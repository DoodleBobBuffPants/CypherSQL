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
		String firstCreate = dumpFileContents.get(0);
		
		CharStream stringStream = CharStreams.fromString(firstCreate);
		CypherLexer lexer = new CypherLexer(stringStream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CypherParser parser = new CypherParser(tokens);
		ParseTree tree = parser.oC_Cypher();
		//Trees.inspect(tree, parser);
		ParseTreeWalker walker = new ParseTreeWalker();
		SchemaListener listener = new SchemaListener();
		walker.walk(listener, tree);
		
		CreateNode createNode = listener.getCreateNode();
		printCreateNode(createNode);
	}
	
	public static void printCreateNode(CreateNode createNode) {
		System.out.println("id: " + createNode.getId());
		System.out.println("label: " + createNode.getLabel());
		createNode.getColumnValues().forEach((k, v) -> System.out.println(k + ": " + v));
	}
}