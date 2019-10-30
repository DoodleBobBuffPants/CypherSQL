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
		String neo4jDBPath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db";
		String[] args = {"--graphdb", neo4jDBPath};
		
		API.main(args);
		
		File dumpFilePath = new File(neo4jDBPath + "dump.txt");
		assertTrue(dumpFilePath.exists());
	}

	@Test
	public void testSchema() {
		String neo4jDumpFilePath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.dbdump.txt";
		String[] args = {"--schema", neo4jDumpFilePath};
		
		API.main(args);
		
		assertTrue(true);
	}
	
	@Test
	public void testQuery() {
		String[] args = {"--query", "test"};
		
		API.main(args);
		
		assertTrue(true);
	}
}