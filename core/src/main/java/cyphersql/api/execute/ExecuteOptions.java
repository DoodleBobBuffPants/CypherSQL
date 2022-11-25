package cyphersql.api.execute;

import cyphersql.api.CypherSqlOptions;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ExecuteOptions extends CypherSqlOptions {
    public static final Option EXECUTE = Option.builder("execute").desc("Execute the provided query").build();
    public static final Option QUERY = Option.builder("query").hasArg(true).desc("The query to execute").build();
    public static final Option DATABASE = Option.builder("database").hasArg(true).desc("The name of the database engine to execute this query on").build();

    @Override
    public Options getRequired() {
        return new Options().addOption(EXECUTE).addOption(QUERY).addOption(DATABASE);
    }

    @Override
    public Options getAll() {
        return getRequired();
    }

    @Override
    public Options getExclusiveOptions() {
        return new Options().addOption(EXECUTE);
    }
}
