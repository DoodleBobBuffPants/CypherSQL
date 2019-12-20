package QueryTranslator;

import static org.junit.Assert.*;

import org.junit.Test;

import ResultFormatter.Formatter;

public class TestTranslatorGOT {
	@Test
	public void testMatchNode() {
		Translator queryTranslator = new Translator("MATCH (n) RETURN labels(n) AS labels, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchNodeWithLabel() {
		Translator queryTranslator = new Translator("MATCH (n:Character) RETURN labels(n) AS labels, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchEdge() {
		Translator queryTranslator = new Translator("MATCH (m)-[r:INTERACTS]->(n) RETURN labels(m) AS srclabels");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testEdgeWithTypes() {
		Translator queryTranslator = new Translator("MATCH ()-[r]->() RETURN type(r) AS type, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testWhere() {
		Translator queryTranslator = new Translator("MATCH (m)-[r:INTERACTS]->(n) WHERE ID(m) = 325 AND ID(n) = 490 RETURN r.weight AS weight");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testOrderByLimit() {
		Translator queryTranslator = new Translator("MATCH (n:Character) RETURN n.name AS name ORDER BY n.name DESC LIMIT 5");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testDistinct() {
		Translator queryTranslator = new Translator("MATCH (n) RETURN DISTINCT labels(n) AS labels");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testCountDistinct() {
		Translator queryTranslator = new Translator("MATCH (n) RETURN count(DISTINCT labels(n)) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchAnyPattern() {
		Translator queryTranslator = new Translator("MATCH (n:Character)<-[r:INTERACTS]-(p:Character)-[s:INTERACTS]->(m:Character) WHERE ID(p) = 325 AND ID(n) <> ID(m) RETURN n.name AS name1, m.name AS name2");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchCSV() {
		Translator queryTranslator = new Translator("MATCH (n:Character), (p:Character) WHERE ID(n) = 47 AND ID(p) = 325 RETURN p.name AS name1, n.name AS name2");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testWith() {
		Translator queryTranslator = new Translator("MATCH (n:Character)<-[r:INTERACTS]-(p:Character)-[s:INTERACTS]->(m:Character) WHERE ID(n) <> ID(m) WITH p.name AS name, count(*) AS total WHERE total > 10 RETURN name, total");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testUndirectedEdge() {
		Translator queryTranslator = new Translator("MATCH (p:Character)-[:INTERACTS]-(m:Character) WHERE ID(p) = 47 RETURN m.name AS name");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testStarOperator() {
		Translator queryTranslator = new Translator("MATCH (p:Character)-[r:INTERACTS*2]-(q:Character) WHERE ID(p) = 325 RETURN q.name AS name");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testAllShortestPaths() {
		Translator queryTranslator = new Translator("MATCH path = allshortestpaths((p:Character)-[:INTERACTS*]-(q:Character)) WHERE ID(p) = 325 AND ID(q) = 150 RETURN length(path)");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		//resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		//assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testASPWithJSON() {
		Translator queryTranslator = new Translator("MATCH path = allshortestpaths((p:Character)-[:INTERACTS*]-(q:Character)) WHERE p.name = 'Jon-Snow' AND q.name = 'Dareon' RETURN length(path)");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		//resultFormatter.getNeo4JResult("resources\\got.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("got", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		//assertTrue(resultFormatter.compare());
	}
}