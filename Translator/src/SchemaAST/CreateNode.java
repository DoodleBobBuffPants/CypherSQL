package SchemaAST;

import java.util.ArrayList;
import java.util.List;

public class CreateNode extends Create {
	private int id;
	private List<String> labels = new ArrayList<String>();
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void addLabel(String label) {
		this.labels.add(label);
	}
	
	public List<String> getLabelList() {
		return new ArrayList<String>(labels);
	}
}