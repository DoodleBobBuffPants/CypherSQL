package cyphersql.api.execute;

import cyphersql.api.exception.NoTranslatorFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueryExecutorTest {
    @Test
    public void failsToInitializeForInvalidDatabase() {
        NoTranslatorFoundException exception = assertThrows(NoTranslatorFoundException.class, () ->
                new QueryExecutor("SELECT 1", "invalid", null));
        assertEquals("No translator found to handle database invalid", exception.getMessage());
    }
}
