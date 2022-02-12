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
package com.amazonaws.appflow.custom.connector.integ.tests;

import com.amazonaws.appflow.custom.connector.integ.providers.ResourceInfoProvider;
import com.amazonaws.appflow.custom.connector.integ.providers.ServiceProvider;
import com.amazonaws.services.appflow.AmazonAppflow;
import com.amazonaws.services.appflow.model.ConnectorDetail;
import com.amazonaws.services.appflow.model.ConnectorProfile;
import com.amazonaws.services.appflow.model.DeleteConnectorProfileRequest;
import com.amazonaws.services.appflow.model.DeleteFlowRequest;
import com.amazonaws.services.appflow.model.DescribeConnectorProfilesRequest;
import com.amazonaws.services.appflow.model.DescribeConnectorProfilesResult;
import com.amazonaws.services.appflow.model.FlowDefinition;
import com.amazonaws.services.appflow.model.ListConnectorsRequest;
import com.amazonaws.services.appflow.model.ListConnectorsResult;
import com.amazonaws.services.appflow.model.ListFlowsRequest;
import com.amazonaws.services.appflow.model.ListFlowsResult;
import com.amazonaws.services.appflow.model.UnregisterConnectorRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.amazonaws.appflow.custom.connector.integ.util.ConfigurationUtil.getTestConfiguration;

/**
 * Tests that run after all other test cases.
 * These test cases clean up resources created in the account during the integration test run.
 */
public class CleanupTest {

    private AmazonAppflow amazonAppflow;

    private String resourcePrefix;

    private static final Logger LOGGER = LoggerFactory.getLogger(CleanupTest.class);

    @BeforeSuite
    public void setUp(final ITestContext iTestContext) throws IOException {
        this.amazonAppflow = ServiceProvider.getAppflow();
        resourcePrefix  = getTestConfiguration(iTestContext).resourcePrefix().orElse("");
    }

    @AfterSuite
    public void CleanUpConnectorProfiles() {
        Map<String, ConnectorProfile> profiles = new HashMap<>();
        String nextToken = null;
        do {
            DescribeConnectorProfilesRequest request = new DescribeConnectorProfilesRequest();
            request.setNextToken(nextToken);
            DescribeConnectorProfilesResult describeConnectorProfilesResult =
                    amazonAppflow.describeConnectorProfiles(request);
            profiles.putAll(describeConnectorProfilesResult.getConnectorProfileDetails()
                    .stream()
                    .filter(cp -> (StringUtils.startsWithIgnoreCase(cp.getConnectorProfileName(), resourcePrefix + ResourceInfoProvider.INTEG_PROFILE)))
                    .collect(Collectors.toMap(ConnectorProfile::getConnectorProfileName, cp -> cp)));
            nextToken = describeConnectorProfilesResult.getNextToken();
        } while (nextToken != null);
        for (String name : profiles.keySet()) {
            LOGGER.info("Deleting Profile " + name);
            amazonAppflow.deleteConnectorProfile(new DeleteConnectorProfileRequest().withConnectorProfileName(name).withForceDelete(true));
        }
    }

    @AfterSuite
    public void CleanUpConnectors() {
        Map<String, ConnectorDetail> connectorDetails = new HashMap<>();
        String nextToken = null;
        do {
            ListConnectorsRequest request = new ListConnectorsRequest();
            request.setNextToken(nextToken);
            ListConnectorsResult result =
                    amazonAppflow.listConnectors(request);
            connectorDetails.putAll(result.getConnectors()
                    .stream()
                    .filter(cp -> (StringUtils.startsWithIgnoreCase(cp.getConnectorLabel(), resourcePrefix + ResourceInfoProvider.INTEG_CONNECTOR)))
                    .collect(Collectors.toMap(ConnectorDetail::getConnectorLabel, cp -> cp)));
            nextToken = result.getNextToken();
        } while (nextToken != null);
        for (String name : connectorDetails.keySet()) {
            LOGGER.info("Unregistering Connector " + name);
            amazonAppflow.unregisterConnector(new UnregisterConnectorRequest().withConnectorLabel(name).withForceDelete(true));
        }
    }

    @AfterSuite
    public void CleanUpFlows() {
        Map<String, FlowDefinition> connectorDetails = new HashMap<>();
        String nextToken = null;
        do {
            ListFlowsRequest request = new ListFlowsRequest();
            request.setNextToken(nextToken);
            ListFlowsResult result =
                    amazonAppflow.listFlows(request);
            connectorDetails.putAll(result.getFlows()
                    .stream()
                    .filter(cp -> (StringUtils.startsWithIgnoreCase(cp.getFlowName(), resourcePrefix + ResourceInfoProvider.INTEG_FLOW)))
                    .collect(Collectors.toMap(FlowDefinition::getFlowName, cp -> cp)));
            nextToken = result.getNextToken();
        } while (nextToken != null);
        for (String name : connectorDetails.keySet()) {
            LOGGER.info("Deleting Flow " + name);
            amazonAppflow.deleteFlow(new DeleteFlowRequest().withFlowName(name).withForceDelete(true));
        }
    }
}
