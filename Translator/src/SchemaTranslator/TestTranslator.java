package SchemaTranslator;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TestTranslator {
	@Test
	public void testDumpGraphDatabase() {
		String neo4jDBPath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db";
		String neo4jDumpFilePath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\dump.txt";
		
		Translator.dumpGraphDatabase(neo4jDBPath, neo4jDumpFilePath);
		
		File neo4jDumpFile = new File(neo4jDumpFilePath);
		assertTrue(neo4jDumpFile.exists());
	}

	@Test
	public void testCleanDumpFile() {
		String neo4jDumpFilePath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\dump.txt";
		
		Translator.cleanDumpFile(neo4jDumpFilePath);
		
		File neo4jDumpFile = new File(neo4jDumpFilePath);
		assertTrue(neo4jDumpFile.exists());
	}
	
	@Test
	public void testConnectPostgres() {
		Translator.connectPostgres();
		
		assertTrue(true);
	}
}