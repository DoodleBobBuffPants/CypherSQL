package FrontEndAPI;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TestAPI {
	@Test
	public void testGraphDB() {
		String[] args = {"--graphdb", "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db"};
		
		API.main(args);
		
		File dumpFilePath = new File("D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db" + "dump.txt");
		assertTrue(dumpFilePath.exists());
	}

	@Test
	public void testSchema() {
		String[] args = {"--schema", "test"};
		
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