package QueryAST;

import java.util.ArrayList;
import java.util.List;

public class Match {
	private List<Pattern> patternList = new ArrayList<Pattern>();

	public List<Pattern> getPatternList() {
		return patternList;
	}

	public void addPattern(Pattern pattern) {
		this.patternList.add(pattern);
	}
}