package cyphersql.api.execute;

import cyphersql.api.exception.NoTranslatorFoundException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExecuteCommandTest {
    @Test
    public void failsToInitializeForInvalidDatabase() throws Exception {
        CommandLine cmd = createOptions("-query", "SELECT 1", "-database", "invalid");
        NoTranslatorFoundException exception = assertThrows(NoTranslatorFoundException.class, () -> new ExecuteCommand().execute(cmd));
        assertEquals("No translator found to handle database invalid", exception.getMessage());
    }

    private CommandLine createOptions(String... options) throws ParseException {
        return new DefaultParser().parse(new ExecuteOptions().getAll(), options);
    }
}
