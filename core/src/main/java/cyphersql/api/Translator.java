package cyphersql.api;

import java.nio.file.Path;

public interface Translator {
    /**
     * @return The name of the database this translator is for
     */
    String getDatabaseName();
    /**
     * @return {@code query} translated into SQL that can be executed by {@code target}
     */
    String translate(String query, Translator target);
    /**
     * Dumps the database pointed to in {@code sourceDatabase} to the location pointed to in {@code targetLocation}
     */
    void dumpDatabase(Path sourceDatabase, Path targetLocation);
}
