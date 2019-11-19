package QueryAST;

import java.util.ArrayList;
import java.util.List;

public class Return {
	private List<ReturnItem> returnItems = new ArrayList<ReturnItem>();
	private boolean isDistinct = false;

	public List<ReturnItem> getReturnItems() {
		return returnItems;
	}

	public void addReturnItem(ReturnItem returnItem) {
		this.returnItems.add(returnItem);
	}

	public boolean isDistinct() {
		return isDistinct;
	}

	public void setDistinct(boolean isDistinct) {
		this.isDistinct = isDistinct;
	}
}