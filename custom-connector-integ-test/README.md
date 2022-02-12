# Integration Test FrameWork
This document explains how to run the integration tests provided by AppFlow for a custom connector.

## Prerequisites:

- mvn

## Test Case Overview:

The framework provides the following test cases.

1. Register and Describing the connector.
2. Calling the metadata APIs.
3. Running a flow from S3 -> connector
4. Running a flow from the connector -> S3

Additionally, we provide a test class that cleans up all AppFlow resources created by the integration tests.
This test case cleans up resources based on the prefix "Integ_{ResourceType}". e.g. Integ_Profile. 
You can also provide a prefix in the test configuration which will be appended to all resources.
If you are running multiple test cases in the same aws account, be sure to use this prefix. Otherwise,
one test run might delete resources deployed by another test run.

All tests are written using TestNG.

## Configuration File Overview

The test cases are driven by a set of configuration files. The main configuration file location is passed
to TestNG as a suite parameter.

The test configuration allows you to specify any number of custom connectors and connector profiles.
These resources are given a name. This name will be used as part of a randomly
generated name. All tests cases take as input either a connector name or a connector profile name
as an optional parameter. If this name is not provided, then the first profile in the configuration.
list will be used. To make the configuration simple, it may be worth specifying one profile and
connector per test file. Instead, you can use multiple configuration files. The tests can still be run from a
single testng.xml file which references other testng.xml files.

```
 <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
    <suite name="AppFlow Custom Connector Suite"  > 
            <suite-files>
                   <suite-file path="./connector1.xml" />
                   <suite-file path="./connector2.xml" />
            </suite-files>
    </suite>
```

You are also free to include as many connectors as you want in one suite file. In general, anything that
can be done in multiple test configuration files can be done in a single file.

The configuration file is in json. It includes a json list for each test case. Each json object in the list
is a test case.
e.g.

```
"listConnectorEntitiesTestConfigurations": [ // Test for the list connector
    {
      // Optional: This file is identical to the response provided by list connector entities api.
      // However, not all entities need to be provided. The test case will only evaluate equality between entities in validation file.
      "validationFileName": "string",
      "profileName":"string", // Optional: Profile used to run the test. Uses first profile otherwise.
      "apiVersion": "string", // Optional: Api version used in request input. Uses default api version from profile otherwise.
      "testName": "string", // Optional: Test name used to associate the test report with this test case.
      "entitiesPath": "string" // Optional: Paramater used in list entities request.
    }
  ],
```

There is a test case called listConnectorEntitiesTest. This test takes in the following parameters shown in the sample-test-config.json
You can specify multiple test cases per test by adding another json payload to the list. Alternatively, an empty list won't run
any tests cases for that test.

An example set of configuration files can be found in the salesforce custom connector example.

A base configuration file can be found in the current directory.

## Running the tests

### Resources

The configuration file requires several AWS resources to already exist in your account. The purpose of these
resources is described in the the sample-test-config.json file.

1. A S3 bucket with AppFlow bucket policy.
2. A Secrets Manager secret for each set of credentials.
3. A Lambda custom connector.

Note: The integration tests will not delete files that are created during the test run. The test bucket you're using,
should have an object expiration for the specific prefix used by the test cases.

### Environment Configuration

The integration tests rely on both the AWS_REGION environment variable 
and AWS credentials environment variables. e.g AWS_ACCESS_KEY_ID

### Including the package.

The integration test package must be included in your dependencies.

e.g. If you're using Maven. You can add this to your pom.xml.
```
        <dependency>
            <groupId>com.amazonaws</groupId>
            <artifactId>aws-custom-connector-integ-test</artifactId>
            <version>${aws-custom-connector-integ-test.version}</version>
        </dependency>
```

## TestNG

The test cases are written using TestNG. The test cases can be run using a testng.xml file such as

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="AppFlow Custom Connector Suite">
    <parameter name="testConfig" value="test-file-2.json"/>
    <test name="AppFlow Custom Connector Tests">
        <classes>
            <class name="com.amazonaws.appflow.custom.connector.integ.tests.BasicCustomConnectorTestCases"/>
            <class name="com.amazonaws.appflow.custom.connector.integ.tests.CleanupTest"/>
        </classes>
    </test> <!-- Test -->
</suite> <!-- Suite -->
```

There are a variety of ways to run TestNG. The custom connector example shows how to run the tests from Maven
using the failsafe plugin. However, the tests can be run using TestNG directly from the command line, or in an IDE.

For example, in the example connector package, they can be run using the following command:

```
mvn failsafe:integration-test
```

The test cases require a single suite parameter called "testConfig".

## Writing your own test cases

You can extend the class BasicCustomConnectorTestCases if you want to write your test cases using the utility 
classes used by the integration tests.

For example, you can use the ResourceInfoProvider to get the name for a connector or profile generated during the test run.
If the resource failed to create then this method will throw a SkipException.

You can also use ServiceProvider class to get the Amazon SDK clients used by the integration tests as well as a FlowPoller
class which you can use to poll flow runs. 

You should use the following annotation for all test cases.

```
@Test(groups = {"tests"}, dependsOnMethods = {"testCreateConnectorProfile"}, alwaysRun = true)
```

This ensures that the test cases always run, run after the connectors and connector profiles are created, 
and run before all resources are deleted.

Below is an example test using the resourceInfoProvider to get the generated resource name from the name given in the 
config.

```
import org.testng.annotations.Test;

public class MyConnectorIntegTest extends BasicCustomConnectorTestCases
package com.amazonaws.appflow.custom.connector.integ.tests;

import com.amazonaws.services.appflow.model.ConnectorType;
import com.amazonaws.services.appflow.model.ListConnectorEntitiesRequest;
import org.testng.annotations.Test;

public class TestClass extends BasicCustomConnectorTestCases {

    @Test(groups = {"tests"}, dependsOnMethods = {"testCreateConnectorProfile"}, alwaysRun = true)
    public void exampleIntegTest()
    {
        appflow.listConnectorEntities(new ListConnectorEntitiesRequest()
                .withConnectorProfileName(resourceInfoProvider.getProfileNameIfCreated("profile1"))
                .withConnectorType(ConnectorType.CustomConnector)
                .withEntitiesPath("path")
                .withApiVersion(resourceInfoProvider.getVersionForProfile("profile1")));
    }
}
```
