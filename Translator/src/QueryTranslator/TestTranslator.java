package QueryTranslator;

import static org.junit.Assert.*;

import org.junit.Test;

import ResultFormatter.Formatter;

public class TestTranslator {
	@Test
	public void testSimpleMatch() {
		Translator queryTranslator = new Translator("MATCH (n) RETURN labels(n) AS labels, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db", queryTranslator.getCypherQuery());
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testSimpleMatchWithLabel() {
		Translator queryTranslator = new Translator("MATCH (n:Movie) RETURN labels(n) AS labels, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db", queryTranslator.getCypherQuery());
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		
		assertTrue(resultFormatter.compare());
	}
}