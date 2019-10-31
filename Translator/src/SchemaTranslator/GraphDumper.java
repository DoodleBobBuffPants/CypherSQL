package SchemaTranslator;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.neo4j.shell.StartClient;

public class GraphDumper {
	private String neo4jDBPath;
	private String neo4jDumpFilePath;
	
	public GraphDumper(String neo4jDBPath) {
		this.neo4jDBPath = neo4jDBPath;
		this.neo4jDBPath = neo4jDBPath + "dump.txt";
	}
	
	public String getNeo4jDumpFilePath() {
		return neo4jDumpFilePath;
	}

	public void dumpGraphDatabase() {		
		try {
			String[] neo4jDumpArgs = {"-path", neo4jDBPath, "-c", "dump"};
			PrintStream neo4jDumpOut = new PrintStream(neo4jDumpFilePath);
			System.setOut(neo4jDumpOut);
			StartClient.main(neo4jDumpArgs);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			neo4jDumpOut.close();
			cleanDumpFile();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void cleanDumpFile() {
		try {
			List<String> dumpFileContents = Files.readAllLines(Paths.get(neo4jDumpFilePath));
			dumpFileContents.remove(0);
			dumpFileContents.remove(0);
			dumpFileContents.remove(0);
			dumpFileContents.remove(0);
			dumpFileContents.remove(dumpFileContents.size() - 1);
			dumpFileContents.remove(dumpFileContents.size() - 1);
			Files.write(Paths.get(neo4jDumpFilePath), dumpFileContents);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}