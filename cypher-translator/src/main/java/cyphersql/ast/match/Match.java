package cyphersql.ast.match;

import cyphersql.ast.match.pattern.Pattern;

import java.util.ArrayList;
import java.util.List;

public class Match {
    public List<Pattern> patternList = new ArrayList<>();
    public boolean allShortestPaths;
    public String pathVariable;
}
