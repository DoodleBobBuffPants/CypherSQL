package QueryAST;

public class Query {
	private Match matchClause;
	private Where whereClause;
	private Return returnClause;
	private Limit limitClause;
	
	public Match getMatchClause() {
		return matchClause;
	}
	
	public void setMatchClause(Match matchClause) {
		this.matchClause = matchClause;
	}
	
	public Where getWhereClause() {
		return whereClause;
	}

	public void setWhereClause(Where whereClause) {
		this.whereClause = whereClause;
	}

	public Return getReturnClause() {
		return returnClause;
	}
	
	public void setReturnClause(Return returnClause) {
		this.returnClause = returnClause;
	}

	public Limit getLimitClause() {
		return limitClause;
	}

	public void setLimitClause(Limit limitClause) {
		this.limitClause = limitClause;
	}
}