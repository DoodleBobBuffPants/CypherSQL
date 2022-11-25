package cyphersql.register;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CypherSqlOptionsRegisterTest {
    @Test
    public void allOptionsImplementationsAreLoaded() {
        List<String> parameters = CypherSqlOptionsRegister.get().stream().map(p -> p.getClass().getSimpleName()).toList();
        assertEquals(3, parameters.size());
        assertTrue(parameters.contains("DumpOptions"), "Actual parameters: " + parameters);
        assertTrue(parameters.contains("ExecuteOptions"), "Actual parameters: " + parameters);
        assertTrue(parameters.contains("TranslateOptions"), "Actual parameters: " + parameters);
    }
}
