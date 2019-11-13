package QueryAST;

public class OrderBy {
	private String field;
	private String ascdesc;
	
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