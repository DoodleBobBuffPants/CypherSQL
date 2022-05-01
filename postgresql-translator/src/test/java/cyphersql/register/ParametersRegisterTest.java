package cyphersql.register;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParametersRegisterTest {
    @Test
    public void allParametersImplementationsAreLoaded() {
        List<String> parameters = ParametersRegister.getParameters().stream().map(p -> p.getClass().getSimpleName()).toList();
        assertEquals(4, parameters.size());
        assertTrue(parameters.contains("DumpParameters"), "Actual parameters: " + parameters);
        assertTrue(parameters.contains("TranslateParameters"), "Actual parameters: " + parameters);
        assertTrue(parameters.contains("ExecuteParameters"), "Actual parameters: " + parameters);
        assertTrue(parameters.contains("PostgreSQLParameters"), "Actual parameters: " + parameters);
    }
}
