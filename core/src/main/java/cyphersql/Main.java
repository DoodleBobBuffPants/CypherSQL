package cyphersql;

import cyphersql.api.CypherSqlOptions;
import cyphersql.comparator.OptionComparator;
import cyphersql.register.CommandRegister;
import cyphersql.register.CypherSqlOptionsRegister;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.System.Logger;
import java.util.Arrays;

import static cyphersql.api.dump.DumpOptions.DUMP;
import static cyphersql.api.execute.ExecuteOptions.EXECUTE;
import static cyphersql.api.translate.TranslateOptions.TRANSLATE;
import static java.lang.System.Logger.Level.INFO;
import static java.lang.System.getLogger;

public class Main {
    public static final String QUERY_DELIMITER = "-- QUERY DELIMITER";
    private static final Logger logger = getLogger(Main.class.getSimpleName());

    public static void main(String[] args) throws Exception {
        CommandLine cmd = parseArguments(args);

        if (isConfigurationInvalid(cmd)) {
            printHelp();
        } else {
            if (cmd.hasOption(DUMP)) {
                CommandRegister.get(DUMP.getOpt()).execute(cmd);
            }
            if (cmd.hasOption(TRANSLATE)) {
                String result = (String) CommandRegister.get(TRANSLATE.getOpt()).execute(cmd);
                logger.log(INFO, "The translated query is:\n" + result);
            }
            if (cmd.hasOption(EXECUTE)) {
                CommandRegister.get(EXECUTE.getOpt()).execute(cmd);
            }
        }
    }

    protected static CommandLine parseArguments(String[] args) throws ParseException {
        Options options = new Options();
        for (CypherSqlOptions cypherSqlOptions : CypherSqlOptionsRegister.get()) cypherSqlOptions.getAll().getOptions().forEach(options::addOption);
        return new DefaultParser().parse(options, args);
    }

    protected static boolean isConfigurationInvalid(CommandLine cmd) {
        Options options = new Options();
        Arrays.stream(cmd.getOptions()).forEach(options::addOption);

        boolean noCommandConfigured = CommandRegister.get().stream().noneMatch(c -> c.isConfigured(options));
        boolean multipleExclusiveOptionsPresent = options.getOptions().stream().filter(o -> CypherSqlOptionsRegister.get().stream().flatMap(p -> p.getExclusiveOptions().getOptions().stream()).toList().contains(o)).count() > 1;

        return noCommandConfigured || multipleExclusiveOptionsPresent;
    }

    private static void printHelp() throws IOException {
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            HelpFormatter hf = new HelpFormatter();
            hf.setWidth(120);
            hf.setOptionComparator(new OptionComparator());
            CypherSqlOptionsRegister.get().forEach(p -> {
                hf.printHelp(pw, hf.getWidth(), " ", null, p.getAll(), hf.getLeftPadding(), hf.getDescPadding(), null, true);
                pw.println();
            });
            logger.log(INFO, sw.toString());
        }
    }
}
