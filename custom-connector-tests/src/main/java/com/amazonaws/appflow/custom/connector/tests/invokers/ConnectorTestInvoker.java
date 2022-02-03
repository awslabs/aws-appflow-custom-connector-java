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

/**
 * This interface defines the functionality that is required for testing custom connector implementation.
 * The tests must verify behavior of all three handlers along with some implementation specific validations.
 */
public interface ConnectorTestInvoker {

    /**
     * Tests for the ConfigurationHandler. This includes verifying behaviour of ValidateCredentials,
     * ValidateConnectorRuntimeSetting and DescribeConnectorConfiguration.
     */
    void invokeConfigurationHandlerTests();

    /**
     * Tests for the MetadataHandler. This includes verifying behaviour of ListEntities and DescribeEntity.
     */
    void invokeMetadataHandlerTests();

    /**
     * Tests for the RecordHandler. This includes verifying behaviour of RetrieveData, WriteData and QueryData.
     */
    void invokeRecordHandlerTests();
}
