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

package com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Represents Authentication types supported by the connector.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableAuthenticationConfig.class)
@JsonDeserialize(as = ImmutableAuthenticationConfig.class)
public interface AuthenticationConfig {

    /**
     * Specifies if the Basic Auth is supported by connector.
     */
    @Nullable
    Boolean isBasicAuthSupported();

    /**
     * Specifies if the ApiKey Auth is supported by connector.
     */
    @Nullable
    Boolean isApiKeyAuthSupported();

    /**
     * Specifies if the OAuth2 is supported by connector.
     */
    @Nullable
    Boolean isOAuth2Supported();

    /**
     * Specifies if the Custom Authentication is supported by connector.
     */
    @Nullable
    Boolean isCustomAuthSupported();

    /**
     * OAuth2 default values provided by the connector.
     */
    @Nullable
    OAuth2Defaults oAuth2Defaults();

    /**
     * Configuration for custom Authentication defined by the connector.
     */
    @Nullable
    List<CustomAuthConfig> customAuthConfig();
}
