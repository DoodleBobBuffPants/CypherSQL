package QueryTranslator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr4.CypherLexer;
import antlr4.CypherParser;

public class Translator {
	public static void main(String[] args) throws IOException {
		String neo4jDumpFilePath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.dbdump.txt";
		List<String> dumpFileContents = Files.readAllLines(Paths.get(neo4jDumpFilePath));
		String firstCreateStatement = dumpFileContents.get(0);
		
		CharStream fcsStream = CharStreams.fromString(firstCreateStatement);
		CypherLexer inputLexer = new CypherLexer(fcsStream);
		CommonTokenStream tokens = new CommonTokenStream(inputLexer);
		CypherParser inputParser = new CypherParser(tokens);
		
		ParseTree parseTree = inputParser.oC_Cypher();
		Trees.inspect(parseTree, inputParser);
		
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		CreateListener createListener = new CreateListener();
		treeWalker.walk(createListener, parseTree);
		
		createListener.getCreateStack().forEach(n -> {printCreate(n); System.out.println();});
	}
	
	public static void printCreate(Create create) {
		if (create instanceof CreateNode) {
			printCreateNode((CreateNode) create);
		} else {
			printCreateEdge((CreateEdge) create);
		}
	}
	
	public static void printCreateNode(CreateNode createNode) {
		System.out.println("id: " + createNode.getId());
		System.out.println("labels: " + createNode.getLabelList());
		createNode.getColumnValueMap().forEach((k, v) -> System.out.println(k + ": " + v));
	}
	
	public static void printCreateEdge(CreateEdge createEdge) {
		System.out.println("Not yet implemented");
	}
}