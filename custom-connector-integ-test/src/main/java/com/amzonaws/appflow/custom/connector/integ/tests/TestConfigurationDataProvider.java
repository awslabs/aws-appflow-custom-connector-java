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
package com.amzonaws.appflow.custom.connector.integ.tests;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static com.amzonaws.appflow.custom.connector.integ.util.ConfigurationUtil.getTestConfiguration;

public class TestConfigurationDataProvider {

    @DataProvider(name = "CreateConnectorConfigs")
    public Object[][] createConnectorConfigs(final ITestContext iTestContext) {
        return getObjects(new ArrayList<>(getTestConfiguration(iTestContext).customConnectorConfigurations()));
    }

    @DataProvider(name = "CreateConnectorProfileConfigs")
    public Object[][] createConnectorProfileConfigs(final ITestContext iTestContext) {
        return getObjects(new ArrayList<>(getTestConfiguration(iTestContext).customConnectorProfileConfigurations()));
    }

    @DataProvider(name = "SourceFlowConfigs")
    public Object[][] sourceFlowConfigs(final ITestContext iTestContext) {
        return getObjects(new ArrayList<>(getTestConfiguration(iTestContext).onDemandToS3TestConfigurations()));
    }

    @DataProvider(name = "DestinationFlowConfigs")
    public Object[][] destinationFlowConfigs(final ITestContext iTestContext) {
        return getObjects(new ArrayList<>(getTestConfiguration(iTestContext).onDemandFromS3TestConfigurations()));
    }

    @DataProvider(name = "ListEntitiesConfigs")
    public Object[][] listEntitiesConfigs(final ITestContext iTestContext) {
        return getObjects(new ArrayList<>(getTestConfiguration(iTestContext).listConnectorEntitiesTestConfigurations()));
    }

    @DataProvider(name = "DescribeEntitiesConfigs")
    public Object[][] describeEntitiesConfigs(final ITestContext iTestContext) {
        return getObjects(new ArrayList<>(getTestConfiguration(iTestContext).describeConnectorEntityTestConfigurations()));
    }

    private Object[][] getObjects(final List<Object> objectList) {
        Object[][] args = new Object[objectList.size()][1];

        int index = 0;

        for (Object connectorConfiguration : objectList) {
            args[index][0] = connectorConfiguration;
            index++;
        }
        return args;
    }
}
