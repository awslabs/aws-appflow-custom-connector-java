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

import com.amazonaws.appflow.custom.connector.integ.data.CustomConnectorProfileConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.DescribeConnectorEntityTestConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.ListConnectorEntitiesTestConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.OnDemandFromS3TestConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.OnDemandToS3TestConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.TestConfiguration;
import com.amazonaws.appflow.custom.connector.integ.providers.DataProvider;
import com.amazonaws.appflow.custom.connector.integ.providers.RequestProvider;
import com.amazonaws.appflow.custom.connector.integ.providers.ResourceInfoProvider;
import com.amazonaws.appflow.custom.connector.integ.providers.ServiceProvider;
import com.amazonaws.services.appflow.AmazonAppflow;
import com.amazonaws.services.appflow.model.ConnectorEntity;
import com.amazonaws.services.appflow.model.ConnectorEntityField;
import com.amazonaws.services.appflow.model.CreateFlowRequest;
import com.amazonaws.services.appflow.model.DescribeConnectorEntityResult;
import com.amazonaws.services.appflow.model.DescribeConnectorResult;
import com.amazonaws.services.appflow.model.ExecutionRecord;
import com.amazonaws.services.appflow.model.ExecutionStatus;
import com.amazonaws.services.appflow.model.ListConnectorEntitiesResult;
import com.amazonaws.services.appflow.model.StartFlowRequest;
import com.amazonaws.appflow.custom.connector.integ.data.CustomConnectorConfiguration;

import com.amazonaws.appflow.custom.connector.integ.util.ConfigurationUtil;
import com.amazonaws.appflow.custom.connector.integ.util.ImmutablePollingConfiguration;
import com.amazonaws.appflow.custom.connector.integ.util.S3Helper;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.amazonaws.appflow.custom.connector.integ.util.ConfigurationUtil.getTestConfiguration;

public class BasicCustomConnectorTestCases {

    private static final Integer MAX_POLLING_TIME = 180;

    protected ResourceInfoProvider resourceInfoProvider;

    protected RequestProvider requestProvider;

    protected AmazonAppflow appflow;

    protected S3Helper s3Helper;

    protected TestConfiguration configuration;

    @BeforeClass
    public void setUp(final ITestContext iTestContext) {
        configuration = getTestConfiguration(iTestContext);
        resourceInfoProvider = new ResourceInfoProvider(configuration);
        appflow = ServiceProvider.getAppflow();
        requestProvider = new RequestProvider(resourceInfoProvider, configuration.testBucketConfiguration());
        s3Helper = new S3Helper(configuration.testBucketConfiguration());
    }

    /**
     * Test case that creates a connector, describes the connector and validates the description against a provided response.
     * @param configuration refer to sample-test-config.json
     */
    @Test(dataProvider = "CreateConnectorConfigs", dataProviderClass = TestConfigurationDataProvider.class)
    public void testRegisterConnector(final CustomConnectorConfiguration configuration) {
        appflow.registerConnector(requestProvider.getRegisterConnectorRequest(configuration));
        DescribeConnectorResult actualResult = appflow.describeConnector(requestProvider.getDescribeConnectorRequest(configuration));
        if (configuration.validationFileName().isPresent()) {
            DescribeConnectorResult expectedResult = ConfigurationUtil.getDescribeConnectorFile(configuration.validationFileName().get());
            expectedResult.getConnectorConfiguration().setConnectorLabel(actualResult.getConnectorConfiguration().getConnectorLabel());
            expectedResult.getConnectorConfiguration().setRegisteredAt(actualResult.getConnectorConfiguration().getRegisteredAt());
            expectedResult.getConnectorConfiguration().setRegisteredBy(actualResult.getConnectorConfiguration().getRegisteredBy());
            Assert.assertEquals(expectedResult, actualResult);
        }
        resourceInfoProvider.addToCreatedConnectors(configuration.name());
    }

    /**
     * Test case that creates a connector profile.
     * @param configuration refer to sample-test-config.json
     */
    @Test(dataProvider = "CreateConnectorProfileConfigs", dataProviderClass = TestConfigurationDataProvider.class, dependsOnMethods = {"testRegisterConnector"}, alwaysRun = true)
    public void testCreateConnectorProfile(final CustomConnectorProfileConfiguration configuration) {
        appflow.createConnectorProfile(requestProvider.getCreateConnectorProfileRequest(configuration));
        resourceInfoProvider.addToCreatedProfiles(configuration.name());
    }

    /**
     * Test case that lists entities, and validates specific entities against a test file the user provides.
     * @param configuration refer to sample-test-config.json
     */
    @Test(dataProvider = "ListEntitiesConfigs", dataProviderClass = TestConfigurationDataProvider.class, groups = {"tests"}, dependsOnMethods = {"testCreateConnectorProfile"}, alwaysRun = true)
    public void testListConnectorEntities(final ListConnectorEntitiesTestConfiguration configuration) {
        ListConnectorEntitiesResult actualResult = appflow.listConnectorEntities(requestProvider.getListConnectorEntitiesRequest(configuration));
        if (configuration.validationFileName().isPresent()) {
            ListConnectorEntitiesResult expectedResult = ConfigurationUtil.getListEntitiesFile(configuration.validationFileName().get());
            for (Map.Entry<String, List<ConnectorEntity>> expectedEntities : expectedResult.getConnectorEntityMap().entrySet()) {
                for (ConnectorEntity expectedEntity : expectedEntities.getValue()) {
                    Optional<ConnectorEntity> actual = actualResult.getConnectorEntityMap().get(expectedEntities.getKey()).stream()
                            .filter((ent) -> ent.getName().equals(expectedEntity.getName())).findFirst();
                    Assert.assertTrue(actual.isPresent());
                    Assert.assertEquals(actual.get(), expectedEntity);
                }
            }
        }
    }

    /**
     * Test case that lists entities, and validates specific entities against a test file the user provides.
     * @param configuration refer to sample-test-config.json
     */
    @Test(dataProvider = "DescribeEntitiesConfigs", dataProviderClass = TestConfigurationDataProvider.class, groups = {"tests"}, dependsOnMethods = {"testCreateConnectorProfile"}, alwaysRun = true)
    public void testDescribeConnectorEntity(final DescribeConnectorEntityTestConfiguration configuration) {
        DescribeConnectorEntityResult result = appflow.describeConnectorEntity(requestProvider.getDescribeConnectorEntityRequest(configuration));

        if (configuration.validationFileName().isPresent()) {
            DescribeConnectorEntityResult actual = ConfigurationUtil.getDescribeEntityFile(configuration.validationFileName().get());
            for (ConnectorEntityField expectedField : actual.getConnectorEntityFields()) {
                Optional<ConnectorEntityField> actualField = result.getConnectorEntityFields().stream()
                        .filter(connectorEntityField -> connectorEntityField.getIdentifier().equals(expectedField.getIdentifier())).findFirst();
                Assert.assertTrue(actualField.isPresent());
                Assert.assertEquals(actualField.get(), expectedField);
            }
        }
    }

    /**
     * Test case that executes a flow and polls the flow until completion. The flow get data from a connector and puts the data into s3.
     * @param configuration refer to sample-test-config.json
     */
    @Test(dataProvider = "SourceFlowConfigs", dataProviderClass = TestConfigurationDataProvider.class, groups = {"tests"}, dependsOnMethods = {"testCreateConnectorProfile"}, alwaysRun = true)
    public void testSourceFlowExecutionOnDemand(final OnDemandToS3TestConfiguration configuration) {
        String flowName = resourceInfoProvider.generateFlowName(configuration.flowName());

        CreateFlowRequest createFlowRequest = requestProvider.getSourceCreateFlowRequest(configuration);
        appflow.createFlow(createFlowRequest);
        String executionId = appflow.startFlow(new StartFlowRequest().withFlowName(flowName)).getExecutionId();
        Optional<ExecutionRecord> executionRecord = ServiceProvider.getFlowPoller().pollForExecutionRecordsResponse(ImmutablePollingConfiguration.builder().executionId(executionId)
                .maxPollTimeS(configuration.flowTimeout().orElse(MAX_POLLING_TIME))
                .timeBetweenPollsS(configuration.flowTimeout().orElse(MAX_POLLING_TIME) / 5)
                .flowName(flowName).build());

        Assert.assertTrue(executionRecord.isPresent());
        Assert.assertEquals(executionRecord.get().getExecutionStatus(), ExecutionStatus.Successful.toString());
        configuration.outputSize().ifPresent((size) -> Assert.assertEquals(executionRecord.get().getExecutionResult().getBytesWritten(), size));
    }

    /**
     * Test case that executes a flow and polls the flow until completion. The flow gets data from s3 and puts it to the connector.
     * @param configuration refer to sample-test-config.json
     */
    @Test(dataProvider = "DestinationFlowConfigs", dataProviderClass = TestConfigurationDataProvider.class, groups = {"tests"}, dependsOnMethods = {"testCreateConnectorProfile"}, alwaysRun = true)
    public void testDestinationFlowExecutionOnDemand(final OnDemandFromS3TestConfiguration configuration) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String flowName = resourceInfoProvider.generateFlowName(configuration.flowName());
        String file;
        if (configuration.sourceDataFile().isPresent()) {
            file = new String(Files.readAllBytes(Paths.get(configuration.sourceDataFile().get())), StandardCharsets.UTF_8);
        } else if (configuration.dataGeneratorClassName().isPresent()) {
            Class<?> clazz = Class.forName(configuration.dataGeneratorClassName().get());
            DataProvider provider = (DataProvider) clazz.newInstance();
            file = provider.GenerateData();
        } else {
            throw new RuntimeException("Either Source data file or data generator class is needed to run test.");
        }
        String[] lines = file.split("\n");
        List<String> fields = Arrays.asList(lines[0].split(","));
        s3Helper.uploadFile(file, configuration.flowName());

        CreateFlowRequest createFlowRequest = requestProvider.getDestinationCreateFlowRequest(configuration, fields);
        appflow.createFlow(createFlowRequest);
        String executionId = appflow.startFlow(new StartFlowRequest().withFlowName(flowName)).getExecutionId();
        Optional<ExecutionRecord> executionRecord = ServiceProvider.getFlowPoller().pollForExecutionRecordsResponse(ImmutablePollingConfiguration.builder().executionId(executionId)
                .maxPollTimeS(configuration.flowTimeout().orElse(MAX_POLLING_TIME))
                .timeBetweenPollsS(configuration.flowTimeout().orElse(MAX_POLLING_TIME) / 5)
                .flowName(flowName).build());

        Assert.assertTrue(executionRecord.isPresent());
        Assert.assertEquals(executionRecord.get().getExecutionStatus(), ExecutionStatus.Successful.toString());
        Assert.assertEquals((long) executionRecord.get().getExecutionResult().getRecordsProcessed(), lines.length - 1);
    }
}
