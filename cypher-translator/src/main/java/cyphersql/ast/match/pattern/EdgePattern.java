package cyphersql.ast.match.pattern;

import cyphersql.ast.EdgeDirection;

public class EdgePattern extends Pattern {
    public String type;
    public EdgeDirection direction;
    public boolean starredEdge;
    public int starLength;
}
