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
		QUOTED_STRING=17, QUOTED_VARIABLE_NAME=18, UNSIGNED_INT=19, DIGIT=20, 
		UNSIGNED_FLOAT=21, WS=22, VariableLetter=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "VECTOR_START", "ESCAPED_QUOTE", 
		"QUOTED_STRING", "ESCAPED_VAR_QUOTE", "QUOTED_VARIABLE_NAME", "UNSIGNED_INT", 
		"DIGIT", "UNSIGNED_FLOAT", "WS", "Explicit_int", "Exponent", "VariableLetter"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00ce\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21p"+
		"\n\21\f\21\16\21s\13\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\7\23}"+
		"\n\23\f\23\16\23\u0080\13\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\7"+
		"\25\u008a\n\25\f\25\16\25\u008d\13\25\3\25\3\25\3\26\6\26\u0092\n\26\r"+
		"\26\16\26\u0093\3\26\5\26\u0097\n\26\3\27\3\27\3\30\6\30\u009c\n\30\r"+
		"\30\16\30\u009d\3\30\3\30\7\30\u00a2\n\30\f\30\16\30\u00a5\13\30\3\30"+
		"\5\30\u00a8\n\30\3\30\3\30\6\30\u00ac\n\30\r\30\16\30\u00ad\3\30\5\30"+
		"\u00b1\n\30\3\30\6\30\u00b4\n\30\r\30\16\30\u00b5\3\30\5\30\u00b9\n\30"+
		"\3\31\6\31\u00bc\n\31\r\31\16\31\u00bd\3\31\3\31\3\32\3\32\3\33\3\33\5"+
		"\33\u00c6\n\33\3\33\6\33\u00c9\n\33\r\33\16\33\u00ca\3\34\3\34\4~\u008b"+
		"\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\2%\23\'\2)\24+\25-\26/\27\61\30\63\2\65\2\67\31\3\2\b\4"+
		"\2\f\f\17\17\3\2\62;\5\2\13\f\17\17\"\"\4\2GGgg\4\2--//\7\2\60\60\62;"+
		"C\\aac|\u00db\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2%\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\67\3\2\2\2\39\3\2\2\2\5<\3\2\2\2\7>\3\2\2\2\tD\3\2\2\2\13I\3\2\2"+
		"\2\rK\3\2\2\2\17M\3\2\2\2\21R\3\2\2\2\23T\3\2\2\2\25V\3\2\2\2\27`\3\2"+
		"\2\2\31b\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37h\3\2\2\2!m\3\2\2\2#v\3\2\2"+
		"\2%y\3\2\2\2\'\u0083\3\2\2\2)\u0086\3\2\2\2+\u0091\3\2\2\2-\u0098\3\2"+
		"\2\2/\u00b8\3\2\2\2\61\u00bb\3\2\2\2\63\u00c1\3\2\2\2\65\u00c3\3\2\2\2"+
		"\67\u00cc\3\2\2\29:\7P\2\2:;\7C\2\2;\4\3\2\2\2<=\7V\2\2=\6\3\2\2\2>?\7"+
		"H\2\2?@\7C\2\2@A\7N\2\2AB\7U\2\2BC\7G\2\2C\b\3\2\2\2DE\7n\2\2EF\7k\2\2"+
		"FG\7u\2\2GH\7v\2\2H\n\3\2\2\2IJ\7?\2\2J\f\3\2\2\2KL\7H\2\2L\16\3\2\2\2"+
		"MN\7P\2\2NO\7W\2\2OP\7N\2\2PQ\7N\2\2Q\20\3\2\2\2RS\7*\2\2S\22\3\2\2\2"+
		"TU\7+\2\2U\24\3\2\2\2VW\7u\2\2WX\7v\2\2XY\7t\2\2YZ\7w\2\2Z[\7e\2\2[\\"+
		"\7v\2\2\\]\7w\2\2]^\7t\2\2^_\7g\2\2_\26\3\2\2\2`a\7-\2\2a\30\3\2\2\2b"+
		"c\7N\2\2c\32\3\2\2\2de\7.\2\2e\34\3\2\2\2fg\7/\2\2g\36\3\2\2\2hi\7V\2"+
		"\2ij\7T\2\2jk\7W\2\2kl\7G\2\2l \3\2\2\2mq\7e\2\2np\5\61\31\2on\3\2\2\2"+
		"ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7*\2\2u\"\3\2\2\2"+
		"vw\7^\2\2wx\7$\2\2x$\3\2\2\2y~\7$\2\2z}\5#\22\2{}\n\2\2\2|z\3\2\2\2|{"+
		"\3\2\2\2}\u0080\3\2\2\2~\177\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2\u0080"+
		"~\3\2\2\2\u0081\u0082\7$\2\2\u0082&\3\2\2\2\u0083\u0084\7^\2\2\u0084\u0085"+
		"\7b\2\2\u0085(\3\2\2\2\u0086\u008b\7b\2\2\u0087\u008a\5\'\24\2\u0088\u008a"+
		"\n\2\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u008f\7b\2\2\u008f*\3\2\2\2\u0090\u0092\5-\27\2\u0091\u0090"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0097\5\63\32\2\u0096\u0095\3\2\2\2\u0096\u0097\3"+
		"\2\2\2\u0097,\3\2\2\2\u0098\u0099\t\3\2\2\u0099.\3\2\2\2\u009a\u009c\4"+
		"\62;\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a3\7\60\2\2\u00a0\u00a2\4"+
		"\62;\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a8\5\65"+
		"\33\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00b9\3\2\2\2\u00a9"+
		"\u00ab\7\60\2\2\u00aa\u00ac\4\62;\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3"+
		"\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af"+
		"\u00b1\5\65\33\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b9\3"+
		"\2\2\2\u00b2\u00b4\4\62;\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\5\65"+
		"\33\2\u00b8\u009b\3\2\2\2\u00b8\u00a9\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b9"+
		"\60\3\2\2\2\u00ba\u00bc\t\4\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2"+
		"\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0"+
		"\b\31\2\2\u00c0\62\3\2\2\2\u00c1\u00c2\7N\2\2\u00c2\64\3\2\2\2\u00c3\u00c5"+
		"\t\5\2\2\u00c4\u00c6\t\6\2\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c8\3\2\2\2\u00c7\u00c9\4\62;\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\66\3\2\2\2\u00cc\u00cd"+
		"\t\7\2\2\u00cd8\3\2\2\2\24\2q|~\u0089\u008b\u0093\u0096\u009d\u00a3\u00a7"+
		"\u00ad\u00b0\u00b5\u00b8\u00bd\u00c5\u00ca\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}