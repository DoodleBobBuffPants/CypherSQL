package cyphersql.api.dump;

import cyphersql.api.Parameters;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class DumpParameters implements Parameters {
    public static Option dump = new Option("dump", false, "Dump the provided database");
    public static Option source = new Option("source", true, "The database to dump. Must be a path to the database file");
    public static Option target = new Option("target", true, "The target file for the dumped database");
    public static Option database = new Option("database", true, "The name of the database being dumped");

    @Override
    public Options getAll() {
        return new Options()
                .addOption(dump)
                .addOption(source)
                .addOption(target)
                .addOption(database);
    }

    @Override
    public Options getExclusiveOptions() {
        return new Options().addOption(dump);
    }

    @Override
    public boolean isConfigured(Options options) {
        return options.hasOption(dump.getOpt()) &&
               options.hasOption(source.getOpt()) &&
               options.hasOption(target.getOpt()) &&
               options.hasOption(database.getOpt());
    }
}
