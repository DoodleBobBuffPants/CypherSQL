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

import QueryAST.Query;
import antlr4.CypherLexer;
import antlr4.CypherParser;

public class Translator {
	private String cypherQuery;
	private String translatedQuery;
	private Query parsedQuery;
	private String select = "";
	private String from = "";
	private String where = "";
	private String groupBy = "";
	
	public static void main(String[] args) {
		Translator queryTranslator = new Translator("MATCH (n) RETURN labels(n) AS labels, count(*) AS count");
		System.out.println(queryTranslator.translate());
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
		Trees.inspect(parseTree, inputParser);
		treeWalker.walk(queryListener, parseTree);
		
		parsedQuery = queryListener.getQuery();
		return generatePostgresQuery();
	}
	
	private String generatePostgresQuery() {
		handleQueryMatch();
		handleQueryReturn();
		translatedQuery = "SELECT " + select + " FROM " + from;
		if (!where.equals("")) {
			translatedQuery += " WHERE " + where;
		}
		if (!groupBy.equals("")) {
			translatedQuery += " GROUP BY " + groupBy;
		}
		return translatedQuery;
	}
	
	private void handleQueryMatch() {
		
	}
	
	private void handleQueryReturn() {
		
	}
}