package SchemaTranslator;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Paths;

import org.junit.Test;

public class TestTranslator {
	@Test
	public void testDumpGraphDatabase() {
		String neo4jDBPath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db";
		Translator schemaTranslator = new Translator(neo4jDBPath);
		
		schemaTranslator.dumpGraphDatabase();
		
		File neo4jDumpFile = new File(neo4jDBPath + "dump.txt");
		assertTrue(neo4jDumpFile.exists());
	}
	
	@Test
	public void testCreateAST() {
		String neo4jDumpFilePath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.dbdump.txt";
		Translator schemaTranslator = new Translator(Paths.get(neo4jDumpFilePath));
		
		schemaTranslator.createAST();
		
		assertTrue(true);
	}
	
	@Test
	public void testConnectPostgres() {
		Translator.connectPostgres();
		
		assertTrue(true);
	}
}