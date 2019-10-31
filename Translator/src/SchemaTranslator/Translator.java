package SchemaTranslator;

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
import java.util.List;

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
	String neo4jDBPath;
	String neo4jDumpFilePath;
	
	public Translator(String neo4jDBPath) {
		this.neo4jDBPath = neo4jDBPath;
		this.neo4jDumpFilePath = neo4jDBPath + "dump.txt";
	}
	
	public Translator(Path createFilePath) {
		this.neo4jDumpFilePath = createFilePath.toString();
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
			
			createListener.getCreateStack().forEach(e -> printCreate(e));
			createListener.getLabelTables().forEach((k, v) -> System.out.println(k + ": " + v));
			createListener.getTypeTables().forEach((k, v) -> System.out.println(k + ": " + v));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
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
	
	public static void connectPostgres() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "admin");
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}