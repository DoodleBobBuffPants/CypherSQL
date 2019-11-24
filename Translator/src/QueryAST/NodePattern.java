package QueryAST;

public class NodePattern extends Pattern {
	private String variable;
	private String label;
	private boolean starredSrc = false;
	private boolean starredTrgt = false;

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isStarredSrc() {
		return starredSrc;
	}

	public void setStarredSrc(boolean starredSrc) {
		this.starredSrc = starredSrc;
	}

	public boolean isStarredTrgt() {
		return starredTrgt;
	}

	public void setStarredTrgt(boolean starredTrgt) {
		this.starredTrgt = starredTrgt;
	}
}