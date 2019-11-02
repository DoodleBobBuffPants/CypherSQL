package SchemaTranslator;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public void testPopulatedNodes() throws SQLException {
//		String createFile = "test\\creates.txt";
//		Translator schemaTranslator = new Translator(createFile);
//		
//		schemaTranslator.translate();
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/creates", "postgres", "admin");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM NODES");
		result.next();
		
		assertTrue(result.getObject(1).toString().equals("_0"));
		assertTrue(result.getObject(2).toString().equals("{Movie}"));
	}
	
	@Test
	public void testPopulatedEdges() throws SQLException {
//		String createFile = "test\\creates.txt";
//		Translator schemaTranslator = new Translator(createFile);
//		
//		schemaTranslator.translate();
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/creates", "postgres", "admin");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM EDGES");
		result.next();
		
		assertTrue(result.getObject(1).toString().equals("_170"));
		assertTrue(result.getObject(2).toString().equals("_111"));
		assertTrue(result.getObject(3).toString().equals("REVIEWED"));
	}
	
	@Test
	public void testPopulatedLabels() throws SQLException {
//		String createFile = "test\\creates.txt";
//		Translator schemaTranslator = new Translator(createFile);
//		
//		schemaTranslator.translate();
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/creates", "postgres", "admin");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM MOVIE");
		result.next();
		
		assertTrue(result.getObject(1).toString().equals("_0"));
		assertTrue(result.getObject(2).toString().equals("Welcome to the Real World"));
		assertTrue(result.getObject(3).toString().equals("The Matrix"));
		assertTrue(result.getObject(4).toString().equals("1999"));
	}
	
	@Test
	public void testPopulatedTypes() throws SQLException {
//		String createFile = "test\\creates.txt";
//		Translator schemaTranslator = new Translator(createFile);
//		
//		schemaTranslator.translate();
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/creates", "postgres", "admin");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM REVIEWED");
		result.next();
		
		assertTrue(result.getObject(1).toString().equals("_170"));
		assertTrue(result.getObject(2).toString().equals("_111"));
		assertTrue(result.getObject(3).toString().equals("Fun, but a little far fetched"));
		assertTrue(result.getObject(4).toString().equals("65"));
	}
}