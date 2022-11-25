package cyphersql.api.exception;

import java.sql.SQLException;

public class ExecuteFailedException extends RuntimeException {
    public ExecuteFailedException(SQLException e) {
        super(e);
    }
}
