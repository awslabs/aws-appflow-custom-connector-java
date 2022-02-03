/*-
 * #%L
 * aws-custom-connector-integ-test
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

import com.amzonaws.appflow.custom.connector.integ.data.TestConfiguration;
import org.testng.SkipException;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * A Utility class for generating resource names.
 * This class also helps in defaulting resource names if they are not explicitly provided in the configuration.
 */
public class ResourceInfoProvider {

    private final HashMap<String, String> versions;

    private final HashMap<String, String> names;

    private final Set<String> createdProfiles;
    private final Set<String> createdConnectors;

    public static final String INTEG_CONNECTOR = "Integ_Connector_";

    public static final String INTEG_PROFILE = "Integ_Profile_";

    public static final String INTEG_FLOW = "Integ_Flow_";

    private final String defaultConnectorName;

    private final String prefix;

    private final String defaultProfileName;

    private final long testStartTime;

    public ResourceInfoProvider(final TestConfiguration testConfiguration) {

        defaultConnectorName = testConfiguration.customConnectorConfigurations().get(0).name();
        defaultProfileName = testConfiguration.customConnectorProfileConfigurations().get(0).name();
        prefix = testConfiguration.resourcePrefix().orElse("");
        versions = new HashMap<>();
        testConfiguration.customConnectorProfileConfigurations()
                .forEach(configuration -> versions.put(configuration.name(), configuration.defaultApiVersion().orElse("1")));
        names = new HashMap<>();
        testConfiguration.customConnectorProfileConfigurations()
                .forEach(configuration -> names.put(configuration.name(), configuration.connectorName()
                        .orElse(testConfiguration.customConnectorConfigurations().get(0).name())));
        testStartTime = Instant.now().getEpochSecond();
        this.createdProfiles = new HashSet<>();
        this.createdConnectors = new HashSet<>();
    }

    public String getApiForProfileName(final Optional<String> profileName, final Optional<String> apiVersion) {
        String profileName2 = profileName
                .orElse(this.defaultProfileName);
        return apiVersion.orElse(versions.get(profileName2));
    }

    public String getVersionForProfile(final String profileName) {
        return versions.get(profileName);
    }

    public String getConnectorForProfile(final String profileName) {
        return names.get(profileName);
    }

    public String getConnectorForProfileName(final Optional<String> profileName) {
        String profileName2 = profileName
                .orElse(this.defaultProfileName);
        return this.getConnectorName(Optional.ofNullable(names.get(profileName2)));
    }

    public String getConnectorName(final Optional<String> connectorName) {
        return getConnectorNameIfCreated(connectorName.orElse(defaultConnectorName));
    }

    public String getProfileName(final Optional<String> profileName) {
        return getProfileNameIfCreated(profileName.orElse(defaultProfileName));
    }

    public String generateFlowName(final String configName) {
        return generateResourceName(configName, prefix + INTEG_FLOW);
    }

    public String generateProfileName(final String configName) {
        return generateResourceName(configName, prefix + INTEG_PROFILE);
    }

    public String generateConnectorName(final String configName) {
        return generateResourceName(configName, prefix + INTEG_CONNECTOR);
    }

    public String generateResourceName(final String configName, final String prefix) {
        return prefix + configName + testStartTime;
    }

    public String getConnectorNameIfCreated(final String configName) {
        String connectorName = generateConnectorName(configName);
        if (!createdConnectors.contains(connectorName)) {
            throw new SkipException(String.format("%s hasn't been created", connectorName));
        }
        return connectorName;
    }

    public String getProfileNameIfCreated(final String configName) {
        String profileName = generateProfileName(configName);
        if (!createdProfiles.contains(configName)) {
            throw new SkipException(String.format("%s hasn't been created", profileName));
        }
        return profileName;
    }

    public void addToCreatedProfiles(final String profileName) {
        createdProfiles.add(profileName);
    }

    public void addToCreatedConnectors(final String profileName) {
        createdConnectors.add(generateConnectorName(profileName));
    }
}
