package QueryTranslator;

import java.util.Stack;

import antlr4.CypherParser;

public class CreateListener extends antlr4.CypherBaseListener {
	private Stack<CreateNode> createNodeStack = new Stack<CreateNode>();
	private Stack<Object> terminalStack = new Stack<Object>();
	private CreateNode createNode;
	
	public Stack<CreateNode> getCreateNodeStack() {
		return createNodeStack;
	}
	
	private String removeQuotes(String unformattedString) {
		return unformattedString.replace("\"", "").replace("`", "").replace("'", "");
	}
	
	@Override
	public void exitOC_SymbolicName(CypherParser.OC_SymbolicNameContext ctx) {
		terminalStack.push(removeQuotes(ctx.getChild(0).getText()));	
	}
	
	@Override
	public void exitOC_Literal(CypherParser.OC_LiteralContext ctx) {
		if (ctx.oC_NumberLiteral() != null && ctx.oC_NumberLiteral().oC_IntegerLiteral() != null) {
			terminalStack.push(Integer.parseInt(ctx.getChild(0).getText()));
		} else {
			terminalStack.push(removeQuotes(ctx.getChild(0).getText()));
		}
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
	public void enterOC_NodePattern(CypherParser.OC_NodePatternContext ctx) {
		createNode = new CreateNode();
	}
	
	@Override
	public void exitOC_NodePattern(CypherParser.OC_NodePatternContext ctx) {
		if (terminalStack.peek().toString().equals("EXIT MAP")) {
			terminalStack.pop();
			while(!terminalStack.peek().toString().equals("ENTER MAP")) {
				Object value = terminalStack.pop();
				String column = (String) terminalStack.pop();
				
				if (value instanceof Integer) {
					createNode.addColumnValue(column, (Integer) value);
				} else {
					createNode.addColumnValue(column, (String) value);
				}
			}
			terminalStack.pop();
		}
		if (terminalStack.peek().toString().equals("EXIT NODE LABELS")) {
			terminalStack.pop();
			while(!terminalStack.peek().toString().equals("ENTER NODE LABELS")) {
				createNode.addLabel(terminalStack.pop().toString());
			}
			terminalStack.pop();
		}
		createNode.setId(terminalStack.pop().toString());
		createNodeStack.push(createNode);
	}
}