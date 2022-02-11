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
import java.util.List;
import java.util.Map;

/**
 * Data model of the Entity.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableEntityDefinition.class)
@JsonDeserialize(as = ImmutableEntityDefinition.class)
public interface EntityDefinition {
    /**
     * Contains its name, description, label or if it has child properties or not.
     */
    Entity entity();

    /**
     * List of data models of the fields an Entity has.
     */
    List<FieldDefinition> fields();

    /**
     * Custom properties defined for an Entity.
     */
    @Nullable
    Map<String, String> customProperties();
}
