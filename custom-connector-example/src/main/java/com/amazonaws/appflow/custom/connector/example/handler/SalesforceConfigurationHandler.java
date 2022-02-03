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

import com.amazonaws.appflow.custom.connector.example.configuration.SalesforceConnectorConfiguration;
import com.amazonaws.appflow.custom.connector.handlers.ConfigurationHandler;
import com.amazonaws.appflow.custom.connector.model.ImmutableConnectorContext;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationRequest;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationResponse;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ImmutableDescribeConnectorConfigurationResponse;
import com.amazonaws.appflow.custom.connector.model.credentials.ImmutableValidateCredentialsResponse;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsRequest;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsResponse;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesResponse;
import com.amazonaws.appflow.custom.connector.model.settings.ImmutableValidateConnectorRuntimeSettingsResponse;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsRequest;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsResponse;

import java.util.Objects;

import static com.amazonaws.appflow.custom.connector.example.configuration.ConnectorSettingKey.API_VERSION;

/**
 * Salesforce Configuration handler.
 */
public class SalesforceConfigurationHandler implements ConfigurationHandler {

    private static final String CONNECTOR_OWNER = "SampleConnector";
    private static final String CONNECTOR_NAME = "SampleSalesforceConnector";
    private static final String CONNECTOR_VERSION = "1.0";

    @Override
    public ValidateConnectorRuntimeSettingsResponse validateConnectorRuntimeSettings(final ValidateConnectorRuntimeSettingsRequest request) {
        return ImmutableValidateConnectorRuntimeSettingsResponse.builder().isSuccess(true).build();
    }

    @Override
    public ValidateCredentialsResponse validateCredentials(final ValidateCredentialsRequest request) {
        final ListEntitiesRequest listEntitiesRequest = ImmutableListEntitiesRequest.builder()
                .connectorContext(ImmutableConnectorContext.builder()
                        .apiVersion((String) request.connectorRuntimeSettings().get(API_VERSION))
                        .credentials(request.credentials())
                        .connectorRuntimeSettings(request.connectorRuntimeSettings())
                        .build())
                .build();
        final ListEntitiesResponse response = new SalesforceMetadataHandler().listEntities(listEntitiesRequest);
        if (Objects.nonNull(response.errorDetails())) {
            return ImmutableValidateCredentialsResponse.builder()
                    .isSuccess(false)
                    .errorDetails(response.errorDetails())
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
}
