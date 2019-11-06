package QueryTranslator;

import QueryAST.Match;
import QueryAST.Query;
import QueryAST.Return;
import QueryAST.SinglePartQuery;
import antlr4.CypherParser;

public class QueryListener extends antlr4.CypherBaseListener {
	private Query query;
	private SinglePartQuery singlePartQuery;
	private Match matchClause;
	private Return returnClause;
	
	public Query getQuery() {
		return query;
	}
	
	@Override
	public void exitOC_Query(CypherParser.OC_QueryContext ctx) {
		query = singlePartQuery;
	}
	
	@Override
	public void enterOC_SinglePartQuery(CypherParser.OC_SinglePartQueryContext ctx) {
		singlePartQuery = new SinglePartQuery();
	}
	
	@Override
	public void exitOC_SinglePartQuery(CypherParser.OC_SinglePartQueryContext ctx) {
		singlePartQuery.setMatchClause(matchClause);
		singlePartQuery.setReturnClause(returnClause);
	}
	
	@Override
	public void enterOC_Match(CypherParser.OC_MatchContext ctx) {
		matchClause = new Match();
	}
	
	@Override
	public void exitOC_Match(CypherParser.OC_MatchContext ctx) {
		
	}
	
	@Override
	public void enterOC_Return(CypherParser.OC_ReturnContext ctx) {
		returnClause = new Return();
	}
	
	@Override
	public void exitOC_Return(CypherParser.OC_ReturnContext ctx) {
		
	}
}