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

package com.amazonaws.appflow.custom.connector.handlers;

import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationRequest;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.DescribeConnectorConfigurationResponse;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsRequest;
import com.amazonaws.appflow.custom.connector.model.credentials.ValidateCredentialsResponse;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsRequest;
import com.amazonaws.appflow.custom.connector.model.settings.ValidateConnectorRuntimeSettingsResponse;

/**
 * This interface defines the functionality to be implemented by custom connectors for configurations, credentials
 * related operations.
 */
public interface ConfigurationHandler {
    /**
     * Validates the user inputs corresponding to the connector settings for a given ConnectorRuntimeSettingScope.
     *
     * @param request - {@link ValidateConnectorRuntimeSettingsRequest}
     * @return - {@link ValidateConnectorRuntimeSettingsResponse}
     */
    ValidateConnectorRuntimeSettingsResponse validateConnectorRuntimeSettings(ValidateConnectorRuntimeSettingsRequest request);

    /**
     * Validates the user provided credentials.
     *
     * @param request - {@link ValidateCredentialsRequest}
     * @return - {@link ValidateCredentialsResponse}
     */
    ValidateCredentialsResponse validateCredentials(ValidateCredentialsRequest request);

    /**
     * Describes the Connector Configuration supported by the connector.
     *
     * @param request - {@link DescribeConnectorConfigurationRequest}
     * @return {@link DescribeConnectorConfigurationResponse}
     */
    DescribeConnectorConfigurationResponse describeConnectorConfiguration(DescribeConnectorConfigurationRequest request);
}
