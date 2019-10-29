package QueryTranslator;

import java.util.Stack;

import antlr4.CypherParser;

public class SchemaListener extends antlr4.CypherBaseListener {
	private Stack<String> terminalStack = new Stack<String>();
	private CreateNode createNode = new CreateNode();
	
	public CreateNode getCreateNode() {
		return createNode;
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
		terminalStack.push(removeQuotes(ctx.getChild(0).getText()));	
	}
	
	@Override
	public void enterOC_MapLiteral(CypherParser.OC_MapLiteralContext ctx) {
		terminalStack.push("ENTER MAP");	
	}
	
	@Override
	public void exitOC_Create(CypherParser.OC_CreateContext ctx) {
		while(!terminalStack.peek().equals("ENTER MAP")) {
			String value = terminalStack.pop();
			String key = terminalStack.pop();
			
			createNode.addColumnValues(key, value);
		}
		terminalStack.pop();
		createNode.setLabel(terminalStack.pop());
		createNode.setId(terminalStack.pop());
	}
}