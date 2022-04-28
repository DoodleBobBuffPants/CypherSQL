package cyphersql.listener;

import cyphersql.antlr.CypherParser.*;
import cyphersql.ast.create.Create;
import cyphersql.ast.create.CreateEdge;
import cyphersql.ast.create.CreateNode;
import cyphersql.ast.terminal.SymbolLiteralTerminal;
import cyphersql.ast.terminal.Terminal;
import cyphersql.ast.terminal.Terminals;

import java.util.*;

public class CypherCreateListener extends CypherQueryListener {
    public final Stack<Create> creates = new Stack<>();
    public final Stack<Terminal> terminals = new Stack<>();
    public final Map<String, Map<String, String>> labelTables = new HashMap<>();
    public final Map<String, Map<String, String>> typeTables = new HashMap<>();
    private CreateNode node;
    private CreateEdge edge;
    private EdgeDirection edgeDirection = EdgeDirection.NONE;

    @Override
    public void enterOC_PatternElement(OC_PatternElementContext ctx) {
        edgeDirection = EdgeDirection.NONE;
    }

    @Override
    public void exitOC_PatternElement(OC_PatternElementContext ctx) {
        if (edgeDirection == EdgeDirection.LEFT_RIGHT) {
            edge.targetID = ((CreateNode) creates.pop()).id;
            edge.sourceID = ((CreateNode) creates.pop()).id;
            creates.push(edge);
        } else if (edgeDirection == EdgeDirection.RIGHT_LEFT) {
            edge.sourceID = ((CreateNode) creates.pop()).id;
            edge.targetID = ((CreateNode) creates.pop()).id;
            creates.push(edge);
        }
    }

    @Override
    public void enterOC_NodePattern(OC_NodePatternContext ctx) {
        node = new CreateNode();
    }

    @Override
    public void exitOC_NodePattern(OC_NodePatternContext ctx) {
        if (terminals.peek() == Terminals.EXIT_MAP) {
            readMapLiteralFromTerminals(node);
        }
        if (terminals.peek() == Terminals.EXIT_NODE_LABELS) {
            terminals.pop();
            while (terminals.peek() != Terminals.ENTER_NODE_LABELS) {
                node.labels.add(terminals.pop().getValue().getRawValue());
            }
            terminals.pop();
        }
        node.id = Integer.parseInt(terminals.pop().getValue().getRawValue().substring(1));
        creates.push(node);
        addNewColumnsToExisting(node.fields, labelTables, node.labels.isEmpty() ? null : node.labels.get(0));
    }

    @Override
    public void enterOC_RelationshipPattern(OC_RelationshipPatternContext ctx) {
        edge = new CreateEdge();
    }

    @Override
    public void exitOC_RelationshipPattern(OC_RelationshipPatternContext ctx) {
        edgeDirection = ctx.oC_LeftArrowHead() == null ? EdgeDirection.LEFT_RIGHT : EdgeDirection.RIGHT_LEFT;
        if (terminals.peek() == Terminals.EXIT_MAP) {
            readMapLiteralFromTerminals(edge);
        }
        edge.type = terminals.pop().getValue().getRawValue();
        addNewColumnsToExisting(edge.fields, typeTables, edge.type);
    }

    @Override
    public void enterOC_NodeLabels(OC_NodeLabelsContext ctx) {
        terminals.push(Terminals.ENTER_NODE_LABELS);
    }

    @Override
    public void exitOC_NodeLabels(OC_NodeLabelsContext ctx) {
        terminals.push(Terminals.EXIT_NODE_LABELS);
    }

    @Override
    public void exitOC_Literal(OC_LiteralContext ctx) {
        if (ctx.oC_NumberLiteral() != null && ctx.oC_NumberLiteral().oC_IntegerLiteral() != null) {
            terminals.push(new SymbolLiteralTerminal(Integer.parseInt(ctx.getChild(0).getText())));
        } else if (ctx.oC_ListLiteral() == null) {
            terminals.push(new SymbolLiteralTerminal(ctx.getChild(0).getText()));
        }
    }

    @Override
    public void enterOC_ListLiteral(OC_ListLiteralContext ctx) {
        terminals.push(Terminals.ENTER_LIST);
    }

    @Override
    public void exitOC_ListLiteral(OC_ListLiteralContext ctx) {
        terminals.push(Terminals.EXIT_LIST);
    }

    @Override
    public void enterOC_MapLiteral(OC_MapLiteralContext ctx) {
        terminals.push(Terminals.ENTER_MAP);
    }

    @Override
    public void exitOC_MapLiteral(OC_MapLiteralContext ctx) {
        terminals.push(Terminals.EXIT_MAP);
    }

    @Override
    public void exitOC_SymbolicName(OC_SymbolicNameContext ctx) {
        terminals.push(new SymbolLiteralTerminal(ctx.getChild(0).getText()));
    }

    private void readMapLiteralFromTerminals(Create create) {
        terminals.pop();
        while (terminals.peek() != Terminals.ENTER_MAP) {
            Terminal top = terminals.pop();
            if (top instanceof SymbolLiteralTerminal) {
                create.fields.put(terminals.pop().getValue().getRawValue(), top.getValue().toString());
            } else if (top == Terminals.EXIT_LIST) {
                List<String> list = new ArrayList<>();
                while (terminals.peek() != Terminals.ENTER_LIST) {
                    list.add(terminals.pop().getValue().toString());
                }
                terminals.pop();
                create.fields.put(terminals.pop().getValue().getRawValue(), String.join(",", list));
            }
        }
        terminals.pop();
    }

    private void addNewColumnsToExisting(Map<String, String> columnsToCheck, Map<String, Map<String, String>> existingColumns, String existingIndex) {
        if (columnsToCheck.isEmpty()) {
            return;
        }
        Map<String, String> columns = existingColumns.getOrDefault(existingIndex, new HashMap<>());
        for (String key : columnsToCheck.keySet()) {
            if (!columns.containsKey(key)) {
                columns.put(key, columnsToCheck.get(key));
            }
        }
        existingColumns.put(existingIndex, columns);
    }

    private enum EdgeDirection {
        NONE, LEFT_RIGHT, RIGHT_LEFT
    }
}
