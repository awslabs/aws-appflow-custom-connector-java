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

package com.amazonaws.appflow.custom.connector.model.metadata;

import com.amazonaws.appflow.custom.connector.model.CacheControl;
import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;

/**
 * Represents the output of a <code>DescribeEntity</> operation.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableDescribeEntityResponse.class)
@JsonDeserialize(as = ImmutableDescribeEntityResponse.class)
public interface DescribeEntityResponse {
    /**
     * Specifies if the operation is successful or not.
     */
    boolean isSuccess();

    /**
     * Error details if the Operation is unsuccessful.
     */
    @Nullable
    ErrorDetails errorDetails();

    /**
     * Data model of the entity.
     */
    @Nullable
    EntityDefinition entityDefinition();

    /**
     * Caching policy for the entity.
     */
    @Nullable
    CacheControl cacheControl();
}
