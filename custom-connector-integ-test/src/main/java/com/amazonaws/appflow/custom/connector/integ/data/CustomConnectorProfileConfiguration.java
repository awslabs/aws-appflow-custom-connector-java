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
package com.amazonaws.appflow.custom.connector.integ.data;

import com.amazonaws.appflow.custom.connector.integ.providers.AuthenticationType;
import com.amazonaws.services.appflow.model.OAuth2Properties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * Refer to sample-test-config.json
 */
@Value.Immutable
@JsonDeserialize(as = ImmutableCustomConnectorProfileConfiguration.class)
@JsonSerialize(as = ImmutableCustomConnectorProfileConfiguration.class)
public interface CustomConnectorProfileConfiguration {

    Optional<String> secretsManagerArn();

    String name();

    Optional<OAuth2Properties> oAuth2Properties();

    Optional<String> connectorName();

    Optional<Map<String, String>> profileProperties();

    AuthenticationType authenticationType();

    Optional<String> defaultApiVersion();
}
