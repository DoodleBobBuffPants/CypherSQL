package cyphersql;

import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void validationFailsForPartiallyConfiguredPostgreSQLCredentials() throws ParseException {
        assertTrue(Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-username", "postgres" })));
    }

    @Test
    public void validationSucceedsForConfiguredPostgreSQLCredentials() throws ParseException {
        assertFalse(Main.isConfigurationInvalid(Main.parseArguments(new String[] { "-url", "jdbc:postgresql://localhost:5432/test", "-username", "postgres", "-password", "test" })));
    }

    @Test
    public void successfullyPrintsHelp() throws Exception {
        Main.main(new String[] { });
    }
}
