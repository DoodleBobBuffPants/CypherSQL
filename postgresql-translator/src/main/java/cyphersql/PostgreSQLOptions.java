package cyphersql;

import cyphersql.api.CypherSqlOptions;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class PostgreSQLOptions extends CypherSqlOptions {
    public static final Option URL = Option.builder("url").desc("The database JDBC url").build();
    public static final Option USERNAME = Option.builder("username").hasArg(true).desc("The username for the database").build();
    public static final Option PASSWORD = Option.builder("password").hasArg(true).desc("The password for the database").build();

    @Override
    public Options getRequired() {
        return new Options();
    }

    @Override
    public Options getAll() {
        return getRequired().addOption(URL).addOption(USERNAME).addOption(PASSWORD);
    }

    @Override
    public Options getExclusiveOptions() {
        return new Options();
    }
}
