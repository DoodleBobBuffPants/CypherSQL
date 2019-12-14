package QueryAST;

import java.util.ArrayList;
import java.util.List;

public class Match {
	private List<Pattern> patternList = new ArrayList<Pattern>();
	private boolean allShortestPaths;
	private String pathVar;

	public List<Pattern> getPatternList() {
		return patternList;
	}

	public void addPattern(Pattern pattern) {
		this.patternList.add(pattern);
	}

	public boolean isAllShortestPaths() {
		return allShortestPaths;
	}

	public void setAllShortestPaths(boolean allShortestPaths) {
		this.allShortestPaths = allShortestPaths;
	}

	public String getPathVar() {
		return pathVar;
	}

	public void setPathVar(String pathVar) {
		this.pathVar = pathVar;
	}
}