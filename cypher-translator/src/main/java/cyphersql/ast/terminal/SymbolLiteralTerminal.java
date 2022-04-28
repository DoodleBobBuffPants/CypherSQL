package cyphersql.ast.terminal;

import cyphersql.ast.value.IntValue;
import cyphersql.ast.value.StringValue;
import cyphersql.ast.value.Value;

import static cyphersql.utils.StringUtils.*;

public class SymbolLiteralTerminal implements Terminal {
    private final Value<?> value;

    public SymbolLiteralTerminal(String value) {
        value = removeQuotes(value);
        if (isInt(value)) {
            this.value = new IntValue(Integer.parseInt(value));
        } else {
            this.value = new StringValue(value);
        }
    }

    public SymbolLiteralTerminal(int value) {
        this.value = new IntValue(value);
    }

    @Override
    public Value<?> getValue() {
        return value;
    }
}
