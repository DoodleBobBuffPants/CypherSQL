package cyphersql.api.dump;

import cyphersql.api.Command;
import cyphersql.api.Translator;
import cyphersql.register.CypherSqlOptionsRegister;
import cyphersql.register.TranslatorRegister;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.lang.System.Logger;
import java.nio.file.Path;

import static cyphersql.api.dump.DumpOptions.*;
import static java.lang.System.Logger.Level.INFO;
import static java.lang.System.getLogger;

public class DumpCommand implements Command<Void> {
    private static final Logger logger = getLogger(DumpCommand.class.getSimpleName());

    @Override
    public boolean handlesCommand(String command) {
        return DUMP.getOpt().equalsIgnoreCase(command);
    }

    @Override
    public boolean isConfigured(Options options) {
        return CypherSqlOptionsRegister.get(DumpOptions.class).isConfigured(options);
    }

    @Override
    public Void execute(CommandLine cmd) {
        Path sourceDatabase = Path.of(cmd.getOptionValue(SOURCE));
        Path targetLocation = Path.of(cmd.getOptionValue(TARGET));
        Translator targetDatabase = TranslatorRegister.get(cmd.getOptionValue(DATABASE));

        logger.log(INFO, "Database dump starting...");
        targetDatabase.dump(sourceDatabase, targetLocation);
        logger.log(INFO, "Database dump complete");

        return null;
    }
}
