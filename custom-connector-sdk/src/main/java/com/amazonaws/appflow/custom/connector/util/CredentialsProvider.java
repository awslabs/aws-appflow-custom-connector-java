/*-
 * #%L
 * Amazon AppFlow Custom Connector SDK
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
package com.amazonaws.appflow.custom.connector.util;

import com.amazonaws.appflow.custom.connector.model.credentials.ApiKeyCredentials;
import com.amazonaws.appflow.custom.connector.model.credentials.BasicAuthCredentials;
import com.amazonaws.appflow.custom.connector.model.credentials.CustomAuthCredentials;
import com.amazonaws.appflow.custom.connector.model.credentials.OAuth2Credentials;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.amazonaws.appflow.custom.connector.model.credentials.ImmutableApiKeyCredentials;
import com.amazonaws.appflow.custom.connector.model.credentials.ImmutableBasicAuthCredentials;
import com.amazonaws.appflow.custom.connector.model.credentials.ImmutableCustomAuthCredentials;
import com.amazonaws.appflow.custom.connector.model.credentials.ImmutableOAuth2Credentials;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import static com.amazonaws.appflow.custom.connector.Constants.ACCESS_TOKEN;
import static com.amazonaws.appflow.custom.connector.Constants.API_KEY;
import static com.amazonaws.appflow.custom.connector.Constants.CUSTOM_AUTHENTICATION_TYPE;
import static com.amazonaws.appflow.custom.connector.Constants.PASSWORD;
import static com.amazonaws.appflow.custom.connector.Constants.SECRET_KEY;
import static com.amazonaws.appflow.custom.connector.Constants.USERNAME;
import static com.amazonaws.appflow.custom.connector.Constants.AUTHENTICATION_TYPE;

public final class CredentialsProvider {

    private CredentialsProvider() {
    }

   private static Map<String, String> getCredentials(final AWSSecretsManager client, final String secretArn) {
        AWSSecretsManager secretsManager = null;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
               .withSecretId(secretArn);

        try {
            GetSecretValueResult secretValueResult;
            if (client != null) {
                secretValueResult = client.getSecretValue(getSecretValueRequest);
            } else {
                secretsManager = AWSSecretsManagerClientBuilder.defaultClient();
                secretValueResult = secretsManager.getSecretValue(getSecretValueRequest);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> credentials = objectMapper.readValue(secretValueResult.getSecretString(),
                    HashMap.class);
            return credentials;
        } catch (Exception e) {
            throw new RuntimeException(String.format("Unable to get secrets from SecretsManager. SecretArn [%s]: %s",
                    secretArn, e.getMessage()), e);
        } finally {
            if (secretsManager != null) {
                secretsManager.shutdown();
            }
        }
   }

   public static BasicAuthCredentials getBasicAuthCredentials(final AWSSecretsManager client, final String secretArn) {
       Map<String, String> credentials = getCredentials(client, secretArn);
        return ImmutableBasicAuthCredentials.builder()
                .userName(credentials.get(USERNAME))
                .password(credentials.get(PASSWORD))
                .build();
    }

    public static OAuth2Credentials getOAuth2Credentials(final AWSSecretsManager client, final String secretArn) {
        Map<String, String> credentials = getCredentials(client, secretArn);
        return ImmutableOAuth2Credentials.builder()
                .accessToken(credentials.get(ACCESS_TOKEN))
                .build();
    }

    public static ApiKeyCredentials getApiKeyCredentials(final AWSSecretsManager client, final String secretArn) {
        Map<String, String> credentials = getCredentials(client, secretArn);
        return ImmutableApiKeyCredentials.builder()
                .apiKey(credentials.get(API_KEY))
                .secretKey(credentials.get(SECRET_KEY))
                .build();
    }

    public static CustomAuthCredentials getCustomAuthCredentials(final AWSSecretsManager client, final String secretArn) {
        Map<String, String> credentials = getCredentials(client, secretArn);
        String customAuthenticationType = credentials.get(CUSTOM_AUTHENTICATION_TYPE);
        credentials.remove(CUSTOM_AUTHENTICATION_TYPE);
        credentials.remove(AUTHENTICATION_TYPE);
        return ImmutableCustomAuthCredentials.builder()
                .customAuthenticationType(customAuthenticationType)
                .customCredentials(credentials)
                .build();
    }
}
