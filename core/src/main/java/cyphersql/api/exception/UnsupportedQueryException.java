package cyphersql.api.exception;

import java.util.List;

public class UnsupportedQueryException extends RuntimeException {
    public UnsupportedQueryException(String badQuery, List<String> supportedQueries) {
        super("Query '" + badQuery + "' is unsupported. The supported queries are: " + String.join(", ", supportedQueries));
    }
}
