package QueryTranslator;

import static org.junit.Assert.*;

import org.junit.Test;

import ResultFormatter.Formatter;

public class TestTranslatorNorthwind {
	@Test
	public void testMatchNode() {
		Translator queryTranslator = new Translator("MATCH (n) RETURN labels(n) AS labels, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchNodeWithLabel() {
		Translator queryTranslator = new Translator("MATCH (n:Customer) RETURN labels(n) AS labels, count(*) AS count");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchEdge() {
		Translator queryTranslator = new Translator("MATCH (m)-[r:PURCHASED]->(n) RETURN labels(m) AS srclabels");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
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
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testWhere() {
		Translator queryTranslator = new Translator("MATCH (m)-[r:ORDERS]->(n) WHERE ID(m) = 205 AND ID(n) = 10 RETURN r.quantity AS quantity");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testOrderByLimit() {
		Translator queryTranslator = new Translator("MATCH (n:Customer) RETURN n.country AS country, n.contactName AS contactname ORDER BY n.country, n.contactname LIMIT 5");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
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
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
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
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchAnyPattern() {
		Translator queryTranslator = new Translator("MATCH (n:Product)<-[r:ORDERS]-(p)-[s:ORDERS]->(m:Product) WHERE ID(p) = 205 AND ID(n) <> ID(m) RETURN n.productName AS productname1, m.productName AS productname2");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testMatchCSV() {
		Translator queryTranslator = new Translator("MATCH (n:Product), (p:Customer) WHERE ID(n) = 10 AND ID(p) = 140 RETURN p.contactName AS contactname, n.productName AS productname");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testWith() {
		Translator queryTranslator = new Translator("MATCH (n:Product)<-[r:ORDERS]-(p)-[s:ORDERS]->(m:Product) WHERE ID(p) = 205 AND ID(n) <> ID(m) WITH n.productName AS productname, count(*) AS total WHERE total > 10 RETURN productname, total");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testUndirectedEdge() {
		Translator queryTranslator = new Translator("MATCH (p:Order)-[:ORDERS]-(m:Product) WHERE ID(p) = 205 RETURN m.productName AS productname");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testStarOperator() {
		Translator queryTranslator = new Translator("MATCH (p:Product)-[r:ORDERS*2]-(q:Product) WHERE ID(p) = 0 RETURN q.productName AS productname");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testAllShortestPaths() {
		Translator queryTranslator = new Translator("MATCH path = allshortestpaths((p:Product)-[:ORDERS*]-(q:Product)) WHERE ID(p) = 0 AND ID(q) = 52 RETURN length(path)");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		//resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		//assertTrue(resultFormatter.compare());
	}
	
	@Test
	public void testASPWithJSON() {
		Translator queryTranslator = new Translator("MATCH path = allshortestpaths((p:Product)-[:ORDERS*]-(q:Product)) WHERE p.productName = 'Chai' AND q.productName = 'Perth Pasties' RETURN length(path)");
		Formatter resultFormatter = new Formatter();
		
		resultFormatter.initialiseResultSets();
		//resultFormatter.getNeo4JResult("resources\\northwind.db", queryTranslator.getCypherQuery());
		long startTime = System.currentTimeMillis();
		resultFormatter.getPostgresResult("northwind", queryTranslator.translate());
		System.out.println("Postgres translation and execution time: " + (System.currentTimeMillis() - startTime));
		
		System.out.println(queryTranslator.getCypherQuery());
		System.out.println(queryTranslator.getTranslatedQuery());
		System.out.println();
		//assertTrue(resultFormatter.compare());
	}
}