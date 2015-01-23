// Generated from Dput.g4 by ANTLR 4.3

package org.auscope.eavl.wpsclient.dput;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DputLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, VECTOR_START=16, 
		QUOTED_STRING=17, QUOTED_VARIABLE_NAME=18, UNSIGNED_INT=19, UNSIGNED_FLOAT=20, 
		VariableLetters=21, WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "VECTOR_START", "ESCAPED_QUOTE", 
		"QUOTED_STRING", "ESCAPED_VAR_QUOTE", "QUOTED_VARIABLE_NAME", "UNSIGNED_INT", 
		"UNSIGNED_FLOAT", "Explicit_int", "Exponent", "VariableLetters", "WS"
	};


	public DputLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Dput.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u00cd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21n\n\21\f\21"+
		"\16\21q\13\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\7\23{\n\23\f\23"+
		"\16\23~\13\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\7\25\u0088\n\25"+
		"\f\25\16\25\u008b\13\25\3\25\3\25\3\26\6\26\u0090\n\26\r\26\16\26\u0091"+
		"\3\26\5\26\u0095\n\26\3\27\6\27\u0098\n\27\r\27\16\27\u0099\3\27\3\27"+
		"\7\27\u009e\n\27\f\27\16\27\u00a1\13\27\3\27\5\27\u00a4\n\27\3\27\3\27"+
		"\6\27\u00a8\n\27\r\27\16\27\u00a9\3\27\5\27\u00ad\n\27\3\27\6\27\u00b0"+
		"\n\27\r\27\16\27\u00b1\3\27\5\27\u00b5\n\27\3\30\3\30\3\31\3\31\5\31\u00bb"+
		"\n\31\3\31\6\31\u00be\n\31\r\31\16\31\u00bf\3\32\6\32\u00c3\n\32\r\32"+
		"\16\32\u00c4\3\33\6\33\u00c8\n\33\r\33\16\33\u00c9\3\33\3\33\4|\u0089"+
		"\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\2%\23\'\2)\24+\25-\26/\2\61\2\63\27\65\30\3\2\b\4\2\f\f"+
		"\17\17\3\2\62;\4\2GGgg\4\2--//\7\2\60\60\62;C\\aac|\5\2\13\f\17\17\"\""+
		"\u00db\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2%\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\3\67\3\2\2\2\5:\3\2\2\2\7<\3\2\2\2\tB\3\2\2\2\13G\3\2\2\2\rI\3\2\2\2"+
		"\17K\3\2\2\2\21P\3\2\2\2\23R\3\2\2\2\25T\3\2\2\2\27^\3\2\2\2\31`\3\2\2"+
		"\2\33b\3\2\2\2\35d\3\2\2\2\37f\3\2\2\2!k\3\2\2\2#t\3\2\2\2%w\3\2\2\2\'"+
		"\u0081\3\2\2\2)\u0084\3\2\2\2+\u008f\3\2\2\2-\u00b4\3\2\2\2/\u00b6\3\2"+
		"\2\2\61\u00b8\3\2\2\2\63\u00c2\3\2\2\2\65\u00c7\3\2\2\2\678\7P\2\289\7"+
		"C\2\29\4\3\2\2\2:;\7V\2\2;\6\3\2\2\2<=\7H\2\2=>\7C\2\2>?\7N\2\2?@\7U\2"+
		"\2@A\7G\2\2A\b\3\2\2\2BC\7n\2\2CD\7k\2\2DE\7u\2\2EF\7v\2\2F\n\3\2\2\2"+
		"GH\7?\2\2H\f\3\2\2\2IJ\7H\2\2J\16\3\2\2\2KL\7P\2\2LM\7W\2\2MN\7N\2\2N"+
		"O\7N\2\2O\20\3\2\2\2PQ\7*\2\2Q\22\3\2\2\2RS\7+\2\2S\24\3\2\2\2TU\7u\2"+
		"\2UV\7v\2\2VW\7t\2\2WX\7w\2\2XY\7e\2\2YZ\7v\2\2Z[\7w\2\2[\\\7t\2\2\\]"+
		"\7g\2\2]\26\3\2\2\2^_\7-\2\2_\30\3\2\2\2`a\7N\2\2a\32\3\2\2\2bc\7.\2\2"+
		"c\34\3\2\2\2de\7/\2\2e\36\3\2\2\2fg\7V\2\2gh\7T\2\2hi\7W\2\2ij\7G\2\2"+
		"j \3\2\2\2ko\7e\2\2ln\5\65\33\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2"+
		"\2pr\3\2\2\2qo\3\2\2\2rs\7*\2\2s\"\3\2\2\2tu\7^\2\2uv\7$\2\2v$\3\2\2\2"+
		"w|\7$\2\2x{\5#\22\2y{\n\2\2\2zx\3\2\2\2zy\3\2\2\2{~\3\2\2\2|}\3\2\2\2"+
		"|z\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\7$\2\2\u0080&\3\2\2\2\u0081"+
		"\u0082\7^\2\2\u0082\u0083\7b\2\2\u0083(\3\2\2\2\u0084\u0089\7b\2\2\u0085"+
		"\u0088\5\'\24\2\u0086\u0088\n\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086\3"+
		"\2\2\2\u0088\u008b\3\2\2\2\u0089\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7b\2\2\u008d*\3\2\2\2\u008e"+
		"\u0090\t\3\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0095\5/\30\2\u0094"+
		"\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095,\3\2\2\2\u0096\u0098\4\62;\2"+
		"\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009f\7\60\2\2\u009c\u009e\4\62;\2"+
		"\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\5\61\31\2"+
		"\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00b5\3\2\2\2\u00a5\u00a7"+
		"\7\60\2\2\u00a6\u00a8\4\62;\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2"+
		"\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00ad"+
		"\5\61\31\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b5\3\2\2\2"+
		"\u00ae\u00b0\4\62;\2\u00af\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\5\61\31\2"+
		"\u00b4\u0097\3\2\2\2\u00b4\u00a5\3\2\2\2\u00b4\u00af\3\2\2\2\u00b5.\3"+
		"\2\2\2\u00b6\u00b7\7N\2\2\u00b7\60\3\2\2\2\u00b8\u00ba\t\4\2\2\u00b9\u00bb"+
		"\t\5\2\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc"+
		"\u00be\4\62;\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\62\3\2\2\2\u00c1\u00c3\t\6\2\2\u00c2\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\64\3\2\2\2\u00c6\u00c8\t\7\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2"+
		"\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc"+
		"\b\33\2\2\u00cc\66\3\2\2\2\25\2oz|\u0087\u0089\u0091\u0094\u0099\u009f"+
		"\u00a3\u00a9\u00ac\u00b1\u00b4\u00ba\u00bf\u00c4\u00c9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}