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

import QueryAST.NodePattern;
import QueryAST.Query;
import QueryAST.ReturnItem;
import antlr4.CypherLexer;
import antlr4.CypherParser;

public class Translator {
	private String cypherQuery;
	private String translatedQuery;
	private Query parsedQuery;
	private String select = " ";
	private String from = ",";
	private String innerJoin = "";
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
		translatedQuery = "SELECT" + select.substring(0, select.length() - 1) + " FROM " + from.substring(1, from.length() - 1);
		if (!innerJoin.equals("")) {
			translatedQuery += " INNER JOIN " + innerJoin;
		}
		if (!where.equals("")) {
			translatedQuery += " WHERE " + where;
		}
		if (!groupBy.equals("")) {
			translatedQuery += " GROUP BY " + groupBy.substring(0, groupBy.length() - 1);
		}
		return translatedQuery;
	}
	
	private String uniqueStringConcat(String target, String concat) {
		if (target.contains("," + concat + ",")) return target;
		return target + concat + ",";
	}
	
	private void handleQueryMatch() {
		if (parsedQuery.getMatchClause().getPattern() instanceof NodePattern) {
			NodePattern node = (NodePattern) parsedQuery.getMatchClause().getPattern();
			if (node.getLabel() == null) {
				from = from + "nodes,";
			} else {
				from = from + node.getLabel().toLowerCase() + ",";
			}
		}
	}
	
	private void handleQueryReturn() {
		for (ReturnItem returnItem: parsedQuery.getReturnClause().getReturnItems()) {
			if (returnItem.getFunctionName() != null) {
				if (returnItem.getFunctionName().toLowerCase().equals("labels")) {
					select = select + "labels";
					from = uniqueStringConcat(from, "nodes");
					//TODO: Possible joining required for function argument
				}
			} else if (returnItem.getToReturn().toLowerCase().startsWith("count(")) {
				String countField = returnItem.getToReturn().substring(returnItem.getToReturn().indexOf("(") + 1, returnItem.getToReturn().indexOf(")"));
				for (String field: select.split(",")) {
					String fieldWithoutAlias = field.split("AS")[0].trim();
					if (!fieldWithoutAlias.equals(countField)) {
						groupBy = groupBy + fieldWithoutAlias + ",";
					}
				}
				select = select + returnItem.getToReturn();
			} else {
				select = select + returnItem.getToReturn();
			}
			
			if (returnItem.getAlias() != null) {
				if (!select.endsWith(" " + returnItem.getAlias())) {
					select = select + " AS " + returnItem.getAlias();
				}
			}
			select = select + ",";
		}
	}
}