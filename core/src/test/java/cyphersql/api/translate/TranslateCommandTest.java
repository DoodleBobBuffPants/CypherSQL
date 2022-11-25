package cyphersql.api.translate;

import cyphersql.api.exception.NoTranslatorFoundException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TranslateCommandTest {
    @Test
    public void failsToInitializeForInvalidDatabase() throws Exception {
        CommandLine cmd = createOptions("-query", "SELECT 1", "-source", "invalid1", "-target", "invalid2");
        NoTranslatorFoundException exception = assertThrows(NoTranslatorFoundException.class, () -> new TranslateCommand().execute(cmd));
        assertEquals("No translator found to handle database invalid1", exception.getMessage());
    }

    private CommandLine createOptions(String... options) throws ParseException {
        return new DefaultParser().parse(new TranslateOptions().getAll(), options);
    }
}
