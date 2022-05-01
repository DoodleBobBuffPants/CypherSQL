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
    public boolean isConfigured(Options options) {
        return options.hasOption(translate.getOpt()) &&
               options.hasOption(query.getOpt()) &&
               options.hasOption(source.getOpt()) &&
               options.hasOption(target.getOpt());
    }
}
