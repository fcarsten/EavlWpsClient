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
		QUOTED_STRING=17, QUOTED_VARIABLE_NAME=18, UNSIGNED_INT=19, UNSIGNED_FLOAT=20, 
		VariableLetters=21, WS=22;
	public static final String[] tokenNames = {
		"<INVALID>", "'NA'", "'T'", "'FALSE'", "'list'", "'='", "'F'", "'NULL'", 
		"'('", "')'", "'structure'", "'+'", "'L'", "','", "'-'", "'TRUE'", "VECTOR_START", 
		"QUOTED_STRING", "QUOTED_VARIABLE_NAME", "UNSIGNED_INT", "UNSIGNED_FLOAT", 
		"VariableLetters", "WS"
	};
	public static final int
		RULE_structure = 0, RULE_matrix = 1, RULE_boolMatrix = 2, RULE_numberMatrix = 3, 
		RULE_stringMatrix = 4, RULE_listStructure = 5, RULE_list = 6, RULE_nameValuePair = 7, 
		RULE_expression = 8, RULE_variableName = 9, RULE_vector = 10, RULE_boolVector = 11, 
		RULE_strVector = 12, RULE_numberVector = 13, RULE_constant = 14, RULE_bool = 15, 
		RULE_str = 16, RULE_number = 17, RULE_explicit_int = 18, RULE_unary_operator = 19, 
		RULE_unsigned_number = 20;
	public static final String[] ruleNames = {
		"structure", "matrix", "boolMatrix", "numberMatrix", "stringMatrix", "listStructure", 
		"list", "nameValuePair", "expression", "variableName", "vector", "boolVector", 
		"strVector", "numberVector", "constant", "bool", "str", "number", "explicit_int", 
		"unary_operator", "unsigned_number"
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
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public ListStructureContext listStructure() {
			return getRuleContext(ListStructureContext.class,0);
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
			setState(44);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42); matrix();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43); listStructure();
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

	public static class MatrixContext extends ParserRuleContext {
		public StringMatrixContext stringMatrix() {
			return getRuleContext(StringMatrixContext.class,0);
		}
		public BoolMatrixContext boolMatrix() {
			return getRuleContext(BoolMatrixContext.class,0);
		}
		public NumberMatrixContext numberMatrix() {
			return getRuleContext(NumberMatrixContext.class,0);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_matrix);
		try {
			setState(49);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46); boolMatrix();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47); numberMatrix();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48); stringMatrix();
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

	public static class BoolMatrixContext extends ParserRuleContext {
		public List<NameValuePairContext> nameValuePair() {
			return getRuleContexts(NameValuePairContext.class);
		}
		public BoolVectorContext boolVector() {
			return getRuleContext(BoolVectorContext.class,0);
		}
		public NameValuePairContext nameValuePair(int i) {
			return getRuleContext(NameValuePairContext.class,i);
		}
		public BoolMatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolMatrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterBoolMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitBoolMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitBoolMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolMatrixContext boolMatrix() throws RecognitionException {
		BoolMatrixContext _localctx = new BoolMatrixContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_boolMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(T__5);
			setState(52); match(T__7);
			setState(53); boolVector();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(54); match(T__2);
				setState(55); nameValuePair();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61); match(T__6);
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

	public static class NumberMatrixContext extends ParserRuleContext {
		public List<NameValuePairContext> nameValuePair() {
			return getRuleContexts(NameValuePairContext.class);
		}
		public NumberVectorContext numberVector() {
			return getRuleContext(NumberVectorContext.class,0);
		}
		public NameValuePairContext nameValuePair(int i) {
			return getRuleContext(NameValuePairContext.class,i);
		}
		public NumberMatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberMatrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterNumberMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitNumberMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitNumberMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberMatrixContext numberMatrix() throws RecognitionException {
		NumberMatrixContext _localctx = new NumberMatrixContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numberMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); match(T__5);
			setState(64); match(T__7);
			setState(65); numberVector();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(66); match(T__2);
				setState(67); nameValuePair();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73); match(T__6);
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

	public static class StringMatrixContext extends ParserRuleContext {
		public List<NameValuePairContext> nameValuePair() {
			return getRuleContexts(NameValuePairContext.class);
		}
		public NameValuePairContext nameValuePair(int i) {
			return getRuleContext(NameValuePairContext.class,i);
		}
		public StrVectorContext strVector() {
			return getRuleContext(StrVectorContext.class,0);
		}
		public StringMatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringMatrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).enterStringMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DputListener ) ((DputListener)listener).exitStringMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DputVisitor ) return ((DputVisitor<? extends T>)visitor).visitStringMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringMatrixContext stringMatrix() throws RecognitionException {
		StringMatrixContext _localctx = new StringMatrixContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stringMatrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); match(T__5);
			setState(76); match(T__7);
			setState(77); strVector();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(78); match(T__2);
				setState(79); nameValuePair();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85); match(T__6);
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
		enterRule(_localctx, 10, RULE_listStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); match(T__5);
			setState(88); match(T__7);
			setState(89); list();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(90); match(T__2);
				setState(91); nameValuePair();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97); match(T__6);
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
		enterRule(_localctx, 12, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(T__11);
			setState(100); match(T__7);
			setState(101); expression();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(102); match(T__2);
				setState(103); expression();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109); match(T__6);
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
		enterRule(_localctx, 14, RULE_nameValuePair);
		int _la;
		try {
			int _alt;
			setState(136);
			switch (_input.LA(1)) {
			case QUOTED_VARIABLE_NAME:
			case VariableLetters:
			case WS:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(111); match(WS);
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(117); ((NameValuePairContext)_localctx).name = variableName();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(118); match(WS);
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124); match(T__10);
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(125); match(WS);
						}
						} 
					}
					setState(130);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(133);
				switch (_input.LA(1)) {
				case T__11:
				case T__8:
				case T__5:
				case VECTOR_START:
				case QUOTED_VARIABLE_NAME:
				case VariableLetters:
				case WS:
					{
					setState(131); expression();
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
					setState(132); constant();
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
				setState(135); match(T__8);
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
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(142);
			switch (_input.LA(1)) {
			case T__8:
			case QUOTED_VARIABLE_NAME:
			case VariableLetters:
			case WS:
				enterOuterAlt(_localctx, 1);
				{
				setState(138); nameValuePair();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(139); structure();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(140); list();
				}
				break;
			case VECTOR_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(141); vector();
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
		public TerminalNode VariableLetters() { return getToken(DputParser.VariableLetters, 0); }
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
		enterRule(_localctx, 18, RULE_variableName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==QUOTED_VARIABLE_NAME || _la==VariableLetters) ) {
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
		enterRule(_localctx, 20, RULE_vector);
		try {
			setState(149);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146); boolVector();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147); strVector();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148); numberVector();
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
		enterRule(_localctx, 22, RULE_boolVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(VECTOR_START);
			setState(152); bool();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(153); match(T__2);
				setState(154); bool();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160); match(T__6);
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
		enterRule(_localctx, 24, RULE_strVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(VECTOR_START);
			setState(163); str();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(164); match(T__2);
				setState(165); str();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171); match(T__6);
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
		enterRule(_localctx, 26, RULE_numberVector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(VECTOR_START);
			setState(174); number();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(175); match(T__2);
				setState(176); number();
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182); match(T__6);
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
		enterRule(_localctx, 28, RULE_constant);
		try {
			setState(187);
			switch (_input.LA(1)) {
			case T__14:
			case T__4:
			case T__1:
			case UNSIGNED_INT:
			case UNSIGNED_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(184); number();
				}
				break;
			case T__13:
			case T__12:
			case T__9:
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(185); bool();
				}
				break;
			case QUOTED_STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(186); str();
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
		enterRule(_localctx, 30, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
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
		enterRule(_localctx, 32, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(QUOTED_STRING);
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
		enterRule(_localctx, 34, RULE_number);
		int _la;
		try {
			setState(198);
			switch (_input.LA(1)) {
			case T__4:
			case T__1:
			case UNSIGNED_INT:
			case UNSIGNED_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				_la = _input.LA(1);
				if (_la==T__4 || _la==T__1) {
					{
					setState(193); unary_operator();
					}
				}

				setState(196); unsigned_number();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(197); match(T__14);
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
		enterRule(_localctx, 36, RULE_explicit_int);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); match(T__3);
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
		enterRule(_localctx, 38, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
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
		enterRule(_localctx, 40, RULE_unsigned_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u00d1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\5\2/\n\2\3\3\3\3\3\3"+
		"\5\3\64\n\3\3\4\3\4\3\4\3\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\7\5G\n\5\f\5\16\5J\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7\6"+
		"S\n\6\f\6\16\6V\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7_\n\7\f\7\16\7b\13"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\b\3\b\3\t\7\t"+
		"s\n\t\f\t\16\tv\13\t\3\t\3\t\7\tz\n\t\f\t\16\t}\13\t\3\t\3\t\7\t\u0081"+
		"\n\t\f\t\16\t\u0084\13\t\3\t\3\t\5\t\u0088\n\t\3\t\5\t\u008b\n\t\3\n\3"+
		"\n\3\n\3\n\5\n\u0091\n\n\3\13\3\13\3\f\3\f\3\f\5\f\u0098\n\f\3\r\3\r\3"+
		"\r\3\r\7\r\u009e\n\r\f\r\16\r\u00a1\13\r\3\r\3\r\3\16\3\16\3\16\3\16\7"+
		"\16\u00a9\n\16\f\16\16\16\u00ac\13\16\3\16\3\16\3\17\3\17\3\17\3\17\7"+
		"\17\u00b4\n\17\f\17\16\17\u00b7\13\17\3\17\3\17\3\20\3\20\3\20\5\20\u00be"+
		"\n\20\3\21\3\21\3\22\3\22\3\23\5\23\u00c5\n\23\3\23\3\23\5\23\u00c9\n"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*\2\6\4\2\24\24\27\27\5\2\4\5\b\b\21\21\4\2\r\r\20"+
		"\20\3\2\25\26\u00d4\2.\3\2\2\2\4\63\3\2\2\2\6\65\3\2\2\2\bA\3\2\2\2\n"+
		"M\3\2\2\2\fY\3\2\2\2\16e\3\2\2\2\20\u008a\3\2\2\2\22\u0090\3\2\2\2\24"+
		"\u0092\3\2\2\2\26\u0097\3\2\2\2\30\u0099\3\2\2\2\32\u00a4\3\2\2\2\34\u00af"+
		"\3\2\2\2\36\u00bd\3\2\2\2 \u00bf\3\2\2\2\"\u00c1\3\2\2\2$\u00c8\3\2\2"+
		"\2&\u00ca\3\2\2\2(\u00cc\3\2\2\2*\u00ce\3\2\2\2,/\5\4\3\2-/\5\f\7\2.,"+
		"\3\2\2\2.-\3\2\2\2/\3\3\2\2\2\60\64\5\6\4\2\61\64\5\b\5\2\62\64\5\n\6"+
		"\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\5\3\2\2\2\65\66\7\f\2"+
		"\2\66\67\7\n\2\2\67<\5\30\r\289\7\17\2\29;\5\20\t\2:8\3\2\2\2;>\3\2\2"+
		"\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\13\2\2@\7\3\2\2\2AB\7\f"+
		"\2\2BC\7\n\2\2CH\5\34\17\2DE\7\17\2\2EG\5\20\t\2FD\3\2\2\2GJ\3\2\2\2H"+
		"F\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\13\2\2L\t\3\2\2\2MN\7\f\2"+
		"\2NO\7\n\2\2OT\5\32\16\2PQ\7\17\2\2QS\5\20\t\2RP\3\2\2\2SV\3\2\2\2TR\3"+
		"\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\13\2\2X\13\3\2\2\2YZ\7\f\2\2"+
		"Z[\7\n\2\2[`\5\16\b\2\\]\7\17\2\2]_\5\20\t\2^\\\3\2\2\2_b\3\2\2\2`^\3"+
		"\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2cd\7\13\2\2d\r\3\2\2\2ef\7\6\2\2f"+
		"g\7\n\2\2gl\5\22\n\2hi\7\17\2\2ik\5\22\n\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2"+
		"\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7\13\2\2p\17\3\2\2\2qs\7\30\2\2rq\3"+
		"\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2w{\5\24\13\2x"+
		"z\7\30\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2"+
		"~\u0082\7\7\2\2\177\u0081\7\30\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2"+
		"\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0087\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0085\u0088\5\22\n\2\u0086\u0088\5\36\20\2\u0087\u0085\3\2\2"+
		"\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u008b\7\t\2\2\u008at"+
		"\3\2\2\2\u008a\u0089\3\2\2\2\u008b\21\3\2\2\2\u008c\u0091\5\20\t\2\u008d"+
		"\u0091\5\2\2\2\u008e\u0091\5\16\b\2\u008f\u0091\5\26\f\2\u0090\u008c\3"+
		"\2\2\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091"+
		"\23\3\2\2\2\u0092\u0093\t\2\2\2\u0093\25\3\2\2\2\u0094\u0098\5\30\r\2"+
		"\u0095\u0098\5\32\16\2\u0096\u0098\5\34\17\2\u0097\u0094\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\27\3\2\2\2\u0099\u009a\7\22\2"+
		"\2\u009a\u009f\5 \21\2\u009b\u009c\7\17\2\2\u009c\u009e\5 \21\2\u009d"+
		"\u009b\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\13\2\2\u00a3"+
		"\31\3\2\2\2\u00a4\u00a5\7\22\2\2\u00a5\u00aa\5\"\22\2\u00a6\u00a7\7\17"+
		"\2\2\u00a7\u00a9\5\"\22\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ad\u00ae\7\13\2\2\u00ae\33\3\2\2\2\u00af\u00b0\7\22\2\2\u00b0"+
		"\u00b5\5$\23\2\u00b1\u00b2\7\17\2\2\u00b2\u00b4\5$\23\2\u00b3\u00b1\3"+
		"\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\13\2\2\u00b9\35\3\2\2"+
		"\2\u00ba\u00be\5$\23\2\u00bb\u00be\5 \21\2\u00bc\u00be\5\"\22\2\u00bd"+
		"\u00ba\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\37\3\2\2"+
		"\2\u00bf\u00c0\t\3\2\2\u00c0!\3\2\2\2\u00c1\u00c2\7\23\2\2\u00c2#\3\2"+
		"\2\2\u00c3\u00c5\5(\25\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c9\5*\26\2\u00c7\u00c9\7\3\2\2\u00c8\u00c4\3\2"+
		"\2\2\u00c8\u00c7\3\2\2\2\u00c9%\3\2\2\2\u00ca\u00cb\7\16\2\2\u00cb\'\3"+
		"\2\2\2\u00cc\u00cd\t\4\2\2\u00cd)\3\2\2\2\u00ce\u00cf\t\5\2\2\u00cf+\3"+
		"\2\2\2\26.\63<HT`lt{\u0082\u0087\u008a\u0090\u0097\u009f\u00aa\u00b5\u00bd"+
		"\u00c4\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}