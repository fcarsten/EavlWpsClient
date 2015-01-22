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
		RULE_expressionList = 0, RULE_expression = 1, RULE_structure = 2, RULE_list = 3, 
		RULE_nameValuePair = 4, RULE_variableName = 5, RULE_vector = 6, RULE_boolVector = 7, 
		RULE_strVector = 8, RULE_numberVector = 9, RULE_constant = 10, RULE_bool = 11, 
		RULE_str = 12, RULE_number = 13, RULE_explicit_int = 14, RULE_unary_operator = 15, 
		RULE_unsigned_number = 16;
	public static final String[] ruleNames = {
		"expressionList", "expression", "structure", "list", "nameValuePair", 
		"variableName", "vector", "boolVector", "strVector", "numberVector", "constant", 
		"bool", "str", "number", "explicit_int", "unary_operator", "unsigned_number"
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
	public static class ExpressionListContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); expression();
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(35); match(T__2);
				setState(36); expression();
				}
				}
				setState(41);
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
		enterRule(_localctx, 2, RULE_expression);
		try {
			setState(46);
			switch (_input.LA(1)) {
			case T__8:
			case QUOTED_VARIABLE_NAME:
			case WS:
			case VariableLetter:
				enterOuterAlt(_localctx, 1);
				{
				setState(42); nameValuePair();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(43); structure();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(44); list();
				}
				break;
			case VECTOR_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(45); vector();
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

	public static class StructureContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
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
		enterRule(_localctx, 4, RULE_structure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(T__5);
			setState(49); match(T__7);
			setState(50); expressionList();
			setState(51); match(T__6);
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
			setState(53); match(T__11);
			setState(54); match(T__7);
			setState(55); expression();
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(56); match(T__2);
				setState(57); expression();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63); match(T__6);
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
			setState(90);
			switch (_input.LA(1)) {
			case QUOTED_VARIABLE_NAME:
			case WS:
			case VariableLetter:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(65); match(WS);
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71); ((NameValuePairContext)_localctx).name = variableName();
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(72); match(WS);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78); match(T__10);
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(79); match(WS);
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(87);
				switch (_input.LA(1)) {
				case T__11:
				case T__8:
				case T__5:
				case VECTOR_START:
				case QUOTED_VARIABLE_NAME:
				case WS:
				case VariableLetter:
					{
					setState(85); expression();
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
					setState(86); constant();
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
				setState(89); match(T__8);
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
		enterRule(_localctx, 10, RULE_variableName);
		int _la;
		try {
			setState(98);
			switch (_input.LA(1)) {
			case VariableLetter:
				enterOuterAlt(_localctx, 1);
				{
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92); match(VariableLetter);
					}
					}
					setState(95); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VariableLetter );
				}
				break;
			case QUOTED_VARIABLE_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(97); match(QUOTED_VARIABLE_NAME);
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
		enterRule(_localctx, 12, RULE_vector);
		try {
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100); boolVector();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101); strVector();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(102); numberVector();
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
		enterRule(_localctx, 14, RULE_boolVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); match(VECTOR_START);
			setState(106); bool();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(107); match(T__2);
				setState(108); bool();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114); match(T__6);
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
		enterRule(_localctx, 16, RULE_strVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(VECTOR_START);
			setState(117); str();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(118); match(T__2);
				setState(119); str();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125); match(T__6);
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
		enterRule(_localctx, 18, RULE_numberVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(VECTOR_START);
			setState(128); number();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(129); match(T__2);
				setState(130); number();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136); match(T__6);
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
		enterRule(_localctx, 20, RULE_constant);
		try {
			setState(141);
			switch (_input.LA(1)) {
			case T__14:
			case T__4:
			case T__1:
			case UNSIGNED_INT:
			case UNSIGNED_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(138); number();
				}
				break;
			case T__13:
			case T__12:
			case T__9:
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(139); bool();
				}
				break;
			case QUOTED_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(140); str();
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
		enterRule(_localctx, 22, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
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
		enterRule(_localctx, 24, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(QUOTED_STRING);
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
		enterRule(_localctx, 26, RULE_number);
		int _la;
		try {
			setState(152);
			switch (_input.LA(1)) {
			case T__4:
			case T__1:
			case UNSIGNED_INT:
			case UNSIGNED_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				_la = _input.LA(1);
				if (_la==T__4 || _la==T__1) {
					{
					setState(147); unary_operator();
					}
				}

				setState(150); unsigned_number();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(151); match(T__14);
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
		enterRule(_localctx, 28, RULE_explicit_int);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); match(T__3);
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
		enterRule(_localctx, 30, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
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
		enterRule(_localctx, 32, RULE_unsigned_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00a3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\3\5\3\5\3\6"+
		"\7\6E\n\6\f\6\16\6H\13\6\3\6\3\6\7\6L\n\6\f\6\16\6O\13\6\3\6\3\6\7\6S"+
		"\n\6\f\6\16\6V\13\6\3\6\3\6\5\6Z\n\6\3\6\5\6]\n\6\3\7\6\7`\n\7\r\7\16"+
		"\7a\3\7\5\7e\n\7\3\b\3\b\3\b\5\bj\n\b\3\t\3\t\3\t\3\t\7\tp\n\t\f\t\16"+
		"\ts\13\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n{\n\n\f\n\16\n~\13\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\7\13\u0086\n\13\f\13\16\13\u0089\13\13\3\13\3\13\3\f\3"+
		"\f\3\f\5\f\u0090\n\f\3\r\3\r\3\16\3\16\3\17\5\17\u0097\n\17\3\17\3\17"+
		"\5\17\u009b\n\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"\2\5\5\2\4\5\b\b\21\21\4\2\r\r\20\20\4\2"+
		"\25\25\27\27\u00a6\2$\3\2\2\2\4\60\3\2\2\2\6\62\3\2\2\2\b\67\3\2\2\2\n"+
		"\\\3\2\2\2\fd\3\2\2\2\16i\3\2\2\2\20k\3\2\2\2\22v\3\2\2\2\24\u0081\3\2"+
		"\2\2\26\u008f\3\2\2\2\30\u0091\3\2\2\2\32\u0093\3\2\2\2\34\u009a\3\2\2"+
		"\2\36\u009c\3\2\2\2 \u009e\3\2\2\2\"\u00a0\3\2\2\2$)\5\4\3\2%&\7\17\2"+
		"\2&(\5\4\3\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+)\3"+
		"\2\2\2,\61\5\n\6\2-\61\5\6\4\2.\61\5\b\5\2/\61\5\16\b\2\60,\3\2\2\2\60"+
		"-\3\2\2\2\60.\3\2\2\2\60/\3\2\2\2\61\5\3\2\2\2\62\63\7\f\2\2\63\64\7\n"+
		"\2\2\64\65\5\2\2\2\65\66\7\13\2\2\66\7\3\2\2\2\678\7\6\2\289\7\n\2\29"+
		">\5\4\3\2:;\7\17\2\2;=\5\4\3\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2"+
		"?A\3\2\2\2@>\3\2\2\2AB\7\13\2\2B\t\3\2\2\2CE\7\30\2\2DC\3\2\2\2EH\3\2"+
		"\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IM\5\f\7\2JL\7\30\2\2KJ\3"+
		"\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PT\7\7\2\2QS\7"+
		"\30\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UY\3\2\2\2VT\3\2\2\2WZ"+
		"\5\4\3\2XZ\5\26\f\2YW\3\2\2\2YX\3\2\2\2Z]\3\2\2\2[]\7\t\2\2\\F\3\2\2\2"+
		"\\[\3\2\2\2]\13\3\2\2\2^`\7\31\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2"+
		"\2\2be\3\2\2\2ce\7\24\2\2d_\3\2\2\2dc\3\2\2\2e\r\3\2\2\2fj\5\20\t\2gj"+
		"\5\22\n\2hj\5\24\13\2if\3\2\2\2ig\3\2\2\2ih\3\2\2\2j\17\3\2\2\2kl\7\22"+
		"\2\2lq\5\30\r\2mn\7\17\2\2np\5\30\r\2om\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr"+
		"\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\13\2\2u\21\3\2\2\2vw\7\22\2\2w|\5\32"+
		"\16\2xy\7\17\2\2y{\5\32\16\2zx\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}"+
		"\177\3\2\2\2~|\3\2\2\2\177\u0080\7\13\2\2\u0080\23\3\2\2\2\u0081\u0082"+
		"\7\22\2\2\u0082\u0087\5\34\17\2\u0083\u0084\7\17\2\2\u0084\u0086\5\34"+
		"\17\2\u0085\u0083\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\13"+
		"\2\2\u008b\25\3\2\2\2\u008c\u0090\5\34\17\2\u008d\u0090\5\30\r\2\u008e"+
		"\u0090\5\32\16\2\u008f\u008c\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3"+
		"\2\2\2\u0090\27\3\2\2\2\u0091\u0092\t\2\2\2\u0092\31\3\2\2\2\u0093\u0094"+
		"\7\23\2\2\u0094\33\3\2\2\2\u0095\u0097\5 \21\2\u0096\u0095\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b\5\"\22\2\u0099\u009b\7"+
		"\3\2\2\u009a\u0096\3\2\2\2\u009a\u0099\3\2\2\2\u009b\35\3\2\2\2\u009c"+
		"\u009d\7\16\2\2\u009d\37\3\2\2\2\u009e\u009f\t\3\2\2\u009f!\3\2\2\2\u00a0"+
		"\u00a1\t\4\2\2\u00a1#\3\2\2\2\23)\60>FMTY\\adiq|\u0087\u008f\u0096\u009a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}