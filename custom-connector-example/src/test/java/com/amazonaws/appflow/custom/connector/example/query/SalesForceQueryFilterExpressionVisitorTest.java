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
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDataType;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableEntity;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableEntityDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableFieldDefinition;
import com.amazonaws.appflow.custom.connector.queryfilter.CustomConnectorParseTreeBuilder;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Test class to validate Salesforce query built by {@link SalesForceQueryFilterExpressionVisitor}
 */
public class SalesForceQueryFilterExpressionVisitorTest {

    private SalesForceQueryFilterExpressionVisitor salesForceQueryFilterExpressionVisitor;

    private static final String CREATED_DATE = "CreatedDate";
    private static final String ACCOUNT_NUMBER = "AccountNumber";
    private static final String ID = "Id";
    private static final String NAME = "Name";

    @BeforeEach
    void setupTestCase() {
        salesForceQueryFilterExpressionVisitor = new SalesForceQueryFilterExpressionVisitor(getTestEntityDefinition());
    }

    @ParameterizedTest
    @MethodSource("getTestFilterExpression")
    void testConversionFromFilterExpressionToSalesforceQuery(
            final String filterExpression,
            final String expectedWhereExpression,
            final String expectedOrderByExpression,
            final String expectedLimitExpression) {
        salesForceQueryFilterExpressionVisitor.visit(CustomConnectorParseTreeBuilder.parse(filterExpression));
        Triple<String, String, String> result = salesForceQueryFilterExpressionVisitor.getResult();
        Assertions.assertEquals(expectedWhereExpression, result.getLeft());
        Assertions.assertEquals(expectedOrderByExpression, result.getMiddle());
        Assertions.assertEquals(expectedLimitExpression, result.getRight());
    }

    private static Stream<Arguments> getTestFilterExpression() {
        return Stream.of(
                Arguments.of("Name = \"TestAccountName\"", "Name = 'TestAccountName'", "", ""),
                Arguments.of("Name = \"TestAccountName\" limit 100", "Name = 'TestAccountName'", "", "100"),
                Arguments.of("Name = \"TestAccountName\" order by Name asc", "Name = 'TestAccountName'", "Name asc", ""),
                Arguments.of("Name = \"TestAccountName\" order by Name, OS asc", "Name = 'TestAccountName'", "Name,OS asc", ""),
                Arguments.of("Name = \"TestAccountName\" order by Name, OS asc limit 100", "Name = 'TestAccountName'", "Name,OS asc", "100"),
                Arguments.of("order by Name, OS asc", "", "Name,OS asc", ""),
                Arguments.of("Id != '0016g00001cyrfiAAA' AND AccountNumber = 40",
                             "Id != '0016g00001cyrfiAAA' AND AccountNumber = 40", "", ""),
                Arguments.of("CreatedDate > 2021-04-20T10:30:35Z AND AccountNumber = 40",
                             "CreatedDate > 2021-04-20T10:30:35Z AND AccountNumber = 40", "", ""),
                Arguments.of("CreatedDate between 2021-04-20T10:30:35Z and 2021-04-25T10:30:35Z",
                             "CreatedDate > 2021-04-20T10:30:35.000+0000 and CreatedDate < 2021-04-25T10:30:35.000+0000", "", ""),
                Arguments.of("Id in (5, 7, 9, 10)",
                             "Id IN ('5','7','9','10')", "", ""),
                Arguments.of("Name = \"TestAccountName\" and Id in (5, 7, 9, 10) and AccountNumber > 100",
                             "Name = 'TestAccountName' and Id IN ('5','7','9','10') and AccountNumber > 100", "", ""),
                Arguments.of(
                        "(AccountNumber > 100 and ((CreatedDate < 2021-04-20T12:30:45Z and CreatedDate > 2021-04-21T15:45:49.234Z) and Name contains \"TestAccountName\"))",
                        "AccountNumber > 100 and CreatedDate < 2021-04-20T12:30:45Z and CreatedDate > " +
                        "2021-04-21T15:45:49.234Z and Name LIKE '%TestAccountName%'", "", ""),
                Arguments.of(
                        "(AccountNumber > 100 and ((CreatedDate < 2021-04-20T12:30:45Z and CreatedDate > 2021-04-21T15:45:49.234Z) and Name contains \"TestAccountName\")) limit 100",
                        "AccountNumber > 100 and CreatedDate < 2021-04-20T12:30:45Z and CreatedDate > " +
                        "2021-04-21T15:45:49.234Z and Name LIKE '%TestAccountName%'", "", "100"));
    }

    /**
     * Entity definition to capture meta data about the entity
     * @return
     */
    private EntityDefinition getTestEntityDefinition() {
        return ImmutableEntityDefinition.builder()
                                        .entity(ImmutableEntity.builder().entityIdentifier("Account").hasNestedEntities(false).build())
                                        .addFields(ImmutableFieldDefinition.builder()
                                                                           .fieldName(CREATED_DATE)
                                                                           .dataType(FieldDataType.DateTime)
                                                                           .dataTypeLabel("dateTime")
                                                                           .build(),
                                                   ImmutableFieldDefinition.builder().fieldName(NAME).dataType(FieldDataType.String).dataTypeLabel("String").build(),
                                                   ImmutableFieldDefinition.builder().fieldName(ID).dataType(FieldDataType.String).dataTypeLabel("String").build(),
                                                   ImmutableFieldDefinition.builder()
                                                                           .fieldName(ACCOUNT_NUMBER)
                                                                           .dataType(FieldDataType.Long)
                                                                           .dataTypeLabel("Long")
                                                                           .build())
                                        .build();
    }
}
