package QueryTranslator;

import QueryAST.NodePattern;
import QueryAST.Query;
import QueryAST.ReturnItem;

public class GeneratePostgresQuery {
	private Query parsedQuery;
	private String translatedQuery;
	private String select = " ";
	private String from = ",";
	private String innerJoin = "";
	private String where = "";
	private String groupBy = "";
	
	public String generatePostgresQuery(Query parsedQuery) {
		this.parsedQuery = parsedQuery;
		handleQueryMatch();
		handleQueryReturn();
		translatedQuery = "SELECT" + select.substring(0, select.length() - 1) + " FROM " + from.substring(1, from.length() - 1);
		if (!innerJoin.equals("")) {
			translatedQuery += " INNER JOIN " + innerJoin;
		}
		if (!where.equals("")) {
			translatedQuery += " WHERE " + where;
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
	
	private void handleQueryMatch() {
		if (parsedQuery.getMatchClause().getPattern() instanceof NodePattern) {
			NodePattern node = (NodePattern) parsedQuery.getMatchClause().getPattern();
			if (node.getLabel() == null) {
				from = from + "nodes,";
			} else {
				from = from + node.getLabel().toLowerCase() + ",";
			}
		}
	}
	
	private void handleQueryReturn() {
		for (ReturnItem returnItem: parsedQuery.getReturnClause().getReturnItems()) {
			if (returnItem.getFunctionName() != null) {
				if (returnItem.getFunctionName().toLowerCase().equals("labels")) {
					select = select + "labels";
					from = uniqueStringConcat(from, "nodes");
					//TODO: Possible joining required for function argument
				}
			} else if (returnItem.getToReturn().toLowerCase().startsWith("count(")) {
				String countField = returnItem.getToReturn().substring(returnItem.getToReturn().indexOf("(") + 1, returnItem.getToReturn().indexOf(")"));
				for (String field: select.split(",")) {
					String fieldWithoutAlias = field.split("AS")[0].trim();
					if (!fieldWithoutAlias.equals(countField)) {
						groupBy = groupBy + fieldWithoutAlias + ",";
					}
				}
				select = select + returnItem.getToReturn();
			} else {
				select = select + returnItem.getToReturn();
			}
			
			if (returnItem.getAlias() != null) {
				if (!select.endsWith(" " + returnItem.getAlias())) {
					select = select + " AS " + returnItem.getAlias();
				}
			}
			select = select + ",";
		}
	}
}