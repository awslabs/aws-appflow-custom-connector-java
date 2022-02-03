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
package com.amazonaws.appflow.custom.connector.queryfilter;

import org.antlr.v4.runtime.tree.ParseTree;

import com.amazonaws.appflow.custom.connector.queryfilter.antlr.CustomConnectorQueryFilterParserBaseVisitor;
import com.amazonaws.appflow.custom.connector.queryfilter.antlr.CustomConnectorQueryFilterParser;

public class TestQueryFilterExpressionVisitor extends CustomConnectorQueryFilterParserBaseVisitor<Integer> {

    //Returns the total number of expressions visited in the parse tree
    private Integer countOfExpressionsVisited = 0;

    @Override
    public Integer visit(ParseTree tree) {
        countOfExpressionsVisited = 0; // clear the previous state before new visit
        super.visit(tree);
        return countOfExpressionsVisited;
    }

    @Override
    public Integer visitLesserThanComparatorExpression(CustomConnectorQueryFilterParser.LesserThanComparatorExpressionContext ctx) {
        //Increases the count if 'a < 30' type of expressions are visited
        countOfExpressionsVisited++;
        return super.visitLesserThanComparatorExpression(ctx);
    }

    @Override
    public Integer visitGreaterThanComparatorExpression(CustomConnectorQueryFilterParser.GreaterThanComparatorExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitGreaterThanComparatorExpression(ctx);
    }

    @Override
    public Integer visitValueExpression(CustomConnectorQueryFilterParser.ValueExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitValueExpression(ctx);
    }

    @Override
    public Integer visitIdentifierExpression(CustomConnectorQueryFilterParser.IdentifierExpressionContext ctx) {
        return super.visitIdentifierExpression(ctx);
    }

    @Override
    public Integer visitNotExpression(CustomConnectorQueryFilterParser.NotExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitNotExpression(ctx);
    }

    @Override
    public Integer visitParenExpression(CustomConnectorQueryFilterParser.ParenExpressionContext ctx) {
        return super.visitParenExpression(ctx);
    }

    @Override
    public Integer visitORBinaryExpression(CustomConnectorQueryFilterParser.ORBinaryExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitORBinaryExpression(ctx);
    }

    @Override
    public Integer visitEqualToComparatorExpression(CustomConnectorQueryFilterParser.EqualToComparatorExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitEqualToComparatorExpression(ctx);
    }

    @Override
    public Integer visitBetweenExpression(CustomConnectorQueryFilterParser.BetweenExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitBetweenExpression(ctx);
    }

    @Override
    public Integer visitInExpression(CustomConnectorQueryFilterParser.InExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitInExpression(ctx);
    }

    @Override
    public Integer visitGreaterThanEqualToComparatorExpression(CustomConnectorQueryFilterParser.GreaterThanEqualToComparatorExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitGreaterThanEqualToComparatorExpression(ctx);
    }

    @Override
    public Integer visitLikeComparatorExpression(CustomConnectorQueryFilterParser.LikeComparatorExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitLikeComparatorExpression(ctx);
    }

    @Override
    public Integer visitLesserThanEqualToComparatorExpression(CustomConnectorQueryFilterParser.LesserThanEqualToComparatorExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitLesserThanEqualToComparatorExpression(ctx);
    }

    @Override
    public Integer visitNotEqualToComparatorExpression(CustomConnectorQueryFilterParser.NotEqualToComparatorExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitNotEqualToComparatorExpression(ctx);
    }

    @Override
    public Integer visitANDBinaryExpression(CustomConnectorQueryFilterParser.ANDBinaryExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitANDBinaryExpression(ctx);
    }

    @Override
    public Integer visitStringValueExpression(CustomConnectorQueryFilterParser.StringValueExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitStringValueExpression(ctx);
    }

    @Override
    public Integer visitDecimalValueExpression(CustomConnectorQueryFilterParser.DecimalValueExpressionContext ctx) {
        countOfExpressionsVisited++;
        return super.visitDecimalValueExpression(ctx);
    }

    @Override
    public Integer visitIsoDate(CustomConnectorQueryFilterParser.IsoDateContext ctx) {
        countOfExpressionsVisited++;
        return super.visitIsoDate(ctx);
    }

    @Override
    public Integer visitIsoDateTime(CustomConnectorQueryFilterParser.IsoDateTimeContext ctx) {
        countOfExpressionsVisited++;
        return super.visitIsoDateTime(ctx);
    }
}
