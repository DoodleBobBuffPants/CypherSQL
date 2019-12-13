package ResultFormatter;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFormatterNorthwind {
	@Test
	public void testCompareLabels() {
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
	public void testCompareNode() {
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
	public void testCompareEdge() {
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
}