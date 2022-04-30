package cyphersql.listener;

import cyphersql.antlr.CypherParser.*;
import cyphersql.ast.EdgeDirection;
import cyphersql.ast.match.Limit;
import cyphersql.ast.match.Match;
import cyphersql.ast.match.Query;
import cyphersql.ast.match.orderby.OrderBy;
import cyphersql.ast.match.orderby.OrderByItem;
import cyphersql.ast.match.pattern.EdgePattern;
import cyphersql.ast.match.pattern.NodePattern;
import cyphersql.ast.match.returnclause.Return;
import cyphersql.ast.match.returnclause.ReturnItem;
import cyphersql.ast.match.where.Where;
import cyphersql.ast.match.where.WhereCondition;
import org.antlr.v4.runtime.tree.ParseTree;

public class CypherMatchListener extends CypherQueryListener {
    public Query query;
    private WhereCondition whereCondition;
    private ReturnItem returnItem;
    private OrderByItem orderByItem;
    private boolean inWhere;
    private boolean inReturn;
    private boolean inOrderBy;
    private boolean onLeftWhereArgument;

    @Override
    public void enterOC_Query(OC_QueryContext ctx) {
        query = new Query();
    }

    @Override
    public void enterOC_Match(OC_MatchContext ctx) {
        query.matchClause = new Match();
    }

    @Override
    public void enterOC_With(OC_WithContext ctx) {
        if (query.returnClause == null) {
            query.returnClause = new Return();
        }
    }

    @Override
    public void enterOC_Return(OC_ReturnContext ctx) {
        if (query.returnClause == null) {
            query.returnClause = new Return();
        }
        ParseTree distinct = ctx.getChild(2);
        if (distinct != null && distinct.getText().equalsIgnoreCase("distinct")) {
            query.returnClause.isDistinct = true;
        }
        inReturn = true;
    }

    @Override
    public void exitOC_Return(OC_ReturnContext ctx) {
        inReturn = false;
    }

    @Override
    public void enterOC_ReturnItem(OC_ReturnItemContext ctx) {
        returnItem = new ReturnItem();
    }

    @Override
    public void exitOC_ReturnItem(OC_ReturnItemContext ctx) {
        String value = ctx.oC_Expression().getText();
        ParseTree alias = ctx.getChild(2);
        if (alias == null || !alias.getText().equalsIgnoreCase("as")) {
            boolean valueIsNotAlias = query.returnClause.returnItems.stream().noneMatch(i -> value.equals(i.alias));
            if (valueIsNotAlias) {
                returnItem.value = value;
                query.returnClause.returnItems.add(returnItem);
            }
        } else {
            returnItem.value = value;
            returnItem.alias = ctx.getChild(4).getText();
            query.returnClause.returnItems.add(returnItem);
        }
    }

    @Override
    public void enterOC_Order(OC_OrderContext ctx) {
        query.orderByClause = new OrderBy();
        inOrderBy = true;
    }

    @Override
    public void exitOC_Order(OC_OrderContext ctx) {
        inOrderBy = false;
    }

    @Override
    public void enterOC_Limit(OC_LimitContext ctx) {
        query.limitClause = new Limit();
        query.limitClause.limit = Integer.parseInt(ctx.oC_Expression().getText());
    }

    @Override
    public void enterOC_SortItem(OC_SortItemContext ctx) {
        orderByItem = new OrderByItem();
        ParseTree order = ctx.getChild(2);
        if (order != null) {
            orderByItem.direction = order.getText().toUpperCase();
        } else {
            orderByItem.direction = "ASC";
        }
        orderByItem.field = ctx.oC_Expression().getText();
    }

    @Override
    public void exitOC_SortItem(OC_SortItemContext ctx) {
        query.orderByClause.orderByItems.add(orderByItem);
    }

    @Override
    public void enterOC_Where(OC_WhereContext ctx) {
        if (query.whereClause == null) {
            query.whereClause = new Where();
        }
        inWhere = true;
    }

    @Override
    public void exitOC_Where(OC_WhereContext ctx) {
        inWhere = false;
    }

    @Override
    public void enterOC_PatternPart(OC_PatternPartContext ctx) {
        ParseTree allShortestPaths = ctx.getChild(4);
        if (allShortestPaths != null) {
            query.matchClause.allShortestPaths = true;
            query.matchClause.pathVariable = ctx.getChild(0).getText();
        } else {
            query.matchClause.allShortestPaths = false;
        }
    }

    @Override
    public void enterOC_NodePattern(OC_NodePatternContext ctx) {
        NodePattern nodePattern = new NodePattern();
        OC_VariableContext variable = ctx.oC_Variable();
        OC_NodeLabelsContext nodeLabels = ctx.oC_NodeLabels();
        if (variable != null) {
            nodePattern.variable = variable.getText();
        }
        if (nodeLabels != null) {
            nodePattern.label = nodeLabels.oC_NodeLabel(0).getText().substring(1);
        }
        query.matchClause.patternList.add(nodePattern);
    }

    @Override
    public void enterOC_RelationshipPattern(OC_RelationshipPatternContext ctx) {
        EdgePattern edgePattern = new EdgePattern();
        OC_RelationshipDetailContext edge = ctx.oC_RelationshipDetail();
        OC_VariableContext variable = edge.oC_Variable();
        OC_RelationshipTypesContext edgeType = edge.oC_RelationshipTypes();
        OC_RangeLiteralContext star = edge.oC_RangeLiteral();
        if (variable != null) {
            edgePattern.variable = variable.getText();
        }
        if (edgeType != null) {
            edgePattern.type = edgeType.getText().substring(1);
        }
        if (ctx.oC_RightArrowHead() != null) {
            edgePattern.direction = EdgeDirection.LEFT_RIGHT;
        } else if (ctx.oC_LeftArrowHead() != null) {
            edgePattern.direction = EdgeDirection.RIGHT_LEFT;
        } else {
            edgePattern.direction = EdgeDirection.BIDIRECTIONAL;
        }
        if (star != null) {
            edgePattern.starredEdge = true;
            OC_IntegerLiteralContext starLength = star.oC_IntegerLiteral(0);
            if (starLength != null) {
                edgePattern.starLength = Integer.parseInt(starLength.getText());
            } else {
                edgePattern.starLength = -1;
            }
        } else {
            edgePattern.starredEdge = false;
        }
        query.matchClause.patternList.add(edgePattern);
    }

    @Override
    public void enterOC_NotExpression(OC_NotExpressionContext ctx) {
        if (inWhere) {
            OC_ComparisonExpressionContext comparison = ctx.oC_ComparisonExpression();
            if (comparison.getChild(comparison.getChildCount() - 1) instanceof OC_PartialComparisonExpressionContext) {
                whereCondition = new WhereCondition();
                onLeftWhereArgument = true;
            }
        }
    }

    @Override
    public void exitOC_NotExpression(OC_NotExpressionContext ctx) {
        if (inWhere) {
            OC_ComparisonExpressionContext comparison = ctx.oC_ComparisonExpression();
            if (comparison.getChild(comparison.getChildCount() - 1) instanceof OC_PartialComparisonExpressionContext) {
                query.whereClause.andConditions.add(whereCondition);
            }
        }
    }

    @Override
    public void exitOC_AddOrSubtractExpression(OC_AddOrSubtractExpressionContext ctx) {
        if (inWhere) {
            if (onLeftWhereArgument) {
                whereCondition.leftArgument.literal = ctx.getText();
            } else {
                whereCondition.rightArgument.literal = ctx.getText();
            }
        }
    }

    @Override
    public void enterOC_PartialComparisonExpression(OC_PartialComparisonExpressionContext ctx) {
        whereCondition.comparisonOperator = ctx.getChild(0).getText();
        onLeftWhereArgument = false;
    }

    @Override
    public void exitOC_FunctionInvocation(OC_FunctionInvocationContext ctx) {
        if (inWhere) {
            if (onLeftWhereArgument) {
                whereCondition.leftArgument.function = ctx.oC_FunctionName().getText();
                whereCondition.leftArgument.functionArgument = ctx.oC_Expression(0).getText();
            } else {
                whereCondition.rightArgument.function = ctx.oC_FunctionName().getText();
                whereCondition.rightArgument.functionArgument = ctx.oC_Expression(0).getText();
            }
        } else if (inReturn) {
            returnItem.function = ctx.oC_FunctionName().getText();
            ParseTree distinct = ctx.getChild(2);
            if (distinct != null && distinct.getText().equalsIgnoreCase("distinct")) {
                returnItem.functionArgument = "DISTINCT " + ctx.oC_Expression(0).getText();
            } else {
                returnItem.functionArgument = ctx.oC_Expression(0).getText();
            }
        } else if (inOrderBy) {
            orderByItem.function = ctx.oC_FunctionName().getText();
            orderByItem.functionArgument = ctx.oC_Expression(0).getText();
        }
    }
}
