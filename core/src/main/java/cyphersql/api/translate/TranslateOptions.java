package cyphersql.api.translate;

import cyphersql.api.CypherSqlOptions;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class TranslateOptions extends CypherSqlOptions {
    public static final Option TRANSLATE = Option.builder("translate").desc("Translate the provided query").build();
    public static final Option QUERY = Option.builder("query").hasArg(true).desc("The query to translate. Can be either a string or a file of statements").build();
    public static final Option SOURCE = Option.builder("source").hasArg(true).desc("The name of the source database engine for the translated query").build();
    public static final Option TARGET = Option.builder("target").hasArg(true).desc("The name of the target database engine for the translated query").build();

    @Override
    public Options getRequired() {
        return new Options().addOption(TRANSLATE).addOption(QUERY).addOption(SOURCE).addOption(TARGET);
    }

    @Override
    public Options getAll() {
        return getRequired();
    }

    @Override
    public Options getExclusiveOptions() {
        return new Options().addOption(TRANSLATE);
    }
}
