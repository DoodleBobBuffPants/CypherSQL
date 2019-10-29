package QueryTranslator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNode extends Create {
	private String id;
	private List<String> label = new ArrayList<String>();
	private Map<String, Object> columnValue = new HashMap<String, Object>();
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void addLabel(String label) {
		this.label.add(label);
	}
	
	public List<String> getLabelList() {
		return new ArrayList<String>(label);
	}
	
	public void addColumnValue(String column, Object value) {
		columnValue.put(column, value);
	}
	
	public Map<String, Object> getColumnValueMap() {
		return new HashMap<String, Object>(columnValue);
	}
}