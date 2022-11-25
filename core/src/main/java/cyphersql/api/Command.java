package cyphersql.api;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public interface Command<T> {
    boolean handlesCommand(String command);

    boolean isConfigured(Options options);

    T execute(CommandLine cmd);
}
