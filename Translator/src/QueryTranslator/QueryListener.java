package QueryTranslator;

import QueryAST.EdgePattern;
import QueryAST.Match;
import QueryAST.NodePattern;
import QueryAST.Query;
import QueryAST.Return;
import QueryAST.ReturnItem;
import QueryAST.Where;
import QueryAST.WhereExpression;
import antlr4.CypherParser;
import antlr4.CypherParser.OC_RelationshipDetailContext;

public class QueryListener extends antlr4.CypherBaseListener {
	private Query query;
	private Match matchClause;
	private Where whereClause;
	private Return returnClause;
	private NodePattern nodePattern;
	private EdgePattern edgePattern;
	private WhereExpression whereExpression;
	private ReturnItem returnItem;
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
	}
	
	@Override
	public void exitOC_NodePattern(CypherParser.OC_NodePatternContext ctx) {
		nodePattern.setVariable(ctx.oC_Variable().getText());
		if (ctx.oC_NodeLabels() != null) {
			nodePattern.setLabel(ctx.oC_NodeLabels().oC_NodeLabel(0).getText().substring(1));
		}
	}
	
	@Override
	public void enterOC_RelationshipPattern(CypherParser.OC_RelationshipPatternContext ctx) {
		edgePattern = new EdgePattern();
	}
	
	@Override
	public void exitOC_RelationshipPattern(CypherParser.OC_RelationshipPatternContext ctx) {
		OC_RelationshipDetailContext relationshipDetail = ctx.oC_RelationshipDetail();
		edgePattern.setVariable(relationshipDetail.oC_Variable().getText());
		edgePattern.setType(relationshipDetail.oC_RelationshipTypes().getText().substring(1));
		if (ctx.oC_RelationshipDetail() != null) {
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
		whereExpression = new WhereExpression();
		leftExpression = true;
	}
	
	@Override
	public void exitOC_NotExpression(CypherParser.OC_NotExpressionContext ctx) {
		if (ctx.parent instanceof CypherParser.OC_AndExpressionContext) {
			whereClause.addAndExpressions(whereExpression);
		}
	}
	
	@Override
	public void enterOC_PartialComparisonExpression(CypherParser.OC_PartialComparisonExpressionContext ctx) {
		whereExpression.setComparisonOperator(ctx.getChild(0).getText());
		leftExpression = false;
	}
	
	@Override
	public void exitOC_AddOrSubtractExpression(CypherParser.OC_AddOrSubtractExpressionContext ctx) {
		if (leftExpression) {
			whereExpression.setLeftLiteral(ctx.getText());
		} else {
			whereExpression.setRightLiteral(ctx.getText());
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
		if (returnClause == null) {
			if (leftExpression) {
				whereExpression.setLeftFunctionName(ctx.oC_FunctionName().getText());
				whereExpression.setLeftFunctionArgument(ctx.oC_Expression(0).getText());
			} else {
				whereExpression.setRightFunctionName(ctx.oC_FunctionName().getText());
				whereExpression.setRightFunctionArgument(ctx.oC_Expression(0).getText());
			}
		} else {
			returnItem.setFunctionName(ctx.oC_FunctionName().getText());
			returnItem.setFunctionArgument(ctx.oC_Expression(0).getText());
		}
	}
	
	@Override
	public void exitOC_ReturnItem(CypherParser.OC_ReturnItemContext ctx) {
		returnItem.setToReturn(ctx.oC_Expression().getText());
		if (ctx.getChild(2).getText().toLowerCase().equals("as")) {
			returnItem.setAlias(ctx.getChild(4).getText());
		}
		returnClause.addReturnItem(returnItem);
	}
}