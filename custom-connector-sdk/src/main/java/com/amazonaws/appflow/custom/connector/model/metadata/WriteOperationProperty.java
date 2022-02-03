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

import com.amazonaws.appflow.custom.connector.model.write.WriteOperationType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;

/**
 * The properties that can be applied to a field when connector is being used as a DESTINATION.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableWriteOperationProperty.class)
@JsonDeserialize(as = ImmutableWriteOperationProperty.class)
public interface WriteOperationProperty {
    /**
     * Specifies if the destination field can be created by the current user.
     */
    @Nullable
    Boolean isCreatable();

    /**
     * Specifies whether the field can be updated during an UPDATE or UPSERT write operation.
     */
    @Nullable
    Boolean isUpdatable();

    /**
     * Specifies if the destination field can have a null value.
     */
    @Nullable
    Boolean isNullable();

    /**
     * Specifies if the flow run can either insert new rows in the destination field if they do not already exist, or
     * update them if they do.
     */
    @Nullable
    Boolean isUpsertable();

    /**
     * Specifies if default value will be used by application while creating records if not provided.
     */
    @Nullable
    Boolean isDefaultedOnCreate();

    /**
     * A list of supported write operations. For each write operation listed, this field can be used in idFieldNames
     * when that write operation is present as a destination option.
     */
    @Nullable
    List<WriteOperationType> supportedWriteOperations();
}
