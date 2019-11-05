package ResultFormatter;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFormatter {
	@Test
	public void testCompareLabels() {
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
	public void testCompareNode() {
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
	public void testCompareEdge() {
		Formatter formatter = new Formatter();
		String neo4jQuery = "MATCH (m)-[r:ACTED_IN]->(n) WHERE ID(m) = 24 AND ID(n) = 141 RETURN r.roles AS roles";
		String postgresQuery = "SELECT roles FROM ACTED_IN WHERE nodesrcid = '_24' AND nodetrgtid = '_141'";
		
		formatter.initialiseResultSets();
		formatter.getNeo4JResult("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db", neo4jQuery);
		formatter.getPostgresResult("graph", postgresQuery);
		formatter.printPostgresResult();
		
		assertTrue(formatter.compare());
	}
}