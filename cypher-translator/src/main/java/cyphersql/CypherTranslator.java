package cyphersql;

import cyphersql.api.Translator;
import cyphersql.api.exception.DumpFailedException;
import org.neo4j.shell.StartClient;

import java.io.PrintStream;
import java.nio.file.Path;

import static cyphersql.utils.FileUtils.trimLines;

public class CypherTranslator implements Translator {
    @Override
    public String getDatabaseName() {
        return "Neo4J";
    }

    @Override
    public String translate(String query, Translator target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dumpDatabase(Path sourceDatabase, Path targetLocation) {
        try {
            PrintStream old = System.out;
            PrintStream sourceDatabasePrintStream = new PrintStream(targetLocation.toString());

            System.setOut(sourceDatabasePrintStream);
            StartClient.main(new String[] { "-path", sourceDatabase.toString(), "-c", "dump" });

            System.setOut(old);
            sourceDatabasePrintStream.close();
            trimLines(targetLocation, 4, 2);
        } catch (Exception e) {
            throw new DumpFailedException(sourceDatabase.toString(), targetLocation.toString(), e);
        }
    }
}
