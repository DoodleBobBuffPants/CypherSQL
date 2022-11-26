package cyphersql.listener;

import cyphersql.antlr.CypherBaseListener;

import java.util.List;

public abstract class CypherQueryListener extends CypherBaseListener {
    public abstract List<String> accept(ListenerVisitor visitor);
}
