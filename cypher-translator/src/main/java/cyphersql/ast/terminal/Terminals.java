package cyphersql.ast.terminal;

import cyphersql.ast.value.Value;

public enum Terminals implements Terminal {
    ENTER_LIST, EXIT_LIST, ENTER_NODE_LABELS, EXIT_NODE_LABELS, ENTER_MAP, EXIT_MAP;

    @Override
    public Value<?> getValue() {
        throw new UnsupportedOperationException();
    }
}
