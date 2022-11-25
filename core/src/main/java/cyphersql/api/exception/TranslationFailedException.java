package cyphersql.api.exception;

public class TranslationFailedException extends RuntimeException {
    public TranslationFailedException(String sourceDatabase, String targetDatabase, Exception e) {
        super("Translation from " + sourceDatabase + " to " + targetDatabase + " failed", e);
    }
}
