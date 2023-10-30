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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CustomConnectorQueryFilterParser}.
 */
public interface CustomConnectorQueryFilterParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#queryfilter}.
	 * @param ctx the parse tree
	 */
	void enterQueryfilter(CustomConnectorQueryFilterParser.QueryfilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#queryfilter}.
	 * @param ctx the parse tree
	 */
	void exitQueryfilter(CustomConnectorQueryFilterParser.QueryfilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code limitExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#limitexpr}.
	 * @param ctx the parse tree
	 */
	void enterLimitExpression(CustomConnectorQueryFilterParser.LimitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code limitExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#limitexpr}.
	 * @param ctx the parse tree
	 */
	void exitLimitExpression(CustomConnectorQueryFilterParser.LimitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orderByExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#orderbyexpr}.
	 * @param ctx the parse tree
	 */
	void enterOrderByExpression(CustomConnectorQueryFilterParser.OrderByExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orderByExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#orderbyexpr}.
	 * @param ctx the parse tree
	 */
	void exitOrderByExpression(CustomConnectorQueryFilterParser.OrderByExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lesserThanComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLesserThanComparatorExpression(CustomConnectorQueryFilterParser.LesserThanComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lesserThanComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLesserThanComparatorExpression(CustomConnectorQueryFilterParser.LesserThanComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterThanComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanComparatorExpression(CustomConnectorQueryFilterParser.GreaterThanComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterThanComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanComparatorExpression(CustomConnectorQueryFilterParser.GreaterThanComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolNotEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolNotEqualToComparatorExpression(CustomConnectorQueryFilterParser.BoolNotEqualToComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolNotEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolNotEqualToComparatorExpression(CustomConnectorQueryFilterParser.BoolNotEqualToComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpression(CustomConnectorQueryFilterParser.ValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpression(CustomConnectorQueryFilterParser.ValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(CustomConnectorQueryFilterParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(CustomConnectorQueryFilterParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(CustomConnectorQueryFilterParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(CustomConnectorQueryFilterParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(CustomConnectorQueryFilterParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(CustomConnectorQueryFilterParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolEqualToComparatorExpression(CustomConnectorQueryFilterParser.BoolEqualToComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolEqualToComparatorExpression(CustomConnectorQueryFilterParser.BoolEqualToComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oRBinaryExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterORBinaryExpression(CustomConnectorQueryFilterParser.ORBinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oRBinaryExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitORBinaryExpression(CustomConnectorQueryFilterParser.ORBinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualToComparatorExpression(CustomConnectorQueryFilterParser.EqualToComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualToComparatorExpression(CustomConnectorQueryFilterParser.EqualToComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code betweenExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBetweenExpression(CustomConnectorQueryFilterParser.BetweenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code betweenExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBetweenExpression(CustomConnectorQueryFilterParser.BetweenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(CustomConnectorQueryFilterParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(CustomConnectorQueryFilterParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterThanEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanEqualToComparatorExpression(CustomConnectorQueryFilterParser.GreaterThanEqualToComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterThanEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanEqualToComparatorExpression(CustomConnectorQueryFilterParser.GreaterThanEqualToComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code likeComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLikeComparatorExpression(CustomConnectorQueryFilterParser.LikeComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code likeComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLikeComparatorExpression(CustomConnectorQueryFilterParser.LikeComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lesserThanEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLesserThanEqualToComparatorExpression(CustomConnectorQueryFilterParser.LesserThanEqualToComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lesserThanEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLesserThanEqualToComparatorExpression(CustomConnectorQueryFilterParser.LesserThanEqualToComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualToComparatorExpression(CustomConnectorQueryFilterParser.NotEqualToComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualToComparatorExpression(CustomConnectorQueryFilterParser.NotEqualToComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aNDBinaryExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterANDBinaryExpression(CustomConnectorQueryFilterParser.ANDBinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aNDBinaryExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitANDBinaryExpression(CustomConnectorQueryFilterParser.ANDBinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#gtComparator}.
	 * @param ctx the parse tree
	 */
	void enterGtComparator(CustomConnectorQueryFilterParser.GtComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#gtComparator}.
	 * @param ctx the parse tree
	 */
	void exitGtComparator(CustomConnectorQueryFilterParser.GtComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#geComparator}.
	 * @param ctx the parse tree
	 */
	void enterGeComparator(CustomConnectorQueryFilterParser.GeComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#geComparator}.
	 * @param ctx the parse tree
	 */
	void exitGeComparator(CustomConnectorQueryFilterParser.GeComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#ltComparator}.
	 * @param ctx the parse tree
	 */
	void enterLtComparator(CustomConnectorQueryFilterParser.LtComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#ltComparator}.
	 * @param ctx the parse tree
	 */
	void exitLtComparator(CustomConnectorQueryFilterParser.LtComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#leComparator}.
	 * @param ctx the parse tree
	 */
	void enterLeComparator(CustomConnectorQueryFilterParser.LeComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#leComparator}.
	 * @param ctx the parse tree
	 */
	void exitLeComparator(CustomConnectorQueryFilterParser.LeComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#eqComparator}.
	 * @param ctx the parse tree
	 */
	void enterEqComparator(CustomConnectorQueryFilterParser.EqComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#eqComparator}.
	 * @param ctx the parse tree
	 */
	void exitEqComparator(CustomConnectorQueryFilterParser.EqComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#neComparator}.
	 * @param ctx the parse tree
	 */
	void enterNeComparator(CustomConnectorQueryFilterParser.NeComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#neComparator}.
	 * @param ctx the parse tree
	 */
	void exitNeComparator(CustomConnectorQueryFilterParser.NeComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#likeComparator}.
	 * @param ctx the parse tree
	 */
	void enterLikeComparator(CustomConnectorQueryFilterParser.LikeComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#likeComparator}.
	 * @param ctx the parse tree
	 */
	void exitLikeComparator(CustomConnectorQueryFilterParser.LikeComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#betweenComparator}.
	 * @param ctx the parse tree
	 */
	void enterBetweenComparator(CustomConnectorQueryFilterParser.BetweenComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#betweenComparator}.
	 * @param ctx the parse tree
	 */
	void exitBetweenComparator(CustomConnectorQueryFilterParser.BetweenComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#andBinary}.
	 * @param ctx the parse tree
	 */
	void enterAndBinary(CustomConnectorQueryFilterParser.AndBinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#andBinary}.
	 * @param ctx the parse tree
	 */
	void exitAndBinary(CustomConnectorQueryFilterParser.AndBinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#orBinary}.
	 * @param ctx the parse tree
	 */
	void enterOrBinary(CustomConnectorQueryFilterParser.OrBinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#orBinary}.
	 * @param ctx the parse tree
	 */
	void exitOrBinary(CustomConnectorQueryFilterParser.OrBinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(CustomConnectorQueryFilterParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(CustomConnectorQueryFilterParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(CustomConnectorQueryFilterParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(CustomConnectorQueryFilterParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#in}.
	 * @param ctx the parse tree
	 */
	void enterIn(CustomConnectorQueryFilterParser.InContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#in}.
	 * @param ctx the parse tree
	 */
	void exitIn(CustomConnectorQueryFilterParser.InContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#limit}.
	 * @param ctx the parse tree
	 */
	void enterLimit(CustomConnectorQueryFilterParser.LimitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#limit}.
	 * @param ctx the parse tree
	 */
	void exitLimit(CustomConnectorQueryFilterParser.LimitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#orderby}.
	 * @param ctx the parse tree
	 */
	void enterOrderby(CustomConnectorQueryFilterParser.OrderbyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#orderby}.
	 * @param ctx the parse tree
	 */
	void exitOrderby(CustomConnectorQueryFilterParser.OrderbyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#order}.
	 * @param ctx the parse tree
	 */
	void enterOrder(CustomConnectorQueryFilterParser.OrderContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#order}.
	 * @param ctx the parse tree
	 */
	void exitOrder(CustomConnectorQueryFilterParser.OrderContext ctx);
	/**
	 * Enter a parse tree produced by {@link CustomConnectorQueryFilterParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(CustomConnectorQueryFilterParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link CustomConnectorQueryFilterParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(CustomConnectorQueryFilterParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringValueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringValueExpression(CustomConnectorQueryFilterParser.StringValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringValueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringValueExpression(CustomConnectorQueryFilterParser.StringValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalValueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void enterDecimalValueExpression(CustomConnectorQueryFilterParser.DecimalValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalValueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void exitDecimalValueExpression(CustomConnectorQueryFilterParser.DecimalValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isoDate}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIsoDate(CustomConnectorQueryFilterParser.IsoDateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isoDate}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIsoDate(CustomConnectorQueryFilterParser.IsoDateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isoDateTime}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIsoDateTime(CustomConnectorQueryFilterParser.IsoDateTimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isoDateTime}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIsoDateTime(CustomConnectorQueryFilterParser.IsoDateTimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code countValueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#count}.
	 * @param ctx the parse tree
	 */
	void enterCountValueExpression(CustomConnectorQueryFilterParser.CountValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code countValueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#count}.
	 * @param ctx the parse tree
	 */
	void exitCountValueExpression(CustomConnectorQueryFilterParser.CountValueExpressionContext ctx);
}
