package cyphersql.api.translate;

import cyphersql.api.exception.NoTranslatorFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueryTranslatorTest {
    @Test
    public void failsToInitializeForInvalidDatabase() {
        NoTranslatorFoundException exception = assertThrows(NoTranslatorFoundException.class, () ->
                new QueryTranslator("SELECT 1", "invalid1", "invalid2"));
        assertEquals("No translator found to handle database invalid1", exception.getMessage());
    }
}
