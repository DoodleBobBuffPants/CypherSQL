package cyphersql;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CypherTranslatorTest {
    private final CypherTranslator translator = new CypherTranslator();

    @Disabled("Required graph DB does not exist")
    @Test
    public void databaseDumpsSuccessfully() {
        Path dbPath = Paths.get("src", "test", "resources", "databases", "graph.db");
        Path dumpLocation = Paths.get("src", "test", "resources", "databases", "dump", "graph_dump.txt");

        translator.dumpDatabase(dbPath, dumpLocation);
        File dumpFile = dumpLocation.toFile();

        assertTrue(dumpFile.exists());
        assertTrue(dumpFile.length() > 0);
    }
}
