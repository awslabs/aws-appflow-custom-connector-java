/*-
 * #%L
 * aws-custom-connector-queryfilter
 * %%
 * Copyright (C) 2021 - 2023 Amazon Web Services
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
// Generated from src/main/configuration/grammar/CustomConnectorQueryFilterLexer.g4 by ANTLR 4.9.3

package com.amazonaws.appflow.custom.connector.queryfilter.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CustomConnectorQueryFilterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, GT=6, GE=7, LT=8, LE=9, EQ=10, NE=11, 
		LIKE=12, BETWEEN=13, LPAREN=14, RPAREN=15, NULL=16, IN=17, LIMIT=18, COMMA=19, 
		IDENTIFIER=20, POS_INTEGER=21, DECIMAL=22, SINGLE_STRING=23, DOUBLE_STRING=24, 
		EMPTY_SINGLE_STRING=25, EMPTY_DOUBLE_STRING=26, WS=27, DATE=28, DATETIME=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "NE", 
			"LIKE", "BETWEEN", "LPAREN", "RPAREN", "NULL", "IN", "LIMIT", "COMMA", 
			"IDENTIFIER", "POS_INTEGER", "DECIMAL", "SINGLE_STRING", "DOUBLE_STRING", 
			"EMPTY_SINGLE_STRING", "EMPTY_DOUBLE_STRING", "STR_ESC", "WS", "DATE", 
			"DATETIME", "TIME"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'>'", "'>='", "'<'", "'<='", "'='", 
			"'!='", null, null, "'('", "')'", "'null'", null, null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
			"NE", "LIKE", "BETWEEN", "LPAREN", "RPAREN", "NULL", "IN", "LIMIT", "COMMA", 
			"IDENTIFIER", "POS_INTEGER", "DECIMAL", "SINGLE_STRING", "DOUBLE_STRING", 
			"EMPTY_SINGLE_STRING", "EMPTY_DOUBLE_STRING", "WS", "DATE", "DATETIME"
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


	public CustomConnectorQueryFilterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CustomConnectorQueryFilterLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u0135\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\2\3\2\5\2H\n\2\3\3\3\3\3\3\3\3\5\3N\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4V\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5d\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6u\n\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u0096\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00a6\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\5\22\u00b5\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00c1\n\23\3\24\3\24\3\25\3\25\7\25\u00c7\n"+
		"\25\f\25\16\25\u00ca\13\25\3\26\3\26\6\26\u00ce\n\26\r\26\16\26\u00cf"+
		"\3\27\5\27\u00d3\n\27\3\27\6\27\u00d6\n\27\r\27\16\27\u00d7\3\27\3\27"+
		"\6\27\u00dc\n\27\r\27\16\27\u00dd\5\27\u00e0\n\27\3\30\3\30\3\30\6\30"+
		"\u00e5\n\30\r\30\16\30\u00e6\3\30\3\30\3\31\3\31\3\31\6\31\u00ee\n\31"+
		"\r\31\16\31\u00ef\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\35\6\35\u00fe\n\35\r\35\16\35\u00ff\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\5\36\u010d\n\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u0118\n\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 "+
		"\5 \u0124\n \3 \3 \3 \3 \3 \3 \3 \3 \6 \u012e\n \r \16 \u012f\5 \u0132"+
		"\n \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\29\35;\36=\37?\2\3\2\16\4\2C\\c|\7\2/\60\62;C\\aac|\3\2\63;\3\2\62"+
		";\3\2))\3\2$$\b\2$$))^^ppttvv\5\2\13\f\16\17\"\"\3\2\62\64\3\2\62\63\3"+
		"\2\62\66\3\2\62\67\2\u0150\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3G\3\2\2\2\5M\3\2\2\2\7U\3\2\2\2\tc\3\2\2"+
		"\2\13t\3\2\2\2\rv\3\2\2\2\17x\3\2\2\2\21{\3\2\2\2\23}\3\2\2\2\25\u0080"+
		"\3\2\2\2\27\u0082\3\2\2\2\31\u0095\3\2\2\2\33\u00a5\3\2\2\2\35\u00a7\3"+
		"\2\2\2\37\u00a9\3\2\2\2!\u00ab\3\2\2\2#\u00b4\3\2\2\2%\u00c0\3\2\2\2\'"+
		"\u00c2\3\2\2\2)\u00c4\3\2\2\2+\u00cb\3\2\2\2-\u00d2\3\2\2\2/\u00e1\3\2"+
		"\2\2\61\u00ea\3\2\2\2\63\u00f3\3\2\2\2\65\u00f6\3\2\2\2\67\u00f9\3\2\2"+
		"\29\u00fd\3\2\2\2;\u0103\3\2\2\2=\u0119\3\2\2\2?\u0123\3\2\2\2AB\7C\2"+
		"\2BC\7P\2\2CH\7F\2\2DE\7c\2\2EF\7p\2\2FH\7f\2\2GA\3\2\2\2GD\3\2\2\2H\4"+
		"\3\2\2\2IJ\7Q\2\2JN\7T\2\2KL\7q\2\2LN\7t\2\2MI\3\2\2\2MK\3\2\2\2N\6\3"+
		"\2\2\2OP\7P\2\2PQ\7Q\2\2QV\7V\2\2RS\7p\2\2ST\7q\2\2TV\7v\2\2UO\3\2\2\2"+
		"UR\3\2\2\2V\b\3\2\2\2WX\7V\2\2XY\7T\2\2YZ\7W\2\2Zd\7G\2\2[\\\7V\2\2\\"+
		"]\7t\2\2]^\7w\2\2^d\7g\2\2_`\7v\2\2`a\7t\2\2ab\7w\2\2bd\7g\2\2cW\3\2\2"+
		"\2c[\3\2\2\2c_\3\2\2\2d\n\3\2\2\2ef\7H\2\2fg\7C\2\2gh\7N\2\2hi\7U\2\2"+
		"iu\7G\2\2jk\7H\2\2kl\7c\2\2lm\7n\2\2mn\7u\2\2nu\7g\2\2op\7h\2\2pq\7c\2"+
		"\2qr\7n\2\2rs\7u\2\2su\7g\2\2te\3\2\2\2tj\3\2\2\2to\3\2\2\2u\f\3\2\2\2"+
		"vw\7@\2\2w\16\3\2\2\2xy\7@\2\2yz\7?\2\2z\20\3\2\2\2{|\7>\2\2|\22\3\2\2"+
		"\2}~\7>\2\2~\177\7?\2\2\177\24\3\2\2\2\u0080\u0081\7?\2\2\u0081\26\3\2"+
		"\2\2\u0082\u0083\7#\2\2\u0083\u0084\7?\2\2\u0084\30\3\2\2\2\u0085\u0086"+
		"\7E\2\2\u0086\u0087\7Q\2\2\u0087\u0088\7P\2\2\u0088\u0089\7V\2\2\u0089"+
		"\u008a\7C\2\2\u008a\u008b\7K\2\2\u008b\u008c\7P\2\2\u008c\u0096\7U\2\2"+
		"\u008d\u008e\7e\2\2\u008e\u008f\7q\2\2\u008f\u0090\7p\2\2\u0090\u0091"+
		"\7v\2\2\u0091\u0092\7c\2\2\u0092\u0093\7k\2\2\u0093\u0094\7p\2\2\u0094"+
		"\u0096\7u\2\2\u0095\u0085\3\2\2\2\u0095\u008d\3\2\2\2\u0096\32\3\2\2\2"+
		"\u0097\u0098\7D\2\2\u0098\u0099\7G\2\2\u0099\u009a\7V\2\2\u009a\u009b"+
		"\7Y\2\2\u009b\u009c\7G\2\2\u009c\u009d\7G\2\2\u009d\u00a6\7P\2\2\u009e"+
		"\u009f\7d\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7y\2\2"+
		"\u00a2\u00a3\7g\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a6\7p\2\2\u00a5\u0097"+
		"\3\2\2\2\u00a5\u009e\3\2\2\2\u00a6\34\3\2\2\2\u00a7\u00a8\7*\2\2\u00a8"+
		"\36\3\2\2\2\u00a9\u00aa\7+\2\2\u00aa \3\2\2\2\u00ab\u00ac\7p\2\2\u00ac"+
		"\u00ad\7w\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7n\2\2\u00af\"\3\2\2\2\u00b0"+
		"\u00b1\7K\2\2\u00b1\u00b5\7P\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b5\7p\2\2"+
		"\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7"+
		"N\2\2\u00b7\u00b8\7K\2\2\u00b8\u00b9\7O\2\2\u00b9\u00ba\7K\2\2\u00ba\u00c1"+
		"\7V\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7o\2\2\u00be"+
		"\u00bf\7k\2\2\u00bf\u00c1\7v\2\2\u00c0\u00b6\3\2\2\2\u00c0\u00bb\3\2\2"+
		"\2\u00c1&\3\2\2\2\u00c2\u00c3\7.\2\2\u00c3(\3\2\2\2\u00c4\u00c8\t\2\2"+
		"\2\u00c5\u00c7\t\3\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6"+
		"\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9*\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb"+
		"\u00cd\t\4\2\2\u00cc\u00ce\t\5\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0,\3\2\2\2\u00d1\u00d3"+
		"\7/\2\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4"+
		"\u00d6\t\5\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00df\3\2\2\2\u00d9\u00db\7\60\2\2\u00da"+
		"\u00dc\t\5\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00d9\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0.\3\2\2\2\u00e1\u00e4\7)\2\2\u00e2\u00e5\n\6\2\2\u00e3"+
		"\u00e5\5\67\34\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3"+
		"\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00e9\7)\2\2\u00e9\60\3\2\2\2\u00ea\u00ed\7$\2\2\u00eb\u00ee\n\7\2\2"+
		"\u00ec\u00ee\5\67\34\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00f2\7$\2\2\u00f2\62\3\2\2\2\u00f3\u00f4\7)\2\2\u00f4\u00f5\7)\2\2\u00f5"+
		"\64\3\2\2\2\u00f6\u00f7\7$\2\2\u00f7\u00f8\7$\2\2\u00f8\66\3\2\2\2\u00f9"+
		"\u00fa\7^\2\2\u00fa\u00fb\t\b\2\2\u00fb8\3\2\2\2\u00fc\u00fe\t\t\2\2\u00fd"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101\u0102\b\35\2\2\u0102:\3\2\2\2\u0103\u0104"+
		"\t\5\2\2\u0104\u0105\t\5\2\2\u0105\u0106\t\5\2\2\u0106\u0107\t\5\2\2\u0107"+
		"\u010c\7/\2\2\u0108\u0109\7\62\2\2\u0109\u010d\t\4\2\2\u010a\u010b\7\63"+
		"\2\2\u010b\u010d\t\n\2\2\u010c\u0108\3\2\2\2\u010c\u010a\3\2\2\2\u010d"+
		"\u010e\3\2\2\2\u010e\u0117\7/\2\2\u010f\u0110\7\62\2\2\u0110\u0118\t\5"+
		"\2\2\u0111\u0112\7\63\2\2\u0112\u0118\t\5\2\2\u0113\u0114\7\64\2\2\u0114"+
		"\u0118\t\5\2\2\u0115\u0116\7\65\2\2\u0116\u0118\t\13\2\2\u0117\u010f\3"+
		"\2\2\2\u0117\u0111\3\2\2\2\u0117\u0113\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"<\3\2\2\2\u0119\u011a\5;\36\2\u011a\u011b\7V\2\2\u011b\u011c\5? \2\u011c"+
		">\3\2\2\2\u011d\u011e\7\62\2\2\u011e\u0124\t\5\2\2\u011f\u0120\7\63\2"+
		"\2\u0120\u0124\t\5\2\2\u0121\u0122\7\64\2\2\u0122\u0124\t\f\2\2\u0123"+
		"\u011d\3\2\2\2\u0123\u011f\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\u0126\7<\2\2\u0126\u0127\t\r\2\2\u0127\u0128\t\5\2\2\u0128"+
		"\u0129\7<\2\2\u0129\u012a\t\r\2\2\u012a\u0131\t\5\2\2\u012b\u012d\7\60"+
		"\2\2\u012c\u012e\t\5\2\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012b\3\2"+
		"\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\7\\\2\2\u0134"+
		"@\3\2\2\2\34\2GMUct\u0095\u00a5\u00b4\u00c0\u00c8\u00cf\u00d2\u00d7\u00dd"+
		"\u00df\u00e4\u00e6\u00ed\u00ef\u00ff\u010c\u0117\u0123\u012f\u0131\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
