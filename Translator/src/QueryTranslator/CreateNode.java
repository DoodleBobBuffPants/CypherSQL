package QueryTranslator;

import java.util.HashMap;
import java.util.Map;

public class CreateNode {
	private String id;
	private String label;
	private Map<String, String> columnValues = new HashMap<String, String>();
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void addColumnValues(String key, String value) {
		columnValues.put(key, value);
	}
	
	public Map<String, String> getColumnValues() {
		return new HashMap<String, String>(columnValues);
	}
}