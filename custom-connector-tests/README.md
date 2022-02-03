# Custom Connector Tests
This module contains Java programs that developers can run to verify connector functionality. This can be used as a verification step to make sure the Lambda handlers being implemented are operating as expected and returning the correct responses (as expected by AppFlow).

## Verification Tests
The main java program class is called `RunTests` and can be executed using the following command:

```text
$ mvn clean && mvn package
$ cd custom-connector-tests
...
$ java -cp target/custom-connector-tests-1.0.jar RunTests -h com.amazonaws.appflow.custom.connector.example.handler.SalesforceLambdaHandler -t ./src/main/configuration/TestConfig.json
```
There are 2 required options:
1. `h -> HandlerName:` This is the full class name of the custom connector handler. This class should extend "BaseLambdaConnectorHandler"
2. `t -> TestConfig:` This is a JSON configuration file used by the verification tests. A sample test configuration file is provided under **src/main/configuration/TestConfig.json**

### Results

The test results will be displayed on the console/terminal where the java program or bash script is being run. Any errors resulting will also be output to the console.

### Test Configuration
The configuration file is created by the connector developer and contains request level information. A sample file is provided under **src/main/configuration/TestConfig.json**

**RuntimeSettings**   
Key-Value map containing the runtime settings expected by the connector. There are 3 scopes allowed and only the ones provided will be used to test the connector.

For example, if the connector only supports ConnectorProfile and Source scope, then only the runtime settings for these 2 scopes will be tested by invoking the **ValidateRuntimeSettings** method of the ConnectorHandler. (The destination scope will be ignored).

Allowed Scopes:
- "connectorProfile"
- "source"
- "destination"

**Credentials**
Type and credentials used by the connector to authorize against the SaaS provider. These will be used to test the connection to your SaaS provider through your custom connector by invoking methods such as **ListEntities** and **DescribeEntity**.

Allowed Credential Types (provide only 1 of the following) are here : 

```custom-connector-sdk/src/main/java/com/amazonaws/appflow/custom/connector/model/credentials/AuthenticationType.java```


NOTE: For OAuth2 credentials, follow the SaaS provider's directions to obtain a valid Access and Refresh token.

**TestEntityIdentifier**
The unique identifier for the entity being used to test methods such as ListEntity, DescribeEntity, etc. Here we are using Salesforce's **Account** entity.

**Configurations**
The test requests for record level operations such as Retrieve, Write and Query should be provided separately here. You can provide a list of as many configurations you want to test (each configuration will result in a separate request to the connector handler).

Refer to `custom-connector-sdk/src/main/model/write/WriteDataRequest.java` to determine the parameters for each type of request (there are required and optional fields). This is the request that will be sent to the ConnectorHandler, and it expects a successful response, thus it is up to the developer to build configs that lead to a successful response from the connector (and also SaaS provider). For example, an `Account` entity with AccountNumber=12345 is a valid entity in our Salesforce account and results in a successful retrieval.

The example `TestConfig.json` file contains sample Retrieve, Write and Query configurations that result in a successful response from the example custom connector (Salesforce). For example, the UPSERT write operation type:
```json
{
  "entityIdentifier": "Account",
  "operation": "UPSERT",
  "idFieldNames": ["ExternalId__c"],
  "records": [
    "{\"Name\": \"UpsertAccount\", \"ExternalId__c\": \"Identifier123\"}"
  ],
  "allOrNone": false
}
```
The `entityIdentifier` tells the connector that the write operation is for the `Account` object in our Salesforce instance.

The `operation` tells the connector to make an UPSERT request (INSERT or UPDATE).

The `idFieldNames` gives the key to be used as the identifier. Salesforce only supports UPSERT for ExternalIds (custom id field). Only provide a single id field since Salesforce only supports single id field names.

The `records` gives the list of records to insert or update. These records should have the field mentioned above.

The `allOrNone` is an optional flag that determines the behavior when a record fails to write.

### Sample Execution
All the tests are passing. Using sample TestConfig.json
```text
$ java -cp target/custom-connector-tests-1.0.jar RunTests -h com.amazonaws.appflow.custom.connector.example.handler.SalesforceLambdaHandler -t ./main/configuration/TestConfig.json

2021-10-07 13:05:06  INFO  BaseConnectorTestInvoker - -----------Starting verification tests for Configuration Handler-----------
2021-10-07 13:05:06  INFO  BaseConnectorTestInvoker - Testing ValidateConnectorRuntimeSettings for ConnectorProfile...
2021-10-07 13:05:06  INFO  BaseConnectorTestInvoker - Testing ValidateConnectorRuntimeSettings for Source...
2021-10-07 13:05:06  INFO  BaseConnectorTestInvoker - Testing ValidateConnectorRuntimeSettings for Destination...
2021-10-07 13:05:06  INFO  BaseConnectorTestInvoker - Testing ValidateCredentials...
2021-10-07 13:05:07  INFO  BaseConnectorTestInvoker - Testing DescribeConnectorConfiguration...
2021-10-07 13:05:07  INFO  BaseConnectorTestInvoker - Configuration handler was verified successfully!
2021-10-07 13:05:07  INFO  BaseConnectorTestInvoker - -----------Starting verification tests for Metadata Handler-----------
2021-10-07 13:05:07  INFO  BaseConnectorTestInvoker - Testing ListEntities...
2021-10-07 13:05:08  INFO  BaseConnectorTestInvoker - Testing DescribeEntity...
2021-10-07 13:05:08  INFO  BaseConnectorTestInvoker - Metadata handler verification was successful!
2021-10-07 13:05:08  INFO  BaseConnectorTestInvoker - -----------Starting verification tests for Record Handler-----------
2021-10-07 13:05:08  INFO  BaseConnectorTestInvoker - Testing RetrieveData configuration 01...
2021-10-07 13:05:09  INFO  BaseConnectorTestInvoker - Testing WriteData configuration 01...
2021-10-07 13:05:10  INFO  BaseConnectorTestInvoker - Testing QueryData configuration 01...
2021-10-07 13:05:10  INFO  BaseConnectorTestInvoker - Record handler verification was successful!
Tests completed successfully, see above logs for results
```
* [ ] 
Test failure during `ListEntities` where entity does not exist.
```text
$ java -cp target/custom-connector-tests-1.0.jar RunTests -h com.amazonaws.appflow.custom.connector.example.handler.SalesforceLambdaHandler -t ~/TestConfig.json

Starting connector verification tests for com.amazonaws.appflow.custom.connector.example.handler.SalesforceLambdaHandler
2021-10-07 13:46:05  INFO  BaseConnectorTestInvoker - -----------Starting verification tests for Configuration Handler-----------
2021-10-07 13:46:05  INFO  BaseConnectorTestInvoker - Testing ValidateConnectorRuntimeSettings for ConnectorProfile...
2021-10-07 13:46:05  INFO  BaseConnectorTestInvoker - Testing ValidateConnectorRuntimeSettings for Source...
2021-10-07 13:46:05  INFO  BaseConnectorTestInvoker - Testing ValidateConnectorRuntimeSettings for Destination...
2021-10-07 13:46:05  INFO  BaseConnectorTestInvoker - Testing ValidateCredentials...
2021-10-07 13:46:06  INFO  BaseConnectorTestInvoker - Testing DescribeConnectorConfiguration...
2021-10-07 13:46:06  INFO  BaseConnectorTestInvoker - Configuration handler was verified successfully!
2021-10-07 13:46:06  INFO  BaseConnectorTestInvoker - -----------Starting verification tests for Metadata Handler-----------
2021-10-07 13:46:06  INFO  BaseConnectorTestInvoker - Testing ListEntities...
2021-10-07 13:46:06  ERROR AbstractSalesforceHandler - Request failed with status code 404 error reason Not Found and salesforce response is [{"errorCode":"NOT_FOUND","message":"The requested resource does not exist"}]
2021-10-07 13:46:06  ERROR BaseConnectorTestInvoker - Error encountered during MetadataHandler verification!
java.lang.IllegalStateException: List Entities response returned unsuccessful response for the provided TestConfiguration
	at com.google.common.base.Preconditions.checkState(Preconditions.java:444) ~[custom-connector-tests-1.0.jar:?]
	at com.amazonaws.appflow.custom.connector.tests.invokers.BaseConnectorTestInvoker.invokeMetadataHandlerTests(BaseConnectorTestInvoker.java:179) [custom-connector-tests-1.0.jar:?]
	at RunTests.main(RunTests.java:92) [custom-connector-tests-1.0.jar:?]
2021-10-07 13:46:06  ERROR BaseConnectorTestInvoker - Verification tests failed for the given Connector Handler. See logs for details
```
