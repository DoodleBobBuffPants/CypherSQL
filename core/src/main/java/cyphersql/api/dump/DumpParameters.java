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
    public boolean isConfigurationInvalid(Options options) {
        boolean isConfigurationInvalid = false;
        if (options.hasOption(dump.getOpt())) {
            String validationMessagePrefix = "'" + dump.getOpt() + "' is specified but '";
            if (!options.hasOption(source.getOpt())) {
                System.err.println(validationMessagePrefix + source.getOpt() + "' is missing");
                isConfigurationInvalid = true;
            }
            if (!options.hasOption(target.getOpt())) {
                System.err.println(validationMessagePrefix + target.getOpt() + "' is missing");
                isConfigurationInvalid = true;
            }
            if (!options.hasOption(database.getOpt())) {
                System.err.println(validationMessagePrefix + database.getOpt() + "' is missing");
                isConfigurationInvalid = true;
            }
        } else {
            String validationMessagePrefix = "'" + dump.getOpt() + "' is not specified but '";
            if (options.hasOption(source.getOpt())) {
                System.err.println(validationMessagePrefix + source.getOpt() + "' is");
                isConfigurationInvalid = true;
            }
            if (options.hasOption(target.getOpt())) {
                System.err.println(validationMessagePrefix + target.getOpt() + "' is");
                isConfigurationInvalid = true;
            }
            if (options.hasOption(database.getOpt())) {
                System.err.println(validationMessagePrefix + database.getOpt() + "' is");
                isConfigurationInvalid = true;
            }
        }
        if (isConfigurationInvalid) {
            System.err.println();
        }
        return isConfigurationInvalid;
    }
}
