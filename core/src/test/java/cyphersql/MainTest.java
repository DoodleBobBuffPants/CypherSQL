package cyphersql;

import cyphersql.api.exception.NoTranslatorFoundException;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void invalidTranslatorThrowsDuringDump() {
        NoTranslatorFoundException exception = assertThrows(NoTranslatorFoundException.class, () ->
                Main.handleDump(Main.parseArguments(new String[] { "-dump", "-source", "source-file", "-target", "target-file", "-database", "invalid" })));
        assertEquals("No translator found to handle database invalid", exception.getMessage());
    }

    @Test
    public void invalidTranslatorThrowsDuringTranslate() {
        NoTranslatorFoundException exception = assertThrows(NoTranslatorFoundException.class, () ->
                Main.handleTranslate(Main.parseArguments(new String[] { "-translate", "-query", "SELECT 1", "-source", "invalid1", "-target", "invalid2" })));
        assertEquals("No translator found to handle database invalid1", exception.getMessage());
    }

    @Test
    public void invalidTranslatorThrowsDuringExecute() {
        NoTranslatorFoundException exception = assertThrows(NoTranslatorFoundException.class, () ->
                Main.handleExecute(Main.parseArguments(new String[] { "-execute", "-query", "SELECT 1", "-db", "invalid" })));
        assertEquals("No translator found to handle database invalid", exception.getMessage());
    }

    @Test
    public void validationFailsForNoArguments() throws ParseException {
        assertTrue(Main.isConfigurationInvalid(Main.parseArguments(new String[] { })));
    }

    @Test
    public void validationFailsForTranslateWithNoArguments() throws ParseException {
        assertTrue(Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-translate" })));
    }

    @Test
    public void validationFailsForDumpWithNoArguments() throws ParseException {
        assertTrue(Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-dump" })));
    }

    @Test
    public void validationFailsForTranslateWithSomeArguments() throws ParseException {
        assertTrue(Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-translate", "-query", "SELECT 1" })));
    }

    @Test
    public void validationFailsForDumpWithSomeArguments() throws ParseException {
        assertTrue(Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-dump", "-database", "PostgreSQL" })));
    }

    @Test
    public void validationFailsForTranslateWithArgumentWithoutValue() {
        MissingArgumentException exception = assertThrows(MissingArgumentException.class, () ->
                Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-translate", "-query" })));
        assertEquals("Missing argument for option: query", exception.getMessage());
    }

    @Test
    public void validationFailsForDumpWithArgumentWithoutValue() {
        MissingArgumentException exception = assertThrows(MissingArgumentException.class, () ->
                Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-dump", "-database" })));
        assertEquals("Missing argument for option: database", exception.getMessage());
    }

    @Test
    public void validationFailsForTranslateWithArgumentWithoutFlag() throws ParseException {
        assertTrue(Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-query", "SELECT 1" })));
    }

    @Test
    public void validationFailsForDumpWithArgumentWithoutFlag() throws ParseException {
        assertTrue(Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-database", "PostgreSQL" })));
    }

    @Test
    public void validationFailsWithMultipleExclusiveOperations() throws ParseException {
        assertTrue(Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-dump", "-translate" })));
    }

    @Test
    public void successfullyPrintsHelp() throws Exception {
        Main.main(new String[] { });
    }
}
