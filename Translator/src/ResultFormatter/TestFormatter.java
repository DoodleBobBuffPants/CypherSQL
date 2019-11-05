package ResultFormatter;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFormatter {
	@Test
	public void testCompareLabelsGraph() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (n) RETURN labels(n) AS labels, count(*) AS count";
		String postgresQuery = "SELECT labels, count(*) FROM nodes GROUP BY labels";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db", neo4jQuery);
		formatter.getPostgresResult("graph", postgresQuery);
		formatter.printPostgresResult();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareNodeGraph() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (n:Movie) WHERE ID(n) = 0 RETURN n.title AS title";
		String postgresQuery = "SELECT title FROM movie WHERE nodeid = '_0'";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db", neo4jQuery);
		formatter.getPostgresResult("graph", postgresQuery);
		formatter.printPostgresResult();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareEdgeGraph() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (m)-[r:ACTED_IN]->(n) WHERE ID(m) = 24 AND ID(n) = 141 RETURN r.roles AS roles";
		String postgresQuery = "SELECT roles FROM ACTED_IN WHERE nodesrcid = '_24' AND nodetrgtid = '_141'";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db", neo4jQuery);
		formatter.getPostgresResult("graph", postgresQuery);
		formatter.printPostgresResult();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareLabelsNorthwind() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (n) RETURN labels(n) AS labels, count(*) AS count";
		String postgresQuery = "SELECT labels, count(*) FROM nodes GROUP BY labels";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\northwind.db", neo4jQuery);
		formatter.getPostgresResult("northwind", postgresQuery);
		formatter.printPostgresResult();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareNodeNorthwind() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (n:Product) WHERE ID(n) = 0 RETURN n.productName AS productname";
		String postgresQuery = "SELECT productname FROM product WHERE nodeid = '_0'";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\northwind.db", neo4jQuery);
		formatter.getPostgresResult("northwind", postgresQuery);
		formatter.printPostgresResult();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareEdgeNorthwind() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (m)-[r:ORDERS]->(n) WHERE ID(m) = 205 AND ID(n) = 41 RETURN r.quantity AS quantity";
		String postgresQuery = "SELECT quantity FROM ORDERS WHERE nodesrcid = '_205' AND nodetrgtid = '_41'";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\northwind.db", neo4jQuery);
		formatter.getPostgresResult("northwind", postgresQuery);
		formatter.printPostgresResult();
		
		assertTrue(formatter.compare());
	}
}