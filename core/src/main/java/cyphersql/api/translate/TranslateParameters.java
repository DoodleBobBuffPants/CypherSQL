package cyphersql.api.translate;

import cyphersql.api.Parameters;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class TranslateParameters implements Parameters {
    public static Option translate = new Option("translate", false, "Translate the provided query");
    public static Option query = new Option("query", true, "The query to translate. Can be either a string or a file of statements");
    public static Option source = new Option("source", true, "The name of the source database for the translated query");
    public static Option target = new Option("target", true, "The name of the target database for the translated query");

    @Override
    public Options getAll() {
        return new Options()
                .addOption(translate)
                .addOption(query)
                .addOption(source)
                .addOption(target);
    }

    @Override
    public Options getExclusiveOptions() {
        return new Options().addOption(translate);
    }

    @Override
    public boolean isConfigurationInvalid(Options options) {
        boolean isConfigurationInvalid = false;
        if (options.hasOption(translate.getOpt())) {
            String validationMessagePrefix = "'" + translate.getOpt() + "' is specified but '";
            if (!options.hasOption(query.getOpt())) {
                System.err.println(validationMessagePrefix + query.getOpt() + "' is missing");
                isConfigurationInvalid = true;
            }
            if (!options.hasOption(source.getOpt())) {
                System.err.println(validationMessagePrefix + source.getOpt() + "' is missing");
                isConfigurationInvalid = true;
            }
            if (!options.hasOption(target.getOpt())) {
                System.err.println(validationMessagePrefix + target.getOpt() + "' is missing");
                isConfigurationInvalid = true;
            }
        } else {
            String validationMessagePrefix = "'" + translate.getOpt() + "' is not specified but '";
            if (options.hasOption(query.getOpt())) {
                System.err.println(validationMessagePrefix + query.getOpt() + "' is");
                isConfigurationInvalid = true;
            }
            if (options.hasOption(source.getOpt())) {
                System.err.println(validationMessagePrefix + source.getOpt() + "' is");
                isConfigurationInvalid = true;
            }
            if (options.hasOption(target.getOpt())) {
                System.err.println(validationMessagePrefix + target.getOpt() + "' is");
                isConfigurationInvalid = true;
            }
        }
        if (isConfigurationInvalid) {
            System.err.println();
        }
        return isConfigurationInvalid;
    }
}
