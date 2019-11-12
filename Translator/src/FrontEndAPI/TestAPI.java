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
		String neo4jDBPath = "tests\\graph.db";
		String[] args = {"--graphdb", neo4jDBPath};
		
		API.main(args);
		
		File dumpFilePath = new File(neo4jDBPath + "dump.txt");
		assertTrue(dumpFilePath.exists());
	}

	@Test
	public void testSchema() {
		String neo4jDumpFilePath = "tests\\graph.dbdump.txt";
		String[] args = {"--schema", neo4jDumpFilePath};
		
		API.main(args);
		
		assertTrue(true);
	}
	
	@Test
	public void testQueryString() {
		String[] args = {"--query", "MATCH (n) RETURN labels(n) AS labels, count(*) AS count"};
		
		API.main(args);
		
		assertTrue(true);
	}
	
	@Test
	public void testQueryPath() {
		String[] args = {"--query", "tests\\query.txt"};
		
		API.main(args);
		
		assertTrue(true);
	}
}