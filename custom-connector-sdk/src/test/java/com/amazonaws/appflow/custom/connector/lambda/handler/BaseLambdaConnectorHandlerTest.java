/*
 * -
 * * #%L
 * * Amazon AppFlow Custom Connector SDK.
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
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationRequest;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.DescribeEntityRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.query.QueryDataRequest;
import com.amazonaws.appflow.custom.connector.model.retreive.RetrieveDataRequest;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsRequest;
import com.amazonaws.appflow.custom.connector.model.write.WriteDataRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BaseLambdaConnectorHandlerTest {

    @Mock
    private RecordHandler recordHandler;

    @Mock
    private MetadataHandler metadataHandler;

    @Mock
    private ConfigurationHandler configurationHandler;

    @Mock
    private Context context;

    @Mock
    private LambdaLogger logger;

    private BaseLambdaConnectorHandler handler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        handler = new BaseLambdaConnectorHandler(metadataHandler, recordHandler, configurationHandler) {
            @Override
            public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) {
                super.handleRequest(inputStream, outputStream, context);
            }
        };
        Mockito.when(context.getLogger()).thenReturn(logger);
        Mockito.doNothing().when(logger).log(Mockito.anyString());
    }

    @Test
    public void testHandleValidateCredentialsRequest() {
        handler.handleRequest(getRequestInputStream("ValidateCredentialsRequest.json"), new ByteArrayOutputStream(),
                context);
        Mockito.verify(configurationHandler, Mockito.times(1))
                .validateCredentials(Mockito.any(ValidateCredentialsRequest.class));
    }

    @Test
    public void testHandleValidateConnectorRuntimeSettingsRequest() throws IOException {
        handler.handleRequest(getRequestInputStream("ValidateConnectorRuntimeSettingsRequest.json"),
                new ByteArrayOutputStream(), context);
        Mockito.verify(configurationHandler, Mockito.times(1))
                .validateConnectorRuntimeSettings(Mockito.any(ValidateConnectorRuntimeSettingsRequest.class));
    }

    @Test
    public void testHandleDescribeConnectorConfigurationRequest() throws IOException {
        handler.handleRequest(getRequestInputStream("DescribeConnectorConfigurationRequest.json"),
                new ByteArrayOutputStream(), context);
        Mockito.verify(configurationHandler, Mockito.times(1))
                .describeConnectorConfiguration(Mockito.any(DescribeConnectorConfigurationRequest.class));
    }

    @Test
    public void testHandleDescribeEntityRequest() throws IOException {
        handler.handleRequest(getRequestInputStream("DescribeEntityRequest.json"), new ByteArrayOutputStream(),
                context);
        Mockito.verify(metadataHandler, Mockito.times(1)).describeEntity(Mockito.any(DescribeEntityRequest.class));
    }

    @Test
    public void testHandleListEntitiesRequest() throws IOException {
        handler.handleRequest(getRequestInputStream("ListEntitiesRequest.json"), new ByteArrayOutputStream(), context);
        Mockito.verify(metadataHandler, Mockito.times(1)).listEntities(Mockito.any(ListEntitiesRequest.class));
    }

    @Test
    public void testHandleQueryDataRequest() throws IOException {
        handler.handleRequest(getRequestInputStream("QueryDataRequest.json"), new ByteArrayOutputStream(), context);
        Mockito.verify(recordHandler, Mockito.times(1)).queryData(Mockito.any(QueryDataRequest.class));
    }

    @Test
    public void testHandleRetrieveDataRequest() throws IOException {
        handler.handleRequest(getRequestInputStream("RetrieveDataRequest.json"), new ByteArrayOutputStream(), context);
        Mockito.verify(recordHandler, Mockito.times(1)).retrieveData(Mockito.any(RetrieveDataRequest.class));
    }

    @Test
    public void testHandleWriteDataRequest() throws IOException {
        handler.handleRequest(getRequestInputStream("WriteDataRequest.json"), new ByteArrayOutputStream(), context);
        Mockito.verify(recordHandler, Mockito.times(1)).writeData(Mockito.any(WriteDataRequest.class));
    }

    @Test
    public void testHandleUnknownTypeRequest() throws IOException {
        try {
            handler.handleRequest(getRequestInputStream("UnknownRequest.json"), new ByteArrayOutputStream(), context);
            Assertions.assertTrue(false);
        } catch (Exception ex) {
        }
    }

    private InputStream getRequestInputStream(String fileName) {
        return this.getClass().getClassLoader().getResourceAsStream(fileName);
    }
}
