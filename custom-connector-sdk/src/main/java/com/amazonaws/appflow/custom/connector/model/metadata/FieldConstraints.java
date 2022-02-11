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

/**
 * Constraints that are applicable to the Field.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableFieldConstraints.class)
@JsonDeserialize(as = ImmutableFieldConstraints.class)
public interface FieldConstraints {
    /**
     * Min and Max range of the length of the value.
     */
    @Nullable
    RangeConstraint allowedLengthRange();

    /**
     * Min and Max range of value of this field.
     */
    @Nullable
    RangeConstraint allowedValueRange();

    /**
     * List of allowed values for this field.
     */
    @Nullable
    List<String> allowedValues();

    /**
     * Value of the field should match with this regex pattern.
     */
    @Nullable
    String allowedValuesRegexPattern();

    /**
     * Allowed data format for the field.
     */
    @Nullable
    String allowedDateFormat();
}
