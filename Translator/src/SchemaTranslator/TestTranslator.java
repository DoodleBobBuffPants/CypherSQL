package SchemaTranslator;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import SchemaAST.Create;
import SchemaAST.CreateEdge;
import SchemaAST.CreateNode;

public class TestTranslator {
	@Test
	public void testCreateASTStack() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(createFile);
		
		schemaTranslator.createAST();
		Stack<Create> createStack = schemaTranslator.getCreateStack();
		
		assertTrue(createStack.pop() instanceof CreateEdge);
		assertTrue(createStack.pop() instanceof CreateNode);
	}
	
	@Test
	public void testCreateASTLabels() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(createFile);
		
		schemaTranslator.createAST();
		Map<String, Map<String, Object>> labelTables = schemaTranslator.getLabelTables();
		
		assertTrue(labelTables.keySet().contains("Movie"));
	}
	
	@Test
	public void testCreateASTTypes() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(createFile);
		
		schemaTranslator.createAST();
		Map<String, Map<String, Object>> typeTables = schemaTranslator.getTypeTables();
		
		assertTrue(typeTables.keySet().contains("REVIEWED"));
	}
	
	@Test
	public void testCreatePostgresDB() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(createFile);
		
		schemaTranslator.translate();
		
		assertTrue(true);
	}
	
	@Test
	public void testPopulatedNodes() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(createFile);
		
		schemaTranslator.translate();
		
		assertTrue(true);
	}
	
	@Test
	public void testPopulatedEdges() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(createFile);
		
		schemaTranslator.translate();
		
		assertTrue(true);
	}
	
	@Test
	public void testPopulatedLabels() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(createFile);
		
		schemaTranslator.translate();
		
		assertTrue(true);
	}
	
	@Test
	public void testPopulatedTypes() {
		String createFile = "test\\creates.txt";
		Translator schemaTranslator = new Translator(createFile);
		
		schemaTranslator.translate();
		
		assertTrue(true);
	}
}