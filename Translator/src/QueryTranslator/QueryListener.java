package QueryTranslator;

import QueryAST.Match;
import QueryAST.NodePattern;
import QueryAST.Query;
import QueryAST.Return;
import QueryAST.ReturnItem;
import antlr4.CypherParser;

public class QueryListener extends antlr4.CypherBaseListener {
	private Query query;
	private Match matchClause;
	private Return returnClause;
	private NodePattern nodePattern;
	private ReturnItem returnItem;
	
	public Query getQuery() {
		return query;
	}
	
	@Override
	public void enterOC_Query(CypherParser.OC_QueryContext ctx) {
		query = new Query();
	}
	
	@Override
	public void exitOC_Query(CypherParser.OC_QueryContext ctx) {
		query.setMatchClause(matchClause);
		query.setReturnClause(returnClause);
	}
	
	@Override
	public void enterOC_Match(CypherParser.OC_MatchContext ctx) {
		matchClause = new Match();
	}
	
	@Override
	public void exitOC_Match(CypherParser.OC_MatchContext ctx) {
		if (nodePattern != null) {
			matchClause.setPattern(nodePattern);
		}
	}
	
	@Override
	public void enterOC_NodePattern(CypherParser.OC_NodePatternContext ctx) {
		nodePattern = new NodePattern();
	}
	
	@Override
	public void exitOC_NodePattern(CypherParser.OC_NodePatternContext ctx) {
		nodePattern.setVariable(ctx.oC_Variable().getText());
		if (ctx.oC_NodeLabels() != null) {
			nodePattern.setLabel(ctx.oC_NodeLabels().oC_NodeLabel(0).getText());
		}
	}
	
	@Override
	public void enterOC_Return(CypherParser.OC_ReturnContext ctx) {
		returnClause = new Return();
	}
	
	@Override
	public void enterOC_ReturnItem(CypherParser.OC_ReturnItemContext ctx) {
		returnItem = new ReturnItem();
	}
	
	@Override
	public void exitOC_FunctionInvocation(CypherParser.OC_FunctionInvocationContext ctx) {
		returnItem.setFunctionName(ctx.oC_FunctionName().getText());
		returnItem.setFunctionArgument(ctx.oC_Expression(0).getText());
	}
	
	@Override
	public void exitOC_ReturnItem(CypherParser.OC_ReturnItemContext ctx) {
		returnItem.setToReturn(ctx.oC_Expression().getText());
		if (ctx.getChild(2).getText().equals("AS")) {
			returnItem.setAlias(ctx.getChild(4).getText());
		}
		returnClause.addReturnItem(returnItem);
	}
}