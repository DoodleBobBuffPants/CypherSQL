package QueryAST;

import java.util.ArrayList;
import java.util.List;

public class OrderBy {
	private List<SortItem> sortItems = new ArrayList<SortItem>();

	public List<SortItem> getSortItems() {
		return new ArrayList<SortItem>(sortItems);
	}

	public void addSortItem(SortItem sortItem) {
		this.sortItems.add(sortItem);
	}
}