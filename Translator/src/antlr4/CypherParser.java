// Generated from Cypher.g4 by ANTLR 4.7.2
package antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CypherParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		UNION=46, ALL=47, OPTIONAL=48, MATCH=49, UNWIND=50, AS=51, MERGE=52, ON=53, 
		CREATE=54, SET=55, DETACH=56, DELETE=57, REMOVE=58, CALL=59, YIELD=60, 
		WITH=61, DISTINCT=62, RETURN=63, ORDER=64, BY=65, L_SKIP=66, LIMIT=67, 
		ASCENDING=68, ASC=69, DESCENDING=70, DESC=71, WHERE=72, ALLSHORTESTPATHS=73, 
		OR=74, XOR=75, AND=76, NOT=77, IN=78, STARTS=79, ENDS=80, CONTAINS=81, 
		IS=82, NULL=83, COUNT=84, ANY=85, NONE=86, SINGLE=87, TRUE=88, FALSE=89, 
		EXISTS=90, CASE=91, ELSE=92, END=93, WHEN=94, THEN=95, StringLiteral=96, 
		EscapedChar=97, HexInteger=98, DecimalInteger=99, OctalInteger=100, HexLetter=101, 
		HexDigit=102, Digit=103, NonZeroDigit=104, NonZeroOctDigit=105, OctDigit=106, 
		ZeroDigit=107, ExponentDecimalReal=108, RegularDecimalReal=109, CONSTRAINT=110, 
		DO=111, FOR=112, REQUIRE=113, UNIQUE=114, MANDATORY=115, SCALAR=116, OF=117, 
		ADD=118, DROP=119, FILTER=120, EXTRACT=121, UnescapedSymbolicName=122, 
		IdentifierStart=123, IdentifierPart=124, EscapedSymbolicName=125, SP=126, 
		WHITESPACE=127, Comment=128;
	public static final int
		RULE_oC_Cypher = 0, RULE_oC_Statement = 1, RULE_oC_Query = 2, RULE_oC_RegularQuery = 3, 
		RULE_oC_Union = 4, RULE_oC_SingleQuery = 5, RULE_oC_SinglePartQuery = 6, 
		RULE_oC_MultiPartQuery = 7, RULE_oC_UpdatingClause = 8, RULE_oC_ReadingClause = 9, 
		RULE_oC_Match = 10, RULE_oC_Unwind = 11, RULE_oC_Merge = 12, RULE_oC_MergeAction = 13, 
		RULE_oC_Create = 14, RULE_oC_Set = 15, RULE_oC_SetItem = 16, RULE_oC_Delete = 17, 
		RULE_oC_Remove = 18, RULE_oC_RemoveItem = 19, RULE_oC_InQueryCall = 20, 
		RULE_oC_StandaloneCall = 21, RULE_oC_YieldItems = 22, RULE_oC_YieldItem = 23, 
		RULE_oC_With = 24, RULE_oC_Return = 25, RULE_oC_ReturnBody = 26, RULE_oC_ReturnItems = 27, 
		RULE_oC_ReturnItem = 28, RULE_oC_Order = 29, RULE_oC_Skip = 30, RULE_oC_Limit = 31, 
		RULE_oC_SortItem = 32, RULE_oC_Where = 33, RULE_oC_Pattern = 34, RULE_oC_PatternPart = 35, 
		RULE_oC_AnonymousPatternPart = 36, RULE_oC_PatternElement = 37, RULE_oC_NodePattern = 38, 
		RULE_oC_PatternElementChain = 39, RULE_oC_RelationshipPattern = 40, RULE_oC_RelationshipDetail = 41, 
		RULE_oC_Properties = 42, RULE_oC_RelationshipTypes = 43, RULE_oC_NodeLabels = 44, 
		RULE_oC_NodeLabel = 45, RULE_oC_RangeLiteral = 46, RULE_oC_LabelName = 47, 
		RULE_oC_RelTypeName = 48, RULE_oC_Expression = 49, RULE_oC_OrExpression = 50, 
		RULE_oC_XorExpression = 51, RULE_oC_AndExpression = 52, RULE_oC_NotExpression = 53, 
		RULE_oC_ComparisonExpression = 54, RULE_oC_AddOrSubtractExpression = 55, 
		RULE_oC_MultiplyDivideModuloExpression = 56, RULE_oC_PowerOfExpression = 57, 
		RULE_oC_UnaryAddOrSubtractExpression = 58, RULE_oC_StringListNullOperatorExpression = 59, 
		RULE_oC_ListOperatorExpression = 60, RULE_oC_StringOperatorExpression = 61, 
		RULE_oC_NullOperatorExpression = 62, RULE_oC_PropertyOrLabelsExpression = 63, 
		RULE_oC_Atom = 64, RULE_oC_Literal = 65, RULE_oC_BooleanLiteral = 66, 
		RULE_oC_ListLiteral = 67, RULE_oC_PartialComparisonExpression = 68, RULE_oC_ParenthesizedExpression = 69, 
		RULE_oC_RelationshipsPattern = 70, RULE_oC_FilterExpression = 71, RULE_oC_IdInColl = 72, 
		RULE_oC_FunctionInvocation = 73, RULE_oC_FunctionName = 74, RULE_oC_ExplicitProcedureInvocation = 75, 
		RULE_oC_ImplicitProcedureInvocation = 76, RULE_oC_ProcedureResultField = 77, 
		RULE_oC_ProcedureName = 78, RULE_oC_Namespace = 79, RULE_oC_ListComprehension = 80, 
		RULE_oC_PatternComprehension = 81, RULE_oC_PropertyLookup = 82, RULE_oC_CaseExpression = 83, 
		RULE_oC_CaseAlternatives = 84, RULE_oC_Variable = 85, RULE_oC_NumberLiteral = 86, 
		RULE_oC_MapLiteral = 87, RULE_oC_Parameter = 88, RULE_oC_PropertyExpression = 89, 
		RULE_oC_PropertyKeyName = 90, RULE_oC_IntegerLiteral = 91, RULE_oC_DoubleLiteral = 92, 
		RULE_oC_SchemaName = 93, RULE_oC_ReservedWord = 94, RULE_oC_SymbolicName = 95, 
		RULE_oC_LeftArrowHead = 96, RULE_oC_RightArrowHead = 97, RULE_oC_Dash = 98;
	private static String[] makeRuleNames() {
		return new String[] {
			"oC_Cypher", "oC_Statement", "oC_Query", "oC_RegularQuery", "oC_Union", 
			"oC_SingleQuery", "oC_SinglePartQuery", "oC_MultiPartQuery", "oC_UpdatingClause", 
			"oC_ReadingClause", "oC_Match", "oC_Unwind", "oC_Merge", "oC_MergeAction", 
			"oC_Create", "oC_Set", "oC_SetItem", "oC_Delete", "oC_Remove", "oC_RemoveItem", 
			"oC_InQueryCall", "oC_StandaloneCall", "oC_YieldItems", "oC_YieldItem", 
			"oC_With", "oC_Return", "oC_ReturnBody", "oC_ReturnItems", "oC_ReturnItem", 
			"oC_Order", "oC_Skip", "oC_Limit", "oC_SortItem", "oC_Where", "oC_Pattern", 
			"oC_PatternPart", "oC_AnonymousPatternPart", "oC_PatternElement", "oC_NodePattern", 
			"oC_PatternElementChain", "oC_RelationshipPattern", "oC_RelationshipDetail", 
			"oC_Properties", "oC_RelationshipTypes", "oC_NodeLabels", "oC_NodeLabel", 
			"oC_RangeLiteral", "oC_LabelName", "oC_RelTypeName", "oC_Expression", 
			"oC_OrExpression", "oC_XorExpression", "oC_AndExpression", "oC_NotExpression", 
			"oC_ComparisonExpression", "oC_AddOrSubtractExpression", "oC_MultiplyDivideModuloExpression", 
			"oC_PowerOfExpression", "oC_UnaryAddOrSubtractExpression", "oC_StringListNullOperatorExpression", 
			"oC_ListOperatorExpression", "oC_StringOperatorExpression", "oC_NullOperatorExpression", 
			"oC_PropertyOrLabelsExpression", "oC_Atom", "oC_Literal", "oC_BooleanLiteral", 
			"oC_ListLiteral", "oC_PartialComparisonExpression", "oC_ParenthesizedExpression", 
			"oC_RelationshipsPattern", "oC_FilterExpression", "oC_IdInColl", "oC_FunctionInvocation", 
			"oC_FunctionName", "oC_ExplicitProcedureInvocation", "oC_ImplicitProcedureInvocation", 
			"oC_ProcedureResultField", "oC_ProcedureName", "oC_Namespace", "oC_ListComprehension", 
			"oC_PatternComprehension", "oC_PropertyLookup", "oC_CaseExpression", 
			"oC_CaseAlternatives", "oC_Variable", "oC_NumberLiteral", "oC_MapLiteral", 
			"oC_Parameter", "oC_PropertyExpression", "oC_PropertyKeyName", "oC_IntegerLiteral", 
			"oC_DoubleLiteral", "oC_SchemaName", "oC_ReservedWord", "oC_SymbolicName", 
			"oC_LeftArrowHead", "oC_RightArrowHead", "oC_Dash"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "','", "'='", "'+='", "'*'", "'('", "')'", "'['", "']'", 
			"':'", "'|'", "'..'", "'+'", "'-'", "'/'", "'%'", "'^'", "'<>'", "'<'", 
			"'>'", "'<='", "'>='", "'.'", "'{'", "'}'", "'$'", "'\u27E8'", "'\u3008'", 
			"'\uFE64'", "'\uFF1C'", "'\u27E9'", "'\u3009'", "'\uFE65'", "'\uFF1E'", 
			"'\u00AD'", "'\u2010'", "'\u2011'", "'\u2012'", "'\u2013'", "'\u2014'", 
			"'\u2015'", "'\u2212'", "'\uFE58'", "'\uFE63'", "'\uFF0D'", null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'0'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "UNION", 
			"ALL", "OPTIONAL", "MATCH", "UNWIND", "AS", "MERGE", "ON", "CREATE", 
			"SET", "DETACH", "DELETE", "REMOVE", "CALL", "YIELD", "WITH", "DISTINCT", 
			"RETURN", "ORDER", "BY", "L_SKIP", "LIMIT", "ASCENDING", "ASC", "DESCENDING", 
			"DESC", "WHERE", "ALLSHORTESTPATHS", "OR", "XOR", "AND", "NOT", "IN", 
			"STARTS", "ENDS", "CONTAINS", "IS", "NULL", "COUNT", "ANY", "NONE", "SINGLE", 
			"TRUE", "FALSE", "EXISTS", "CASE", "ELSE", "END", "WHEN", "THEN", "StringLiteral", 
			"EscapedChar", "HexInteger", "DecimalInteger", "OctalInteger", "HexLetter", 
			"HexDigit", "Digit", "NonZeroDigit", "NonZeroOctDigit", "OctDigit", "ZeroDigit", 
			"ExponentDecimalReal", "RegularDecimalReal", "CONSTRAINT", "DO", "FOR", 
			"REQUIRE", "UNIQUE", "MANDATORY", "SCALAR", "OF", "ADD", "DROP", "FILTER", 
			"EXTRACT", "UnescapedSymbolicName", "IdentifierStart", "IdentifierPart", 
			"EscapedSymbolicName", "SP", "WHITESPACE", "Comment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cypher.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CypherParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class OC_CypherContext extends ParserRuleContext {
		public OC_StatementContext oC_Statement() {
			return getRuleContext(OC_StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CypherParser.EOF, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_CypherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Cypher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Cypher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Cypher(this);
		}
	}

	public final OC_CypherContext oC_Cypher() throws RecognitionException {
		OC_CypherContext _localctx = new OC_CypherContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_oC_Cypher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(198);
				match(SP);
				}
			}

			setState(201);
			oC_Statement();
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(202);
					match(SP);
					}
				}

				setState(205);
				match(T__0);
				}
				break;
			}
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(208);
				match(SP);
				}
			}

			setState(211);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_StatementContext extends ParserRuleContext {
		public OC_QueryContext oC_Query() {
			return getRuleContext(OC_QueryContext.class,0);
		}
		public OC_StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Statement(this);
		}
	}

	public final OC_StatementContext oC_Statement() throws RecognitionException {
		OC_StatementContext _localctx = new OC_StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_oC_Statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			oC_Query();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_QueryContext extends ParserRuleContext {
		public OC_RegularQueryContext oC_RegularQuery() {
			return getRuleContext(OC_RegularQueryContext.class,0);
		}
		public OC_StandaloneCallContext oC_StandaloneCall() {
			return getRuleContext(OC_StandaloneCallContext.class,0);
		}
		public OC_QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Query(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Query(this);
		}
	}

	public final OC_QueryContext oC_Query() throws RecognitionException {
		OC_QueryContext _localctx = new OC_QueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_oC_Query);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				oC_RegularQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				oC_StandaloneCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RegularQueryContext extends ParserRuleContext {
		public OC_SingleQueryContext oC_SingleQuery() {
			return getRuleContext(OC_SingleQueryContext.class,0);
		}
		public List<OC_UnionContext> oC_Union() {
			return getRuleContexts(OC_UnionContext.class);
		}
		public OC_UnionContext oC_Union(int i) {
			return getRuleContext(OC_UnionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_RegularQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RegularQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_RegularQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_RegularQuery(this);
		}
	}

	public final OC_RegularQueryContext oC_RegularQuery() throws RecognitionException {
		OC_RegularQueryContext _localctx = new OC_RegularQueryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_oC_RegularQuery);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			oC_SingleQuery();
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(220);
						match(SP);
						}
					}

					setState(223);
					oC_Union();
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_UnionContext extends ParserRuleContext {
		public TerminalNode UNION() { return getToken(CypherParser.UNION, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode ALL() { return getToken(CypherParser.ALL, 0); }
		public OC_SingleQueryContext oC_SingleQuery() {
			return getRuleContext(OC_SingleQueryContext.class,0);
		}
		public OC_UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Union(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Union(this);
		}
	}

	public final OC_UnionContext oC_Union() throws RecognitionException {
		OC_UnionContext _localctx = new OC_UnionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_oC_Union);
		int _la;
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(229);
				match(UNION);
				setState(230);
				match(SP);
				setState(231);
				match(ALL);
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(232);
					match(SP);
					}
				}

				setState(235);
				oC_SingleQuery();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(236);
				match(UNION);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(237);
					match(SP);
					}
				}

				setState(240);
				oC_SingleQuery();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SingleQueryContext extends ParserRuleContext {
		public OC_SinglePartQueryContext oC_SinglePartQuery() {
			return getRuleContext(OC_SinglePartQueryContext.class,0);
		}
		public OC_MultiPartQueryContext oC_MultiPartQuery() {
			return getRuleContext(OC_MultiPartQueryContext.class,0);
		}
		public OC_SingleQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SingleQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_SingleQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_SingleQuery(this);
		}
	}

	public final OC_SingleQueryContext oC_SingleQuery() throws RecognitionException {
		OC_SingleQueryContext _localctx = new OC_SingleQueryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_oC_SingleQuery);
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				oC_SinglePartQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				oC_MultiPartQuery();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SinglePartQueryContext extends ParserRuleContext {
		public OC_ReturnContext oC_Return() {
			return getRuleContext(OC_ReturnContext.class,0);
		}
		public List<OC_ReadingClauseContext> oC_ReadingClause() {
			return getRuleContexts(OC_ReadingClauseContext.class);
		}
		public OC_ReadingClauseContext oC_ReadingClause(int i) {
			return getRuleContext(OC_ReadingClauseContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<OC_UpdatingClauseContext> oC_UpdatingClause() {
			return getRuleContexts(OC_UpdatingClauseContext.class);
		}
		public OC_UpdatingClauseContext oC_UpdatingClause(int i) {
			return getRuleContext(OC_UpdatingClauseContext.class,i);
		}
		public OC_SinglePartQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SinglePartQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_SinglePartQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_SinglePartQuery(this);
		}
	}

	public final OC_SinglePartQueryContext oC_SinglePartQuery() throws RecognitionException {
		OC_SinglePartQueryContext _localctx = new OC_SinglePartQueryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_oC_SinglePartQuery);
		int _la;
		try {
			int _alt;
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPTIONAL) | (1L << MATCH) | (1L << UNWIND) | (1L << CALL))) != 0)) {
					{
					{
					setState(247);
					oC_ReadingClause();
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(248);
						match(SP);
						}
					}

					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(256);
				oC_Return();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPTIONAL) | (1L << MATCH) | (1L << UNWIND) | (1L << CALL))) != 0)) {
					{
					{
					setState(257);
					oC_ReadingClause();
					setState(259);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(258);
						match(SP);
						}
					}

					}
					}
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(266);
				oC_UpdatingClause();
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(268);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(267);
							match(SP);
							}
						}

						setState(270);
						oC_UpdatingClause();
						}
						} 
					}
					setState(275);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(280);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(276);
						match(SP);
						}
					}

					setState(279);
					oC_Return();
					}
					break;
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MultiPartQueryContext extends ParserRuleContext {
		public OC_SinglePartQueryContext oC_SinglePartQuery() {
			return getRuleContext(OC_SinglePartQueryContext.class,0);
		}
		public List<OC_WithContext> oC_With() {
			return getRuleContexts(OC_WithContext.class);
		}
		public OC_WithContext oC_With(int i) {
			return getRuleContext(OC_WithContext.class,i);
		}
		public List<OC_ReadingClauseContext> oC_ReadingClause() {
			return getRuleContexts(OC_ReadingClauseContext.class);
		}
		public OC_ReadingClauseContext oC_ReadingClause(int i) {
			return getRuleContext(OC_ReadingClauseContext.class,i);
		}
		public List<OC_UpdatingClauseContext> oC_UpdatingClause() {
			return getRuleContexts(OC_UpdatingClauseContext.class);
		}
		public OC_UpdatingClauseContext oC_UpdatingClause(int i) {
			return getRuleContext(OC_UpdatingClauseContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_MultiPartQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_MultiPartQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_MultiPartQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_MultiPartQuery(this);
		}
	}

	public final OC_MultiPartQueryContext oC_MultiPartQuery() throws RecognitionException {
		OC_MultiPartQueryContext _localctx = new OC_MultiPartQueryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_oC_MultiPartQuery);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(306); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(290);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPTIONAL) | (1L << MATCH) | (1L << UNWIND) | (1L << CALL))) != 0)) {
						{
						{
						setState(284);
						oC_ReadingClause();
						setState(286);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(285);
							match(SP);
							}
						}

						}
						}
						setState(292);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MERGE) | (1L << CREATE) | (1L << SET) | (1L << DETACH) | (1L << DELETE) | (1L << REMOVE))) != 0)) {
						{
						{
						setState(293);
						oC_UpdatingClause();
						setState(295);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(294);
							match(SP);
							}
						}

						}
						}
						setState(301);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(302);
					oC_With();
					setState(304);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(303);
						match(SP);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(308); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(310);
			oC_SinglePartQuery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_UpdatingClauseContext extends ParserRuleContext {
		public OC_CreateContext oC_Create() {
			return getRuleContext(OC_CreateContext.class,0);
		}
		public OC_MergeContext oC_Merge() {
			return getRuleContext(OC_MergeContext.class,0);
		}
		public OC_DeleteContext oC_Delete() {
			return getRuleContext(OC_DeleteContext.class,0);
		}
		public OC_SetContext oC_Set() {
			return getRuleContext(OC_SetContext.class,0);
		}
		public OC_RemoveContext oC_Remove() {
			return getRuleContext(OC_RemoveContext.class,0);
		}
		public OC_UpdatingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_UpdatingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_UpdatingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_UpdatingClause(this);
		}
	}

	public final OC_UpdatingClauseContext oC_UpdatingClause() throws RecognitionException {
		OC_UpdatingClauseContext _localctx = new OC_UpdatingClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_oC_UpdatingClause);
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				oC_Create();
				}
				break;
			case MERGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				oC_Merge();
				}
				break;
			case DETACH:
			case DELETE:
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				oC_Delete();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 4);
				{
				setState(315);
				oC_Set();
				}
				break;
			case REMOVE:
				enterOuterAlt(_localctx, 5);
				{
				setState(316);
				oC_Remove();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ReadingClauseContext extends ParserRuleContext {
		public OC_MatchContext oC_Match() {
			return getRuleContext(OC_MatchContext.class,0);
		}
		public OC_UnwindContext oC_Unwind() {
			return getRuleContext(OC_UnwindContext.class,0);
		}
		public OC_InQueryCallContext oC_InQueryCall() {
			return getRuleContext(OC_InQueryCallContext.class,0);
		}
		public OC_ReadingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ReadingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ReadingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ReadingClause(this);
		}
	}

	public final OC_ReadingClauseContext oC_ReadingClause() throws RecognitionException {
		OC_ReadingClauseContext _localctx = new OC_ReadingClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_oC_ReadingClause);
		try {
			setState(322);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTIONAL:
			case MATCH:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				oC_Match();
				}
				break;
			case UNWIND:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				oC_Unwind();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 3);
				{
				setState(321);
				oC_InQueryCall();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MatchContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(CypherParser.MATCH, 0); }
		public OC_PatternContext oC_Pattern() {
			return getRuleContext(OC_PatternContext.class,0);
		}
		public TerminalNode OPTIONAL() { return getToken(CypherParser.OPTIONAL, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_WhereContext oC_Where() {
			return getRuleContext(OC_WhereContext.class,0);
		}
		public OC_MatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Match; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Match(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Match(this);
		}
	}

	public final OC_MatchContext oC_Match() throws RecognitionException {
		OC_MatchContext _localctx = new OC_MatchContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_oC_Match);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPTIONAL) {
				{
				setState(324);
				match(OPTIONAL);
				setState(325);
				match(SP);
				}
			}

			setState(328);
			match(MATCH);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(329);
				match(SP);
				}
			}

			setState(332);
			oC_Pattern();
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(333);
					match(SP);
					}
				}

				setState(336);
				oC_Where();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_UnwindContext extends ParserRuleContext {
		public TerminalNode UNWIND() { return getToken(CypherParser.UNWIND, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode AS() { return getToken(CypherParser.AS, 0); }
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_UnwindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Unwind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Unwind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Unwind(this);
		}
	}

	public final OC_UnwindContext oC_Unwind() throws RecognitionException {
		OC_UnwindContext _localctx = new OC_UnwindContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_oC_Unwind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(UNWIND);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(340);
				match(SP);
				}
			}

			setState(343);
			oC_Expression();
			setState(344);
			match(SP);
			setState(345);
			match(AS);
			setState(346);
			match(SP);
			setState(347);
			oC_Variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MergeContext extends ParserRuleContext {
		public TerminalNode MERGE() { return getToken(CypherParser.MERGE, 0); }
		public OC_PatternPartContext oC_PatternPart() {
			return getRuleContext(OC_PatternPartContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<OC_MergeActionContext> oC_MergeAction() {
			return getRuleContexts(OC_MergeActionContext.class);
		}
		public OC_MergeActionContext oC_MergeAction(int i) {
			return getRuleContext(OC_MergeActionContext.class,i);
		}
		public OC_MergeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Merge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Merge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Merge(this);
		}
	}

	public final OC_MergeContext oC_Merge() throws RecognitionException {
		OC_MergeContext _localctx = new OC_MergeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_oC_Merge);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(MERGE);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(350);
				match(SP);
				}
			}

			setState(353);
			oC_PatternPart();
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(354);
					match(SP);
					setState(355);
					oC_MergeAction();
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MergeActionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(CypherParser.ON, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode MATCH() { return getToken(CypherParser.MATCH, 0); }
		public OC_SetContext oC_Set() {
			return getRuleContext(OC_SetContext.class,0);
		}
		public TerminalNode CREATE() { return getToken(CypherParser.CREATE, 0); }
		public OC_MergeActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_MergeAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_MergeAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_MergeAction(this);
		}
	}

	public final OC_MergeActionContext oC_MergeAction() throws RecognitionException {
		OC_MergeActionContext _localctx = new OC_MergeActionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_oC_MergeAction);
		try {
			setState(371);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(361);
				match(ON);
				setState(362);
				match(SP);
				setState(363);
				match(MATCH);
				setState(364);
				match(SP);
				setState(365);
				oC_Set();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(366);
				match(ON);
				setState(367);
				match(SP);
				setState(368);
				match(CREATE);
				setState(369);
				match(SP);
				setState(370);
				oC_Set();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_CreateContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(CypherParser.CREATE, 0); }
		public OC_PatternContext oC_Pattern() {
			return getRuleContext(OC_PatternContext.class,0);
		}
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Create(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Create(this);
		}
	}

	public final OC_CreateContext oC_Create() throws RecognitionException {
		OC_CreateContext _localctx = new OC_CreateContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_oC_Create);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(CREATE);
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(374);
				match(SP);
				}
			}

			setState(377);
			oC_Pattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SetContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(CypherParser.SET, 0); }
		public List<OC_SetItemContext> oC_SetItem() {
			return getRuleContexts(OC_SetItemContext.class);
		}
		public OC_SetItemContext oC_SetItem(int i) {
			return getRuleContext(OC_SetItemContext.class,i);
		}
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Set(this);
		}
	}

	public final OC_SetContext oC_Set() throws RecognitionException {
		OC_SetContext _localctx = new OC_SetContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_oC_Set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(SET);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(380);
				match(SP);
				}
			}

			setState(383);
			oC_SetItem();
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(384);
				match(T__1);
				setState(385);
				oC_SetItem();
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SetItemContext extends ParserRuleContext {
		public OC_PropertyExpressionContext oC_PropertyExpression() {
			return getRuleContext(OC_PropertyExpressionContext.class,0);
		}
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_NodeLabelsContext oC_NodeLabels() {
			return getRuleContext(OC_NodeLabelsContext.class,0);
		}
		public OC_SetItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SetItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_SetItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_SetItem(this);
		}
	}

	public final OC_SetItemContext oC_SetItem() throws RecognitionException {
		OC_SetItemContext _localctx = new OC_SetItemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_oC_SetItem);
		int _la;
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(391);
				oC_PropertyExpression();
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(392);
					match(SP);
					}
				}

				setState(395);
				match(T__2);
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(396);
					match(SP);
					}
				}

				setState(399);
				oC_Expression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(401);
				oC_Variable();
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(402);
					match(SP);
					}
				}

				setState(405);
				match(T__2);
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(406);
					match(SP);
					}
				}

				setState(409);
				oC_Expression();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(411);
				oC_Variable();
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(412);
					match(SP);
					}
				}

				setState(415);
				match(T__3);
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(416);
					match(SP);
					}
				}

				setState(419);
				oC_Expression();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(421);
				oC_Variable();
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(422);
					match(SP);
					}
				}

				setState(425);
				oC_NodeLabels();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_DeleteContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(CypherParser.DELETE, 0); }
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public TerminalNode DETACH() { return getToken(CypherParser.DETACH, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Delete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Delete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Delete(this);
		}
	}

	public final OC_DeleteContext oC_Delete() throws RecognitionException {
		OC_DeleteContext _localctx = new OC_DeleteContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_oC_Delete);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DETACH) {
				{
				setState(429);
				match(DETACH);
				setState(430);
				match(SP);
				}
			}

			setState(433);
			match(DELETE);
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(434);
				match(SP);
				}
			}

			setState(437);
			oC_Expression();
			setState(448);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(439);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(438);
						match(SP);
						}
					}

					setState(441);
					match(T__1);
					setState(443);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(442);
						match(SP);
						}
					}

					setState(445);
					oC_Expression();
					}
					} 
				}
				setState(450);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RemoveContext extends ParserRuleContext {
		public TerminalNode REMOVE() { return getToken(CypherParser.REMOVE, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<OC_RemoveItemContext> oC_RemoveItem() {
			return getRuleContexts(OC_RemoveItemContext.class);
		}
		public OC_RemoveItemContext oC_RemoveItem(int i) {
			return getRuleContext(OC_RemoveItemContext.class,i);
		}
		public OC_RemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Remove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Remove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Remove(this);
		}
	}

	public final OC_RemoveContext oC_Remove() throws RecognitionException {
		OC_RemoveContext _localctx = new OC_RemoveContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_oC_Remove);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(REMOVE);
			setState(452);
			match(SP);
			setState(453);
			oC_RemoveItem();
			setState(464);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(455);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(454);
						match(SP);
						}
					}

					setState(457);
					match(T__1);
					setState(459);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(458);
						match(SP);
						}
					}

					setState(461);
					oC_RemoveItem();
					}
					} 
				}
				setState(466);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RemoveItemContext extends ParserRuleContext {
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_NodeLabelsContext oC_NodeLabels() {
			return getRuleContext(OC_NodeLabelsContext.class,0);
		}
		public OC_PropertyExpressionContext oC_PropertyExpression() {
			return getRuleContext(OC_PropertyExpressionContext.class,0);
		}
		public OC_RemoveItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RemoveItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_RemoveItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_RemoveItem(this);
		}
	}

	public final OC_RemoveItemContext oC_RemoveItem() throws RecognitionException {
		OC_RemoveItemContext _localctx = new OC_RemoveItemContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_oC_RemoveItem);
		try {
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(467);
				oC_Variable();
				setState(468);
				oC_NodeLabels();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
				oC_PropertyExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_InQueryCallContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(CypherParser.CALL, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_ExplicitProcedureInvocationContext oC_ExplicitProcedureInvocation() {
			return getRuleContext(OC_ExplicitProcedureInvocationContext.class,0);
		}
		public TerminalNode YIELD() { return getToken(CypherParser.YIELD, 0); }
		public OC_YieldItemsContext oC_YieldItems() {
			return getRuleContext(OC_YieldItemsContext.class,0);
		}
		public OC_InQueryCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_InQueryCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_InQueryCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_InQueryCall(this);
		}
	}

	public final OC_InQueryCallContext oC_InQueryCall() throws RecognitionException {
		OC_InQueryCallContext _localctx = new OC_InQueryCallContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_oC_InQueryCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(CALL);
			setState(474);
			match(SP);
			setState(475);
			oC_ExplicitProcedureInvocation();
			setState(482);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(476);
					match(SP);
					}
				}

				setState(479);
				match(YIELD);
				setState(480);
				match(SP);
				setState(481);
				oC_YieldItems();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_StandaloneCallContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(CypherParser.CALL, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_ExplicitProcedureInvocationContext oC_ExplicitProcedureInvocation() {
			return getRuleContext(OC_ExplicitProcedureInvocationContext.class,0);
		}
		public OC_ImplicitProcedureInvocationContext oC_ImplicitProcedureInvocation() {
			return getRuleContext(OC_ImplicitProcedureInvocationContext.class,0);
		}
		public TerminalNode YIELD() { return getToken(CypherParser.YIELD, 0); }
		public OC_YieldItemsContext oC_YieldItems() {
			return getRuleContext(OC_YieldItemsContext.class,0);
		}
		public OC_StandaloneCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_StandaloneCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_StandaloneCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_StandaloneCall(this);
		}
	}

	public final OC_StandaloneCallContext oC_StandaloneCall() throws RecognitionException {
		OC_StandaloneCallContext _localctx = new OC_StandaloneCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_oC_StandaloneCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			match(CALL);
			setState(485);
			match(SP);
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(486);
				oC_ExplicitProcedureInvocation();
				}
				break;
			case 2:
				{
				setState(487);
				oC_ImplicitProcedureInvocation();
				}
				break;
			}
			setState(494);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(490);
				match(SP);
				setState(491);
				match(YIELD);
				setState(492);
				match(SP);
				setState(493);
				oC_YieldItems();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_YieldItemsContext extends ParserRuleContext {
		public OC_WhereContext oC_Where() {
			return getRuleContext(OC_WhereContext.class,0);
		}
		public List<OC_YieldItemContext> oC_YieldItem() {
			return getRuleContexts(OC_YieldItemContext.class);
		}
		public OC_YieldItemContext oC_YieldItem(int i) {
			return getRuleContext(OC_YieldItemContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_YieldItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_YieldItems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_YieldItems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_YieldItems(this);
		}
	}

	public final OC_YieldItemsContext oC_YieldItems() throws RecognitionException {
		OC_YieldItemsContext _localctx = new OC_YieldItemsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_oC_YieldItems);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(496);
				match(T__4);
				}
				break;
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case HexLetter:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				{
				{
				setState(497);
				oC_YieldItem();
				setState(508);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(499);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(498);
							match(SP);
							}
						}

						setState(501);
						match(T__1);
						setState(503);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(502);
							match(SP);
							}
						}

						setState(505);
						oC_YieldItem();
						}
						} 
					}
					setState(510);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(517);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(513);
					match(SP);
					}
				}

				setState(516);
				oC_Where();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_YieldItemContext extends ParserRuleContext {
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_ProcedureResultFieldContext oC_ProcedureResultField() {
			return getRuleContext(OC_ProcedureResultFieldContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode AS() { return getToken(CypherParser.AS, 0); }
		public OC_YieldItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_YieldItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_YieldItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_YieldItem(this);
		}
	}

	public final OC_YieldItemContext oC_YieldItem() throws RecognitionException {
		OC_YieldItemContext _localctx = new OC_YieldItemContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_oC_YieldItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(519);
				oC_ProcedureResultField();
				setState(520);
				match(SP);
				setState(521);
				match(AS);
				setState(522);
				match(SP);
				}
				break;
			}
			setState(526);
			oC_Variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_WithContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(CypherParser.WITH, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_ReturnBodyContext oC_ReturnBody() {
			return getRuleContext(OC_ReturnBodyContext.class,0);
		}
		public TerminalNode DISTINCT() { return getToken(CypherParser.DISTINCT, 0); }
		public OC_WhereContext oC_Where() {
			return getRuleContext(OC_WhereContext.class,0);
		}
		public OC_WithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_With; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_With(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_With(this);
		}
	}

	public final OC_WithContext oC_With() throws RecognitionException {
		OC_WithContext _localctx = new OC_WithContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_oC_With);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			match(WITH);
			setState(533);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(530);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(529);
					match(SP);
					}
				}

				setState(532);
				match(DISTINCT);
				}
				break;
			}
			setState(535);
			match(SP);
			setState(536);
			oC_ReturnBody();
			setState(541);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(538);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(537);
					match(SP);
					}
				}

				setState(540);
				oC_Where();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CypherParser.RETURN, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_ReturnBodyContext oC_ReturnBody() {
			return getRuleContext(OC_ReturnBodyContext.class,0);
		}
		public TerminalNode DISTINCT() { return getToken(CypherParser.DISTINCT, 0); }
		public OC_ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Return(this);
		}
	}

	public final OC_ReturnContext oC_Return() throws RecognitionException {
		OC_ReturnContext _localctx = new OC_ReturnContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_oC_Return);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			match(RETURN);
			setState(548);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(544);
					match(SP);
					}
				}

				setState(547);
				match(DISTINCT);
				}
				break;
			}
			setState(550);
			match(SP);
			setState(551);
			oC_ReturnBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ReturnBodyContext extends ParserRuleContext {
		public OC_ReturnItemsContext oC_ReturnItems() {
			return getRuleContext(OC_ReturnItemsContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_OrderContext oC_Order() {
			return getRuleContext(OC_OrderContext.class,0);
		}
		public OC_SkipContext oC_Skip() {
			return getRuleContext(OC_SkipContext.class,0);
		}
		public OC_LimitContext oC_Limit() {
			return getRuleContext(OC_LimitContext.class,0);
		}
		public OC_ReturnBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ReturnBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ReturnBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ReturnBody(this);
		}
	}

	public final OC_ReturnBodyContext oC_ReturnBody() throws RecognitionException {
		OC_ReturnBodyContext _localctx = new OC_ReturnBodyContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_oC_ReturnBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			oC_ReturnItems();
			setState(556);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(554);
				match(SP);
				setState(555);
				oC_Order();
				}
				break;
			}
			setState(560);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(558);
				match(SP);
				setState(559);
				oC_Skip();
				}
				break;
			}
			setState(564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(562);
				match(SP);
				setState(563);
				oC_Limit();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ReturnItemsContext extends ParserRuleContext {
		public List<OC_ReturnItemContext> oC_ReturnItem() {
			return getRuleContexts(OC_ReturnItemContext.class);
		}
		public OC_ReturnItemContext oC_ReturnItem(int i) {
			return getRuleContext(OC_ReturnItemContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_ReturnItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ReturnItems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ReturnItems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ReturnItems(this);
		}
	}

	public final OC_ReturnItemsContext oC_ReturnItems() throws RecognitionException {
		OC_ReturnItemsContext _localctx = new OC_ReturnItemsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_oC_ReturnItems);
		int _la;
		try {
			int _alt;
			setState(594);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(566);
				match(T__4);
				setState(577);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(568);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(567);
							match(SP);
							}
						}

						setState(570);
						match(T__1);
						setState(572);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(571);
							match(SP);
							}
						}

						setState(574);
						oC_ReturnItem();
						}
						} 
					}
					setState(579);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
				}
				}
				}
				break;
			case T__5:
			case T__7:
			case T__12:
			case T__13:
			case T__23:
			case T__25:
			case ALL:
			case NOT:
			case NULL:
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case TRUE:
			case FALSE:
			case EXISTS:
			case CASE:
			case StringLiteral:
			case HexInteger:
			case DecimalInteger:
			case OctalInteger:
			case HexLetter:
			case ExponentDecimalReal:
			case RegularDecimalReal:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(580);
				oC_ReturnItem();
				setState(591);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(582);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(581);
							match(SP);
							}
						}

						setState(584);
						match(T__1);
						setState(586);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(585);
							match(SP);
							}
						}

						setState(588);
						oC_ReturnItem();
						}
						} 
					}
					setState(593);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ReturnItemContext extends ParserRuleContext {
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode AS() { return getToken(CypherParser.AS, 0); }
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_ReturnItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ReturnItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ReturnItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ReturnItem(this);
		}
	}

	public final OC_ReturnItemContext oC_ReturnItem() throws RecognitionException {
		OC_ReturnItemContext _localctx = new OC_ReturnItemContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_oC_ReturnItem);
		try {
			setState(603);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(596);
				oC_Expression();
				setState(597);
				match(SP);
				setState(598);
				match(AS);
				setState(599);
				match(SP);
				setState(600);
				oC_Variable();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(602);
				oC_Expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_OrderContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(CypherParser.ORDER, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode BY() { return getToken(CypherParser.BY, 0); }
		public List<OC_SortItemContext> oC_SortItem() {
			return getRuleContexts(OC_SortItemContext.class);
		}
		public OC_SortItemContext oC_SortItem(int i) {
			return getRuleContext(OC_SortItemContext.class,i);
		}
		public OC_OrderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Order(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Order(this);
		}
	}

	public final OC_OrderContext oC_Order() throws RecognitionException {
		OC_OrderContext _localctx = new OC_OrderContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_oC_Order);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			match(ORDER);
			setState(606);
			match(SP);
			setState(607);
			match(BY);
			setState(608);
			match(SP);
			setState(609);
			oC_SortItem();
			setState(617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(610);
				match(T__1);
				setState(612);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(611);
					match(SP);
					}
				}

				setState(614);
				oC_SortItem();
				}
				}
				setState(619);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SkipContext extends ParserRuleContext {
		public TerminalNode L_SKIP() { return getToken(CypherParser.L_SKIP, 0); }
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_SkipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Skip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Skip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Skip(this);
		}
	}

	public final OC_SkipContext oC_Skip() throws RecognitionException {
		OC_SkipContext _localctx = new OC_SkipContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_oC_Skip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			match(L_SKIP);
			setState(621);
			match(SP);
			setState(622);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_LimitContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(CypherParser.LIMIT, 0); }
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Limit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Limit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Limit(this);
		}
	}

	public final OC_LimitContext oC_Limit() throws RecognitionException {
		OC_LimitContext _localctx = new OC_LimitContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_oC_Limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(LIMIT);
			setState(625);
			match(SP);
			setState(626);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SortItemContext extends ParserRuleContext {
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public TerminalNode ASCENDING() { return getToken(CypherParser.ASCENDING, 0); }
		public TerminalNode ASC() { return getToken(CypherParser.ASC, 0); }
		public TerminalNode DESCENDING() { return getToken(CypherParser.DESCENDING, 0); }
		public TerminalNode DESC() { return getToken(CypherParser.DESC, 0); }
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_SortItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SortItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_SortItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_SortItem(this);
		}
	}

	public final OC_SortItemContext oC_SortItem() throws RecognitionException {
		OC_SortItemContext _localctx = new OC_SortItemContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_oC_SortItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			oC_Expression();
			setState(633);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(629);
					match(SP);
					}
				}

				setState(632);
				_la = _input.LA(1);
				if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (ASCENDING - 68)) | (1L << (ASC - 68)) | (1L << (DESCENDING - 68)) | (1L << (DESC - 68)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_WhereContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(CypherParser.WHERE, 0); }
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Where(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Where(this);
		}
	}

	public final OC_WhereContext oC_Where() throws RecognitionException {
		OC_WhereContext _localctx = new OC_WhereContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_oC_Where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			match(WHERE);
			setState(636);
			match(SP);
			setState(637);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternContext extends ParserRuleContext {
		public List<OC_PatternPartContext> oC_PatternPart() {
			return getRuleContexts(OC_PatternPartContext.class);
		}
		public OC_PatternPartContext oC_PatternPart(int i) {
			return getRuleContext(OC_PatternPartContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Pattern(this);
		}
	}

	public final OC_PatternContext oC_Pattern() throws RecognitionException {
		OC_PatternContext _localctx = new OC_PatternContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_oC_Pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			oC_PatternPart();
			setState(650);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(641);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(640);
						match(SP);
						}
					}

					setState(643);
					match(T__1);
					setState(645);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(644);
						match(SP);
						}
					}

					setState(647);
					oC_PatternPart();
					}
					} 
				}
				setState(652);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternPartContext extends ParserRuleContext {
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_AnonymousPatternPartContext oC_AnonymousPatternPart() {
			return getRuleContext(OC_AnonymousPatternPartContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode ALLSHORTESTPATHS() { return getToken(CypherParser.ALLSHORTESTPATHS, 0); }
		public OC_PatternPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PatternPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PatternPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PatternPart(this);
		}
	}

	public final OC_PatternPartContext oC_PatternPart() throws RecognitionException {
		OC_PatternPartContext _localctx = new OC_PatternPartContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_oC_PatternPart);
		int _la;
		try {
			setState(686);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(653);
				oC_Variable();
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(654);
					match(SP);
					}
				}

				setState(657);
				match(T__2);
				setState(659);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(658);
					match(SP);
					}
				}

				setState(661);
				oC_AnonymousPatternPart();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(663);
				oC_Variable();
				setState(665);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(664);
					match(SP);
					}
				}

				setState(667);
				match(T__2);
				setState(669);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(668);
					match(SP);
					}
				}

				{
				setState(671);
				match(ALLSHORTESTPATHS);
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(672);
					match(SP);
					}
				}

				setState(675);
				match(T__5);
				setState(677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(676);
					match(SP);
					}
				}

				setState(679);
				oC_AnonymousPatternPart();
				setState(681);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(680);
					match(SP);
					}
				}

				setState(683);
				match(T__6);
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(685);
				oC_AnonymousPatternPart();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_AnonymousPatternPartContext extends ParserRuleContext {
		public OC_PatternElementContext oC_PatternElement() {
			return getRuleContext(OC_PatternElementContext.class,0);
		}
		public OC_AnonymousPatternPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_AnonymousPatternPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_AnonymousPatternPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_AnonymousPatternPart(this);
		}
	}

	public final OC_AnonymousPatternPartContext oC_AnonymousPatternPart() throws RecognitionException {
		OC_AnonymousPatternPartContext _localctx = new OC_AnonymousPatternPartContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_oC_AnonymousPatternPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			oC_PatternElement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternElementContext extends ParserRuleContext {
		public OC_NodePatternContext oC_NodePattern() {
			return getRuleContext(OC_NodePatternContext.class,0);
		}
		public List<OC_PatternElementChainContext> oC_PatternElementChain() {
			return getRuleContexts(OC_PatternElementChainContext.class);
		}
		public OC_PatternElementChainContext oC_PatternElementChain(int i) {
			return getRuleContext(OC_PatternElementChainContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_PatternElementContext oC_PatternElement() {
			return getRuleContext(OC_PatternElementContext.class,0);
		}
		public OC_PatternElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PatternElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PatternElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PatternElement(this);
		}
	}

	public final OC_PatternElementContext oC_PatternElement() throws RecognitionException {
		OC_PatternElementContext _localctx = new OC_PatternElementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_oC_PatternElement);
		int _la;
		try {
			int _alt;
			setState(704);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(690);
				oC_NodePattern();
				setState(697);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(692);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(691);
							match(SP);
							}
						}

						setState(694);
						oC_PatternElementChain();
						}
						} 
					}
					setState(699);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(700);
				match(T__5);
				setState(701);
				oC_PatternElement();
				setState(702);
				match(T__6);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NodePatternContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_NodeLabelsContext oC_NodeLabels() {
			return getRuleContext(OC_NodeLabelsContext.class,0);
		}
		public OC_PropertiesContext oC_Properties() {
			return getRuleContext(OC_PropertiesContext.class,0);
		}
		public OC_NodePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NodePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_NodePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_NodePattern(this);
		}
	}

	public final OC_NodePatternContext oC_NodePattern() throws RecognitionException {
		OC_NodePatternContext _localctx = new OC_NodePatternContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_oC_NodePattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			match(T__5);
			setState(708);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(707);
				match(SP);
				}
			}

			setState(714);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (COUNT - 84)) | (1L << (ANY - 84)) | (1L << (NONE - 84)) | (1L << (SINGLE - 84)) | (1L << (HexLetter - 84)) | (1L << (FILTER - 84)) | (1L << (EXTRACT - 84)) | (1L << (UnescapedSymbolicName - 84)) | (1L << (EscapedSymbolicName - 84)))) != 0)) {
				{
				setState(710);
				oC_Variable();
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(711);
					match(SP);
					}
				}

				}
			}

			setState(720);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(716);
				oC_NodeLabels();
				setState(718);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(717);
					match(SP);
					}
				}

				}
			}

			setState(726);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23 || _la==T__25) {
				{
				setState(722);
				oC_Properties();
				setState(724);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(723);
					match(SP);
					}
				}

				}
			}

			setState(728);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternElementChainContext extends ParserRuleContext {
		public OC_RelationshipPatternContext oC_RelationshipPattern() {
			return getRuleContext(OC_RelationshipPatternContext.class,0);
		}
		public OC_NodePatternContext oC_NodePattern() {
			return getRuleContext(OC_NodePatternContext.class,0);
		}
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_PatternElementChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PatternElementChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PatternElementChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PatternElementChain(this);
		}
	}

	public final OC_PatternElementChainContext oC_PatternElementChain() throws RecognitionException {
		OC_PatternElementChainContext _localctx = new OC_PatternElementChainContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_oC_PatternElementChain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			oC_RelationshipPattern();
			setState(732);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(731);
				match(SP);
				}
			}

			setState(734);
			oC_NodePattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelationshipPatternContext extends ParserRuleContext {
		public OC_LeftArrowHeadContext oC_LeftArrowHead() {
			return getRuleContext(OC_LeftArrowHeadContext.class,0);
		}
		public List<OC_DashContext> oC_Dash() {
			return getRuleContexts(OC_DashContext.class);
		}
		public OC_DashContext oC_Dash(int i) {
			return getRuleContext(OC_DashContext.class,i);
		}
		public OC_RightArrowHeadContext oC_RightArrowHead() {
			return getRuleContext(OC_RightArrowHeadContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_RelationshipDetailContext oC_RelationshipDetail() {
			return getRuleContext(OC_RelationshipDetailContext.class,0);
		}
		public OC_RelationshipPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelationshipPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_RelationshipPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_RelationshipPattern(this);
		}
	}

	public final OC_RelationshipPatternContext oC_RelationshipPattern() throws RecognitionException {
		OC_RelationshipPatternContext _localctx = new OC_RelationshipPatternContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_oC_RelationshipPattern);
		int _la;
		try {
			setState(800);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(736);
				oC_LeftArrowHead();
				setState(738);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(737);
					match(SP);
					}
				}

				setState(740);
				oC_Dash();
				setState(742);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(741);
					match(SP);
					}
					break;
				}
				setState(745);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(744);
					oC_RelationshipDetail();
					}
				}

				setState(748);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(747);
					match(SP);
					}
				}

				setState(750);
				oC_Dash();
				setState(752);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(751);
					match(SP);
					}
				}

				setState(754);
				oC_RightArrowHead();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(756);
				oC_LeftArrowHead();
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(757);
					match(SP);
					}
				}

				setState(760);
				oC_Dash();
				setState(762);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					{
					setState(761);
					match(SP);
					}
					break;
				}
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(764);
					oC_RelationshipDetail();
					}
				}

				setState(768);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(767);
					match(SP);
					}
				}

				setState(770);
				oC_Dash();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(772);
				oC_Dash();
				setState(774);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
				case 1:
					{
					setState(773);
					match(SP);
					}
					break;
				}
				setState(777);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(776);
					oC_RelationshipDetail();
					}
				}

				setState(780);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(779);
					match(SP);
					}
				}

				setState(782);
				oC_Dash();
				setState(784);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(783);
					match(SP);
					}
				}

				setState(786);
				oC_RightArrowHead();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(788);
				oC_Dash();
				setState(790);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
				case 1:
					{
					setState(789);
					match(SP);
					}
					break;
				}
				setState(793);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(792);
					oC_RelationshipDetail();
					}
				}

				setState(796);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(795);
					match(SP);
					}
				}

				setState(798);
				oC_Dash();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelationshipDetailContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_RelationshipTypesContext oC_RelationshipTypes() {
			return getRuleContext(OC_RelationshipTypesContext.class,0);
		}
		public OC_RangeLiteralContext oC_RangeLiteral() {
			return getRuleContext(OC_RangeLiteralContext.class,0);
		}
		public OC_PropertiesContext oC_Properties() {
			return getRuleContext(OC_PropertiesContext.class,0);
		}
		public OC_RelationshipDetailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelationshipDetail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_RelationshipDetail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_RelationshipDetail(this);
		}
	}

	public final OC_RelationshipDetailContext oC_RelationshipDetail() throws RecognitionException {
		OC_RelationshipDetailContext _localctx = new OC_RelationshipDetailContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_oC_RelationshipDetail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
			match(T__7);
			setState(804);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(803);
				match(SP);
				}
			}

			setState(810);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (COUNT - 84)) | (1L << (ANY - 84)) | (1L << (NONE - 84)) | (1L << (SINGLE - 84)) | (1L << (HexLetter - 84)) | (1L << (FILTER - 84)) | (1L << (EXTRACT - 84)) | (1L << (UnescapedSymbolicName - 84)) | (1L << (EscapedSymbolicName - 84)))) != 0)) {
				{
				setState(806);
				oC_Variable();
				setState(808);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(807);
					match(SP);
					}
				}

				}
			}

			setState(816);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(812);
				oC_RelationshipTypes();
				setState(814);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(813);
					match(SP);
					}
				}

				}
			}

			setState(819);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(818);
				oC_RangeLiteral();
				}
			}

			setState(825);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23 || _la==T__25) {
				{
				setState(821);
				oC_Properties();
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(822);
					match(SP);
					}
				}

				}
			}

			setState(827);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertiesContext extends ParserRuleContext {
		public OC_MapLiteralContext oC_MapLiteral() {
			return getRuleContext(OC_MapLiteralContext.class,0);
		}
		public OC_ParameterContext oC_Parameter() {
			return getRuleContext(OC_ParameterContext.class,0);
		}
		public OC_PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Properties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Properties(this);
		}
	}

	public final OC_PropertiesContext oC_Properties() throws RecognitionException {
		OC_PropertiesContext _localctx = new OC_PropertiesContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_oC_Properties);
		try {
			setState(831);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(829);
				oC_MapLiteral();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(830);
				oC_Parameter();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelationshipTypesContext extends ParserRuleContext {
		public List<OC_RelTypeNameContext> oC_RelTypeName() {
			return getRuleContexts(OC_RelTypeNameContext.class);
		}
		public OC_RelTypeNameContext oC_RelTypeName(int i) {
			return getRuleContext(OC_RelTypeNameContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_RelationshipTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelationshipTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_RelationshipTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_RelationshipTypes(this);
		}
	}

	public final OC_RelationshipTypesContext oC_RelationshipTypes() throws RecognitionException {
		OC_RelationshipTypesContext _localctx = new OC_RelationshipTypesContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_oC_RelationshipTypes);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(833);
			match(T__9);
			setState(835);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(834);
				match(SP);
				}
			}

			setState(837);
			oC_RelTypeName();
			setState(851);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(839);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(838);
						match(SP);
						}
					}

					setState(841);
					match(T__10);
					setState(843);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__9) {
						{
						setState(842);
						match(T__9);
						}
					}

					setState(846);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(845);
						match(SP);
						}
					}

					setState(848);
					oC_RelTypeName();
					}
					} 
				}
				setState(853);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NodeLabelsContext extends ParserRuleContext {
		public List<OC_NodeLabelContext> oC_NodeLabel() {
			return getRuleContexts(OC_NodeLabelContext.class);
		}
		public OC_NodeLabelContext oC_NodeLabel(int i) {
			return getRuleContext(OC_NodeLabelContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_NodeLabelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NodeLabels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_NodeLabels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_NodeLabels(this);
		}
	}

	public final OC_NodeLabelsContext oC_NodeLabels() throws RecognitionException {
		OC_NodeLabelsContext _localctx = new OC_NodeLabelsContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_oC_NodeLabels);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			oC_NodeLabel();
			setState(861);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(856);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(855);
						match(SP);
						}
					}

					setState(858);
					oC_NodeLabel();
					}
					} 
				}
				setState(863);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NodeLabelContext extends ParserRuleContext {
		public OC_LabelNameContext oC_LabelName() {
			return getRuleContext(OC_LabelNameContext.class,0);
		}
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_NodeLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NodeLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_NodeLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_NodeLabel(this);
		}
	}

	public final OC_NodeLabelContext oC_NodeLabel() throws RecognitionException {
		OC_NodeLabelContext _localctx = new OC_NodeLabelContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_oC_NodeLabel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864);
			match(T__9);
			setState(866);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(865);
				match(SP);
				}
			}

			setState(868);
			oC_LabelName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RangeLiteralContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<OC_IntegerLiteralContext> oC_IntegerLiteral() {
			return getRuleContexts(OC_IntegerLiteralContext.class);
		}
		public OC_IntegerLiteralContext oC_IntegerLiteral(int i) {
			return getRuleContext(OC_IntegerLiteralContext.class,i);
		}
		public OC_RangeLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RangeLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_RangeLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_RangeLiteral(this);
		}
	}

	public final OC_RangeLiteralContext oC_RangeLiteral() throws RecognitionException {
		OC_RangeLiteralContext _localctx = new OC_RangeLiteralContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_oC_RangeLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			match(T__4);
			setState(872);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(871);
				match(SP);
				}
			}

			setState(878);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (HexInteger - 98)) | (1L << (DecimalInteger - 98)) | (1L << (OctalInteger - 98)))) != 0)) {
				{
				setState(874);
				oC_IntegerLiteral();
				setState(876);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(875);
					match(SP);
					}
				}

				}
			}

			setState(890);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(880);
				match(T__11);
				setState(882);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(881);
					match(SP);
					}
				}

				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (HexInteger - 98)) | (1L << (DecimalInteger - 98)) | (1L << (OctalInteger - 98)))) != 0)) {
					{
					setState(884);
					oC_IntegerLiteral();
					setState(886);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(885);
						match(SP);
						}
					}

					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_LabelNameContext extends ParserRuleContext {
		public OC_SchemaNameContext oC_SchemaName() {
			return getRuleContext(OC_SchemaNameContext.class,0);
		}
		public OC_LabelNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_LabelName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_LabelName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_LabelName(this);
		}
	}

	public final OC_LabelNameContext oC_LabelName() throws RecognitionException {
		OC_LabelNameContext _localctx = new OC_LabelNameContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_oC_LabelName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(892);
			oC_SchemaName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelTypeNameContext extends ParserRuleContext {
		public OC_SchemaNameContext oC_SchemaName() {
			return getRuleContext(OC_SchemaNameContext.class,0);
		}
		public OC_RelTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_RelTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_RelTypeName(this);
		}
	}

	public final OC_RelTypeNameContext oC_RelTypeName() throws RecognitionException {
		OC_RelTypeNameContext _localctx = new OC_RelTypeNameContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_oC_RelTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
			oC_SchemaName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ExpressionContext extends ParserRuleContext {
		public OC_OrExpressionContext oC_OrExpression() {
			return getRuleContext(OC_OrExpressionContext.class,0);
		}
		public OC_ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Expression(this);
		}
	}

	public final OC_ExpressionContext oC_Expression() throws RecognitionException {
		OC_ExpressionContext _localctx = new OC_ExpressionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_oC_Expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896);
			oC_OrExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_OrExpressionContext extends ParserRuleContext {
		public List<OC_XorExpressionContext> oC_XorExpression() {
			return getRuleContexts(OC_XorExpressionContext.class);
		}
		public OC_XorExpressionContext oC_XorExpression(int i) {
			return getRuleContext(OC_XorExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<TerminalNode> OR() { return getTokens(CypherParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CypherParser.OR, i);
		}
		public OC_OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_OrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_OrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_OrExpression(this);
		}
	}

	public final OC_OrExpressionContext oC_OrExpression() throws RecognitionException {
		OC_OrExpressionContext _localctx = new OC_OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_oC_OrExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
			oC_XorExpression();
			setState(905);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(899);
					match(SP);
					setState(900);
					match(OR);
					setState(901);
					match(SP);
					setState(902);
					oC_XorExpression();
					}
					} 
				}
				setState(907);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_XorExpressionContext extends ParserRuleContext {
		public List<OC_AndExpressionContext> oC_AndExpression() {
			return getRuleContexts(OC_AndExpressionContext.class);
		}
		public OC_AndExpressionContext oC_AndExpression(int i) {
			return getRuleContext(OC_AndExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<TerminalNode> XOR() { return getTokens(CypherParser.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(CypherParser.XOR, i);
		}
		public OC_XorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_XorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_XorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_XorExpression(this);
		}
	}

	public final OC_XorExpressionContext oC_XorExpression() throws RecognitionException {
		OC_XorExpressionContext _localctx = new OC_XorExpressionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_oC_XorExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
			oC_AndExpression();
			setState(915);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(909);
					match(SP);
					setState(910);
					match(XOR);
					setState(911);
					match(SP);
					setState(912);
					oC_AndExpression();
					}
					} 
				}
				setState(917);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,152,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_AndExpressionContext extends ParserRuleContext {
		public List<OC_NotExpressionContext> oC_NotExpression() {
			return getRuleContexts(OC_NotExpressionContext.class);
		}
		public OC_NotExpressionContext oC_NotExpression(int i) {
			return getRuleContext(OC_NotExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<TerminalNode> AND() { return getTokens(CypherParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CypherParser.AND, i);
		}
		public OC_AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_AndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_AndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_AndExpression(this);
		}
	}

	public final OC_AndExpressionContext oC_AndExpression() throws RecognitionException {
		OC_AndExpressionContext _localctx = new OC_AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_oC_AndExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
			oC_NotExpression();
			setState(925);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(919);
					match(SP);
					setState(920);
					match(AND);
					setState(921);
					match(SP);
					setState(922);
					oC_NotExpression();
					}
					} 
				}
				setState(927);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NotExpressionContext extends ParserRuleContext {
		public OC_ComparisonExpressionContext oC_ComparisonExpression() {
			return getRuleContext(OC_ComparisonExpressionContext.class,0);
		}
		public List<TerminalNode> NOT() { return getTokens(CypherParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(CypherParser.NOT, i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_NotExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NotExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_NotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_NotExpression(this);
		}
	}

	public final OC_NotExpressionContext oC_NotExpression() throws RecognitionException {
		OC_NotExpressionContext _localctx = new OC_NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_oC_NotExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(934);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOT) {
				{
				{
				setState(928);
				match(NOT);
				setState(930);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(929);
					match(SP);
					}
				}

				}
				}
				setState(936);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(937);
			oC_ComparisonExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ComparisonExpressionContext extends ParserRuleContext {
		public OC_AddOrSubtractExpressionContext oC_AddOrSubtractExpression() {
			return getRuleContext(OC_AddOrSubtractExpressionContext.class,0);
		}
		public List<OC_PartialComparisonExpressionContext> oC_PartialComparisonExpression() {
			return getRuleContexts(OC_PartialComparisonExpressionContext.class);
		}
		public OC_PartialComparisonExpressionContext oC_PartialComparisonExpression(int i) {
			return getRuleContext(OC_PartialComparisonExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ComparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ComparisonExpression(this);
		}
	}

	public final OC_ComparisonExpressionContext oC_ComparisonExpression() throws RecognitionException {
		OC_ComparisonExpressionContext _localctx = new OC_ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_oC_ComparisonExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			oC_AddOrSubtractExpression();
			setState(946);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(941);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(940);
						match(SP);
						}
					}

					setState(943);
					oC_PartialComparisonExpression();
					}
					} 
				}
				setState(948);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,157,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_AddOrSubtractExpressionContext extends ParserRuleContext {
		public List<OC_MultiplyDivideModuloExpressionContext> oC_MultiplyDivideModuloExpression() {
			return getRuleContexts(OC_MultiplyDivideModuloExpressionContext.class);
		}
		public OC_MultiplyDivideModuloExpressionContext oC_MultiplyDivideModuloExpression(int i) {
			return getRuleContext(OC_MultiplyDivideModuloExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_AddOrSubtractExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_AddOrSubtractExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_AddOrSubtractExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_AddOrSubtractExpression(this);
		}
	}

	public final OC_AddOrSubtractExpressionContext oC_AddOrSubtractExpression() throws RecognitionException {
		OC_AddOrSubtractExpressionContext _localctx = new OC_AddOrSubtractExpressionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_oC_AddOrSubtractExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(949);
			oC_MultiplyDivideModuloExpression();
			setState(968);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(966);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
					case 1:
						{
						{
						setState(951);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(950);
							match(SP);
							}
						}

						setState(953);
						match(T__12);
						setState(955);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(954);
							match(SP);
							}
						}

						setState(957);
						oC_MultiplyDivideModuloExpression();
						}
						}
						break;
					case 2:
						{
						{
						setState(959);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(958);
							match(SP);
							}
						}

						setState(961);
						match(T__13);
						setState(963);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(962);
							match(SP);
							}
						}

						setState(965);
						oC_MultiplyDivideModuloExpression();
						}
						}
						break;
					}
					} 
				}
				setState(970);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MultiplyDivideModuloExpressionContext extends ParserRuleContext {
		public List<OC_PowerOfExpressionContext> oC_PowerOfExpression() {
			return getRuleContexts(OC_PowerOfExpressionContext.class);
		}
		public OC_PowerOfExpressionContext oC_PowerOfExpression(int i) {
			return getRuleContext(OC_PowerOfExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_MultiplyDivideModuloExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_MultiplyDivideModuloExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_MultiplyDivideModuloExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_MultiplyDivideModuloExpression(this);
		}
	}

	public final OC_MultiplyDivideModuloExpressionContext oC_MultiplyDivideModuloExpression() throws RecognitionException {
		OC_MultiplyDivideModuloExpressionContext _localctx = new OC_MultiplyDivideModuloExpressionContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_oC_MultiplyDivideModuloExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(971);
			oC_PowerOfExpression();
			setState(998);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(996);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
					case 1:
						{
						{
						setState(973);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(972);
							match(SP);
							}
						}

						setState(975);
						match(T__4);
						setState(977);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(976);
							match(SP);
							}
						}

						setState(979);
						oC_PowerOfExpression();
						}
						}
						break;
					case 2:
						{
						{
						setState(981);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(980);
							match(SP);
							}
						}

						setState(983);
						match(T__14);
						setState(985);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(984);
							match(SP);
							}
						}

						setState(987);
						oC_PowerOfExpression();
						}
						}
						break;
					case 3:
						{
						{
						setState(989);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(988);
							match(SP);
							}
						}

						setState(991);
						match(T__15);
						setState(993);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(992);
							match(SP);
							}
						}

						setState(995);
						oC_PowerOfExpression();
						}
						}
						break;
					}
					} 
				}
				setState(1000);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PowerOfExpressionContext extends ParserRuleContext {
		public List<OC_UnaryAddOrSubtractExpressionContext> oC_UnaryAddOrSubtractExpression() {
			return getRuleContexts(OC_UnaryAddOrSubtractExpressionContext.class);
		}
		public OC_UnaryAddOrSubtractExpressionContext oC_UnaryAddOrSubtractExpression(int i) {
			return getRuleContext(OC_UnaryAddOrSubtractExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_PowerOfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PowerOfExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PowerOfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PowerOfExpression(this);
		}
	}

	public final OC_PowerOfExpressionContext oC_PowerOfExpression() throws RecognitionException {
		OC_PowerOfExpressionContext _localctx = new OC_PowerOfExpressionContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_oC_PowerOfExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1001);
			oC_UnaryAddOrSubtractExpression();
			setState(1012);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1003);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1002);
						match(SP);
						}
					}

					setState(1005);
					match(T__16);
					setState(1007);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1006);
						match(SP);
						}
					}

					setState(1009);
					oC_UnaryAddOrSubtractExpression();
					}
					} 
				}
				setState(1014);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_UnaryAddOrSubtractExpressionContext extends ParserRuleContext {
		public OC_StringListNullOperatorExpressionContext oC_StringListNullOperatorExpression() {
			return getRuleContext(OC_StringListNullOperatorExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_UnaryAddOrSubtractExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_UnaryAddOrSubtractExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_UnaryAddOrSubtractExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_UnaryAddOrSubtractExpression(this);
		}
	}

	public final OC_UnaryAddOrSubtractExpressionContext oC_UnaryAddOrSubtractExpression() throws RecognitionException {
		OC_UnaryAddOrSubtractExpressionContext _localctx = new OC_UnaryAddOrSubtractExpressionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_oC_UnaryAddOrSubtractExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1021);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12 || _la==T__13) {
				{
				{
				setState(1015);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1017);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1016);
					match(SP);
					}
				}

				}
				}
				setState(1023);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1024);
			oC_StringListNullOperatorExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_StringListNullOperatorExpressionContext extends ParserRuleContext {
		public OC_PropertyOrLabelsExpressionContext oC_PropertyOrLabelsExpression() {
			return getRuleContext(OC_PropertyOrLabelsExpressionContext.class,0);
		}
		public List<OC_StringOperatorExpressionContext> oC_StringOperatorExpression() {
			return getRuleContexts(OC_StringOperatorExpressionContext.class);
		}
		public OC_StringOperatorExpressionContext oC_StringOperatorExpression(int i) {
			return getRuleContext(OC_StringOperatorExpressionContext.class,i);
		}
		public List<OC_ListOperatorExpressionContext> oC_ListOperatorExpression() {
			return getRuleContexts(OC_ListOperatorExpressionContext.class);
		}
		public OC_ListOperatorExpressionContext oC_ListOperatorExpression(int i) {
			return getRuleContext(OC_ListOperatorExpressionContext.class,i);
		}
		public List<OC_NullOperatorExpressionContext> oC_NullOperatorExpression() {
			return getRuleContexts(OC_NullOperatorExpressionContext.class);
		}
		public OC_NullOperatorExpressionContext oC_NullOperatorExpression(int i) {
			return getRuleContext(OC_NullOperatorExpressionContext.class,i);
		}
		public OC_StringListNullOperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_StringListNullOperatorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_StringListNullOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_StringListNullOperatorExpression(this);
		}
	}

	public final OC_StringListNullOperatorExpressionContext oC_StringListNullOperatorExpression() throws RecognitionException {
		OC_StringListNullOperatorExpressionContext _localctx = new OC_StringListNullOperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_oC_StringListNullOperatorExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1026);
			oC_PropertyOrLabelsExpression();
			setState(1032);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(1030);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,177,_ctx) ) {
					case 1:
						{
						setState(1027);
						oC_StringOperatorExpression();
						}
						break;
					case 2:
						{
						setState(1028);
						oC_ListOperatorExpression();
						}
						break;
					case 3:
						{
						setState(1029);
						oC_NullOperatorExpression();
						}
						break;
					}
					} 
				}
				setState(1034);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ListOperatorExpressionContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode IN() { return getToken(CypherParser.IN, 0); }
		public OC_PropertyOrLabelsExpressionContext oC_PropertyOrLabelsExpression() {
			return getRuleContext(OC_PropertyOrLabelsExpressionContext.class,0);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_ListOperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ListOperatorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ListOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ListOperatorExpression(this);
		}
	}

	public final OC_ListOperatorExpressionContext oC_ListOperatorExpression() throws RecognitionException {
		OC_ListOperatorExpressionContext _localctx = new OC_ListOperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_oC_ListOperatorExpression);
		int _la;
		try {
			setState(1060);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1035);
				match(SP);
				setState(1036);
				match(IN);
				setState(1038);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1037);
					match(SP);
					}
				}

				setState(1040);
				oC_PropertyOrLabelsExpression();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1042);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1041);
					match(SP);
					}
				}

				setState(1044);
				match(T__7);
				setState(1045);
				oC_Expression();
				setState(1046);
				match(T__8);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1049);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1048);
					match(SP);
					}
				}

				setState(1051);
				match(T__7);
				setState(1053);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__23) | (1L << T__25) | (1L << ALL))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (NOT - 77)) | (1L << (NULL - 77)) | (1L << (COUNT - 77)) | (1L << (ANY - 77)) | (1L << (NONE - 77)) | (1L << (SINGLE - 77)) | (1L << (TRUE - 77)) | (1L << (FALSE - 77)) | (1L << (EXISTS - 77)) | (1L << (CASE - 77)) | (1L << (StringLiteral - 77)) | (1L << (HexInteger - 77)) | (1L << (DecimalInteger - 77)) | (1L << (OctalInteger - 77)) | (1L << (HexLetter - 77)) | (1L << (ExponentDecimalReal - 77)) | (1L << (RegularDecimalReal - 77)) | (1L << (FILTER - 77)) | (1L << (EXTRACT - 77)) | (1L << (UnescapedSymbolicName - 77)) | (1L << (EscapedSymbolicName - 77)))) != 0)) {
					{
					setState(1052);
					oC_Expression();
					}
				}

				setState(1055);
				match(T__11);
				setState(1057);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__23) | (1L << T__25) | (1L << ALL))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (NOT - 77)) | (1L << (NULL - 77)) | (1L << (COUNT - 77)) | (1L << (ANY - 77)) | (1L << (NONE - 77)) | (1L << (SINGLE - 77)) | (1L << (TRUE - 77)) | (1L << (FALSE - 77)) | (1L << (EXISTS - 77)) | (1L << (CASE - 77)) | (1L << (StringLiteral - 77)) | (1L << (HexInteger - 77)) | (1L << (DecimalInteger - 77)) | (1L << (OctalInteger - 77)) | (1L << (HexLetter - 77)) | (1L << (ExponentDecimalReal - 77)) | (1L << (RegularDecimalReal - 77)) | (1L << (FILTER - 77)) | (1L << (EXTRACT - 77)) | (1L << (UnescapedSymbolicName - 77)) | (1L << (EscapedSymbolicName - 77)))) != 0)) {
					{
					setState(1056);
					oC_Expression();
					}
				}

				setState(1059);
				match(T__8);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_StringOperatorExpressionContext extends ParserRuleContext {
		public OC_PropertyOrLabelsExpressionContext oC_PropertyOrLabelsExpression() {
			return getRuleContext(OC_PropertyOrLabelsExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode STARTS() { return getToken(CypherParser.STARTS, 0); }
		public TerminalNode WITH() { return getToken(CypherParser.WITH, 0); }
		public TerminalNode ENDS() { return getToken(CypherParser.ENDS, 0); }
		public TerminalNode CONTAINS() { return getToken(CypherParser.CONTAINS, 0); }
		public OC_StringOperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_StringOperatorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_StringOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_StringOperatorExpression(this);
		}
	}

	public final OC_StringOperatorExpressionContext oC_StringOperatorExpression() throws RecognitionException {
		OC_StringOperatorExpressionContext _localctx = new OC_StringOperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_oC_StringOperatorExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1072);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
			case 1:
				{
				{
				setState(1062);
				match(SP);
				setState(1063);
				match(STARTS);
				setState(1064);
				match(SP);
				setState(1065);
				match(WITH);
				}
				}
				break;
			case 2:
				{
				{
				setState(1066);
				match(SP);
				setState(1067);
				match(ENDS);
				setState(1068);
				match(SP);
				setState(1069);
				match(WITH);
				}
				}
				break;
			case 3:
				{
				{
				setState(1070);
				match(SP);
				setState(1071);
				match(CONTAINS);
				}
				}
				break;
			}
			setState(1075);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1074);
				match(SP);
				}
			}

			setState(1077);
			oC_PropertyOrLabelsExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NullOperatorExpressionContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode IS() { return getToken(CypherParser.IS, 0); }
		public TerminalNode NULL() { return getToken(CypherParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(CypherParser.NOT, 0); }
		public OC_NullOperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NullOperatorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_NullOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_NullOperatorExpression(this);
		}
	}

	public final OC_NullOperatorExpressionContext oC_NullOperatorExpression() throws RecognitionException {
		OC_NullOperatorExpressionContext _localctx = new OC_NullOperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_oC_NullOperatorExpression);
		try {
			setState(1089);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1079);
				match(SP);
				setState(1080);
				match(IS);
				setState(1081);
				match(SP);
				setState(1082);
				match(NULL);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1083);
				match(SP);
				setState(1084);
				match(IS);
				setState(1085);
				match(SP);
				setState(1086);
				match(NOT);
				setState(1087);
				match(SP);
				setState(1088);
				match(NULL);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertyOrLabelsExpressionContext extends ParserRuleContext {
		public OC_AtomContext oC_Atom() {
			return getRuleContext(OC_AtomContext.class,0);
		}
		public List<OC_PropertyLookupContext> oC_PropertyLookup() {
			return getRuleContexts(OC_PropertyLookupContext.class);
		}
		public OC_PropertyLookupContext oC_PropertyLookup(int i) {
			return getRuleContext(OC_PropertyLookupContext.class,i);
		}
		public OC_NodeLabelsContext oC_NodeLabels() {
			return getRuleContext(OC_NodeLabelsContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_PropertyOrLabelsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PropertyOrLabelsExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PropertyOrLabelsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PropertyOrLabelsExpression(this);
		}
	}

	public final OC_PropertyOrLabelsExpressionContext oC_PropertyOrLabelsExpression() throws RecognitionException {
		OC_PropertyOrLabelsExpressionContext _localctx = new OC_PropertyOrLabelsExpressionContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_oC_PropertyOrLabelsExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1091);
			oC_Atom();
			setState(1098);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1093);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1092);
						match(SP);
						}
					}

					setState(1095);
					oC_PropertyLookup();
					}
					} 
				}
				setState(1100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,189,_ctx);
			}
			setState(1105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				{
				setState(1102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1101);
					match(SP);
					}
				}

				setState(1104);
				oC_NodeLabels();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_AtomContext extends ParserRuleContext {
		public OC_LiteralContext oC_Literal() {
			return getRuleContext(OC_LiteralContext.class,0);
		}
		public OC_ParameterContext oC_Parameter() {
			return getRuleContext(OC_ParameterContext.class,0);
		}
		public OC_CaseExpressionContext oC_CaseExpression() {
			return getRuleContext(OC_CaseExpressionContext.class,0);
		}
		public TerminalNode COUNT() { return getToken(CypherParser.COUNT, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_ListComprehensionContext oC_ListComprehension() {
			return getRuleContext(OC_ListComprehensionContext.class,0);
		}
		public OC_PatternComprehensionContext oC_PatternComprehension() {
			return getRuleContext(OC_PatternComprehensionContext.class,0);
		}
		public TerminalNode ALL() { return getToken(CypherParser.ALL, 0); }
		public OC_FilterExpressionContext oC_FilterExpression() {
			return getRuleContext(OC_FilterExpressionContext.class,0);
		}
		public TerminalNode ANY() { return getToken(CypherParser.ANY, 0); }
		public TerminalNode NONE() { return getToken(CypherParser.NONE, 0); }
		public TerminalNode SINGLE() { return getToken(CypherParser.SINGLE, 0); }
		public OC_RelationshipsPatternContext oC_RelationshipsPattern() {
			return getRuleContext(OC_RelationshipsPatternContext.class,0);
		}
		public OC_ParenthesizedExpressionContext oC_ParenthesizedExpression() {
			return getRuleContext(OC_ParenthesizedExpressionContext.class,0);
		}
		public OC_FunctionInvocationContext oC_FunctionInvocation() {
			return getRuleContext(OC_FunctionInvocationContext.class,0);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public OC_AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Atom(this);
		}
	}

	public final OC_AtomContext oC_Atom() throws RecognitionException {
		OC_AtomContext _localctx = new OC_AtomContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_oC_Atom);
		int _la;
		try {
			setState(1185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1107);
				oC_Literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1108);
				oC_Parameter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1109);
				oC_CaseExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(1110);
				match(COUNT);
				setState(1112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1111);
					match(SP);
					}
				}

				setState(1114);
				match(T__5);
				setState(1116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1115);
					match(SP);
					}
				}

				setState(1118);
				match(T__4);
				setState(1120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1119);
					match(SP);
					}
				}

				setState(1122);
				match(T__6);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1123);
				oC_ListComprehension();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1124);
				oC_PatternComprehension();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(1125);
				match(ALL);
				setState(1127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1126);
					match(SP);
					}
				}

				setState(1129);
				match(T__5);
				setState(1131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1130);
					match(SP);
					}
				}

				setState(1133);
				oC_FilterExpression();
				setState(1135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1134);
					match(SP);
					}
				}

				setState(1137);
				match(T__6);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(1139);
				match(ANY);
				setState(1141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1140);
					match(SP);
					}
				}

				setState(1143);
				match(T__5);
				setState(1145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1144);
					match(SP);
					}
				}

				setState(1147);
				oC_FilterExpression();
				setState(1149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1148);
					match(SP);
					}
				}

				setState(1151);
				match(T__6);
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(1153);
				match(NONE);
				setState(1155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1154);
					match(SP);
					}
				}

				setState(1157);
				match(T__5);
				setState(1159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1158);
					match(SP);
					}
				}

				setState(1161);
				oC_FilterExpression();
				setState(1163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1162);
					match(SP);
					}
				}

				setState(1165);
				match(T__6);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(1167);
				match(SINGLE);
				setState(1169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1168);
					match(SP);
					}
				}

				setState(1171);
				match(T__5);
				setState(1173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1172);
					match(SP);
					}
				}

				setState(1175);
				oC_FilterExpression();
				setState(1177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1176);
					match(SP);
					}
				}

				setState(1179);
				match(T__6);
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1181);
				oC_RelationshipsPattern();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1182);
				oC_ParenthesizedExpression();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1183);
				oC_FunctionInvocation();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1184);
				oC_Variable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_LiteralContext extends ParserRuleContext {
		public OC_NumberLiteralContext oC_NumberLiteral() {
			return getRuleContext(OC_NumberLiteralContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(CypherParser.StringLiteral, 0); }
		public OC_BooleanLiteralContext oC_BooleanLiteral() {
			return getRuleContext(OC_BooleanLiteralContext.class,0);
		}
		public TerminalNode NULL() { return getToken(CypherParser.NULL, 0); }
		public OC_MapLiteralContext oC_MapLiteral() {
			return getRuleContext(OC_MapLiteralContext.class,0);
		}
		public OC_ListLiteralContext oC_ListLiteral() {
			return getRuleContext(OC_ListLiteralContext.class,0);
		}
		public OC_LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Literal(this);
		}
	}

	public final OC_LiteralContext oC_Literal() throws RecognitionException {
		OC_LiteralContext _localctx = new OC_LiteralContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_oC_Literal);
		try {
			setState(1193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HexInteger:
			case DecimalInteger:
			case OctalInteger:
			case ExponentDecimalReal:
			case RegularDecimalReal:
				enterOuterAlt(_localctx, 1);
				{
				setState(1187);
				oC_NumberLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(1188);
				match(StringLiteral);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1189);
				oC_BooleanLiteral();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1190);
				match(NULL);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 5);
				{
				setState(1191);
				oC_MapLiteral();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(1192);
				oC_ListLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(CypherParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CypherParser.FALSE, 0); }
		public OC_BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_BooleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_BooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_BooleanLiteral(this);
		}
	}

	public final OC_BooleanLiteralContext oC_BooleanLiteral() throws RecognitionException {
		OC_BooleanLiteralContext _localctx = new OC_BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_oC_BooleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1195);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ListLiteralContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ListLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ListLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ListLiteral(this);
		}
	}

	public final OC_ListLiteralContext oC_ListLiteral() throws RecognitionException {
		OC_ListLiteralContext _localctx = new OC_ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_oC_ListLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1197);
			match(T__7);
			setState(1199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1198);
				match(SP);
				}
			}

			setState(1218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__23) | (1L << T__25) | (1L << ALL))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (NOT - 77)) | (1L << (NULL - 77)) | (1L << (COUNT - 77)) | (1L << (ANY - 77)) | (1L << (NONE - 77)) | (1L << (SINGLE - 77)) | (1L << (TRUE - 77)) | (1L << (FALSE - 77)) | (1L << (EXISTS - 77)) | (1L << (CASE - 77)) | (1L << (StringLiteral - 77)) | (1L << (HexInteger - 77)) | (1L << (DecimalInteger - 77)) | (1L << (OctalInteger - 77)) | (1L << (HexLetter - 77)) | (1L << (ExponentDecimalReal - 77)) | (1L << (RegularDecimalReal - 77)) | (1L << (FILTER - 77)) | (1L << (EXTRACT - 77)) | (1L << (UnescapedSymbolicName - 77)) | (1L << (EscapedSymbolicName - 77)))) != 0)) {
				{
				setState(1201);
				oC_Expression();
				setState(1203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1202);
					match(SP);
					}
				}

				setState(1215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(1205);
					match(T__1);
					setState(1207);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1206);
						match(SP);
						}
					}

					setState(1209);
					oC_Expression();
					setState(1211);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1210);
						match(SP);
						}
					}

					}
					}
					setState(1217);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1220);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PartialComparisonExpressionContext extends ParserRuleContext {
		public OC_AddOrSubtractExpressionContext oC_AddOrSubtractExpression() {
			return getRuleContext(OC_AddOrSubtractExpressionContext.class,0);
		}
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_PartialComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PartialComparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PartialComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PartialComparisonExpression(this);
		}
	}

	public final OC_PartialComparisonExpressionContext oC_PartialComparisonExpression() throws RecognitionException {
		OC_PartialComparisonExpressionContext _localctx = new OC_PartialComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_oC_PartialComparisonExpression);
		int _la;
		try {
			setState(1252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1222);
				match(T__2);
				setState(1224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1223);
					match(SP);
					}
				}

				setState(1226);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(1227);
				match(T__17);
				setState(1229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1228);
					match(SP);
					}
				}

				setState(1231);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(1232);
				match(T__18);
				setState(1234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1233);
					match(SP);
					}
				}

				setState(1236);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(1237);
				match(T__19);
				setState(1239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1238);
					match(SP);
					}
				}

				setState(1241);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(1242);
				match(T__20);
				setState(1244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1243);
					match(SP);
					}
				}

				setState(1246);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(1247);
				match(T__21);
				setState(1249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1248);
					match(SP);
					}
				}

				setState(1251);
				oC_AddOrSubtractExpression();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ParenthesizedExpressionContext extends ParserRuleContext {
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_ParenthesizedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ParenthesizedExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ParenthesizedExpression(this);
		}
	}

	public final OC_ParenthesizedExpressionContext oC_ParenthesizedExpression() throws RecognitionException {
		OC_ParenthesizedExpressionContext _localctx = new OC_ParenthesizedExpressionContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_oC_ParenthesizedExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1254);
			match(T__5);
			setState(1256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1255);
				match(SP);
				}
			}

			setState(1258);
			oC_Expression();
			setState(1260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1259);
				match(SP);
				}
			}

			setState(1262);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RelationshipsPatternContext extends ParserRuleContext {
		public OC_NodePatternContext oC_NodePattern() {
			return getRuleContext(OC_NodePatternContext.class,0);
		}
		public List<OC_PatternElementChainContext> oC_PatternElementChain() {
			return getRuleContexts(OC_PatternElementChainContext.class);
		}
		public OC_PatternElementChainContext oC_PatternElementChain(int i) {
			return getRuleContext(OC_PatternElementChainContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_RelationshipsPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RelationshipsPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_RelationshipsPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_RelationshipsPattern(this);
		}
	}

	public final OC_RelationshipsPatternContext oC_RelationshipsPattern() throws RecognitionException {
		OC_RelationshipsPatternContext _localctx = new OC_RelationshipsPatternContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_oC_RelationshipsPattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1264);
			oC_NodePattern();
			setState(1269); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1266);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1265);
						match(SP);
						}
					}

					setState(1268);
					oC_PatternElementChain();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1271); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_FilterExpressionContext extends ParserRuleContext {
		public OC_IdInCollContext oC_IdInColl() {
			return getRuleContext(OC_IdInCollContext.class,0);
		}
		public OC_WhereContext oC_Where() {
			return getRuleContext(OC_WhereContext.class,0);
		}
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_FilterExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_FilterExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_FilterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_FilterExpression(this);
		}
	}

	public final OC_FilterExpressionContext oC_FilterExpression() throws RecognitionException {
		OC_FilterExpressionContext _localctx = new OC_FilterExpressionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_oC_FilterExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1273);
			oC_IdInColl();
			setState(1278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,227,_ctx) ) {
			case 1:
				{
				setState(1275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1274);
					match(SP);
					}
				}

				setState(1277);
				oC_Where();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_IdInCollContext extends ParserRuleContext {
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode IN() { return getToken(CypherParser.IN, 0); }
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_IdInCollContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_IdInColl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_IdInColl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_IdInColl(this);
		}
	}

	public final OC_IdInCollContext oC_IdInColl() throws RecognitionException {
		OC_IdInCollContext _localctx = new OC_IdInCollContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_oC_IdInColl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1280);
			oC_Variable();
			setState(1281);
			match(SP);
			setState(1282);
			match(IN);
			setState(1283);
			match(SP);
			setState(1284);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_FunctionInvocationContext extends ParserRuleContext {
		public OC_FunctionNameContext oC_FunctionName() {
			return getRuleContext(OC_FunctionNameContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode DISTINCT() { return getToken(CypherParser.DISTINCT, 0); }
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_FunctionInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_FunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_FunctionInvocation(this);
		}
	}

	public final OC_FunctionInvocationContext oC_FunctionInvocation() throws RecognitionException {
		OC_FunctionInvocationContext _localctx = new OC_FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_oC_FunctionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1286);
			oC_FunctionName();
			setState(1288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1287);
				match(SP);
				}
			}

			setState(1290);
			match(T__5);
			setState(1292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1291);
				match(SP);
				}
			}

			setState(1298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DISTINCT) {
				{
				setState(1294);
				match(DISTINCT);
				setState(1296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1295);
					match(SP);
					}
				}

				}
			}

			setState(1317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__23) | (1L << T__25) | (1L << ALL))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (NOT - 77)) | (1L << (NULL - 77)) | (1L << (COUNT - 77)) | (1L << (ANY - 77)) | (1L << (NONE - 77)) | (1L << (SINGLE - 77)) | (1L << (TRUE - 77)) | (1L << (FALSE - 77)) | (1L << (EXISTS - 77)) | (1L << (CASE - 77)) | (1L << (StringLiteral - 77)) | (1L << (HexInteger - 77)) | (1L << (DecimalInteger - 77)) | (1L << (OctalInteger - 77)) | (1L << (HexLetter - 77)) | (1L << (ExponentDecimalReal - 77)) | (1L << (RegularDecimalReal - 77)) | (1L << (FILTER - 77)) | (1L << (EXTRACT - 77)) | (1L << (UnescapedSymbolicName - 77)) | (1L << (EscapedSymbolicName - 77)))) != 0)) {
				{
				setState(1300);
				oC_Expression();
				setState(1302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1301);
					match(SP);
					}
				}

				setState(1314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(1304);
					match(T__1);
					setState(1306);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1305);
						match(SP);
						}
					}

					setState(1308);
					oC_Expression();
					setState(1310);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1309);
						match(SP);
						}
					}

					}
					}
					setState(1316);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1319);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_FunctionNameContext extends ParserRuleContext {
		public OC_NamespaceContext oC_Namespace() {
			return getRuleContext(OC_NamespaceContext.class,0);
		}
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(CypherParser.EXISTS, 0); }
		public OC_FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_FunctionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_FunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_FunctionName(this);
		}
	}

	public final OC_FunctionNameContext oC_FunctionName() throws RecognitionException {
		OC_FunctionNameContext _localctx = new OC_FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_oC_FunctionName);
		try {
			setState(1325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case HexLetter:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1321);
				oC_Namespace();
				setState(1322);
				oC_SymbolicName();
				}
				}
				break;
			case EXISTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1324);
				match(EXISTS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ExplicitProcedureInvocationContext extends ParserRuleContext {
		public OC_ProcedureNameContext oC_ProcedureName() {
			return getRuleContext(OC_ProcedureNameContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_ExplicitProcedureInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ExplicitProcedureInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ExplicitProcedureInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ExplicitProcedureInvocation(this);
		}
	}

	public final OC_ExplicitProcedureInvocationContext oC_ExplicitProcedureInvocation() throws RecognitionException {
		OC_ExplicitProcedureInvocationContext _localctx = new OC_ExplicitProcedureInvocationContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_oC_ExplicitProcedureInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1327);
			oC_ProcedureName();
			setState(1329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1328);
				match(SP);
				}
			}

			setState(1331);
			match(T__5);
			setState(1333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1332);
				match(SP);
				}
			}

			setState(1352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__23) | (1L << T__25) | (1L << ALL))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (NOT - 77)) | (1L << (NULL - 77)) | (1L << (COUNT - 77)) | (1L << (ANY - 77)) | (1L << (NONE - 77)) | (1L << (SINGLE - 77)) | (1L << (TRUE - 77)) | (1L << (FALSE - 77)) | (1L << (EXISTS - 77)) | (1L << (CASE - 77)) | (1L << (StringLiteral - 77)) | (1L << (HexInteger - 77)) | (1L << (DecimalInteger - 77)) | (1L << (OctalInteger - 77)) | (1L << (HexLetter - 77)) | (1L << (ExponentDecimalReal - 77)) | (1L << (RegularDecimalReal - 77)) | (1L << (FILTER - 77)) | (1L << (EXTRACT - 77)) | (1L << (UnescapedSymbolicName - 77)) | (1L << (EscapedSymbolicName - 77)))) != 0)) {
				{
				setState(1335);
				oC_Expression();
				setState(1337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1336);
					match(SP);
					}
				}

				setState(1349);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(1339);
					match(T__1);
					setState(1341);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1340);
						match(SP);
						}
					}

					setState(1343);
					oC_Expression();
					setState(1345);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1344);
						match(SP);
						}
					}

					}
					}
					setState(1351);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1354);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ImplicitProcedureInvocationContext extends ParserRuleContext {
		public OC_ProcedureNameContext oC_ProcedureName() {
			return getRuleContext(OC_ProcedureNameContext.class,0);
		}
		public OC_ImplicitProcedureInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ImplicitProcedureInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ImplicitProcedureInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ImplicitProcedureInvocation(this);
		}
	}

	public final OC_ImplicitProcedureInvocationContext oC_ImplicitProcedureInvocation() throws RecognitionException {
		OC_ImplicitProcedureInvocationContext _localctx = new OC_ImplicitProcedureInvocationContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_oC_ImplicitProcedureInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1356);
			oC_ProcedureName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ProcedureResultFieldContext extends ParserRuleContext {
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public OC_ProcedureResultFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ProcedureResultField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ProcedureResultField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ProcedureResultField(this);
		}
	}

	public final OC_ProcedureResultFieldContext oC_ProcedureResultField() throws RecognitionException {
		OC_ProcedureResultFieldContext _localctx = new OC_ProcedureResultFieldContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_oC_ProcedureResultField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1358);
			oC_SymbolicName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ProcedureNameContext extends ParserRuleContext {
		public OC_NamespaceContext oC_Namespace() {
			return getRuleContext(OC_NamespaceContext.class,0);
		}
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public OC_ProcedureNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ProcedureName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ProcedureName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ProcedureName(this);
		}
	}

	public final OC_ProcedureNameContext oC_ProcedureName() throws RecognitionException {
		OC_ProcedureNameContext _localctx = new OC_ProcedureNameContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_oC_ProcedureName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1360);
			oC_Namespace();
			setState(1361);
			oC_SymbolicName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NamespaceContext extends ParserRuleContext {
		public List<OC_SymbolicNameContext> oC_SymbolicName() {
			return getRuleContexts(OC_SymbolicNameContext.class);
		}
		public OC_SymbolicNameContext oC_SymbolicName(int i) {
			return getRuleContext(OC_SymbolicNameContext.class,i);
		}
		public OC_NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Namespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Namespace(this);
		}
	}

	public final OC_NamespaceContext oC_Namespace() throws RecognitionException {
		OC_NamespaceContext _localctx = new OC_NamespaceContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_oC_Namespace);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1368);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1363);
					oC_SymbolicName();
					setState(1364);
					match(T__22);
					}
					} 
				}
				setState(1370);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ListComprehensionContext extends ParserRuleContext {
		public OC_FilterExpressionContext oC_FilterExpression() {
			return getRuleContext(OC_FilterExpressionContext.class,0);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_ExpressionContext oC_Expression() {
			return getRuleContext(OC_ExpressionContext.class,0);
		}
		public OC_ListComprehensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ListComprehension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ListComprehension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ListComprehension(this);
		}
	}

	public final OC_ListComprehensionContext oC_ListComprehension() throws RecognitionException {
		OC_ListComprehensionContext _localctx = new OC_ListComprehensionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_oC_ListComprehension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1371);
			match(T__7);
			setState(1373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1372);
				match(SP);
				}
			}

			setState(1375);
			oC_FilterExpression();
			setState(1384);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
			case 1:
				{
				setState(1377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1376);
					match(SP);
					}
				}

				setState(1379);
				match(T__10);
				setState(1381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1380);
					match(SP);
					}
				}

				setState(1383);
				oC_Expression();
				}
				break;
			}
			setState(1387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1386);
				match(SP);
				}
			}

			setState(1389);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PatternComprehensionContext extends ParserRuleContext {
		public OC_RelationshipsPatternContext oC_RelationshipsPattern() {
			return getRuleContext(OC_RelationshipsPatternContext.class,0);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_VariableContext oC_Variable() {
			return getRuleContext(OC_VariableContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(CypherParser.WHERE, 0); }
		public OC_PatternComprehensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PatternComprehension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PatternComprehension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PatternComprehension(this);
		}
	}

	public final OC_PatternComprehensionContext oC_PatternComprehension() throws RecognitionException {
		OC_PatternComprehensionContext _localctx = new OC_PatternComprehensionContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_oC_PatternComprehension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1391);
			match(T__7);
			setState(1393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1392);
				match(SP);
				}
			}

			setState(1403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (COUNT - 84)) | (1L << (ANY - 84)) | (1L << (NONE - 84)) | (1L << (SINGLE - 84)) | (1L << (HexLetter - 84)) | (1L << (FILTER - 84)) | (1L << (EXTRACT - 84)) | (1L << (UnescapedSymbolicName - 84)) | (1L << (EscapedSymbolicName - 84)))) != 0)) {
				{
				setState(1395);
				oC_Variable();
				setState(1397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1396);
					match(SP);
					}
				}

				setState(1399);
				match(T__2);
				setState(1401);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1400);
					match(SP);
					}
				}

				}
			}

			setState(1405);
			oC_RelationshipsPattern();
			setState(1407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1406);
				match(SP);
				}
			}

			setState(1417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1409);
				match(WHERE);
				setState(1411);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1410);
					match(SP);
					}
				}

				setState(1413);
				oC_Expression();
				setState(1415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1414);
					match(SP);
					}
				}

				}
			}

			setState(1419);
			match(T__10);
			setState(1421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1420);
				match(SP);
				}
			}

			setState(1423);
			oC_Expression();
			setState(1425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1424);
				match(SP);
				}
			}

			setState(1427);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertyLookupContext extends ParserRuleContext {
		public OC_PropertyKeyNameContext oC_PropertyKeyName() {
			return getRuleContext(OC_PropertyKeyNameContext.class,0);
		}
		public TerminalNode SP() { return getToken(CypherParser.SP, 0); }
		public OC_PropertyLookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PropertyLookup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PropertyLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PropertyLookup(this);
		}
	}

	public final OC_PropertyLookupContext oC_PropertyLookup() throws RecognitionException {
		OC_PropertyLookupContext _localctx = new OC_PropertyLookupContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_oC_PropertyLookup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1429);
			match(T__22);
			setState(1431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1430);
				match(SP);
				}
			}

			{
			setState(1433);
			oC_PropertyKeyName();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_CaseExpressionContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(CypherParser.END, 0); }
		public TerminalNode ELSE() { return getToken(CypherParser.ELSE, 0); }
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public TerminalNode CASE() { return getToken(CypherParser.CASE, 0); }
		public List<OC_CaseAlternativesContext> oC_CaseAlternatives() {
			return getRuleContexts(OC_CaseAlternativesContext.class);
		}
		public OC_CaseAlternativesContext oC_CaseAlternatives(int i) {
			return getRuleContext(OC_CaseAlternativesContext.class,i);
		}
		public OC_CaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_CaseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_CaseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_CaseExpression(this);
		}
	}

	public final OC_CaseExpressionContext oC_CaseExpression() throws RecognitionException {
		OC_CaseExpressionContext _localctx = new OC_CaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_oC_CaseExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1457);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				{
				setState(1435);
				match(CASE);
				setState(1440); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1437);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1436);
							match(SP);
							}
						}

						setState(1439);
						oC_CaseAlternatives();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1442); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				break;
			case 2:
				{
				{
				setState(1444);
				match(CASE);
				setState(1446);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1445);
					match(SP);
					}
				}

				setState(1448);
				oC_Expression();
				setState(1453); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1450);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==SP) {
							{
							setState(1449);
							match(SP);
							}
						}

						setState(1452);
						oC_CaseAlternatives();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1455); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,266,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				break;
			}
			setState(1467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				{
				setState(1460);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1459);
					match(SP);
					}
				}

				setState(1462);
				match(ELSE);
				setState(1464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1463);
					match(SP);
					}
				}

				setState(1466);
				oC_Expression();
				}
				break;
			}
			setState(1470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1469);
				match(SP);
				}
			}

			setState(1472);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_CaseAlternativesContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(CypherParser.WHEN, 0); }
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public TerminalNode THEN() { return getToken(CypherParser.THEN, 0); }
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_CaseAlternativesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_CaseAlternatives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_CaseAlternatives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_CaseAlternatives(this);
		}
	}

	public final OC_CaseAlternativesContext oC_CaseAlternatives() throws RecognitionException {
		OC_CaseAlternativesContext _localctx = new OC_CaseAlternativesContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_oC_CaseAlternatives);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1474);
			match(WHEN);
			setState(1476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1475);
				match(SP);
				}
			}

			setState(1478);
			oC_Expression();
			setState(1480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1479);
				match(SP);
				}
			}

			setState(1482);
			match(THEN);
			setState(1484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1483);
				match(SP);
				}
			}

			setState(1486);
			oC_Expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_VariableContext extends ParserRuleContext {
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public OC_VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Variable(this);
		}
	}

	public final OC_VariableContext oC_Variable() throws RecognitionException {
		OC_VariableContext _localctx = new OC_VariableContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_oC_Variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1488);
			oC_SymbolicName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_NumberLiteralContext extends ParserRuleContext {
		public OC_DoubleLiteralContext oC_DoubleLiteral() {
			return getRuleContext(OC_DoubleLiteralContext.class,0);
		}
		public OC_IntegerLiteralContext oC_IntegerLiteral() {
			return getRuleContext(OC_IntegerLiteralContext.class,0);
		}
		public OC_NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_NumberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_NumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_NumberLiteral(this);
		}
	}

	public final OC_NumberLiteralContext oC_NumberLiteral() throws RecognitionException {
		OC_NumberLiteralContext _localctx = new OC_NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_oC_NumberLiteral);
		try {
			setState(1492);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ExponentDecimalReal:
			case RegularDecimalReal:
				enterOuterAlt(_localctx, 1);
				{
				setState(1490);
				oC_DoubleLiteral();
				}
				break;
			case HexInteger:
			case DecimalInteger:
			case OctalInteger:
				enterOuterAlt(_localctx, 2);
				{
				setState(1491);
				oC_IntegerLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_MapLiteralContext extends ParserRuleContext {
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public List<OC_PropertyKeyNameContext> oC_PropertyKeyName() {
			return getRuleContexts(OC_PropertyKeyNameContext.class);
		}
		public OC_PropertyKeyNameContext oC_PropertyKeyName(int i) {
			return getRuleContext(OC_PropertyKeyNameContext.class,i);
		}
		public List<OC_ExpressionContext> oC_Expression() {
			return getRuleContexts(OC_ExpressionContext.class);
		}
		public OC_ExpressionContext oC_Expression(int i) {
			return getRuleContext(OC_ExpressionContext.class,i);
		}
		public OC_MapLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_MapLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_MapLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_MapLiteral(this);
		}
	}

	public final OC_MapLiteralContext oC_MapLiteral() throws RecognitionException {
		OC_MapLiteralContext _localctx = new OC_MapLiteralContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_oC_MapLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1494);
			match(T__23);
			setState(1496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SP) {
				{
				setState(1495);
				match(SP);
				}
			}

			setState(1531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNION) | (1L << ALL) | (1L << OPTIONAL) | (1L << MATCH) | (1L << UNWIND) | (1L << AS) | (1L << MERGE) | (1L << ON) | (1L << CREATE) | (1L << SET) | (1L << DETACH) | (1L << DELETE) | (1L << REMOVE) | (1L << WITH) | (1L << DISTINCT) | (1L << RETURN))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ORDER - 64)) | (1L << (BY - 64)) | (1L << (L_SKIP - 64)) | (1L << (LIMIT - 64)) | (1L << (ASCENDING - 64)) | (1L << (ASC - 64)) | (1L << (DESCENDING - 64)) | (1L << (DESC - 64)) | (1L << (WHERE - 64)) | (1L << (OR - 64)) | (1L << (XOR - 64)) | (1L << (AND - 64)) | (1L << (NOT - 64)) | (1L << (IN - 64)) | (1L << (STARTS - 64)) | (1L << (ENDS - 64)) | (1L << (CONTAINS - 64)) | (1L << (IS - 64)) | (1L << (NULL - 64)) | (1L << (COUNT - 64)) | (1L << (ANY - 64)) | (1L << (NONE - 64)) | (1L << (SINGLE - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (EXISTS - 64)) | (1L << (CASE - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (WHEN - 64)) | (1L << (THEN - 64)) | (1L << (HexLetter - 64)) | (1L << (CONSTRAINT - 64)) | (1L << (DO - 64)) | (1L << (FOR - 64)) | (1L << (REQUIRE - 64)) | (1L << (UNIQUE - 64)) | (1L << (MANDATORY - 64)) | (1L << (SCALAR - 64)) | (1L << (OF - 64)) | (1L << (ADD - 64)) | (1L << (DROP - 64)) | (1L << (FILTER - 64)) | (1L << (EXTRACT - 64)) | (1L << (UnescapedSymbolicName - 64)) | (1L << (EscapedSymbolicName - 64)))) != 0)) {
				{
				setState(1498);
				oC_PropertyKeyName();
				setState(1500);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1499);
					match(SP);
					}
				}

				setState(1502);
				match(T__9);
				setState(1504);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1503);
					match(SP);
					}
				}

				setState(1506);
				oC_Expression();
				setState(1508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SP) {
					{
					setState(1507);
					match(SP);
					}
				}

				setState(1528);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(1510);
					match(T__1);
					setState(1512);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1511);
						match(SP);
						}
					}

					setState(1514);
					oC_PropertyKeyName();
					setState(1516);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1515);
						match(SP);
						}
					}

					setState(1518);
					match(T__9);
					setState(1520);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1519);
						match(SP);
						}
					}

					setState(1522);
					oC_Expression();
					setState(1524);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1523);
						match(SP);
						}
					}

					}
					}
					setState(1530);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1533);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ParameterContext extends ParserRuleContext {
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public TerminalNode DecimalInteger() { return getToken(CypherParser.DecimalInteger, 0); }
		public OC_ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Parameter(this);
		}
	}

	public final OC_ParameterContext oC_Parameter() throws RecognitionException {
		OC_ParameterContext _localctx = new OC_ParameterContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_oC_Parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1535);
			match(T__25);
			setState(1538);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case HexLetter:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				{
				setState(1536);
				oC_SymbolicName();
				}
				break;
			case DecimalInteger:
				{
				setState(1537);
				match(DecimalInteger);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertyExpressionContext extends ParserRuleContext {
		public OC_AtomContext oC_Atom() {
			return getRuleContext(OC_AtomContext.class,0);
		}
		public List<OC_PropertyLookupContext> oC_PropertyLookup() {
			return getRuleContexts(OC_PropertyLookupContext.class);
		}
		public OC_PropertyLookupContext oC_PropertyLookup(int i) {
			return getRuleContext(OC_PropertyLookupContext.class,i);
		}
		public List<TerminalNode> SP() { return getTokens(CypherParser.SP); }
		public TerminalNode SP(int i) {
			return getToken(CypherParser.SP, i);
		}
		public OC_PropertyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PropertyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PropertyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PropertyExpression(this);
		}
	}

	public final OC_PropertyExpressionContext oC_PropertyExpression() throws RecognitionException {
		OC_PropertyExpressionContext _localctx = new OC_PropertyExpressionContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_oC_PropertyExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1540);
			oC_Atom();
			setState(1545); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1542);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SP) {
						{
						setState(1541);
						match(SP);
						}
					}

					setState(1544);
					oC_PropertyLookup();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1547); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,288,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_PropertyKeyNameContext extends ParserRuleContext {
		public OC_SchemaNameContext oC_SchemaName() {
			return getRuleContext(OC_SchemaNameContext.class,0);
		}
		public OC_PropertyKeyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_PropertyKeyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_PropertyKeyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_PropertyKeyName(this);
		}
	}

	public final OC_PropertyKeyNameContext oC_PropertyKeyName() throws RecognitionException {
		OC_PropertyKeyNameContext _localctx = new OC_PropertyKeyNameContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_oC_PropertyKeyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1549);
			oC_SchemaName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_IntegerLiteralContext extends ParserRuleContext {
		public TerminalNode HexInteger() { return getToken(CypherParser.HexInteger, 0); }
		public TerminalNode OctalInteger() { return getToken(CypherParser.OctalInteger, 0); }
		public TerminalNode DecimalInteger() { return getToken(CypherParser.DecimalInteger, 0); }
		public OC_IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_IntegerLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_IntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_IntegerLiteral(this);
		}
	}

	public final OC_IntegerLiteralContext oC_IntegerLiteral() throws RecognitionException {
		OC_IntegerLiteralContext _localctx = new OC_IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_oC_IntegerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1551);
			_la = _input.LA(1);
			if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (HexInteger - 98)) | (1L << (DecimalInteger - 98)) | (1L << (OctalInteger - 98)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_DoubleLiteralContext extends ParserRuleContext {
		public TerminalNode ExponentDecimalReal() { return getToken(CypherParser.ExponentDecimalReal, 0); }
		public TerminalNode RegularDecimalReal() { return getToken(CypherParser.RegularDecimalReal, 0); }
		public OC_DoubleLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_DoubleLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_DoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_DoubleLiteral(this);
		}
	}

	public final OC_DoubleLiteralContext oC_DoubleLiteral() throws RecognitionException {
		OC_DoubleLiteralContext _localctx = new OC_DoubleLiteralContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_oC_DoubleLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1553);
			_la = _input.LA(1);
			if ( !(_la==ExponentDecimalReal || _la==RegularDecimalReal) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SchemaNameContext extends ParserRuleContext {
		public OC_SymbolicNameContext oC_SymbolicName() {
			return getRuleContext(OC_SymbolicNameContext.class,0);
		}
		public OC_ReservedWordContext oC_ReservedWord() {
			return getRuleContext(OC_ReservedWordContext.class,0);
		}
		public OC_SchemaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SchemaName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_SchemaName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_SchemaName(this);
		}
	}

	public final OC_SchemaNameContext oC_SchemaName() throws RecognitionException {
		OC_SchemaNameContext _localctx = new OC_SchemaNameContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_oC_SchemaName);
		try {
			setState(1557);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COUNT:
			case ANY:
			case NONE:
			case SINGLE:
			case HexLetter:
			case FILTER:
			case EXTRACT:
			case UnescapedSymbolicName:
			case EscapedSymbolicName:
				enterOuterAlt(_localctx, 1);
				{
				setState(1555);
				oC_SymbolicName();
				}
				break;
			case UNION:
			case ALL:
			case OPTIONAL:
			case MATCH:
			case UNWIND:
			case AS:
			case MERGE:
			case ON:
			case CREATE:
			case SET:
			case DETACH:
			case DELETE:
			case REMOVE:
			case WITH:
			case DISTINCT:
			case RETURN:
			case ORDER:
			case BY:
			case L_SKIP:
			case LIMIT:
			case ASCENDING:
			case ASC:
			case DESCENDING:
			case DESC:
			case WHERE:
			case OR:
			case XOR:
			case AND:
			case NOT:
			case IN:
			case STARTS:
			case ENDS:
			case CONTAINS:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case EXISTS:
			case CASE:
			case ELSE:
			case END:
			case WHEN:
			case THEN:
			case CONSTRAINT:
			case DO:
			case FOR:
			case REQUIRE:
			case UNIQUE:
			case MANDATORY:
			case SCALAR:
			case OF:
			case ADD:
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(1556);
				oC_ReservedWord();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_ReservedWordContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(CypherParser.ALL, 0); }
		public TerminalNode ASC() { return getToken(CypherParser.ASC, 0); }
		public TerminalNode ASCENDING() { return getToken(CypherParser.ASCENDING, 0); }
		public TerminalNode BY() { return getToken(CypherParser.BY, 0); }
		public TerminalNode CREATE() { return getToken(CypherParser.CREATE, 0); }
		public TerminalNode DELETE() { return getToken(CypherParser.DELETE, 0); }
		public TerminalNode DESC() { return getToken(CypherParser.DESC, 0); }
		public TerminalNode DESCENDING() { return getToken(CypherParser.DESCENDING, 0); }
		public TerminalNode DETACH() { return getToken(CypherParser.DETACH, 0); }
		public TerminalNode EXISTS() { return getToken(CypherParser.EXISTS, 0); }
		public TerminalNode LIMIT() { return getToken(CypherParser.LIMIT, 0); }
		public TerminalNode MATCH() { return getToken(CypherParser.MATCH, 0); }
		public TerminalNode MERGE() { return getToken(CypherParser.MERGE, 0); }
		public TerminalNode ON() { return getToken(CypherParser.ON, 0); }
		public TerminalNode OPTIONAL() { return getToken(CypherParser.OPTIONAL, 0); }
		public TerminalNode ORDER() { return getToken(CypherParser.ORDER, 0); }
		public TerminalNode REMOVE() { return getToken(CypherParser.REMOVE, 0); }
		public TerminalNode RETURN() { return getToken(CypherParser.RETURN, 0); }
		public TerminalNode SET() { return getToken(CypherParser.SET, 0); }
		public TerminalNode L_SKIP() { return getToken(CypherParser.L_SKIP, 0); }
		public TerminalNode WHERE() { return getToken(CypherParser.WHERE, 0); }
		public TerminalNode WITH() { return getToken(CypherParser.WITH, 0); }
		public TerminalNode UNION() { return getToken(CypherParser.UNION, 0); }
		public TerminalNode UNWIND() { return getToken(CypherParser.UNWIND, 0); }
		public TerminalNode AND() { return getToken(CypherParser.AND, 0); }
		public TerminalNode AS() { return getToken(CypherParser.AS, 0); }
		public TerminalNode CONTAINS() { return getToken(CypherParser.CONTAINS, 0); }
		public TerminalNode DISTINCT() { return getToken(CypherParser.DISTINCT, 0); }
		public TerminalNode ENDS() { return getToken(CypherParser.ENDS, 0); }
		public TerminalNode IN() { return getToken(CypherParser.IN, 0); }
		public TerminalNode IS() { return getToken(CypherParser.IS, 0); }
		public TerminalNode NOT() { return getToken(CypherParser.NOT, 0); }
		public TerminalNode OR() { return getToken(CypherParser.OR, 0); }
		public TerminalNode STARTS() { return getToken(CypherParser.STARTS, 0); }
		public TerminalNode XOR() { return getToken(CypherParser.XOR, 0); }
		public TerminalNode FALSE() { return getToken(CypherParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(CypherParser.TRUE, 0); }
		public TerminalNode NULL() { return getToken(CypherParser.NULL, 0); }
		public TerminalNode CONSTRAINT() { return getToken(CypherParser.CONSTRAINT, 0); }
		public TerminalNode DO() { return getToken(CypherParser.DO, 0); }
		public TerminalNode FOR() { return getToken(CypherParser.FOR, 0); }
		public TerminalNode REQUIRE() { return getToken(CypherParser.REQUIRE, 0); }
		public TerminalNode UNIQUE() { return getToken(CypherParser.UNIQUE, 0); }
		public TerminalNode CASE() { return getToken(CypherParser.CASE, 0); }
		public TerminalNode WHEN() { return getToken(CypherParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(CypherParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CypherParser.ELSE, 0); }
		public TerminalNode END() { return getToken(CypherParser.END, 0); }
		public TerminalNode MANDATORY() { return getToken(CypherParser.MANDATORY, 0); }
		public TerminalNode SCALAR() { return getToken(CypherParser.SCALAR, 0); }
		public TerminalNode OF() { return getToken(CypherParser.OF, 0); }
		public TerminalNode ADD() { return getToken(CypherParser.ADD, 0); }
		public TerminalNode DROP() { return getToken(CypherParser.DROP, 0); }
		public OC_ReservedWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_ReservedWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_ReservedWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_ReservedWord(this);
		}
	}

	public final OC_ReservedWordContext oC_ReservedWord() throws RecognitionException {
		OC_ReservedWordContext _localctx = new OC_ReservedWordContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_oC_ReservedWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1559);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNION) | (1L << ALL) | (1L << OPTIONAL) | (1L << MATCH) | (1L << UNWIND) | (1L << AS) | (1L << MERGE) | (1L << ON) | (1L << CREATE) | (1L << SET) | (1L << DETACH) | (1L << DELETE) | (1L << REMOVE) | (1L << WITH) | (1L << DISTINCT) | (1L << RETURN))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ORDER - 64)) | (1L << (BY - 64)) | (1L << (L_SKIP - 64)) | (1L << (LIMIT - 64)) | (1L << (ASCENDING - 64)) | (1L << (ASC - 64)) | (1L << (DESCENDING - 64)) | (1L << (DESC - 64)) | (1L << (WHERE - 64)) | (1L << (OR - 64)) | (1L << (XOR - 64)) | (1L << (AND - 64)) | (1L << (NOT - 64)) | (1L << (IN - 64)) | (1L << (STARTS - 64)) | (1L << (ENDS - 64)) | (1L << (CONTAINS - 64)) | (1L << (IS - 64)) | (1L << (NULL - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (EXISTS - 64)) | (1L << (CASE - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (WHEN - 64)) | (1L << (THEN - 64)) | (1L << (CONSTRAINT - 64)) | (1L << (DO - 64)) | (1L << (FOR - 64)) | (1L << (REQUIRE - 64)) | (1L << (UNIQUE - 64)) | (1L << (MANDATORY - 64)) | (1L << (SCALAR - 64)) | (1L << (OF - 64)) | (1L << (ADD - 64)) | (1L << (DROP - 64)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_SymbolicNameContext extends ParserRuleContext {
		public TerminalNode UnescapedSymbolicName() { return getToken(CypherParser.UnescapedSymbolicName, 0); }
		public TerminalNode EscapedSymbolicName() { return getToken(CypherParser.EscapedSymbolicName, 0); }
		public TerminalNode HexLetter() { return getToken(CypherParser.HexLetter, 0); }
		public TerminalNode COUNT() { return getToken(CypherParser.COUNT, 0); }
		public TerminalNode FILTER() { return getToken(CypherParser.FILTER, 0); }
		public TerminalNode EXTRACT() { return getToken(CypherParser.EXTRACT, 0); }
		public TerminalNode ANY() { return getToken(CypherParser.ANY, 0); }
		public TerminalNode NONE() { return getToken(CypherParser.NONE, 0); }
		public TerminalNode SINGLE() { return getToken(CypherParser.SINGLE, 0); }
		public OC_SymbolicNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_SymbolicName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_SymbolicName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_SymbolicName(this);
		}
	}

	public final OC_SymbolicNameContext oC_SymbolicName() throws RecognitionException {
		OC_SymbolicNameContext _localctx = new OC_SymbolicNameContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_oC_SymbolicName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1561);
			_la = _input.LA(1);
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (COUNT - 84)) | (1L << (ANY - 84)) | (1L << (NONE - 84)) | (1L << (SINGLE - 84)) | (1L << (HexLetter - 84)) | (1L << (FILTER - 84)) | (1L << (EXTRACT - 84)) | (1L << (UnescapedSymbolicName - 84)) | (1L << (EscapedSymbolicName - 84)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_LeftArrowHeadContext extends ParserRuleContext {
		public OC_LeftArrowHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_LeftArrowHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_LeftArrowHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_LeftArrowHead(this);
		}
	}

	public final OC_LeftArrowHeadContext oC_LeftArrowHead() throws RecognitionException {
		OC_LeftArrowHeadContext _localctx = new OC_LeftArrowHeadContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_oC_LeftArrowHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1563);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_RightArrowHeadContext extends ParserRuleContext {
		public OC_RightArrowHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_RightArrowHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_RightArrowHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_RightArrowHead(this);
		}
	}

	public final OC_RightArrowHeadContext oC_RightArrowHead() throws RecognitionException {
		OC_RightArrowHeadContext _localctx = new OC_RightArrowHeadContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_oC_RightArrowHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1565);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OC_DashContext extends ParserRuleContext {
		public OC_DashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oC_Dash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).enterOC_Dash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CypherListener ) ((CypherListener)listener).exitOC_Dash(this);
		}
	}

	public final OC_DashContext oC_Dash() throws RecognitionException {
		OC_DashContext _localctx = new OC_DashContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_oC_Dash);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1567);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0082\u0624\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\3\2\5\2\u00ca\n\2\3\2\3\2\5\2\u00ce\n\2\3"+
		"\2\5\2\u00d1\n\2\3\2\5\2\u00d4\n\2\3\2\3\2\3\3\3\3\3\4\3\4\5\4\u00dc\n"+
		"\4\3\5\3\5\5\5\u00e0\n\5\3\5\7\5\u00e3\n\5\f\5\16\5\u00e6\13\5\3\6\3\6"+
		"\3\6\3\6\5\6\u00ec\n\6\3\6\3\6\3\6\5\6\u00f1\n\6\3\6\5\6\u00f4\n\6\3\7"+
		"\3\7\5\7\u00f8\n\7\3\b\3\b\5\b\u00fc\n\b\7\b\u00fe\n\b\f\b\16\b\u0101"+
		"\13\b\3\b\3\b\3\b\5\b\u0106\n\b\7\b\u0108\n\b\f\b\16\b\u010b\13\b\3\b"+
		"\3\b\5\b\u010f\n\b\3\b\7\b\u0112\n\b\f\b\16\b\u0115\13\b\3\b\5\b\u0118"+
		"\n\b\3\b\5\b\u011b\n\b\5\b\u011d\n\b\3\t\3\t\5\t\u0121\n\t\7\t\u0123\n"+
		"\t\f\t\16\t\u0126\13\t\3\t\3\t\5\t\u012a\n\t\7\t\u012c\n\t\f\t\16\t\u012f"+
		"\13\t\3\t\3\t\5\t\u0133\n\t\6\t\u0135\n\t\r\t\16\t\u0136\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\5\n\u0140\n\n\3\13\3\13\3\13\5\13\u0145\n\13\3\f\3\f\5"+
		"\f\u0149\n\f\3\f\3\f\5\f\u014d\n\f\3\f\3\f\5\f\u0151\n\f\3\f\5\f\u0154"+
		"\n\f\3\r\3\r\5\r\u0158\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\5\16\u0162"+
		"\n\16\3\16\3\16\3\16\7\16\u0167\n\16\f\16\16\16\u016a\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0176\n\17\3\20\3\20\5\20"+
		"\u017a\n\20\3\20\3\20\3\21\3\21\5\21\u0180\n\21\3\21\3\21\3\21\7\21\u0185"+
		"\n\21\f\21\16\21\u0188\13\21\3\22\3\22\5\22\u018c\n\22\3\22\3\22\5\22"+
		"\u0190\n\22\3\22\3\22\3\22\3\22\5\22\u0196\n\22\3\22\3\22\5\22\u019a\n"+
		"\22\3\22\3\22\3\22\3\22\5\22\u01a0\n\22\3\22\3\22\5\22\u01a4\n\22\3\22"+
		"\3\22\3\22\3\22\5\22\u01aa\n\22\3\22\3\22\5\22\u01ae\n\22\3\23\3\23\5"+
		"\23\u01b2\n\23\3\23\3\23\5\23\u01b6\n\23\3\23\3\23\5\23\u01ba\n\23\3\23"+
		"\3\23\5\23\u01be\n\23\3\23\7\23\u01c1\n\23\f\23\16\23\u01c4\13\23\3\24"+
		"\3\24\3\24\3\24\5\24\u01ca\n\24\3\24\3\24\5\24\u01ce\n\24\3\24\7\24\u01d1"+
		"\n\24\f\24\16\24\u01d4\13\24\3\25\3\25\3\25\3\25\5\25\u01da\n\25\3\26"+
		"\3\26\3\26\3\26\5\26\u01e0\n\26\3\26\3\26\3\26\5\26\u01e5\n\26\3\27\3"+
		"\27\3\27\3\27\5\27\u01eb\n\27\3\27\3\27\3\27\3\27\5\27\u01f1\n\27\3\30"+
		"\3\30\3\30\5\30\u01f6\n\30\3\30\3\30\5\30\u01fa\n\30\3\30\7\30\u01fd\n"+
		"\30\f\30\16\30\u0200\13\30\5\30\u0202\n\30\3\30\5\30\u0205\n\30\3\30\5"+
		"\30\u0208\n\30\3\31\3\31\3\31\3\31\3\31\5\31\u020f\n\31\3\31\3\31\3\32"+
		"\3\32\5\32\u0215\n\32\3\32\5\32\u0218\n\32\3\32\3\32\3\32\5\32\u021d\n"+
		"\32\3\32\5\32\u0220\n\32\3\33\3\33\5\33\u0224\n\33\3\33\5\33\u0227\n\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\5\34\u022f\n\34\3\34\3\34\5\34\u0233\n"+
		"\34\3\34\3\34\5\34\u0237\n\34\3\35\3\35\5\35\u023b\n\35\3\35\3\35\5\35"+
		"\u023f\n\35\3\35\7\35\u0242\n\35\f\35\16\35\u0245\13\35\3\35\3\35\5\35"+
		"\u0249\n\35\3\35\3\35\5\35\u024d\n\35\3\35\7\35\u0250\n\35\f\35\16\35"+
		"\u0253\13\35\5\35\u0255\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u025e"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0267\n\37\3\37\7\37\u026a"+
		"\n\37\f\37\16\37\u026d\13\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\5\"\u0279"+
		"\n\"\3\"\5\"\u027c\n\"\3#\3#\3#\3#\3$\3$\5$\u0284\n$\3$\3$\5$\u0288\n"+
		"$\3$\7$\u028b\n$\f$\16$\u028e\13$\3%\3%\5%\u0292\n%\3%\3%\5%\u0296\n%"+
		"\3%\3%\3%\3%\5%\u029c\n%\3%\3%\5%\u02a0\n%\3%\3%\5%\u02a4\n%\3%\3%\5%"+
		"\u02a8\n%\3%\3%\5%\u02ac\n%\3%\3%\3%\5%\u02b1\n%\3&\3&\3\'\3\'\5\'\u02b7"+
		"\n\'\3\'\7\'\u02ba\n\'\f\'\16\'\u02bd\13\'\3\'\3\'\3\'\3\'\5\'\u02c3\n"+
		"\'\3(\3(\5(\u02c7\n(\3(\3(\5(\u02cb\n(\5(\u02cd\n(\3(\3(\5(\u02d1\n(\5"+
		"(\u02d3\n(\3(\3(\5(\u02d7\n(\5(\u02d9\n(\3(\3(\3)\3)\5)\u02df\n)\3)\3"+
		")\3*\3*\5*\u02e5\n*\3*\3*\5*\u02e9\n*\3*\5*\u02ec\n*\3*\5*\u02ef\n*\3"+
		"*\3*\5*\u02f3\n*\3*\3*\3*\3*\5*\u02f9\n*\3*\3*\5*\u02fd\n*\3*\5*\u0300"+
		"\n*\3*\5*\u0303\n*\3*\3*\3*\3*\5*\u0309\n*\3*\5*\u030c\n*\3*\5*\u030f"+
		"\n*\3*\3*\5*\u0313\n*\3*\3*\3*\3*\5*\u0319\n*\3*\5*\u031c\n*\3*\5*\u031f"+
		"\n*\3*\3*\5*\u0323\n*\3+\3+\5+\u0327\n+\3+\3+\5+\u032b\n+\5+\u032d\n+"+
		"\3+\3+\5+\u0331\n+\5+\u0333\n+\3+\5+\u0336\n+\3+\3+\5+\u033a\n+\5+\u033c"+
		"\n+\3+\3+\3,\3,\5,\u0342\n,\3-\3-\5-\u0346\n-\3-\3-\5-\u034a\n-\3-\3-"+
		"\5-\u034e\n-\3-\5-\u0351\n-\3-\7-\u0354\n-\f-\16-\u0357\13-\3.\3.\5.\u035b"+
		"\n.\3.\7.\u035e\n.\f.\16.\u0361\13.\3/\3/\5/\u0365\n/\3/\3/\3\60\3\60"+
		"\5\60\u036b\n\60\3\60\3\60\5\60\u036f\n\60\5\60\u0371\n\60\3\60\3\60\5"+
		"\60\u0375\n\60\3\60\3\60\5\60\u0379\n\60\5\60\u037b\n\60\5\60\u037d\n"+
		"\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\7\64\u038a"+
		"\n\64\f\64\16\64\u038d\13\64\3\65\3\65\3\65\3\65\3\65\7\65\u0394\n\65"+
		"\f\65\16\65\u0397\13\65\3\66\3\66\3\66\3\66\3\66\7\66\u039e\n\66\f\66"+
		"\16\66\u03a1\13\66\3\67\3\67\5\67\u03a5\n\67\7\67\u03a7\n\67\f\67\16\67"+
		"\u03aa\13\67\3\67\3\67\38\38\58\u03b0\n8\38\78\u03b3\n8\f8\168\u03b6\13"+
		"8\39\39\59\u03ba\n9\39\39\59\u03be\n9\39\39\59\u03c2\n9\39\39\59\u03c6"+
		"\n9\39\79\u03c9\n9\f9\169\u03cc\139\3:\3:\5:\u03d0\n:\3:\3:\5:\u03d4\n"+
		":\3:\3:\5:\u03d8\n:\3:\3:\5:\u03dc\n:\3:\3:\5:\u03e0\n:\3:\3:\5:\u03e4"+
		"\n:\3:\7:\u03e7\n:\f:\16:\u03ea\13:\3;\3;\5;\u03ee\n;\3;\3;\5;\u03f2\n"+
		";\3;\7;\u03f5\n;\f;\16;\u03f8\13;\3<\3<\5<\u03fc\n<\7<\u03fe\n<\f<\16"+
		"<\u0401\13<\3<\3<\3=\3=\3=\3=\7=\u0409\n=\f=\16=\u040c\13=\3>\3>\3>\5"+
		">\u0411\n>\3>\3>\5>\u0415\n>\3>\3>\3>\3>\3>\5>\u041c\n>\3>\3>\5>\u0420"+
		"\n>\3>\3>\5>\u0424\n>\3>\5>\u0427\n>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\5?"+
		"\u0433\n?\3?\5?\u0436\n?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u0444"+
		"\n@\3A\3A\5A\u0448\nA\3A\7A\u044b\nA\fA\16A\u044e\13A\3A\5A\u0451\nA\3"+
		"A\5A\u0454\nA\3B\3B\3B\3B\3B\5B\u045b\nB\3B\3B\5B\u045f\nB\3B\3B\5B\u0463"+
		"\nB\3B\3B\3B\3B\3B\5B\u046a\nB\3B\3B\5B\u046e\nB\3B\3B\5B\u0472\nB\3B"+
		"\3B\3B\3B\5B\u0478\nB\3B\3B\5B\u047c\nB\3B\3B\5B\u0480\nB\3B\3B\3B\3B"+
		"\5B\u0486\nB\3B\3B\5B\u048a\nB\3B\3B\5B\u048e\nB\3B\3B\3B\3B\5B\u0494"+
		"\nB\3B\3B\5B\u0498\nB\3B\3B\5B\u049c\nB\3B\3B\3B\3B\3B\3B\5B\u04a4\nB"+
		"\3C\3C\3C\3C\3C\3C\5C\u04ac\nC\3D\3D\3E\3E\5E\u04b2\nE\3E\3E\5E\u04b6"+
		"\nE\3E\3E\5E\u04ba\nE\3E\3E\5E\u04be\nE\7E\u04c0\nE\fE\16E\u04c3\13E\5"+
		"E\u04c5\nE\3E\3E\3F\3F\5F\u04cb\nF\3F\3F\3F\5F\u04d0\nF\3F\3F\3F\5F\u04d5"+
		"\nF\3F\3F\3F\5F\u04da\nF\3F\3F\3F\5F\u04df\nF\3F\3F\3F\5F\u04e4\nF\3F"+
		"\5F\u04e7\nF\3G\3G\5G\u04eb\nG\3G\3G\5G\u04ef\nG\3G\3G\3H\3H\5H\u04f5"+
		"\nH\3H\6H\u04f8\nH\rH\16H\u04f9\3I\3I\5I\u04fe\nI\3I\5I\u0501\nI\3J\3"+
		"J\3J\3J\3J\3J\3K\3K\5K\u050b\nK\3K\3K\5K\u050f\nK\3K\3K\5K\u0513\nK\5"+
		"K\u0515\nK\3K\3K\5K\u0519\nK\3K\3K\5K\u051d\nK\3K\3K\5K\u0521\nK\7K\u0523"+
		"\nK\fK\16K\u0526\13K\5K\u0528\nK\3K\3K\3L\3L\3L\3L\5L\u0530\nL\3M\3M\5"+
		"M\u0534\nM\3M\3M\5M\u0538\nM\3M\3M\5M\u053c\nM\3M\3M\5M\u0540\nM\3M\3"+
		"M\5M\u0544\nM\7M\u0546\nM\fM\16M\u0549\13M\5M\u054b\nM\3M\3M\3N\3N\3O"+
		"\3O\3P\3P\3P\3Q\3Q\3Q\7Q\u0559\nQ\fQ\16Q\u055c\13Q\3R\3R\5R\u0560\nR\3"+
		"R\3R\5R\u0564\nR\3R\3R\5R\u0568\nR\3R\5R\u056b\nR\3R\5R\u056e\nR\3R\3"+
		"R\3S\3S\5S\u0574\nS\3S\3S\5S\u0578\nS\3S\3S\5S\u057c\nS\5S\u057e\nS\3"+
		"S\3S\5S\u0582\nS\3S\3S\5S\u0586\nS\3S\3S\5S\u058a\nS\5S\u058c\nS\3S\3"+
		"S\5S\u0590\nS\3S\3S\5S\u0594\nS\3S\3S\3T\3T\5T\u059a\nT\3T\3T\3U\3U\5"+
		"U\u05a0\nU\3U\6U\u05a3\nU\rU\16U\u05a4\3U\3U\5U\u05a9\nU\3U\3U\5U\u05ad"+
		"\nU\3U\6U\u05b0\nU\rU\16U\u05b1\5U\u05b4\nU\3U\5U\u05b7\nU\3U\3U\5U\u05bb"+
		"\nU\3U\5U\u05be\nU\3U\5U\u05c1\nU\3U\3U\3V\3V\5V\u05c7\nV\3V\3V\5V\u05cb"+
		"\nV\3V\3V\5V\u05cf\nV\3V\3V\3W\3W\3X\3X\5X\u05d7\nX\3Y\3Y\5Y\u05db\nY"+
		"\3Y\3Y\5Y\u05df\nY\3Y\3Y\5Y\u05e3\nY\3Y\3Y\5Y\u05e7\nY\3Y\3Y\5Y\u05eb"+
		"\nY\3Y\3Y\5Y\u05ef\nY\3Y\3Y\5Y\u05f3\nY\3Y\3Y\5Y\u05f7\nY\7Y\u05f9\nY"+
		"\fY\16Y\u05fc\13Y\5Y\u05fe\nY\3Y\3Y\3Z\3Z\3Z\5Z\u0605\nZ\3[\3[\5[\u0609"+
		"\n[\3[\6[\u060c\n[\r[\16[\u060d\3\\\3\\\3]\3]\3^\3^\3_\3_\5_\u0618\n_"+
		"\3`\3`\3a\3a\3b\3b\3c\3c\3d\3d\3d\2\2e\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0"+
		"\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\2\f"+
		"\3\2FI\3\2\17\20\3\2Z[\3\2df\3\2no\7\2\60<?JLUZapy\6\2VYggz|\177\177\4"+
		"\2\25\25\35 \4\2\26\26!$\4\2\20\20%/\2\u0703\2\u00c9\3\2\2\2\4\u00d7\3"+
		"\2\2\2\6\u00db\3\2\2\2\b\u00dd\3\2\2\2\n\u00f3\3\2\2\2\f\u00f7\3\2\2\2"+
		"\16\u011c\3\2\2\2\20\u0134\3\2\2\2\22\u013f\3\2\2\2\24\u0144\3\2\2\2\26"+
		"\u0148\3\2\2\2\30\u0155\3\2\2\2\32\u015f\3\2\2\2\34\u0175\3\2\2\2\36\u0177"+
		"\3\2\2\2 \u017d\3\2\2\2\"\u01ad\3\2\2\2$\u01b1\3\2\2\2&\u01c5\3\2\2\2"+
		"(\u01d9\3\2\2\2*\u01db\3\2\2\2,\u01e6\3\2\2\2.\u0201\3\2\2\2\60\u020e"+
		"\3\2\2\2\62\u0212\3\2\2\2\64\u0221\3\2\2\2\66\u022b\3\2\2\28\u0254\3\2"+
		"\2\2:\u025d\3\2\2\2<\u025f\3\2\2\2>\u026e\3\2\2\2@\u0272\3\2\2\2B\u0276"+
		"\3\2\2\2D\u027d\3\2\2\2F\u0281\3\2\2\2H\u02b0\3\2\2\2J\u02b2\3\2\2\2L"+
		"\u02c2\3\2\2\2N\u02c4\3\2\2\2P\u02dc\3\2\2\2R\u0322\3\2\2\2T\u0324\3\2"+
		"\2\2V\u0341\3\2\2\2X\u0343\3\2\2\2Z\u0358\3\2\2\2\\\u0362\3\2\2\2^\u0368"+
		"\3\2\2\2`\u037e\3\2\2\2b\u0380\3\2\2\2d\u0382\3\2\2\2f\u0384\3\2\2\2h"+
		"\u038e\3\2\2\2j\u0398\3\2\2\2l\u03a8\3\2\2\2n\u03ad\3\2\2\2p\u03b7\3\2"+
		"\2\2r\u03cd\3\2\2\2t\u03eb\3\2\2\2v\u03ff\3\2\2\2x\u0404\3\2\2\2z\u0426"+
		"\3\2\2\2|\u0432\3\2\2\2~\u0443\3\2\2\2\u0080\u0445\3\2\2\2\u0082\u04a3"+
		"\3\2\2\2\u0084\u04ab\3\2\2\2\u0086\u04ad\3\2\2\2\u0088\u04af\3\2\2\2\u008a"+
		"\u04e6\3\2\2\2\u008c\u04e8\3\2\2\2\u008e\u04f2\3\2\2\2\u0090\u04fb\3\2"+
		"\2\2\u0092\u0502\3\2\2\2\u0094\u0508\3\2\2\2\u0096\u052f\3\2\2\2\u0098"+
		"\u0531\3\2\2\2\u009a\u054e\3\2\2\2\u009c\u0550\3\2\2\2\u009e\u0552\3\2"+
		"\2\2\u00a0\u055a\3\2\2\2\u00a2\u055d\3\2\2\2\u00a4\u0571\3\2\2\2\u00a6"+
		"\u0597\3\2\2\2\u00a8\u05b3\3\2\2\2\u00aa\u05c4\3\2\2\2\u00ac\u05d2\3\2"+
		"\2\2\u00ae\u05d6\3\2\2\2\u00b0\u05d8\3\2\2\2\u00b2\u0601\3\2\2\2\u00b4"+
		"\u0606\3\2\2\2\u00b6\u060f\3\2\2\2\u00b8\u0611\3\2\2\2\u00ba\u0613\3\2"+
		"\2\2\u00bc\u0617\3\2\2\2\u00be\u0619\3\2\2\2\u00c0\u061b\3\2\2\2\u00c2"+
		"\u061d\3\2\2\2\u00c4\u061f\3\2\2\2\u00c6\u0621\3\2\2\2\u00c8\u00ca\7\u0080"+
		"\2\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00d0\5\4\3\2\u00cc\u00ce\7\u0080\2\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\7\3\2\2\u00d0\u00cd\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d4\7\u0080\2\2\u00d3\u00d2"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\2\2\3\u00d6"+
		"\3\3\2\2\2\u00d7\u00d8\5\6\4\2\u00d8\5\3\2\2\2\u00d9\u00dc\5\b\5\2\u00da"+
		"\u00dc\5,\27\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\7\3\2\2\2"+
		"\u00dd\u00e4\5\f\7\2\u00de\u00e0\7\u0080\2\2\u00df\u00de\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\5\n\6\2\u00e2\u00df\3\2"+
		"\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\t\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7\60\2\2\u00e8\u00e9\7\u0080"+
		"\2\2\u00e9\u00eb\7\61\2\2\u00ea\u00ec\7\u0080\2\2\u00eb\u00ea\3\2\2\2"+
		"\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f4\5\f\7\2\u00ee\u00f0"+
		"\7\60\2\2\u00ef\u00f1\7\u0080\2\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\5\f\7\2\u00f3\u00e7\3\2\2\2\u00f3"+
		"\u00ee\3\2\2\2\u00f4\13\3\2\2\2\u00f5\u00f8\5\16\b\2\u00f6\u00f8\5\20"+
		"\t\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\r\3\2\2\2\u00f9\u00fb"+
		"\5\24\13\2\u00fa\u00fc\7\u0080\2\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2"+
		"\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0102\u011d\5\64\33\2\u0103\u0105\5\24\13\2\u0104\u0106\7\u0080\2"+
		"\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u0103"+
		"\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u0113\5\22\n\2\u010d\u010f\7"+
		"\u0080\2\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2"+
		"\u0110\u0112\5\22\n\2\u0111\u010e\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u011a\3\2\2\2\u0115\u0113\3\2\2\2\u0116"+
		"\u0118\7\u0080\2\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119"+
		"\3\2\2\2\u0119\u011b\5\64\33\2\u011a\u0117\3\2\2\2\u011a\u011b\3\2\2\2"+
		"\u011b\u011d\3\2\2\2\u011c\u00ff\3\2\2\2\u011c\u0109\3\2\2\2\u011d\17"+
		"\3\2\2\2\u011e\u0120\5\24\13\2\u011f\u0121\7\u0080\2\2\u0120\u011f\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0123\3\2\2\2\u0122\u011e\3\2\2\2\u0123"+
		"\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u012d\3\2"+
		"\2\2\u0126\u0124\3\2\2\2\u0127\u0129\5\22\n\2\u0128\u012a\7\u0080\2\2"+
		"\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0127"+
		"\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132\5\62\32\2\u0131\u0133\7"+
		"\u0080\2\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2"+
		"\u0134\u0124\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137"+
		"\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\5\16\b\2\u0139\21\3\2\2\2\u013a"+
		"\u0140\5\36\20\2\u013b\u0140\5\32\16\2\u013c\u0140\5$\23\2\u013d\u0140"+
		"\5 \21\2\u013e\u0140\5&\24\2\u013f\u013a\3\2\2\2\u013f\u013b\3\2\2\2\u013f"+
		"\u013c\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140\23\3\2\2"+
		"\2\u0141\u0145\5\26\f\2\u0142\u0145\5\30\r\2\u0143\u0145\5*\26\2\u0144"+
		"\u0141\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0143\3\2\2\2\u0145\25\3\2\2"+
		"\2\u0146\u0147\7\62\2\2\u0147\u0149\7\u0080\2\2\u0148\u0146\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\7\63\2\2\u014b\u014d\7"+
		"\u0080\2\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2"+
		"\u014e\u0153\5F$\2\u014f\u0151\7\u0080\2\2\u0150\u014f\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0154\5D#\2\u0153\u0150\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\27\3\2\2\2\u0155\u0157\7\64\2\2\u0156\u0158\7\u0080"+
		"\2\2\u0157\u0156\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u015a\5d\63\2\u015a\u015b\7\u0080\2\2\u015b\u015c\7\65\2\2\u015c\u015d"+
		"\7\u0080\2\2\u015d\u015e\5\u00acW\2\u015e\31\3\2\2\2\u015f\u0161\7\66"+
		"\2\2\u0160\u0162\7\u0080\2\2\u0161\u0160\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0168\5H%\2\u0164\u0165\7\u0080\2\2\u0165\u0167\5"+
		"\34\17\2\u0166\u0164\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\33\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016c\7\67\2"+
		"\2\u016c\u016d\7\u0080\2\2\u016d\u016e\7\63\2\2\u016e\u016f\7\u0080\2"+
		"\2\u016f\u0176\5 \21\2\u0170\u0171\7\67\2\2\u0171\u0172\7\u0080\2\2\u0172"+
		"\u0173\78\2\2\u0173\u0174\7\u0080\2\2\u0174\u0176\5 \21\2\u0175\u016b"+
		"\3\2\2\2\u0175\u0170\3\2\2\2\u0176\35\3\2\2\2\u0177\u0179\78\2\2\u0178"+
		"\u017a\7\u0080\2\2\u0179\u0178\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u017c\5F$\2\u017c\37\3\2\2\2\u017d\u017f\79\2\2\u017e\u0180"+
		"\7\u0080\2\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\3\2\2"+
		"\2\u0181\u0186\5\"\22\2\u0182\u0183\7\4\2\2\u0183\u0185\5\"\22\2\u0184"+
		"\u0182\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2"+
		"\2\2\u0187!\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018b\5\u00b4[\2\u018a\u018c"+
		"\7\u0080\2\2\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\3\2\2"+
		"\2\u018d\u018f\7\5\2\2\u018e\u0190\7\u0080\2\2\u018f\u018e\3\2\2\2\u018f"+
		"\u0190\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0192\5d\63\2\u0192\u01ae\3\2"+
		"\2\2\u0193\u0195\5\u00acW\2\u0194\u0196\7\u0080\2\2\u0195\u0194\3\2\2"+
		"\2\u0195\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0199\7\5\2\2\u0198\u019a"+
		"\7\u0080\2\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2"+
		"\2\u019b\u019c\5d\63\2\u019c\u01ae\3\2\2\2\u019d\u019f\5\u00acW\2\u019e"+
		"\u01a0\7\u0080\2\2\u019f\u019e\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1"+
		"\3\2\2\2\u01a1\u01a3\7\6\2\2\u01a2\u01a4\7\u0080\2\2\u01a3\u01a2\3\2\2"+
		"\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\5d\63\2\u01a6\u01ae"+
		"\3\2\2\2\u01a7\u01a9\5\u00acW\2\u01a8\u01aa\7\u0080\2\2\u01a9\u01a8\3"+
		"\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\5Z.\2\u01ac"+
		"\u01ae\3\2\2\2\u01ad\u0189\3\2\2\2\u01ad\u0193\3\2\2\2\u01ad\u019d\3\2"+
		"\2\2\u01ad\u01a7\3\2\2\2\u01ae#\3\2\2\2\u01af\u01b0\7:\2\2\u01b0\u01b2"+
		"\7\u0080\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\3\2\2"+
		"\2\u01b3\u01b5\7;\2\2\u01b4\u01b6\7\u0080\2\2\u01b5\u01b4\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01c2\5d\63\2\u01b8\u01ba\7\u0080"+
		"\2\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01bd\7\4\2\2\u01bc\u01be\7\u0080\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be"+
		"\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c1\5d\63\2\u01c0\u01b9\3\2\2\2\u01c1"+
		"\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3%\3\2\2\2"+
		"\u01c4\u01c2\3\2\2\2\u01c5\u01c6\7<\2\2\u01c6\u01c7\7\u0080\2\2\u01c7"+
		"\u01d2\5(\25\2\u01c8\u01ca\7\u0080\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca"+
		"\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\7\4\2\2\u01cc\u01ce\7\u0080\2"+
		"\2\u01cd\u01cc\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d1"+
		"\5(\25\2\u01d0\u01c9\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d3\3\2\2\2\u01d3\'\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d6\5\u00ac"+
		"W\2\u01d6\u01d7\5Z.\2\u01d7\u01da\3\2\2\2\u01d8\u01da\5\u00b4[\2\u01d9"+
		"\u01d5\3\2\2\2\u01d9\u01d8\3\2\2\2\u01da)\3\2\2\2\u01db\u01dc\7=\2\2\u01dc"+
		"\u01dd\7\u0080\2\2\u01dd\u01e4\5\u0098M\2\u01de\u01e0\7\u0080\2\2\u01df"+
		"\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2\7>"+
		"\2\2\u01e2\u01e3\7\u0080\2\2\u01e3\u01e5\5.\30\2\u01e4\u01df\3\2\2\2\u01e4"+
		"\u01e5\3\2\2\2\u01e5+\3\2\2\2\u01e6\u01e7\7=\2\2\u01e7\u01ea\7\u0080\2"+
		"\2\u01e8\u01eb\5\u0098M\2\u01e9\u01eb\5\u009aN\2\u01ea\u01e8\3\2\2\2\u01ea"+
		"\u01e9\3\2\2\2\u01eb\u01f0\3\2\2\2\u01ec\u01ed\7\u0080\2\2\u01ed\u01ee"+
		"\7>\2\2\u01ee\u01ef\7\u0080\2\2\u01ef\u01f1\5.\30\2\u01f0\u01ec\3\2\2"+
		"\2\u01f0\u01f1\3\2\2\2\u01f1-\3\2\2\2\u01f2\u0202\7\7\2\2\u01f3\u01fe"+
		"\5\60\31\2\u01f4\u01f6\7\u0080\2\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2"+
		"\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f9\7\4\2\2\u01f8\u01fa\7\u0080\2\2\u01f9"+
		"\u01f8\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fd\5\60"+
		"\31\2\u01fc\u01f5\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe"+
		"\u01ff\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u01f2\3\2"+
		"\2\2\u0201\u01f3\3\2\2\2\u0202\u0207\3\2\2\2\u0203\u0205\7\u0080\2\2\u0204"+
		"\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0208\5D"+
		"#\2\u0207\u0204\3\2\2\2\u0207\u0208\3\2\2\2\u0208/\3\2\2\2\u0209\u020a"+
		"\5\u009cO\2\u020a\u020b\7\u0080\2\2\u020b\u020c\7\65\2\2\u020c\u020d\7"+
		"\u0080\2\2\u020d\u020f\3\2\2\2\u020e\u0209\3\2\2\2\u020e\u020f\3\2\2\2"+
		"\u020f\u0210\3\2\2\2\u0210\u0211\5\u00acW\2\u0211\61\3\2\2\2\u0212\u0217"+
		"\7?\2\2\u0213\u0215\7\u0080\2\2\u0214\u0213\3\2\2\2\u0214\u0215\3\2\2"+
		"\2\u0215\u0216\3\2\2\2\u0216\u0218\7@\2\2\u0217\u0214\3\2\2\2\u0217\u0218"+
		"\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\7\u0080\2\2\u021a\u021f\5\66"+
		"\34\2\u021b\u021d\7\u0080\2\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2\2"+
		"\u021d\u021e\3\2\2\2\u021e\u0220\5D#\2\u021f\u021c\3\2\2\2\u021f\u0220"+
		"\3\2\2\2\u0220\63\3\2\2\2\u0221\u0226\7A\2\2\u0222\u0224\7\u0080\2\2\u0223"+
		"\u0222\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0227\7@"+
		"\2\2\u0226\u0223\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228\3\2\2\2\u0228"+
		"\u0229\7\u0080\2\2\u0229\u022a\5\66\34\2\u022a\65\3\2\2\2\u022b\u022e"+
		"\58\35\2\u022c\u022d\7\u0080\2\2\u022d\u022f\5<\37\2\u022e\u022c\3\2\2"+
		"\2\u022e\u022f\3\2\2\2\u022f\u0232\3\2\2\2\u0230\u0231\7\u0080\2\2\u0231"+
		"\u0233\5> \2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0236\3\2\2"+
		"\2\u0234\u0235\7\u0080\2\2\u0235\u0237\5@!\2\u0236\u0234\3\2\2\2\u0236"+
		"\u0237\3\2\2\2\u0237\67\3\2\2\2\u0238\u0243\7\7\2\2\u0239\u023b\7\u0080"+
		"\2\2\u023a\u0239\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3\2\2\2\u023c"+
		"\u023e\7\4\2\2\u023d\u023f\7\u0080\2\2\u023e\u023d\3\2\2\2\u023e\u023f"+
		"\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0242\5:\36\2\u0241\u023a\3\2\2\2\u0242"+
		"\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0255\3\2"+
		"\2\2\u0245\u0243\3\2\2\2\u0246\u0251\5:\36\2\u0247\u0249\7\u0080\2\2\u0248"+
		"\u0247\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024c\7\4"+
		"\2\2\u024b\u024d\7\u0080\2\2\u024c\u024b\3\2\2\2\u024c\u024d\3\2\2\2\u024d"+
		"\u024e\3\2\2\2\u024e\u0250\5:\36\2\u024f\u0248\3\2\2\2\u0250\u0253\3\2"+
		"\2\2\u0251\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0255\3\2\2\2\u0253"+
		"\u0251\3\2\2\2\u0254\u0238\3\2\2\2\u0254\u0246\3\2\2\2\u02559\3\2\2\2"+
		"\u0256\u0257\5d\63\2\u0257\u0258\7\u0080\2\2\u0258\u0259\7\65\2\2\u0259"+
		"\u025a\7\u0080\2\2\u025a\u025b\5\u00acW\2\u025b\u025e\3\2\2\2\u025c\u025e"+
		"\5d\63\2\u025d\u0256\3\2\2\2\u025d\u025c\3\2\2\2\u025e;\3\2\2\2\u025f"+
		"\u0260\7B\2\2\u0260\u0261\7\u0080\2\2\u0261\u0262\7C\2\2\u0262\u0263\7"+
		"\u0080\2\2\u0263\u026b\5B\"\2\u0264\u0266\7\4\2\2\u0265\u0267\7\u0080"+
		"\2\2\u0266\u0265\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0268\3\2\2\2\u0268"+
		"\u026a\5B\"\2\u0269\u0264\3\2\2\2\u026a\u026d\3\2\2\2\u026b\u0269\3\2"+
		"\2\2\u026b\u026c\3\2\2\2\u026c=\3\2\2\2\u026d\u026b\3\2\2\2\u026e\u026f"+
		"\7D\2\2\u026f\u0270\7\u0080\2\2\u0270\u0271\5d\63\2\u0271?\3\2\2\2\u0272"+
		"\u0273\7E\2\2\u0273\u0274\7\u0080\2\2\u0274\u0275\5d\63\2\u0275A\3\2\2"+
		"\2\u0276\u027b\5d\63\2\u0277\u0279\7\u0080\2\2\u0278\u0277\3\2\2\2\u0278"+
		"\u0279\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027c\t\2\2\2\u027b\u0278\3\2"+
		"\2\2\u027b\u027c\3\2\2\2\u027cC\3\2\2\2\u027d\u027e\7J\2\2\u027e\u027f"+
		"\7\u0080\2\2\u027f\u0280\5d\63\2\u0280E\3\2\2\2\u0281\u028c\5H%\2\u0282"+
		"\u0284\7\u0080\2\2\u0283\u0282\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u0285"+
		"\3\2\2\2\u0285\u0287\7\4\2\2\u0286\u0288\7\u0080\2\2\u0287\u0286\3\2\2"+
		"\2\u0287\u0288\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028b\5H%\2\u028a\u0283"+
		"\3\2\2\2\u028b\u028e\3\2\2\2\u028c\u028a\3\2\2\2\u028c\u028d\3\2\2\2\u028d"+
		"G\3\2\2\2\u028e\u028c\3\2\2\2\u028f\u0291\5\u00acW\2\u0290\u0292\7\u0080"+
		"\2\2\u0291\u0290\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\3\2\2\2\u0293"+
		"\u0295\7\5\2\2\u0294\u0296\7\u0080\2\2\u0295\u0294\3\2\2\2\u0295\u0296"+
		"\3\2\2\2\u0296\u0297\3\2\2\2\u0297\u0298\5J&\2\u0298\u02b1\3\2\2\2\u0299"+
		"\u029b\5\u00acW\2\u029a\u029c\7\u0080\2\2\u029b\u029a\3\2\2\2\u029b\u029c"+
		"\3\2\2\2\u029c\u029d\3\2\2\2\u029d\u029f\7\5\2\2\u029e\u02a0\7\u0080\2"+
		"\2\u029f\u029e\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a3"+
		"\7K\2\2\u02a2\u02a4\7\u0080\2\2\u02a3\u02a2\3\2\2\2\u02a3\u02a4\3\2\2"+
		"\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7\7\b\2\2\u02a6\u02a8\7\u0080\2\2\u02a7"+
		"\u02a6\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02ab\5J"+
		"&\2\u02aa\u02ac\7\u0080\2\2\u02ab\u02aa\3\2\2\2\u02ab\u02ac\3\2\2\2\u02ac"+
		"\u02ad\3\2\2\2\u02ad\u02ae\7\t\2\2\u02ae\u02b1\3\2\2\2\u02af\u02b1\5J"+
		"&\2\u02b0\u028f\3\2\2\2\u02b0\u0299\3\2\2\2\u02b0\u02af\3\2\2\2\u02b1"+
		"I\3\2\2\2\u02b2\u02b3\5L\'\2\u02b3K\3\2\2\2\u02b4\u02bb\5N(\2\u02b5\u02b7"+
		"\7\u0080\2\2\u02b6\u02b5\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\3\2\2"+
		"\2\u02b8\u02ba\5P)\2\u02b9\u02b6\3\2\2\2\u02ba\u02bd\3\2\2\2\u02bb\u02b9"+
		"\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u02c3\3\2\2\2\u02bd\u02bb\3\2\2\2\u02be"+
		"\u02bf\7\b\2\2\u02bf\u02c0\5L\'\2\u02c0\u02c1\7\t\2\2\u02c1\u02c3\3\2"+
		"\2\2\u02c2\u02b4\3\2\2\2\u02c2\u02be\3\2\2\2\u02c3M\3\2\2\2\u02c4\u02c6"+
		"\7\b\2\2\u02c5\u02c7\7\u0080\2\2\u02c6\u02c5\3\2\2\2\u02c6\u02c7\3\2\2"+
		"\2\u02c7\u02cc\3\2\2\2\u02c8\u02ca\5\u00acW\2\u02c9\u02cb\7\u0080\2\2"+
		"\u02ca\u02c9\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cd\3\2\2\2\u02cc\u02c8"+
		"\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02d2\3\2\2\2\u02ce\u02d0\5Z.\2\u02cf"+
		"\u02d1\7\u0080\2\2\u02d0\u02cf\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d3"+
		"\3\2\2\2\u02d2\u02ce\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d8\3\2\2\2\u02d4"+
		"\u02d6\5V,\2\u02d5\u02d7\7\u0080\2\2\u02d6\u02d5\3\2\2\2\u02d6\u02d7\3"+
		"\2\2\2\u02d7\u02d9\3\2\2\2\u02d8\u02d4\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9"+
		"\u02da\3\2\2\2\u02da\u02db\7\t\2\2\u02dbO\3\2\2\2\u02dc\u02de\5R*\2\u02dd"+
		"\u02df\7\u0080\2\2\u02de\u02dd\3\2\2\2\u02de\u02df\3\2\2\2\u02df\u02e0"+
		"\3\2\2\2\u02e0\u02e1\5N(\2\u02e1Q\3\2\2\2\u02e2\u02e4\5\u00c2b\2\u02e3"+
		"\u02e5\7\u0080\2\2\u02e4\u02e3\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e6"+
		"\3\2\2\2\u02e6\u02e8\5\u00c6d\2\u02e7\u02e9\7\u0080\2\2\u02e8\u02e7\3"+
		"\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02eb\3\2\2\2\u02ea\u02ec\5T+\2\u02eb"+
		"\u02ea\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec\u02ee\3\2\2\2\u02ed\u02ef\7\u0080"+
		"\2\2\u02ee\u02ed\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0"+
		"\u02f2\5\u00c6d\2\u02f1\u02f3\7\u0080\2\2\u02f2\u02f1\3\2\2\2\u02f2\u02f3"+
		"\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f5\5\u00c4c\2\u02f5\u0323\3\2\2"+
		"\2\u02f6\u02f8\5\u00c2b\2\u02f7\u02f9\7\u0080\2\2\u02f8\u02f7\3\2\2\2"+
		"\u02f8\u02f9\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fc\5\u00c6d\2\u02fb"+
		"\u02fd\7\u0080\2\2\u02fc\u02fb\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02ff"+
		"\3\2\2\2\u02fe\u0300\5T+\2\u02ff\u02fe\3\2\2\2\u02ff\u0300\3\2\2\2\u0300"+
		"\u0302\3\2\2\2\u0301\u0303\7\u0080\2\2\u0302\u0301\3\2\2\2\u0302\u0303"+
		"\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0305\5\u00c6d\2\u0305\u0323\3\2\2"+
		"\2\u0306\u0308\5\u00c6d\2\u0307\u0309\7\u0080\2\2\u0308\u0307\3\2\2\2"+
		"\u0308\u0309\3\2\2\2\u0309\u030b\3\2\2\2\u030a\u030c\5T+\2\u030b\u030a"+
		"\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u030e\3\2\2\2\u030d\u030f\7\u0080\2"+
		"\2\u030e\u030d\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0312"+
		"\5\u00c6d\2\u0311\u0313\7\u0080\2\2\u0312\u0311\3\2\2\2\u0312\u0313\3"+
		"\2\2\2\u0313\u0314\3\2\2\2\u0314\u0315\5\u00c4c\2\u0315\u0323\3\2\2\2"+
		"\u0316\u0318\5\u00c6d\2\u0317\u0319\7\u0080\2\2\u0318\u0317\3\2\2\2\u0318"+
		"\u0319\3\2\2\2\u0319\u031b\3\2\2\2\u031a\u031c\5T+\2\u031b\u031a\3\2\2"+
		"\2\u031b\u031c\3\2\2\2\u031c\u031e\3\2\2\2\u031d\u031f\7\u0080\2\2\u031e"+
		"\u031d\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0321\5\u00c6"+
		"d\2\u0321\u0323\3\2\2\2\u0322\u02e2\3\2\2\2\u0322\u02f6\3\2\2\2\u0322"+
		"\u0306\3\2\2\2\u0322\u0316\3\2\2\2\u0323S\3\2\2\2\u0324\u0326\7\n\2\2"+
		"\u0325\u0327\7\u0080\2\2\u0326\u0325\3\2\2\2\u0326\u0327\3\2\2\2\u0327"+
		"\u032c\3\2\2\2\u0328\u032a\5\u00acW\2\u0329\u032b\7\u0080\2\2\u032a\u0329"+
		"\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u032d\3\2\2\2\u032c\u0328\3\2\2\2\u032c"+
		"\u032d\3\2\2\2\u032d\u0332\3\2\2\2\u032e\u0330\5X-\2\u032f\u0331\7\u0080"+
		"\2\2\u0330\u032f\3\2\2\2\u0330\u0331\3\2\2\2\u0331\u0333\3\2\2\2\u0332"+
		"\u032e\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0335\3\2\2\2\u0334\u0336\5^"+
		"\60\2\u0335\u0334\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u033b\3\2\2\2\u0337"+
		"\u0339\5V,\2\u0338\u033a\7\u0080\2\2\u0339\u0338\3\2\2\2\u0339\u033a\3"+
		"\2\2\2\u033a\u033c\3\2\2\2\u033b\u0337\3\2\2\2\u033b\u033c\3\2\2\2\u033c"+
		"\u033d\3\2\2\2\u033d\u033e\7\13\2\2\u033eU\3\2\2\2\u033f\u0342\5\u00b0"+
		"Y\2\u0340\u0342\5\u00b2Z\2\u0341\u033f\3\2\2\2\u0341\u0340\3\2\2\2\u0342"+
		"W\3\2\2\2\u0343\u0345\7\f\2\2\u0344\u0346\7\u0080\2\2\u0345\u0344\3\2"+
		"\2\2\u0345\u0346\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0355\5b\62\2\u0348"+
		"\u034a\7\u0080\2\2\u0349\u0348\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u034b"+
		"\3\2\2\2\u034b\u034d\7\r\2\2\u034c\u034e\7\f\2\2\u034d\u034c\3\2\2\2\u034d"+
		"\u034e\3\2\2\2\u034e\u0350\3\2\2\2\u034f\u0351\7\u0080\2\2\u0350\u034f"+
		"\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0354\5b\62\2\u0353"+
		"\u0349\3\2\2\2\u0354\u0357\3\2\2\2\u0355\u0353\3\2\2\2\u0355\u0356\3\2"+
		"\2\2\u0356Y\3\2\2\2\u0357\u0355\3\2\2\2\u0358\u035f\5\\/\2\u0359\u035b"+
		"\7\u0080\2\2\u035a\u0359\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035c\3\2\2"+
		"\2\u035c\u035e\5\\/\2\u035d\u035a\3\2\2\2\u035e\u0361\3\2\2\2\u035f\u035d"+
		"\3\2\2\2\u035f\u0360\3\2\2\2\u0360[\3\2\2\2\u0361\u035f\3\2\2\2\u0362"+
		"\u0364\7\f\2\2\u0363\u0365\7\u0080\2\2\u0364\u0363\3\2\2\2\u0364\u0365"+
		"\3\2\2\2\u0365\u0366\3\2\2\2\u0366\u0367\5`\61\2\u0367]\3\2\2\2\u0368"+
		"\u036a\7\7\2\2\u0369\u036b\7\u0080\2\2\u036a\u0369\3\2\2\2\u036a\u036b"+
		"\3\2\2\2\u036b\u0370\3\2\2\2\u036c\u036e\5\u00b8]\2\u036d\u036f\7\u0080"+
		"\2\2\u036e\u036d\3\2\2\2\u036e\u036f\3\2\2\2\u036f\u0371\3\2\2\2\u0370"+
		"\u036c\3\2\2\2\u0370\u0371\3\2\2\2\u0371\u037c\3\2\2\2\u0372\u0374\7\16"+
		"\2\2\u0373\u0375\7\u0080\2\2\u0374\u0373\3\2\2\2\u0374\u0375\3\2\2\2\u0375"+
		"\u037a\3\2\2\2\u0376\u0378\5\u00b8]\2\u0377\u0379\7\u0080\2\2\u0378\u0377"+
		"\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037b\3\2\2\2\u037a\u0376\3\2\2\2\u037a"+
		"\u037b\3\2\2\2\u037b\u037d\3\2\2\2\u037c\u0372\3\2\2\2\u037c\u037d\3\2"+
		"\2\2\u037d_\3\2\2\2\u037e\u037f\5\u00bc_\2\u037fa\3\2\2\2\u0380\u0381"+
		"\5\u00bc_\2\u0381c\3\2\2\2\u0382\u0383\5f\64\2\u0383e\3\2\2\2\u0384\u038b"+
		"\5h\65\2\u0385\u0386\7\u0080\2\2\u0386\u0387\7L\2\2\u0387\u0388\7\u0080"+
		"\2\2\u0388\u038a\5h\65\2\u0389\u0385\3\2\2\2\u038a\u038d\3\2\2\2\u038b"+
		"\u0389\3\2\2\2\u038b\u038c\3\2\2\2\u038cg\3\2\2\2\u038d\u038b\3\2\2\2"+
		"\u038e\u0395\5j\66\2\u038f\u0390\7\u0080\2\2\u0390\u0391\7M\2\2\u0391"+
		"\u0392\7\u0080\2\2\u0392\u0394\5j\66\2\u0393\u038f\3\2\2\2\u0394\u0397"+
		"\3\2\2\2\u0395\u0393\3\2\2\2\u0395\u0396\3\2\2\2\u0396i\3\2\2\2\u0397"+
		"\u0395\3\2\2\2\u0398\u039f\5l\67\2\u0399\u039a\7\u0080\2\2\u039a\u039b"+
		"\7N\2\2\u039b\u039c\7\u0080\2\2\u039c\u039e\5l\67\2\u039d\u0399\3\2\2"+
		"\2\u039e\u03a1\3\2\2\2\u039f\u039d\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0k"+
		"\3\2\2\2\u03a1\u039f\3\2\2\2\u03a2\u03a4\7O\2\2\u03a3\u03a5\7\u0080\2"+
		"\2\u03a4\u03a3\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a7\3\2\2\2\u03a6\u03a2"+
		"\3\2\2\2\u03a7\u03aa\3\2\2\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9"+
		"\u03ab\3\2\2\2\u03aa\u03a8\3\2\2\2\u03ab\u03ac\5n8\2\u03acm\3\2\2\2\u03ad"+
		"\u03b4\5p9\2\u03ae\u03b0\7\u0080\2\2\u03af\u03ae\3\2\2\2\u03af\u03b0\3"+
		"\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b3\5\u008aF\2\u03b2\u03af\3\2\2\2"+
		"\u03b3\u03b6\3\2\2\2\u03b4\u03b2\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5o\3"+
		"\2\2\2\u03b6\u03b4\3\2\2\2\u03b7\u03ca\5r:\2\u03b8\u03ba\7\u0080\2\2\u03b9"+
		"\u03b8\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03bd\7\17"+
		"\2\2\u03bc\u03be\7\u0080\2\2\u03bd\u03bc\3\2\2\2\u03bd\u03be\3\2\2\2\u03be"+
		"\u03bf\3\2\2\2\u03bf\u03c9\5r:\2\u03c0\u03c2\7\u0080\2\2\u03c1\u03c0\3"+
		"\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c5\7\20\2\2\u03c4"+
		"\u03c6\7\u0080\2\2\u03c5\u03c4\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c7"+
		"\3\2\2\2\u03c7\u03c9\5r:\2\u03c8\u03b9\3\2\2\2\u03c8\u03c1\3\2\2\2\u03c9"+
		"\u03cc\3\2\2\2\u03ca\u03c8\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cbq\3\2\2\2"+
		"\u03cc\u03ca\3\2\2\2\u03cd\u03e8\5t;\2\u03ce\u03d0\7\u0080\2\2\u03cf\u03ce"+
		"\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d3\7\7\2\2\u03d2"+
		"\u03d4\7\u0080\2\2\u03d3\u03d2\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4\u03d5"+
		"\3\2\2\2\u03d5\u03e7\5t;\2\u03d6\u03d8\7\u0080\2\2\u03d7\u03d6\3\2\2\2"+
		"\u03d7\u03d8\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9\u03db\7\21\2\2\u03da\u03dc"+
		"\7\u0080\2\2\u03db\u03da\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc\u03dd\3\2\2"+
		"\2\u03dd\u03e7\5t;\2\u03de\u03e0\7\u0080\2\2\u03df\u03de\3\2\2\2\u03df"+
		"\u03e0\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u03e3\7\22\2\2\u03e2\u03e4\7"+
		"\u0080\2\2\u03e3\u03e2\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03e5\3\2\2\2"+
		"\u03e5\u03e7\5t;\2\u03e6\u03cf\3\2\2\2\u03e6\u03d7\3\2\2\2\u03e6\u03df"+
		"\3\2\2\2\u03e7\u03ea\3\2\2\2\u03e8\u03e6\3\2\2\2\u03e8\u03e9\3\2\2\2\u03e9"+
		"s\3\2\2\2\u03ea\u03e8\3\2\2\2\u03eb\u03f6\5v<\2\u03ec\u03ee\7\u0080\2"+
		"\2\u03ed\u03ec\3\2\2\2\u03ed\u03ee\3\2\2\2\u03ee\u03ef\3\2\2\2\u03ef\u03f1"+
		"\7\23\2\2\u03f0\u03f2\7\u0080\2\2\u03f1\u03f0\3\2\2\2\u03f1\u03f2\3\2"+
		"\2\2\u03f2\u03f3\3\2\2\2\u03f3\u03f5\5v<\2\u03f4\u03ed\3\2\2\2\u03f5\u03f8"+
		"\3\2\2\2\u03f6\u03f4\3\2\2\2\u03f6\u03f7\3\2\2\2\u03f7u\3\2\2\2\u03f8"+
		"\u03f6\3\2\2\2\u03f9\u03fb\t\3\2\2\u03fa\u03fc\7\u0080\2\2\u03fb\u03fa"+
		"\3\2\2\2\u03fb\u03fc\3\2\2\2\u03fc\u03fe\3\2\2\2\u03fd\u03f9\3\2\2\2\u03fe"+
		"\u0401\3\2\2\2\u03ff\u03fd\3\2\2\2\u03ff\u0400\3\2\2\2\u0400\u0402\3\2"+
		"\2\2\u0401\u03ff\3\2\2\2\u0402\u0403\5x=\2\u0403w\3\2\2\2\u0404\u040a"+
		"\5\u0080A\2\u0405\u0409\5|?\2\u0406\u0409\5z>\2\u0407\u0409\5~@\2\u0408"+
		"\u0405\3\2\2\2\u0408\u0406\3\2\2\2\u0408\u0407\3\2\2\2\u0409\u040c\3\2"+
		"\2\2\u040a\u0408\3\2\2\2\u040a\u040b\3\2\2\2\u040by\3\2\2\2\u040c\u040a"+
		"\3\2\2\2\u040d\u040e\7\u0080\2\2\u040e\u0410\7P\2\2\u040f\u0411\7\u0080"+
		"\2\2\u0410\u040f\3\2\2\2\u0410\u0411\3\2\2\2\u0411\u0412\3\2\2\2\u0412"+
		"\u0427\5\u0080A\2\u0413\u0415\7\u0080\2\2\u0414\u0413\3\2\2\2\u0414\u0415"+
		"\3\2\2\2\u0415\u0416\3\2\2\2\u0416\u0417\7\n\2\2\u0417\u0418\5d\63\2\u0418"+
		"\u0419\7\13\2\2\u0419\u0427\3\2\2\2\u041a\u041c\7\u0080\2\2\u041b\u041a"+
		"\3\2\2\2\u041b\u041c\3\2\2\2\u041c\u041d\3\2\2\2\u041d\u041f\7\n\2\2\u041e"+
		"\u0420\5d\63\2\u041f\u041e\3\2\2\2\u041f\u0420\3\2\2\2\u0420\u0421\3\2"+
		"\2\2\u0421\u0423\7\16\2\2\u0422\u0424\5d\63\2\u0423\u0422\3\2\2\2\u0423"+
		"\u0424\3\2\2\2\u0424\u0425\3\2\2\2\u0425\u0427\7\13\2\2\u0426\u040d\3"+
		"\2\2\2\u0426\u0414\3\2\2\2\u0426\u041b\3\2\2\2\u0427{\3\2\2\2\u0428\u0429"+
		"\7\u0080\2\2\u0429\u042a\7Q\2\2\u042a\u042b\7\u0080\2\2\u042b\u0433\7"+
		"?\2\2\u042c\u042d\7\u0080\2\2\u042d\u042e\7R\2\2\u042e\u042f\7\u0080\2"+
		"\2\u042f\u0433\7?\2\2\u0430\u0431\7\u0080\2\2\u0431\u0433\7S\2\2\u0432"+
		"\u0428\3\2\2\2\u0432\u042c\3\2\2\2\u0432\u0430\3\2\2\2\u0433\u0435\3\2"+
		"\2\2\u0434\u0436\7\u0080\2\2\u0435\u0434\3\2\2\2\u0435\u0436\3\2\2\2\u0436"+
		"\u0437\3\2\2\2\u0437\u0438\5\u0080A\2\u0438}\3\2\2\2\u0439\u043a\7\u0080"+
		"\2\2\u043a\u043b\7T\2\2\u043b\u043c\7\u0080\2\2\u043c\u0444\7U\2\2\u043d"+
		"\u043e\7\u0080\2\2\u043e\u043f\7T\2\2\u043f\u0440\7\u0080\2\2\u0440\u0441"+
		"\7O\2\2\u0441\u0442\7\u0080\2\2\u0442\u0444\7U\2\2\u0443\u0439\3\2\2\2"+
		"\u0443\u043d\3\2\2\2\u0444\177\3\2\2\2\u0445\u044c\5\u0082B\2\u0446\u0448"+
		"\7\u0080\2\2\u0447\u0446\3\2\2\2\u0447\u0448\3\2\2\2\u0448\u0449\3\2\2"+
		"\2\u0449\u044b\5\u00a6T\2\u044a\u0447\3\2\2\2\u044b\u044e\3\2\2\2\u044c"+
		"\u044a\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u0453\3\2\2\2\u044e\u044c\3\2"+
		"\2\2\u044f\u0451\7\u0080\2\2\u0450\u044f\3\2\2\2\u0450\u0451\3\2\2\2\u0451"+
		"\u0452\3\2\2\2\u0452\u0454\5Z.\2\u0453\u0450\3\2\2\2\u0453\u0454\3\2\2"+
		"\2\u0454\u0081\3\2\2\2\u0455\u04a4\5\u0084C\2\u0456\u04a4\5\u00b2Z\2\u0457"+
		"\u04a4\5\u00a8U\2\u0458\u045a\7V\2\2\u0459\u045b\7\u0080\2\2\u045a\u0459"+
		"\3\2\2\2\u045a\u045b\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045e\7\b\2\2\u045d"+
		"\u045f\7\u0080\2\2\u045e\u045d\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0460"+
		"\3\2\2\2\u0460\u0462\7\7\2\2\u0461\u0463\7\u0080\2\2\u0462\u0461\3\2\2"+
		"\2\u0462\u0463\3\2\2\2\u0463\u0464\3\2\2\2\u0464\u04a4\7\t\2\2\u0465\u04a4"+
		"\5\u00a2R\2\u0466\u04a4\5\u00a4S\2\u0467\u0469\7\61\2\2\u0468\u046a\7"+
		"\u0080\2\2\u0469\u0468\3\2\2\2\u0469\u046a\3\2\2\2\u046a\u046b\3\2\2\2"+
		"\u046b\u046d\7\b\2\2\u046c\u046e\7\u0080\2\2\u046d\u046c\3\2\2\2\u046d"+
		"\u046e\3\2\2\2\u046e\u046f\3\2\2\2\u046f\u0471\5\u0090I\2\u0470\u0472"+
		"\7\u0080\2\2\u0471\u0470\3\2\2\2\u0471\u0472\3\2\2\2\u0472\u0473\3\2\2"+
		"\2\u0473\u0474\7\t\2\2\u0474\u04a4\3\2\2\2\u0475\u0477\7W\2\2\u0476\u0478"+
		"\7\u0080\2\2\u0477\u0476\3\2\2\2\u0477\u0478\3\2\2\2\u0478\u0479\3\2\2"+
		"\2\u0479\u047b\7\b\2\2\u047a\u047c\7\u0080\2\2\u047b\u047a\3\2\2\2\u047b"+
		"\u047c\3\2\2\2\u047c\u047d\3\2\2\2\u047d\u047f\5\u0090I\2\u047e\u0480"+
		"\7\u0080\2\2\u047f\u047e\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0481\3\2\2"+
		"\2\u0481\u0482\7\t\2\2\u0482\u04a4\3\2\2\2\u0483\u0485\7X\2\2\u0484\u0486"+
		"\7\u0080\2\2\u0485\u0484\3\2\2\2\u0485\u0486\3\2\2\2\u0486\u0487\3\2\2"+
		"\2\u0487\u0489\7\b\2\2\u0488\u048a\7\u0080\2\2\u0489\u0488\3\2\2\2\u0489"+
		"\u048a\3\2\2\2\u048a\u048b\3\2\2\2\u048b\u048d\5\u0090I\2\u048c\u048e"+
		"\7\u0080\2\2\u048d\u048c\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u048f\3\2\2"+
		"\2\u048f\u0490\7\t\2\2\u0490\u04a4\3\2\2\2\u0491\u0493\7Y\2\2\u0492\u0494"+
		"\7\u0080\2\2\u0493\u0492\3\2\2\2\u0493\u0494\3\2\2\2\u0494\u0495\3\2\2"+
		"\2\u0495\u0497\7\b\2\2\u0496\u0498\7\u0080\2\2\u0497\u0496\3\2\2\2\u0497"+
		"\u0498\3\2\2\2\u0498\u0499\3\2\2\2\u0499\u049b\5\u0090I\2\u049a\u049c"+
		"\7\u0080\2\2\u049b\u049a\3\2\2\2\u049b\u049c\3\2\2\2\u049c\u049d\3\2\2"+
		"\2\u049d\u049e\7\t\2\2\u049e\u04a4\3\2\2\2\u049f\u04a4\5\u008eH\2\u04a0"+
		"\u04a4\5\u008cG\2\u04a1\u04a4\5\u0094K\2\u04a2\u04a4\5\u00acW\2\u04a3"+
		"\u0455\3\2\2\2\u04a3\u0456\3\2\2\2\u04a3\u0457\3\2\2\2\u04a3\u0458\3\2"+
		"\2\2\u04a3\u0465\3\2\2\2\u04a3\u0466\3\2\2\2\u04a3\u0467\3\2\2\2\u04a3"+
		"\u0475\3\2\2\2\u04a3\u0483\3\2\2\2\u04a3\u0491\3\2\2\2\u04a3\u049f\3\2"+
		"\2\2\u04a3\u04a0\3\2\2\2\u04a3\u04a1\3\2\2\2\u04a3\u04a2\3\2\2\2\u04a4"+
		"\u0083\3\2\2\2\u04a5\u04ac\5\u00aeX\2\u04a6\u04ac\7b\2\2\u04a7\u04ac\5"+
		"\u0086D\2\u04a8\u04ac\7U\2\2\u04a9\u04ac\5\u00b0Y\2\u04aa\u04ac\5\u0088"+
		"E\2\u04ab\u04a5\3\2\2\2\u04ab\u04a6\3\2\2\2\u04ab\u04a7\3\2\2\2\u04ab"+
		"\u04a8\3\2\2\2\u04ab\u04a9\3\2\2\2\u04ab\u04aa\3\2\2\2\u04ac\u0085\3\2"+
		"\2\2\u04ad\u04ae\t\4\2\2\u04ae\u0087\3\2\2\2\u04af\u04b1\7\n\2\2\u04b0"+
		"\u04b2\7\u0080\2\2\u04b1\u04b0\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u04c4"+
		"\3\2\2\2\u04b3\u04b5\5d\63\2\u04b4\u04b6\7\u0080\2\2\u04b5\u04b4\3\2\2"+
		"\2\u04b5\u04b6\3\2\2\2\u04b6\u04c1\3\2\2\2\u04b7\u04b9\7\4\2\2\u04b8\u04ba"+
		"\7\u0080\2\2\u04b9\u04b8\3\2\2\2\u04b9\u04ba\3\2\2\2\u04ba\u04bb\3\2\2"+
		"\2\u04bb\u04bd\5d\63\2\u04bc\u04be\7\u0080\2\2\u04bd\u04bc\3\2\2\2\u04bd"+
		"\u04be\3\2\2\2\u04be\u04c0\3\2\2\2\u04bf\u04b7\3\2\2\2\u04c0\u04c3\3\2"+
		"\2\2\u04c1\u04bf\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c5\3\2\2\2\u04c3"+
		"\u04c1\3\2\2\2\u04c4\u04b3\3\2\2\2\u04c4\u04c5\3\2\2\2\u04c5\u04c6\3\2"+
		"\2\2\u04c6\u04c7\7\13\2\2\u04c7\u0089\3\2\2\2\u04c8\u04ca\7\5\2\2\u04c9"+
		"\u04cb\7\u0080\2\2\u04ca\u04c9\3\2\2\2\u04ca\u04cb\3\2\2\2\u04cb\u04cc"+
		"\3\2\2\2\u04cc\u04e7\5p9\2\u04cd\u04cf\7\24\2\2\u04ce\u04d0\7\u0080\2"+
		"\2\u04cf\u04ce\3\2\2\2\u04cf\u04d0\3\2\2\2\u04d0\u04d1\3\2\2\2\u04d1\u04e7"+
		"\5p9\2\u04d2\u04d4\7\25\2\2\u04d3\u04d5\7\u0080\2\2\u04d4\u04d3\3\2\2"+
		"\2\u04d4\u04d5\3\2\2\2\u04d5\u04d6\3\2\2\2\u04d6\u04e7\5p9\2\u04d7\u04d9"+
		"\7\26\2\2\u04d8\u04da\7\u0080\2\2\u04d9\u04d8\3\2\2\2\u04d9\u04da\3\2"+
		"\2\2\u04da\u04db\3\2\2\2\u04db\u04e7\5p9\2\u04dc\u04de\7\27\2\2\u04dd"+
		"\u04df\7\u0080\2\2\u04de\u04dd\3\2\2\2\u04de\u04df\3\2\2\2\u04df\u04e0"+
		"\3\2\2\2\u04e0\u04e7\5p9\2\u04e1\u04e3\7\30\2\2\u04e2\u04e4\7\u0080\2"+
		"\2\u04e3\u04e2\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04e7"+
		"\5p9\2\u04e6\u04c8\3\2\2\2\u04e6\u04cd\3\2\2\2\u04e6\u04d2\3\2\2\2\u04e6"+
		"\u04d7\3\2\2\2\u04e6\u04dc\3\2\2\2\u04e6\u04e1\3\2\2\2\u04e7\u008b\3\2"+
		"\2\2\u04e8\u04ea\7\b\2\2\u04e9\u04eb\7\u0080\2\2\u04ea\u04e9\3\2\2\2\u04ea"+
		"\u04eb\3\2\2\2\u04eb\u04ec\3\2\2\2\u04ec\u04ee\5d\63\2\u04ed\u04ef\7\u0080"+
		"\2\2\u04ee\u04ed\3\2\2\2\u04ee\u04ef\3\2\2\2\u04ef\u04f0\3\2\2\2\u04f0"+
		"\u04f1\7\t\2\2\u04f1\u008d\3\2\2\2\u04f2\u04f7\5N(\2\u04f3\u04f5\7\u0080"+
		"\2\2\u04f4\u04f3\3\2\2\2\u04f4\u04f5\3\2\2\2\u04f5\u04f6\3\2\2\2\u04f6"+
		"\u04f8\5P)\2\u04f7\u04f4\3\2\2\2\u04f8\u04f9\3\2\2\2\u04f9\u04f7\3\2\2"+
		"\2\u04f9\u04fa\3\2\2\2\u04fa\u008f\3\2\2\2\u04fb\u0500\5\u0092J\2\u04fc"+
		"\u04fe\7\u0080\2\2\u04fd\u04fc\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u04ff"+
		"\3\2\2\2\u04ff\u0501\5D#\2\u0500\u04fd\3\2\2\2\u0500\u0501\3\2\2\2\u0501"+
		"\u0091\3\2\2\2\u0502\u0503\5\u00acW\2\u0503\u0504\7\u0080\2\2\u0504\u0505"+
		"\7P\2\2\u0505\u0506\7\u0080\2\2\u0506\u0507\5d\63\2\u0507\u0093\3\2\2"+
		"\2\u0508\u050a\5\u0096L\2\u0509\u050b\7\u0080\2\2\u050a\u0509\3\2\2\2"+
		"\u050a\u050b\3\2\2\2\u050b\u050c\3\2\2\2\u050c\u050e\7\b\2\2\u050d\u050f"+
		"\7\u0080\2\2\u050e\u050d\3\2\2\2\u050e\u050f\3\2\2\2\u050f\u0514\3\2\2"+
		"\2\u0510\u0512\7@\2\2\u0511\u0513\7\u0080\2\2\u0512\u0511\3\2\2\2\u0512"+
		"\u0513\3\2\2\2\u0513\u0515\3\2\2\2\u0514\u0510\3\2\2\2\u0514\u0515\3\2"+
		"\2\2\u0515\u0527\3\2\2\2\u0516\u0518\5d\63\2\u0517\u0519\7\u0080\2\2\u0518"+
		"\u0517\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u0524\3\2\2\2\u051a\u051c\7\4"+
		"\2\2\u051b\u051d\7\u0080\2\2\u051c\u051b\3\2\2\2\u051c\u051d\3\2\2\2\u051d"+
		"\u051e\3\2\2\2\u051e\u0520\5d\63\2\u051f\u0521\7\u0080\2\2\u0520\u051f"+
		"\3\2\2\2\u0520\u0521\3\2\2\2\u0521\u0523\3\2\2\2\u0522\u051a\3\2\2\2\u0523"+
		"\u0526\3\2\2\2\u0524\u0522\3\2\2\2\u0524\u0525\3\2\2\2\u0525\u0528\3\2"+
		"\2\2\u0526\u0524\3\2\2\2\u0527\u0516\3\2\2\2\u0527\u0528\3\2\2\2\u0528"+
		"\u0529\3\2\2\2\u0529\u052a\7\t\2\2\u052a\u0095\3\2\2\2\u052b\u052c\5\u00a0"+
		"Q\2\u052c\u052d\5\u00c0a\2\u052d\u0530\3\2\2\2\u052e\u0530\7\\\2\2\u052f"+
		"\u052b\3\2\2\2\u052f\u052e\3\2\2\2\u0530\u0097\3\2\2\2\u0531\u0533\5\u009e"+
		"P\2\u0532\u0534\7\u0080\2\2\u0533\u0532\3\2\2\2\u0533\u0534\3\2\2\2\u0534"+
		"\u0535\3\2\2\2\u0535\u0537\7\b\2\2\u0536\u0538\7\u0080\2\2\u0537\u0536"+
		"\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u054a\3\2\2\2\u0539\u053b\5d\63\2\u053a"+
		"\u053c\7\u0080\2\2\u053b\u053a\3\2\2\2\u053b\u053c\3\2\2\2\u053c\u0547"+
		"\3\2\2\2\u053d\u053f\7\4\2\2\u053e\u0540\7\u0080\2\2\u053f\u053e\3\2\2"+
		"\2\u053f\u0540\3\2\2\2\u0540\u0541\3\2\2\2\u0541\u0543\5d\63\2\u0542\u0544"+
		"\7\u0080\2\2\u0543\u0542\3\2\2\2\u0543\u0544\3\2\2\2\u0544\u0546\3\2\2"+
		"\2\u0545\u053d\3\2\2\2\u0546\u0549\3\2\2\2\u0547\u0545\3\2\2\2\u0547\u0548"+
		"\3\2\2\2\u0548\u054b\3\2\2\2\u0549\u0547\3\2\2\2\u054a\u0539\3\2\2\2\u054a"+
		"\u054b\3\2\2\2\u054b\u054c\3\2\2\2\u054c\u054d\7\t\2\2\u054d\u0099\3\2"+
		"\2\2\u054e\u054f\5\u009eP\2\u054f\u009b\3\2\2\2\u0550\u0551\5\u00c0a\2"+
		"\u0551\u009d\3\2\2\2\u0552\u0553\5\u00a0Q\2\u0553\u0554\5\u00c0a\2\u0554"+
		"\u009f\3\2\2\2\u0555\u0556\5\u00c0a\2\u0556\u0557\7\31\2\2\u0557\u0559"+
		"\3\2\2\2\u0558\u0555\3\2\2\2\u0559\u055c\3\2\2\2\u055a\u0558\3\2\2\2\u055a"+
		"\u055b\3\2\2\2\u055b\u00a1\3\2\2\2\u055c\u055a\3\2\2\2\u055d\u055f\7\n"+
		"\2\2\u055e\u0560\7\u0080\2\2\u055f\u055e\3\2\2\2\u055f\u0560\3\2\2\2\u0560"+
		"\u0561\3\2\2\2\u0561\u056a\5\u0090I\2\u0562\u0564\7\u0080\2\2\u0563\u0562"+
		"\3\2\2\2\u0563\u0564\3\2\2\2\u0564\u0565\3\2\2\2\u0565\u0567\7\r\2\2\u0566"+
		"\u0568\7\u0080\2\2\u0567\u0566\3\2\2\2\u0567\u0568\3\2\2\2\u0568\u0569"+
		"\3\2\2\2\u0569\u056b\5d\63\2\u056a\u0563\3\2\2\2\u056a\u056b\3\2\2\2\u056b"+
		"\u056d\3\2\2\2\u056c\u056e\7\u0080\2\2\u056d\u056c\3\2\2\2\u056d\u056e"+
		"\3\2\2\2\u056e\u056f\3\2\2\2\u056f\u0570\7\13\2\2\u0570\u00a3\3\2\2\2"+
		"\u0571\u0573\7\n\2\2\u0572\u0574\7\u0080\2\2\u0573\u0572\3\2\2\2\u0573"+
		"\u0574\3\2\2\2\u0574\u057d\3\2\2\2\u0575\u0577\5\u00acW\2\u0576\u0578"+
		"\7\u0080\2\2\u0577\u0576\3\2\2\2\u0577\u0578\3\2\2\2\u0578\u0579\3\2\2"+
		"\2\u0579\u057b\7\5\2\2\u057a\u057c\7\u0080\2\2\u057b\u057a\3\2\2\2\u057b"+
		"\u057c\3\2\2\2\u057c\u057e\3\2\2\2\u057d\u0575\3\2\2\2\u057d\u057e\3\2"+
		"\2\2\u057e\u057f\3\2\2\2\u057f\u0581\5\u008eH\2\u0580\u0582\7\u0080\2"+
		"\2\u0581\u0580\3\2\2\2\u0581\u0582\3\2\2\2\u0582\u058b\3\2\2\2\u0583\u0585"+
		"\7J\2\2\u0584\u0586\7\u0080\2\2\u0585\u0584\3\2\2\2\u0585\u0586\3\2\2"+
		"\2\u0586\u0587\3\2\2\2\u0587\u0589\5d\63\2\u0588\u058a\7\u0080\2\2\u0589"+
		"\u0588\3\2\2\2\u0589\u058a\3\2\2\2\u058a\u058c\3\2\2\2\u058b\u0583\3\2"+
		"\2\2\u058b\u058c\3\2\2\2\u058c\u058d\3\2\2\2\u058d\u058f\7\r\2\2\u058e"+
		"\u0590\7\u0080\2\2\u058f\u058e\3\2\2\2\u058f\u0590\3\2\2\2\u0590\u0591"+
		"\3\2\2\2\u0591\u0593\5d\63\2\u0592\u0594\7\u0080\2\2\u0593\u0592\3\2\2"+
		"\2\u0593\u0594\3\2\2\2\u0594\u0595\3\2\2\2\u0595\u0596\7\13\2\2\u0596"+
		"\u00a5\3\2\2\2\u0597\u0599\7\31\2\2\u0598\u059a\7\u0080\2\2\u0599\u0598"+
		"\3\2\2\2\u0599\u059a\3\2\2\2\u059a\u059b\3\2\2\2\u059b\u059c\5\u00b6\\"+
		"\2\u059c\u00a7\3\2\2\2\u059d\u05a2\7]\2\2\u059e\u05a0\7\u0080\2\2\u059f"+
		"\u059e\3\2\2\2\u059f\u05a0\3\2\2\2\u05a0\u05a1\3\2\2\2\u05a1\u05a3\5\u00aa"+
		"V\2\u05a2\u059f\3\2\2\2\u05a3\u05a4\3\2\2\2\u05a4\u05a2\3\2\2\2\u05a4"+
		"\u05a5\3\2\2\2\u05a5\u05b4\3\2\2\2\u05a6\u05a8\7]\2\2\u05a7\u05a9\7\u0080"+
		"\2\2\u05a8\u05a7\3\2\2\2\u05a8\u05a9\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa"+
		"\u05af\5d\63\2\u05ab\u05ad\7\u0080\2\2\u05ac\u05ab\3\2\2\2\u05ac\u05ad"+
		"\3\2\2\2\u05ad\u05ae\3\2\2\2\u05ae\u05b0\5\u00aaV\2\u05af\u05ac\3\2\2"+
		"\2\u05b0\u05b1\3\2\2\2\u05b1\u05af\3\2\2\2\u05b1\u05b2\3\2\2\2\u05b2\u05b4"+
		"\3\2\2\2\u05b3\u059d\3\2\2\2\u05b3\u05a6\3\2\2\2\u05b4\u05bd\3\2\2\2\u05b5"+
		"\u05b7\7\u0080\2\2\u05b6\u05b5\3\2\2\2\u05b6\u05b7\3\2\2\2\u05b7\u05b8"+
		"\3\2\2\2\u05b8\u05ba\7^\2\2\u05b9\u05bb\7\u0080\2\2\u05ba\u05b9\3\2\2"+
		"\2\u05ba\u05bb\3\2\2\2\u05bb\u05bc\3\2\2\2\u05bc\u05be\5d\63\2\u05bd\u05b6"+
		"\3\2\2\2\u05bd\u05be\3\2\2\2\u05be\u05c0\3\2\2\2\u05bf\u05c1\7\u0080\2"+
		"\2\u05c0\u05bf\3\2\2\2\u05c0\u05c1\3\2\2\2\u05c1\u05c2\3\2\2\2\u05c2\u05c3"+
		"\7_\2\2\u05c3\u00a9\3\2\2\2\u05c4\u05c6\7`\2\2\u05c5\u05c7\7\u0080\2\2"+
		"\u05c6\u05c5\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05c8\3\2\2\2\u05c8\u05ca"+
		"\5d\63\2\u05c9\u05cb\7\u0080\2\2\u05ca\u05c9\3\2\2\2\u05ca\u05cb\3\2\2"+
		"\2\u05cb\u05cc\3\2\2\2\u05cc\u05ce\7a\2\2\u05cd\u05cf\7\u0080\2\2\u05ce"+
		"\u05cd\3\2\2\2\u05ce\u05cf\3\2\2\2\u05cf\u05d0\3\2\2\2\u05d0\u05d1\5d"+
		"\63\2\u05d1\u00ab\3\2\2\2\u05d2\u05d3\5\u00c0a\2\u05d3\u00ad\3\2\2\2\u05d4"+
		"\u05d7\5\u00ba^\2\u05d5\u05d7\5\u00b8]\2\u05d6\u05d4\3\2\2\2\u05d6\u05d5"+
		"\3\2\2\2\u05d7\u00af\3\2\2\2\u05d8\u05da\7\32\2\2\u05d9\u05db\7\u0080"+
		"\2\2\u05da\u05d9\3\2\2\2\u05da\u05db\3\2\2\2\u05db\u05fd\3\2\2\2\u05dc"+
		"\u05de\5\u00b6\\\2\u05dd\u05df\7\u0080\2\2\u05de\u05dd\3\2\2\2\u05de\u05df"+
		"\3\2\2\2\u05df\u05e0\3\2\2\2\u05e0\u05e2\7\f\2\2\u05e1\u05e3\7\u0080\2"+
		"\2\u05e2\u05e1\3\2\2\2\u05e2\u05e3\3\2\2\2\u05e3\u05e4\3\2\2\2\u05e4\u05e6"+
		"\5d\63\2\u05e5\u05e7\7\u0080\2\2\u05e6\u05e5\3\2\2\2\u05e6\u05e7\3\2\2"+
		"\2\u05e7\u05fa\3\2\2\2\u05e8\u05ea\7\4\2\2\u05e9\u05eb\7\u0080\2\2\u05ea"+
		"\u05e9\3\2\2\2\u05ea\u05eb\3\2\2\2\u05eb\u05ec\3\2\2\2\u05ec\u05ee\5\u00b6"+
		"\\\2\u05ed\u05ef\7\u0080\2\2\u05ee\u05ed\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef"+
		"\u05f0\3\2\2\2\u05f0\u05f2\7\f\2\2\u05f1\u05f3\7\u0080\2\2\u05f2\u05f1"+
		"\3\2\2\2\u05f2\u05f3\3\2\2\2\u05f3\u05f4\3\2\2\2\u05f4\u05f6\5d\63\2\u05f5"+
		"\u05f7\7\u0080\2\2\u05f6\u05f5\3\2\2\2\u05f6\u05f7\3\2\2\2\u05f7\u05f9"+
		"\3\2\2\2\u05f8\u05e8\3\2\2\2\u05f9\u05fc\3\2\2\2\u05fa\u05f8\3\2\2\2\u05fa"+
		"\u05fb\3\2\2\2\u05fb\u05fe\3\2\2\2\u05fc\u05fa\3\2\2\2\u05fd\u05dc\3\2"+
		"\2\2\u05fd\u05fe\3\2\2\2\u05fe\u05ff\3\2\2\2\u05ff\u0600\7\33\2\2\u0600"+
		"\u00b1\3\2\2\2\u0601\u0604\7\34\2\2\u0602\u0605\5\u00c0a\2\u0603\u0605"+
		"\7e\2\2\u0604\u0602\3\2\2\2\u0604\u0603\3\2\2\2\u0605\u00b3\3\2\2\2\u0606"+
		"\u060b\5\u0082B\2\u0607\u0609\7\u0080\2\2\u0608\u0607\3\2\2\2\u0608\u0609"+
		"\3\2\2\2\u0609\u060a\3\2\2\2\u060a\u060c\5\u00a6T\2\u060b\u0608\3\2\2"+
		"\2\u060c\u060d\3\2\2\2\u060d\u060b\3\2\2\2\u060d\u060e\3\2\2\2\u060e\u00b5"+
		"\3\2\2\2\u060f\u0610\5\u00bc_\2\u0610\u00b7\3\2\2\2\u0611\u0612\t\5\2"+
		"\2\u0612\u00b9\3\2\2\2\u0613\u0614\t\6\2\2\u0614\u00bb\3\2\2\2\u0615\u0618"+
		"\5\u00c0a\2\u0616\u0618\5\u00be`\2\u0617\u0615\3\2\2\2\u0617\u0616\3\2"+
		"\2\2\u0618\u00bd\3\2\2\2\u0619\u061a\t\7\2\2\u061a\u00bf\3\2\2\2\u061b"+
		"\u061c\t\b\2\2\u061c\u00c1\3\2\2\2\u061d\u061e\t\t\2\2\u061e\u00c3\3\2"+
		"\2\2\u061f\u0620\t\n\2\2\u0620\u00c5\3\2\2\2\u0621\u0622\t\13\2\2\u0622"+
		"\u00c7\3\2\2\2\u0124\u00c9\u00cd\u00d0\u00d3\u00db\u00df\u00e4\u00eb\u00f0"+
		"\u00f3\u00f7\u00fb\u00ff\u0105\u0109\u010e\u0113\u0117\u011a\u011c\u0120"+
		"\u0124\u0129\u012d\u0132\u0136\u013f\u0144\u0148\u014c\u0150\u0153\u0157"+
		"\u0161\u0168\u0175\u0179\u017f\u0186\u018b\u018f\u0195\u0199\u019f\u01a3"+
		"\u01a9\u01ad\u01b1\u01b5\u01b9\u01bd\u01c2\u01c9\u01cd\u01d2\u01d9\u01df"+
		"\u01e4\u01ea\u01f0\u01f5\u01f9\u01fe\u0201\u0204\u0207\u020e\u0214\u0217"+
		"\u021c\u021f\u0223\u0226\u022e\u0232\u0236\u023a\u023e\u0243\u0248\u024c"+
		"\u0251\u0254\u025d\u0266\u026b\u0278\u027b\u0283\u0287\u028c\u0291\u0295"+
		"\u029b\u029f\u02a3\u02a7\u02ab\u02b0\u02b6\u02bb\u02c2\u02c6\u02ca\u02cc"+
		"\u02d0\u02d2\u02d6\u02d8\u02de\u02e4\u02e8\u02eb\u02ee\u02f2\u02f8\u02fc"+
		"\u02ff\u0302\u0308\u030b\u030e\u0312\u0318\u031b\u031e\u0322\u0326\u032a"+
		"\u032c\u0330\u0332\u0335\u0339\u033b\u0341\u0345\u0349\u034d\u0350\u0355"+
		"\u035a\u035f\u0364\u036a\u036e\u0370\u0374\u0378\u037a\u037c\u038b\u0395"+
		"\u039f\u03a4\u03a8\u03af\u03b4\u03b9\u03bd\u03c1\u03c5\u03c8\u03ca\u03cf"+
		"\u03d3\u03d7\u03db\u03df\u03e3\u03e6\u03e8\u03ed\u03f1\u03f6\u03fb\u03ff"+
		"\u0408\u040a\u0410\u0414\u041b\u041f\u0423\u0426\u0432\u0435\u0443\u0447"+
		"\u044c\u0450\u0453\u045a\u045e\u0462\u0469\u046d\u0471\u0477\u047b\u047f"+
		"\u0485\u0489\u048d\u0493\u0497\u049b\u04a3\u04ab\u04b1\u04b5\u04b9\u04bd"+
		"\u04c1\u04c4\u04ca\u04cf\u04d4\u04d9\u04de\u04e3\u04e6\u04ea\u04ee\u04f4"+
		"\u04f9\u04fd\u0500\u050a\u050e\u0512\u0514\u0518\u051c\u0520\u0524\u0527"+
		"\u052f\u0533\u0537\u053b\u053f\u0543\u0547\u054a\u055a\u055f\u0563\u0567"+
		"\u056a\u056d\u0573\u0577\u057b\u057d\u0581\u0585\u0589\u058b\u058f\u0593"+
		"\u0599\u059f\u05a4\u05a8\u05ac\u05b1\u05b3\u05b6\u05ba\u05bd\u05c0\u05c6"+
		"\u05ca\u05ce\u05d6\u05da\u05de\u05e2\u05e6\u05ea\u05ee\u05f2\u05f6\u05fa"+
		"\u05fd\u0604\u0608\u060d\u0617";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}