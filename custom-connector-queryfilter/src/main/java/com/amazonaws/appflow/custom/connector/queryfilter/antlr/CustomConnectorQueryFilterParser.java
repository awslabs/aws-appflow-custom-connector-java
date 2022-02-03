/*-
 * #%L
 * aws-custom-connector-queryfilter
 * %%
 * Copyright (C) 2021 Amazon Web Services
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
// Generated from CustomConnectorQueryFilterParser.g4 by ANTLR 4.9.1

package com.amazonaws.appflow.custom.connector.queryfilter.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CustomConnectorQueryFilterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, GT=6, GE=7, LT=8, LE=9, EQ=10, NE=11, 
		LIKE=12, BETWEEN=13, LPAREN=14, RPAREN=15, NULL=16, IN=17, COMMA=18, IDENTIFIER=19, 
		DECIMAL=20, SINGLE_STRING=21, DOUBLE_STRING=22, EMPTY_SINGLE_STRING=23, 
		EMPTY_DOUBLE_STRING=24, WS=25, DATE=26, DATETIME=27;
	public static final int
		RULE_queryfilter = 0, RULE_expression = 1, RULE_gtComparator = 2, RULE_geComparator = 3, 
		RULE_ltComparator = 4, RULE_leComparator = 5, RULE_eqComparator = 6, RULE_neComparator = 7, 
		RULE_likeComparator = 8, RULE_betweenComparator = 9, RULE_andBinary = 10, 
		RULE_orBinary = 11, RULE_bool = 12, RULE_identifier = 13, RULE_in = 14, 
		RULE_string = 15, RULE_value = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"queryfilter", "expression", "gtComparator", "geComparator", "ltComparator", 
			"leComparator", "eqComparator", "neComparator", "likeComparator", "betweenComparator", 
			"andBinary", "orBinary", "bool", "identifier", "in", "string", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'>'", "'>='", "'<'", "'<='", "'='", 
			"'!='", null, null, "'('", "')'", "'null'", null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
			"NE", "LIKE", "BETWEEN", "LPAREN", "RPAREN", "NULL", "IN", "COMMA", "IDENTIFIER", 
			"DECIMAL", "SINGLE_STRING", "DOUBLE_STRING", "EMPTY_SINGLE_STRING", "EMPTY_DOUBLE_STRING", 
			"WS", "DATE", "DATETIME"
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
	public String getGrammarFileName() { return "CustomConnectorQueryFilterParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CustomConnectorQueryFilterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QueryfilterContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CustomConnectorQueryFilterParser.EOF, 0); }
		public QueryfilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryfilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterQueryfilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitQueryfilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitQueryfilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryfilterContext queryfilter() throws RecognitionException {
		QueryfilterContext _localctx = new QueryfilterContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_queryfilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			expression(0);
			setState(35);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LesserThanComparatorExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public LtComparatorContext op;
		public ValueContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LtComparatorContext ltComparator() {
			return getRuleContext(LtComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public LesserThanComparatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterLesserThanComparatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitLesserThanComparatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitLesserThanComparatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanComparatorExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public GtComparatorContext op;
		public ValueContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GtComparatorContext gtComparator() {
			return getRuleContext(GtComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public GreaterThanComparatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterGreaterThanComparatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitGreaterThanComparatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitGreaterThanComparatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolNotEqualToComparatorExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public NeComparatorContext op;
		public BoolContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public NeComparatorContext neComparator() {
			return getRuleContext(NeComparatorContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolNotEqualToComparatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterBoolNotEqualToComparatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitBoolNotEqualToComparatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitBoolNotEqualToComparatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExpressionContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitValueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExpressionContext extends ExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitIdentifierExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(CustomConnectorQueryFilterParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExpressionContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(CustomConnectorQueryFilterParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CustomConnectorQueryFilterParser.RPAREN, 0); }
		public ParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolEqualToComparatorExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public EqComparatorContext op;
		public BoolContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EqComparatorContext eqComparator() {
			return getRuleContext(EqComparatorContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolEqualToComparatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterBoolEqualToComparatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitBoolEqualToComparatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitBoolEqualToComparatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ORBinaryExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public OrBinaryContext op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrBinaryContext orBinary() {
			return getRuleContext(OrBinaryContext.class,0);
		}
		public ORBinaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterORBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitORBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitORBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualToComparatorExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public EqComparatorContext op;
		public ValueContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EqComparatorContext eqComparator() {
			return getRuleContext(EqComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public EqualToComparatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterEqualToComparatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitEqualToComparatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitEqualToComparatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public BetweenComparatorContext op;
		public ValueContext l1;
		public AndBinaryContext op1;
		public ValueContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BetweenComparatorContext betweenComparator() {
			return getRuleContext(BetweenComparatorContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public AndBinaryContext andBinary() {
			return getRuleContext(AndBinaryContext.class,0);
		}
		public BetweenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterBetweenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitBetweenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitBetweenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InExpressionContext extends ExpressionContext {
		public InContext op;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CustomConnectorQueryFilterParser.LPAREN, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(CustomConnectorQueryFilterParser.RPAREN, 0); }
		public InContext in() {
			return getRuleContext(InContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CustomConnectorQueryFilterParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CustomConnectorQueryFilterParser.COMMA, i);
		}
		public InExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterInExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitInExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitInExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanEqualToComparatorExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public GeComparatorContext op;
		public ValueContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GeComparatorContext geComparator() {
			return getRuleContext(GeComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public GreaterThanEqualToComparatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterGreaterThanEqualToComparatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitGreaterThanEqualToComparatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitGreaterThanEqualToComparatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LikeComparatorExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public LikeComparatorContext op;
		public ValueContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LikeComparatorContext likeComparator() {
			return getRuleContext(LikeComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public LikeComparatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterLikeComparatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitLikeComparatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitLikeComparatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LesserThanEqualToComparatorExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public LeComparatorContext op;
		public ValueContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LeComparatorContext leComparator() {
			return getRuleContext(LeComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public LesserThanEqualToComparatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterLesserThanEqualToComparatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitLesserThanEqualToComparatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitLesserThanEqualToComparatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotEqualToComparatorExpressionContext extends ExpressionContext {
		public IdentifierContext left;
		public NeComparatorContext op;
		public ValueContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public NeComparatorContext neComparator() {
			return getRuleContext(NeComparatorContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NotEqualToComparatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterNotEqualToComparatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitNotEqualToComparatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitNotEqualToComparatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ANDBinaryExpressionContext extends ExpressionContext {
		public ExpressionContext left;
		public AndBinaryContext op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndBinaryContext andBinary() {
			return getRuleContext(AndBinaryContext.class,0);
		}
		public ANDBinaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterANDBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitANDBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitANDBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(38);
				match(LPAREN);
				setState(39);
				expression(0);
				setState(40);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(NOT);
				setState(43);
				expression(16);
				}
				break;
			case 3:
				{
				_localctx = new GreaterThanComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				((GreaterThanComparatorExpressionContext)_localctx).left = identifier();
				setState(45);
				((GreaterThanComparatorExpressionContext)_localctx).op = gtComparator();
				setState(46);
				((GreaterThanComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 4:
				{
				_localctx = new GreaterThanEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48);
				((GreaterThanEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(49);
				((GreaterThanEqualToComparatorExpressionContext)_localctx).op = geComparator();
				setState(50);
				((GreaterThanEqualToComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 5:
				{
				_localctx = new LesserThanComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				((LesserThanComparatorExpressionContext)_localctx).left = identifier();
				setState(53);
				((LesserThanComparatorExpressionContext)_localctx).op = ltComparator();
				setState(54);
				((LesserThanComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 6:
				{
				_localctx = new LesserThanEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				((LesserThanEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(57);
				((LesserThanEqualToComparatorExpressionContext)_localctx).op = leComparator();
				setState(58);
				((LesserThanEqualToComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 7:
				{
				_localctx = new EqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				((EqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(61);
				((EqualToComparatorExpressionContext)_localctx).op = eqComparator();
				setState(62);
				((EqualToComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 8:
				{
				_localctx = new BoolEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				((BoolEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(65);
				((BoolEqualToComparatorExpressionContext)_localctx).op = eqComparator();
				setState(66);
				((BoolEqualToComparatorExpressionContext)_localctx).right = bool();
				}
				break;
			case 9:
				{
				_localctx = new NotEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				((NotEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(69);
				((NotEqualToComparatorExpressionContext)_localctx).op = neComparator();
				setState(70);
				((NotEqualToComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 10:
				{
				_localctx = new BoolNotEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				((BoolNotEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(73);
				((BoolNotEqualToComparatorExpressionContext)_localctx).op = neComparator();
				setState(74);
				((BoolNotEqualToComparatorExpressionContext)_localctx).right = bool();
				}
				break;
			case 11:
				{
				_localctx = new LikeComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				((LikeComparatorExpressionContext)_localctx).left = identifier();
				setState(77);
				((LikeComparatorExpressionContext)_localctx).op = likeComparator();
				setState(78);
				((LikeComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 12:
				{
				_localctx = new BetweenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(80);
				((BetweenExpressionContext)_localctx).left = identifier();
				setState(81);
				((BetweenExpressionContext)_localctx).op = betweenComparator();
				{
				setState(82);
				((BetweenExpressionContext)_localctx).l1 = value();
				setState(83);
				((BetweenExpressionContext)_localctx).op1 = andBinary();
				setState(84);
				((BetweenExpressionContext)_localctx).right = value();
				}
				}
				}
				break;
			case 13:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				identifier();
				}
				break;
			case 14:
				{
				_localctx = new ValueExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				value();
				}
				break;
			case 15:
				{
				_localctx = new InExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				identifier();
				setState(89);
				((InExpressionContext)_localctx).op = in();
				setState(90);
				match(LPAREN);
				setState(91);
				value();
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(92);
					match(COMMA);
					setState(93);
					value();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ANDBinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ANDBinaryExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(103);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(104);
						((ANDBinaryExpressionContext)_localctx).op = andBinary();
						setState(105);
						((ANDBinaryExpressionContext)_localctx).right = expression(16);
						}
						break;
					case 2:
						{
						_localctx = new ORBinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ORBinaryExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(108);
						((ORBinaryExpressionContext)_localctx).op = orBinary();
						setState(109);
						((ORBinaryExpressionContext)_localctx).right = expression(15);
						}
						break;
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GtComparatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(CustomConnectorQueryFilterParser.GT, 0); }
		public GtComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gtComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterGtComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitGtComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitGtComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GtComparatorContext gtComparator() throws RecognitionException {
		GtComparatorContext _localctx = new GtComparatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_gtComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(GT);
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

	public static class GeComparatorContext extends ParserRuleContext {
		public TerminalNode GE() { return getToken(CustomConnectorQueryFilterParser.GE, 0); }
		public GeComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_geComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterGeComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitGeComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitGeComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeComparatorContext geComparator() throws RecognitionException {
		GeComparatorContext _localctx = new GeComparatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_geComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(GE);
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

	public static class LtComparatorContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(CustomConnectorQueryFilterParser.LT, 0); }
		public LtComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ltComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterLtComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitLtComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitLtComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LtComparatorContext ltComparator() throws RecognitionException {
		LtComparatorContext _localctx = new LtComparatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ltComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(LT);
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

	public static class LeComparatorContext extends ParserRuleContext {
		public TerminalNode LE() { return getToken(CustomConnectorQueryFilterParser.LE, 0); }
		public LeComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterLeComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitLeComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitLeComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeComparatorContext leComparator() throws RecognitionException {
		LeComparatorContext _localctx = new LeComparatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_leComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(LE);
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

	public static class EqComparatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(CustomConnectorQueryFilterParser.EQ, 0); }
		public EqComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterEqComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitEqComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitEqComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqComparatorContext eqComparator() throws RecognitionException {
		EqComparatorContext _localctx = new EqComparatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_eqComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(EQ);
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

	public static class NeComparatorContext extends ParserRuleContext {
		public TerminalNode NE() { return getToken(CustomConnectorQueryFilterParser.NE, 0); }
		public NeComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterNeComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitNeComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitNeComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NeComparatorContext neComparator() throws RecognitionException {
		NeComparatorContext _localctx = new NeComparatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_neComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(NE);
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

	public static class LikeComparatorContext extends ParserRuleContext {
		public TerminalNode LIKE() { return getToken(CustomConnectorQueryFilterParser.LIKE, 0); }
		public LikeComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_likeComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterLikeComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitLikeComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitLikeComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LikeComparatorContext likeComparator() throws RecognitionException {
		LikeComparatorContext _localctx = new LikeComparatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_likeComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(LIKE);
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

	public static class BetweenComparatorContext extends ParserRuleContext {
		public TerminalNode BETWEEN() { return getToken(CustomConnectorQueryFilterParser.BETWEEN, 0); }
		public BetweenComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterBetweenComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitBetweenComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitBetweenComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenComparatorContext betweenComparator() throws RecognitionException {
		BetweenComparatorContext _localctx = new BetweenComparatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_betweenComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(BETWEEN);
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

	public static class AndBinaryContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(CustomConnectorQueryFilterParser.AND, 0); }
		public AndBinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andBinary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterAndBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitAndBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitAndBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndBinaryContext andBinary() throws RecognitionException {
		AndBinaryContext _localctx = new AndBinaryContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_andBinary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(AND);
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

	public static class OrBinaryContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(CustomConnectorQueryFilterParser.OR, 0); }
		public OrBinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orBinary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterOrBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitOrBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitOrBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrBinaryContext orBinary() throws RecognitionException {
		OrBinaryContext _localctx = new OrBinaryContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_orBinary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(OR);
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
		public TerminalNode TRUE() { return getToken(CustomConnectorQueryFilterParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CustomConnectorQueryFilterParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitBool(this);
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
			setState(136);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CustomConnectorQueryFilterParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(IDENTIFIER);
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

	public static class InContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(CustomConnectorQueryFilterParser.IN, 0); }
		public InContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitIn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InContext in() throws RecognitionException {
		InContext _localctx = new InContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_in);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(IN);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode SINGLE_STRING() { return getToken(CustomConnectorQueryFilterParser.SINGLE_STRING, 0); }
		public TerminalNode DOUBLE_STRING() { return getToken(CustomConnectorQueryFilterParser.DOUBLE_STRING, 0); }
		public TerminalNode EMPTY_DOUBLE_STRING() { return getToken(CustomConnectorQueryFilterParser.EMPTY_DOUBLE_STRING, 0); }
		public TerminalNode EMPTY_SINGLE_STRING() { return getToken(CustomConnectorQueryFilterParser.EMPTY_SINGLE_STRING, 0); }
		public TerminalNode NULL() { return getToken(CustomConnectorQueryFilterParser.NULL, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << EMPTY_SINGLE_STRING) | (1L << EMPTY_DOUBLE_STRING))) != 0)) ) {
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringValueExpressionContext extends ValueContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StringValueExpressionContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterStringValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitStringValueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitStringValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecimalValueExpressionContext extends ValueContext {
		public TerminalNode DECIMAL() { return getToken(CustomConnectorQueryFilterParser.DECIMAL, 0); }
		public DecimalValueExpressionContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterDecimalValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitDecimalValueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitDecimalValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsoDateContext extends ValueContext {
		public TerminalNode DATE() { return getToken(CustomConnectorQueryFilterParser.DATE, 0); }
		public IsoDateContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterIsoDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitIsoDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitIsoDate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsoDateTimeContext extends ValueContext {
		public TerminalNode DATETIME() { return getToken(CustomConnectorQueryFilterParser.DATETIME, 0); }
		public IsoDateTimeContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterIsoDateTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitIsoDateTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitIsoDateTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULL:
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case EMPTY_SINGLE_STRING:
			case EMPTY_DOUBLE_STRING:
				_localctx = new StringValueExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				string();
				}
				break;
			case DECIMAL:
				_localctx = new DecimalValueExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(DECIMAL);
				}
				break;
			case DATE:
				_localctx = new IsoDateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				match(DATE);
				}
				break;
			case DATETIME:
				_localctx = new IsoDateTimeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				match(DATETIME);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u0099\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3a\n\3\f\3\16\3d\13\3\3\3\3\3\5\3h\n"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3r\n\3\f\3\16\3u\13\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\5\22\u0097"+
		"\n\22\3\22\2\3\4\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\4\3\2"+
		"\6\7\4\2\22\22\27\32\2\u009b\2$\3\2\2\2\4g\3\2\2\2\6v\3\2\2\2\bx\3\2\2"+
		"\2\nz\3\2\2\2\f|\3\2\2\2\16~\3\2\2\2\20\u0080\3\2\2\2\22\u0082\3\2\2\2"+
		"\24\u0084\3\2\2\2\26\u0086\3\2\2\2\30\u0088\3\2\2\2\32\u008a\3\2\2\2\34"+
		"\u008c\3\2\2\2\36\u008e\3\2\2\2 \u0090\3\2\2\2\"\u0096\3\2\2\2$%\5\4\3"+
		"\2%&\7\2\2\3&\3\3\2\2\2\'(\b\3\1\2()\7\20\2\2)*\5\4\3\2*+\7\21\2\2+h\3"+
		"\2\2\2,-\7\5\2\2-h\5\4\3\22./\5\34\17\2/\60\5\6\4\2\60\61\5\"\22\2\61"+
		"h\3\2\2\2\62\63\5\34\17\2\63\64\5\b\5\2\64\65\5\"\22\2\65h\3\2\2\2\66"+
		"\67\5\34\17\2\678\5\n\6\289\5\"\22\29h\3\2\2\2:;\5\34\17\2;<\5\f\7\2<"+
		"=\5\"\22\2=h\3\2\2\2>?\5\34\17\2?@\5\16\b\2@A\5\"\22\2Ah\3\2\2\2BC\5\34"+
		"\17\2CD\5\16\b\2DE\5\32\16\2Eh\3\2\2\2FG\5\34\17\2GH\5\20\t\2HI\5\"\22"+
		"\2Ih\3\2\2\2JK\5\34\17\2KL\5\20\t\2LM\5\32\16\2Mh\3\2\2\2NO\5\34\17\2"+
		"OP\5\22\n\2PQ\5\"\22\2Qh\3\2\2\2RS\5\34\17\2ST\5\24\13\2TU\5\"\22\2UV"+
		"\5\26\f\2VW\5\"\22\2Wh\3\2\2\2Xh\5\34\17\2Yh\5\"\22\2Z[\5\34\17\2[\\\5"+
		"\36\20\2\\]\7\20\2\2]b\5\"\22\2^_\7\24\2\2_a\5\"\22\2`^\3\2\2\2ad\3\2"+
		"\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7\21\2\2fh\3\2\2\2g\'\3"+
		"\2\2\2g,\3\2\2\2g.\3\2\2\2g\62\3\2\2\2g\66\3\2\2\2g:\3\2\2\2g>\3\2\2\2"+
		"gB\3\2\2\2gF\3\2\2\2gJ\3\2\2\2gN\3\2\2\2gR\3\2\2\2gX\3\2\2\2gY\3\2\2\2"+
		"gZ\3\2\2\2hs\3\2\2\2ij\f\21\2\2jk\5\26\f\2kl\5\4\3\22lr\3\2\2\2mn\f\20"+
		"\2\2no\5\30\r\2op\5\4\3\21pr\3\2\2\2qi\3\2\2\2qm\3\2\2\2ru\3\2\2\2sq\3"+
		"\2\2\2st\3\2\2\2t\5\3\2\2\2us\3\2\2\2vw\7\b\2\2w\7\3\2\2\2xy\7\t\2\2y"+
		"\t\3\2\2\2z{\7\n\2\2{\13\3\2\2\2|}\7\13\2\2}\r\3\2\2\2~\177\7\f\2\2\177"+
		"\17\3\2\2\2\u0080\u0081\7\r\2\2\u0081\21\3\2\2\2\u0082\u0083\7\16\2\2"+
		"\u0083\23\3\2\2\2\u0084\u0085\7\17\2\2\u0085\25\3\2\2\2\u0086\u0087\7"+
		"\3\2\2\u0087\27\3\2\2\2\u0088\u0089\7\4\2\2\u0089\31\3\2\2\2\u008a\u008b"+
		"\t\2\2\2\u008b\33\3\2\2\2\u008c\u008d\7\25\2\2\u008d\35\3\2\2\2\u008e"+
		"\u008f\7\23\2\2\u008f\37\3\2\2\2\u0090\u0091\t\3\2\2\u0091!\3\2\2\2\u0092"+
		"\u0097\5 \21\2\u0093\u0097\7\26\2\2\u0094\u0097\7\34\2\2\u0095\u0097\7"+
		"\35\2\2\u0096\u0092\3\2\2\2\u0096\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0095\3\2\2\2\u0097#\3\2\2\2\7bgqs\u0096";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
