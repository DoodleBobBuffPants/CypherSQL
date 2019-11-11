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
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testSimpleMatchWithLabel() {
		Translator queryTranslator = new Translator("MATCH (n:Movie) RETURN labels(n) AS labels, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testSimpleMatchEdge() {
		Translator queryTranslator = new Translator("MATCH (m)-[r:ACTED_IN]->(n) RETURN labels(m) AS srclabels");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
}