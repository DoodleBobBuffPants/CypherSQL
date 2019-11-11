package QueryTranslator;

import QueryAST.EdgePattern;
import QueryAST.Match;
import QueryAST.NodePattern;
import QueryAST.Query;
import QueryAST.Return;
import QueryAST.ReturnItem;

public class GeneratePostgresQuery {
	private String translatedQuery;
	private String select = " ";
	private String from = ",";
	private String innerJoin = "";
	private String where = "";
	private String groupBy = "";
	
	public String getTranslatedQuery() {
		return translatedQuery;
	}

	public String generatePostgresQuery(Query parsedQuery) {
		handleQueryMatch(parsedQuery);
		handleQueryReturn(parsedQuery);
		
		translatedQuery = "SELECT" + select.substring(0, select.length() - 1) + " FROM " + from.substring(1, from.length() - 1);
		
		if (!innerJoin.equals("")) {
			translatedQuery += " INNER JOIN " + innerJoin;
		}
		if (!where.equals("")) {
			translatedQuery += " WHERE " + where.substring(0, where.length() - 5);
		}
		if (!groupBy.equals("")) {
			translatedQuery += " GROUP BY " + groupBy.substring(0, groupBy.length() - 1);
		}
		
		return translatedQuery;
	}

	private String uniqueStringConcat(String target, String concat) {
		if (target.contains("," + concat + ",")) return target;
		return target + concat + ",";
	}
	
	private void handleQueryMatch(Query parsedQuery) {
		Match matchClause = parsedQuery.getMatchClause();
		
		if (matchClause.getPattern() instanceof NodePattern) {
			NodePattern node = (NodePattern) matchClause.getPattern();
			String nodeLabel = node.getLabel();
			
			if (nodeLabel == null) {
				from = from + "nodes,";
			} else {
				from = from + nodeLabel.toLowerCase() + ",";
			}
		} else {
			EdgePattern edge = (EdgePattern) matchClause.getPattern();
			String nodeSrcLabel = edge.getNodeSrc().getLabel();
			String nodeTrgtLabel = edge.getNodeTrgt().getLabel();
			String edgeType = edge.getType();
			
			if (edgeType == null) {
				from = from + "edges,";
			} else {
				from = from + edgeType.toLowerCase() + ",";
			}
			
			if (nodeSrcLabel != null) {
				from = from + nodeSrcLabel.toLowerCase() + ",";
			}
			if (nodeTrgtLabel != null) {
				from = from + nodeTrgtLabel.toLowerCase() + ",";
			}
		}
	}
	
	private void handleQueryReturn(Query parsedQuery) {
		Return returnClause = parsedQuery.getReturnClause();
		
		for (ReturnItem returnItem: returnClause.getReturnItems()) {
			String functionName = returnItem.getFunctionName();
			String toReturn = returnItem.getToReturn();
			
			if (functionName != null) {
				if (functionName.toLowerCase().equals("labels")) {
					Match matchClause = parsedQuery.getMatchClause();
					
					if (matchClause.getPattern() instanceof NodePattern) {
						NodePattern node = (NodePattern) matchClause.getPattern();
						String nodeLabel = node.getLabel();
						
						select = select + "labels";
						from = uniqueStringConcat(from, "nodes");
						
						if (node.getVariable().equals(returnItem.getFunctionArgument()) && nodeLabel != null) {
							where = where + "nodes.nodeid = " + nodeLabel.toLowerCase() + ".nodeid AND ";
							where = where + "'" + nodeLabel + "' = ANY(labels) AND ";
						}
					} else {
						EdgePattern edge = (EdgePattern) matchClause.getPattern();
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
							matchSrc = false;
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