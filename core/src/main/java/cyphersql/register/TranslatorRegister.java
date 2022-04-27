package cyphersql.register;

import cyphersql.api.Translator;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class TranslatorRegister {
    private static List<Translator> translators = null;

    public static List<Translator> getTranslators() {
        if (translators == null) {
            register();
        }
        return translators;
    }

    private synchronized static void register() {
        translators = new ArrayList<>();
        ServiceLoader.load(Translator.class).forEach(t -> translators.add(t));
    }
}
