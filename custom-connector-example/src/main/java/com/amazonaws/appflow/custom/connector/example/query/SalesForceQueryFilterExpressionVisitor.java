/*-
 * #%L
 * custom-connector-example
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
package com.amazonaws.appflow.custom.connector.example.query;

import com.amazonaws.appflow.custom.connector.model.metadata.EntityDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDefinition;
import com.amazonaws.appflow.custom.connector.queryfilter.antlr.CustomConnectorQueryFilterParser;
import com.amazonaws.appflow.custom.connector.queryfilter.antlr.CustomConnectorQueryFilterParserBaseVisitor;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class is responsible to convert filter expression into Salesforce connector specific filter query.
 * Filter expression is passed in as instance of {@link org.antlr.v4.runtime.tree.ParseTree} and this class visits
 * all nodes to form Salesforce specific where clause of query.
 */
public class SalesForceQueryFilterExpressionVisitor extends CustomConnectorQueryFilterParserBaseVisitor<StringBuilder> {

    // helps build the WHERE-clause for Salesforce SOQL
    private final StringBuilder queryBuilder = new StringBuilder();

    // Caller will provide the entity definition for the queried entity. This holds field level metadata for the entity.
    private EntityDefinition entityDefinition;

    private static final String SPACE = " ";

    // Salesforce supported datatype of fields in entity
    public static final String DATE_TIME = "DateTime";
    public static final String DATE = "Date";
    private static final List<String> DATE_TYPES = Arrays.asList(DATE, DATE_TIME);
    private static final List<String> STRING_TYPES = Arrays.asList("String", "id", "textarea");
    private static final List<String> NON_STRING_TYPES = Arrays.asList("Boolean", "double",
            "Integer", "Float", "Double", "Short", "Long", "Currency");

    // Salesforce supported date formatting for building query. This formatting is applied on
    // filter expression values which has respective datatype mentioned into map
    private static final Map<String, DateTimeFormatter> FORMAT_TYPE_MAP =
            new HashMap<String, DateTimeFormatter>() {
            {
                    put(DATE, DateTimeFormatter.ofPattern("uuuu-MM-dd").withZone(ZoneId.of("UTC")));
                    put(DATE_TIME, DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSZ").withZone(ZoneId.of("UTC")));
            }
    };

    private static final String CONTAINS = "CONTAINS";

    // Salesforce supported logical operator
    private static final String CONDITION_FORMAT = "%s %s %s";
    private static final String LIKE = "LIKE";
    private static final String LOGICAL_AND = " and ";
    private static final String IN = " IN ";
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String COMPARISON_LESSER = "<";
    private static final String COMPARISON_GREATER = ">";

    // Formats the filter value corresponding to the field types
    // This formatting is specific to the underlying query syntax. This example shows Salesforce specific
    // formatting of filter values.
    private static final ValueFormatter FORMATTER = (String value, String type, String operator) -> {
        String formattedVal = value;
        boolean hasCustomQuotes = ValueFormatter.HAS_CUSTOM_QUOTES.test(value);
        if (hasCustomQuotes) {
            formattedVal = ValueFormatter.STRIP_QUOTES.apply(formattedVal);
        }
        formattedVal = ValueFormatter.REPLACE_SINGLE_QUOTES.apply(formattedVal);

        if (DATE_TYPES.contains(type)) {
            return ValueFormatter.FORMAT_DATE_TYPE.apply(formattedVal, type);
        }
        if (STRING_TYPES.contains(type) || (hasCustomQuotes && !NON_STRING_TYPES.contains(type))) {
            return ValueFormatter.ADD_WILD_CARDS.andThen(ValueFormatter.ADD_SINGLE_QUOTES).apply(
                    formattedVal, operator);
        }
        return formattedVal;
    };

    // constructor
    public SalesForceQueryFilterExpressionVisitor(final EntityDefinition entityDefinition) {
        Objects.requireNonNull(entityDefinition,
                "entityDefinition can't be null as it is required for building filter query");
        this.entityDefinition = entityDefinition;
    }

    @Override
    public StringBuilder visitBetweenExpression(final CustomConnectorQueryFilterParser.BetweenExpressionContext ctx) {
        if (ctx.getChildCount() == 5) {
            String identifier = ctx.getChild(0).getText();
            String lowerBound = ctx.getChild(2).getText();
            String upperBound = ctx.getChild(4).getText();
            // Identify the datatype of identifier and format it accordingly while building query
            String dataType = getFieldDatatype(ctx.getChild(0).getText()).dataType().name();
            return queryBuilder
                    .append(String.format(CONDITION_FORMAT, identifier, COMPARISON_GREATER,
                            FORMATTER.formatValue(lowerBound, dataType, COMPARISON_GREATER)))
                    .append(LOGICAL_AND)
                    .append(String.format(CONDITION_FORMAT, identifier, COMPARISON_LESSER,
                            FORMATTER.formatValue(upperBound, dataType, COMPARISON_LESSER)));
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitInExpression(final CustomConnectorQueryFilterParser.InExpressionContext ctx) {
        if (ctx.value().size() > 0) {
            String identifier = ctx.getChild(0).getText();
            String dataType = getFieldDatatype(identifier).dataType().name();
            queryBuilder.append(identifier).append(IN).append(LEFT_PARENTHESIS); // setting up the IN clause
            List<CustomConnectorQueryFilterParser.ValueContext>  inClauseValues = ctx.value();
            String values = inClauseValues.stream().map(valueContext -> FORMATTER
                    .formatValue(valueContext.getText(), dataType, null))
                    .collect(Collectors.joining(","));
            queryBuilder.append(values).append(RIGHT_PARENTHESIS);
            return queryBuilder; // There are no child nodes to visit further
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitGreaterThanEqualToComparatorExpression(
            final CustomConnectorQueryFilterParser.GreaterThanEqualToComparatorExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitGtComparator(final CustomConnectorQueryFilterParser.GtComparatorContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitGeComparator(final CustomConnectorQueryFilterParser.GeComparatorContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitLtComparator(final CustomConnectorQueryFilterParser.LtComparatorContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitLeComparator(final CustomConnectorQueryFilterParser.LeComparatorContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitEqComparator(final CustomConnectorQueryFilterParser.EqComparatorContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitNeComparator(final CustomConnectorQueryFilterParser.NeComparatorContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitLikeComparator(final CustomConnectorQueryFilterParser.LikeComparatorContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(LIKE).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitBetweenComparator(final CustomConnectorQueryFilterParser.BetweenComparatorContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitAndBinary(final CustomConnectorQueryFilterParser.AndBinaryContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitOrBinary(final CustomConnectorQueryFilterParser.OrBinaryContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitIdentifier(final CustomConnectorQueryFilterParser.IdentifierContext ctx) {
        // This will add space between operator and operand
        if (ctx.getChildCount() == 1) {
            return queryBuilder.append(ctx.getText()).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitStringValueExpression(
            final CustomConnectorQueryFilterParser.StringValueExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            // get the datatype of identifier and format the value accordingly
            String dataType = getFieldDatatype(ctx.getParent().getChild(0).getText()).dataType().name();
            String value = FORMATTER.formatValue(ctx.getText(), dataType, ctx.getParent().getChild(1).getText());
            return queryBuilder.append(value).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitDecimalValueExpression(
            final CustomConnectorQueryFilterParser.DecimalValueExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            // get the datatype of identifier and format the value accordingly
            String dataType = getFieldDatatype(ctx.getParent().getChild(0).getText()).dataType().name();
            String value = FORMATTER.formatValue(ctx.getText(), dataType, ctx.getParent().getChild(1).getText());
            return queryBuilder.append(value).append(SPACE);
        }
        return visitChildren(ctx);
    }

    @Override
    public StringBuilder visitIsoDate(final CustomConnectorQueryFilterParser.IsoDateContext ctx) {
        return queryBuilder.append(ctx.getText());
    }

    @Override
    public StringBuilder visitIsoDateTime(final CustomConnectorQueryFilterParser.IsoDateTimeContext ctx) {
        return queryBuilder.append(OffsetDateTime.parse(ctx.getText()).toInstant().toString());
    }

    /**
     * Returns the final query expression built for Salesforce
     */
    public String getResult() {
        return queryBuilder.toString();
    }

    @FunctionalInterface
    interface ValueFormatter {
        Predicate<String> HAS_CUSTOM_QUOTES = val -> (val.startsWith("'") || val.startsWith("\"")) && (val.endsWith("'")
                || val.endsWith("\""));
        Function<String, String> STRIP_QUOTES = val -> val.substring(1, val.length() - 1);
        Function<String, String> REPLACE_SINGLE_QUOTES = val -> val.replace("'", "\\'");
        BiFunction<String, String, String> ADD_WILD_CARDS =
                (val, operator) -> CONTAINS.equalsIgnoreCase(operator) && !val.contains("%")
                ? "%" + val + "%" : val;
        BiFunction<String, String, String> FORMAT_DATE_TYPE = (val, type) -> {
            if (DATE.equals(type)) {
                // This does not handle the use-case where type was Date and passed in value is ISO 8601 date time
                return FORMAT_TYPE_MAP.get(type).format(LocalDate.parse(val));
            }
            // This does not handle the use-case where type was DateTime and passed in value is ISO 8601 date
            return FORMAT_TYPE_MAP.get(type).format(Instant.parse(val));
        };
        Function<String, String> ADD_SINGLE_QUOTES = val -> "'" + val + "'";

        String formatValue(String value, String type, String operator);
    }

    /**
     * Method to find fieldDefinition object for given fieldName. This definition contains datatype supported by
     * field and contains other useful metadata information required to build filter clause.
     *
     * @param fieldName
     */
    private FieldDefinition getFieldDatatype(final String fieldName) {
        return entityDefinition.fields().stream()
                .filter(field -> StringUtils.equals(field.fieldName(), fieldName))
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        "Filter attribute not found in entity definition"));
    }
}
