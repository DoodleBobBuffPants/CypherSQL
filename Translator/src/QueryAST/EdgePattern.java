package QueryAST;

public class EdgePattern extends Pattern {
	private boolean directed = true;
	private boolean leftSrc;
	private String variable;
	private String type;
	private boolean starredEdge;
	private int starLength;
	
	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

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

	public boolean isStarredEdge() {
		return starredEdge;
	}

	public void setStarredEdge(boolean starredEdge) {
		this.starredEdge = starredEdge;
	}

	public int getStarLength() {
		return starLength;
	}

	public void setStarLength(int starLength) {
		this.starLength = starLength;
	}
}