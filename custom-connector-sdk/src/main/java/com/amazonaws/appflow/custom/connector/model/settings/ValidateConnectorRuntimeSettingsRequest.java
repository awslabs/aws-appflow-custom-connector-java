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

package com.amazonaws.appflow.custom.connector.model.settings;

import com.amazonaws.appflow.custom.connector.model.ConnectorRequest;
import com.amazonaws.appflow.custom.connector.model.ConnectorRequestStyle;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Map;

/**
 * Represents the input of a <code>ValidateConnectorRuntimeSettings</> operation.
 */
@ConnectorRequestStyle
@Value.Immutable
@JsonSerialize(as = ImmutableValidateConnectorRuntimeSettingsRequest.class)
@JsonDeserialize(as = ImmutableValidateConnectorRuntimeSettingsRequest.class)
@JsonTypeName("ValidateConnectorRuntimeSettingsRequest")
public interface ValidateConnectorRuntimeSettingsRequest extends ConnectorRequest {
    /**
     * Scope of the connector runtime settings needs to validated.
     */
    ConnectorRuntimeSettingScope scope();

    /**
     * Connector settings input. Key will be <code>ConnectorSetting.key()</code> and value will be input provided by
     * user.
     */
    Map<String, String> connectorRuntimeSettings();
}
