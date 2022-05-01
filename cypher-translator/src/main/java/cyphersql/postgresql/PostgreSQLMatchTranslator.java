package cyphersql.postgresql;

import cyphersql.listener.CypherMatchListener;

import java.util.List;

public record PostgreSQLMatchTranslator(CypherMatchListener listener) {
    public List<String> translate() {
        throw new UnsupportedOperationException();
    }
}
