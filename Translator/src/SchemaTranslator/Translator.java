package SchemaTranslator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import SchemaAST.Create;
import antlr4.CypherLexer;
import antlr4.CypherParser;

public class Translator {
	private Path createFilePath;
	private String dbName;
	
	private Stack<Create> createStack;
	private Map<String, Map<String, Object>> labelTables;
	private Map<String, Map<String, Object>> typeTables;
	
	public Translator(String createFilePath) {
		this.createFilePath = Paths.get(createFilePath.toString());
		this.dbName = new File(createFilePath).getName();
		this.dbName = this.dbName.substring(0, dbName.indexOf("."));
	}
	
	public Stack<Create> getCreateStack() {
		return createStack;
	}

	public Map<String, Map<String, Object>> getLabelTables() {
		return new HashMap<String, Map<String, Object>>(labelTables);
	}

	public Map<String, Map<String, Object>> getTypeTables() {
		return new HashMap<String, Map<String, Object>>(typeTables);
	}
	
	public void createAST() {
		try {
			List<String> dumpFileContents = Files.readAllLines(createFilePath);
			
			ParseTreeWalker treeWalker = new ParseTreeWalker();
			CreateListener createListener = new CreateListener();
			
			for (String statement: dumpFileContents) {
				CharStream statementStream = CharStreams.fromString(statement);
				CypherLexer inputLexer = new CypherLexer(statementStream);
				CommonTokenStream tokens = new CommonTokenStream(inputLexer);
				CypherParser inputParser = new CypherParser(tokens);
				
				ParseTree parseTree = inputParser.oC_Cypher();
				treeWalker.walk(createListener, parseTree);
			}
			
			createStack = createListener.getCreateStack();
			labelTables = createListener.getLabelTables();
			typeTables = createListener.getTypeTables();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
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
				+ "PRIMARY KEY (NodeSrcID, NodeTrgtID))";
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
}