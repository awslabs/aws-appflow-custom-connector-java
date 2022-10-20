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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * Represents the entity structure.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableEntity.class)
@JsonDeserialize(as = ImmutableEntity.class)
public interface Entity {
    /**
     * Unique identifier for the entity. Can be entityId/ entityName / entityPath+name / entityUrl etc.
     */
    String entityIdentifier();

    /**
     * Specifies whether the connector entity is a parent or a category and has more entities nested underneath it.
     */
    boolean hasNestedEntities();

    /**
     * Specifies if the connector entity is writable
     */
    @Value.Default
    default boolean isWritable() { return true; }

    /**
     * Label of the entity.
     */
    @Nullable
    String label();

    /**
     * Description of the entity.
     */
    @Nullable
    String description();

    /**
     * Custom Properties of the entity.
     * A map that has specific properties related to the ConnectorEntity.
     */
    @Nullable
    Map<String, String> customProperties();
}
