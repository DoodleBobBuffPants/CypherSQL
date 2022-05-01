package cyphersql.api.execute;

import cyphersql.Main;
import cyphersql.api.Translator;
import cyphersql.api.exception.NoTranslatorFoundException;
import cyphersql.register.TranslatorRegister;
import org.apache.commons.cli.CommandLine;

import java.sql.SQLException;

public class QueryExecutor {
    private final String query;
    private final Translator db;
    private final CommandLine cmd;

    public QueryExecutor(String query, String db, CommandLine cmd) {
        this.query = query;
        this.db = TranslatorRegister.getTranslators().stream()
                                    .filter(t -> t.getDatabaseName().equalsIgnoreCase(db))
                                    .findFirst()
                                    .orElseThrow(() -> new NoTranslatorFoundException(db));
        this.cmd = cmd;
    }

    public void execute() throws SQLException {
        for (String individualQuery : query.split(Main.QUERY_DELIMITER)) {
            db.execute(individualQuery.trim(), cmd);
        }
    }
}
