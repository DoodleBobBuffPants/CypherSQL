package cyphersql.register;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommandRegisterTest {
    @Test
    public void allCommandImplementationsAreLoaded() {
        List<String> parameters = CommandRegister.get().stream().map(p -> p.getClass().getSimpleName()).toList();
        assertEquals(3, parameters.size());
        assertTrue(parameters.contains("DumpCommand"), "Actual parameters: " + parameters);
        assertTrue(parameters.contains("ExecuteCommand"), "Actual parameters: " + parameters);
        assertTrue(parameters.contains("TranslateCommand"), "Actual parameters: " + parameters);
    }
}
