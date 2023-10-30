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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CustomConnectorQueryFilterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CustomConnectorQueryFilterParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#queryfilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryfilter(CustomConnectorQueryFilterParser.QueryfilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code limitExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#limitexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitExpression(CustomConnectorQueryFilterParser.LimitExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orderByExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#orderbyexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderByExpression(CustomConnectorQueryFilterParser.OrderByExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lesserThanComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLesserThanComparatorExpression(CustomConnectorQueryFilterParser.LesserThanComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterThanComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanComparatorExpression(CustomConnectorQueryFilterParser.GreaterThanComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolNotEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolNotEqualToComparatorExpression(CustomConnectorQueryFilterParser.BoolNotEqualToComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpression(CustomConnectorQueryFilterParser.ValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(CustomConnectorQueryFilterParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(CustomConnectorQueryFilterParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(CustomConnectorQueryFilterParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolEqualToComparatorExpression(CustomConnectorQueryFilterParser.BoolEqualToComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oRBinaryExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitORBinaryExpression(CustomConnectorQueryFilterParser.ORBinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualToComparatorExpression(CustomConnectorQueryFilterParser.EqualToComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenExpression(CustomConnectorQueryFilterParser.BetweenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(CustomConnectorQueryFilterParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterThanEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanEqualToComparatorExpression(CustomConnectorQueryFilterParser.GreaterThanEqualToComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code likeComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeComparatorExpression(CustomConnectorQueryFilterParser.LikeComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lesserThanEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLesserThanEqualToComparatorExpression(CustomConnectorQueryFilterParser.LesserThanEqualToComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notEqualToComparatorExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualToComparatorExpression(CustomConnectorQueryFilterParser.NotEqualToComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aNDBinaryExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitANDBinaryExpression(CustomConnectorQueryFilterParser.ANDBinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#gtComparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtComparator(CustomConnectorQueryFilterParser.GtComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#geComparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeComparator(CustomConnectorQueryFilterParser.GeComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#ltComparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtComparator(CustomConnectorQueryFilterParser.LtComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#leComparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeComparator(CustomConnectorQueryFilterParser.LeComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#eqComparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqComparator(CustomConnectorQueryFilterParser.EqComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#neComparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeComparator(CustomConnectorQueryFilterParser.NeComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#likeComparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeComparator(CustomConnectorQueryFilterParser.LikeComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#betweenComparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenComparator(CustomConnectorQueryFilterParser.BetweenComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#andBinary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndBinary(CustomConnectorQueryFilterParser.AndBinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#orBinary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrBinary(CustomConnectorQueryFilterParser.OrBinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(CustomConnectorQueryFilterParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(CustomConnectorQueryFilterParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#in}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(CustomConnectorQueryFilterParser.InContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#limit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimit(CustomConnectorQueryFilterParser.LimitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#orderby}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderby(CustomConnectorQueryFilterParser.OrderbyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#order}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder(CustomConnectorQueryFilterParser.OrderContext ctx);
	/**
	 * Visit a parse tree produced by {@link CustomConnectorQueryFilterParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(CustomConnectorQueryFilterParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringValueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValueExpression(CustomConnectorQueryFilterParser.StringValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalValueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalValueExpression(CustomConnectorQueryFilterParser.DecimalValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isoDate}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsoDate(CustomConnectorQueryFilterParser.IsoDateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isoDateTime}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsoDateTime(CustomConnectorQueryFilterParser.IsoDateTimeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code countValueExpression}
	 * labeled alternative in {@link CustomConnectorQueryFilterParser#count}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountValueExpression(CustomConnectorQueryFilterParser.CountValueExpressionContext ctx);
}
