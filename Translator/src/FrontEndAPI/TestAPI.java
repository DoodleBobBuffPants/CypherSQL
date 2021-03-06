package FrontEndAPI;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TestAPI {
	@Test
	public void testNoArguments() {
		API.main(new String[] {});
		
		assertTrue(true);
	}
	
	@Test
	public void testGraphDB() {
		String neo4jDBPath = "resources\\graph.db";
		String[] args = {"--graphdb", neo4jDBPath};
		
		API.main(args);
		
		File dumpFilePath = new File(neo4jDBPath + "dump.txt");
		assertTrue(dumpFilePath.exists());
	}

	@Test
	public void testSchema() {
		String neo4jDumpFilePath = "resources\\graph.dbdump.txt";
		String[] args = {"--schema", neo4jDumpFilePath};
		
		API.main(args);
		
		assertTrue(true);
	}
	
	@Test
	public void testQueryString() {
		String[] args = {"--query", "graph", "MATCH (n) RETURN labels(n) AS labels, count(*) AS count"};
		
		API.main(args);
		
		assertTrue(true);
	}
	
	@Test
	public void testQueryPath() {
		String[] args = {"--query", "graph", "resources\\query.txt"};
		
		API.main(args);
		
		assertTrue(true);
	}
}