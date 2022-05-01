package cyphersql.postgresql;

import cyphersql.listener.CypherCreateListener;

import java.util.List;

public record PostgreSQLCreateTranslator(CypherCreateListener listener) {
    public List<String> translate() {
        throw new UnsupportedOperationException();
    }
}
