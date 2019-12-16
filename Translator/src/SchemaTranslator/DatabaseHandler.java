package SchemaTranslator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import SchemaAST.Create;
import SchemaAST.CreateEdge;
import SchemaAST.CreateNode;

public class DatabaseHandler {
	private String dbName;
	private Stack<Create> createStack;
	private Map<String, Map<String, Object>> labelTables;
	private Map<String, Map<String, Object>> typeTables;
	
	public DatabaseHandler(String dbName, Stack<Create> createStack, Map<String, Map<String, Object>> labelTables, Map<String, Map<String, Object>> typeTables) {
		this.dbName = dbName;
		this.createStack = createStack;
		this.labelTables = labelTables;
		this.typeTables = typeTables;
	}
	
	public void createPostgresDB() {
		makeNewPostgresDB();
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, "postgres", "admin");
			Statement createTables = connection.createStatement();
			BufferedWriter queryLogger = new BufferedWriter(new FileWriter("resources\\" + dbName + "SQL.txt"));
			
			String makeNodeQuery = makeNodeTable();
			String makeEdgeQuery = makeEdgeTable();
			String makeDetailedNodesQuery = makeDetailedNodesTable();
			String makeDetailedEdgesQuery = makeDetailedEdgesTable();
			List<String> makeLabelQueries = makeLabelTables();
			List<String> makeTypeQueries = makeTypeTables();
			List<String> makeASPQueries = makeASPTable();
			
			createTables.execute(makeNodeQuery);
			queryLogger.write(makeNodeQuery);
			queryLogger.newLine();
			createTables.execute(makeEdgeQuery);
			queryLogger.write(makeEdgeQuery);
			queryLogger.newLine();
			createTables.execute(makeDetailedNodesQuery);
			queryLogger.write(makeDetailedNodesQuery);
			queryLogger.newLine();
			createTables.execute(makeDetailedEdgesQuery);
			queryLogger.write(makeDetailedEdgesQuery);
			queryLogger.newLine();
			for (String query: makeLabelQueries) {
				createTables.execute(query);
				queryLogger.write(query);
				queryLogger.newLine();
			}
			for (String query: makeTypeQueries) {
				createTables.execute(query);
				queryLogger.write(query);
				queryLogger.newLine();
			}
			
			for (Create dbItem: createStack) {
				List<String> queries;
				if (dbItem instanceof CreateNode) {
					queries = fillNodeQueries((CreateNode) dbItem);
					queries.addAll(fillDetailedNodesQueries((CreateNode) dbItem));
				} else {
					queries = fillEdgeQueries((CreateEdge) dbItem);
					queries.addAll(fillDetailedEdgesQueries((CreateEdge) dbItem));
				}
				for (String query: queries) {
					createTables.execute(query);
					queryLogger.write(query);
					queryLogger.newLine();
				}
			}
			
			for (String query: makeASPQueries) {
				createTables.execute(query);
				queryLogger.write(query);
				queryLogger.newLine();
			}
			
			connection.close();
			queryLogger.flush();
			queryLogger.close();
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void makeNewPostgresDB() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "admin");
			Statement createDB = connection.createStatement();
			createDB.execute("CREATE DATABASE " + dbName);
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private String makeNodeTable() {
		return "CREATE TABLE Nodes("
				+ "NodeID integer PRIMARY KEY,"
				+ "Labels text[])";
	}
	
	private String makeEdgeTable() {
		return "CREATE TABLE Edges("
				+ "NodeSrcID integer,"
				+ "NodeTrgtID integer,"
				+ "Type text,"
				+ "PRIMARY KEY (NodeSrcID, NodeTrgtID, Type))";
	}
	
	private List<String> makeLabelTables() {
		List<String> labelQueries = new ArrayList<String>();
		for (String tableName: labelTables.keySet()) {
			Map<String, Object> columns = labelTables.get(tableName);
			String query = "CREATE TABLE " + (tableName.equals("Order") ? "\"" + tableName + "\"": tableName) + "("
					+ "NodeID integer PRIMARY KEY";
			query = addTableColumns(columns, query);
			query = query + ")";
			labelQueries.add(query);
		}
		return labelQueries;
	}
	
	private List<String> makeTypeTables() {
		List<String> typeQueries = new ArrayList<String>();
		for (String tableName: typeTables.keySet()) {
			Map<String, Object> columns = typeTables.get(tableName);
			String query = "CREATE TABLE " + (tableName.equals("Order") ? "\"" + tableName + "\"": tableName) + "("
					+ "NodeSrcID integer,"
					+ "NodeTrgtID integer";
			query = addTableColumns(columns, query);
			query = query + ",PRIMARY KEY (NodeSrcID, NodeTrgtID))";
			typeQueries.add(query);
		}
		return typeQueries;
	}
	
	private List<String> makeASPTable() {
		List<String> aspQueries = new ArrayList<String>();
		aspQueries.add("CREATE TEMP TABLE json_nodes AS SELECT json_strip_nulls(row_to_json(detailed_nodes)) AS json_node FROM detailed_nodes");
		aspQueries.add("CREATE INDEX jnIndex ON json_nodes (((json_node->>'nodeid')::int))");
		aspQueries.add("CREATE TEMP TABLE json_edges AS SELECT json_strip_nulls(row_to_json(detailed_edges)) AS json_edge FROM detailed_edges");
		aspQueries.add("CREATE INDEX jeIndex ON json_edges (((json_edge->>'nodesrcid')::int), ((json_edge->>'nodetrgtid')::int))");
		aspQueries.add("CREATE TABLE allshortestpaths AS "
				+ "WITH RECURSIVE asp(path, path_length, edge_type, closure) AS ("
				+ "SELECT ARRAY[json_node], 0, NULL, ARRAY[((json_node->>'nodeid')::int)] FROM json_nodes UNION ALL "
				+ "SELECT path || ARRAY[json_edge, json_node], path_length+1, "
				+ "CASE WHEN edge_type = (json_edge->>'type') OR (edge_type IS NULL AND (json_edge->>'type') IS NULL) THEN edge_type "
				+ "     WHEN edge_type IS NULL AND (json_edge->>'type') IS NOT NULL THEN (json_edge->>'type') ELSE NULL END, "
				+ "closure || ((json_node->>'nodeid')::int) "
				+ "FROM json_nodes, json_edges, asp "
				+ "WHERE ((((json_edge->>'nodesrcid')::int) = ((path[array_length(path, 1)]->>'nodeid')::int) AND ((json_edge->>'nodetrgtid')::int) = ((json_node->>'nodeid')::int)) OR "
				+ "       (((json_edge->>'nodetrgtid')::int) = ((path[array_length(path, 1)]->>'nodeid')::int) AND ((json_edge->>'nodesrcid')::int) = ((json_node->>'nodeid')::int))) AND "
				+ "NOT ((json_node->>'nodeid')::int) = ANY(closure) AND path_length < 5) "
				+ "SELECT path[1] AS source, path[array_length(path,1)] AS target, path, path_length, edge_type FROM asp WHERE path_length > 0");
		aspQueries.add("CREATE INDEX aspIndex ON allshortestpaths (((source->>'nodeid')::int), ((target->>'nodeid')::int))");
		return aspQueries;
	}
	
	private String makeDetailedNodesTable() {
		String query = "CREATE TABLE detailed_nodes("
				+ "nodeid integer PRIMARY KEY,"
				+ "labels text[]";
		for (Map<String, Object> columns: labelTables.values()) {
			query = addTableColumns(columns, query);
		}
		return query + ")";
	}
	
	private String makeDetailedEdgesTable() {
		String query = "CREATE TABLE detailed_edges("
				+ "nodesrcid integer,"
				+ "nodetrgtid integer,"
				+ "type text";
		for (Map<String, Object> columns: typeTables.values()) {
			query = addTableColumns(columns, query);
		}
		return query + ",PRIMARY KEY (nodesrcid, nodetrgtid))";
	}

	private String addTableColumns(Map<String, Object> columns, String query) {
		for (String columnName: columns.keySet()) {
			Object exampleType = columns.get(columnName);
			String type;
			if (exampleType instanceof Integer) {
				type = "integer";
			} else if (exampleType instanceof String) {
				type = "text";
			} else if (exampleType instanceof List<?> && ((List<?>) exampleType).get(0) instanceof Integer) {
				type = "integer[]";
			} else {
				type = "text[]";
			}
			query += "," + columnName + " " + type;
		}
		return query;
	}
	
	private String formatQueryIntList(List<Integer> intList) {
		String result = "{";
		for (Integer item: intList) {
			result = result + item + ",";
		}
		result = result.substring(0, result.length() - 1);
		result = result + "}";
		return result;
	}
	
	private String formatQueryStringList(List<String> stringList) {
		String result = "{";
		for (String item: stringList) {
			result = result + "\"" + item + "\"" + ",";
		}
		result = result.substring(0, result.length() - 1);
		result = result + "}";
		return result;
	}
	
	private List<String> fillNodeQueries(CreateNode createNode) {
		List<String> queries = new ArrayList<String>();
		queries.add("INSERT INTO Nodes(NodeID, Labels)"
				+ "VALUES (" + createNode.getId() + ", '" + formatQueryStringList(createNode.getLabelList()) + "')");
		
		if (createNode.getColumnValueMap().size() == 0) {
			for (String labelTable: createNode.getLabelList()) {
				String insert = "INSERT INTO " + (labelTable.equals("Order") ? "\"" + labelTable + "\"": labelTable) + "(NodeID";
				String values = "VALUES (" + createNode.getId();
				
				for (String column: labelTables.get(labelTable).keySet()) {
					insert = insert + "," + column;
					values = values + ",NULL";
				}
				
				insert = insert + ")";
				values = values + ")";
				queries.add(insert + values);
			}
		} else {
			String labelTable = createNode.getLabelList().get(0);
			String insert = "INSERT INTO " + (labelTable.equals("Order") ? "\"" + labelTable + "\"": labelTable) + "(NodeID";
			String values = "VALUES (" + createNode.getId();
			fillInsertQuery(createNode, queries, insert, values);
		}
		return queries;
	}
	
	private List<String> fillEdgeQueries(CreateEdge createEdge) {
		List<String> queries = new ArrayList<String>();
		queries.add("INSERT INTO Edges(NodeSrcID, NodeTrgtID, Type)"
				+ "VALUES (" + createEdge.getSourceID() + ", " + createEdge.getTargetID() + ", '" + createEdge.getType() + "')");
		
		if (createEdge.getColumnValueMap().size() == 0) {
			String typeTable = createEdge.getType();
			String insert = "INSERT INTO " + (typeTable.equals("Order") ? "\"" + typeTable + "\"": typeTable) + "(NodeSrcID,NodeTrgtID";
			String values = "VALUES (" + createEdge.getSourceID() + "," + createEdge.getTargetID();
			
			for (String column: typeTables.get(typeTable).keySet()) {
				insert = insert + "," + column;
				values = values + ",NULL";
			}
			
			insert = insert + ")";
			values = values + ")";
			queries.add(insert + values);
		} else {
			String typeTable = createEdge.getType();
			String insert = "INSERT INTO " + (typeTable.equals("Order") ? "\"" + typeTable + "\"": typeTable) + "(NodeSrcID,NodeTrgtID";
			String values = "VALUES (" + createEdge.getSourceID() + "," + createEdge.getTargetID();
			fillInsertQuery(createEdge, queries, insert, values);
		}
		return queries;
	}
	
	private List<String> fillDetailedNodesQueries(CreateNode createNode) {
		List<String> queries = new ArrayList<String>();
		String insert = "INSERT INTO detailed_nodes(nodeid, labels";
		String values = "VALUES (" + createNode.getId() + ", '" + formatQueryStringList(createNode.getLabelList()) + "'";
		if (createNode.getColumnValueMap().size() != 0) {
			fillInsertQuery(createNode, queries, insert, values);
		}
		return queries;
	}
	
	private List<String> fillDetailedEdgesQueries(CreateEdge createEdge) {
		List<String> queries = new ArrayList<String>();
		String insert = "INSERT INTO detailed_edges(nodesrcid, nodetrgtid, type";
		String values = "VALUES (" + createEdge.getSourceID() + ", " + createEdge.getTargetID() + ", '" + createEdge.getType() + "'";
		if (createEdge.getColumnValueMap().size() != 0) {
			fillInsertQuery(createEdge, queries, insert, values);
		}
		return queries;
	}
	
	@SuppressWarnings("unchecked")
	private void fillInsertQuery(Create create, List<String> queries, String insert, String values) {
		Map<String, Object> columnValueMap = create.getColumnValueMap();
		for (String column: columnValueMap.keySet()) {
			Object value = columnValueMap.get(column);
			insert = insert + "," + column;
			if (value instanceof Integer) {
				values = values + "," + ((Integer) value);
			} else if (value instanceof String) {
				if (values.toString().equals("NULL")) {
					values = values + ",NULL";
				} else {
					values = values + ",'" + value.toString() + "'";
				}
			} else if (value instanceof List<?> && ((List<?>) value).get(0) instanceof Integer) {
				values = values + ",'" + formatQueryIntList((List<Integer>)value) + "'";
			} else {
				values = values + ",'" + formatQueryStringList((List<String>)value) + "'";;
			}
		}
		insert = insert + ")";
		values = values + ")";
		queries.add(insert + values);
	}
}