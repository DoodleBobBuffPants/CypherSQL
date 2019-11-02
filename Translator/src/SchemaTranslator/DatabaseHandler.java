package SchemaTranslator;

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
	
	public DatabaseHandler(Stack<Create> createStack, Map<String, Map<String, Object>> labelTables, Map<String, Map<String, Object>> typeTables) {
		this.createStack = createStack;
		this.labelTables = labelTables;
		this.typeTables = typeTables;
	}
	
	public void createPostgresDB() {
		makeNewPostgresDB();
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, "postgres", "admin");
			Statement createTables = connection.createStatement();
			
			String makeNodeQuery = makeNodeTable();
			String makeEdgeQuery = makeEdgeTable();
			List<String> makeLabelQueries = makeLabelTables();
			List<String> makeTypeQueries = makeTypeTables();
			
			createTables.execute(makeNodeQuery);
			createTables.execute(makeEdgeQuery);
			for (String query: makeLabelQueries) {
				createTables.execute(query);
			}
			for (String query: makeTypeQueries) {
				createTables.execute(query);
			}
			
			for (Create dbItem: createStack) {
				List<String> queries;
				if (dbItem instanceof CreateNode) {
					queries = fillNodeQueries((CreateNode) dbItem);
				} else {
					queries = fillEdgeQueries((CreateEdge) dbItem);
				}
				for (String query: queries) {
					createTables.execute(query);
				}
			}
			
			connection.close();
		} catch (SQLException e) {
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
				+ "NodeID text PRIMARY KEY,"
				+ "Labels text[])";
	}
	
	private String makeEdgeTable() {
		return "CREATE TABLE Edges("
				+ "NodeSrcID text,"
				+ "NodeTrgtID text,"
				+ "Type text,"
				+ "PRIMARY KEY (NodeSrcID, NodeTrgtID, Type))";
	}
	
	private List<String> makeLabelTables() {
		List<String> labelQueries = new ArrayList<String>();
		for (String tableName: labelTables.keySet()) {
			Map<String, Object> columns = labelTables.get(tableName);
			String query = "CREATE TABLE " + tableName + "("
					+ "NodeID text PRIMARY KEY";
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
			String query = "CREATE TABLE " + tableName + "("
					+ "NodeSrcID text,"
					+ "NodeTrgtID text";
			query = addTableColumns(columns, query);
			query = query + ",PRIMARY KEY (NodeSrcID, NodeTrgtID))";
			typeQueries.add(query);
		}
		return typeQueries;
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
			query = query + "," + columnName + " " + type;
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
				+ "VALUES ('" + createNode.getId() + "', '" + formatQueryStringList(createNode.getLabelList()) + "')");
		
		if (createNode.getColumnValueMap().size() == 0) {
			for (String labelTable: createNode.getLabelList()) {
				String insert = "INSERT INTO " + labelTable + "(NodeID";
				String values = "VALUES ('" + createNode.getId() + "'";
				
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
			String insert = "INSERT INTO " + labelTable + "(NodeID";
			String values = "VALUES ('" + createNode.getId() + "'";
			fillInsertQuery(createNode, queries, insert, values);
		}
		return queries;
	}
	
	private List<String> fillEdgeQueries(CreateEdge createEdge) {
		List<String> queries = new ArrayList<String>();
		queries.add("INSERT INTO Edges(NodeSrcID, NodeTrgtID, Type)"
				+ "VALUES ('" + createEdge.getSourceID() + "', '" + createEdge.getTargetID() + "', '" + createEdge.getType() + "')");
		
		if (createEdge.getColumnValueMap().size() == 0) {
			String typeTable = createEdge.getType();
			String insert = "INSERT INTO " + typeTable + "(NodeSrcID,NodeTrgtID";
			String values = "VALUES ('" + createEdge.getSourceID() + "','" + createEdge.getTargetID() + "'";
			
			for (String column: typeTables.get(typeTable).keySet()) {
				insert = insert + "," + column;
				values = values + ",NULL";
			}
			
			insert = insert + ")";
			values = values + ")";
			queries.add(insert + values);
		} else {
			String typeTable = createEdge.getType();
			String insert = "INSERT INTO " + typeTable + "(NodeSrcID,NodeTrgtID";
			String values = "VALUES ('" + createEdge.getSourceID() + "','" + createEdge.getTargetID() + "'";
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
				values = values + ",'" + value.toString() + "'";
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