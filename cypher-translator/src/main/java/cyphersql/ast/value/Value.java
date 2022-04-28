package cyphersql.ast.value;

public abstract class Value<T> {
    public T value;

    public Value(T value) {
        this.value = value;
    }

    public String getRawValue() {
        return value.toString();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
