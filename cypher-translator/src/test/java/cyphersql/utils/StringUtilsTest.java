package cyphersql.utils;

import org.junit.jupiter.api.Test;

import static cyphersql.utils.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    public void removeDoubleQuotes() {
        assertEquals("Good morning", removeQuotes("\"Good morning\""));
    }

    @Test
    public void keepEscapedDoubleQuotes() {
        assertEquals("\\\"Good morning\\\"", removeQuotes("\\\"Good morning\\\""));
    }

    @Test
    public void removeSingleQuotes() {
        assertEquals("Good morning", removeQuotes("'Good morning'"));
    }

    @Test
    public void keepEscapedSingleQuotes() {
        assertEquals("\\'Good morning\\'", removeQuotes("\\'Good morning\\'"));
    }

    @Test
    public void removeBackticks() {
        assertEquals("Good morning", removeQuotes("`Good morning`"));
    }

    @Test
    public void keepEscapedBackticks() {
        assertEquals("\\`Good morning\\`", removeQuotes("\\`Good morning\\`"));
    }

    @Test
    public void intIsInt() {
        assertTrue(isInt("69"));
    }

    @Test
    public void stringIsNotInt() {
        assertFalse(isInt("Good morning"));
    }
}
