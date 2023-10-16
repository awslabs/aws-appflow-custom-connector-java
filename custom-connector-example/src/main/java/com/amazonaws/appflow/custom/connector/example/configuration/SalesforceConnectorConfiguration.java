/*
 * -
 *  * #%L
 * * Example Custom Connector.
 *  *
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

package com.amazonaws.appflow.custom.connector.example.configuration;

import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.ConnectorModes;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth.ImmutableOAuth2Defaults;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth.OAuth2Defaults;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth.OAuth2GrantType;
import com.amazonaws.appflow.custom.connector.model.settings.ConnectorRuntimeSetting;
import com.amazonaws.appflow.custom.connector.model.settings.ConnectorRuntimeSettingDataType;
import com.amazonaws.appflow.custom.connector.model.settings.ConnectorRuntimeSettingScope;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth.AuthenticationConfig;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth.ImmutableAuthenticationConfig;
import com.amazonaws.appflow.custom.connector.model.settings.ImmutableConnectorRuntimeSetting;
import com.amazonaws.appflow.custom.connector.model.write.WriteOperationType;
import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.amazonaws.appflow.custom.connector.example.configuration.ConnectorSettingKey.INSTANCE_URL;
import static com.amazonaws.appflow.custom.connector.example.configuration.ConnectorSettingKey.IS_SANDBOX_ACCOUNT;

/**
 * Static Configuration for Salesforce connector.
 */
public final class SalesforceConnectorConfiguration {
    private SalesforceConnectorConfiguration() {
    }

    public static List<ConnectorRuntimeSetting> getConnectorRuntimeSettings() {
        ConnectorRuntimeSetting instanceUrl = ImmutableConnectorRuntimeSetting.builder()
                .key(INSTANCE_URL)
                .dataType(ConnectorRuntimeSettingDataType.Url)
                .required(true)
                .label("Salesforce Instance URL")
                .description("URL of the instance where user wants to run the operations.")
                .scope(ConnectorRuntimeSettingScope.CONNECTOR_PROFILE)
                .build();

        ConnectorRuntimeSetting isSandboxAccount = ImmutableConnectorRuntimeSetting.builder()
                .key(IS_SANDBOX_ACCOUNT)
                .dataType(ConnectorRuntimeSettingDataType.Boolean)
                .required(true)
                .label("Type of salesforce account")
                .description("Is Salesforce account a sandbox account")
                .scope(ConnectorRuntimeSettingScope.CONNECTOR_PROFILE)
                .build();

        return Arrays.asList(instanceUrl, isSandboxAccount);
    }

    public static List<ConnectorModes> getConnectorModes() {
        return Arrays.asList(ConnectorModes.SOURCE, ConnectorModes.DESTINATION);
    }

    public static AuthenticationConfig getAuthenticationConfig() {
        return ImmutableAuthenticationConfig.builder()
                .isOAuth2Supported(true)
                .oAuth2Defaults(getOAuth2Defaults())
                .build();
    }

    private static OAuth2Defaults getOAuth2Defaults() {
        return ImmutableOAuth2Defaults.builder()
                .authURL(ImmutableList.of("https://login.salesforce.com/services/oauth2/authorize",
                        "https://test.salesforce.com/services/oauth2/authorize"))
                .tokenURL(ImmutableList.of("https://login.salesforce.com/services/oauth2/token",
                        "https://test.salesforce.com/services/oauth2/token"))
                .oAuthScopes(Arrays.asList("api", "refresh_token"))
                .addOAuth2GrantTypesSupported(OAuth2GrantType.AUTHORIZATION_CODE)
                .build();
    }

    public static List<String> getSupportedApiVersions() {
        return Collections.singletonList(SupportedSalesforceVersion.V51.getVersionNumber());
    }

    public static List<WriteOperationType> supportedWriteOperations() {
        return Arrays.asList(WriteOperationType.INSERT, WriteOperationType.UPDATE, WriteOperationType.UPSERT);
    }
}
