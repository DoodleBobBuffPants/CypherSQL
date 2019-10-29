package QueryTranslator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

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
		
		tokens.fill();
		System.out.println(tokens.getText());
		
		CypherParser parser = new CypherParser(tokens);
		Trees.inspect(parser.oC_Cypher(), parser);
	}
}