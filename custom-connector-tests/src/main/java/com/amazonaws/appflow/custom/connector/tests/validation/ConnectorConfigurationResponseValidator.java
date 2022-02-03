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

import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorModes;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationResponse;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth.AuthenticationConfig;
import com.amazonaws.appflow.custom.connector.tests.exceptions.ValidationException;
import com.google.common.collect.ImmutableList;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ConnectorConfigurationResponseValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectorConfigurationResponseValidator.class);
    private static final Pattern RESERVED_KEYWORDS_PATTERN =
        Pattern.compile("([Aa][Ww][Ss]|[Aa][Mm][Aa][Zz][Oo][Nn]|[Aa][Pp][Pp][Ff][Ll][Oo][Ww]).*");
    public static final ImmutableList<String> RESERVED_KEYWORDS = ImmutableList.of("aws", "amazon", "appflow");

    private ConnectorConfigurationResponseValidator() {}

    public static void validateConnectorConfiguration(final DescribeConnectorConfigurationResponse connectorConfiguration) {
        List<String> validationErrors = new ArrayList<>();

        if (checkForReservedKeyWords(connectorConfiguration.connectorName())) {
            validationErrors.add("ConnectorName should not contain these reserved keywords " + RESERVED_KEYWORDS);
        }

        if (checkForReservedKeyWords(connectorConfiguration.connectorOwner())) {
            validationErrors.add("ConnectorOwner should not contain these reserved keywords " + RESERVED_KEYWORDS);
        }

        if (CollectionUtils.isEmpty(connectorConfiguration.connectorModes())) {
            validationErrors.add("ConnectorModes cannot be null for Connector.");
        }

        validationErrors.addAll(validateAuthenticationConfig(connectorConfiguration.authenticationConfig()));

        if (connectorConfiguration.connectorModes().contains(ConnectorModes.DESTINATION) &&
            CollectionUtils.isEmpty(connectorConfiguration.supportedWriteOperations())) {
            validationErrors.add(
                "SupportedWriteOperations cannot be null for the connector which supports usage as Destination.");
        }

        if (CollectionUtils.isEmpty(connectorConfiguration.supportedApiVersions())) {
            validationErrors.add("SupportedAPIVersion cannot be null for the connector");
        }

        if (CollectionUtils.isEmpty(connectorConfiguration.operatorsSupported())) {
            validationErrors.add("SupportedOperators cannot be null for the connector");
        }

        if (CollectionUtils.isEmpty(connectorConfiguration.supportedTriggerTypes())) {
            validationErrors.add("SupportedTriggerTypes cannot be null for the connector");
        }

        validationErrors.addAll(validateUrls(Collections.singletonList(connectorConfiguration.logoURL())));

        if (CollectionUtils.isNotEmpty(validationErrors)) {
            String errorMessage =
                "ConnectorConfiguration from the connector failed with following validation validationErrors. " +
                    validationErrors;
            throw new ValidationException(errorMessage);
        }
    }

    private static boolean checkForReservedKeyWords(final String input) {
        Matcher matcher = RESERVED_KEYWORDS_PATTERN.matcher(input);
        return matcher.matches();
    }

    private static List<String> validateAuthenticationConfig(final AuthenticationConfig authenticationConfig) {
        List<String> validationErrors = new ArrayList<>();

        if (!isNullOrFalse(authenticationConfig.isCustomAuthSupported()) &&
            CollectionUtils.isEmpty(authenticationConfig.customAuthConfig())) {
            validationErrors.add("For custom Authentication, CustomAuthConfig is required.");
        }

        if (isNullOrFalse(authenticationConfig.isCustomAuthSupported()) &&
            CollectionUtils.isNotEmpty(authenticationConfig.customAuthConfig())) {
            validationErrors.add("CustomAuthConfig can only be provided for CustomAuthentication.");
        }

        if (!isNullOrFalse(authenticationConfig.isOAuth2Supported()) &&
            Objects.isNull(authenticationConfig.oAuth2Defaults())) {
            validationErrors.add("For OAuth2 Authentication, OAuth2Defaults cannot be null.");
        }

        if (isNullOrFalse(authenticationConfig.isOAuth2Supported()) &&
            Objects.nonNull(authenticationConfig.oAuth2Defaults())) {
            validationErrors.add("OAuth2Defaults can only be provided for OAuth2 Authentication.");
        }

        if (!isNullOrFalse(authenticationConfig.isOAuth2Supported()) &&
                Objects.nonNull(authenticationConfig.oAuth2Defaults())) {
            validationErrors.addAll(validateUrls(authenticationConfig.oAuth2Defaults().tokenURL()));
            if (CollectionUtils.isNotEmpty(authenticationConfig.oAuth2Defaults().authURL())) {
                validationErrors.addAll(validateUrls(authenticationConfig.oAuth2Defaults().authURL()));
            }
        }

        return validationErrors;
    }

    private static List<String> validateUrls(final List<String> urls) {
        List<String> validationErrors = new ArrayList<>();
        urls.forEach(it -> {
            try {
                UrlValidator.validate(it);
            } catch (ValidationException ex) {
                validationErrors.add("Validation failed for url " + it + " with errorMessage " + ex.getMessage());
            }
        });
        return validationErrors;
    }

    private static boolean isNullOrFalse(final Boolean input) {
        if (Objects.isNull(input)) {
            return true;
        }
        return !input;
    }
}
