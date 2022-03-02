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

package com.amazonaws.appflow.custom.connector.model.write;

import com.amazonaws.appflow.custom.connector.model.ConnectorContext;
import com.amazonaws.appflow.custom.connector.model.ConnectorRequest;
import com.amazonaws.appflow.custom.connector.model.ConnectorRequestStyle;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Represents the input of a <code>WriteData</> operation.
 */
@ConnectorRequestStyle
@Value.Immutable
@JsonSerialize(as = ImmutableWriteDataRequest.class)
@JsonDeserialize(as = ImmutableWriteDataRequest.class)
@JsonTypeName("WriteDataRequest")
public interface WriteDataRequest extends ConnectorRequest {
    /**
     * Unique identifier for the entity. Can be entityId/ entityName / entityPath+name / entityUrl etc.
     */
    String entityIdentifier();

    /**
     * Write operation type needs to be called.
     */
    WriteOperationType operation();

    /**
     * Primary keys of the entity. Used for DELETE/ UPDATE/ UPSERT operations.
     */
    @Nullable
    List<String> idFieldNames();

    /**
     * List of JSON serialized string of the entity record as per the entity metadata.
     */
    @Nullable
    List<String> records();

    /**
     * Specifies that the WRITE operation must fail immediately after encountering the first instance of failure
     * when writing a batch of records to the Application. Alternatively, if the application supports the allOrNone
     * behavior the connector can pass on the flag to the application.
     */
    @Nullable
    Boolean allOrNone();

    /**
     * Context contains the connector settings, credentials and API version etc.
     */
    ConnectorContext connectorContext();
}
