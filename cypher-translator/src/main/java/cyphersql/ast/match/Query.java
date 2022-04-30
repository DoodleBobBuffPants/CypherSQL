package cyphersql.ast.match;

import cyphersql.ast.match.orderby.OrderBy;
import cyphersql.ast.match.returnclause.Return;
import cyphersql.ast.match.where.Where;

public class Query {
    public Match matchClause;
    public Where whereClause;
    public Return returnClause;
    public OrderBy orderByClause;
    public Limit limitClause;
}
