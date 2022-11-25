package cyphersql.api.dump;

import cyphersql.api.CypherSqlOptions;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class DumpOptions extends CypherSqlOptions {
    public static final Option DUMP = Option.builder("dump").desc("Dump the provided database").build();
    public static final Option SOURCE = Option.builder("source").hasArg(true).desc("The database to dump. Must be a path to the database file").build();
    public static final Option TARGET = Option.builder("target").hasArg(true).desc("The target file for the dumped database").build();
    public static final Option DATABASE = Option.builder("database").hasArg(true).desc("The name of the database engine being dumped").build();

    @Override
    public Options getRequired() {
        return new Options().addOption(DUMP).addOption(SOURCE).addOption(TARGET).addOption(DATABASE);
    }

    @Override
    public Options getAll() {
        return getRequired();
    }

    @Override
    public Options getExclusiveOptions() {
        return new Options().addOption(DUMP);
    }
}
