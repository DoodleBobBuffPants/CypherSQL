package cyphersql.api.exception;

public class TranslationFailedException extends RuntimeException {
    public TranslationFailedException(String sourceDB, String targetDB, Exception e) {
        super("Translation from " + sourceDB + " to " + targetDB + " failed", e);
    }
}
