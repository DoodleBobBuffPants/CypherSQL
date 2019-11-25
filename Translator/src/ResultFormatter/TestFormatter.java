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
		formatter.getNeo4JResult("resources\\graph.db", neo4jQuery);
		formatter.getPostgresResult("graph", postgresQuery);
		
		formatter.printNeo4JResult();
		System.out.println();
		formatter.printPostgresResult();
		System.out.println();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareNodeGraph() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (n:Movie) WHERE ID(n) = 0 RETURN n.title AS title";
		String postgresQuery = "SELECT title FROM movie WHERE nodeid = 0";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("resources\\graph.db", neo4jQuery);
		formatter.getPostgresResult("graph", postgresQuery);
		
		formatter.printNeo4JResult();
		System.out.println();
		formatter.printPostgresResult();
		System.out.println();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareEdgeGraph() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (m)-[r:ACTED_IN]->(n) WHERE ID(m) = 34 AND ID(n) = 78 RETURN r.roles AS roles";
		String postgresQuery = "SELECT roles FROM ACTED_IN WHERE nodesrcid = 34 AND nodetrgtid = 78";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("resources\\graph.db", neo4jQuery);
		formatter.getPostgresResult("graph", postgresQuery);
		
		formatter.printNeo4JResult();
		System.out.println();
		formatter.printPostgresResult();
		System.out.println();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareLabelsNorthwind() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (n) RETURN labels(n) AS labels, count(*) AS count";
		String postgresQuery = "SELECT labels, count(*) FROM nodes GROUP BY labels";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("resources\\northwind.db", neo4jQuery);
		formatter.getPostgresResult("northwind", postgresQuery);
		
		formatter.printNeo4JResult();
		System.out.println();
		formatter.printPostgresResult();
		System.out.println();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareNodeNorthwind() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (n:Product) WHERE ID(n) = 0 RETURN n.productName AS productname";
		String postgresQuery = "SELECT productname FROM product WHERE nodeid = 0";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("resources\\northwind.db", neo4jQuery);
		formatter.getPostgresResult("northwind", postgresQuery);
		
		formatter.printNeo4JResult();
		System.out.println();
		formatter.printPostgresResult();
		System.out.println();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareEdgeNorthwind() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (m)-[r:ORDERS]->(n) WHERE ID(m) = 205 AND ID(n) = 41 RETURN r.quantity AS quantity";
		String postgresQuery = "SELECT quantity FROM ORDERS WHERE nodesrcid = 205 AND nodetrgtid = 41";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("resources\\northwind.db", neo4jQuery);
		formatter.getPostgresResult("northwind", postgresQuery);
		
		formatter.printNeo4JResult();
		System.out.println();
		formatter.printPostgresResult();
		System.out.println();
		
		assertTrue(formatter.compare());
	}
	
	@Test
	public void testCompareStarGraph() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (p:Person)-[:ACTED_IN*2]-(q:Person) WHERE ID(p) = 1 RETURN q.name AS name";
		String postgresQuery = "WITH RECURSIVE rec_match(nodeid, depth) AS ("
				+ "SELECT nodeid, 2 FROM person WHERE person.nodeid = 1 UNION ALL "
				+ "SELECT nodes.nodeid, depth-1 FROM nodes, rec_match, acted_in "
				+ "WHERE ((acted_in.nodesrcid = rec_match.nodeid AND acted_in.nodetrgtid = nodes.nodeid) OR "
				+ "(acted_in.nodetrgtid = rec_match.nodeid AND acted_in.nodesrcid = nodes.nodeid)) AND depth > 0) "
				+ "SELECT person.name AS name FROM rec_match, person WHERE rec_match.depth = 0 AND person.nodeid = rec_match.nodeid AND NOT person.nodeid = 1";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("resources\\graph.db", neo4jQuery);
		formatter.getPostgresResult("graph", postgresQuery);
		
		formatter.printNeo4JResult();
		System.out.println();
		formatter.printPostgresResult();
		System.out.println();
		
		assertTrue(formatter.compare());
	}
}