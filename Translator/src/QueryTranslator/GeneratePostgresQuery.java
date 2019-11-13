package QueryTranslator;

import org.apache.commons.lang3.math.NumberUtils;

import QueryAST.EdgePattern;
import QueryAST.Limit;
import QueryAST.NodePattern;
import QueryAST.Pattern;
import QueryAST.Query;
import QueryAST.ReturnItem;
import QueryAST.Where;
import QueryAST.WhereExpression;

public class GeneratePostgresQuery {
	private String translatedQuery;
	private String select = ",";
	private String from = ",";
	private String where = " AND ";
	private String groupBy = "";
	private String orderBy = "";
	private String limit = "";
	
	public String getTranslatedQuery() {
		return translatedQuery;
	}

	public String generatePostgresQuery(Query parsedQuery) {
		handleQueryMatch(parsedQuery);
		handleQueryWhere(parsedQuery);
		handleQueryReturn(parsedQuery);
		handleQueryLimit(parsedQuery);
		
		translatedQuery = "SELECT " + select.substring(1, select.length() - 1) + " FROM " + from.substring(1, from.length() - 1);
		
		if (!where.equals(" AND ")) {
			translatedQuery += " WHERE " + where.substring(5, where.length() - 5);
		}
		if (!groupBy.equals("")) {
			translatedQuery += " GROUP BY " + groupBy.substring(0, groupBy.length() - 1);
		}
		if (!orderBy.equals("")) {
			translatedQuery += " ORDER BY " + orderBy.substring(0, orderBy.length() - 1);
		}
		if (!limit.equals("")) {
			translatedQuery += " LIMIT " + limit;
		}
		
		return translatedQuery;
	}

	private String uniqueStringConcat(String target, String concat, String delim) {
		if (target.contains(delim + concat + delim)) return target;
		return target + concat + delim;
	}
	
	private void matchEdgeHandler(String nodeVar, String nodeLabel, String edgeType, String srctrgt) {
		if (nodeVar != null && nodeLabel == null) {
			from = uniqueStringConcat(from, "nodes AS " + nodeVar + "_node", ",");
			where = uniqueStringConcat(where, edgeType + ".node" + srctrgt + "id = " + nodeVar + "_node.nodeid", " AND ");
		} else if (nodeVar != null && nodeLabel != null) {
			from = uniqueStringConcat(from, nodeLabel.toLowerCase() + " AS " + nodeVar + "_" + nodeLabel.toLowerCase() , ",");
			where = uniqueStringConcat(where, edgeType + ".node" + srctrgt + "id = " + nodeVar + "_" + nodeLabel.toLowerCase() + ".nodeid", " AND ");
		} else if (nodeLabel != null) {
			from = uniqueStringConcat(from, nodeLabel.toLowerCase(), ",");
			where = uniqueStringConcat(where, edgeType + ".node" + srctrgt + "id = " + nodeLabel.toLowerCase() + ".nodeid", " AND ");
		}
	}
	
	private void whereExpressionHandler(String functionName, String functionArgument, String literal, Pattern pattern) {
		if (functionName != null) {
			if (functionName.toLowerCase().equals("id")) {
				if (pattern instanceof NodePattern) {
					NodePattern node = (NodePattern) pattern;
					
					if (node.getVariable().equals(functionArgument)) {
						where = where + "nodeid";
					}
				} else if (pattern instanceof EdgePattern) {
					EdgePattern edge = (EdgePattern) pattern;
					
					if (edge.getNodeSrc().getVariable().equals(functionArgument)) {
						where = where + "nodesrcid";
					} else if (edge.getNodeTrgt().getVariable().equals(functionArgument)) {
						where = where + "nodetrgtid";
					}
				}
			}
		} else {
			if (NumberUtils.isNumber(literal)) {
				where = where + literal;
			} else if (literal.startsWith("'") && literal.endsWith("'")) {
				where = where + literal;
			} else {
				where = where + returnItemHandler(literal, pattern);
			}
		}
	}
	
	private void returnFunctionHandler(String functionName, String functionArgument, Pattern pattern) {
		if (functionName.toLowerCase().equals("labels")) {
			if (pattern instanceof NodePattern) {
				NodePattern node = (NodePattern) pattern;
				String nodeLabel = node.getLabel();
				
				select = select + "labels";
				from = uniqueStringConcat(from, "nodes", ",");
				
				if (node.getVariable().equals(functionArgument) && nodeLabel != null) {
					where = where + "nodes.nodeid = " + nodeLabel.toLowerCase() + ".nodeid AND ";
					where = where + "'" + nodeLabel + "' = ANY(labels) AND ";
				}
			} else {
				EdgePattern edge = (EdgePattern) pattern;
				NodePattern nodeSrc = edge.getNodeSrc();
				NodePattern nodeTrgt = edge.getNodeTrgt();
				
				String nodeSrcVar = nodeSrc.getVariable();
				String nodeTrgtVar = nodeTrgt.getVariable();
				
				String nodeVar = "";
				String nodeLabel = null;
				if (nodeSrcVar.equals(functionArgument)) {
					nodeVar = nodeSrcVar;
					nodeLabel = nodeSrc.getLabel();
				} else if (nodeTrgtVar.equals(functionArgument)){
					nodeVar = nodeTrgtVar;
					nodeLabel = nodeTrgt.getLabel();
				}
				
				if (!nodeVar.equals("")) {
					select = select + nodeVar + "_node.labels";
					from = uniqueStringConcat(from, "nodes AS " + nodeVar + "_node", ",");
					if (nodeLabel != null) {
						where = where + nodeVar + "_node.nodeid = " + nodeLabel.toLowerCase() + ".nodeid AND ";
						where = where + "'" + nodeLabel + "' = ANY(" + nodeVar + "_node.labels) AND ";
					}
				}
			}
		} else if (functionName.toLowerCase().equals("type")) {
			EdgePattern edge = (EdgePattern) pattern;
			String edgeType = edge.getType();
			
			select = select + "type";
			from = uniqueStringConcat(from, "edges", ",");
			
			if (edge.getVariable().equals(functionArgument) && edgeType != null) {
				where = where + "edges.nodesrcid = " + edgeType.toLowerCase() + ".nodesrcid AND ";
				where = where + "edges.nodetrgtid = " + edgeType.toLowerCase() + ".nodetrgtid AND ";
				where = where + "type = " + "'" + edgeType + "' AND ";
			}
		} else if (functionName.toLowerCase().equals("count")) {
			if (functionArgument.split("\\(").length > 1) {
				String nestedFunctionName = functionArgument.substring(0, functionArgument.indexOf("("));
				String nestedFunctionArgument = functionArgument.substring(functionArgument.indexOf("(") + 1, functionArgument.length() - 1);
				
				select = select + "count(";
				returnFunctionHandler(nestedFunctionName, nestedFunctionArgument, pattern);
				select = select + ")";
			} else {
				String translatedArgument = returnItemHandler(functionArgument, pattern);
				for (String fieldWithAlias: select.substring(1).split(",")) {
					String field = fieldWithAlias.split("AS")[0].trim();
					if (!field.equals(translatedArgument) && !field.equals("")) {
						groupBy = groupBy + field + ",";
					}
				}
				select = select + "count(" + translatedArgument + ")";
			}
		}
	}
	
	private String returnItemHandler(String toReturn, Pattern pattern) {
		if (!toReturn.contains(".")) return toReturn;
		
		String[] returnElems = toReturn.split("\\.");
		String returnVar = returnElems[0];
		String returnField = returnElems[1];
		
		if (pattern instanceof NodePattern) {
			if (returnVar.equals(((NodePattern) pattern).getVariable())) {
				return returnField;
			}
		} else if (pattern instanceof EdgePattern) {
			EdgePattern edge = (EdgePattern) pattern;
			String edgeVar = edge.getVariable();
			
			if (returnVar.equals(edgeVar)) {
				return returnField;
			} else { 
				NodePattern nodeSrc = edge.getNodeSrc();
				String nodeSrcVar = nodeSrc.getVariable();
				String nodeSrcLabel = nodeSrc.getLabel();
				if (returnVar.equals(nodeSrcVar)) {
					if (nodeSrcLabel == null) {
						return nodeSrcVar + "_node." + returnField;
					} else {
						return nodeSrcVar + "_" + nodeSrcLabel.toLowerCase() + "." + returnField;
					}
				} else { 
					NodePattern nodeTrgt = edge.getNodeTrgt();
					String nodeTrgtVar = nodeTrgt.getVariable();
					String nodeTrgtLabel = nodeTrgt.getLabel();
					if (returnVar.equals(nodeTrgtVar)) {
						if (nodeTrgtLabel == null) {
							return nodeTrgtVar + "_node." + returnField;
						} else {
							return nodeTrgtVar + "_" + nodeTrgtLabel.toLowerCase() + "." + returnField;
						}
					}
				}
			} 
		}
		
		return "";
	}
	
	private void handleQueryMatch(Query parsedQuery) {
		Pattern pattern = parsedQuery.getMatchClause().getPattern();
		
		if (pattern instanceof NodePattern) {
			NodePattern node = (NodePattern) pattern;
			String nodeVar = node.getVariable();
			String nodeLabel = node.getLabel();
			
			if (nodeVar != null && nodeLabel == null) {
				from = from + "nodes,";
			} else if (nodeLabel != null){
				from = from + nodeLabel.toLowerCase() + ",";
			}
		} else {
			EdgePattern edge = (EdgePattern) pattern;
			NodePattern nodeSrc = edge.getNodeSrc();
			NodePattern nodeTrgt = edge.getNodeTrgt();
			
			String nodeSrcVar = nodeSrc.getVariable();
			String nodeSrcLabel = nodeSrc.getLabel();
			String nodeTrgtVar = nodeTrgt.getVariable();
			String nodeTrgtLabel = nodeTrgt.getLabel();
			String edgeVar = edge.getVariable();
			String edgeType = edge.getType();
			
			if (edgeVar != null && edgeType == null) {
				from = from + "edges,";
				matchEdgeHandler(nodeSrcVar, nodeSrcLabel, "edges", "src");
				matchEdgeHandler(nodeTrgtVar, nodeTrgtLabel, "edges", "trgt");
			} else if (edgeType != null){
				from = from + edgeType.toLowerCase() + ",";
				matchEdgeHandler(nodeSrcVar, nodeSrcLabel, edgeType.toLowerCase(), "src");
				matchEdgeHandler(nodeTrgtVar, nodeTrgtLabel, edgeType.toLowerCase(), "trgt");
			}
		}
	}
	
	private void handleQueryWhere(Query parsedQuery) {
		Where whereClause = parsedQuery.getWhereClause();
		if (whereClause != null) {
			for (WhereExpression whereExpression: whereClause.getAndExpressions()) {
				whereExpressionHandler(whereExpression.getLeftFunctionName(), whereExpression.getLeftFunctionArgument(), whereExpression.getLeftLiteral(), parsedQuery.getMatchClause().getPattern());
				where = where + " " + whereExpression.getComparisonOperator() + " ";
				whereExpressionHandler(whereExpression.getRightFunctionName(), whereExpression.getRightFunctionArgument(), whereExpression.getRightLiteral(), parsedQuery.getMatchClause().getPattern());
				where = where + " AND ";
			}
		}
	}
	
	private void handleQueryReturn(Query parsedQuery) {
		for (ReturnItem returnItem: parsedQuery.getReturnClause().getReturnItems()) {
			String functionName = returnItem.getFunctionName();
			String toReturn = returnItem.getToReturn();
			
			if (functionName != null) {
				returnFunctionHandler(functionName, returnItem.getFunctionArgument(), parsedQuery.getMatchClause().getPattern());
			} else if (toReturn.toLowerCase().equals("count(*)")) {
				for (String field: select.substring(1).split(",")) {
					groupBy = groupBy + field.split("AS")[0].trim() + ",";
				}
				select = select + toReturn;
			} else {
				select = select + returnItemHandler(toReturn, parsedQuery.getMatchClause().getPattern());
			}
			
			String alias = returnItem.getAlias();
			if (alias != null) {
				if (!select.endsWith("," + alias)) {
					select = select + " AS " + alias;
				}
			}
			select = select + ",";
		}
	}
	
	private void handleQueryLimit(Query parsedQuery) {
		Limit limitClause = parsedQuery.getLimitClause();
		if (limitClause != null) {
			limit += limitClause.getLimit();
		}
	}
}