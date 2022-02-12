/*-
 * #%L
 * custom-connector-integ-test
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
package com.amazonaws.appflow.custom.connector.integ.providers;

import com.amazonaws.appflow.custom.connector.model.credentials.Credentials;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * Contains the test credentials required to create the connector profile.
 */
@Value.Immutable
@JsonDeserialize(as = ImmutableTestCredentials.class)
@JsonSerialize(as = ImmutableTestCredentials.class)
public interface TestCredentials {

    Optional<Credentials> credentials();

    Optional<String> clientId();

    Optional<String> clientSecret();
}
