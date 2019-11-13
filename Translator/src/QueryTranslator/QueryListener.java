package QueryTranslator;

import org.antlr.v4.runtime.tree.ParseTree;

import QueryAST.EdgePattern;
import QueryAST.Limit;
import QueryAST.Match;
import QueryAST.NodePattern;
import QueryAST.OrderBy;
import QueryAST.Query;
import QueryAST.Return;
import QueryAST.ReturnItem;
import QueryAST.SortItem;
import QueryAST.Where;
import QueryAST.WhereExpression;
import antlr4.CypherParser;
import antlr4.CypherParser.OC_ComparisonExpressionContext;
import antlr4.CypherParser.OC_NodeLabelsContext;
import antlr4.CypherParser.OC_PartialComparisonExpressionContext;
import antlr4.CypherParser.OC_RelationshipDetailContext;
import antlr4.CypherParser.OC_RelationshipTypesContext;
import antlr4.CypherParser.OC_VariableContext;

public class QueryListener extends antlr4.CypherBaseListener {
	private Query query;
	private Match matchClause;
	private Where whereClause;
	private Return returnClause;
	private OrderBy orderByClause;
	private Limit limitClause;
	private NodePattern nodePattern;
	private EdgePattern edgePattern;
	private WhereExpression whereExpression;
	private ReturnItem returnItem;
	private SortItem sortItem;
	private boolean hasEdge;
	private boolean leftRight;
	private boolean leftExpression;
	
	public Query getQuery() {
		return query;
	}
	
	@Override
	public void enterOC_Query(CypherParser.OC_QueryContext ctx) {
		query = new Query();
	}
	
	@Override
	public void exitOC_Query(CypherParser.OC_QueryContext ctx) {
		query.setMatchClause(matchClause);
		query.setWhereClause(whereClause);
		query.setReturnClause(returnClause);
		query.setOrderByClause(orderByClause);
		query.setLimitClause(limitClause);
	}
	
	@Override
	public void enterOC_Match(CypherParser.OC_MatchContext ctx) {
		matchClause = new Match();
	}
	
	@Override
	public void exitOC_Match(CypherParser.OC_MatchContext ctx) {
		if (edgePattern != null) {
			matchClause.setPattern(edgePattern);
		} else if (nodePattern != null) {
			matchClause.setPattern(nodePattern);
		}
	}
	
	@Override
	public void enterOC_PatternElement(CypherParser.OC_PatternElementContext ctx) {
		hasEdge = false;
	}
	
	@Override
	public void exitOC_PatternElement(CypherParser.OC_PatternElementContext ctx) {
		if (hasEdge && leftRight) {
			edgePattern.setNodeTrgt(nodePattern);
		} else if (hasEdge) {
			edgePattern.setNodeSrc(nodePattern);
		}
	}
	
	@Override
	public void enterOC_NodePattern(CypherParser.OC_NodePatternContext ctx) {
		nodePattern = new NodePattern();
		OC_VariableContext variable = ctx.oC_Variable();
		if (variable != null) {
			nodePattern.setVariable(variable.getText());
		}
		OC_NodeLabelsContext nodeLabels = ctx.oC_NodeLabels();
		if (nodeLabels != null) {
			nodePattern.setLabel(nodeLabels.oC_NodeLabel(0).getText().substring(1));
		}
	}
	
	@Override
	public void enterOC_RelationshipPattern(CypherParser.OC_RelationshipPatternContext ctx) {
		edgePattern = new EdgePattern();
		hasEdge = true;
		
		OC_RelationshipDetailContext relationshipDetail = ctx.oC_RelationshipDetail();
		OC_VariableContext variable = relationshipDetail.oC_Variable();
		if (variable != null) {
			edgePattern.setVariable(variable.getText());
		}
		OC_RelationshipTypesContext edgeType = relationshipDetail.oC_RelationshipTypes();
		if (edgeType != null) {
			edgePattern.setType(edgeType.getText().substring(1));
		}
		if (ctx.oC_RightArrowHead() != null) {
			leftRight = true;
			edgePattern.setNodeSrc(nodePattern);
		} else {
			leftRight = false;
			edgePattern.setNodeTrgt(nodePattern);
		}
	}
	
	@Override
	public void enterOC_Where(CypherParser.OC_WhereContext ctx) {
		whereClause = new Where();
	}
	
	@Override
	public void enterOC_NotExpression(CypherParser.OC_NotExpressionContext ctx) {
		if (returnClause == null && orderByClause == null) {
			OC_ComparisonExpressionContext comparisonExp = ctx.oC_ComparisonExpression();
			if (comparisonExp.getChild(comparisonExp.getChildCount() - 1) instanceof OC_PartialComparisonExpressionContext) {
				whereExpression = new WhereExpression();
				leftExpression = true;
			}
		}
	}
	
	@Override
	public void exitOC_NotExpression(CypherParser.OC_NotExpressionContext ctx) {
		if (returnClause == null && orderByClause == null) { 
			OC_ComparisonExpressionContext comparisonExp = ctx.oC_ComparisonExpression();
			if (comparisonExp.getChild(comparisonExp.getChildCount() - 1) instanceof OC_PartialComparisonExpressionContext) {
				whereClause.addAndExpression(whereExpression);
			}
		}
	}
	
	@Override
	public void enterOC_PartialComparisonExpression(CypherParser.OC_PartialComparisonExpressionContext ctx) {
		whereExpression.setComparisonOperator(ctx.getChild(0).getText());
		leftExpression = false;
	}
	
	@Override
	public void exitOC_AddOrSubtractExpression(CypherParser.OC_AddOrSubtractExpressionContext ctx) {
		if (returnClause == null && orderByClause == null) {
			if (leftExpression) {
				whereExpression.setLeftLiteral(ctx.getText());
			} else {
				whereExpression.setRightLiteral(ctx.getText());
			}
		}
	}
	
	@Override
	public void enterOC_Return(CypherParser.OC_ReturnContext ctx) {
		returnClause = new Return();
	}
	
	@Override
	public void enterOC_ReturnItem(CypherParser.OC_ReturnItemContext ctx) {
		returnItem = new ReturnItem();
	}
	
	@Override
	public void exitOC_FunctionInvocation(CypherParser.OC_FunctionInvocationContext ctx) {
		if (returnClause == null && orderByClause == null) {
			if (leftExpression) {
				whereExpression.setLeftFunctionName(ctx.oC_FunctionName().getText());
				whereExpression.setLeftFunctionArgument(ctx.oC_Expression(0).getText());
			} else {
				whereExpression.setRightFunctionName(ctx.oC_FunctionName().getText());
				whereExpression.setRightFunctionArgument(ctx.oC_Expression(0).getText());
			}
		} else if (returnClause == null) {
			sortItem.setFunctionName(ctx.oC_FunctionName().getText());
			sortItem.setFunctionArgument(ctx.oC_Expression(0).getText());
		} else {
			returnItem.setFunctionName(ctx.oC_FunctionName().getText());
			returnItem.setFunctionArgument(ctx.oC_Expression(0).getText());
		}
	}
	
	@Override
	public void exitOC_ReturnItem(CypherParser.OC_ReturnItemContext ctx) {
		returnItem.setToReturn(ctx.oC_Expression().getText());
		ParseTree aliasTree = ctx.getChild(2);
		if (aliasTree != null) {
			if (aliasTree.getText().toLowerCase().equals("as")) {
				returnItem.setAlias(ctx.getChild(4).getText());
			}
		}
		returnClause.addReturnItem(returnItem);
	}
	
	@Override
	public void enterOC_Order(CypherParser.OC_OrderContext ctx) {
		orderByClause = new OrderBy();
	}
	
	@Override
	public void enterOC_SortItem(CypherParser.OC_SortItemContext ctx) {
		sortItem = new SortItem();
		ParseTree order = ctx.getChild(2);
		if (order != null) {
			sortItem.setAscdesc(order.getText().toLowerCase());
		} else {
			sortItem.setAscdesc("asc");
		}
		sortItem.setField(ctx.oC_Expression().getText());
	}
	
	@Override
	public void exitOC_SortItem(CypherParser.OC_SortItemContext ctx) {
		orderByClause.addSortItem(sortItem);
	}
	
	@Override
	public void enterOC_Limit(CypherParser.OC_LimitContext ctx) {
		limitClause = new Limit();
		limitClause.setLimit(Integer.parseInt(ctx.oC_Expression().getText()));
	}
}