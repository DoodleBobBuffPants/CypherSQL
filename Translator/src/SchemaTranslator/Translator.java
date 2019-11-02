package SchemaTranslator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	public void translate() {
		createAST();
		DatabaseHandler dbHandler = new DatabaseHandler(dbName, createStack, labelTables, typeTables);
		dbHandler.createPostgresDB();
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
}