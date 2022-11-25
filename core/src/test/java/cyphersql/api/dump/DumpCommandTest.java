package cyphersql.api.dump;

import cyphersql.api.exception.NoTranslatorFoundException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DumpCommandTest {
    @Test
    public void failsToInitializeForInvalidDatabase() throws Exception {
        CommandLine cmd = createOptions("-source", "source-database", "-target", "target-location", "-database", "invalid");
        NoTranslatorFoundException exception = assertThrows(NoTranslatorFoundException.class, () -> new DumpCommand().execute(cmd));
        assertEquals("No translator found to handle database invalid", exception.getMessage());
    }

    private CommandLine createOptions(String... options) throws ParseException {
        return new DefaultParser().parse(new DumpOptions().getAll(), options);
    }
}
