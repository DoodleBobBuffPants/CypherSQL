package QueryTranslator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import QueryAST.EdgePattern;
import QueryAST.Limit;
import QueryAST.Match;
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
	private String having = ",";
	private String orderBy = "";
	private String limit = "";
	
	private boolean isHaving;
	
	private Map<String, String> varNameMap = new HashMap<String, String>();
	
	public String getTranslatedQuery() {
		return translatedQuery;
	}

	public String generatePostgresQuery(Query parsedQuery) {
		handleQueryMatch(parsedQuery);
		handleQueryReturn(parsedQuery);
		handleQueryWhere(parsedQuery);
		handleQueryOrderBy(parsedQuery);
		handleQueryLimit(parsedQuery);
		
		translatedQuery = "SELECT " + select.substring(1, select.length() - 1) + " FROM " + from.substring(1, from.length() - 1);
		
		if (!where.equals(" AND ")) {
			translatedQuery += " WHERE " + where.substring(5, where.length() - 5);
		}
		if (!groupBy.equals(",")) {
			translatedQuery += " GROUP BY " + groupBy.substring(1, groupBy.length() - 1);
		}
		if (!having.equals(",")) {
			translatedQuery += " HAVING " + having.substring(1, having.length() - 1);
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
					String otherNodeName = varNameMap.get(otherNodeVar);
					if (!currentNodeName.equals(otherNodeName)) {
						where = uniqueStringConcat(where, currentNodeName + ".nodeid = " +  otherNodeName + ".nodeid", " AND ");
					}
				}
			}
		}
	}
	
	private void matchEdgeHandler(String nodeVar, String nodeLabel, String edgeName, String srctrgt) {
		if (nodeVar != null && nodeLabel == null) {
			where = uniqueStringConcat(where, edgeName + ".node" + srctrgt + "id = " + nodeVar + "_node.nodeid", " AND ");
		} else if (nodeVar != null && nodeLabel != null) {
			where = uniqueStringConcat(where, edgeName + ".node" + srctrgt + "id = " + nodeVar + "_" + nodeLabel.toLowerCase() + ".nodeid", " AND ");
		} else if (nodeLabel != null) {
			String lowerNodeLabel = nodeLabel.toLowerCase();
			from = uniqueStringConcat(from, lowerNodeLabel, ",");
			where = uniqueStringConcat(where, edgeName + ".node" + srctrgt + "id = " + lowerNodeLabel + ".nodeid", " AND ");
		}
	}
	
	private void matchEdgeCasesHandler(NodePattern nodeSrc, NodePattern nodeTrgt, EdgePattern edge) {
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
			varNameMap.put(edgeVar, edgeName);
		} else if (edgeVar != null && edgeType != null){
			String lowerEdgeType = edgeType.toLowerCase();
			String edgeName = edgeVar + "_" + lowerEdgeType;
			from = uniqueStringConcat(from, lowerEdgeType + " AS " + edgeName, ",");
			matchEdgeHandler(nodeSrcVar, nodeSrcLabel, edgeName, "src");
			matchEdgeHandler(nodeTrgtVar, nodeTrgtLabel, edgeName, "trgt");
			varNameMap.put(edgeVar, edgeName);
		} else if (edgeType != null) {
			String lowerEdgeType = edgeType.toLowerCase();
			from = uniqueStringConcat(from, lowerEdgeType, ",");
			matchEdgeHandler(nodeSrcVar, nodeSrcLabel, lowerEdgeType, "src");
			matchEdgeHandler(nodeTrgtVar, nodeTrgtLabel, lowerEdgeType, "trgt");
		}
	}
	
	private void matchStarredEdgeHandler(EdgePattern edge, List<Pattern> patternList, int i) {
		String edgeType = edge.getType();
		if (edgeType == null) {
			edgeType = "edges";
		} else {
			edgeType = edgeType.toLowerCase();
		}
		
		int maxDepth = edge.getStarLength();
		String startNodeVar = ((NodePattern) patternList.get(i - 1)).getVariable();
		String startNodeAlias = varNameMap.get(startNodeVar);
		for (int depth = 0; depth < maxDepth; depth ++) {
			String nodeAlias = "";
			if (depth == maxDepth - 1) {
				NodePattern endNode = (NodePattern) patternList.get(i + 1);
				String nodeVar = endNode.getVariable();
				String nodeLabel = endNode.getLabel();
				if (nodeLabel == null) {
					nodeAlias = nodeVar + "_node";
				} else {
					nodeAlias = nodeVar + "_" + nodeLabel.toLowerCase();
				} 
			} else {
				nodeAlias = "star_" + i + "_node_" + depth;
				from += "nodes AS " + nodeAlias + ",";
			}
			String edgeAlias = "star_" + i + "_edge_" + depth;
			from += edgeType + " AS " + edgeAlias + ",";
			where += "((" + edgeAlias + ".nodesrcid = " + startNodeAlias + ".nodeid AND " + edgeAlias + ".nodetrgtid = " + nodeAlias + ".nodeid) OR "
					+ "(" + edgeAlias + ".nodetrgtid = " + startNodeAlias + ".nodeid AND " + edgeAlias + ".nodesrcid = " + nodeAlias + ".nodeid)) AND ";
			startNodeAlias = nodeAlias;
		}
		where = uniqueStringConcat(where, startNodeAlias + ".nodeid <> " + varNameMap.get(startNodeVar) + ".nodeid", " AND ");
	}
	
	private void matchAllShortestPathsHandler(Match matchClause, Where whereClause, Return returnClause) {
		List<Pattern> patternList = matchClause.getPatternList();
		NodePattern nodeSrc = (NodePattern) patternList.get(0);
		NodePattern nodeTrgt = (NodePattern) patternList.get(2);
		String nodeSrcVar = nodeSrc.getVariable();
		String nodeTrgtVar = nodeTrgt.getVariable();
		String pathVar = matchClause.getPathVar();
		String subWhere = "";
		
		from += "allshortestpaths,";
		
		subWhere = aspWhereHandler(whereClause, nodeSrcVar, subWhere, "source");
		subWhere = aspWhereHandler(whereClause, nodeTrgtVar, subWhere, "target");
		where += "path_length IN (SELECT MIN(path_length) FROM allshortestpaths WHERE " + subWhere.substring(0, subWhere.length() - 5) + ") AND ";
		
		for (ReturnItem returnItem: returnClause.getReturnItems()) {
			String functionName = returnItem.getFunctionName();
			if (functionName != null && functionName.toLowerCase().equals("length") && returnItem.getFunctionArgument().equals(pathVar)) {
				returnItem.setFunctionName(null);
				returnItem.setToReturn(returnItem.getToReturn().replaceAll("length\\("+pathVar+"\\)", "path_length"));
			} else if (returnItem.getToReturn().equals(pathVar)) {
				returnItem.setToReturn("id_path");
			}
		}
	}
	
	private String aspWhereHandler(Where whereClause, String nodeVar, String subWhere, String sourceTarget) {
		List<WhereExpression> aspExpressions = new ArrayList<WhereExpression>();
		Iterator<WhereExpression> whereIterator = whereClause.getAndExpressions().iterator();
		while (whereIterator.hasNext()) {
			WhereExpression whereExpression = whereIterator.next();
			String leftLiteral = whereExpression.getLeftLiteral();
			String rightLiteral = whereExpression.getRightLiteral();
			if (leftLiteral.contains(" " + nodeVar + ".") || leftLiteral.contains("(" + nodeVar + ")") || rightLiteral.contains(" " + nodeVar + ".") || rightLiteral.contains("(" + nodeVar + ")")) {
				aspExpressions.add(whereExpression);
				whereIterator.remove();
			}
		}
		
		String condition = "";
		for (WhereExpression aspExpression: aspExpressions) {
			String leftFunctionName = aspExpression.getLeftFunctionName();
			String rightFunctionName = aspExpression.getRightFunctionName();
			if (leftFunctionName != null && leftFunctionName.toLowerCase().equals("id")) {
				condition = sourceTarget + " = " + aspExpression.getRightLiteral() + " AND ";
				where += condition;
				subWhere += condition;
			} else if (rightFunctionName != null && rightFunctionName.toLowerCase().equals("id")) {
				condition = sourceTarget + " = " + aspExpression.getLeftLiteral() + " AND ";
				where += condition;
				subWhere += condition;
			}
		}
		
		return subWhere;
	}
	
	private void whereExpressionHandler(String functionName, String functionArgument, String literal, List<Pattern> patternList) {
		if (functionName != null) {
			if (functionName.toLowerCase().equals("id")) {
				for (Pattern pattern: patternList) {
					if (pattern instanceof NodePattern) {
						NodePattern node = (NodePattern) pattern;
						String nodeVar = node.getVariable();
						if (nodeVar.equals(functionArgument)) {
							where += varNameMap.get(nodeVar) + ".nodeid";
							break;
						}
					}
				}
			}
		} else {
			if (NumberUtils.isNumber(literal) || (literal.startsWith("'") && literal.endsWith("'"))) {
				where += literal;
			} else {
				where += returnItemHandler(literal, patternList);
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
						
						select += nodeName + ".labels";
						from = uniqueStringConcat(from, "nodes AS " + nodeName, ",");
						
						if (nodeLabel != null) {
							where = uniqueStringConcat(where, nodeName + ".nodeid = " + varNameMap.get(nodeVar) + ".nodeid", " AND ");
							where = uniqueStringConcat(where, "'" + nodeLabel + "' = ANY(labels)", " AND ");
						}
						break;
					}
				}
			}
		} else if (functionName.toLowerCase().equals("type")) {
			for (Pattern pattern: patternList) {
				if (pattern instanceof EdgePattern) {
					EdgePattern edge = (EdgePattern) pattern;
					String edgeVar = edge.getVariable();
					if (functionArgument.equals(edgeVar)) {
						String edgeType = edge.getType();
						String edgeName = edgeVar + "_edge";
						
						select += edgeName + ".type";
						from = uniqueStringConcat(from, "edges AS " + edgeName, ",");
						
						if (edgeType != null) {
							String typedEdgeName = varNameMap.get(edgeVar);
							where = uniqueStringConcat(where, edgeName + ".nodesrcid = " + typedEdgeName + ".nodesrcid", " AND ");
							where = uniqueStringConcat(where, edgeName + ".nodetrgtid = " + typedEdgeName + ".nodetrgtid", " AND ");
							where = uniqueStringConcat(where, "type = " + "'" + edgeType + "'", " AND ");
						}
						break;
					}
				}
			}
		} else if (functionName.toLowerCase().equals("count")) {
			if (functionArgument.startsWith("DISTINCT ")) {
				select += "count(DISTINCT ";
				functionArgument = functionArgument.substring(9);
			} else {
				select += "count(";
			}
			
			if (functionArgument.split("\\(").length > 1) {
				String nestedFunctionName = functionArgument.substring(0, functionArgument.indexOf("("));
				String nestedFunctionArgument = functionArgument.substring(functionArgument.indexOf("(") + 1, functionArgument.length() - 1);
				
				returnFunctionHandler(nestedFunctionName, nestedFunctionArgument, patternList);
				select += ")";
			} else {
				String translatedArgument = returnItemHandler(functionArgument, patternList);
				for (String fieldWithAlias: select.substring(1).split(",")) {
					String field = fieldWithAlias.split("AS")[0].trim();
					if (!field.equals(translatedArgument) && !field.equals("")) {
						groupBy = uniqueStringConcat(groupBy, field, ",");
					}
				}
				select += translatedArgument + ")";
			}
		} else if (functionName.toLowerCase().equals("keys")) {
			select += "column_name";
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
		if (!toReturn.contains(".")) {
			for (String returnItems: select.substring(1).split(",")) {
				String[] itemAndAlias = returnItems.split("AS");
				if (itemAndAlias.length == 2) {
					String alias = itemAndAlias[1].trim();
					if (toReturn.equals(alias)) {
						String item = itemAndAlias[0].trim();
						if (item.toLowerCase().startsWith("count(")) {
							isHaving = true;
						}
						return item;
					}
				}
			}
			return toReturn;
		}
		
		String[] returnElems = toReturn.split("\\.");
		String returnVar = returnElems[0];
		String returnField = returnElems[1];
		
		for (Pattern pattern: patternList) {
			if (pattern instanceof NodePattern) {
				NodePattern node = (NodePattern) pattern;
				String nodeVar = node.getVariable();
				if (returnVar.equals(nodeVar)) {
					return varNameMap.get(nodeVar) + "." + returnField;
				}
			} else if (pattern instanceof EdgePattern) {
				EdgePattern edge = (EdgePattern) pattern;
				String edgeVar = edge.getVariable();
				if (returnVar.equals(edgeVar)) {
					return varNameMap.get(edgeVar) + "." + returnField;
				}
			}
		}
		
		return "";
	}
	
	private void handleQueryMatch(Query parsedQuery) {
		Match matchClause = parsedQuery.getMatchClause();
		if (matchClause.isAllShortestPaths()) {
			matchAllShortestPathsHandler(matchClause, parsedQuery.getWhereClause(), parsedQuery.getReturnClause());
		} else {
			List<Pattern> patternList = matchClause.getPatternList();
			for (int i = 0; i < patternList.size(); i++) {
				Pattern pattern = patternList.get(i);
				if (pattern instanceof NodePattern) {
					NodePattern node = (NodePattern) pattern;
					String nodeVar = node.getVariable();
					String nodeLabel = node.getLabel();
					String nodeName = "";
					
					if (nodeVar != null && nodeLabel == null) {
						nodeName = nodeVar + "_node";
						from = uniqueStringConcat(from, "nodes AS " + nodeName, ",");
					} else if (nodeVar != null){
						String lowerNodeLabel = nodeLabel.toLowerCase();
						nodeName = nodeVar + "_" + lowerNodeLabel;
						from = uniqueStringConcat(from, lowerNodeLabel + " AS " + nodeName, ",");
					}
					
					if (!nodeName.equals("")) {
						matchNodeHandler(nodeVar, nodeName, i, patternList);
						varNameMap.put(nodeVar, nodeName);
					}
				} else {
					EdgePattern edge = (EdgePattern) pattern;
					
					if (edge.isStarredEdge()) {
						matchStarredEdgeHandler(edge, patternList, i);
					} else if (!edge.isDirected()) {
						NodePattern nodeSrc = (NodePattern) patternList.get(i - 1);
						NodePattern nodeTrgt = (NodePattern) patternList.get(i + 1);
						where = where + "((";
						matchEdgeCasesHandler(nodeSrc, nodeTrgt, edge);
						where = where.substring(0, where.length() - 5) + ") OR (";
						matchEdgeCasesHandler(nodeTrgt, nodeSrc, edge);
						where = where.substring(0, where.length() - 5) + ")) AND ";
					} else if (edge.isLeftSrc()) {
						matchEdgeCasesHandler((NodePattern) patternList.get(i - 1), (NodePattern) patternList.get(i + 1), edge);
					} else {
						matchEdgeCasesHandler((NodePattern) patternList.get(i + 1),(NodePattern) patternList.get(i - 1), edge);
					}
				}
			}
		}
	}
	
	private void handleQueryWhere(Query parsedQuery) {
		Where whereClause = parsedQuery.getWhereClause();
		if (whereClause != null) {
			for (WhereExpression whereExpression: whereClause.getAndExpressions()) {
				List<Pattern> patternList = parsedQuery.getMatchClause().getPatternList();
				isHaving = false;
				whereExpressionHandler(whereExpression.getLeftFunctionName(), whereExpression.getLeftFunctionArgument(), whereExpression.getLeftLiteral(), patternList);
				where += " " + whereExpression.getComparisonOperator() + " ";
				whereExpressionHandler(whereExpression.getRightFunctionName(), whereExpression.getRightFunctionArgument(), whereExpression.getRightLiteral(), patternList);
				
				if (isHaving) {
					String havingItem = where.substring(where.lastIndexOf(" AND ") + 5);
					where = where.substring(0, where.length() - havingItem.length());
					having = uniqueStringConcat(having, havingItem, ",");
				} else {
					where += " AND ";
				}
			}
		}
	}
	
	private void handleQueryReturn(Query parsedQuery) {
		Return returnClause = parsedQuery.getReturnClause();
		if (returnClause.isDistinct()) {
			select += "DISTINCT ";
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
				select += toReturn;
			} else {
				select += returnItemHandler(toReturn, parsedQuery.getMatchClause().getPatternList());
			}
			
			String alias = returnItem.getAlias();
			if (alias != null && !select.endsWith("," + alias)) {
				select += " AS " + alias;
			}
			select += ",";
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
					orderBy = select + " " + sortItem.getAscdesc() + ",";
					select = tempSelect;
				} else {
					orderBy += returnItemHandler(sortItem.getField(), parsedQuery.getMatchClause().getPatternList()) + " " + sortItem.getAscdesc() + ",";
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