package cyphersql.api.exception;

public class UnsupportedTranslationException extends RuntimeException {
    public UnsupportedTranslationException(String sourceDatabase, String targetDatabase) {
        super("Translation from " + sourceDatabase + " to " + targetDatabase + " is unsupported");
    }
}
