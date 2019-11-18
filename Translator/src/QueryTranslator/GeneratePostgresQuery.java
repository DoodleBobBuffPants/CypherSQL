package QueryTranslator;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import QueryAST.EdgePattern;
import QueryAST.Limit;
import QueryAST.NodePattern;
import QueryAST.OrderBy;
import QueryAST.Pattern;
import QueryAST.Query;
import QueryAST.Return;
import QueryAST.ReturnItem;
import QueryAST.SortItem;
import QueryAST.Where;
import QueryAST.WhereExpression;

public class GeneratePostgresQuery {
	private String translatedQuery;
	private String select = ",";
	private String from = ",";
	private String where = " AND ";
	private String groupBy = ",";
	private String orderBy = "";
	private String limit = "";
	
	public String getTranslatedQuery() {
		return translatedQuery;
	}

	public String generatePostgresQuery(Query parsedQuery) {
		handleQueryMatch(parsedQuery);
		handleQueryWhere(parsedQuery);
		handleQueryReturn(parsedQuery);
		handleQueryOrderBy(parsedQuery);
		handleQueryLimit(parsedQuery);
		
		translatedQuery = "SELECT " + select.substring(1, select.length() - 1) + " FROM " + from.substring(1, from.length() - 1);
		
		if (!where.equals(" AND ")) {
			translatedQuery += " WHERE " + where.substring(5, where.length() - 5);
		}
		if (!groupBy.equals(",")) {
			translatedQuery += " GROUP BY " + groupBy.substring(1, groupBy.length() - 1);
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
	
	private void matchNodeHandler(String currentNodeVar, String currentNodeName, int index, List<Pattern> patternList) {
		for (int i = 0; i < index; i++) {
			Pattern pattern = patternList.get(i);
			if (pattern instanceof NodePattern) {
				NodePattern otherNode = (NodePattern) pattern;
				String otherNodeVar = otherNode.getVariable();
				if (currentNodeVar.equals(otherNodeVar)) {
					String otherNodeLabel = otherNode.getLabel();
					if (otherNodeLabel == null) {
						where = uniqueStringConcat(where, currentNodeName + ".nodeid = " +  otherNodeVar + "_node.nodeid", " AND ");
					} else {
						where = uniqueStringConcat(where, currentNodeName + ".nodeid = " + otherNodeVar + "_" + otherNodeLabel.toLowerCase() + ".nodeid", " AND ");
					}
				}
			}
		}
	}
	
	private void matchEdgeHandler(String nodeVar, String nodeLabel, String edgeName, String srctrgt) {
		if (nodeVar != null && nodeLabel == null) {
			where = uniqueStringConcat(where, edgeName + ".node" + srctrgt + "id = " + nodeVar + "_node" + ".nodeid", " AND ");
		} else if (nodeVar != null && nodeLabel != null) {
			where = uniqueStringConcat(where, edgeName + ".node" + srctrgt + "id = " + nodeVar + "_" + nodeLabel.toLowerCase() + ".nodeid", " AND ");
		} else if (nodeLabel != null) {
			String lowerNodeLabel = nodeLabel.toLowerCase();
			from = uniqueStringConcat(from, lowerNodeLabel, ",");
			where = uniqueStringConcat(where, edgeName + ".node" + srctrgt + "id = " + lowerNodeLabel + ".nodeid", " AND ");
		}
	}
	
	private void whereExpressionHandler(String functionName, String functionArgument, String literal, List<Pattern> patternList) {
		if (functionName != null) {
			if (functionName.toLowerCase().equals("id")) {
				for (Pattern pattern: patternList) {
					if (pattern instanceof NodePattern) {
						NodePattern node = (NodePattern) pattern;
						String nodeVar = node.getVariable();
						if (nodeVar.equals(functionArgument)) {
							String nodeLabel = node.getLabel();
							if (nodeLabel == null) {
								where = where + nodeVar + "_node.nodeid";
							} else {
								where = where + nodeVar + "_" + nodeLabel.toLowerCase() + ".nodeid";
							}
						}
					}
				}
			}
		} else {
			if (NumberUtils.isNumber(literal)) {
				where = where + literal;
			} else if (literal.startsWith("'") && literal.endsWith("'")) {
				where = where + literal;
			} else {
				where = where + returnItemHandler(literal, patternList);
			}
		}
	}
	
	private void returnFunctionHandler(String functionName, String functionArgument, List<Pattern> patternList) {
		if (functionName.toLowerCase().equals("labels")) {
			for (Pattern pattern: patternList) {
				if (pattern instanceof NodePattern) {
					NodePattern node = (NodePattern) pattern;
					String nodeVar = node.getVariable();
					if (functionArgument.equals(nodeVar)) {
						String nodeLabel = node.getLabel();
						String nodeName = nodeVar + "_node";
						
						select = select + nodeName + ".labels";
						from = uniqueStringConcat(from, "nodes AS " + nodeName, ",");
						
						if (nodeLabel != null) {
							where = uniqueStringConcat(where, nodeName + ".nodeid = " + nodeVar + "_" + nodeLabel.toLowerCase() + ".nodeid", " AND ");
							where = uniqueStringConcat(where, "'" + nodeLabel + "' = ANY(labels)", " AND ");
						}
						break;
					}
				}
			}
		} else if (functionName.toLowerCase().equals("type")) {
			for (Pattern pattern: patternList) {
				EdgePattern edge = (EdgePattern) pattern;
				String edgeVar = edge.getVariable();
				if (functionArgument.equals(edgeVar)) {
					String edgeType = edge.getType();
					String edgeName = edgeVar + "_edge";
					
					select = select + edgeName + ".type";
					from = uniqueStringConcat(from, "edges AS " + edgeName, ",");
					
					if (edgeType != null) {
						String lowerEdgeType = edgeType.toLowerCase();
						where = uniqueStringConcat(where, edgeName + ".nodesrcid = " + edgeVar + "_" + lowerEdgeType + ".nodesrcid", " AND ");
						where = uniqueStringConcat(where, edgeName + ".nodetrgtid = " + edgeVar + "_" + lowerEdgeType + ".nodetrgtid", " AND ");
						where = uniqueStringConcat(where, "type = " + "'" + edgeType + "'", " AND ");
					}
					break;
				}
			}
		} else if (functionName.toLowerCase().equals("count")) {
			if (functionArgument.startsWith("DISTINCT ")) {
				select = select + "count(DISTINCT ";
				functionArgument = functionArgument.substring(9);
			} else {
				select = select + "count(";
			}
			
			if (functionArgument.split("\\(").length > 1) {
				String nestedFunctionName = functionArgument.substring(0, functionArgument.indexOf("("));
				String nestedFunctionArgument = functionArgument.substring(functionArgument.indexOf("(") + 1, functionArgument.length() - 1);
				
				returnFunctionHandler(nestedFunctionName, nestedFunctionArgument, patternList);
				select = select + ")";
			} else {
				String translatedArgument = returnItemHandler(functionArgument, patternList);
				for (String fieldWithAlias: select.substring(1).split(",")) {
					String field = fieldWithAlias.split("AS")[0].trim();
					if (!field.equals(translatedArgument) && !field.equals("")) {
						groupBy = uniqueStringConcat(groupBy, field, ",");
					}
				}
				select = select + translatedArgument + ")";
			}
		} else if (functionName.toLowerCase().equals("keys")) {
			select = select + "column_name";
			from = uniqueStringConcat(from, "information_schema.columns", ",");
			groupBy = uniqueStringConcat(groupBy, "column_name", ",");
			
			for (Pattern pattern: patternList) {
				if (pattern instanceof NodePattern) {
					NodePattern node = (NodePattern) pattern;
					if (functionArgument.equals(node.getVariable())) {
						from = uniqueStringConcat(from, "nodes", ",");
						where = uniqueStringConcat(where,  "initcap(table_name) = ANY(nodes.labels)", " AND ");
						where = uniqueStringConcat(where,  "column_name <> 'nodeid'", " AND ");
						break;
					}
				} else if (pattern instanceof EdgePattern) {
					EdgePattern edge = (EdgePattern) pattern;
					if (functionArgument.equals(edge.getVariable())) {
						from = uniqueStringConcat(from, "edges", ",");
						where = uniqueStringConcat(where,  "table_name = lower(edges.type)", " AND ");
						where = uniqueStringConcat(where,  "column_name <> 'nodesrcid'", " AND ");
						where = uniqueStringConcat(where,  "column_name <> 'nodetrgtid'", " AND ");
						break;
					}
				}
			}
		}
	}
	
	private String returnItemHandler(String toReturn, List<Pattern> patternList) {
		if (!toReturn.contains(".")) return toReturn;
		
		String[] returnElems = toReturn.split("\\.");
		String returnVar = returnElems[0];
		String returnField = returnElems[1];
		
		for (Pattern pattern: patternList) {
			if (pattern instanceof NodePattern) {
				NodePattern node = (NodePattern) pattern;
				String nodeVar = node.getVariable();
				if (returnVar.equals(nodeVar)) {
					String nodeLabel = node.getLabel();
					if (nodeLabel == null) {
						return nodeVar + "_node." + returnField;
					} else {
						return nodeVar + "_" + nodeLabel.toLowerCase() + "." + returnField;
					}
				}
			} else if (pattern instanceof EdgePattern) {
				EdgePattern edge = (EdgePattern) pattern;
				String edgeVar = edge.getVariable();
				if (returnVar.equals(edgeVar)) {
					String edgeType = edge.getType();
					if (edgeType == null) {
						return edgeVar + "_edge." + returnField;
					} else {
						return edgeVar + "_" + edgeType.toLowerCase() + "." + returnField;
					}
				}
			}
		}
		
		return "";
	}
	
	private void handleQueryMatch(Query parsedQuery) {
		List<Pattern> patternList = parsedQuery.getMatchClause().getPatternList();
		for (int i = 0; i < patternList.size(); i++) {
			Pattern pattern = patternList.get(i);
			if (pattern instanceof NodePattern) {
				NodePattern node = (NodePattern) pattern;
				String nodeVar = node.getVariable();
				String nodeLabel = node.getLabel();
				
				if (nodeVar != null && nodeLabel == null) {
					String nodeName = nodeVar + "_node";
					from = uniqueStringConcat(from, "nodes AS " + nodeName, ",");
					matchNodeHandler(nodeVar, nodeName, i, patternList);
				} else if (nodeVar != null){
					String lowerNodeLabel = nodeLabel.toLowerCase();
					String nodeName = nodeVar + "_" + lowerNodeLabel;
					from = uniqueStringConcat(from, lowerNodeLabel + " AS " + nodeName, ",");
					matchNodeHandler(nodeVar, nodeName, i, patternList);
				}
			} else {
				EdgePattern edge = (EdgePattern) pattern;
				NodePattern nodeSrc;
				NodePattern nodeTrgt;
				
				if (edge.isLeftSrc()) {
					nodeSrc = (NodePattern) patternList.get(i - 1);
					nodeTrgt = (NodePattern) patternList.get(i + 1);
				} else {
					nodeSrc = (NodePattern) patternList.get(i + 1);
					nodeTrgt = (NodePattern) patternList.get(i - 1);
				}
				
				String nodeSrcVar = nodeSrc.getVariable();
				String nodeSrcLabel = nodeSrc.getLabel();
				String nodeTrgtVar = nodeTrgt.getVariable();
				String nodeTrgtLabel = nodeTrgt.getLabel();
				String edgeVar = edge.getVariable();
				String edgeType = edge.getType();
				
				if (edgeVar != null && edgeType == null) {
					String edgeName =  edgeVar + "_edge";
					from = uniqueStringConcat(from, "edges AS " + edgeName, ",");
					matchEdgeHandler(nodeSrcVar, nodeSrcLabel, edgeName, "src");
					matchEdgeHandler(nodeTrgtVar, nodeTrgtLabel, edgeName, "trgt");
				} else if (edgeVar != null && edgeType != null){
					String lowerEdgeType = edgeType.toLowerCase();
					String edgeName = edgeVar + "_" + lowerEdgeType;
					from = uniqueStringConcat(from, lowerEdgeType + " AS " + edgeName, ",");
					matchEdgeHandler(nodeSrcVar, nodeSrcLabel, edgeName, "src");
					matchEdgeHandler(nodeTrgtVar, nodeTrgtLabel, edgeName, "trgt");
				} else if (edgeType != null) {
					String lowerEdgeType = edgeType.toLowerCase();
					from = uniqueStringConcat(from, lowerEdgeType, ",");
					matchEdgeHandler(nodeSrcVar, nodeSrcLabel, lowerEdgeType, "src");
					matchEdgeHandler(nodeTrgtVar, nodeTrgtLabel, lowerEdgeType, "trgt");
				}
			}
		}
	}
	
	private void handleQueryWhere(Query parsedQuery) {
		Where whereClause = parsedQuery.getWhereClause();
		if (whereClause != null) {
			for (WhereExpression whereExpression: whereClause.getAndExpressions()) {
				List<Pattern> patternList = parsedQuery.getMatchClause().getPatternList();
				whereExpressionHandler(whereExpression.getLeftFunctionName(), whereExpression.getLeftFunctionArgument(), whereExpression.getLeftLiteral(), patternList);
				where = where + " " + whereExpression.getComparisonOperator() + " ";
				whereExpressionHandler(whereExpression.getRightFunctionName(), whereExpression.getRightFunctionArgument(), whereExpression.getRightLiteral(), patternList);
				where = where + " AND ";
			}
		}
	}
	
	private void handleQueryReturn(Query parsedQuery) {
		Return returnClause = parsedQuery.getReturnClause();
		if (returnClause.isDistinct()) {
			select = select + "DISTINCT ";
		}
		
		for (ReturnItem returnItem: returnClause.getReturnItems()) {
			String functionName = returnItem.getFunctionName();
			String toReturn = returnItem.getToReturn();
			
			if (functionName != null) {
				returnFunctionHandler(functionName, returnItem.getFunctionArgument(), parsedQuery.getMatchClause().getPatternList());
			} else if (toReturn.toLowerCase().equals("count(*)")) {
				for (String field: select.substring(1).split(",")) {
					groupBy = uniqueStringConcat(groupBy, field.split("AS")[0].trim(), ",");
				}
				select = select + toReturn;
			} else {
				select = select + returnItemHandler(toReturn, parsedQuery.getMatchClause().getPatternList());
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
	
	private void handleQueryOrderBy(Query parsedQuery) {
		OrderBy orderByClause = parsedQuery.getOrderByClause();
		if (orderByClause != null) {
			for (SortItem sortItem: orderByClause.getSortItems()) {
				String functionName = sortItem.getFunctionName();
				if (functionName != null) {
					String tempSelect = select;
					select = orderBy;
					returnFunctionHandler(functionName, sortItem.getFunctionArgument(), parsedQuery.getMatchClause().getPatternList());
					orderBy = select;
					select = tempSelect;
					orderBy = orderBy + " " + sortItem.getAscdesc() + ",";
				} else {
					orderBy = orderBy + returnItemHandler(sortItem.getField(), parsedQuery.getMatchClause().getPatternList()) + " " + sortItem.getAscdesc() + ",";
				}
			}
		}
	}
	
	private void handleQueryLimit(Query parsedQuery) {
		Limit limitClause = parsedQuery.getLimitClause();
		if (limitClause != null) {
			limit += limitClause.getLimit();
		}
	}
}