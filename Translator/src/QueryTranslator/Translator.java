package QueryTranslator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr4.CypherLexer;
import antlr4.CypherParser;

public class Translator {
	private String cypherQuery;
	private GeneratePostgresQuery genPostgresQuery;
	
	public Translator(String cypherQuery) {
		this.cypherQuery = cypherQuery;
		genPostgresQuery = new GeneratePostgresQuery();
	}
	
	public Translator(Path queryPath) {
		try {
			this.cypherQuery = new String(Files.readAllBytes(queryPath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		genPostgresQuery = new GeneratePostgresQuery();
	}
	
	public String getCypherQuery() {
		return cypherQuery;
	}

	public String getTranslatedQuery() {
		return genPostgresQuery.getTranslatedQuery();
	}
	
	public String translate() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		QueryListener queryListener = new QueryListener();
		
		CharStream queryStream = CharStreams.fromString(cypherQuery);
		CypherLexer inputLexer = new CypherLexer(queryStream);
		CommonTokenStream tokens = new CommonTokenStream(inputLexer);
		CypherParser inputParser = new CypherParser(tokens);
		
		ParseTree parseTree = inputParser.oC_Cypher();
		treeWalker.walk(queryListener, parseTree);

		return genPostgresQuery.generatePostgresQuery(queryListener.getQuery());
	}
}