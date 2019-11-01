package FrontEndAPI;

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
		graphDumper.dumpGraphDatabase();
		
		SchemaTranslator.Translator schemaTranslator = new SchemaTranslator.Translator(graphDumper.getNeo4jDumpFilePath());
		schemaTranslator.createAST();
		schemaTranslator.createPostgresDB();
	}
	
	private static void handleSchema(String createFile) {
		SchemaTranslator.Translator schemaTranslator = new SchemaTranslator.Translator(createFile);
		schemaTranslator.createAST();
		schemaTranslator.createPostgresDB();
	}
	
	private static void handleQuery(String query) {
		System.out.println("Not yet implemented");
	}
}