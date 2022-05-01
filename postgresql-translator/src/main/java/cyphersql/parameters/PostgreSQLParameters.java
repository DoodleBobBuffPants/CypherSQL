package cyphersql.parameters;

import cyphersql.api.Parameters;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class PostgreSQLParameters implements Parameters {
    public static Option url = new Option("url", false, "The database JDBC url");
    public static Option username = new Option("username", true, "The username for the database");
    public static Option password = new Option("password", true, "The password for the database");

    @Override
    public Options getAll() {
        return new Options()
                .addOption(url)
                .addOption(username)
                .addOption(password);
    }

    @Override
    public Options getExclusiveOptions() {
        return new Options();
    }

    @Override
    public boolean isConfigured(Options options) {
        return options.hasOption(url.getOpt()) &&
               options.hasOption(username.getOpt()) &&
               options.hasOption(password.getOpt());
    }
}
