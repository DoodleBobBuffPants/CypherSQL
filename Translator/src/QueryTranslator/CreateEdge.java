package QueryTranslator;

import java.util.HashMap;
import java.util.Map;

public class CreateEdge extends Create {
	private String sourceID;
	private String targetID;
	private String type;
	private Map<String, Object> columnValue = new HashMap<String, Object>();
	
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
	
	public void addColumnValue(String column, Object value) {
		columnValue.put(column, value);
	}
	
	public Map<String, Object> getColumnValueMap() {
		return new HashMap<String, Object>(columnValue);
	}
}