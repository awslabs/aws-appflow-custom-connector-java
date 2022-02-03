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
package com.amzonaws.appflow.custom.connector.integ.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Refer to sample-test-config.json
 */
@Value.Immutable
@JsonDeserialize(as = ImmutableOnDemandFromS3TestConfiguration.class)
@JsonSerialize(as = ImmutableOnDemandFromS3TestConfiguration.class)
public interface OnDemandFromS3TestConfiguration {
    Optional<String> testName();

    Optional<String> apiVersion();

    Optional<String> profileName();

    String entityName();

    String flowName();

    Optional<List<String>> idFieldNames();

    String writeOperationType();

    Optional<Integer> flowTimeout();

    Optional<String> sourceDataFile();

    Optional<String> dataGeneratorClassName();

    Optional<Map<String, String>> destinationRuntimeSettings();
}
