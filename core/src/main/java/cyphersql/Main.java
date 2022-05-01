package cyphersql;

import cyphersql.api.Parameters;
import cyphersql.api.dump.DatabaseDumper;
import cyphersql.api.dump.DumpParameters;
import cyphersql.api.translate.QueryTranslator;
import cyphersql.api.translate.TranslateParameters;
import cyphersql.comparator.OptionComparator;
import cyphersql.register.ParametersRegister;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.System.Logger;
import java.nio.file.Path;
import java.util.Arrays;

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
            if (cmd.hasOption(DumpParameters.dump)) {
                handleDump(cmd);
            }
            if (cmd.hasOption(TranslateParameters.translate)) {
                handleTranslate(cmd);
            }
        }
    }

    protected static CommandLine parseArguments(String[] args) throws ParseException {
        Options options = new Options();
        for (Parameters parameters : ParametersRegister.getParameters()) {
            parameters.getAll().getOptions().forEach(options::addOption);
        }
        return new DefaultParser().parse(options, args);
    }

    protected static boolean isConfigurationInvalid(CommandLine cmd) {
        Options options = new Options();
        Arrays.stream(cmd.getOptions()).forEach(options::addOption);

        boolean noOptionsConfigured = options.getOptions().size() == 0;
        boolean noCommandsConfigured = ParametersRegister.getParameters().stream().noneMatch(p -> p.isConfigured(options));
        boolean multipleExclusiveOptionsPresent = options.getOptions().stream().filter(o -> ParametersRegister.getParameters().stream()
                                                                                                              .flatMap(p -> p.getExclusiveOptions().getOptions().stream())
                                                                                                              .toList().contains(o))
                                                         .count() > 1;

        return noOptionsConfigured || noCommandsConfigured || multipleExclusiveOptionsPresent;
    }

    private static void printHelp() throws IOException {
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            HelpFormatter hf = new HelpFormatter();
            hf.setWidth(120);
            hf.setOptionComparator(new OptionComparator());
            ParametersRegister.getParameters().forEach(p -> {
                hf.printHelp(pw, hf.getWidth(), " ", null, p.getAll(), hf.getLeftPadding(), hf.getDescPadding(), null, true);
                pw.println();
            });
            logger.log(INFO, sw.toString());
        }
    }

    protected static void handleDump(CommandLine cmd) {
        Path sourceDatabase = Path.of(cmd.getOptionValue(DumpParameters.source));
        Path targetLocation = Path.of(cmd.getOptionValue(DumpParameters.target));
        new DatabaseDumper(sourceDatabase, targetLocation, cmd.getOptionValue(DumpParameters.database)).dump();
    }

    protected static void handleTranslate(CommandLine cmd) {
        String query = cmd.getOptionValue(TranslateParameters.query);
        String source = cmd.getOptionValue(TranslateParameters.source);
        String target = cmd.getOptionValue(TranslateParameters.target);
        String translatedQuery = new QueryTranslator(query, source, target).translate();
        logger.log(INFO, "The translated query is:\n" + translatedQuery);
    }
}
