package cyphersql;

import cyphersql.api.exception.TranslationFailedException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class CypherTranslatorTest {
    private final CypherTranslator translator = new CypherTranslator();

    @Disabled("Required graph DB does not exist")
    @Test
    public void databaseDumpsSuccessfully() {
        Path databaseDump = Path.of("src", "test", "resources", "databases", "graph.db");
        Path dumpLocation = Path.of("src", "test", "resources", "databases", "dump", "graph_dump.txt");

        translator.dump(databaseDump, dumpLocation);
        File dumpFile = dumpLocation.toFile();

        assertTrue(dumpFile.exists());
        assertTrue(dumpFile.length() > 0);
    }

    @Test
    public void translatesMatchNodeWithCount() {
        String query = "MATCH (n) RETURN count(*) AS count";
        assertThrows(TranslationFailedException.class, () -> translator.translate(query, new PostgreSQLTranslator()));
    }

    @Test
    public void translatesCreateNode() {
        String query = "CREATE (_0: `Movie` {`released`: 1999, `tagline`: \"Welcome to the Real World\", `title`: \"The Matrix\"})";
        assertThrows(TranslationFailedException.class, () -> translator.translate(query, new PostgreSQLTranslator()));
    }
}
