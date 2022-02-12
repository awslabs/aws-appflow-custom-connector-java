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

package com.amazonaws.appflow.custom.connector.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Custom Object mapper with all the required modules registered.
 */
public final class CustomObjectMapper {
    private CustomObjectMapper() {
    }

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            // To properly serialize and deserialize the Immutable collections
            .registerModule(new GuavaModule())
            // To properly serialize and deserialize the Jdk8 related classes such as Optional.
            .registerModule(new Jdk8Module())
            // To properly serialize and deserialize java time objects
            .registerModule(new JavaTimeModule())
            // Enabling the below features
            .enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES)
            // Disabling the below features
            .disable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);

    /**
     * Returns a new instance of ObjectMapper.
     */
    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER.copy();
    }
}
