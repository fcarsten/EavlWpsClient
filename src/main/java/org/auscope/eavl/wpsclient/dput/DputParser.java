// Generated from Dput.g4 by ANTLR 4.3

package org.auscope.eavl.wpsclient.dput;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DputParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, VECTOR_START=16, 
		QUOTED_STRING=17, QUOTED_VARIABLE_NAME=18, UNSIGNED_INT=19, DIGIT=20, 
		UNSIGNED_FLOAT=21, WS=22, VariableLetter=23;
	public static final String[] tokenNames = {
		"<INVALID>", "'NA'", "'T'", "'FALSE'", "'list'", "'='", "'F'", "'NULL'", 
		"'('", "')'", "'structure'", "'+'", "'L'", "','", "'-'", "'TRUE'", "VECTOR_START", 
		"QUOTED_STRING", "QUOTED_VARIABLE_NAME", "UNSIGNED_INT", "DIGIT", "UNSIGNED_FLOAT", 
		"WS", "VariableLetter"
	};
	public static final int
		RULE_structure = 0, RULE_vectorStructure = 1, RULE_listStructure = 2, 
		RULE_list = 3, RULE_nameValuePair = 4, RULE_expression = 5, RULE_variableName = 6, 
		RULE_vector = 7, RULE_boolVector = 8, RULE_strVector = 9, RULE_numberVector = 10, 
		RULE_constant = 11, RULE_bool = 12, RULE_str = 13, RULE_number = 14, RULE_explicit_int = 15, 
		RULE_unary_operator = 16, RULE_unsigned_number = 17;
	public static final String[] ruleNames = {
		"structure", "vectorStructure", "listStructure", "list", "nameValuePair", 
		"expression", "variableName", "vector", "boolVector", "strVector", "numberVector", 
		"constant", "bool", "str", "number", "explicit_int", "unary_operator", 
		"unsigned_number"
	};

	@Override
	public String getGrammarFileName() { return "Dput.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DputParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StructureContext extends ParserRuleContext {
		public ListStructureContext listStructure() {
			return getRuleContext(ListStructureContext.class,0);
		}
		public VectorStructureContext vectorStructure() {
			return getRuleContext(VectorStructureContext.class,0);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_structure);
		try {
			setState(38);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36); vectorStructure();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37); listStructure();
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

	public static class VectorStructureContext extends ParserRuleContext {
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public List<NameValuePairContext> nameValuePair() {
			return getRuleContexts(NameValuePairContext.class);
		}
		public NameValuePairContext nameValuePair(int i) {
			return getRuleContext(NameValuePairContext.class,i);
		}
		public VectorStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vectorStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterVectorStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitVectorStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitVectorStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorStructureContext vectorStructure() throws RecognitionException {
		VectorStructureContext _localctx = new VectorStructureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_vectorStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); match(T__5);
			setState(41); match(T__7);
			setState(42); vector();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(43); match(T__2);
				setState(44); nameValuePair();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50); match(T__6);
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

	public static class ListStructureContext extends ParserRuleContext {
		public List<NameValuePairContext> nameValuePair() {
			return getRuleContexts(NameValuePairContext.class);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public NameValuePairContext nameValuePair(int i) {
			return getRuleContext(NameValuePairContext.class,i);
		}
		public ListStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterListStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitListStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitListStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListStructureContext listStructure() throws RecognitionException {
		ListStructureContext _localctx = new ListStructureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_listStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); match(T__5);
			setState(53); match(T__7);
			setState(54); list();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(55); match(T__2);
				setState(56); nameValuePair();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62); match(T__6);
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

	public static class ListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(T__11);
			setState(65); match(T__7);
			setState(66); expression();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(67); match(T__2);
				setState(68); expression();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74); match(T__6);
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

	public static class NameValuePairContext extends ParserRuleContext {
		public VariableNameContext name;
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode WS(int i) {
			return getToken(DputParser.WS, i);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(DputParser.WS); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NameValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterNameValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitNameValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitNameValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameValuePairContext nameValuePair() throws RecognitionException {
		NameValuePairContext _localctx = new NameValuePairContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nameValuePair);
		int _la;
		try {
			int _alt;
			setState(101);
			switch (_input.LA(1)) {
			case QUOTED_VARIABLE_NAME:
			case WS:
			case VariableLetter:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(76); match(WS);
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82); ((NameValuePairContext)_localctx).name = variableName();
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(83); match(WS);
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(89); match(T__10);
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(90); match(WS);
						}
						} 
					}
					setState(95);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(98);
				switch (_input.LA(1)) {
				case T__11:
				case T__8:
				case T__5:
				case VECTOR_START:
				case QUOTED_VARIABLE_NAME:
				case WS:
				case VariableLetter:
					{
					setState(96); expression();
					}
					break;
				case T__14:
				case T__13:
				case T__12:
				case T__9:
				case T__4:
				case T__1:
				case T__0:
				case QUOTED_STRING:
				case UNSIGNED_INT:
				case UNSIGNED_FLOAT:
					{
					setState(97); constant();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(100); match(T__8);
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

	public static class ExpressionContext extends ParserRuleContext {
		public NameValuePairContext nameValuePair() {
			return getRuleContext(NameValuePairContext.class,0);
		}
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		try {
			setState(107);
			switch (_input.LA(1)) {
			case T__8:
			case QUOTED_VARIABLE_NAME:
			case WS:
			case VariableLetter:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); nameValuePair();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(104); structure();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(105); list();
				}
				break;
			case VECTOR_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(106); vector();
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

	public static class VariableNameContext extends ParserRuleContext {
		public TerminalNode QUOTED_VARIABLE_NAME() { return getToken(DputParser.QUOTED_VARIABLE_NAME, 0); }
		public TerminalNode VariableLetter(int i) {
			return getToken(DputParser.VariableLetter, i);
		}
		public List<TerminalNode> VariableLetter() { return getTokens(DputParser.VariableLetter); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableName);
		int _la;
		try {
			setState(115);
			switch (_input.LA(1)) {
			case VariableLetter:
				enterOuterAlt(_localctx, 1);
				{
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(109); match(VariableLetter);
					}
					}
					setState(112); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VariableLetter );
				}
				break;
			case QUOTED_VARIABLE_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(114); match(QUOTED_VARIABLE_NAME);
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

	public static class VectorContext extends ParserRuleContext {
		public BoolVectorContext boolVector() {
			return getRuleContext(BoolVectorContext.class,0);
		}
		public NumberVectorContext numberVector() {
			return getRuleContext(NumberVectorContext.class,0);
		}
		public StrVectorContext strVector() {
			return getRuleContext(StrVectorContext.class,0);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_vector);
		try {
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117); boolVector();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118); strVector();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(119); numberVector();
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

	public static class BoolVectorContext extends ParserRuleContext {
		public TerminalNode VECTOR_START() { return getToken(DputParser.VECTOR_START, 0); }
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolVectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolVector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterBoolVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitBoolVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitBoolVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolVectorContext boolVector() throws RecognitionException {
		BoolVectorContext _localctx = new BoolVectorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_boolVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(VECTOR_START);
			setState(123); bool();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(124); match(T__2);
				setState(125); bool();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131); match(T__6);
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

	public static class StrVectorContext extends ParserRuleContext {
		public List<StrContext> str() {
			return getRuleContexts(StrContext.class);
		}
		public TerminalNode VECTOR_START() { return getToken(DputParser.VECTOR_START, 0); }
		public StrContext str(int i) {
			return getRuleContext(StrContext.class,i);
		}
		public StrVectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strVector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterStrVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitStrVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitStrVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrVectorContext strVector() throws RecognitionException {
		StrVectorContext _localctx = new StrVectorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_strVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(VECTOR_START);
			setState(134); str();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(135); match(T__2);
				setState(136); str();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142); match(T__6);
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

	public static class NumberVectorContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public TerminalNode VECTOR_START() { return getToken(DputParser.VECTOR_START, 0); }
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public NumberVectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberVector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterNumberVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitNumberVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitNumberVector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberVectorContext numberVector() throws RecognitionException {
		NumberVectorContext _localctx = new NumberVectorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numberVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); match(VECTOR_START);
			setState(145); number();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(146); match(T__2);
				setState(147); number();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153); match(T__6);
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

	public static class ConstantContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constant);
		try {
			setState(158);
			switch (_input.LA(1)) {
			case T__14:
			case T__4:
			case T__1:
			case UNSIGNED_INT:
			case UNSIGNED_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(155); number();
				}
				break;
			case T__13:
			case T__12:
			case T__9:
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(156); bool();
				}
				break;
			case QUOTED_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(157); str();
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

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__12) | (1L << T__9) | (1L << T__0))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class StrContext extends ParserRuleContext {
		public TerminalNode QUOTED_STRING() { return getToken(DputParser.QUOTED_STRING, 0); }
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitStr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(QUOTED_STRING);
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

	public static class NumberContext extends ParserRuleContext {
		public Unsigned_numberContext unsigned_number() {
			return getRuleContext(Unsigned_numberContext.class,0);
		}
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_number);
		int _la;
		try {
			setState(169);
			switch (_input.LA(1)) {
			case T__4:
			case T__1:
			case UNSIGNED_INT:
			case UNSIGNED_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				_la = _input.LA(1);
				if (_la==T__4 || _la==T__1) {
					{
					setState(164); unary_operator();
					}
				}

				setState(167); unsigned_number();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(168); match(T__14);
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

	public static class Explicit_intContext extends ParserRuleContext {
		public Explicit_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicit_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterExplicit_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitExplicit_int(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitExplicit_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Explicit_intContext explicit_int() throws RecognitionException {
		Explicit_intContext _localctx = new Explicit_intContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_explicit_int);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); match(T__3);
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

	public static class Unary_operatorContext extends ParserRuleContext {
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Unsigned_numberContext extends ParserRuleContext {
		public TerminalNode UNSIGNED_FLOAT() { return getToken(DputParser.UNSIGNED_FLOAT, 0); }
		public TerminalNode UNSIGNED_INT() { return getToken(DputParser.UNSIGNED_INT, 0); }
		public Unsigned_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterUnsigned_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitUnsigned_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitUnsigned_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unsigned_numberContext unsigned_number() throws RecognitionException {
		Unsigned_numberContext _localctx = new Unsigned_numberContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unsigned_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_la = _input.LA(1);
			if ( !(_la==UNSIGNED_INT || _la==UNSIGNED_FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00b4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\5\2)\n\2\3\3\3\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63"+
		"\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\3\6\7\6P\n\6\f\6\16\6"+
		"S\13\6\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6"+
		"\3\6\3\6\5\6e\n\6\3\6\5\6h\n\6\3\7\3\7\3\7\3\7\5\7n\n\7\3\b\6\bq\n\b\r"+
		"\b\16\br\3\b\5\bv\n\b\3\t\3\t\3\t\5\t{\n\t\3\n\3\n\3\n\3\n\7\n\u0081\n"+
		"\n\f\n\16\n\u0084\13\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u008c\n\13\f\13"+
		"\16\13\u008f\13\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a"+
		"\13\f\3\f\3\f\3\r\3\r\3\r\5\r\u00a1\n\r\3\16\3\16\3\17\3\17\3\20\5\20"+
		"\u00a8\n\20\3\20\3\20\5\20\u00ac\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\5\2\4\5\b\b"+
		"\21\21\4\2\r\r\20\20\4\2\25\25\27\27\u00b8\2(\3\2\2\2\4*\3\2\2\2\6\66"+
		"\3\2\2\2\bB\3\2\2\2\ng\3\2\2\2\fm\3\2\2\2\16u\3\2\2\2\20z\3\2\2\2\22|"+
		"\3\2\2\2\24\u0087\3\2\2\2\26\u0092\3\2\2\2\30\u00a0\3\2\2\2\32\u00a2\3"+
		"\2\2\2\34\u00a4\3\2\2\2\36\u00ab\3\2\2\2 \u00ad\3\2\2\2\"\u00af\3\2\2"+
		"\2$\u00b1\3\2\2\2&)\5\4\3\2\')\5\6\4\2(&\3\2\2\2(\'\3\2\2\2)\3\3\2\2\2"+
		"*+\7\f\2\2+,\7\n\2\2,\61\5\20\t\2-.\7\17\2\2.\60\5\n\6\2/-\3\2\2\2\60"+
		"\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65"+
		"\7\13\2\2\65\5\3\2\2\2\66\67\7\f\2\2\678\7\n\2\28=\5\b\5\29:\7\17\2\2"+
		":<\5\n\6\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2"+
		"@A\7\13\2\2A\7\3\2\2\2BC\7\6\2\2CD\7\n\2\2DI\5\f\7\2EF\7\17\2\2FH\5\f"+
		"\7\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\13"+
		"\2\2M\t\3\2\2\2NP\7\30\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3"+
		"\2\2\2SQ\3\2\2\2TX\5\16\b\2UW\7\30\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2X"+
		"Y\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[_\7\7\2\2\\^\7\30\2\2]\\\3\2\2\2^a\3\2\2"+
		"\2_]\3\2\2\2_`\3\2\2\2`d\3\2\2\2a_\3\2\2\2be\5\f\7\2ce\5\30\r\2db\3\2"+
		"\2\2dc\3\2\2\2eh\3\2\2\2fh\7\t\2\2gQ\3\2\2\2gf\3\2\2\2h\13\3\2\2\2in\5"+
		"\n\6\2jn\5\2\2\2kn\5\b\5\2ln\5\20\t\2mi\3\2\2\2mj\3\2\2\2mk\3\2\2\2ml"+
		"\3\2\2\2n\r\3\2\2\2oq\7\31\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2"+
		"sv\3\2\2\2tv\7\24\2\2up\3\2\2\2ut\3\2\2\2v\17\3\2\2\2w{\5\22\n\2x{\5\24"+
		"\13\2y{\5\26\f\2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{\21\3\2\2\2|}\7\22\2\2"+
		"}\u0082\5\32\16\2~\177\7\17\2\2\177\u0081\5\32\16\2\u0080~\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\13\2\2\u0086\23\3\2\2\2\u0087\u0088"+
		"\7\22\2\2\u0088\u008d\5\34\17\2\u0089\u008a\7\17\2\2\u008a\u008c\5\34"+
		"\17\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\13"+
		"\2\2\u0091\25\3\2\2\2\u0092\u0093\7\22\2\2\u0093\u0098\5\36\20\2\u0094"+
		"\u0095\7\17\2\2\u0095\u0097\5\36\20\2\u0096\u0094\3\2\2\2\u0097\u009a"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\7\13\2\2\u009c\27\3\2\2\2\u009d\u00a1\5\36"+
		"\20\2\u009e\u00a1\5\32\16\2\u009f\u00a1\5\34\17\2\u00a0\u009d\3\2\2\2"+
		"\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\31\3\2\2\2\u00a2\u00a3"+
		"\t\2\2\2\u00a3\33\3\2\2\2\u00a4\u00a5\7\23\2\2\u00a5\35\3\2\2\2\u00a6"+
		"\u00a8\5\"\22\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3"+
		"\2\2\2\u00a9\u00ac\5$\23\2\u00aa\u00ac\7\3\2\2\u00ab\u00a7\3\2\2\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\37\3\2\2\2\u00ad\u00ae\7\16\2\2\u00ae!\3\2\2\2\u00af"+
		"\u00b0\t\3\2\2\u00b0#\3\2\2\2\u00b1\u00b2\t\4\2\2\u00b2%\3\2\2\2\25(\61"+
		"=IQX_dgmruz\u0082\u008d\u0098\u00a0\u00a7\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}