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

package com.amazonaws.appflow.custom.connector.model.connectorconfiguration;

import com.amazonaws.appflow.custom.connector.model.ConnectorRequest;
import com.amazonaws.appflow.custom.connector.model.ConnectorRequestStyle;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;

/**
 * Represents the input of a <code>DescribeConnectorConfiguration</> operation.
 */
@ConnectorRequestStyle
@Value.Immutable
@JsonSerialize(as = ImmutableDescribeConnectorConfigurationRequest.class)
@JsonDeserialize(as = ImmutableDescribeConnectorConfigurationRequest.class)
@JsonTypeName("DescribeConnectorConfigurationRequest")
public interface DescribeConnectorConfigurationRequest extends ConnectorRequest {

    /**
     * Locale value to get the localized string values for labels and descriptions for connector settings. Default is
     * en-US.
     */
    @Value.Default
    default String locale() {
        return "en-US";
    }

    /**
     * Connector label to be used for logging.
     * @return
     */
    @Nullable
    String connectorLabel();
}
