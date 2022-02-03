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

/**
 * Defines the scope for a given connector runtime setting. All connector runtime settings will be aggregated and will
 * be sent along with every function invocation on the connector.
 */
public enum ConnectorRuntimeSettingScope {
    /**
     * Settings to be populated during connector profile creation
     */
    CONNECTOR_PROFILE,

    /**
     * Setting to be populated during a flow creation if the connector is chosen as a source connector.
     */
    SOURCE,

    /**
     * Setting to be populated during a flow creation if the connector is chosen as a destination connector.
     */
    DESTINATION,

    /**
     * Setting to be populated during a flow creation if the connector is chosen either as a source or a destination
     * connector.
     */
    SOURCE_AND_DESTINATION
}
