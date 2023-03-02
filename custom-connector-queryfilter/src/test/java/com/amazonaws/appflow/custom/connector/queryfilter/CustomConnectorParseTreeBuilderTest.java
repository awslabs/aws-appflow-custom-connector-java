/*-
 * #%L
 * Amazon AppFlow Custom Connector SDK
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Test class for the {@link CustomConnectorParseTreeBuilder}
 */
public class CustomConnectorParseTreeBuilderTest {

    @ParameterizedTest
    @MethodSource("validFilterExpressions")
    public void testParseTreeWithValidFilterExpression(final String filterExpression) {
        Assertions.assertDoesNotThrow(() -> CustomConnectorParseTreeBuilder.parse(filterExpression));
    }

    @ParameterizedTest
    @MethodSource("invalidFilterExpressions")
    public void testParseTreeWithInvalidFilterExpression(final String filterExpression) {
        Assertions.assertThrows(InvalidFilterExpressionException.class,
                () -> CustomConnectorParseTreeBuilder.parse(filterExpression));
    }

    public void testParseTreeWithNullFilterExpression() {
        Assertions.assertThrows(NullPointerException.class, () -> CustomConnectorParseTreeBuilder.parse(null));
    }

    private static Stream<Arguments> validFilterExpressions() {
        return Stream.of(
                Arguments.of("os = \"mojave\""),
                Arguments.of("os != \"mojave\""),
                Arguments.of("LIMIT 100"),
                Arguments.of("accountId > 90"),
                Arguments.of("dateRange BETWEEN 1611639470000 AND 1611639476298"),
                Arguments.of("date BETWEEN 1511630000000 AND 1611639476298"),
                Arguments.of("time between 1511630000000 and 1611639476298"),
                Arguments.of("accountId < 100"),
                Arguments.of("accountId >= 90"),
                Arguments.of("accountId <= 100 LIMIT 100"),
                Arguments.of("accountId BETWEEN 90 AND 100"),
                Arguments.of("accountId BETWEEN 90 AND 100 LIMIT 100"),
                Arguments.of("os CONTAINS \"mojave\""),
                Arguments.of("os CONTAINS \"moj%ave\""),
                Arguments.of("os = \"mojave\" and app = \"mo\""),
                Arguments.of("os = \"mojave\" OR app = \"mo\""),
                Arguments.of("(os = \"mojave\" AND app = \"mo\") and (os = \"mojave\" OR app = \"mo\")"),
                Arguments.of("(os = \"mojave\" AND app = \"mo\") or (os = \"mojave\" OR app = \"mo\")"),
                Arguments.of("accountId in (100, 90, 70)"),
                Arguments.of("date between 2021-04-20 and 2021-04-21"),
                Arguments.of("date between 2021-04-20T12:30:45Z and 2021-04-20T15:45:49.234Z"),
                Arguments.of("(accountId > 100 and ((date < 2021-04-20T12:30:45Z and date > 2021-04-21T15:45:49.234Z)" +
                             " and accountId < 200))"),
                Arguments.of("overrides = true or accountFlag != false"),
                Arguments.of("overrides != true"),
                Arguments.of("date > 2020-10-05T12:05:34Z")
        );
    }

    private static Stream<Arguments> invalidFilterExpressions() {
        return Stream.of(
                Arguments.of("os == \"mojave\""),
                Arguments.of("os <> \"mojave\""),
                Arguments.of("LIMIT 100 LIMIT 100"),
                Arguments.of("accountId => 90"),
                Arguments.of("accountId >= 90 LIMIT"),
                Arguments.of("accountId >= 90 LIMIT 0"),
                Arguments.of("accountId >= 90 LIMIT -1"),
                Arguments.of("accountId >= 90 LIMIT 1.5"),
                Arguments.of("accountId >= 90 LIMIT abc"),
                Arguments.of("dateRange in 1611639470000 AND 1611639476298"),
                Arguments.of("date FROM 1511630000000 TO 1611639476298"),
                Arguments.of("time Between 1511630000000 and 1611639476298"),
                Arguments.of("os CONTAIN \"mojave\""),
                Arguments.of("os CONTAINS \"moj%ave"),
                Arguments.of("accountId in (id, \"90\", 70)"),
                Arguments.of("accountId in (true)"),
                Arguments.of("date > 2021-04-203"),
                Arguments.of("date > 2021-04-20T20:30"),
                Arguments.of("date > 2021-04-20T20:30:20.9999+26"),
                Arguments.of("date > 2021-04-20T20:30:20.9999+12:23"),
                Arguments.of("date > 2021-04-20T20:30:20.9999-12:23")
        );
    }
}
