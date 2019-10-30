package SchemaAST;

import java.util.ArrayList;
import java.util.List;

public class CreateNode extends Create {
	private String id;
	private List<String> label = new ArrayList<String>();
	
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
}