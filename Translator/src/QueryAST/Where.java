package QueryAST;

import java.util.ArrayList;
import java.util.List;

public class Where {
	private List<WhereExpression> andExpressions = new ArrayList<WhereExpression>();

	public List<WhereExpression> getAndExpressions() {
		return andExpressions;
	}

	public void addAndExpression(WhereExpression whereExpression) {
		this.andExpressions.add(whereExpression);
	}
}