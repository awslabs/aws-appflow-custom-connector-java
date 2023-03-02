/*
 * -
 *  * #%L
 * * Example Custom Connector.
 *  *
 * %%
 * Copyright (C) 2021 Amazon Web Services
 *  *
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
 *
 */

package com.amazonaws.appflow.custom.connector.example.query;

import com.amazonaws.appflow.custom.connector.model.metadata.EntityDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDataType;
import com.amazonaws.appflow.custom.connector.queryfilter.CustomConnectorParseTreeBuilder;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample Salesforce query builder. It might be deleted or method implementations might be changed after adding Antlr
 * parser code.
 */
public final class SalesforceQueryBuilder {
    private SalesforceQueryBuilder() {
    }

    private static final String CONDITION_FORMAT = "%s %s %s";
    private static final String WHERE_AND = " and ";
    private static final String CLAUSE_STRING_FORMAT = "%s %s";
    private static final String WHERE_CLAUSE = "where";
    private static final String FROM_CLAUSE = "from";
    private static final String SELECT_CLAUSE = "select";
    private static final String LIMIT_CLAUSE = "limit";

    public static String buildQuery(final QueryObject queryObject) {

        if (CollectionUtils.isEmpty(queryObject.selectedFieldNames())) {
            throw new IllegalArgumentException("No fields where selected for Salesforce Query");
        }
        final List<String> clauses = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        final String selectFields = String.join(", ", queryObject.selectedFieldNames());
        clauses.add(String.format(CLAUSE_STRING_FORMAT, SELECT_CLAUSE, selectFields));
        clauses.add(String.format(CLAUSE_STRING_FORMAT, FROM_CLAUSE, queryObject.sObject()));

        // QueryData allows data filtering based on filter expression.
        if (Strings.isNotBlank(queryObject.filterExpression())) {
            // adding filter expression in the query
            Pair<String, String> whereAndLimitClauses = translateFilterExpression(queryObject.filterExpression(), queryObject.entityDefinition());
            String whereClause = whereAndLimitClauses.getLeft();
            String limitClause = whereAndLimitClauses.getRight();
            if (StringUtils.isNotBlank(whereClause)) {
                clauses.add(String.format(CLAUSE_STRING_FORMAT, WHERE_CLAUSE, whereClause));
            }
            if (StringUtils.isNotBlank(limitClause)) {
                clauses.add(String.format(CLAUSE_STRING_FORMAT, LIMIT_CLAUSE, limitClause));
            }
        } else {
            // RetrieveData allows data filtering based on entity primary Id fields
            if (StringUtils.isNotBlank(queryObject.idFieldName()) && CollectionUtils.isNotEmpty(queryObject.fields()) &&
                StringUtils.isNotBlank(queryObject.dataType())) {
                conditions = addOrConditions("=", conditions, queryObject.idFieldName(), queryObject.fields(),
                                             queryObject.dataType());
            }
            if (CollectionUtils.isNotEmpty(conditions)) {
                final String whereClause = String.join(WHERE_AND, conditions);
                clauses.add(String.format(CLAUSE_STRING_FORMAT, WHERE_CLAUSE, whereClause));
            }
        }
        return String.join(" ", clauses);
    }

    private static List<String> addOrConditions(final String operator,
                                                final List<String> conditions,
                                                final String variable,
                                                final List<String> values,
                                                final String type) {
        final List<String> orConditions = new ArrayList<>();
        for (String value : values) {
            addCondition(operator, orConditions, variable, value, type);
        }
        // Add all the or conditions together in parentheses
        final String condition = "(" + String.join(" or ", orConditions) + ")";
        conditions.add(condition);
        return conditions;
    }

    private static List<String> addCondition(final String operator,
                                             final List<String> conditions,
                                             final String fieldName,
                                             final String value,
                                             final String type) {
        final String formattedValue = formatType(type, value);
        conditions.add(String.format(CONDITION_FORMAT, fieldName, operator, formattedValue));
        return conditions;
    }

    private static String formatType(final String type, final String value) {
        String formattedValue = value;

        // If the customer quoted the value we will reapply quotes after escaping internal quotes
        boolean customerQuoted = false;

        // Remove quotes from beginning and end of string.
        if (formattedValue.startsWith("'") || formattedValue.startsWith("\"")) {
            formattedValue = formattedValue.substring(1);
            customerQuoted = true;
        }
        if (formattedValue.endsWith("'") || formattedValue.endsWith("\"")) {
            formattedValue = formattedValue.substring(0, formattedValue.length() - 1);
            customerQuoted = true;
        }
        formattedValue = formattedValue.replace("'", "\\'");
        if (FieldDataType.Struct.name().equals(type) || customerQuoted) {
            return addSingleQuotes(formattedValue);
        }
        return formattedValue;
    }

    private static String addSingleQuotes(final String string) {
        return '\'' + string + '\'';
    }

    private static Pair<String, String> translateFilterExpression(final String filterExpression, final EntityDefinition entityDefinition) {
        if (StringUtils.isNotBlank(filterExpression)) {
            ParseTree parseTree = CustomConnectorParseTreeBuilder.parse(filterExpression);
            SalesForceQueryFilterExpressionVisitor salesForceQueryFilterExpressionVisitor = new SalesForceQueryFilterExpressionVisitor(entityDefinition);
            // visit the parse tree to convert the filter expression into salesforce filter query
            salesForceQueryFilterExpressionVisitor.visit(parseTree);
            // return the salesforce filter expression build by visiting the filter expression
            return salesForceQueryFilterExpressionVisitor.getResult();
        }
        // no filter expression is defined
        return Pair.of(StringUtils.EMPTY, StringUtils.EMPTY);
    }
}
