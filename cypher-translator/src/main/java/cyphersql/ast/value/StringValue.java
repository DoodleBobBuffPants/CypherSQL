package cyphersql.ast.value;

public class StringValue extends Value<String> {
    public StringValue(String value) {
        super(value);
    }

    @Override
    public String getRawValue() {
        return value;
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }
}
