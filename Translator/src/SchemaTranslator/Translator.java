package SchemaTranslator;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.neo4j.shell.StartClient;

public class Translator {
	public static void dumpGraphDatabase(String neo4jDBPath, String neo4jDumpFilePath) {		
		try {
			String[] neo4jDumpArgs = {"-path", neo4jDBPath, "-c", "dump"};
			PrintStream neo4jDumpOut = new PrintStream(neo4jDumpFilePath);
			System.setOut(neo4jDumpOut);
			StartClient.main(neo4jDumpArgs);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			neo4jDumpOut.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void cleanDumpFile(Path neo4jDumpFilePath) {
		try {
			List<String> dumpFileContents = Files.readAllLines(neo4jDumpFilePath);
			dumpFileContents.remove(0);
			dumpFileContents.remove(0);
			dumpFileContents.remove(0);
			dumpFileContents.remove(0);
			dumpFileContents.remove(dumpFileContents.size() - 1);
			dumpFileContents.remove(dumpFileContents.size() - 1);
			Files.write(neo4jDumpFilePath, dumpFileContents);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void connectPostgres() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "admin");
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}