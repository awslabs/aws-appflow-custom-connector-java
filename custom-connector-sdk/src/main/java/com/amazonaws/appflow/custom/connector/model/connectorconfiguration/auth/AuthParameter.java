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

package com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Represents the authentication parameter.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableAuthParameter.class)
@JsonDeserialize(as = ImmutableAuthParameter.class)
public interface AuthParameter {
    /**
     * Unique identifier for AuthParameter.
     */
    String key();

    /**
     * Specifies if this AuthParameter is required or not.
     */
    boolean required();

    /**
     * Label of the Auth Parameter.
     */
    String label();

    /**
     * Description of the Auth Parameter.
     */
    String description();

    /**
     * Specifies if this field data is sensitive/Critical that shouldn't be stored as plain text.
     */
    @Nullable
    Boolean sensitiveField();

    /**
     * Values provided by connector which can be used as input for this AuthParameter.
     */
    @Nullable
    List<String> connectorSuppliedValues();
}
