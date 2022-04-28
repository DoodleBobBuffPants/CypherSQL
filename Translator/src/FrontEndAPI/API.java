package FrontEndAPI;

import java.io.File;
import java.nio.file.Paths;

import ResultFormatter.Formatter;

public class API {

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

    private static void handleQuery(String database, String query) {
        QueryTranslator.Translator queryTranslator;
        if (new File(query).exists()) {
            queryTranslator = new QueryTranslator.Translator(Paths.get(query));
        } else {
            queryTranslator = new QueryTranslator.Translator(query);
        }
        System.out.println("Query translation starting...");
        System.out.println(queryTranslator.translate());
        System.out.println("Query translation completed");

        Formatter resultFormatter = new Formatter();
        resultFormatter.getPostgresResult(database, queryTranslator.getTranslatedQuery());
        System.out.println("Postgres results:");
        resultFormatter.printPostgresResult();
    }
}
