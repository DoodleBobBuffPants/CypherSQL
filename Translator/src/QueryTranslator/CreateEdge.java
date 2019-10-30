package QueryTranslator;

public class CreateEdge extends Create {
	private String sourceID;
	private String targetID;
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}
	
	public String getSourceID() {
		return sourceID;
	}
	
	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}
	
	public String getTargetID() {
		return targetID;
	}
}