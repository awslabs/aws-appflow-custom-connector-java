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

import com.amazonaws.appflow.custom.connector.model.write.ImmutableWriteRecordResult;
import com.amazonaws.appflow.custom.connector.model.write.WriteRecordResult;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Sample implementation for parsing record API responses.
 */
public final class RecordResponseParser extends AbstractParser {
    private RecordResponseParser() {
    }

    private static final Gson GSON = new Gson();

    public static List<String> parseQueryResponse(final String jsonString) {
        final JsonObject parentObject = GSON.fromJson(jsonString, JsonObject.class);
        final List<String> records = new ArrayList<>();
        if (Objects.nonNull(parentObject.get("records"))) {
            final JsonArray jsonArray = parentObject.get("records").getAsJsonArray();
            for (final JsonElement jsonElement : jsonArray) {
                records.add(jsonElement.toString());
            }
        }
        return records;
    }

    public static WriteRecordResult parseWriteResponse(final String jsonString) {
        final JsonObject parentObject = GSON.fromJson(jsonString, JsonObject.class);
        return ImmutableWriteRecordResult.builder()
                .recordId(getStringValue(parentObject, "id"))
                .isSuccess(getBooleanValue(parentObject, "success"))
                .errorMessage(Objects.nonNull(parentObject.get("errors")) ?
                              parentObject.get("errors").getAsJsonArray().toString() : null)
                .build();
    }
}
