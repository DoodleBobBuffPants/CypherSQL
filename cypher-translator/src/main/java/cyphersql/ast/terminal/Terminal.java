package cyphersql.ast.terminal;

import cyphersql.ast.value.Value;

public interface Terminal {
    Value<?> getValue();
}
