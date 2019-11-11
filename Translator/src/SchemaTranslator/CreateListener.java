package SchemaTranslator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import SchemaAST.Create;
import SchemaAST.CreateEdge;
import SchemaAST.CreateNode;
import antlr4.CypherParser;

public class CreateListener extends antlr4.CypherBaseListener {
	private Stack<Create> createStack = new Stack<Create>();
	private Stack<Object> terminalStack = new Stack<Object>();
	private Map<String, Map<String, Object>> labelTables = new HashMap<String, Map<String, Object>>();
	private Map<String, Map<String, Object>> typeTables = new HashMap<String, Map<String, Object>>();
	private CreateNode createNode;
	private CreateEdge createEdge;
	private boolean hasEdge;
	private boolean leftRight;
	
	public Stack<Create> getCreateStack() {
		return createStack;
	}
	
	public Map<String, Map<String, Object>> getLabelTables() {
		return new HashMap<String, Map<String, Object>>(labelTables);
	}
	
	public Map<String, Map<String, Object>> getTypeTables() {
		return new HashMap<String, Map<String, Object>>(typeTables);
	}
	
	private String removeQuotes(String unformattedString) {
		return unformattedString.replace("\\\"","<3").replace("\\`", "<4").replace("\\'", "<5")
								.replace("\"", "").replace("`", "").replace("'", "")
								.replace("<3", "\\\"").replace("<4", "\\`").replace("<5", "\\'");
	}
	
	@Override
	public void exitOC_SymbolicName(CypherParser.OC_SymbolicNameContext ctx) {
		terminalStack.push(new String(removeQuotes(ctx.getChild(0).getText())));	
	}
	
	@Override
	public void exitOC_Literal(CypherParser.OC_LiteralContext ctx) {
		if (ctx.oC_NumberLiteral() != null && ctx.oC_NumberLiteral().oC_IntegerLiteral() != null) {
			terminalStack.push(Integer.parseInt(ctx.getChild(0).getText()));
		} else if (ctx.oC_ListLiteral() != null) {
			//Do not process lists here
		} else {
			terminalStack.push(new String(removeQuotes(ctx.getChild(0).getText())));
		}
	}
	
	@Override
	public void enterOC_ListLiteral(CypherParser.OC_ListLiteralContext ctx) {
		terminalStack.push("ENTER LIST");	
	}
	
	@Override
	public void exitOC_ListLiteral(CypherParser.OC_ListLiteralContext ctx) {
		terminalStack.push("EXIT LIST");	
	}
	
	@Override
	public void enterOC_NodeLabels(CypherParser.OC_NodeLabelsContext ctx) {
		terminalStack.push("ENTER NODE LABELS");	
	}
	
	@Override
	public void exitOC_NodeLabels(CypherParser.OC_NodeLabelsContext ctx) {
		terminalStack.push("EXIT NODE LABELS");	
	}
	
	@Override
	public void enterOC_MapLiteral(CypherParser.OC_MapLiteralContext ctx) {
		terminalStack.push("ENTER MAP");	
	}
	
	@Override
	public void exitOC_MapLiteral(CypherParser.OC_MapLiteralContext ctx) {
		terminalStack.push("EXIT MAP");	
	}
	
	@Override
	public void enterOC_PatternElement(CypherParser.OC_PatternElementContext ctx) {
		hasEdge = false;
	}
	
	@Override
	public void exitOC_PatternElement(CypherParser.OC_PatternElementContext ctx) {
		if (hasEdge) {
			if (leftRight) {
				createEdge.setTargetID(((CreateNode) createStack.pop()).getId());
				createEdge.setSourceID(((CreateNode) createStack.pop()).getId());
			} else {
				createEdge.setSourceID(((CreateNode) createStack.pop()).getId());
				createEdge.setTargetID(((CreateNode) createStack.pop()).getId());
			}
			createStack.push(createEdge);
		}
	}
	
	@Override
	public void enterOC_RelationshipPattern(CypherParser.OC_RelationshipPatternContext ctx) {
		hasEdge = true;
		createEdge = new CreateEdge();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void exitOC_RelationshipPattern(CypherParser.OC_RelationshipPatternContext ctx) {
		leftRight = (ctx.oC_LeftArrowHead() == null);
		processMapLiteral(createEdge);
		createEdge.setType(new String(terminalStack.pop().toString()));
		
		Map<String, Object> newColumns = createEdge.getColumnValueMap();
		String type = createEdge.getType();
		Map<String, Object> columns = typeTables.get(type);
		if (columns == null) {
			columns = new HashMap<String, Object>();
		}
		for (String key : newColumns.keySet()) {
			if (!columns.keySet().contains(key)) {
				Object value = newColumns.get(key);
				if (value instanceof Integer) {
					columns.put(key, Integer.parseInt(value.toString()));
				} else if (value instanceof String) {
					columns.put(key, value.toString());
				} else if (value instanceof List<?> && ((List<?>) value).get(0) instanceof Integer) {
					columns.put(key, new ArrayList<Integer>((List<Integer>) value));
				} else {
					columns.put(key, new ArrayList<String>((List<String>) value));
				}
			}
		}
		typeTables.put(type, columns);
	}
	
	@Override
	public void enterOC_NodePattern(CypherParser.OC_NodePatternContext ctx) {
		createNode = new CreateNode();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void exitOC_NodePattern(CypherParser.OC_NodePatternContext ctx) {
		processMapLiteral(createNode);
		if (terminalStack.peek().toString().equals("EXIT NODE LABELS")) {
			terminalStack.pop();
			while(!terminalStack.peek().toString().equals("ENTER NODE LABELS")) {
				createNode.addLabel(new String(terminalStack.pop().toString()));
			}
			terminalStack.pop();
		}
		createNode.setId(Integer.parseInt(terminalStack.pop().toString().substring(1)));
		createStack.push(createNode);
		
		Map<String, Object> newColumns = createNode.getColumnValueMap();
		if (newColumns.size() > 0) {
			String label = createNode.getLabelList().get(0);
			Map<String, Object> columns = labelTables.get(label);
			if (columns == null) {
				columns = new HashMap<String, Object>();
			}
			for (String key : newColumns.keySet()) {
				if (!columns.keySet().contains(key)) {
					Object value = newColumns.get(key);
					if (value instanceof Integer) {
						columns.put(key, Integer.parseInt(value.toString()));
					} else if (value instanceof String) {
						columns.put(key, value.toString());
					} else if (value instanceof List<?> && ((List<?>) value).get(0) instanceof Integer) {
						columns.put(key, new ArrayList<Integer>((List<Integer>) value));
					} else {
						columns.put(key, new ArrayList<String>((List<String>) value));
					}
				}
			}
			labelTables.put(label, columns);
		}
	}
	
	private void processMapLiteral(Create create) {
		if (terminalStack.peek().toString().equals("EXIT MAP")) {
			terminalStack.pop();
			while(!terminalStack.peek().toString().equals("ENTER MAP")) {
				Object top = terminalStack.pop();
				
				if (top instanceof Integer) {
					String column = terminalStack.pop().toString();
					create.addColumnValue(column, Integer.valueOf(((Integer) top).intValue()));
				} else if (top.toString().equals("EXIT LIST")) { 
					List<Object> list = new ArrayList<Object>();
					while(!terminalStack.peek().toString().equals("ENTER LIST")) {
						list.add(terminalStack.pop());
					}
					terminalStack.pop();
					String column = terminalStack.pop().toString();
					if (list.stream().allMatch(e -> e instanceof Integer)) {
						create.addColumnValue(column, new ArrayList<Integer>(list.stream().map(e -> (Integer) e).collect(Collectors.toList())));
					} else {
						create.addColumnValue(column, new ArrayList<String>(list.stream().map(e -> e.toString()).collect(Collectors.toList())));
					}
				} else {
					String column = terminalStack.pop().toString();
					create.addColumnValue(column, new String(top.toString()));
				}
			}
			terminalStack.pop();
		}
	}
}