package QueryTranslator;

import QueryAST.EdgePattern;
import QueryAST.NodePattern;
import QueryAST.Pattern;
import QueryAST.Query;
import QueryAST.ReturnItem;
import QueryAST.Where;

public class GeneratePostgresQuery {
	private String translatedQuery;
	private String select = " ";
	private String from = ",";
	private String where = " AND ";
	private String groupBy = "";
	
	public String getTranslatedQuery() {
		return translatedQuery;
	}

	public String generatePostgresQuery(Query parsedQuery) {
		handleQueryMatch(parsedQuery);
		handleQueryWhere(parsedQuery);
		handleQueryReturn(parsedQuery);
		
		translatedQuery = "SELECT" + select.substring(0, select.length() - 1) + " FROM " + from.substring(1, from.length() - 1);
		
		if (!where.equals(" AND ")) {
			translatedQuery += " WHERE " + where.substring(5, where.length() - 5);
		}
		if (!groupBy.equals("")) {
			translatedQuery += " GROUP BY " + groupBy.substring(0, groupBy.length() - 1);
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
			
		}
	}
	
	private void handleQueryReturn(Query parsedQuery) {
		for (ReturnItem returnItem: parsedQuery.getReturnClause().getReturnItems()) {
			String functionName = returnItem.getFunctionName();
			String toReturn = returnItem.getToReturn();
			
			if (functionName != null) {
				if (functionName.toLowerCase().equals("labels")) {
					Pattern pattern = parsedQuery.getMatchClause().getPattern();
					
					if (pattern instanceof NodePattern) {
						NodePattern node = (NodePattern) pattern;
						String nodeLabel = node.getLabel();
						
						select = select + "labels";
						from = uniqueStringConcat(from, "nodes", ",");
						
						if (node.getVariable().equals(returnItem.getFunctionArgument()) && nodeLabel != null) {
							where = where + "nodes.nodeid = " + nodeLabel.toLowerCase() + ".nodeid AND ";
							where = where + "'" + nodeLabel + "' = ANY(labels) AND ";
						}
					} else {
						EdgePattern edge = (EdgePattern) pattern;
						NodePattern nodeSrc = edge.getNodeSrc();
						NodePattern nodeTrgt = edge.getNodeTrgt();
						
						String edgeType = edge.getType();
						String functionArgument = returnItem.getFunctionArgument();
						String nodeSrcVar = nodeSrc.getVariable();
						String nodeTrgtVar = nodeTrgt.getVariable();
						
						String nodeVar = "";
						String nodeLabel = null;
						boolean matchSrc = false;
						if (nodeSrcVar.equals(functionArgument)) {
							nodeVar = nodeSrcVar;
							nodeLabel = nodeSrc.getLabel();
							matchSrc = true;
						} else if (nodeTrgtVar.equals(functionArgument)){
							nodeVar = nodeTrgtVar;
							nodeLabel = nodeTrgt.getLabel();
						}
						
						if (!nodeVar.equals("")) {
							select = select + nodeVar + "_node" + ".labels";
							from = from + "nodes AS " + nodeVar + "_node,";
							if (nodeLabel != null) {
								where = where + nodeVar + "_node.nodeid = " + nodeLabel.toLowerCase() + ".nodeid AND ";
								where = where + "'" + nodeLabel + "' = ANY(" + nodeVar + "_node.labels) AND ";
							}
							if (edgeType == null && matchSrc) {
								where = where + "edges.nodesrcid = " + nodeVar + "_node.nodeid AND ";
							} else if (edgeType == null) {
								where = where + "edges.nodetrgtid = " + nodeVar + "_node.nodeid AND ";
							} else if (matchSrc){
								where = where + edgeType.toLowerCase() + ".nodesrcid = " + nodeVar + "_node.nodeid AND ";
							} else {
								where = where + edgeType.toLowerCase() + ".nodetrgtid = " + nodeVar + "_node.nodeid AND ";	
							}
						}
					}
				} else if (functionName.toLowerCase().equals("type")) {
					EdgePattern edge = (EdgePattern) parsedQuery.getMatchClause().getPattern();
					String edgeType = edge.getType();
					
					select = select + "type";
					from = uniqueStringConcat(from, "edges", ",");
					
					if (edge.getVariable().equals(returnItem.getFunctionArgument()) && edgeType != null) {
						where = where + "edges.nodesrcid = " + edgeType.toLowerCase() + ".nodesrcid AND ";
						where = where + "edges.nodetrgtid = " + edgeType.toLowerCase() + ".nodetrgtid AND ";
						where = where + "type = " + "'" + edgeType + "' AND ";
					}
				}
			} else if (toReturn.toLowerCase().startsWith("count(")) {
				String countField = toReturn.substring(toReturn.indexOf("(") + 1, toReturn.indexOf(")"));
				
				for (String field: select.split(",")) {
					String fieldWithoutAlias = field.split("AS")[0].trim();
					
					if (!fieldWithoutAlias.equals(countField)) {
						groupBy = groupBy + fieldWithoutAlias + ",";
					}
				}
				
				select = select + toReturn;
			} else {
				select = select + toReturn.split("\\.")[1];
			}
			
			String alias = returnItem.getAlias();
			
			if (alias != null) {
				if (!select.endsWith(" " + alias)) {
					select = select + " AS " + alias;
				}
			}
			
			select = select + ",";
		}
	}
}