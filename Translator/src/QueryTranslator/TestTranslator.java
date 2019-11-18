package QueryTranslator;

import static org.junit.Assert.*;

import org.junit.Test;

import ResultFormatter.Formatter;

public class TestTranslator {
	@Test
	public void testMatchNode() {
		Translator queryTranslator = new Translator("MATCH (n) RETURN labels(n) AS labels, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchNodeWithLabel() {
		Translator queryTranslator = new Translator("MATCH (n:Movie) RETURN labels(n) AS labels, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchEdgeWithNodes() {
		Translator queryTranslator = new Translator("MATCH (m)-[r:ACTED_IN]->(n) RETURN labels(m) AS srclabels");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testEdgeTypes() {
		Translator queryTranslator = new Translator("MATCH ()-[r]->() RETURN type(r) AS type, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testWhereClause() {
		Translator queryTranslator = new Translator("MATCH (m)-[r:ACTED_IN]->(n) WHERE ID(m) = 34 AND ID(n) = 78 RETURN r.roles AS roles");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testOrderByLimit() {
		Translator queryTranslator = new Translator("MATCH (n:Movie) RETURN n.title AS title, n.released AS released ORDER BY n.released DESC, n.title LIMIT 5");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testDistinct() {
		Translator queryTranslator = new Translator("MATCH (n) RETURN DISTINCT labels(n) AS labels");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testCountDistinct() {
		Translator queryTranslator = new Translator("MATCH (n) RETURN count(DISTINCT labels(n)) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchAnyPattern() {
		Translator queryTranslator = new Translator("MATCH (n:Movie)<-[r:DIRECTED]-(p:Person)-[s:WROTE]->(n:Movie) WHERE ID(p) = 5 AND ID(n) = 121 RETURN p.name AS name, n.title AS title");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchCSV() {
		Translator queryTranslator = new Translator("MATCH (n:Movie), (p:Person) WHERE ID(n) = 0 AND ID(p) = 5 RETURN p.name AS name, n.title AS title");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("tests\\graph.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("graph", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		assertTrue(resultFormatter.compare());
	}
}