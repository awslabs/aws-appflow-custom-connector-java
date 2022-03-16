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
 * Default OAuth2 Params values defined by Connector.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableOAuth2Defaults.class)
@JsonDeserialize(as = ImmutableOAuth2Defaults.class)
public interface OAuth2Defaults {

    /**
     * OAuth Scopes. Required for OAuth2GrantType - AUTHORIZATION_CODE.
     */
    @Nullable
    List<String> oAuthScopes();

    /**
     * Token URLs. Required for both OAuth2GrantType - AUTHORIZATION_CODE and CLIENT_CREDENTIALS.
     * This URL can be in two format - Static and Template based where we need the input from the Customer to build the complete URL.
     * For Static URLs you can add the URL directly to this list like 
     *  - https://mc17nm2rn5qghzw-lk5r70cv2prm.auth.marketingcloudapis.com/v2/token.
     * And for template based URLs, you can use this format
     *  - https://{{SALESFORCE_SUBDOMAIN}}.auth.marketingcloudapis.com/v2/token where the SALESFORCE_SUBDOMAIN 
     * will be the user input and AppFlow will ask the customers to provide its value while 
     * configuring the connector profile.
     */
    List<String> tokenURL();

    /**
     * Auth URLs. Required for OAuth2GrantType - AUTHORIZATION_CODE.
     * This URL can be in two format - Static and Template based where we need the input from the Customer to build the complete URL.
     * For Static URLs you can add the URL directly to this list like
     *  - https://login.salesforce.com/services/oauth2/token.
     * And for template based URLs, you can use this format
     *  - https://{{SALESFORCE_SUBDOMAIN}}.auth.marketingcloudapis.com/v2/token where the SALESFORCE_SUBDOMAIN
     * will be the user input and AppFlow will ask the customers to provide its value while
     * configuring the connector profile.
     */
    @Nullable
    List<String> authURL();

    /**
     * OAuth2 Grant types supported by connector.
     */
    List<OAuth2GrantType> oAuth2GrantTypesSupported();
}
