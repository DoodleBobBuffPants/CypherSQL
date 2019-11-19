package SchemaAST;

import java.util.HashMap;
import java.util.Map;

public class Create {
	private Map<String, Object> columnValue = new HashMap<String, Object>();
	
	public void addColumnValue(String column, Object value) {
		columnValue.put(column, value);
	}
	
	public Map<String, Object> getColumnValueMap() {
		return columnValue;
	}
}