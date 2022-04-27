package cyphersql.register;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslatorRegisterTest {
    @Test
    public void allTranslatorImplementationsAreLoaded() {
        List<String> translators = TranslatorRegister.getTranslators().stream().map(t -> t.getClass().getSimpleName()).toList();
        assertEquals(1, translators.size());
    }
}
