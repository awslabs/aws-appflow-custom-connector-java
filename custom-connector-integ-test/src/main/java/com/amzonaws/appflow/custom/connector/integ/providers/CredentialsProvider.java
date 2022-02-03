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
package com.amzonaws.appflow.custom.connector.integ.providers;

import com.amazonaws.services.appflow.model.ApiKeyCredentials;
import com.amazonaws.services.appflow.model.BasicAuthCredentials;
import com.amazonaws.services.appflow.model.CustomAuthCredentials;
import com.amazonaws.services.appflow.model.CustomConnectorProfileCredentials;
import com.amazonaws.services.appflow.model.OAuth2Credentials;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;

import com.amzonaws.appflow.custom.connector.integ.data.CustomConnectorProfileConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;

import static com.amzonaws.appflow.custom.connector.integ.providers.ServiceProvider.getSecretsManager;
import static com.amzonaws.appflow.custom.connector.integ.util.ConfigurationUtil.OBJECT_MAPPER;

/**
 * Responsible for providing user credentials from SecretsManager.
 */
public final class CredentialsProvider {

    private CredentialsProvider() {
    }

    /**
     * Builds the credentials by reading the data fetched from secret manager.
     *
     * @return- CustomConnectorProfileCredentials
     */
    public static CustomConnectorProfileCredentials getCustomConnectorProfileCredentials(final CustomConnectorProfileConfiguration profileConfiguration) {
        CustomConnectorProfileCredentials customConnectorProfileCredentials = new CustomConnectorProfileCredentials();

        if (profileConfiguration.authenticationType().equals(AuthenticationType.NO_AUTH) || !profileConfiguration.secretsManagerArn().isPresent()) {
            return customConnectorProfileCredentials;
        }
        AWSSecretsManager secretsManager = getSecretsManager();
        GetSecretValueResult secretValueResult = secretsManager.getSecretValue(new GetSecretValueRequest()
                .withSecretId(profileConfiguration.secretsManagerArn().get()));
        try {
            switch (profileConfiguration.authenticationType()) {
                case API_KEY:
                    return customConnectorProfileCredentials.withAuthenticationType(com.amazonaws.services.appflow.model.AuthenticationType.APIKEY)
                            .withApiKey(OBJECT_MAPPER.readValue(secretValueResult.getSecretString(), ApiKeyCredentials.class));
                case BASIC:
                    return customConnectorProfileCredentials.withAuthenticationType(com.amazonaws.services.appflow.model.AuthenticationType.BASIC)
                            .withBasic(OBJECT_MAPPER.readValue(secretValueResult.getSecretString(), BasicAuthCredentials.class));
                case OAUTH2:
                    return customConnectorProfileCredentials.withAuthenticationType(com.amazonaws.services.appflow.model.AuthenticationType.OAUTH2)
                            .withOauth2(OBJECT_MAPPER.readValue(secretValueResult.getSecretString(), OAuth2Credentials.class));
                case CUSTOM:
                    return customConnectorProfileCredentials.withAuthenticationType(com.amazonaws.services.appflow.model.AuthenticationType.CUSTOM)
                            .withCustom(OBJECT_MAPPER.readValue(secretValueResult.getSecretString(), CustomAuthCredentials.class));
                default:
                    throw new IllegalStateException("AuthenticationType is not defined");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to Serialize secrets value. Secret String must be a valid json");
        }
    }
}
