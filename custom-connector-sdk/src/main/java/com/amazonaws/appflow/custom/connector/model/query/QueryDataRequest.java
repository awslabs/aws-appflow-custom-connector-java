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

package com.amazonaws.appflow.custom.connector.model.query;

import com.amazonaws.appflow.custom.connector.model.ConnectorContext;
import com.amazonaws.appflow.custom.connector.model.ConnectorRequest;
import com.amazonaws.appflow.custom.connector.model.ConnectorRequestStyle;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;

import static com.amazonaws.appflow.custom.connector.Constants.MAX_RESULT_SIZE;

/**
 * Represents the input of a <code>QueryData</> operation.
 */
@ConnectorRequestStyle
@Value.Immutable
@JsonSerialize(as = ImmutableQueryDataRequest.class)
@JsonDeserialize(as = ImmutableQueryDataRequest.class)
@JsonTypeName("QueryDataRequest")
public interface QueryDataRequest extends ConnectorRequest {
    /**
     * Unique identifier for the entity. Can be entityId/ entityName / entityPath+name / entityUrl etc.
     */
    String entityIdentifier();

    /**
     * Field values to retrieve. If null, it will provide all the fields for the entity.
     */
    @Nullable
    List<String> selectedFieldNames();

    /**
     * Filter expression string similar to the WHERE clause in SQL.
     */
    @Nullable
    String filterExpression();

    /**
     * Maximum number of records needs to be returned as part of single call. Default value is 1000.
     */
    @Value.Default
    default Long maxResults() {
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
