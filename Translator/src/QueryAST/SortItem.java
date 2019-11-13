package QueryAST;

public class SortItem {
	private String functionName;
	private String functionArgument;
	private String field;
	private String ascdesc;
	
	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionArgument() {
		return functionArgument;
	}

	public void setFunctionArgument(String functionArg) {
		this.functionArgument = functionArg;
	}

	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
	public String getAscdesc() {
		return ascdesc;
	}
	
	public void setAscdesc(String ascdesc) {
		this.ascdesc = ascdesc;
	}
}