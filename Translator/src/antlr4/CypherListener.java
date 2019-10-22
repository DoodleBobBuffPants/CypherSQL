// Generated from Cypher.g4 by ANTLR 4.4
package antlr4;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CypherParser}.
 */
public interface CypherListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_MultiPartQuery}.
	 * @param ctx the parse tree
	 */
	void enterOC_MultiPartQuery(@NotNull CypherParser.OC_MultiPartQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_MultiPartQuery}.
	 * @param ctx the parse tree
	 */
	void exitOC_MultiPartQuery(@NotNull CypherParser.OC_MultiPartQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_DoubleLiteral}.
	 * @param ctx the parse tree
	 */
	void enterOC_DoubleLiteral(@NotNull CypherParser.OC_DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_DoubleLiteral}.
	 * @param ctx the parse tree
	 */
	void exitOC_DoubleLiteral(@NotNull CypherParser.OC_DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_UpdatingClause}.
	 * @param ctx the parse tree
	 */
	void enterOC_UpdatingClause(@NotNull CypherParser.OC_UpdatingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_UpdatingClause}.
	 * @param ctx the parse tree
	 */
	void exitOC_UpdatingClause(@NotNull CypherParser.OC_UpdatingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_NodeLabels}.
	 * @param ctx the parse tree
	 */
	void enterOC_NodeLabels(@NotNull CypherParser.OC_NodeLabelsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_NodeLabels}.
	 * @param ctx the parse tree
	 */
	void exitOC_NodeLabels(@NotNull CypherParser.OC_NodeLabelsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ListComprehension}.
	 * @param ctx the parse tree
	 */
	void enterOC_ListComprehension(@NotNull CypherParser.OC_ListComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ListComprehension}.
	 * @param ctx the parse tree
	 */
	void exitOC_ListComprehension(@NotNull CypherParser.OC_ListComprehensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Cypher}.
	 * @param ctx the parse tree
	 */
	void enterOC_Cypher(@NotNull CypherParser.OC_CypherContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Cypher}.
	 * @param ctx the parse tree
	 */
	void exitOC_Cypher(@NotNull CypherParser.OC_CypherContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PropertyOrLabelsExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_PropertyOrLabelsExpression(@NotNull CypherParser.OC_PropertyOrLabelsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PropertyOrLabelsExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_PropertyOrLabelsExpression(@NotNull CypherParser.OC_PropertyOrLabelsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_With}.
	 * @param ctx the parse tree
	 */
	void enterOC_With(@NotNull CypherParser.OC_WithContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_With}.
	 * @param ctx the parse tree
	 */
	void exitOC_With(@NotNull CypherParser.OC_WithContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_RangeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterOC_RangeLiteral(@NotNull CypherParser.OC_RangeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_RangeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitOC_RangeLiteral(@NotNull CypherParser.OC_RangeLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_RightArrowHead}.
	 * @param ctx the parse tree
	 */
	void enterOC_RightArrowHead(@NotNull CypherParser.OC_RightArrowHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_RightArrowHead}.
	 * @param ctx the parse tree
	 */
	void exitOC_RightArrowHead(@NotNull CypherParser.OC_RightArrowHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_YieldItems}.
	 * @param ctx the parse tree
	 */
	void enterOC_YieldItems(@NotNull CypherParser.OC_YieldItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_YieldItems}.
	 * @param ctx the parse tree
	 */
	void exitOC_YieldItems(@NotNull CypherParser.OC_YieldItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PartialComparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_PartialComparisonExpression(@NotNull CypherParser.OC_PartialComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PartialComparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_PartialComparisonExpression(@NotNull CypherParser.OC_PartialComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Limit}.
	 * @param ctx the parse tree
	 */
	void enterOC_Limit(@NotNull CypherParser.OC_LimitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Limit}.
	 * @param ctx the parse tree
	 */
	void exitOC_Limit(@NotNull CypherParser.OC_LimitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_AddOrSubtractExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_AddOrSubtractExpression(@NotNull CypherParser.OC_AddOrSubtractExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_AddOrSubtractExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_AddOrSubtractExpression(@NotNull CypherParser.OC_AddOrSubtractExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_StringListNullOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_StringListNullOperatorExpression(@NotNull CypherParser.OC_StringListNullOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_StringListNullOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_StringListNullOperatorExpression(@NotNull CypherParser.OC_StringListNullOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Match}.
	 * @param ctx the parse tree
	 */
	void enterOC_Match(@NotNull CypherParser.OC_MatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Match}.
	 * @param ctx the parse tree
	 */
	void exitOC_Match(@NotNull CypherParser.OC_MatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PatternPart}.
	 * @param ctx the parse tree
	 */
	void enterOC_PatternPart(@NotNull CypherParser.OC_PatternPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PatternPart}.
	 * @param ctx the parse tree
	 */
	void exitOC_PatternPart(@NotNull CypherParser.OC_PatternPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_AnonymousPatternPart}.
	 * @param ctx the parse tree
	 */
	void enterOC_AnonymousPatternPart(@NotNull CypherParser.OC_AnonymousPatternPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_AnonymousPatternPart}.
	 * @param ctx the parse tree
	 */
	void exitOC_AnonymousPatternPart(@NotNull CypherParser.OC_AnonymousPatternPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_RelationshipTypes}.
	 * @param ctx the parse tree
	 */
	void enterOC_RelationshipTypes(@NotNull CypherParser.OC_RelationshipTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_RelationshipTypes}.
	 * @param ctx the parse tree
	 */
	void exitOC_RelationshipTypes(@NotNull CypherParser.OC_RelationshipTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_CaseExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_CaseExpression(@NotNull CypherParser.OC_CaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_CaseExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_CaseExpression(@NotNull CypherParser.OC_CaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Remove}.
	 * @param ctx the parse tree
	 */
	void enterOC_Remove(@NotNull CypherParser.OC_RemoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Remove}.
	 * @param ctx the parse tree
	 */
	void exitOC_Remove(@NotNull CypherParser.OC_RemoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_RemoveItem}.
	 * @param ctx the parse tree
	 */
	void enterOC_RemoveItem(@NotNull CypherParser.OC_RemoveItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_RemoveItem}.
	 * @param ctx the parse tree
	 */
	void exitOC_RemoveItem(@NotNull CypherParser.OC_RemoveItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_NotExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_NotExpression(@NotNull CypherParser.OC_NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_NotExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_NotExpression(@NotNull CypherParser.OC_NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_SetItem}.
	 * @param ctx the parse tree
	 */
	void enterOC_SetItem(@NotNull CypherParser.OC_SetItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_SetItem}.
	 * @param ctx the parse tree
	 */
	void exitOC_SetItem(@NotNull CypherParser.OC_SetItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ListLiteral}.
	 * @param ctx the parse tree
	 */
	void enterOC_ListLiteral(@NotNull CypherParser.OC_ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ListLiteral}.
	 * @param ctx the parse tree
	 */
	void exitOC_ListLiteral(@NotNull CypherParser.OC_ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ReturnItem}.
	 * @param ctx the parse tree
	 */
	void enterOC_ReturnItem(@NotNull CypherParser.OC_ReturnItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ReturnItem}.
	 * @param ctx the parse tree
	 */
	void exitOC_ReturnItem(@NotNull CypherParser.OC_ReturnItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_XorExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_XorExpression(@NotNull CypherParser.OC_XorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_XorExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_XorExpression(@NotNull CypherParser.OC_XorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Namespace}.
	 * @param ctx the parse tree
	 */
	void enterOC_Namespace(@NotNull CypherParser.OC_NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Namespace}.
	 * @param ctx the parse tree
	 */
	void exitOC_Namespace(@NotNull CypherParser.OC_NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PropertyExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_PropertyExpression(@NotNull CypherParser.OC_PropertyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PropertyExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_PropertyExpression(@NotNull CypherParser.OC_PropertyExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_NumberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterOC_NumberLiteral(@NotNull CypherParser.OC_NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_NumberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitOC_NumberLiteral(@NotNull CypherParser.OC_NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ReservedWord}.
	 * @param ctx the parse tree
	 */
	void enterOC_ReservedWord(@NotNull CypherParser.OC_ReservedWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ReservedWord}.
	 * @param ctx the parse tree
	 */
	void exitOC_ReservedWord(@NotNull CypherParser.OC_ReservedWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_FunctionName}.
	 * @param ctx the parse tree
	 */
	void enterOC_FunctionName(@NotNull CypherParser.OC_FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_FunctionName}.
	 * @param ctx the parse tree
	 */
	void exitOC_FunctionName(@NotNull CypherParser.OC_FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_UnaryAddOrSubtractExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_UnaryAddOrSubtractExpression(@NotNull CypherParser.OC_UnaryAddOrSubtractExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_UnaryAddOrSubtractExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_UnaryAddOrSubtractExpression(@NotNull CypherParser.OC_UnaryAddOrSubtractExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_SymbolicName}.
	 * @param ctx the parse tree
	 */
	void enterOC_SymbolicName(@NotNull CypherParser.OC_SymbolicNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_SymbolicName}.
	 * @param ctx the parse tree
	 */
	void exitOC_SymbolicName(@NotNull CypherParser.OC_SymbolicNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_YieldItem}.
	 * @param ctx the parse tree
	 */
	void enterOC_YieldItem(@NotNull CypherParser.OC_YieldItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_YieldItem}.
	 * @param ctx the parse tree
	 */
	void exitOC_YieldItem(@NotNull CypherParser.OC_YieldItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PowerOfExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_PowerOfExpression(@NotNull CypherParser.OC_PowerOfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PowerOfExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_PowerOfExpression(@NotNull CypherParser.OC_PowerOfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_IdInColl}.
	 * @param ctx the parse tree
	 */
	void enterOC_IdInColl(@NotNull CypherParser.OC_IdInCollContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_IdInColl}.
	 * @param ctx the parse tree
	 */
	void exitOC_IdInColl(@NotNull CypherParser.OC_IdInCollContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Delete}.
	 * @param ctx the parse tree
	 */
	void enterOC_Delete(@NotNull CypherParser.OC_DeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Delete}.
	 * @param ctx the parse tree
	 */
	void exitOC_Delete(@NotNull CypherParser.OC_DeleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ListOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_ListOperatorExpression(@NotNull CypherParser.OC_ListOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ListOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_ListOperatorExpression(@NotNull CypherParser.OC_ListOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_StringOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_StringOperatorExpression(@NotNull CypherParser.OC_StringOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_StringOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_StringOperatorExpression(@NotNull CypherParser.OC_StringOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_NodeLabel}.
	 * @param ctx the parse tree
	 */
	void enterOC_NodeLabel(@NotNull CypherParser.OC_NodeLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_NodeLabel}.
	 * @param ctx the parse tree
	 */
	void exitOC_NodeLabel(@NotNull CypherParser.OC_NodeLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_RegularQuery}.
	 * @param ctx the parse tree
	 */
	void enterOC_RegularQuery(@NotNull CypherParser.OC_RegularQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_RegularQuery}.
	 * @param ctx the parse tree
	 */
	void exitOC_RegularQuery(@NotNull CypherParser.OC_RegularQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_RelationshipsPattern}.
	 * @param ctx the parse tree
	 */
	void enterOC_RelationshipsPattern(@NotNull CypherParser.OC_RelationshipsPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_RelationshipsPattern}.
	 * @param ctx the parse tree
	 */
	void exitOC_RelationshipsPattern(@NotNull CypherParser.OC_RelationshipsPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_SchemaName}.
	 * @param ctx the parse tree
	 */
	void enterOC_SchemaName(@NotNull CypherParser.OC_SchemaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_SchemaName}.
	 * @param ctx the parse tree
	 */
	void exitOC_SchemaName(@NotNull CypherParser.OC_SchemaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Order}.
	 * @param ctx the parse tree
	 */
	void enterOC_Order(@NotNull CypherParser.OC_OrderContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Order}.
	 * @param ctx the parse tree
	 */
	void exitOC_Order(@NotNull CypherParser.OC_OrderContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Literal}.
	 * @param ctx the parse tree
	 */
	void enterOC_Literal(@NotNull CypherParser.OC_LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Literal}.
	 * @param ctx the parse tree
	 */
	void exitOC_Literal(@NotNull CypherParser.OC_LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ProcedureResultField}.
	 * @param ctx the parse tree
	 */
	void enterOC_ProcedureResultField(@NotNull CypherParser.OC_ProcedureResultFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ProcedureResultField}.
	 * @param ctx the parse tree
	 */
	void exitOC_ProcedureResultField(@NotNull CypherParser.OC_ProcedureResultFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ParenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_ParenthesizedExpression(@NotNull CypherParser.OC_ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ParenthesizedExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_ParenthesizedExpression(@NotNull CypherParser.OC_ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Unwind}.
	 * @param ctx the parse tree
	 */
	void enterOC_Unwind(@NotNull CypherParser.OC_UnwindContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Unwind}.
	 * @param ctx the parse tree
	 */
	void exitOC_Unwind(@NotNull CypherParser.OC_UnwindContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Set}.
	 * @param ctx the parse tree
	 */
	void enterOC_Set(@NotNull CypherParser.OC_SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Set}.
	 * @param ctx the parse tree
	 */
	void exitOC_Set(@NotNull CypherParser.OC_SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_RelTypeName}.
	 * @param ctx the parse tree
	 */
	void enterOC_RelTypeName(@NotNull CypherParser.OC_RelTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_RelTypeName}.
	 * @param ctx the parse tree
	 */
	void exitOC_RelTypeName(@NotNull CypherParser.OC_RelTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_NullOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_NullOperatorExpression(@NotNull CypherParser.OC_NullOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_NullOperatorExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_NullOperatorExpression(@NotNull CypherParser.OC_NullOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Properties}.
	 * @param ctx the parse tree
	 */
	void enterOC_Properties(@NotNull CypherParser.OC_PropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Properties}.
	 * @param ctx the parse tree
	 */
	void exitOC_Properties(@NotNull CypherParser.OC_PropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_LeftArrowHead}.
	 * @param ctx the parse tree
	 */
	void enterOC_LeftArrowHead(@NotNull CypherParser.OC_LeftArrowHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_LeftArrowHead}.
	 * @param ctx the parse tree
	 */
	void exitOC_LeftArrowHead(@NotNull CypherParser.OC_LeftArrowHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ImplicitProcedureInvocation}.
	 * @param ctx the parse tree
	 */
	void enterOC_ImplicitProcedureInvocation(@NotNull CypherParser.OC_ImplicitProcedureInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ImplicitProcedureInvocation}.
	 * @param ctx the parse tree
	 */
	void exitOC_ImplicitProcedureInvocation(@NotNull CypherParser.OC_ImplicitProcedureInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Union}.
	 * @param ctx the parse tree
	 */
	void enterOC_Union(@NotNull CypherParser.OC_UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Union}.
	 * @param ctx the parse tree
	 */
	void exitOC_Union(@NotNull CypherParser.OC_UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_SinglePartQuery}.
	 * @param ctx the parse tree
	 */
	void enterOC_SinglePartQuery(@NotNull CypherParser.OC_SinglePartQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_SinglePartQuery}.
	 * @param ctx the parse tree
	 */
	void exitOC_SinglePartQuery(@NotNull CypherParser.OC_SinglePartQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Return}.
	 * @param ctx the parse tree
	 */
	void enterOC_Return(@NotNull CypherParser.OC_ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Return}.
	 * @param ctx the parse tree
	 */
	void exitOC_Return(@NotNull CypherParser.OC_ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Where}.
	 * @param ctx the parse tree
	 */
	void enterOC_Where(@NotNull CypherParser.OC_WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Where}.
	 * @param ctx the parse tree
	 */
	void exitOC_Where(@NotNull CypherParser.OC_WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Pattern}.
	 * @param ctx the parse tree
	 */
	void enterOC_Pattern(@NotNull CypherParser.OC_PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Pattern}.
	 * @param ctx the parse tree
	 */
	void exitOC_Pattern(@NotNull CypherParser.OC_PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_NodePattern}.
	 * @param ctx the parse tree
	 */
	void enterOC_NodePattern(@NotNull CypherParser.OC_NodePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_NodePattern}.
	 * @param ctx the parse tree
	 */
	void exitOC_NodePattern(@NotNull CypherParser.OC_NodePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ProcedureName}.
	 * @param ctx the parse tree
	 */
	void enterOC_ProcedureName(@NotNull CypherParser.OC_ProcedureNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ProcedureName}.
	 * @param ctx the parse tree
	 */
	void exitOC_ProcedureName(@NotNull CypherParser.OC_ProcedureNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ComparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_ComparisonExpression(@NotNull CypherParser.OC_ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ComparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_ComparisonExpression(@NotNull CypherParser.OC_ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Atom}.
	 * @param ctx the parse tree
	 */
	void enterOC_Atom(@NotNull CypherParser.OC_AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Atom}.
	 * @param ctx the parse tree
	 */
	void exitOC_Atom(@NotNull CypherParser.OC_AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Merge}.
	 * @param ctx the parse tree
	 */
	void enterOC_Merge(@NotNull CypherParser.OC_MergeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Merge}.
	 * @param ctx the parse tree
	 */
	void exitOC_Merge(@NotNull CypherParser.OC_MergeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_InQueryCall}.
	 * @param ctx the parse tree
	 */
	void enterOC_InQueryCall(@NotNull CypherParser.OC_InQueryCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_InQueryCall}.
	 * @param ctx the parse tree
	 */
	void exitOC_InQueryCall(@NotNull CypherParser.OC_InQueryCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Parameter}.
	 * @param ctx the parse tree
	 */
	void enterOC_Parameter(@NotNull CypherParser.OC_ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Parameter}.
	 * @param ctx the parse tree
	 */
	void exitOC_Parameter(@NotNull CypherParser.OC_ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_SortItem}.
	 * @param ctx the parse tree
	 */
	void enterOC_SortItem(@NotNull CypherParser.OC_SortItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_SortItem}.
	 * @param ctx the parse tree
	 */
	void exitOC_SortItem(@NotNull CypherParser.OC_SortItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ReturnItems}.
	 * @param ctx the parse tree
	 */
	void enterOC_ReturnItems(@NotNull CypherParser.OC_ReturnItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ReturnItems}.
	 * @param ctx the parse tree
	 */
	void exitOC_ReturnItems(@NotNull CypherParser.OC_ReturnItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_StandaloneCall}.
	 * @param ctx the parse tree
	 */
	void enterOC_StandaloneCall(@NotNull CypherParser.OC_StandaloneCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_StandaloneCall}.
	 * @param ctx the parse tree
	 */
	void exitOC_StandaloneCall(@NotNull CypherParser.OC_StandaloneCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_RelationshipDetail}.
	 * @param ctx the parse tree
	 */
	void enterOC_RelationshipDetail(@NotNull CypherParser.OC_RelationshipDetailContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_RelationshipDetail}.
	 * @param ctx the parse tree
	 */
	void exitOC_RelationshipDetail(@NotNull CypherParser.OC_RelationshipDetailContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Skip}.
	 * @param ctx the parse tree
	 */
	void enterOC_Skip(@NotNull CypherParser.OC_SkipContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Skip}.
	 * @param ctx the parse tree
	 */
	void exitOC_Skip(@NotNull CypherParser.OC_SkipContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_MergeAction}.
	 * @param ctx the parse tree
	 */
	void enterOC_MergeAction(@NotNull CypherParser.OC_MergeActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_MergeAction}.
	 * @param ctx the parse tree
	 */
	void exitOC_MergeAction(@NotNull CypherParser.OC_MergeActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Statement}.
	 * @param ctx the parse tree
	 */
	void enterOC_Statement(@NotNull CypherParser.OC_StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Statement}.
	 * @param ctx the parse tree
	 */
	void exitOC_Statement(@NotNull CypherParser.OC_StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PatternComprehension}.
	 * @param ctx the parse tree
	 */
	void enterOC_PatternComprehension(@NotNull CypherParser.OC_PatternComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PatternComprehension}.
	 * @param ctx the parse tree
	 */
	void exitOC_PatternComprehension(@NotNull CypherParser.OC_PatternComprehensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Create}.
	 * @param ctx the parse tree
	 */
	void enterOC_Create(@NotNull CypherParser.OC_CreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Create}.
	 * @param ctx the parse tree
	 */
	void exitOC_Create(@NotNull CypherParser.OC_CreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_AndExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_AndExpression(@NotNull CypherParser.OC_AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_AndExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_AndExpression(@NotNull CypherParser.OC_AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ReturnBody}.
	 * @param ctx the parse tree
	 */
	void enterOC_ReturnBody(@NotNull CypherParser.OC_ReturnBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ReturnBody}.
	 * @param ctx the parse tree
	 */
	void exitOC_ReturnBody(@NotNull CypherParser.OC_ReturnBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Expression}.
	 * @param ctx the parse tree
	 */
	void enterOC_Expression(@NotNull CypherParser.OC_ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Expression}.
	 * @param ctx the parse tree
	 */
	void exitOC_Expression(@NotNull CypherParser.OC_ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Dash}.
	 * @param ctx the parse tree
	 */
	void enterOC_Dash(@NotNull CypherParser.OC_DashContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Dash}.
	 * @param ctx the parse tree
	 */
	void exitOC_Dash(@NotNull CypherParser.OC_DashContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_FilterExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_FilterExpression(@NotNull CypherParser.OC_FilterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_FilterExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_FilterExpression(@NotNull CypherParser.OC_FilterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_FunctionInvocation}.
	 * @param ctx the parse tree
	 */
	void enterOC_FunctionInvocation(@NotNull CypherParser.OC_FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_FunctionInvocation}.
	 * @param ctx the parse tree
	 */
	void exitOC_FunctionInvocation(@NotNull CypherParser.OC_FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Variable}.
	 * @param ctx the parse tree
	 */
	void enterOC_Variable(@NotNull CypherParser.OC_VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Variable}.
	 * @param ctx the parse tree
	 */
	void exitOC_Variable(@NotNull CypherParser.OC_VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_OrExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_OrExpression(@NotNull CypherParser.OC_OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_OrExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_OrExpression(@NotNull CypherParser.OC_OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PropertyKeyName}.
	 * @param ctx the parse tree
	 */
	void enterOC_PropertyKeyName(@NotNull CypherParser.OC_PropertyKeyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PropertyKeyName}.
	 * @param ctx the parse tree
	 */
	void exitOC_PropertyKeyName(@NotNull CypherParser.OC_PropertyKeyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ExplicitProcedureInvocation}.
	 * @param ctx the parse tree
	 */
	void enterOC_ExplicitProcedureInvocation(@NotNull CypherParser.OC_ExplicitProcedureInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ExplicitProcedureInvocation}.
	 * @param ctx the parse tree
	 */
	void exitOC_ExplicitProcedureInvocation(@NotNull CypherParser.OC_ExplicitProcedureInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_CaseAlternatives}.
	 * @param ctx the parse tree
	 */
	void enterOC_CaseAlternatives(@NotNull CypherParser.OC_CaseAlternativesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_CaseAlternatives}.
	 * @param ctx the parse tree
	 */
	void exitOC_CaseAlternatives(@NotNull CypherParser.OC_CaseAlternativesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_RelationshipPattern}.
	 * @param ctx the parse tree
	 */
	void enterOC_RelationshipPattern(@NotNull CypherParser.OC_RelationshipPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_RelationshipPattern}.
	 * @param ctx the parse tree
	 */
	void exitOC_RelationshipPattern(@NotNull CypherParser.OC_RelationshipPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_LabelName}.
	 * @param ctx the parse tree
	 */
	void enterOC_LabelName(@NotNull CypherParser.OC_LabelNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_LabelName}.
	 * @param ctx the parse tree
	 */
	void exitOC_LabelName(@NotNull CypherParser.OC_LabelNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_IntegerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterOC_IntegerLiteral(@NotNull CypherParser.OC_IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_IntegerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitOC_IntegerLiteral(@NotNull CypherParser.OC_IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_MultiplyDivideModuloExpression}.
	 * @param ctx the parse tree
	 */
	void enterOC_MultiplyDivideModuloExpression(@NotNull CypherParser.OC_MultiplyDivideModuloExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_MultiplyDivideModuloExpression}.
	 * @param ctx the parse tree
	 */
	void exitOC_MultiplyDivideModuloExpression(@NotNull CypherParser.OC_MultiplyDivideModuloExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_BooleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterOC_BooleanLiteral(@NotNull CypherParser.OC_BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_BooleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitOC_BooleanLiteral(@NotNull CypherParser.OC_BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_Query}.
	 * @param ctx the parse tree
	 */
	void enterOC_Query(@NotNull CypherParser.OC_QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_Query}.
	 * @param ctx the parse tree
	 */
	void exitOC_Query(@NotNull CypherParser.OC_QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PatternElementChain}.
	 * @param ctx the parse tree
	 */
	void enterOC_PatternElementChain(@NotNull CypherParser.OC_PatternElementChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PatternElementChain}.
	 * @param ctx the parse tree
	 */
	void exitOC_PatternElementChain(@NotNull CypherParser.OC_PatternElementChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PropertyLookup}.
	 * @param ctx the parse tree
	 */
	void enterOC_PropertyLookup(@NotNull CypherParser.OC_PropertyLookupContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PropertyLookup}.
	 * @param ctx the parse tree
	 */
	void exitOC_PropertyLookup(@NotNull CypherParser.OC_PropertyLookupContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_PatternElement}.
	 * @param ctx the parse tree
	 */
	void enterOC_PatternElement(@NotNull CypherParser.OC_PatternElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_PatternElement}.
	 * @param ctx the parse tree
	 */
	void exitOC_PatternElement(@NotNull CypherParser.OC_PatternElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_MapLiteral}.
	 * @param ctx the parse tree
	 */
	void enterOC_MapLiteral(@NotNull CypherParser.OC_MapLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_MapLiteral}.
	 * @param ctx the parse tree
	 */
	void exitOC_MapLiteral(@NotNull CypherParser.OC_MapLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_ReadingClause}.
	 * @param ctx the parse tree
	 */
	void enterOC_ReadingClause(@NotNull CypherParser.OC_ReadingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_ReadingClause}.
	 * @param ctx the parse tree
	 */
	void exitOC_ReadingClause(@NotNull CypherParser.OC_ReadingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CypherParser#oC_SingleQuery}.
	 * @param ctx the parse tree
	 */
	void enterOC_SingleQuery(@NotNull CypherParser.OC_SingleQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CypherParser#oC_SingleQuery}.
	 * @param ctx the parse tree
	 */
	void exitOC_SingleQuery(@NotNull CypherParser.OC_SingleQueryContext ctx);
}