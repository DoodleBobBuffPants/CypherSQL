package cyphersql;

import cyphersql.api.exception.TranslationFailedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    private static final String MATCH_QUERY = "MATCH (n) RETURN count(*) AS count";
    private static final String CREATE_QUERY = "CREATE (_0: `Movie` {`released`: 1999, `tagline`: \"Welcome to the Real World\", `title`: \"The Matrix\"})";

    @Test
    public void translatesMatchQuery() {
        assertThrows(TranslationFailedException.class, () ->
                Main.main(new String[] { "-translate", "-query", MATCH_QUERY, "-source", "neo4j", "-target", "postgresql" }));
    }

    @Test
    public void translatesCreateQuery() {
        assertThrows(TranslationFailedException.class, () ->
                Main.main(new String[] { "-translate", "-query", CREATE_QUERY, "-source", "neo4j", "-target", "postgresql" }));
    }
}
