package cyphersql;

import cyphersql.antlr.CypherLexer;
import cyphersql.antlr.CypherParser;
import cyphersql.api.Translator;
import cyphersql.api.exception.DumpFailedException;
import cyphersql.api.exception.UnsupportedQueryException;
import cyphersql.api.exception.UnsupportedTranslationException;
import cyphersql.listener.CypherCreateListener;
import cyphersql.listener.CypherMatchListener;
import cyphersql.listener.CypherQueryListener;
import cyphersql.postgresql.PostgreSQLListenerVisitor;
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
    public String getDatabaseEngineName() {
        return "Neo4J";
    }

    @Override
    public List<String> translate(String query, Translator target) {
        return switch (target.getDatabaseEngineName()) {
            case "Neo4J" -> List.of(query);
            case "PostgreSQL" -> listen(query).accept(new PostgreSQLListenerVisitor());
            default -> throw new UnsupportedTranslationException(getDatabaseEngineName(), target.getDatabaseEngineName());
        };
    }

    @Override
    public void dump(Path sourceDatabase, Path targetLocation) {
        try {
            PrintStream old = System.out;
            PrintStream targetLocationPrintStream = new PrintStream(targetLocation.toString());

            System.setOut(targetLocationPrintStream);
            StartClient.main(new String[] { "-path", sourceDatabase.toString(), "-c", "dump" });

            System.setOut(old);
            targetLocationPrintStream.close();
            trimLines(targetLocation, 4, 2);
        } catch (Exception e) {
            throw new DumpFailedException(sourceDatabase.toString(), targetLocation.toString(), e);
        }
    }

    @Override
    public void execute(String statement, CommandLine cmd) {
        throw new UnsupportedOperationException();
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
