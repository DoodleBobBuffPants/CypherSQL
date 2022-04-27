package cyphersql;

import cyphersql.api.Parameters;
import cyphersql.api.dump.DatabaseDumper;
import cyphersql.api.dump.DumpParameters;
import cyphersql.api.translate.QueryTranslator;
import cyphersql.api.translate.TranslateParameters;
import cyphersql.comparator.OptionComparator;
import cyphersql.register.ParametersRegister;
import org.apache.commons.cli.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {
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
        boolean anyParametersAreInvalid = ParametersRegister.getParameters().stream().anyMatch(p -> p.isConfigurationInvalid(options));
        boolean multipleExclusiveOptionsPresent = options.getOptions().stream().filter(o -> ParametersRegister.getParameters().stream()
                                                                                                              .flatMap(p -> p.getExclusiveOptions().getOptions().stream())
                                                                                                              .toList().contains(o))
                                                         .count() > 1;

        return noOptionsConfigured || anyParametersAreInvalid || multipleExclusiveOptionsPresent;
    }

    private static void printHelp() {
        HelpFormatter hf = new HelpFormatter();
        hf.setWidth(120);
        hf.setOptionComparator(new OptionComparator());
        ParametersRegister.getParameters().forEach(p -> {
            hf.printHelp("all of these are required together", p.getAll());
            System.out.println();
        });
    }

    protected static void handleDump(CommandLine cmd) {
        Path sourceDatabase = Paths.get(cmd.getOptionValue(DumpParameters.source));
        Path targetLocation = Paths.get(cmd.getOptionValue(DumpParameters.target));
        new DatabaseDumper(sourceDatabase, targetLocation, cmd.getOptionValue(DumpParameters.database)).dump();
    }

    protected static void handleTranslate(CommandLine cmd) {
        String query = cmd.getOptionValue(TranslateParameters.query);
        String source = cmd.getOptionValue(TranslateParameters.source);
        String target = cmd.getOptionValue(TranslateParameters.target);
        String translatedQuery = new QueryTranslator(query, source, target).translate();
        System.out.println("The translated query is:\n" + translatedQuery);
    }
}
