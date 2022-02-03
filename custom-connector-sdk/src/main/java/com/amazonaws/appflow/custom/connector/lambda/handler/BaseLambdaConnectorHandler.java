/*
 * -
 *  * #%L
 * * Amazon Appflow Custom Connector SDK.
 * *
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

package com.amazonaws.appflow.custom.connector.lambda.handler;

import com.amazonaws.appflow.custom.connector.handlers.ConfigurationHandler;
import com.amazonaws.appflow.custom.connector.handlers.RecordHandler;
import com.amazonaws.appflow.custom.connector.handlers.MetadataHandler;
import com.amazonaws.appflow.custom.connector.model.ConnectorRequest;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationRequest;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.DescribeEntityRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.query.QueryDataRequest;
import com.amazonaws.appflow.custom.connector.model.retreive.RetrieveDataRequest;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsRequest;
import com.amazonaws.appflow.custom.connector.model.write.WriteDataRequest;
import com.amazonaws.appflow.custom.connector.util.CustomObjectMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.annotation.Nonnull;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Base class for Lambda Connector handlers. It is recommended that all connectors extend this class for Lambda
 * operations though it is possible for you to write your own from the ground up.
 */
public abstract class BaseLambdaConnectorHandler implements RequestStreamHandler {
    private final ObjectMapper objectMapper = CustomObjectMapper.getObjectMapper();
    private final RecordHandler recordHandler;
    private final MetadataHandler metadataHandler;
    private final ConfigurationHandler configurationHandler;

    public BaseLambdaConnectorHandler(@Nonnull final MetadataHandler metadataHandler,
                                      @Nonnull final RecordHandler recordHandler,
                                      @Nonnull final ConfigurationHandler configurationHandler) {
        this.recordHandler = recordHandler;
        this.metadataHandler = metadataHandler;
        this.configurationHandler = configurationHandler;
    }

    @Override
    public void handleRequest(final InputStream inputStream, final OutputStream outputStream, final Context context) {
        //TODO :: Adding Lambda LOGGER for now. Need to think more for logging.
        final LambdaLogger lambdaLogger = context.getLogger();
        try (ConnectorRequest connectorRequest = objectMapper.readValue(inputStream, ConnectorRequest.class)) {
            lambdaLogger.log("Handling request for requestType: " + connectorRequest.getClass().getName());
            if (connectorRequest instanceof ValidateConnectorRuntimeSettingsRequest) {
                objectMapper.writeValue(outputStream, configurationHandler.validateConnectorRuntimeSettings(
                        (ValidateConnectorRuntimeSettingsRequest) connectorRequest));
            } else if (connectorRequest instanceof ValidateCredentialsRequest) {
                objectMapper.writeValue(outputStream,
                        configurationHandler.validateCredentials((ValidateCredentialsRequest) connectorRequest));
            } else if (connectorRequest instanceof DescribeConnectorConfigurationRequest) {
                objectMapper.writeValue(outputStream, configurationHandler.describeConnectorConfiguration(
                        (DescribeConnectorConfigurationRequest) connectorRequest));
            } else if (connectorRequest instanceof RetrieveDataRequest) {
                objectMapper.writeValue(outputStream,
                        recordHandler.retrieveData((RetrieveDataRequest) connectorRequest));
            } else if (connectorRequest instanceof QueryDataRequest) {
                objectMapper.writeValue(outputStream, recordHandler.queryData((QueryDataRequest) connectorRequest));
            } else if (connectorRequest instanceof WriteDataRequest) {
                objectMapper.writeValue(outputStream, recordHandler.writeData((WriteDataRequest) connectorRequest));
            } else if (connectorRequest instanceof ListEntitiesRequest) {
                objectMapper.writeValue(outputStream,
                        metadataHandler.listEntities((ListEntitiesRequest) connectorRequest));
            } else if (connectorRequest instanceof DescribeEntityRequest) {
                objectMapper.writeValue(outputStream,
                        metadataHandler.describeEntity((DescribeEntityRequest) connectorRequest));
            } else {
                lambdaLogger.log(String.format("handleRequest: Request type %s is not supported",
                        connectorRequest.getClass().getName()));
                throw new IllegalArgumentException(
                        "No operation is defined for requestType: " + connectorRequest.getClass().getName());
            }
        } catch (Exception ex) {
            lambdaLogger.log("handleRequest: Completed with an exception: " + ExceptionUtils.getStackTrace(ex));
            throw new RuntimeException(
                    "Exception while processing the request due to " + ExceptionUtils.getStackTrace(ex));
        }
    }
}
