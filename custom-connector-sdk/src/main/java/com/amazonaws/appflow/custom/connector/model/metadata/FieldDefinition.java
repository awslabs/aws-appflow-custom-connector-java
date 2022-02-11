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

import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator.BETWEEN;
import static com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator.CONTAINS;
import static com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator.EQUAL_TO;
import static com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator.GREATER_THAN;
import static com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator.GREATER_THAN_OR_EQUAL_TO;
import static com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator.LESS_THAN;
import static com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator.LESS_THAN_OR_EQUAL_TO;
import static com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorOperator.NOT_EQUAL_TO;

/**
 * Describes the data model of a field. For example, for an account entity, the fields would be account name, account
 * ID, and so on.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableFieldDefinition.class)
@JsonDeserialize(as = ImmutableFieldDefinition.class)
public interface FieldDefinition {
    /**
     * The unique identifier of the connector field.
     */
    String fieldName();

    /**
     * DataType of this field.
     */
    FieldDataType dataType();

    /**
     * Application specific description of the dataType, so that AppFlow user can be presented with the same information
     * in the public API for exposing connector specific metadata
     */
    @Value.Default
    default String dataTypeLabel() {
       return dataType().name();
    }

    /**
     * Label for this field.
     */
    @Nullable
    String label();

    /**
     * Description of this field.
     */
    @Nullable
    String description();

    /**
     * Specifies if it can be used as a primary key.
     */
    @Nullable
    Boolean isPrimaryKey();

    /**
     * Default value of the field.
     */
    @Nullable
    String defaultValue();

    /**
     * Specifies if this field is deprecated.
     */
    @Nullable
    Boolean isDeprecated();

    /**
     * Constraints applicable to this field like length, value etc.
     */
    @Nullable
    FieldConstraints constraints();

    /**
     * The properties that can be applied to a field when the connector is being used as a SOURCE.
     */
    @Nullable
    ReadOperationProperty readProperties();

    /**
     * The properties applied to a field when the connector is being used as a destination.
     */
    @Nullable
    WriteOperationProperty writeProperties();

    /**
     * Filter Operators applicable for this field. This method can be overridden by the connector developers for
     * specific use cases. For example if they wish to disallow certain operators for specific data types, that can be
     * modified by overriding this method.
     */
    @Value.Default
    default List<ConnectorOperator> filterOperators() {
        switch (dataType()) {
            case Integer:
            case Float:
            case Double:
            case Long:
            case Short:
            case BigInteger:
            case BigDecimal:
                return Arrays.asList(NOT_EQUAL_TO, EQUAL_TO, LESS_THAN, LESS_THAN_OR_EQUAL_TO, GREATER_THAN,
                        GREATER_THAN_OR_EQUAL_TO);
            case Date:
            case DateTime:
                return Arrays.asList(EQUAL_TO, LESS_THAN, LESS_THAN_OR_EQUAL_TO, GREATER_THAN, GREATER_THAN_OR_EQUAL_TO,
                        BETWEEN);
            case String:
                return Arrays.asList(CONTAINS, EQUAL_TO, NOT_EQUAL_TO);
            case Boolean:
                return Arrays.asList(EQUAL_TO, NOT_EQUAL_TO);
            case Map:
            case List:
                return Collections.singletonList(CONTAINS);
            case Struct:
            case ByteArray:
                return Collections.emptyList();
            default:
                throw new IllegalArgumentException("FilterOperators are not defined for dataType " + dataType());
        }
    }

    /**
     * Custom properties defined for this field.
     */
    @Nullable
    Map<String, String> customProperties();
}
