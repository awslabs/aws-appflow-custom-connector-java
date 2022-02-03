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

package com.amazonaws.appflow.custom.connector.model;

import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ImmutableDescribeConnectorConfigurationRequest;
import com.amazonaws.appflow.custom.connector.model.credentials.ImmutableValidateCredentialsRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableDescribeEntityRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.query.ImmutableQueryDataRequest;
import com.amazonaws.appflow.custom.connector.model.retreive.ImmutableRetrieveDataRequest;
import com.amazonaws.appflow.custom.connector.model.settings.ImmutableValidateConnectorRuntimeSettingsRequest;
import com.amazonaws.appflow.custom.connector.model.write.ImmutableWriteDataRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Base class for all user facing requests.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ImmutableValidateConnectorRuntimeSettingsRequest.class, name = "ValidateConnectorRuntimeSettingsRequest"),
        @JsonSubTypes.Type(value = ImmutableValidateCredentialsRequest.class, name = "ValidateCredentialsRequest"),
        @JsonSubTypes.Type(value = ImmutableDescribeEntityRequest.class, name = "DescribeEntityRequest"),
        @JsonSubTypes.Type(value = ImmutableListEntitiesRequest.class, name = "ListEntitiesRequest"),
        @JsonSubTypes.Type(value = ImmutableDescribeConnectorConfigurationRequest.class, name = "DescribeConnectorConfigurationRequest"),
        @JsonSubTypes.Type(value = ImmutableQueryDataRequest.class, name = "QueryDataRequest"),
        @JsonSubTypes.Type(value = ImmutableRetrieveDataRequest.class, name = "RetrieveDataRequest"),
        @JsonSubTypes.Type(value = ImmutableWriteDataRequest.class, name = "WriteDataRequest")})
public interface ConnectorRequest extends AutoCloseable {
    @Override
    default void close() throws Exception {
    }
}
