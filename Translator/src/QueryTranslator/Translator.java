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
	private String query;
	
	public static void main(String[] args) {
		Translator queryTranslator = new Translator("MATCH (n) RETURN labels(n) AS labels, count(*) AS count");
		queryTranslator.translate();
	}
	
	public Translator(String query) {
		this.query = query;
	}
	
	public Translator(Path queryPath) {
		try {
			this.query = new String(Files.readAllBytes(queryPath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void translate() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		QueryListener queryListener = new QueryListener();
		
		CharStream queryStream = CharStreams.fromString(query);
		CypherLexer inputLexer = new CypherLexer(queryStream);
		CommonTokenStream tokens = new CommonTokenStream(inputLexer);
		CypherParser inputParser = new CypherParser(tokens);
		
		ParseTree parseTree = inputParser.oC_Cypher();
		Trees.inspect(parseTree, inputParser);
		treeWalker.walk(queryListener, parseTree);
		
		Query parsedQuery = queryListener.getQuery();
		generatePostgresQuery(parsedQuery);
	}
	
	private String generatePostgresQuery(Query parsedQuery) {
		return "";
	}
}