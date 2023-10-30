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
// Generated from src/main/configuration/grammar/CustomConnectorQueryFilterParser.g4 by ANTLR 4.9.3

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
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, GT=6, GE=7, LT=8, LE=9, EQ=10, NE=11, 
		LIKE=12, BETWEEN=13, LPAREN=14, RPAREN=15, NULL=16, IN=17, LIMIT=18, ORDERBY=19, 
		ASC=20, DESC=21, COMMA=22, IDENTIFIER=23, POS_INTEGER=24, DECIMAL=25, 
		SINGLE_STRING=26, DOUBLE_STRING=27, EMPTY_SINGLE_STRING=28, EMPTY_DOUBLE_STRING=29, 
		WS=30, DATE=31, DATETIME=32;
	public static final int
		RULE_queryfilter = 0, RULE_limitexpr = 1, RULE_orderbyexpr = 2, RULE_expression = 3, 
		RULE_gtComparator = 4, RULE_geComparator = 5, RULE_ltComparator = 6, RULE_leComparator = 7, 
		RULE_eqComparator = 8, RULE_neComparator = 9, RULE_likeComparator = 10, 
		RULE_betweenComparator = 11, RULE_andBinary = 12, RULE_orBinary = 13, 
		RULE_bool = 14, RULE_identifier = 15, RULE_in = 16, RULE_limit = 17, RULE_orderby = 18, 
		RULE_order = 19, RULE_string = 20, RULE_value = 21, RULE_count = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"queryfilter", "limitexpr", "orderbyexpr", "expression", "gtComparator", 
			"geComparator", "ltComparator", "leComparator", "eqComparator", "neComparator", 
			"likeComparator", "betweenComparator", "andBinary", "orBinary", "bool", 
			"identifier", "in", "limit", "orderby", "order", "string", "value", "count"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'>'", "'>='", "'<'", "'<='", "'='", 
			"'!='", null, null, "'('", "')'", "'null'", null, null, null, null, null, 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
			"NE", "LIKE", "BETWEEN", "LPAREN", "RPAREN", "NULL", "IN", "LIMIT", "ORDERBY", 
			"ASC", "DESC", "COMMA", "IDENTIFIER", "POS_INTEGER", "DECIMAL", "SINGLE_STRING", 
			"DOUBLE_STRING", "EMPTY_SINGLE_STRING", "EMPTY_DOUBLE_STRING", "WS", 
			"DATE", "DATETIME"
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
		public OrderbyexprContext orderbyexpr() {
			return getRuleContext(OrderbyexprContext.class,0);
		}
		public LimitexprContext limitexpr() {
			return getRuleContext(LimitexprContext.class,0);
		}
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
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				expression(0);
				setState(47);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				orderbyexpr();
				setState(50);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				limitexpr();
				setState(53);
				match(EOF);
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

	public static class LimitexprContext extends ParserRuleContext {
		public LimitexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitexpr; }
	 
		public LimitexprContext() { }
		public void copyFrom(LimitexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LimitExpressionContext extends LimitexprContext {
		public LimitContext op;
		public CountContext right;
		public ExpressionContext left;
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public CountContext count() {
			return getRuleContext(CountContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OrderbyexprContext orderbyexpr() {
			return getRuleContext(OrderbyexprContext.class,0);
		}
		public LimitExpressionContext(LimitexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterLimitExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitLimitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitLimitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LimitexprContext limitexpr() throws RecognitionException {
		LimitexprContext _localctx = new LimitexprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_limitexpr);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new LimitExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((LimitExpressionContext)_localctx).op = limit();
				setState(58);
				((LimitExpressionContext)_localctx).right = count();
				}
				break;
			case 2:
				_localctx = new LimitExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((LimitExpressionContext)_localctx).left = expression(0);
				setState(61);
				((LimitExpressionContext)_localctx).op = limit();
				setState(62);
				((LimitExpressionContext)_localctx).right = count();
				}
				break;
			case 3:
				_localctx = new LimitExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				orderbyexpr();
				setState(65);
				((LimitExpressionContext)_localctx).op = limit();
				setState(66);
				((LimitExpressionContext)_localctx).right = count();
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

	public static class OrderbyexprContext extends ParserRuleContext {
		public OrderbyexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderbyexpr; }
	 
		public OrderbyexprContext() { }
		public void copyFrom(OrderbyexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OrderByExpressionContext extends OrderbyexprContext {
		public OrderbyContext op;
		public OrderContext right;
		public ExpressionContext left;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public OrderbyContext orderby() {
			return getRuleContext(OrderbyContext.class,0);
		}
		public OrderContext order() {
			return getRuleContext(OrderContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CustomConnectorQueryFilterParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CustomConnectorQueryFilterParser.COMMA, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OrderByExpressionContext(OrderbyexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterOrderByExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitOrderByExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitOrderByExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderbyexprContext orderbyexpr() throws RecognitionException {
		OrderbyexprContext _localctx = new OrderbyexprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_orderbyexpr);
		int _la;
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ORDERBY:
				_localctx = new OrderByExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				((OrderByExpressionContext)_localctx).op = orderby();
				setState(71);
				identifier();
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(72);
					match(COMMA);
					setState(73);
					identifier();
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				((OrderByExpressionContext)_localctx).right = order();
				}
				break;
			case NOT:
			case LPAREN:
			case NULL:
			case IDENTIFIER:
			case POS_INTEGER:
			case DECIMAL:
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case EMPTY_SINGLE_STRING:
			case EMPTY_DOUBLE_STRING:
			case DATE:
			case DATETIME:
				_localctx = new OrderByExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				((OrderByExpressionContext)_localctx).left = expression(0);
				setState(82);
				((OrderByExpressionContext)_localctx).op = orderby();
				setState(83);
				identifier();
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(84);
					match(COMMA);
					setState(85);
					identifier();
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91);
				((OrderByExpressionContext)_localctx).right = order();
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(96);
				match(LPAREN);
				setState(97);
				expression(0);
				setState(98);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(NOT);
				setState(101);
				expression(16);
				}
				break;
			case 3:
				{
				_localctx = new GreaterThanComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				((GreaterThanComparatorExpressionContext)_localctx).left = identifier();
				setState(103);
				((GreaterThanComparatorExpressionContext)_localctx).op = gtComparator();
				setState(104);
				((GreaterThanComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 4:
				{
				_localctx = new GreaterThanEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				((GreaterThanEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(107);
				((GreaterThanEqualToComparatorExpressionContext)_localctx).op = geComparator();
				setState(108);
				((GreaterThanEqualToComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 5:
				{
				_localctx = new LesserThanComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				((LesserThanComparatorExpressionContext)_localctx).left = identifier();
				setState(111);
				((LesserThanComparatorExpressionContext)_localctx).op = ltComparator();
				setState(112);
				((LesserThanComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 6:
				{
				_localctx = new LesserThanEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				((LesserThanEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(115);
				((LesserThanEqualToComparatorExpressionContext)_localctx).op = leComparator();
				setState(116);
				((LesserThanEqualToComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 7:
				{
				_localctx = new EqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				((EqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(119);
				((EqualToComparatorExpressionContext)_localctx).op = eqComparator();
				setState(120);
				((EqualToComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 8:
				{
				_localctx = new BoolEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				((BoolEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(123);
				((BoolEqualToComparatorExpressionContext)_localctx).op = eqComparator();
				setState(124);
				((BoolEqualToComparatorExpressionContext)_localctx).right = bool();
				}
				break;
			case 9:
				{
				_localctx = new NotEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				((NotEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(127);
				((NotEqualToComparatorExpressionContext)_localctx).op = neComparator();
				setState(128);
				((NotEqualToComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 10:
				{
				_localctx = new BoolNotEqualToComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				((BoolNotEqualToComparatorExpressionContext)_localctx).left = identifier();
				setState(131);
				((BoolNotEqualToComparatorExpressionContext)_localctx).op = neComparator();
				setState(132);
				((BoolNotEqualToComparatorExpressionContext)_localctx).right = bool();
				}
				break;
			case 11:
				{
				_localctx = new LikeComparatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				((LikeComparatorExpressionContext)_localctx).left = identifier();
				setState(135);
				((LikeComparatorExpressionContext)_localctx).op = likeComparator();
				setState(136);
				((LikeComparatorExpressionContext)_localctx).right = value();
				}
				break;
			case 12:
				{
				_localctx = new BetweenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(138);
				((BetweenExpressionContext)_localctx).left = identifier();
				setState(139);
				((BetweenExpressionContext)_localctx).op = betweenComparator();
				{
				setState(140);
				((BetweenExpressionContext)_localctx).l1 = value();
				setState(141);
				((BetweenExpressionContext)_localctx).op1 = andBinary();
				setState(142);
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
				setState(144);
				identifier();
				}
				break;
			case 14:
				{
				_localctx = new ValueExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				value();
				}
				break;
			case 15:
				{
				_localctx = new InExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				identifier();
				setState(147);
				((InExpressionContext)_localctx).op = in();
				setState(148);
				match(LPAREN);
				setState(149);
				value();
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(150);
					match(COMMA);
					setState(151);
					value();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(169);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ANDBinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ANDBinaryExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(161);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(162);
						((ANDBinaryExpressionContext)_localctx).op = andBinary();
						setState(163);
						((ANDBinaryExpressionContext)_localctx).right = expression(16);
						}
						break;
					case 2:
						{
						_localctx = new ORBinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ORBinaryExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(165);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(166);
						((ORBinaryExpressionContext)_localctx).op = orBinary();
						setState(167);
						((ORBinaryExpressionContext)_localctx).right = expression(15);
						}
						break;
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 8, RULE_gtComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
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
		enterRule(_localctx, 10, RULE_geComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
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
		enterRule(_localctx, 12, RULE_ltComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
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
		enterRule(_localctx, 14, RULE_leComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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
		enterRule(_localctx, 16, RULE_eqComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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
		enterRule(_localctx, 18, RULE_neComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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
		enterRule(_localctx, 20, RULE_likeComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
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
		enterRule(_localctx, 22, RULE_betweenComparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
		enterRule(_localctx, 24, RULE_andBinary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
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
		enterRule(_localctx, 26, RULE_orBinary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
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
		enterRule(_localctx, 28, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
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
		enterRule(_localctx, 30, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
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
		enterRule(_localctx, 32, RULE_in);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
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

	public static class LimitContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(CustomConnectorQueryFilterParser.LIMIT, 0); }
		public LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterLimit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitLimit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitLimit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LimitContext limit() throws RecognitionException {
		LimitContext _localctx = new LimitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(LIMIT);
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

	public static class OrderbyContext extends ParserRuleContext {
		public TerminalNode ORDERBY() { return getToken(CustomConnectorQueryFilterParser.ORDERBY, 0); }
		public OrderbyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderby; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterOrderby(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitOrderby(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitOrderby(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderbyContext orderby() throws RecognitionException {
		OrderbyContext _localctx = new OrderbyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_orderby);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(ORDERBY);
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

	public static class OrderContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(CustomConnectorQueryFilterParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(CustomConnectorQueryFilterParser.DESC, 0); }
		public OrderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterOrder(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitOrder(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitOrder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderContext order() throws RecognitionException {
		OrderContext _localctx = new OrderContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_order);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_la = _input.LA(1);
			if ( !(_la==ASC || _la==DESC) ) {
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
		enterRule(_localctx, 40, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
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
		public TerminalNode POS_INTEGER() { return getToken(CustomConnectorQueryFilterParser.POS_INTEGER, 0); }
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
		enterRule(_localctx, 42, RULE_value);
		try {
			setState(213);
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
				setState(208);
				string();
				}
				break;
			case POS_INTEGER:
				_localctx = new DecimalValueExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(POS_INTEGER);
				}
				break;
			case DECIMAL:
				_localctx = new DecimalValueExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				match(DECIMAL);
				}
				break;
			case DATE:
				_localctx = new IsoDateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				match(DATE);
				}
				break;
			case DATETIME:
				_localctx = new IsoDateTimeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
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

	public static class CountContext extends ParserRuleContext {
		public CountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_count; }
	 
		public CountContext() { }
		public void copyFrom(CountContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CountValueExpressionContext extends CountContext {
		public TerminalNode POS_INTEGER() { return getToken(CustomConnectorQueryFilterParser.POS_INTEGER, 0); }
		public CountValueExpressionContext(CountContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).enterCountValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CustomConnectorQueryFilterParserListener ) ((CustomConnectorQueryFilterParserListener)listener).exitCountValueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CustomConnectorQueryFilterParserVisitor ) return ((CustomConnectorQueryFilterParserVisitor<? extends T>)visitor).visitCountValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CountContext count() throws RecognitionException {
		CountContext _localctx = new CountContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_count);
		try {
			_localctx = new CountValueExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(POS_INTEGER);
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
		case 3:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00dc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2:\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3G\n\3\3\4\3\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\3\4\5\4`\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\7\5\u009b\n\5\f\5\16\5\u009e\13\5\3\5\3\5\5\5\u00a2\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00ac\n\5\f\5\16\5\u00af\13\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u00d8\n\27\3\30\3\30\3\30\2\3\b\31"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\5\3\2\6\7\3\2\26\27"+
		"\4\2\22\22\34\37\2\u00e0\29\3\2\2\2\4F\3\2\2\2\6_\3\2\2\2\b\u00a1\3\2"+
		"\2\2\n\u00b0\3\2\2\2\f\u00b2\3\2\2\2\16\u00b4\3\2\2\2\20\u00b6\3\2\2\2"+
		"\22\u00b8\3\2\2\2\24\u00ba\3\2\2\2\26\u00bc\3\2\2\2\30\u00be\3\2\2\2\32"+
		"\u00c0\3\2\2\2\34\u00c2\3\2\2\2\36\u00c4\3\2\2\2 \u00c6\3\2\2\2\"\u00c8"+
		"\3\2\2\2$\u00ca\3\2\2\2&\u00cc\3\2\2\2(\u00ce\3\2\2\2*\u00d0\3\2\2\2,"+
		"\u00d7\3\2\2\2.\u00d9\3\2\2\2\60\61\5\b\5\2\61\62\7\2\2\3\62:\3\2\2\2"+
		"\63\64\5\6\4\2\64\65\7\2\2\3\65:\3\2\2\2\66\67\5\4\3\2\678\7\2\2\38:\3"+
		"\2\2\29\60\3\2\2\29\63\3\2\2\29\66\3\2\2\2:\3\3\2\2\2;<\5$\23\2<=\5.\30"+
		"\2=G\3\2\2\2>?\5\b\5\2?@\5$\23\2@A\5.\30\2AG\3\2\2\2BC\5\6\4\2CD\5$\23"+
		"\2DE\5.\30\2EG\3\2\2\2F;\3\2\2\2F>\3\2\2\2FB\3\2\2\2G\5\3\2\2\2HI\5&\24"+
		"\2IN\5 \21\2JK\7\30\2\2KM\5 \21\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2"+
		"\2\2OQ\3\2\2\2PN\3\2\2\2QR\5(\25\2R`\3\2\2\2ST\5\b\5\2TU\5&\24\2UZ\5 "+
		"\21\2VW\7\30\2\2WY\5 \21\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]"+
		"\3\2\2\2\\Z\3\2\2\2]^\5(\25\2^`\3\2\2\2_H\3\2\2\2_S\3\2\2\2`\7\3\2\2\2"+
		"ab\b\5\1\2bc\7\20\2\2cd\5\b\5\2de\7\21\2\2e\u00a2\3\2\2\2fg\7\5\2\2g\u00a2"+
		"\5\b\5\22hi\5 \21\2ij\5\n\6\2jk\5,\27\2k\u00a2\3\2\2\2lm\5 \21\2mn\5\f"+
		"\7\2no\5,\27\2o\u00a2\3\2\2\2pq\5 \21\2qr\5\16\b\2rs\5,\27\2s\u00a2\3"+
		"\2\2\2tu\5 \21\2uv\5\20\t\2vw\5,\27\2w\u00a2\3\2\2\2xy\5 \21\2yz\5\22"+
		"\n\2z{\5,\27\2{\u00a2\3\2\2\2|}\5 \21\2}~\5\22\n\2~\177\5\36\20\2\177"+
		"\u00a2\3\2\2\2\u0080\u0081\5 \21\2\u0081\u0082\5\24\13\2\u0082\u0083\5"+
		",\27\2\u0083\u00a2\3\2\2\2\u0084\u0085\5 \21\2\u0085\u0086\5\24\13\2\u0086"+
		"\u0087\5\36\20\2\u0087\u00a2\3\2\2\2\u0088\u0089\5 \21\2\u0089\u008a\5"+
		"\26\f\2\u008a\u008b\5,\27\2\u008b\u00a2\3\2\2\2\u008c\u008d\5 \21\2\u008d"+
		"\u008e\5\30\r\2\u008e\u008f\5,\27\2\u008f\u0090\5\32\16\2\u0090\u0091"+
		"\5,\27\2\u0091\u00a2\3\2\2\2\u0092\u00a2\5 \21\2\u0093\u00a2\5,\27\2\u0094"+
		"\u0095\5 \21\2\u0095\u0096\5\"\22\2\u0096\u0097\7\20\2\2\u0097\u009c\5"+
		",\27\2\u0098\u0099\7\30\2\2\u0099\u009b\5,\27\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7\21\2\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"a\3\2\2\2\u00a1f\3\2\2\2\u00a1h\3\2\2\2\u00a1l\3\2\2\2\u00a1p\3\2\2\2"+
		"\u00a1t\3\2\2\2\u00a1x\3\2\2\2\u00a1|\3\2\2\2\u00a1\u0080\3\2\2\2\u00a1"+
		"\u0084\3\2\2\2\u00a1\u0088\3\2\2\2\u00a1\u008c\3\2\2\2\u00a1\u0092\3\2"+
		"\2\2\u00a1\u0093\3\2\2\2\u00a1\u0094\3\2\2\2\u00a2\u00ad\3\2\2\2\u00a3"+
		"\u00a4\f\21\2\2\u00a4\u00a5\5\32\16\2\u00a5\u00a6\5\b\5\22\u00a6\u00ac"+
		"\3\2\2\2\u00a7\u00a8\f\20\2\2\u00a8\u00a9\5\34\17\2\u00a9\u00aa\5\b\5"+
		"\21\u00aa\u00ac\3\2\2\2\u00ab\u00a3\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\t\3\2\2\2"+
		"\u00af\u00ad\3\2\2\2\u00b0\u00b1\7\b\2\2\u00b1\13\3\2\2\2\u00b2\u00b3"+
		"\7\t\2\2\u00b3\r\3\2\2\2\u00b4\u00b5\7\n\2\2\u00b5\17\3\2\2\2\u00b6\u00b7"+
		"\7\13\2\2\u00b7\21\3\2\2\2\u00b8\u00b9\7\f\2\2\u00b9\23\3\2\2\2\u00ba"+
		"\u00bb\7\r\2\2\u00bb\25\3\2\2\2\u00bc\u00bd\7\16\2\2\u00bd\27\3\2\2\2"+
		"\u00be\u00bf\7\17\2\2\u00bf\31\3\2\2\2\u00c0\u00c1\7\3\2\2\u00c1\33\3"+
		"\2\2\2\u00c2\u00c3\7\4\2\2\u00c3\35\3\2\2\2\u00c4\u00c5\t\2\2\2\u00c5"+
		"\37\3\2\2\2\u00c6\u00c7\7\31\2\2\u00c7!\3\2\2\2\u00c8\u00c9\7\23\2\2\u00c9"+
		"#\3\2\2\2\u00ca\u00cb\7\24\2\2\u00cb%\3\2\2\2\u00cc\u00cd\7\25\2\2\u00cd"+
		"\'\3\2\2\2\u00ce\u00cf\t\3\2\2\u00cf)\3\2\2\2\u00d0\u00d1\t\4\2\2\u00d1"+
		"+\3\2\2\2\u00d2\u00d8\5*\26\2\u00d3\u00d8\7\32\2\2\u00d4\u00d8\7\33\2"+
		"\2\u00d5\u00d8\7!\2\2\u00d6\u00d8\7\"\2\2\u00d7\u00d2\3\2\2\2\u00d7\u00d3"+
		"\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8"+
		"-\3\2\2\2\u00d9\u00da\7\32\2\2\u00da/\3\2\2\2\f9FNZ_\u009c\u00a1\u00ab"+
		"\u00ad\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
