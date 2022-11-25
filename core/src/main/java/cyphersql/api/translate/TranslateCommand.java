package cyphersql.api.translate;

import cyphersql.api.Command;
import cyphersql.api.Translator;
import cyphersql.api.exception.UnableToReadQueryException;
import cyphersql.register.CypherSqlOptionsRegister;
import cyphersql.register.TranslatorRegister;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import static cyphersql.Main.QUERY_DELIMITER;
import static cyphersql.api.translate.TranslateOptions.*;

public class TranslateCommand implements Command<String> {
    @Override
    public boolean handlesCommand(String command) {
        return TRANSLATE.getOpt().equalsIgnoreCase(command);
    }

    @Override
    public boolean isConfigured(Options options) {
        return CypherSqlOptionsRegister.get(TranslateOptions.class).isConfigured(options);
    }

    @Override
    public String execute(CommandLine cmd) {
        String query = cmd.getOptionValue(QUERY);
        Translator source = TranslatorRegister.get(cmd.getOptionValue(SOURCE));
        Translator target = TranslatorRegister.get(cmd.getOptionValue(TARGET));

        try {
            Path queryPath = Path.of(query);
            if (queryPath.toFile().exists()) {
                query = String.join("\n", Files.readAllLines(queryPath));
            }
        } catch (IOException e) {
            throw new UnableToReadQueryException("Unable to read the query in " + Path.of(query), e);
        } catch (InvalidPathException ignored) {
        }

        return String.join("\n\n" + QUERY_DELIMITER + "\n\n", source.translate(query, target));
    }
}
