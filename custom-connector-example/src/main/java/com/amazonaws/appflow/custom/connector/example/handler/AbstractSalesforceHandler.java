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

package com.amazonaws.appflow.custom.connector.example.handler;

import com.amazonaws.appflow.custom.connector.example.client.HttpClient;
import com.amazonaws.appflow.custom.connector.example.SalesforceResponse;
import com.amazonaws.appflow.custom.connector.model.ConnectorContext;
import com.amazonaws.appflow.custom.connector.model.ErrorCode;
import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.amazonaws.appflow.custom.connector.model.ImmutableErrorDetails;
import com.amazonaws.appflow.custom.connector.model.credentials.OAuth2Credentials;
import com.amazonaws.appflow.custom.connector.util.CredentialsProvider;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import org.apache.commons.lang3.Range;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

import static com.amazonaws.appflow.custom.connector.example.configuration.ConnectorSettingKey.INSTANCE_URL;

/**
 * Base implementation for salesforce handler.
 */
public abstract class AbstractSalesforceHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSalesforceHandler.class);

    private static final Range<Integer> HTTP_STATUS_SUCCESS_CODE_RANGE = Range.between(200, 299);

    protected HttpClient getSalesforceClient(final ConnectorContext connectorContext) {
        LOGGER.info("Fetching access token from Secret Arn.");
        OAuth2Credentials credentials = CredentialsProvider.getOAuth2Credentials(AWSSecretsManagerClientBuilder.defaultClient(),
                connectorContext.credentials().secretArn());
        return new HttpClient(credentials.accessToken());
    }
    
    protected ErrorDetails checkForErrorsInSalesforceResponse(final SalesforceResponse response) {
        final int statusCode = response.statusCode();
        if (statusCode >= HTTP_STATUS_SUCCESS_CODE_RANGE.getMinimum() &&
            statusCode < HTTP_STATUS_SUCCESS_CODE_RANGE.getMaximum()) {
            return null;
        }

        ErrorCode errorCode = null;
        if (statusCode == HttpStatus.SC_UNAUTHORIZED) {
            errorCode = ErrorCode.InvalidCredentials;
        } else if (statusCode == HttpStatus.SC_BAD_REQUEST) {
            errorCode = ErrorCode.InvalidArgument;
        } else {
            errorCode = ErrorCode.ServerError;
        }
        String errorMessage =
                "Request failed with status code " + response.statusCode() + " error reason " + response.errorReason() +
                " and salesforce response is " + response.response();
        LOGGER.error(errorMessage);
        return ImmutableErrorDetails.builder().errorCode(errorCode).errorMessage(errorMessage).build();
    }

    protected static String buildSalesforceRequestURI(final ConnectorContext connectorContext,
                                                      final String urlFormat, final String requestPath) {
        final Map<String, String> connectorRuntimeSettings = connectorContext.connectorRuntimeSettings();
        String instanceUrl = connectorRuntimeSettings.get(INSTANCE_URL);
        instanceUrl = addPath(instanceUrl);
        final String apiVersion = connectorContext.apiVersion();
        String requestUri;
        if (Objects.nonNull(requestPath)) {
            requestUri = String.format(urlFormat, instanceUrl, apiVersion, requestPath);
        } else {
            requestUri = String.format(urlFormat, instanceUrl, apiVersion);
        }
        return requestUri;
    }

    private static String addPath(final String url) {
        if (url.endsWith("/")) {
            return url;
        } else {
            return url + "/";
        }
    }
}
