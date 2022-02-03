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
package com.amazonaws.appflow.custom.connector.tests.invokers;

import com.amazonaws.appflow.custom.connector.lambda.handler.BaseLambdaConnectorHandler;
import com.amazonaws.appflow.custom.connector.model.ConnectorContext;
import com.amazonaws.appflow.custom.connector.model.ImmutableConnectorContext;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationRequest;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationResponse;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ImmutableDescribeConnectorConfigurationRequest;
import com.amazonaws.appflow.custom.connector.model.credentials.ImmutableValidateCredentialsRequest;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsRequest;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsResponse;
import com.amazonaws.appflow.custom.connector.model.metadata.DescribeEntityRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.DescribeEntityResponse;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableDescribeEntityRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesResponse;
import com.amazonaws.appflow.custom.connector.model.query.ImmutableQueryDataRequest;
import com.amazonaws.appflow.custom.connector.model.query.QueryDataRequest;
import com.amazonaws.appflow.custom.connector.model.query.QueryDataResponse;
import com.amazonaws.appflow.custom.connector.model.retreive.ImmutableRetrieveDataRequest;
import com.amazonaws.appflow.custom.connector.model.retreive.RetrieveDataRequest;
import com.amazonaws.appflow.custom.connector.model.retreive.RetrieveDataResponse;
import com.amazonaws.appflow.custom.connector.model.settings.ConnectorRuntimeSettingScope;
import com.amazonaws.appflow.custom.connector.model.settings.ImmutableValidateConnectorRuntimeSettingsRequest;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsRequest;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsResponse;
import com.amazonaws.appflow.custom.connector.model.write.ImmutableWriteDataRequest;
import com.amazonaws.appflow.custom.connector.model.write.WriteDataRequest;
import com.amazonaws.appflow.custom.connector.model.write.WriteDataResponse;
import com.amazonaws.appflow.custom.connector.tests.model.QueryRecordConfiguration;
import com.amazonaws.appflow.custom.connector.tests.model.RetrieveRecordConfiguration;
import com.amazonaws.appflow.custom.connector.tests.model.TestConfig;
import com.amazonaws.appflow.custom.connector.tests.model.WriteRecordConfiguration;
import com.amazonaws.appflow.custom.connector.tests.resources.TestContext;
import com.amazonaws.appflow.custom.connector.tests.validation.ConnectorConfigurationResponseValidator;
import com.amazonaws.appflow.custom.connector.util.CustomObjectMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseConnectorTestInvoker implements ConnectorTestInvoker {
    private final Logger log = LoggerFactory.getLogger(BaseConnectorTestInvoker.class);
    private final ObjectMapper mapper = CustomObjectMapper.getObjectMapper();
    private final Context testContext = new TestContext();
    private static final String API_VERSION = "api_version";

    private BaseLambdaConnectorHandler connectorHandler;
    private TestConfig testConfig;

    public BaseConnectorTestInvoker(final BaseLambdaConnectorHandler connectorHandler,
                                    final TestConfig testConfig) {
        this.connectorHandler = connectorHandler;
        this.testConfig = testConfig;
    }

    public void invokeConfigurationHandlerTests() {
        log.info("-----------Starting verification tests for Configuration Handler-----------");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            TestConfig.RuntimeSettings runtimeSettings = testConfig.getRuntimeSettings();
            if (!Objects.isNull(runtimeSettings.getConnectorProfile())) {
                log.info("Testing ValidateConnectorRuntimeSettings for ConnectorProfile...");
                ValidateConnectorRuntimeSettingsRequest validateRuntimeRequest =
                    ImmutableValidateConnectorRuntimeSettingsRequest.builder()
                        .connectorRuntimeSettings(runtimeSettings.getConnectorProfile())
                        .scope(ConnectorRuntimeSettingScope.CONNECTOR_PROFILE)
                        .build();
                connectorHandler.handleRequest(getInputStream(validateRuntimeRequest), out, testContext);

                ValidateConnectorRuntimeSettingsResponse validateRuntimeResponse =
                    mapper.readValue(out.toByteArray(), ValidateConnectorRuntimeSettingsResponse.class);
                out.reset();
                Preconditions.checkNotNull(validateRuntimeResponse);
                Preconditions.checkState(validateRuntimeResponse.isSuccess(), "Validate Connector Runtime response was unsuccessful for the provided TestConfiguration");
            }

            if (!Objects.isNull(runtimeSettings.getSource())) {
                log.info("Testing ValidateConnectorRuntimeSettings for Source...");
                ValidateConnectorRuntimeSettingsRequest validateRuntimeRequest = ImmutableValidateConnectorRuntimeSettingsRequest.builder()
                    .connectorRuntimeSettings(runtimeSettings.getSource())
                    .scope(ConnectorRuntimeSettingScope.SOURCE)
                    .build();
                connectorHandler.handleRequest(getInputStream(validateRuntimeRequest), out, testContext);

                ValidateConnectorRuntimeSettingsResponse validateRuntimeResponse =
                    mapper.readValue(out.toByteArray(), ValidateConnectorRuntimeSettingsResponse.class);
                out.reset();
                Preconditions.checkNotNull(validateRuntimeResponse);
                Preconditions.checkState(validateRuntimeResponse.isSuccess(), "Validate Connector Runtime response was unsuccessful for the provided TestConfiguration");
            }

            if (!Objects.isNull(runtimeSettings.getDestination())) {
                log.info("Testing ValidateConnectorRuntimeSettings for Destination...");
                ValidateConnectorRuntimeSettingsRequest validateRuntimeRequest = ImmutableValidateConnectorRuntimeSettingsRequest.builder()
                    .connectorRuntimeSettings(runtimeSettings.getDestination())
                    .scope(ConnectorRuntimeSettingScope.DESTINATION)
                    .build();
                connectorHandler.handleRequest(getInputStream(validateRuntimeRequest), out, testContext);

                ValidateConnectorRuntimeSettingsResponse validateRuntimeResponse =
                    mapper.readValue(out.toByteArray(), ValidateConnectorRuntimeSettingsResponse.class);
                out.reset();
                Preconditions.checkNotNull(validateRuntimeResponse);
                Preconditions.checkState(validateRuntimeResponse.isSuccess(), "Validate Connector Runtime response was unsuccessful for the provided TestConfiguration");
            }

            log.info("Testing ValidateCredentials...");
            ValidateCredentialsRequest validateCredentialsRequest = ImmutableValidateCredentialsRequest.builder()
                    .credentials(testConfig.getCredentials())
                    .connectorRuntimeSettings(buildConnectorRuntimeSettingsMap())
                    .build();
            connectorHandler.handleRequest(getInputStream(validateCredentialsRequest), out, testContext);

            ValidateCredentialsResponse validateCredentialsResponse =
                    mapper.readValue(out.toByteArray(), ValidateCredentialsResponse.class);
            out.reset();
            Preconditions.checkNotNull(validateCredentialsResponse);
            Preconditions.checkState(validateCredentialsResponse.isSuccess(), "Validate Credentials response was unsuccessful for the provided TestConfiguration");

            log.info("Testing DescribeConnectorConfiguration...");
            DescribeConnectorConfigurationRequest describeConnectorRequest =
                    ImmutableDescribeConnectorConfigurationRequest.builder().build();
            connectorHandler.handleRequest(getInputStream(describeConnectorRequest), out, testContext);
            DescribeConnectorConfigurationResponse describeConnectorResponse =
                    mapper.readValue(out.toByteArray(), DescribeConnectorConfigurationResponse.class);
            out.reset();
            Preconditions.checkNotNull(describeConnectorResponse);
            Preconditions.checkState(describeConnectorResponse.isSuccess(), "Describe Connector response was unsuccessful");
            Preconditions.checkNotNull(describeConnectorResponse.connectorName());
            Preconditions.checkNotNull(describeConnectorResponse.connectorOwner());
            Preconditions.checkNotNull(describeConnectorResponse.connectorVersion());
            ConnectorConfigurationResponseValidator.validateConnectorConfiguration(describeConnectorResponse);

            log.info("Configuration handler was verified successfully!");
        } catch (Exception e) {
            log.error("Error encountered during ConfigurationHandler verification!", e);
            log.error("Verification tests failed for the given Connector Handler. See logs for details");
            System.exit(1);
        }
    }

    public void invokeMetadataHandlerTests() {
        log.info("-----------Starting verification tests for Metadata Handler-----------");

        try {
            log.info("Testing ListEntities...");
            ListEntitiesRequest listEntitiesRequest = ImmutableListEntitiesRequest.builder()
                .connectorContext(ImmutableConnectorContext.builder()
                    .connectorRuntimeSettings(buildConnectorRuntimeSettingsMap())
                    .credentials(testConfig.getCredentials())
                    .apiVersion(testConfig.getRuntimeSettings().getConnectorProfile().get(API_VERSION))
                    .build())
                .entitiesPath(testConfig.getTestEntityIdentifier())
                .build();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            connectorHandler.handleRequest(getInputStream(listEntitiesRequest), out, testContext);
            ListEntitiesResponse listEntitiesResponse = mapper.readValue(out.toByteArray(), ListEntitiesResponse.class);
            Preconditions.checkNotNull(listEntitiesResponse);
            Preconditions.checkState(listEntitiesResponse.isSuccess(), "List Entities response returned unsuccessful response for the provided TestConfiguration");
            Preconditions.checkNotNull(listEntitiesResponse.entities(), "No entities were returned");
            Preconditions.checkState(!listEntitiesResponse.entities().isEmpty(), "No entities were returned in List Entities response");

            log.info("Testing DescribeEntity...");
            DescribeEntityRequest describeEntityRequest = ImmutableDescribeEntityRequest.builder()
                .entityIdentifier(testConfig.getTestEntityIdentifier())
                .connectorContext(ImmutableConnectorContext.builder()
                    .connectorRuntimeSettings(buildConnectorRuntimeSettingsMap())
                    .credentials(testConfig.getCredentials())
                    .apiVersion(testConfig.getRuntimeSettings().getConnectorProfile().get(API_VERSION))
                    .build())
                .build();
            out.reset();
            connectorHandler.handleRequest(getInputStream(describeEntityRequest), out, testContext);
            DescribeEntityResponse describeEntityResponse =
                mapper.readValue(out.toByteArray(), DescribeEntityResponse.class);
            Preconditions.checkNotNull(describeEntityResponse);
            Preconditions.checkState(describeEntityResponse.isSuccess(), "Describe Entity response returned unsuccessful response for the provided TestConfiguration");
            Preconditions.checkNotNull(describeEntityResponse.entityDefinition());

            log.info("Metadata handler verification was successful!");
        } catch (Exception e) {
            log.error("Error encountered during MetadataHandler verification!", e);
            log.error("Verification tests failed for the given Connector Handler. See logs for details");
            System.exit(1);
        }
    }

    public void invokeRecordHandlerTests() {
        log.info("-----------Starting verification tests for Record Handler-----------");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            for (int configurationIndex = 0; configurationIndex < testConfig.getRetrieveRecordConfigurations().size(); configurationIndex++) {
                log.info("Testing RetrieveData configuration " + (configurationIndex + 1) + "...");

                RetrieveRecordConfiguration retrieveRecordConfiguration =
                    testConfig.getRetrieveRecordConfigurations().get(configurationIndex);
                RetrieveDataRequest retrieveDataRequest = ImmutableRetrieveDataRequest.builder()
                    .connectorContext(buildTestConfigConnectorContext(retrieveRecordConfiguration.getEntityIdentifier()))
                    .entityIdentifier(testConfig.getTestEntityIdentifier())
                    .selectedFieldNames(retrieveRecordConfiguration.getSelectedFieldNames())
                    .idFieldName(retrieveRecordConfiguration.getIdFieldName())
                    .ids(retrieveRecordConfiguration.getIds())
                    .build();
                connectorHandler.handleRequest(getInputStream(retrieveDataRequest), out, testContext);

                RetrieveDataResponse retrieveDataResponse = mapper.readValue(out.toByteArray(), RetrieveDataResponse.class);
                Preconditions.checkNotNull(retrieveDataResponse);
                Preconditions.checkState(retrieveDataResponse.isSuccess(), "Retrieve Data response returned unsuccessful response for the provided TestConfiguration");
                Preconditions.checkNotNull(retrieveDataResponse.records(), "No records were found");
                Preconditions.checkState(!retrieveDataResponse.records().isEmpty(), "Retrieve Data returned empty record list when at least 1 expected");
                out.reset();
            }

            for (int configurationIndex = 0; configurationIndex < testConfig.getWriteRecordConfigurations().size(); configurationIndex++) {
                log.info("Testing WriteData configuration " + (configurationIndex + 1) + "...");

                WriteRecordConfiguration writeRecordConfiguration = testConfig.getWriteRecordConfigurations().get(configurationIndex);
                WriteDataRequest writeDataRequest = ImmutableWriteDataRequest.builder()
                    .entityIdentifier(testConfig.getTestEntityIdentifier())
                    .operation(writeRecordConfiguration.getOperation())
                    .records(writeRecordConfiguration.getRecords())
                    .idFieldNames(writeRecordConfiguration.getIdFieldNames())
                    .allOrNone(writeRecordConfiguration.isAllOrNone())
                    .connectorContext(buildTestConfigConnectorContext(writeRecordConfiguration.getEntityIdentifier()))
                    .build();
                connectorHandler.handleRequest(getInputStream(writeDataRequest), out, testContext);

                WriteDataResponse writeDataResponse = mapper.readValue(out.toByteArray(), WriteDataResponse.class);
                Preconditions.checkNotNull(writeDataResponse);
                Preconditions.checkState(writeDataResponse.isSuccess(), "Write Data response returned unsuccessful response for the provided TestConfig");
                out.reset();
            }

            for (int configurationIndex = 0; configurationIndex < testConfig.getQueryRecordConfigurations().size(); configurationIndex++) {
                log.info("Testing QueryData configuration " + (configurationIndex + 1) + "...");
                QueryRecordConfiguration queryRecordConfiguration = testConfig.getQueryRecordConfigurations().get(configurationIndex);
                QueryDataRequest queryDataRequest = ImmutableQueryDataRequest.builder()
                    .entityIdentifier(testConfig.getTestEntityIdentifier())
                    .selectedFieldNames(queryRecordConfiguration.getSelectedFieldNames())
                    .filterExpression(queryRecordConfiguration.getFilterExpression())
                    .connectorContext(buildTestConfigConnectorContext(queryRecordConfiguration.getEntityIdentifier()))
                    .build();
                connectorHandler.handleRequest(getInputStream(queryDataRequest), out, testContext);

                QueryDataResponse queryDataResponse = mapper.readValue(out.toByteArray(), QueryDataResponse.class);
                Preconditions.checkNotNull(queryDataResponse);
                Preconditions.checkState(queryDataResponse.isSuccess(), "Query Data response returned unsuccessful response for provided TestConfig");
                Preconditions.checkState(!queryDataResponse.records().isEmpty(), "No records were returned for the given query");
                out.reset();
            }

            log.info("Record handler verification was successful!");
        } catch (Exception e) {
            log.error("Error encountered during RecordHandler verification!", e);
            log.error("Verification tests failed for the given Connector Handler. See logs for details");
            System.exit(1);
        }
    }

    private InputStream getInputStream(final Object input) throws JsonProcessingException {
        return new ByteArrayInputStream(mapper.writeValueAsBytes(input));
    }

    private Map<String, String> buildConnectorRuntimeSettingsMap() {
        Map<String, String> connectorRuntimeSettings = new HashMap<>();
        TestConfig.RuntimeSettings runtimeSettings = testConfig.getRuntimeSettings();

        if (!Objects.isNull(runtimeSettings.getConnectorProfile())) {
            connectorRuntimeSettings.putAll(runtimeSettings.getConnectorProfile());
        }
        if (!Objects.isNull(runtimeSettings.getSource())) {
            connectorRuntimeSettings.putAll(runtimeSettings.getSource());
        }
        if (!Objects.isNull(runtimeSettings.getDestination())) {
            connectorRuntimeSettings.putAll(runtimeSettings.getDestination());
        }

        return connectorRuntimeSettings;
    }

    private ConnectorContext buildTestConfigConnectorContext(final String entityIdentifier) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DescribeEntityRequest describeEntityRequest = ImmutableDescribeEntityRequest.builder()
            .entityIdentifier(entityIdentifier)
            .connectorContext(ImmutableConnectorContext.builder()
                .connectorRuntimeSettings(buildConnectorRuntimeSettingsMap())
                .credentials(testConfig.getCredentials())
                .apiVersion(testConfig.getRuntimeSettings().getConnectorProfile().get(API_VERSION))
                .build())
            .build();
        connectorHandler.handleRequest(getInputStream(describeEntityRequest), out, testContext);
        DescribeEntityResponse describeEntityResponse = mapper.readValue(out.toByteArray(), DescribeEntityResponse.class);

        return ImmutableConnectorContext.builder()
            .connectorRuntimeSettings(buildConnectorRuntimeSettingsMap())
            .credentials(testConfig.getCredentials())
            .apiVersion(testConfig.getRuntimeSettings().getConnectorProfile().get(API_VERSION))
            .entityDefinition(describeEntityResponse.entityDefinition())
            .build();
    }
}
