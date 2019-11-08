package QueryTranslator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr4.CypherLexer;
import antlr4.CypherParser;

public class Translator {
	private String cypherQuery;
	
	
	public static void main(String[] args) {
		Translator queryTranslator = new Translator("MATCH (n) RETURN labels(n) AS labels, count(*) AS count");
		System.out.println(queryTranslator.translate());
	}
	
	public String getCypherQuery() {
		return cypherQuery;
	}

	public Translator(String cypherQuery) {
		this.cypherQuery = cypherQuery;
	}
	
	public Translator(Path queryPath) {
		try {
			this.cypherQuery = new String(Files.readAllBytes(queryPath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String translate() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		QueryListener queryListener = new QueryListener();
		
		CharStream queryStream = CharStreams.fromString(cypherQuery);
		CypherLexer inputLexer = new CypherLexer(queryStream);
		CommonTokenStream tokens = new CommonTokenStream(inputLexer);
		CypherParser inputParser = new CypherParser(tokens);
		
		ParseTree parseTree = inputParser.oC_Cypher();
		//Trees.inspect(parseTree, inputParser);
		treeWalker.walk(queryListener, parseTree);
		
		GeneratePostgresQuery genPostgresQuery = new GeneratePostgresQuery();
		return genPostgresQuery.generatePostgresQuery(queryListener.getQuery());
	}
}