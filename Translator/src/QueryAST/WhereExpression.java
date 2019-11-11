package QueryAST;

public class WhereExpression {
	private String leftFunctionName;
	private String leftFunctionArgument;
	private String leftLiteral;
	private String comparisonOperator;
	private String rightFunctionName;
	private String rightFunctionArgument;
	private String rightLiteral;
	
	public String getLeftFunctionName() {
		return leftFunctionName;
	}
	
	public void setLeftFunctionName(String functionName) {
		this.leftFunctionName = functionName;
	}
	
	public String getLeftFunctionArgument() {
		return leftFunctionArgument;
	}
	
	public void setLeftFunctionArgument(String functionArgument) {
		this.leftFunctionArgument = functionArgument;
	}

	public String getLeftLiteral() {
		return leftLiteral;
	}

	public void setLeftLiteral(String leftLiteral) {
		this.leftLiteral = leftLiteral;
	}

	public String getComparisonOperator() {
		return comparisonOperator;
	}

	public void setComparisonOperator(String comparisonOperator) {
		this.comparisonOperator = comparisonOperator;
	}

	public String getRightFunctionName() {
		return rightFunctionName;
	}

	public void setRightFunctionName(String rightFunctionName) {
		this.rightFunctionName = rightFunctionName;
	}

	public String getRightFunctionArgument() {
		return rightFunctionArgument;
	}

	public void setRightFunctionArgument(String rightFunctionArgument) {
		this.rightFunctionArgument = rightFunctionArgument;
	}

	public String getRightLiteral() {
		return rightLiteral;
	}

	public void setRightLiteral(String rightLiteral) {
		this.rightLiteral = rightLiteral;
	}
}