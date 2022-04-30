package cyphersql.listener;

import cyphersql.CypherTranslator;
import cyphersql.ast.EdgeDirection;
import cyphersql.ast.match.Query;
import cyphersql.ast.match.orderby.OrderByItem;
import cyphersql.ast.match.pattern.EdgePattern;
import cyphersql.ast.match.pattern.NodePattern;
import cyphersql.ast.match.pattern.Pattern;
import cyphersql.ast.match.returnclause.ReturnItem;
import cyphersql.ast.match.where.WhereArgument;
import cyphersql.ast.match.where.WhereCondition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CypherMatchListenerTest {
    private final CypherTranslator translator = new CypherTranslator();
    private Query query;

    @Test
    public void parsesNode() {
        String cypher = "MATCH (n) RETURN count(*) AS count";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        List<Pattern> patterns = query.matchClause.patternList;
        assertEquals(1, patterns.size());
        assertNode(patterns.get(0), "n", null);
        assertReturn(query.returnClause.returnItems.get(0), null, null, "count(*)", "count");
    }

    private CypherMatchListener assertListenerIsMatchListener(CypherQueryListener listener) {
        if (listener instanceof CypherMatchListener matchListener) {
            return matchListener;
        }
        return fail("Expected listener to be " + CypherMatchListener.class.getSimpleName() + " but was " + listener.getClass().getSimpleName());
    }

    private void assertNode(Pattern pattern, String variable, String label) {
        if (pattern instanceof NodePattern node) {
            assertEquals(variable, node.variable);
            assertEquals(label, node.label);
        } else {
            fail("Pattern expected to be " + NodePattern.class.getSimpleName() + " but was " + pattern.getClass().getSimpleName());
        }
    }

    private void assertReturn(ReturnItem returnItem, String function, String functionArgument, String value, String alias) {
        assertEquals(function, returnItem.function);
        assertEquals(functionArgument, returnItem.functionArgument);
        assertEquals(value, returnItem.value);
        assertEquals(alias, returnItem.alias);
    }

    @Test
    public void parsesNodeWithLabel() {
        String cypher = "MATCH (n:Character) RETURN labels(n) AS labels";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        List<Pattern> patterns = query.matchClause.patternList;
        List<ReturnItem> returnItems = query.returnClause.returnItems;
        assertEquals(1, patterns.size());
        assertEquals(1, returnItems.size());
        assertNode(patterns.get(0), "n", "Character");
        assertReturn(returnItems.get(0), "labels", "n", "labels(n)", "labels");
    }

    @Test
    public void parsesEdge() {
        String cypher = "MATCH ()-[r]->() RETURN count(*) AS count";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        List<Pattern> patterns = query.matchClause.patternList;
        assertEquals(3, patterns.size());
        assertNode(patterns.get(0), null, null);
        assertEdge(patterns.get(1), "r", null, EdgeDirection.LEFT_RIGHT);
        assertNode(patterns.get(2), null, null);
        assertReturn(query.returnClause.returnItems.get(0), null, null, "count(*)", "count");
    }

    private void assertEdge(Pattern pattern, String variable, String type, EdgeDirection direction) {
        assertEdge(pattern, variable, type, direction, false, 0);
    }

    private void assertEdge(Pattern pattern, String variable, String type, EdgeDirection direction, boolean starredEdge, int starLength) {
        if (pattern instanceof EdgePattern edge) {
            assertEquals(variable, edge.variable);
            assertEquals(type, edge.type);
            assertEquals(direction, edge.direction);
            assertEquals(starredEdge, edge.starredEdge);
            assertEquals(starLength, edge.starLength);
        } else {
            fail("Pattern expected to be " + EdgePattern.class.getSimpleName() + " but was " + pattern.getClass().getSimpleName());
        }
    }

    @Test
    public void parsesEdgeWithType() {
        String cypher = "MATCH (m)-[r:INTERACTS]->(n) RETURN type(r) as type";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        List<Pattern> patterns = query.matchClause.patternList;
        List<ReturnItem> returnItems = query.returnClause.returnItems;
        assertEquals(3, patterns.size());
        assertEquals(1, returnItems.size());
        assertNode(patterns.get(0), "m", null);
        assertEdge(patterns.get(1), "r", "INTERACTS", EdgeDirection.LEFT_RIGHT);
        assertNode(patterns.get(2), "n", null);
        assertReturn(returnItems.get(0), "type", "r", "type(r)", "type");
    }

    @Test
    public void parsesWhere() {
        String cypher = "MATCH (m)-[r:INTERACTS]->(n) WHERE ID(m) = 325 AND ID(n) = 490 RETURN r.weight AS weight";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        List<WhereCondition> whereConditions = query.whereClause.andConditions;
        assertEquals(2, whereConditions.size());
        assertWhereArgument(whereConditions.get(0).leftArgument, "ID", "m", "ID(m)");
        assertWhereArgument(whereConditions.get(0).rightArgument, null, null, "325");
        assertWhereArgument(whereConditions.get(1).leftArgument, "ID", "n", "ID(n)");
        assertWhereArgument(whereConditions.get(1).rightArgument, null, null, "490");
        assertEquals("=", whereConditions.get(0).comparisonOperator);
        assertEquals("=", whereConditions.get(1).comparisonOperator);
    }

    private void assertWhereArgument(WhereArgument whereArgument, String function, String functionArgument, String literal) {
        assertEquals(function, whereArgument.function);
        assertEquals(functionArgument, whereArgument.functionArgument);
        assertEquals(literal, whereArgument.literal);
    }

    @Test
    public void parsesOrderByLimit() {
        String cypher = "MATCH (n:Character) RETURN n.name AS name ORDER BY n.name DESC LIMIT 5";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        OrderByItem orderByItem = query.orderByClause.orderByItems.get(0);
        assertEquals("n.name", orderByItem.field);
        assertEquals("DESC", orderByItem.direction);
        assertEquals(5, query.limitClause.limit);
    }

    @Test
    public void parsesDistinct() {
        String cypher = "MATCH (n) RETURN DISTINCT labels(n) AS labels";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        assertTrue(query.returnClause.isDistinct);
    }

    @Test
    public void parsesCountDistinct() {
        String cypher = "MATCH (n) RETURN count(DISTINCT labels(n)) AS count";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        assertEquals("count(DISTINCT labels(n))", query.returnClause.returnItems.get(0).value);
    }

    @Test
    public void parsesMultipleNodes() {
        String cypher = "MATCH (n:Character), (m:Character) RETURN n.name AS name1, m.name AS name2";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        assertEquals(2, query.matchClause.patternList.size());
        assertNode(query.matchClause.patternList.get(0), "n", "Character");
        assertNode(query.matchClause.patternList.get(1), "m", "Character");
    }

    @Test
    public void parsesMultipleEdges() {
        String cypher = "MATCH (m:Character)<-[r:INTERACTS]-(n:Character)-[s:INTERACTS]->(o:Character) RETURN n.name AS name";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        assertEquals(5, query.matchClause.patternList.size());
        assertEdge(query.matchClause.patternList.get(1), "r", "INTERACTS", EdgeDirection.RIGHT_LEFT);
        assertEdge(query.matchClause.patternList.get(3), "s", "INTERACTS", EdgeDirection.LEFT_RIGHT);
    }

    @Test
    public void parsesWith() {
        String cypher = "MATCH (m:Character)<-[r:INTERACTS]-(n:Character)-[s:INTERACTS]->(o:Character) WHERE ID(m) <> ID(o) WITH p.name AS name, count(*) AS total WHERE total > 10 RETURN name, total";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        assertEquals(2, query.returnClause.returnItems.size());
        assertReturn(query.returnClause.returnItems.get(0), null, null, "p.name", "name");
        assertReturn(query.returnClause.returnItems.get(1), null, null, "count(*)", "total");
    }

    @Test
    public void parsesBidirectionalEdge() {
        String cypher = "MATCH (p:Character)-[:INTERACTS]-(q:Character) WHERE ID(p) = 47 RETURN q.name AS name";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        assertEdge(query.matchClause.patternList.get(1), null, "INTERACTS", EdgeDirection.BIDIRECTIONAL);
    }

    @Test
    public void parsesStarOperator() {
        String cypher = "MATCH (p:Character)-[r:INTERACTS*2]-(q:Character) WHERE ID(p) = 325 RETURN q.name AS name";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        assertEdge(query.matchClause.patternList.get(1), "r", "INTERACTS", EdgeDirection.BIDIRECTIONAL, true, 2);
    }

    @Test
    public void parsesAllShortestPaths() {
        String cypher = "MATCH path = allshortestpaths((p:Character)-[:INTERACTS*]-(q:Character)) WHERE p.name = 'Jon-Snow' AND q.name = 'Dareon' RETURN length(path)";
        query = assertListenerIsMatchListener(translator.listen(cypher)).query;
        assertTrue(query.matchClause.allShortestPaths);
        assertEquals("path", query.matchClause.pathVariable);
    }
}
