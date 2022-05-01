package cyphersql.api;

import org.apache.commons.cli.Options;

public interface Parameters {
    Options getAll();
    Options getExclusiveOptions();
    boolean isConfigured(Options options);
}
