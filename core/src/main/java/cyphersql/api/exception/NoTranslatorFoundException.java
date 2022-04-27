package cyphersql.api.exception;

public class NoTranslatorFoundException extends RuntimeException {
    public NoTranslatorFoundException(String database) {
        super("No translator found to handle database " + database);
    }
}
