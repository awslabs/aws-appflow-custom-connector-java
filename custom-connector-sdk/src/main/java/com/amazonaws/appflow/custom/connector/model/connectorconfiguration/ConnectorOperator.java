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

package com.amazonaws.appflow.custom.connector.model.connectorconfiguration;

/**
 * Enumerates the set of operations that are allowed for constructing filter criteria against specific entity fields.
 */
public enum ConnectorOperator {

    // TODO: Need to add description for each of the following

    // Column Filter Operator
    PROJECTION,

    // Row Filter Operators
    LESS_THAN,
    GREATER_THAN,
    BETWEEN,
    LESS_THAN_OR_EQUAL_TO,
    GREATER_THAN_OR_EQUAL_TO,
    EQUAL_TO,
    CONTAINS,
    NOT_EQUAL_TO,

    // Operators with a Destination Field
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION,

    // Masking related operators
    MASK_ALL,
    MASK_FIRST_N,
    MASK_LAST_N,

    // Validation specific operators
    VALIDATE_NON_NULL,
    VALIDATE_NON_ZERO,
    VALIDATE_NON_NEGATIVE,
    VALIDATE_NUMERIC,

    NO_OP
}
