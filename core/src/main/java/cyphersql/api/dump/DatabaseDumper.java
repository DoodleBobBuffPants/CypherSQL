package cyphersql.api.dump;

import cyphersql.api.Translator;
import cyphersql.api.exception.NoTranslatorFoundException;
import cyphersql.register.TranslatorRegister;

import java.nio.file.Path;

public class DatabaseDumper {
    private final Path sourceDatabase;
    private final Path targetLocation;
    private final Translator targetDatabase;

    public DatabaseDumper(Path sourceDatabase, Path targetLocation, String targetDatabase) {
        this.sourceDatabase = sourceDatabase;
        this.targetLocation = targetLocation;
        this.targetDatabase = TranslatorRegister.getTranslators().stream()
                                                .filter(t -> t.getDatabaseName().equalsIgnoreCase(targetDatabase))
                                                .findFirst()
                                                .orElseThrow(() -> new NoTranslatorFoundException(targetDatabase));
    }

    public void dump() {
        System.out.println("Database dump starting...");
        targetDatabase.dumpDatabase(sourceDatabase, targetLocation);
        System.out.println("Database dump complete");
    }
}
