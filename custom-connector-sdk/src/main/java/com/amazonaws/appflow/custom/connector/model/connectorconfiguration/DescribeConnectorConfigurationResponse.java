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

package com.amazonaws.appflow.custom.connector.model.connectorconfiguration;

import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth.AuthenticationConfig;
import com.amazonaws.appflow.custom.connector.model.settings.ConnectorRuntimeSetting;
import com.amazonaws.appflow.custom.connector.model.write.WriteOperationType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the output of a <code>DescribeConnectorConfiguration</> operation.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableDescribeConnectorConfigurationResponse.class)
@JsonDeserialize(as = ImmutableDescribeConnectorConfigurationResponse.class)
public interface DescribeConnectorConfigurationResponse {

    /**
     * Name of the connector owner.
     */
    String connectorOwner();

    /**
     * Name of the connector.
     */
    String connectorName();

    /**
     * Version of the connector.
     */
    String connectorVersion();

    /**
     * List of <code>ConnectorMode</code> supported by the connector.
     */
    List<ConnectorModes> connectorModes();

    /**
     * <code>AuthenticationConfig</code> supported by the connector. Can be null if connector doesn't need any
     * credentials from customer.
     */
    @Nullable
    AuthenticationConfig authenticationConfig();

    /**
     * Custom connector runtime settings for which connector requires input from the end user.
     */
    @Nullable
    List<ConnectorRuntimeSetting> connectorRuntimeSetting();

    /**
     * List of API versions supported by connector for the underlying application. For example, if the underlying
     * application is Salesforce, then example could be List of {v46.0, v47.0, v48.9}.
     */
    List<String> supportedApiVersions();

    /**
     * Operators supported by the connector. Default: all the operators
     */
    @Value.Default
    default List<ConnectorOperator> operatorsSupported() {
        return Arrays.asList(ConnectorOperator.values());
    }

    /**
     * Trigger types supported by connector. Default is OnDemand and Scheduled.
     */
    @Value.Default
    default List<TriggerType> supportedTriggerTypes() {
        return Arrays.asList(TriggerType.values());
    }

    /**
     * Trigger frequencies supported by Connector. Default: all trigger frequencies
     */
    @Value.Default
    default List<TriggerFrequency> triggerFrequenciesSupported() {
        return Arrays.asList(TriggerFrequency.values());
    }

    /**
     * Write Operations supported by Connector. Only applicable if the connector support DESTINATION mode. Default is
     * all the Write Operation types supported.
     */
    @Value.Default
    default List<WriteOperationType> supportedWriteOperations() {
        return Arrays.asList(WriteOperationType.values());
    }

    /**
     * Logo URL for display purposes for connector icon.
     */
    @Nullable
    String logoURL();

    /**
     * Specifies if the operation is successful or not.
     */
    boolean isSuccess();

    /**
     * Error details if the Operation is unsuccessful.
     */
    @Nullable
    ErrorDetails errorDetails();
}
