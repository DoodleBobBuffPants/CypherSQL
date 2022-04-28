package cyphersql.api.exception;

public class UnsupportedTranslationException extends RuntimeException {
    public UnsupportedTranslationException(String sourceDB, String targetDB) {
        super("Translation from " + sourceDB + " to " + targetDB + " is unsupported");
    }
}
