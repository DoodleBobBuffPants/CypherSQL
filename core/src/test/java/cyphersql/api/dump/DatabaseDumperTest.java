package cyphersql.api.dump;

import cyphersql.api.exception.NoTranslatorFoundException;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseDumperTest {
    @Test
    public void failsToInitializeForInvalidDatabase() {
        NoTranslatorFoundException exception = assertThrows(NoTranslatorFoundException.class, () ->
                new DatabaseDumper(Paths.get("source-database"), Paths.get("target-location"), "invalid"));
        assertEquals("No translator found to handle database invalid", exception.getMessage());
    }
}
