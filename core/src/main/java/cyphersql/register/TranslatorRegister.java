package cyphersql.register;

import cyphersql.api.Translator;
import cyphersql.api.exception.NoTranslatorFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class TranslatorRegister {
    private static List<Translator> translators = null;

    public static Translator get(String databaseEngineName) {
        return get().stream().filter(t -> t.getDatabaseEngineName().equalsIgnoreCase(databaseEngineName)).findFirst().orElseThrow(() -> new NoTranslatorFoundException(databaseEngineName));
    }

    public static List<Translator> get() {
        if (translators == null) register();
        return translators;
    }

    private synchronized static void register() {
        translators = new ArrayList<>();
        ServiceLoader.load(Translator.class).forEach(t -> translators.add(t));
    }
}
