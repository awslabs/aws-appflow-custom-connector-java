/*-
 * #%L
 * custom-connector-example
 * %%
 * Copyright (C) 2021 Amazon Web Services
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
package com.amazonaws.appflow.custom.connector.example.parser;

import com.google.gson.JsonObject;

public abstract class AbstractParser {

    //Gets a String value from a Json Object and defaults to null with null values
    protected static String getStringValue(final JsonObject object, final String fieldName) {
        if (fieldName == null || object.get(fieldName) == null || object.get(fieldName).isJsonNull()) {
            return null;
        } else {
            return object.get(fieldName).getAsString();
        }
    }

    //Gets a Boolean value from a Json Object and defaults to false with null values
    // will default to true if fieldname is "true"
    protected static boolean getBooleanValue(final JsonObject object, final String fieldName) {
        if (fieldName == null) {
            return false;
        } else if ("true".equals(fieldName)) {
            return true;
        } else if (object.get(fieldName).isJsonNull()) {
            return false;
        } else {
            return object.get(fieldName).getAsBoolean();
        }
    }
}
