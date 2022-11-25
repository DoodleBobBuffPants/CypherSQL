package cyphersql.api.execute;

import cyphersql.api.Command;
import cyphersql.api.Translator;
import cyphersql.api.exception.ExecuteFailedException;
import cyphersql.register.CypherSqlOptionsRegister;
import cyphersql.register.TranslatorRegister;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.sql.SQLException;

import static cyphersql.Main.QUERY_DELIMITER;
import static cyphersql.api.execute.ExecuteOptions.*;

public class ExecuteCommand implements Command<Void> {
    @Override
    public boolean handlesCommand(String command) {
        return EXECUTE.getOpt().equalsIgnoreCase(command);
    }

    @Override
    public boolean isConfigured(Options options) {
        return CypherSqlOptionsRegister.get(ExecuteOptions.class).isConfigured(options);
    }

    @Override
    public Void execute(CommandLine cmd) {
        String query = cmd.getOptionValue(QUERY);
        Translator database = TranslatorRegister.get(cmd.getOptionValue(DATABASE));

        for (String statement : query.split(QUERY_DELIMITER)) {
            try {
                database.execute(statement.trim(), cmd);
            } catch (SQLException e) {
                throw new ExecuteFailedException(e);
            }
        }

        return null;
    }
}
