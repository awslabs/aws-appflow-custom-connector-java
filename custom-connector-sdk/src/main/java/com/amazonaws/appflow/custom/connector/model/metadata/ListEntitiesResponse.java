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
import java.util.List;

/**
 * Represents the output of a <code>RetrieveData</> operation.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableListEntitiesResponse.class)
@JsonDeserialize(as = ImmutableListEntitiesResponse.class)
public interface ListEntitiesResponse {
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
     * List of entities.
     */
    @Nullable
    List<Entity> entities();

    /**
     * The pagination token for the next page of data.
     */
    @Nullable
    String nextToken();

    /**
     * Caching policy for the list of entities.
     */
    @Nullable
    CacheControl cacheControl();
}
