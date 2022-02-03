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

package com.amazonaws.appflow.custom.connector.model.metadata;

import com.amazonaws.appflow.custom.connector.model.ConnectorContext;
import com.amazonaws.appflow.custom.connector.model.ConnectorRequest;
import com.amazonaws.appflow.custom.connector.model.ConnectorRequestStyle;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;

import static com.amazonaws.appflow.custom.connector.Constants.MAX_RESULT_SIZE;

/**
 * Represents the input of a <code>ListEntities</> operation.
 */
@ConnectorRequestStyle
@Value.Immutable
@JsonSerialize(as = ImmutableListEntitiesRequest.class)
@JsonDeserialize(as = ImmutableListEntitiesRequest.class)
@JsonTypeName("ListEntitiesRequest")
public interface ListEntitiesRequest extends ConnectorRequest {
    /**
     * Path/URI of entities.
     */
    @Nullable
    String entitiesPath();

    /**
     * Maximum number of records needs to be returned as part of single call. Default value is 1000.
     */
    @Nullable
    @Value.Default
    default Long maxResult() {
        return MAX_RESULT_SIZE;
    }

    /**
     * The pagination token - next page should start from this token value.
     */
    @Nullable
    String nextToken();

    /**
     * Context contains the connector settings, credentials and APi version etc.
     */
    ConnectorContext connectorContext();
}
