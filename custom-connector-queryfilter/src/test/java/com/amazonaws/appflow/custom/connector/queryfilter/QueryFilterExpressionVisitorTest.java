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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Test class to validate parse tree traversal logic
 */
public class QueryFilterExpressionVisitorTest {

    // Creating the instance of object under test
    TestQueryFilterExpressionVisitor testQueryFilterExpressionVisitor = new TestQueryFilterExpressionVisitor();

    @ParameterizedTest
    @MethodSource("getValidFilterExpression")
    void testCountOfExpressionVisited(final String filterExpression, final int expectedCountOfExpressionVisited) {
        ParseTree parseTree = CustomConnectorParseTreeBuilder.parse(filterExpression);
        Assertions.assertEquals(expectedCountOfExpressionVisited, testQueryFilterExpressionVisitor.visit(parseTree));
    }

    private static Stream<Arguments> getValidFilterExpression() {
        // Each Argument object contains valid filter expression and expected count of expression visited by
        // TestQueryFilterExpressionVisitor
        return Stream.of(
                Arguments.of("os = \"mojave\"", 2),
                Arguments.of("os != \"mojave\"", 2),
                Arguments.of("accountId > 90", 2),
                Arguments.of("dateRange BETWEEN 1611639470000 AND 1611639476298", 3),
                Arguments.of("date BETWEEN 1511630000000 AND 1611639476298", 3),
                Arguments.of("time between 1511630000000 and 1611639476298", 3),
                Arguments.of("accountId < 100", 2),
                Arguments.of("accountId >= 90", 2),
                Arguments.of("accountId >= 90 LIMIT 100", 4),
                Arguments.of("accountId <= 100", 2),
                Arguments.of("account-Id <= 100", 2),
                Arguments.of("account.Id <= 100", 2),
                Arguments.of("accountId BETWEEN 90 AND 100", 3),
                Arguments.of("os CONTAINS \"mojave\"", 2),
                Arguments.of("os CONTAINS \"moj%ave\"", 2),
                Arguments.of("os = \"mojave\" and app = \"mo\"", 5),
                Arguments.of("os = \"mojave\" OR app = \"mo\"", 5),
                Arguments.of("(os = \"mojave\" AND app = \"mo\") and (os = \"mojave\" OR app = \"mo\")", 11),
                Arguments.of("(os = \"mojave\" AND app = \"mo\") or (os = \"mojave\" OR app = \"mo\")", 11),
                Arguments.of("accountId in (100, 90, 70)", 4),
                Arguments.of("date between 2021-04-20 and 2021-04-21", 3),
                Arguments.of("date between 2021-04-20T12:30:45Z and 2021-04-20T15:45:49.234Z", 3),
                Arguments.of("(accountId > 100 and ((date < 2021-04-20T12:30:45Z and date > " +
                             "2021-04-21T15:45:49.234Z) and accountId < 200))", 11)
        );
    }
}
