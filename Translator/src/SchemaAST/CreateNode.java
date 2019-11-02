package SchemaAST;

import java.util.ArrayList;
import java.util.List;

public class CreateNode extends Create {
	private String id;
	private List<String> labels = new ArrayList<String>();
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void addLabel(String label) {
		this.labels.add(label);
	}
	
	public List<String> getLabelList() {
		return new ArrayList<String>(labels);
	}
}