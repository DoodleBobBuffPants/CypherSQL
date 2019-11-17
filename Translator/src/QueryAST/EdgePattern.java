package QueryAST;

public class EdgePattern extends Pattern {
	private boolean leftSrc;
	private String variable;
	private String type;
	
	public boolean isLeftSrc() {
		return leftSrc;
	}

	public void setLeftSrc(boolean leftSrc) {
		this.leftSrc = leftSrc;
	}
	
	public String getVariable() {
		return variable;
	}
	
	public void setVariable(String variable) {
		this.variable = variable;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}