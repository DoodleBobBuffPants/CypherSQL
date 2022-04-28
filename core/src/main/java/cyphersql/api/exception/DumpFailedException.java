package cyphersql.api.exception;

public class DumpFailedException extends RuntimeException {
    public DumpFailedException(String sourceDatabase, String targetLocation, Exception e) {
        super("Dump of database " + sourceDatabase + " to " + targetLocation + " failed", e);
    }
}
