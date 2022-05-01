package cyphersql.api.exception;

public class NoServiceFoundException extends RuntimeException {
    public NoServiceFoundException(Class<?> clazz) {
        super("No service found called " + clazz.getSimpleName());
    }
}
