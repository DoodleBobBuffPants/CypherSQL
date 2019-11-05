package FrontEndAPI;

import java.io.File;
import java.nio.file.Paths;

public class API {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Must contain two arguments: <option> <argument>");
			System.out.println("Options are --graphdb --schema --query");
		} else {
			String option = args[0];
			String argument = args[1];
			
			switch (option) {
				case "--graphdb":
					handleGraphDB(argument);
					break;
				case "--schema":
					handleSchema(argument);
					break;
				case "--query":
					handleQuery(argument);
					break;
				default:
					System.out.println("Invalid option");
			}
		}
	}
	
	private static void handleGraphDB(String graphDBPath) {
		SchemaTranslator.GraphDumper graphDumper = new SchemaTranslator.GraphDumper(graphDBPath);
		System.out.println("Graph dump starting...");
		graphDumper.dumpGraphDatabase();
		System.out.println("Graph dump complete");
		
		SchemaTranslator.Translator schemaTranslator = new SchemaTranslator.Translator(graphDumper.getNeo4jDumpFilePath());
		System.out.println("Schema translation starting...");
		schemaTranslator.translate();
		System.out.println("Schema translation complete");
	}
	
	private static void handleSchema(String createFile) {
		SchemaTranslator.Translator schemaTranslator = new SchemaTranslator.Translator(createFile);
		System.out.println("Schema translation starting...");
		schemaTranslator.translate();
		System.out.println("Schema translation complete");
	}
	
	private static void handleQuery(String query) {
		QueryTranslator.Translator queryTranslator;
		if (new File(query).exists()) {
			queryTranslator = new QueryTranslator.Translator(Paths.get(query));
		} else {
			queryTranslator = new QueryTranslator.Translator(query);
		}
		System.out.println("Query translation starting...");
		queryTranslator.translate();
		System.out.println("Query translation completed");
	}
}