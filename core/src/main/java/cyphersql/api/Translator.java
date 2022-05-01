package cyphersql.api;

import org.apache.commons.cli.CommandLine;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

public interface Translator {
    /**
     * @return The name of the database this translator is for
     */
    String getDatabaseName();
    /**
     * @return {@code query} translated into SQL that can be executed by {@code target}
     */
    List<String> translate(String query, Translator target);
    /**
     * Dumps the database pointed to in {@code sourceDatabase} to the location pointed to in {@code targetLocation}
     */
    void dumpDatabase(Path sourceDatabase, Path targetLocation);
    /**
     * Executes the specified query
     */
    void execute(String query, CommandLine cmd) throws SQLException;
}
