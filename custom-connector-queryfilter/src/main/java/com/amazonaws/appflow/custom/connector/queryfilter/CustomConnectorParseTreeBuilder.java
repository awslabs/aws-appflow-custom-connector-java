/*-
 * #%L
 * Amazon Appflow Custom Connector SDK
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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.amazonaws.appflow.custom.connector.queryfilter.antlr.CustomConnectorQueryFilterLexer;
import com.amazonaws.appflow.custom.connector.queryfilter.antlr.CustomConnectorQueryFilterParser;

import java.util.Objects;

/**
 * Helper class to validate and construct a parse tree for a given filter expression
 */
public final class CustomConnectorParseTreeBuilder {

    private CustomConnectorParseTreeBuilder() {
        // To avoid instantiation of the helper class
    }

    /**
     * Validates and generates a parse tree the provided filterExpression and reports syntax error if any
     *
     * @param filterExpression
     * @return a parse tree for the expression
     */
    public static ParseTree parse(final String filterExpression) {
        Objects.requireNonNull(filterExpression, "Filter expression can't be null");
        CharStream cs = CharStreams.fromString(filterExpression);
        CustomConnectorQueryFilterLexer customConnectorQueryFilterLexer = new CustomConnectorQueryFilterLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(customConnectorQueryFilterLexer);
        CustomConnectorQueryFilterParser parser = new CustomConnectorQueryFilterParser(cts);
        parser.removeErrorListeners(); // remove any pre-existing error listeners and register custom listeners
        SyntaxErrorReporter syntaxErrorReporter = new SyntaxErrorReporter();
        parser.addErrorListener(syntaxErrorReporter);
        ParseTree tree = parser.queryfilter();
        if (syntaxErrorReporter.hasError()) {
            throw new InvalidFilterExpressionException("Filter expression has the following syntax errors : "
                    + syntaxErrorReporter.getSyntaxErrors());
        }
        return tree;
    }
}
