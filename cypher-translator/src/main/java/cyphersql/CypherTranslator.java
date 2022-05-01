package cyphersql;

import cyphersql.antlr.CypherLexer;
import cyphersql.antlr.CypherParser;
import cyphersql.api.Translator;
import cyphersql.api.exception.*;
import cyphersql.listener.CypherCreateListener;
import cyphersql.listener.CypherMatchListener;
import cyphersql.listener.CypherQueryListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.cli.CommandLine;
import org.neo4j.shell.StartClient;

import java.io.PrintStream;
import java.nio.file.Path;
import java.util.List;

import static cyphersql.utils.FileUtils.trimLines;

public class CypherTranslator implements Translator {
    @Override
    public String getDatabaseName() {
        return "Neo4J";
    }

    @Override
    public List<String> translate(String query, Translator target) {
        return switch (target.getDatabaseName()) {
            case "Neo4J" -> List.of(query);
            case "PostgreSQL" -> translateToPostgreSQL(query);
            default -> throw new UnsupportedTranslationException(getDatabaseName(), target.getDatabaseName());
        };
    }

    @Override
    public void dumpDatabase(Path sourceDatabase, Path targetLocation) {
        try {
            PrintStream old = System.out;
            PrintStream sourceDatabasePrintStream = new PrintStream(targetLocation.toString());

            System.setOut(sourceDatabasePrintStream);
            StartClient.main(new String[] { "-path", sourceDatabase.toString(), "-c", "dump" });

            System.setOut(old);
            sourceDatabasePrintStream.close();
            trimLines(targetLocation, 4, 2);
        } catch (Exception e) {
            throw new DumpFailedException(sourceDatabase.toString(), targetLocation.toString(), e);
        }
    }

    @Override
    public void execute(String query, CommandLine cmd) {
        throw new UnsupportedOperationException();
    }

    private List<String> translateToPostgreSQL(String query) {
        try {
            return listen(query).translate();
        } catch (Exception e) {
            throw new TranslationFailedException(getDatabaseName(), "PostgreSQL", e);
        }
    }

    public CypherQueryListener listen(String query) {
        CypherQueryListener listener;
        if (query.trim().toLowerCase().startsWith("create")) {
            listener = new CypherCreateListener();
        } else if (query.trim().toLowerCase().startsWith("match")) {
            listener = new CypherMatchListener();
        } else {
            throw new UnsupportedQueryException(query, List.of("CREATE", "MATCH"));
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, new CypherParser(new CommonTokenStream(new CypherLexer(CharStreams.fromString(query)))).oC_Cypher());
        return listener;
    }
}