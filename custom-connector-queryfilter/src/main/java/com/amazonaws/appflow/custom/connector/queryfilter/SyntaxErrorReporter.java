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

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for collecting and reporting syntax errors in passed filter expression in the input request.
 * Note : This class is not thread safe.
 */
public class SyntaxErrorReporter extends BaseErrorListener {

    private boolean hasError = false;
    private final StringBuilder syntaxErrors = new StringBuilder();

    public boolean hasError() {
        return hasError;
    }

    public StringBuilder getSyntaxErrors() {
        return syntaxErrors;
    }

    @Override
    public void syntaxError(final Recognizer<?, ?> recognizer,
                            final Object offendingSymbol,
                            final int line, final int charPositionInLine,
                            final String msg, final RecognitionException e) {
        hasError = true;
        List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        syntaxErrors.append("rule stack: ").append(stack).append(" ")
                .append("line ").append(line).append(":").append(charPositionInLine).append(" at ")
                .append(offendingSymbol).append(":").append(msg);
    }
}
