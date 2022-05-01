package cyphersql;

import cyphersql.api.Translator;
import cyphersql.parameters.PostgreSQLParameters;
import org.apache.commons.cli.CommandLine;
import org.postgresql.ds.PGSimpleDataSource;

import java.lang.System.Logger;
import java.nio.file.Path;
import java.sql.*;
import java.util.List;

import static java.lang.System.Logger.Level.INFO;
import static java.lang.System.getLogger;

public class PostgreSQLTranslator implements Translator {
    private static final Logger logger = getLogger(PostgreSQLTranslator.class.getSimpleName());

    @Override
    public String getDatabaseName() {
        return "PostgreSQL";
    }

    @Override
    public List<String> translate(String query, Translator target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dumpDatabase(Path sourceDatabase, Path targetLocation) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void execute(String query, CommandLine cmd) throws SQLException {
        String url = cmd.getOptionValue(PostgreSQLParameters.url);
        String username = cmd.getOptionValue(PostgreSQLParameters.username);
        String password = cmd.getOptionValue(PostgreSQLParameters.password);

        try (Connection connection = getConnection(url, username, password); Statement statement = connection.createStatement()) {
            statement.execute(query);
            logResults(statement.getResultSet());
        }
    }

    private Connection getConnection(String url, String username, String password) throws SQLException {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setURL(url);
        ds.setUser(username);
        ds.setPassword(password);
        return ds.getConnection();
    }

    private void logResults(ResultSet results) throws SQLException {
        ResultSetMetaData md = results.getMetaData();
        while (results.next()) {
            for (int i = 1; i <= md.getColumnCount(); i++) {
                logger.log(INFO, md.getColumnName(i));
                logger.log(INFO, results.getString(i));
                logger.log(INFO, "");
            }
        }
    }
}
