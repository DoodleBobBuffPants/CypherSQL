package SchemaTranslator;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.shell.StartClient;

import SchemaAST.Create;
import SchemaAST.CreateEdge;
import SchemaAST.CreateNode;
import antlr4.CypherLexer;
import antlr4.CypherParser;

public class Translator {
	private String neo4jDBPath;
	private String neo4jDumpFilePath;
	private String dbName;
	
	private Stack<Create> createStack;
	private Map<String, Map<String, Object>> labelTables;
	private Map<String, Map<String, Object>> typeTables;
	
	public Translator(String neo4jDBPath) {
		this.neo4jDBPath = neo4jDBPath;
		this.neo4jDumpFilePath = neo4jDBPath + "dump.txt";
		this.dbName = new File(neo4jDBPath).getName();
		dbName = dbName.substring(0, dbName.indexOf("."));
	}
	
	public Translator(Path createFilePath) {
		this.neo4jDumpFilePath = createFilePath.toString();
		this.dbName = new File(neo4jDumpFilePath).getName();
		dbName = dbName.substring(0, dbName.indexOf("."));
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
	
	public void dumpGraphDatabase() {		
		try {
			String[] neo4jDumpArgs = {"-path", neo4jDBPath, "-c", "dump"};
			PrintStream neo4jDumpOut = new PrintStream(neo4jDumpFilePath);
			System.setOut(neo4jDumpOut);
			StartClient.main(neo4jDumpArgs);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			neo4jDumpOut.close();
			cleanDumpFile();
			createAST();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void cleanDumpFile() {
		try {
			List<String> dumpFileContents = Files.readAllLines(Paths.get(neo4jDumpFilePath));
			dumpFileContents.remove(0);
			dumpFileContents.remove(0);
			dumpFileContents.remove(0);
			dumpFileContents.remove(0);
			dumpFileContents.remove(dumpFileContents.size() - 1);
			dumpFileContents.remove(dumpFileContents.size() - 1);
			Files.write(Paths.get(neo4jDumpFilePath), dumpFileContents);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void createAST() {
		try {
			List<String> dumpFileContents = Files.readAllLines(Paths.get(neo4jDumpFilePath));
			
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
			
			makeNewPostgresDB();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void printCreate(Create create) {
		if (create instanceof CreateNode) {
			printCreateNode((CreateNode) create);
		} else {
			printCreateEdge((CreateEdge) create);
		}
		System.out.println();
	}
	
	private void printCreateNode(CreateNode createNode) {
		System.out.println("id: " + createNode.getId());
		System.out.println("labels: " + createNode.getLabelList());
		createNode.getColumnValueMap().forEach((k, v) -> System.out.println(k + ": " + v));
	}
	
	private void printCreateEdge(CreateEdge createEdge) {
		System.out.println("source: " + createEdge.getSourceID());
		System.out.println("target: " + createEdge.getTargetID());
		System.out.println("type: " + createEdge.getType());
		createEdge.getColumnValueMap().forEach((k, v) -> System.out.println(k + ": " + v));
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
}