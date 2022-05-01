package cyphersql;

import cyphersql.api.Translator;

import java.nio.file.Path;
import java.util.List;

public class PostgreSQLTranslator implements Translator {
    @Override
    public String getDatabaseName() {
        return "PostgreSQL";
    }

    @Override
    public List<String> translate(String query, Translator target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dumpDatabase(Path sourceDatabase, Path targetLocation) {
        throw new UnsupportedOperationException();
    }
}
