package SchemaAST;

public class CreateEdge extends Create {
	private int sourceID;
	private int targetID;
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}
	
	public int getSourceID() {
		return sourceID;
	}
	
	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}
	
	public int getTargetID() {
		return targetID;
	}
}