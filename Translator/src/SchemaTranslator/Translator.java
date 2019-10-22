package SchemaTranslator;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.neo4j.shell.StartClient;

public class Translator {
	public static void main(String[] args) {
		System.out.println("Database dump starting...");
		String neo4jDBPath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\graph.db";
		String neo4jDumpFilePath = "D:\\Program Files\\Neo4j\\Neo4j CE 3.2.6\\databases\\dump.txt";
		try {
			Translator.dumpGraphDatabase(neo4jDBPath, neo4jDumpFilePath);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Database dump complete");
		
		System.out.println("Dump file cleaning started...");
		try {
			Translator.cleanDumpFile(Paths.get(neo4jDumpFilePath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Dump file cleaning complete");
		
		System.out.println("Testing Postgres connection...");
		try {
			Translator.connectPostgres();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Testing Postgres complete");
	}
	
	public static void dumpGraphDatabase(String neo4jDBPath, String neo4jDumpFilePath) throws FileNotFoundException {		
		String[] neo4jDumpArgs = {"-path", neo4jDBPath, "-c", "dump"};
		PrintStream neo4jDumpOut = new PrintStream(neo4jDumpFilePath);
		System.setOut(neo4jDumpOut);
		StartClient.main(neo4jDumpArgs);
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		neo4jDumpOut.close();
	}
	
	public static void cleanDumpFile(Path neo4jDumpFilePath) throws IOException {
		List<String> dumpFileContents = Files.readAllLines(neo4jDumpFilePath);
		dumpFileContents.remove(0);
		dumpFileContents.remove(0);
		dumpFileContents.remove(0);
		dumpFileContents.remove(0);
		dumpFileContents.remove(dumpFileContents.size() - 1);
		dumpFileContents.remove(dumpFileContents.size() - 1);
		Files.write(neo4jDumpFilePath, dumpFileContents);
	}
	
	public static void connectPostgres() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "admin");
		connection.close();
	}
}