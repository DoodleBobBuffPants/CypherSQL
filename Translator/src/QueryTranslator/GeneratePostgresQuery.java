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
		
		translatedQuery = "SELECT" + select.substring(0, select.length() - 1) + " FROM " + from.substring(1, (from.length() > 1 ? from.length() - 1 : 1));
		
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
		}
	}
	
	private void handleQueryReturn(Query parsedQuery) {
		Return returnClause = parsedQuery.getReturnClause();
		
		for (ReturnItem returnItem: returnClause.getReturnItems()) {
			String functionName = returnItem.getFunctionName();
			String toReturn = returnItem.getToReturn();
			
			if (functionName != null) {
				if (functionName.toLowerCase().equals("labels")) {
					select = select + "labels";
					from = uniqueStringConcat(from, "nodes");
					
					Match matchClause = parsedQuery.getMatchClause();
					
					if (matchClause.getPattern() instanceof NodePattern) {
						NodePattern node = (NodePattern) matchClause.getPattern();
						String nodeLabel = node.getLabel();
						
						if (node.getVariable().equals(returnItem.getFunctionArgument()) && nodeLabel != null) {
							where = where + "nodes.nodeid = " + nodeLabel.toLowerCase() + ".nodeid AND ";
							where = where + "'" + nodeLabel + "' = ANY(labels) AND ";
						}
					} else {
						EdgePattern edge = (EdgePattern) matchClause.getPattern();
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
				select = select + toReturn;
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