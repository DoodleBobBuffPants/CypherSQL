package cyphersql.api.exception;

public class UnableToReadQueryException extends RuntimeException {
    public UnableToReadQueryException(String message, Exception e) {
        super(message, e);
    }
}
