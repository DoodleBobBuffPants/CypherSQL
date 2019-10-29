package QueryTranslator;

import antlr4.CypherParser;

public class SchemaListener extends antlr4.CypherBaseListener {
	@Override
	public void enterOC_Create(CypherParser.OC_CreateContext ctx) {
		System.out.println("enter create");
	}
	
	@Override
	public void exitOC_Create(CypherParser.OC_CreateContext ctx) {
		System.out.println("exit create");
	}	
}