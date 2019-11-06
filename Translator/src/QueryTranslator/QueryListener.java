package QueryTranslator;

import QueryAST.Match;
import QueryAST.NodePattern;
import QueryAST.Query;
import QueryAST.Return;
import antlr4.CypherParser;

public class QueryListener extends antlr4.CypherBaseListener {
	private Query query;
	private Match matchClause;
	private Return returnClause;
	private NodePattern nodePattern;
	
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
		
	}
	
	@Override
	public void enterOC_Return(CypherParser.OC_ReturnContext ctx) {
		returnClause = new Return();
	}
	
	@Override
	public void exitOC_Return(CypherParser.OC_ReturnContext ctx) {
		
	}
}