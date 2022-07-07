/*
 * -
 *  * #%L
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

package com.amazonaws.appflow.custom.connector.model;

import com.amazonaws.appflow.custom.connector.model.credentials.Credentials;
import com.amazonaws.appflow.custom.connector.model.metadata.EntityDefinition;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Represents the Connector Context which contains the connectorRuntimeSettings, credentials, apiVersion, entityMetadata.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableConnectorContext.class)
@JsonDeserialize(as = ImmutableConnectorContext.class)
public interface ConnectorContext {

    /**
     * Connector settings required for API call. For example, for the Read API it will contains all the
     * ConnectorSettingScope.SOURCE settings. Key will be ConnectorSetting.key() and value will be the input provided by
     * user.
     */
    @Nullable
    Map<String, String> connectorRuntimeSettings();

    /**
     * Credentials which will be used to make API call.
     */
    @Nullable
    Credentials credentials();

    /**
     * API version to use. Value will be the API Version supported by Connector as part of Connector Configuration.
     */
    @Nullable
    String apiVersion();

    /**
     * Flow name to use for logging.
     * @return
     */
    @Nullable
    String flowName();

    /**
     * Execution Id to use for logging.
     * @return
     */
    @Nullable
    String executionId();

    /**
     * Connector profile name to use for logging.
     * @return
     */
    @Nullable
    String connectorProfileLabel();

    /**
     * Entity definition in compressed form. As it will be required by calling application as well as connector lambda
     * to serialize/deserialize request/response payload.
     */
    @Nullable
    EntityDefinition entityDefinition();
}
