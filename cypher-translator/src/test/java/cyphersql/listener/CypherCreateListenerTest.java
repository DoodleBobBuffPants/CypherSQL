package cyphersql.listener;

import cyphersql.CypherTranslator;
import cyphersql.ast.create.Create;
import cyphersql.ast.create.CreateEdge;
import cyphersql.ast.create.CreateNode;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CypherCreateListenerTest {
    private static final String CREATE_NODE_QUERY = "CREATE (_0: `Movie` {`released`: 1999, `tagline`: \"Welcome to the Real World\", `title`: \"The Matrix\"})";
    private static final String CREATE_EDGE_QUERY = "CREATE (_170)-[: `REVIEWED` {`rating`: 65, `summary`: \"Fun, but a little far fetched\"}]->(_111)";
    private final CypherTranslator translator = new CypherTranslator();
    private CypherCreateListener listener;

    @Test
    public void parsesNode() {
        listener = assertListenerIsCreateListener(translator.listen(CREATE_NODE_QUERY));
        CreateNode node = assertCreateIsCreateNode(listener.creates.pop());
        assertEquals(0, node.id);
    }

    private CypherCreateListener assertListenerIsCreateListener(CypherQueryListener listener) {
        if (listener instanceof CypherCreateListener createListener) return createListener;
        return fail("Expected listener to be " + CypherCreateListener.class.getSimpleName() + " but was " + listener.getClass().getSimpleName());
    }

    private CreateNode assertCreateIsCreateNode(Create create) {
        if (create instanceof CreateNode createNode) return createNode;
        return fail("Expected create object to be " + CreateNode.class.getSimpleName() + " but was " + create.getClass().getSimpleName());
    }

    @Test
    public void parsesEdge() {
        listener = assertListenerIsCreateListener(translator.listen(CREATE_EDGE_QUERY));
        CreateEdge edge = assertCreateIsCreateEdge(listener.creates.pop());
        assertEquals(170, edge.sourceID);
        assertEquals(111, edge.targetID);
    }

    private CreateEdge assertCreateIsCreateEdge(Create create) {
        if (create instanceof CreateEdge createEdge) return createEdge;
        return fail("Expected create object to be " + CreateEdge.class.getSimpleName() + " but was " + create.getClass().getSimpleName());
    }

    @Test
    public void parsesLabels() {
        listener = assertListenerIsCreateListener(translator.listen(CREATE_NODE_QUERY));
        Map<String, Map<String, String>> labelTables = listener.labelTables;
        assertTrue(labelTables.containsKey("Movie"), "Actual label tables: " + labelTables);
        assertTrue(labelTables.containsValue(Map.of("released", "1999", "tagline", "\"Welcome to the Real World\"", "title", "\"The Matrix\"")), "Actual label tables: " + labelTables);
    }

    @Test
    public void parsesTypes() {
        listener = assertListenerIsCreateListener(translator.listen(CREATE_EDGE_QUERY));
        Map<String, Map<String, String>> typeTables = listener.typeTables;
        assertTrue(typeTables.containsKey("REVIEWED"), "Actual type tables: " + typeTables);
        assertTrue(typeTables.containsValue(Map.of("rating", "65", "summary", "\"Fun, but a little far fetched\"")), "Actual type tables: " + typeTables);
    }
}
