package cyphersql;

import cyphersql.api.Translator;

import java.nio.file.Path;

public class CypherTranslator implements Translator {
    @Override
    public String getDatabaseName() {
        return "Neo4J";
    }

    @Override
    public String translate(String query, Translator target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dumpDatabase(Path sourceDatabase, Path targetLocation) {
        throw new UnsupportedOperationException();
    }
}
