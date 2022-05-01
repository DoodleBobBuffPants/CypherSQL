package cyphersql.api.execute;

import cyphersql.api.Parameters;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ExecuteParameters implements Parameters {
    public static Option execute = new Option("execute", false, "Execute the provided query");
    public static Option query = new Option("query", true, "The query to execute");
    public static Option db = new Option("db", true, "The name of the database to execute this query on");

    @Override
    public Options getAll() {
        return new Options()
                .addOption(execute)
                .addOption(query)
                .addOption(db);
    }

    @Override
    public Options getExclusiveOptions() {
        return new Options().addOption(execute);
    }

    @Override
    public boolean isConfigured(Options options) {
        return options.hasOption(execute.getOpt()) &&
               options.hasOption(query.getOpt()) &&
               options.hasOption(db.getOpt());
    }
}
