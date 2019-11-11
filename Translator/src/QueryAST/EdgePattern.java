package QueryAST;

public class EdgePattern extends Pattern {
	private NodePattern nodeSrc;
	private NodePattern nodeTrgt;
	private String variable;
	private String type;
	
	public NodePattern getNodeSrc() {
		return nodeSrc;
	}
	
	public void setNodeSrc(NodePattern nodeSrc) {
		this.nodeSrc = nodeSrc;
	}
	
	public NodePattern getNodeTrgt() {
		return nodeTrgt;
	}
	
	public void setNodeTrgt(NodePattern nodeTrgt) {
		this.nodeTrgt = nodeTrgt;
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