package cyphersql.postgresql;

import cyphersql.listener.CypherCreateListener;
import cyphersql.listener.CypherMatchListener;
import cyphersql.listener.ListenerVisitor;

import java.util.List;

public class PostgreSQLListenerVisitor implements ListenerVisitor {
    @Override
    public List<String> visit(CypherCreateListener listener) {
        return PostgreSQLCreateVisitor.visit(listener);
    }

    @Override
    public List<String> visit(CypherMatchListener listener) {
        return PostgreSQLMatchVisitor.visit(listener);
    }
}
