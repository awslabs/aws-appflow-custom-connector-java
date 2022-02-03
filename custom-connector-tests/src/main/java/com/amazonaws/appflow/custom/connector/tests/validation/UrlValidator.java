/*-
 * #%L
 * custom-connector-tests
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
package com.amazonaws.appflow.custom.connector.tests.validation;

import com.amazonaws.appflow.custom.connector.tests.exceptions.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

public final class UrlValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(UrlValidator.class);

    private UrlValidator() {}

    public static void validate(final String inputUrl) {
        if (StringUtils.isBlank(inputUrl)) {
            return;
        }

        try {
            URI uri = new URI(inputUrl);
            if (!"https".equals(uri.getScheme())) {
                String errorMessage = String.format("Invalid protocol in url %s. Only https format is supported",
                    inputUrl);
                throw new ValidationException(errorMessage);
            }
        } catch (URISyntaxException e) {
            LOGGER.error("Invalid url format!");
            String errorMessage = String.format("Invalid format for url %s." +
                " Please check if if the url syntax is correct" +
                " and it resolves to a known host.", inputUrl);
            throw new ValidationException(errorMessage);
        }
    }
}
