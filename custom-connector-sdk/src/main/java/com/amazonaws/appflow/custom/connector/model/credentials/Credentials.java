/*
 * -
 *  * #%L
 * * Amazon Appflow Custom Connector SDK.
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

package com.amazonaws.appflow.custom.connector.model.credentials;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;

/**
 * This class represents the Credentials structure. These credentials will be passed along with every connector
 * invocation within the ConnectorContext.
 *
 * @note Only one type of the Authentication credentials will be present (after the user selects the one they want
 * to use) and others will be null.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableCredentials.class)
@JsonDeserialize(as = ImmutableCredentials.class)
public interface Credentials {

    /**
     * ARN of the secret (authentication credentials) stored in AWS Secret Manager.
     */
    @Nullable
    String secretArn();

    /**
     * Authentication type associated with the credentials stored in AWS Secret Manager.
     */
    @Nullable
    AuthenticationType authenticationType();
}
