/*
 * -
 *  * #%L
 * * Example Custom Connector.
 *  *
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

package com.amazonaws.appflow.custom.connector.example.parser;

import com.amazonaws.appflow.custom.connector.model.metadata.Entity;
import com.amazonaws.appflow.custom.connector.model.metadata.EntityDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDataType;
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableEntity;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableEntityDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableFieldDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableReadOperationProperty;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableWriteOperationProperty;
import com.amazonaws.appflow.custom.connector.model.write.WriteOperationType;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Sample implementation for parsing metadata API responses.
 */
public final class EntityParser extends AbstractParser {

    private EntityParser() {
    }

    private static final Gson GSON = new Gson();

    public static List<Entity> parseEntity(final String jsonString) {
        final JsonObject parentObject = GSON.fromJson(jsonString, JsonObject.class);
        final List<Entity> entityList = new ArrayList<>();
        if (Objects.nonNull(parentObject.get("sobjects"))) {
            final JsonArray jsonArray = parentObject.get("sobjects").getAsJsonArray();
            for (final JsonElement jsonElement : jsonArray) {
                entityList.add(buildEntity(jsonElement.getAsJsonObject()));
            }
        } else if (Objects.nonNull(parentObject.getAsJsonObject("objectDescribe"))) {
            entityList.add(buildEntity(parentObject.getAsJsonObject("objectDescribe")));
        }

        return entityList;
    }

    public static EntityDefinition parseEntityDefinition(final String jsonString) {
        final List<FieldDefinition> fieldDefinitions = new ArrayList<>();
        final JsonObject parentObject = GSON.fromJson(jsonString, JsonObject.class);
        final Entity entity = buildEntity(parentObject);

        if (Objects.nonNull(parentObject.get("fields"))) {
            final JsonArray jsonArray = parentObject.get("fields").getAsJsonArray();
            for (final JsonElement jsonElement : jsonArray) {
                fieldDefinitions.add(buildFieldDefinition(jsonElement.getAsJsonObject()));
            }
        }

        return ImmutableEntityDefinition.builder().entity(entity).fields(fieldDefinitions).build();
    }

    private static Entity buildEntity(final JsonObject field) {
        final String name = getStringValue(field, "name");
        final boolean hasNestedEntities =
                getBooleanValue(field, "hasSubtypes") || checkChildRelationship(field.get("childRelationships"));
        final String description = getStringValue(field, "label");
        final Entity entity = ImmutableEntity.builder()
                .entityIdentifier(name)
                .label(description)
                .hasNestedEntities(hasNestedEntities)
                .description(description)
                .build();
        return entity;
    }

    private static FieldDefinition buildFieldDefinition(final JsonObject field) {
        final String displayName = getStringValue(field, "label");
        final String fieldName = getStringValue(field, "name");
        final String type = getStringValue(field, "type");
        final FieldDataType dataType = convertDataType(type);
        List<WriteOperationType> writeOperationTypes = new ArrayList<>();
        if (getBooleanValue(field, "externalId")) {
            writeOperationTypes.add(WriteOperationType.UPSERT);
        } else if (getBooleanValue(field, "idLookup")) {
            writeOperationTypes.add(WriteOperationType.UPDATE);
            writeOperationTypes.add(WriteOperationType.UPSERT);
        }
        final FieldDefinition fieldDefinition = ImmutableFieldDefinition.builder()
                .fieldName(fieldName)
                .dataType(dataType)
                .dataTypeLabel(type)
                .label(displayName)
                .description(displayName)
                .defaultValue(getStringValue(field, "defaultValue"))
                .isPrimaryKey(getBooleanValue(field, "unique"))
                .readProperties(ImmutableReadOperationProperty.builder()
                        .isQueryable(getBooleanValue(field, "filterable"))
                        .isRetrievable(true)
                        .build())
                .writeProperties(ImmutableWriteOperationProperty.builder()
                        .isNullable(getBooleanValue(field, "nillable"))
                        .isUpdatable(getBooleanValue(field, "updateable"))
                        .isCreatable(getBooleanValue(field, "createable"))
                        .isDefaultedOnCreate(getBooleanValue(field, "defaultedOnCreate"))
                        .supportedWriteOperations(writeOperationTypes)
                        .build())
                .build();
        return fieldDefinition;
    }

    private static boolean checkChildRelationship(final JsonElement jsonObject) {
        if (Objects.isNull(jsonObject)) {
            return false;
        }
        final JsonArray childRelationships = jsonObject.getAsJsonArray();
        return !childRelationships.isJsonNull() && childRelationships.size() != 0;
    }

    private static FieldDataType convertDataType(final String type) {
        switch (type) {
            case "int":
                return FieldDataType.Integer;
            case "double":
                return FieldDataType.Double;
            case "long":
                return FieldDataType.Long;
            case "id":
            case "string":
            case "textarea":
                return FieldDataType.String;
            case "date":
                return FieldDataType.Date;
            case "datetime":
            case "time":
                return FieldDataType.DateTime;
            case "boolean":
                return FieldDataType.Boolean;
            default:
                return FieldDataType.Struct;
        }
    }
}
