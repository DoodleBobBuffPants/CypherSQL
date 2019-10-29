package QueryTranslator;

import java.util.HashMap;
import java.util.Map;

public class CreateNode {
	private String id;
	private String label;
	private Map<String, Object> columnValue = new HashMap<String, Object>();
	
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
	
	public void addColumnValue(String column, Object value) {
		columnValue.put(column, value);
	}
	
	public Map<String, Object> getColumnValues() {
		return new HashMap<String, Object>(columnValue);
	}
}