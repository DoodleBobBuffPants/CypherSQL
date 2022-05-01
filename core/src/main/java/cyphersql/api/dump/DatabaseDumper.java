package cyphersql.api.dump;

import cyphersql.api.Translator;
import cyphersql.api.exception.NoTranslatorFoundException;
import cyphersql.register.TranslatorRegister;

import java.lang.System.Logger;
import java.nio.file.Path;

import static java.lang.System.Logger.Level.INFO;
import static java.lang.System.getLogger;

public class DatabaseDumper {
    private static final Logger logger = getLogger(DatabaseDumper.class.getSimpleName());
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
        logger.log(INFO, "Database dump starting...");
        targetDatabase.dumpDatabase(sourceDatabase, targetLocation);
        logger.log(INFO, "Database dump complete");
    }
}
