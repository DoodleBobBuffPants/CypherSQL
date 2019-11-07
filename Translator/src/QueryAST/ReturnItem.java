package QueryAST;

public class ReturnItem {
	private String functionName;
	private String functionArgument;
	private String toReturn;
	private String alias;
	
	public String getFunctionName() {
		return functionName;
	}
	
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	public String getFunctionArgument() {
		return functionArgument;
	}
	
	public void setFunctionArgument(String functionArgument) {
		this.functionArgument = functionArgument;
	}
	
	public String getToReturn() {
		return toReturn;
	}
	
	public void setToReturn(String toReturn) {
		this.toReturn = toReturn;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
}