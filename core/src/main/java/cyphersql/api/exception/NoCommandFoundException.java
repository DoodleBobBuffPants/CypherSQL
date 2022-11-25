package cyphersql.api.exception;

public class NoCommandFoundException extends RuntimeException {
    public NoCommandFoundException(String command) {
        super("No command implementation found to handle command " + command);
    }
}
