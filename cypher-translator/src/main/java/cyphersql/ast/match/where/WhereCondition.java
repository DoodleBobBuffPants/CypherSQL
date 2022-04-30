package cyphersql.ast.match.where;

public class WhereCondition {
    public WhereArgument leftArgument = new WhereArgument();
    public String comparisonOperator;
    public WhereArgument rightArgument = new WhereArgument();
}
