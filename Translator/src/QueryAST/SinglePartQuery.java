package QueryAST;

public class SinglePartQuery extends Query {
	private Match matchClause;
	private Return returnClause;
	
	public Match getMatchClause() {
		return matchClause;
	}
	
	public void setMatchClause(Match matchClause) {
		this.matchClause = matchClause;
	}
	
	public Return getReturnClause() {
		return returnClause;
	}
	
	public void setReturnClause(Return returnClause) {
		this.returnClause = returnClause;
	}
}