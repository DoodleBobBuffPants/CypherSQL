package cyphersql.api.translate;

import cyphersql.Main;
import cyphersql.api.Translator;
import cyphersql.api.exception.NoTranslatorFoundException;
import cyphersql.api.exception.UnableToReadQueryException;
import cyphersql.register.TranslatorRegister;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class QueryTranslator {
    // may be a query or a file containing a query
    private final String query;
    private final Translator source;
    private final Translator target;

    public QueryTranslator(String query, String source, String target) {
        this.query = query;
        this.source = TranslatorRegister.getTranslators().stream()
                                        .filter(t -> t.getDatabaseName().equalsIgnoreCase(source))
                                        .findFirst()
                                        .orElseThrow(() -> new NoTranslatorFoundException(source));
        this.target = TranslatorRegister.getTranslators().stream()
                                        .filter(t -> t.getDatabaseName().equalsIgnoreCase(target))
                                        .findFirst()
                                        .orElseThrow(() -> new NoTranslatorFoundException(target));
    }

    public String translate() {
        String queryToTranslate = query;
        Path queryPath = null;
        try {
            queryPath = Path.of(query);
            if (queryPath.toFile().exists()) {
                queryToTranslate = String.join(" ", Files.readAllLines(queryPath));
            }
        } catch (IOException e) {
            throw new UnableToReadQueryException("Unable to read the queries in " + queryPath, e);
        } catch (InvalidPathException ignored) {}
        return String.join("\n\n" + Main.QUERY_DELIMITER + "\n\n", source.translate(queryToTranslate, target));
    }
}