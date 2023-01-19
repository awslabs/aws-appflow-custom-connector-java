/*-
 * #%L
 * aws-custom-connector-sdk
 * %%
 * Copyright (C) 2021 - 2023 Amazon Web Services
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
 */
package com.amazonaws.appflow.custom.connector.util;

import com.amazonaws.appflow.custom.connector.model.metadata.EntityDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDataType;
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDefinition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class the can validate whether an object matches SDK JSON format.
 */
public final class JSONValidator {

    private static final String DATA_FORMAT_ERROR_MESSAGE = "%s didn't fit the SDK format for type %s.";
    private static final String MALFORMED_JSON_OBJECT_ERROR_MESSAGE = "The data is not a valid JSON Object.";
    private final ObjectMapper objectMapper;

    /**
     * Class the can validate whether an object matches SDK JSON format.
     * @param objectMapper the object mapper used for serialization
     */
    public JSONValidator(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Method that validates ether an object matches SDK JSON format.
     * @param jsonObject the serialized JSON object to be validated.
     * @param formats the formats for each field.
     * @throws DataFormatValidationException thrown when the format is invalid.
     */
    public void validateJsonObject(final String jsonObject, final Map<String, FieldDataType> formats)
            throws DataFormatValidationException {
        JsonNode node;
        try {
            node = objectMapper.readValue(jsonObject, JsonNode.class);
        } catch (JsonProcessingException e) {
            throw new DataFormatValidationException(MALFORMED_JSON_OBJECT_ERROR_MESSAGE, e);
        }
        validateJsonObject(node, formats);
    }

    /**
     * Method that validates ether an object matches SDK JSON format.
     * @param jsonNode the JSON node to be validated.
     * @param formats the formats for each field.
     * @throws DataFormatValidationException Thrown when the format is invalid.
     */
    public void validateJsonObject(final JsonNode jsonNode, final Map<String, FieldDataType> formats)
            throws DataFormatValidationException {
        if (!jsonNode.isObject()) {
            throw new DataFormatValidationException(MALFORMED_JSON_OBJECT_ERROR_MESSAGE);
        }
        for (String field : formats.keySet()) {
            JsonNode fieldNode = jsonNode.get(field);
            if (fieldNode == null) {
                continue;
            }
            FieldDataType fieldDataType = formats.get(field);
            try {
                switch (fieldDataType) {
                    case Boolean:
                        ValidateField(fieldNode.isBoolean(), field, fieldDataType);
                        break;
                    case Float:
                        ValidateField(fieldNode.isNumber(), field, fieldDataType);
                        Float.parseFloat(fieldNode.asText());
                        break;
                    case Long:
                        ValidateField(fieldNode.isNumber(), field, fieldDataType);
                        Long.parseLong(fieldNode.asText());
                        break;
                    case Short:
                        ValidateField(fieldNode.isNumber(), field, fieldDataType);
                        Short.parseShort(fieldNode.asText());
                        break;
                    case Integer:
                        ValidateField(fieldNode.isNumber(), field, fieldDataType);
                        Integer.parseInt(fieldNode.asText());
                        break;
                    case Double:
                        ValidateField(fieldNode.isNumber(), field, fieldDataType);
                        Double.parseDouble(fieldNode.asText());
                        break;
                    case BigDecimal:
                        ValidateField(fieldNode.isNumber(), field, fieldDataType);
                        new BigDecimal(fieldNode.asText());
                        break;
                    case BigInteger:
                        ValidateField(fieldNode.isNumber(), field, fieldDataType);
                        new BigInteger(fieldNode.asText());
                        break;
                    case Map:
                    case Struct:
                        ValidateField(fieldNode.isObject(), field, fieldDataType);
                        break;
                    case Date:
                        ValidateField(fieldNode.isTextual(), field, fieldDataType);
                        String date = fieldNode.asText();
                        isValidFormat(date, DateTimeFormatter.ISO_DATE, field, fieldDataType);
                        break;
                    case DateTime:
                        ValidateField(fieldNode.isTextual(), field, fieldDataType);
                        String datetime = fieldNode.asText();
                        isValidFormat(datetime, DateTimeFormatter.ISO_DATE_TIME, field, fieldDataType);
                        break;
                    case String:
                    case ByteArray:
                        ValidateField(fieldNode.isTextual(), field, fieldDataType);
                        break;
                    case List:
                        ValidateField(fieldNode.isArray(), field, fieldDataType);
                        break;
                    default:
                        throw new DataFormatValidationException("No known datatype");
                }
            } catch (NumberFormatException e) {
                String message = String.format(DATA_FORMAT_ERROR_MESSAGE, field, formats.get(field));
                throw new DataFormatValidationException(message, e);
            }
        }
    }

    private static void isValidFormat(final String date, final DateTimeFormatter dateTimeFormatter, final String fieldName,
                                      final FieldDataType dataType) throws DataFormatValidationException {
        try {
            dateTimeFormatter.parse(date);
        } catch (DateTimeParseException e) {
            String message = String.format(DATA_FORMAT_ERROR_MESSAGE, fieldName, dataType);
            throw new DataFormatValidationException(message, e);
        }
    }

    private static void ValidateField(final boolean isValid, final String fieldName, final FieldDataType dataType)
            throws DataFormatValidationException {
        if (!isValid) {
            String message = String.format(DATA_FORMAT_ERROR_MESSAGE, fieldName, dataType);
            throw new DataFormatValidationException(message);
        }
    }

    /**
     * Utility to construct a DataType Map from the entity Definition
     * @param entityDefinition the Entity Definition used to construct a DataType Map
     * @return A DataType Map
     */
    public static Map<String, FieldDataType> getFormatsFromEntityDefinition(final EntityDefinition entityDefinition) {
        return entityDefinition.fields().stream().collect(Collectors.toMap(FieldDefinition::fieldName, FieldDefinition::dataType));
    }
}
