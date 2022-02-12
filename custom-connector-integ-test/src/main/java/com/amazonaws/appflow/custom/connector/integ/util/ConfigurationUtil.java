/*-
 * #%L
 * aws-custom-connector-integ-test
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
package com.amazonaws.appflow.custom.connector.integ.util;

import com.amazonaws.appflow.custom.connector.integ.data.TestConfiguration;
import com.amazonaws.services.appflow.model.DescribeConnectorEntityResult;
import com.amazonaws.services.appflow.model.DescribeConnectorResult;
import com.amazonaws.services.appflow.model.ListConnectorEntitiesResult;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;

/**
 * Util class for reading configuration files.
 */
public final class ConfigurationUtil {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new GuavaModule())
            .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(JsonParser.Feature.ALLOW_COMMENTS)
            .registerModule(new Jdk8Module());

    private static TestConfiguration testConfiguration;

    private ConfigurationUtil() {}

    public static TestConfiguration getTestConfiguration(final ITestContext iTestContext) {
        if (testConfiguration != null) {
            return testConfiguration;
        }
        try {
            testConfiguration = OBJECT_MAPPER.readValue(new File(iTestContext.getSuite().getParameter("testConfig")), TestConfiguration.class);
            return testConfiguration;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static DescribeConnectorResult getDescribeConnectorFile(final String file) {
        try {
            return OBJECT_MAPPER.readValue(new File(file), DescribeConnectorResult.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static ListConnectorEntitiesResult getListEntitiesFile(final String file) {
        try {
            return OBJECT_MAPPER.readValue(new File(file), ListConnectorEntitiesResult.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static DescribeConnectorEntityResult getDescribeEntityFile(final String file) {
        try {
            return OBJECT_MAPPER.readValue(new File(file), DescribeConnectorEntityResult.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
