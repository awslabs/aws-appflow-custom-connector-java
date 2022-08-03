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

import com.amazonaws.appflow.custom.connector.example.SalesforceResponse;
import com.amazonaws.appflow.custom.connector.example.client.HttpClient;
import com.amazonaws.appflow.custom.connector.example.configuration.SalesforceConnectorConfiguration;
import com.amazonaws.appflow.custom.connector.handlers.ConfigurationHandler;
import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationRequest;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationResponse;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ImmutableDescribeConnectorConfigurationResponse;
import com.amazonaws.appflow.custom.connector.model.credentials.Credentials;
import com.amazonaws.appflow.custom.connector.model.credentials.ImmutableValidateCredentialsResponse;
import com.amazonaws.appflow.custom.connector.model.credentials.OAuth2Credentials;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsRequest;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsResponse;
import com.amazonaws.appflow.custom.connector.model.settings.ImmutableValidateConnectorRuntimeSettingsResponse;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsRequest;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsResponse;
import com.amazonaws.appflow.custom.connector.util.CredentialsProvider;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;

import java.util.Map;
import java.util.Objects;

import static com.amazonaws.appflow.custom.connector.example.configuration.ConnectorSettingKey.IS_SANDBOX_ACCOUNT;

/**
 * Salesforce Configuration handler.
 */
public class SalesforceConfigurationHandler extends AbstractSalesforceHandler implements ConfigurationHandler {

    public static final String SALESFORCE_USERINFO_URL_FORMAT = "https://login.salesforce.com/services/oauth2/userinfo";
    public static final String SALESFORCE_USERINFO_SANDBOX_URL_FORMAT = "https://test.salesforce.com/services/oauth2/userinfo";
    public static final String TRUE = "TRUE";

    private static final String CONNECTOR_OWNER = "SampleConnector";
    private static final String CONNECTOR_NAME = "SampleSalesforceConnector";
    private static final String CONNECTOR_VERSION = "1.0";

    @Override
    public ValidateConnectorRuntimeSettingsResponse validateConnectorRuntimeSettings(final ValidateConnectorRuntimeSettingsRequest request) {
        return ImmutableValidateConnectorRuntimeSettingsResponse.builder().isSuccess(true).build();
    }

    @Override
    public ValidateCredentialsResponse validateCredentials(final ValidateCredentialsRequest request) {
        String requestUri = buildSalesforceUserInfoRequest(request);

        final SalesforceResponse response = getSalesforceClient(request.credentials()).restGet(requestUri);
        ErrorDetails errorDetails = checkForErrorsInSalesforceResponse(response);
        if (Objects.nonNull(errorDetails)) {
            return ImmutableValidateCredentialsResponse.builder()
                    .isSuccess(false)
                    .errorDetails(errorDetails)
                    .build();
        } else {
            return ImmutableValidateCredentialsResponse.builder().isSuccess(true).build();
        }
    }

    @Override
    public DescribeConnectorConfigurationResponse describeConnectorConfiguration(final DescribeConnectorConfigurationRequest request) {
        return ImmutableDescribeConnectorConfigurationResponse.builder()
                .isSuccess(true)
                .connectorOwner(CONNECTOR_OWNER)
                .connectorName(CONNECTOR_NAME)
                .connectorVersion(CONNECTOR_VERSION)
                .connectorModes(SalesforceConnectorConfiguration.getConnectorModes())
                .connectorRuntimeSetting(SalesforceConnectorConfiguration.getConnectorRuntimeSettings())
                .authenticationConfig(SalesforceConnectorConfiguration.getAuthenticationConfig())
                .supportedApiVersions(SalesforceConnectorConfiguration.getSupportedApiVersions())
                .supportedWriteOperations(SalesforceConnectorConfiguration.supportedWriteOperations())
                .build();
    }

    private String buildSalesforceUserInfoRequest(final ValidateCredentialsRequest request) {
        Map<String, String> connectorRuntimeSettings = request.connectorRuntimeSettings();
        if (Objects.isNull(connectorRuntimeSettings)) {
            return SALESFORCE_USERINFO_URL_FORMAT;
        }
        if (connectorRuntimeSettings.containsKey(IS_SANDBOX_ACCOUNT) &&
                TRUE.equalsIgnoreCase(connectorRuntimeSettings.get(IS_SANDBOX_ACCOUNT))) {
            return SALESFORCE_USERINFO_SANDBOX_URL_FORMAT;
        }
        return SALESFORCE_USERINFO_URL_FORMAT;
    }

    private HttpClient getSalesforceClient(Credentials credentials) {
        OAuth2Credentials creds = CredentialsProvider.getOAuth2Credentials(AWSSecretsManagerClientBuilder.defaultClient(),
                credentials.secretArn());
        return new HttpClient(creds.accessToken());
    }
}
