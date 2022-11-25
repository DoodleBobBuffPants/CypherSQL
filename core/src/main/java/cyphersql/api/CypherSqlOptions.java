package cyphersql.api;

import org.apache.commons.cli.Options;

public abstract class CypherSqlOptions {
    public boolean isConfigured(Options options) {
        return options.getOptions().containsAll(getRequired().getOptions());
    }

    public abstract Options getRequired();

    public abstract Options getAll();

    public abstract Options getExclusiveOptions();
}
