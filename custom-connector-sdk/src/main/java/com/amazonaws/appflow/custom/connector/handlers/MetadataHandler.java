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

package com.amazonaws.appflow.custom.connector.handlers;

import com.amazonaws.appflow.custom.connector.model.metadata.DescribeEntityRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.DescribeEntityResponse;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesResponse;

/**
 * This interface defines the functionality to be implemented by custom connectors for metadata operations.
 */
public interface MetadataHandler {
    /**
     * Lists all the entities available in a paginated fashion. This API is recursive in nature and provides a heretical
     * entity listing based on entityPath. If the ListEntityResponse returns hasChildren=true that indicates that
     * there are more entities in the next level.
     *
     * @param request - {@link ListEntitiesRequest}
     * @return - {@link ListEntitiesResponse}
     */
    ListEntitiesResponse listEntities(ListEntitiesRequest request);

    /**
     * Describes the entity definition with its field level metadata.
     *
     * @param request - {@link DescribeEntityRequest}
     * @return - {@link DescribeEntityResponse}
     */
    DescribeEntityResponse describeEntity(DescribeEntityRequest request);
}
