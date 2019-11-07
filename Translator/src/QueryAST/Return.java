package QueryAST;

import java.util.ArrayList;
import java.util.List;

public class Return {
	private List<ReturnItem> returnItems = new ArrayList<ReturnItem>();

	public List<ReturnItem> getReturnItems() {
		return new ArrayList<ReturnItem>(returnItems);
	}

	public void addReturnItem(ReturnItem returnItem) {
		this.returnItems.add(returnItem);
	}
}