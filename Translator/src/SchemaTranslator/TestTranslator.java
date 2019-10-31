package SchemaTranslator;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import SchemaAST.Create;
import SchemaAST.CreateEdge;
import SchemaAST.CreateNode;

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
	public void testCreateASTStack() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(Paths.get(createFile));
		
		schemaTranslator.createAST();
		Stack<Create> createStack = schemaTranslator.getCreateStack();
		
		assertTrue(createStack.pop() instanceof CreateEdge);
		assertTrue(createStack.pop() instanceof CreateNode);
	}
	
	@Test
	public void testCreateASTLabels() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(Paths.get(createFile));
		
		schemaTranslator.createAST();
		Map<String, Map<String, Object>> labelTables = schemaTranslator.getLabelTables();
		
		assertTrue(labelTables.keySet().contains("Movie"));
	}
	
	@Test
	public void testCreateASTTypes() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(Paths.get(createFile));
		
		schemaTranslator.createAST();
		Map<String, Map<String, Object>> typeTables = schemaTranslator.getTypeTables();
		
		assertTrue(typeTables.keySet().contains("REVIEWED"));
	}
}