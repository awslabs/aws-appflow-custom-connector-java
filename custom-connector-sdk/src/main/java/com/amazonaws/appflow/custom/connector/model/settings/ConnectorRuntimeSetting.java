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

package com.amazonaws.appflow.custom.connector.model.settings;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Represents the setting that the connector needs at runtime and the input will be provided by the Appflow user. For
 * eg. instanceUrl, maxParallelism etc.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableConnectorRuntimeSetting.class)
@JsonDeserialize(as = ImmutableConnectorRuntimeSetting.class)
public interface ConnectorRuntimeSetting {
    /**
     * Unique identifier for the connector runtime setting.
     */
    String key();

    /**
     * Data type for the connector runtime setting.
     */
    ConnectorRuntimeSettingDataType dataType();

    /**
     * Specifies if this setting is required or not.
     */
    boolean required();

    /**
     * Label for the connector runtime setting.
     */
    String label();

    /**
     * Description of the connector runtime setting.
     */
    String description();

    /**
     * Scope of the runtime setting needed for CONNECTOR_PROFILE, SOURCE, DESTINATION etc.
     */
    ConnectorRuntimeSettingScope scope();

    /**
     * Optional connector supplied value options (with matching data type) that the user can pick from as a value for
     * this runtime setting.
     */
    @Nullable
    List<String> connectorSuppliedValueOptions();
}
