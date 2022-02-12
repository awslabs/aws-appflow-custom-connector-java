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
package com.amazonaws.appflow.custom.connector.integ.providers;

import com.amazonaws.services.appflow.model.ConnectionMode;
import com.amazonaws.services.appflow.model.ConnectorOperator;
import com.amazonaws.services.appflow.model.ConnectorProfileConfig;
import com.amazonaws.services.appflow.model.ConnectorProfileCredentials;
import com.amazonaws.services.appflow.model.ConnectorProfileProperties;
import com.amazonaws.services.appflow.model.ConnectorProvisioningConfig;
import com.amazonaws.services.appflow.model.ConnectorProvisioningType;
import com.amazonaws.services.appflow.model.ConnectorType;
import com.amazonaws.services.appflow.model.CreateConnectorProfileRequest;
import com.amazonaws.services.appflow.model.CreateFlowRequest;
import com.amazonaws.services.appflow.model.CustomConnectorDestinationProperties;
import com.amazonaws.services.appflow.model.CustomConnectorProfileProperties;
import com.amazonaws.services.appflow.model.CustomConnectorSourceProperties;
import com.amazonaws.services.appflow.model.DescribeConnectorEntityRequest;
import com.amazonaws.services.appflow.model.DescribeConnectorRequest;
import com.amazonaws.services.appflow.model.DestinationConnectorProperties;
import com.amazonaws.services.appflow.model.DestinationFlowConfig;
import com.amazonaws.services.appflow.model.ErrorHandlingConfig;
import com.amazonaws.services.appflow.model.FileType;
import com.amazonaws.services.appflow.model.LambdaConnectorProvisioningConfig;
import com.amazonaws.services.appflow.model.ListConnectorEntitiesRequest;
import com.amazonaws.services.appflow.model.Operator;
import com.amazonaws.services.appflow.model.RegisterConnectorRequest;

import com.amazonaws.services.appflow.model.S3ConnectorOperator;
import com.amazonaws.services.appflow.model.S3DestinationProperties;
import com.amazonaws.services.appflow.model.S3OutputFormatConfig;
import com.amazonaws.services.appflow.model.S3SourceProperties;
import com.amazonaws.services.appflow.model.SourceConnectorProperties;
import com.amazonaws.services.appflow.model.SourceFlowConfig;
import com.amazonaws.services.appflow.model.Task;
import com.amazonaws.services.appflow.model.TaskType;
import com.amazonaws.services.appflow.model.TriggerConfig;
import com.amazonaws.services.appflow.model.TriggerType;
import com.amazonaws.appflow.custom.connector.integ.data.CustomConnectorConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.CustomConnectorProfileConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.DescribeConnectorEntityTestConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.ListConnectorEntitiesTestConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.OnDemandFromS3TestConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.OnDemandToS3TestConfiguration;
import com.amazonaws.appflow.custom.connector.integ.data.TestBucketConfiguration;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.amazonaws.appflow.custom.connector.integ.providers.CredentialsProvider.getCustomConnectorProfileCredentials;

/**
 * Utility class used to Generate Requests for the testcases.
 */
public class RequestProvider {

    private final ResourceInfoProvider resourceInfoProvider;
    private final TestBucketConfiguration testBucketConfiguration;

    public RequestProvider(final ResourceInfoProvider resourceInfoProvider,
                           final TestBucketConfiguration testBucketConfiguration) {
        this.resourceInfoProvider = resourceInfoProvider;
        this.testBucketConfiguration = testBucketConfiguration;
    }

    public RegisterConnectorRequest getRegisterConnectorRequest(final CustomConnectorConfiguration configuration) {
        RegisterConnectorRequest request = new RegisterConnectorRequest()
                .withConnectorLabel(resourceInfoProvider.generateConnectorName(configuration.name()))
                .withConnectorProvisioningType(ConnectorProvisioningType.LAMBDA)
                .withConnectorProvisioningConfig(new ConnectorProvisioningConfig()
                        .withLambda(new LambdaConnectorProvisioningConfig()
                                .withLambdaArn(configuration.lambdaArn())
                        )
                );
        return request;
    }

    public DescribeConnectorRequest getDescribeConnectorRequest(final CustomConnectorConfiguration configuration) {
        DescribeConnectorRequest request = new DescribeConnectorRequest()
                .withConnectorLabel(resourceInfoProvider.generateConnectorName(configuration.name()))
                .withConnectorType(ConnectorType.CustomConnector);
        return request;
    }

    public CreateConnectorProfileRequest getCreateConnectorProfileRequest(final CustomConnectorProfileConfiguration profileConfiguration) {
        CreateConnectorProfileRequest request = new CreateConnectorProfileRequest()
                .withConnectorLabel(resourceInfoProvider
                        .getConnectorName(profileConfiguration.connectorName()))
                .withConnectorProfileName(resourceInfoProvider.generateProfileName(profileConfiguration.name()))
                .withConnectorType(ConnectorType.CustomConnector)
                .withConnectionMode(ConnectionMode.Public)
                .withConnectorProfileConfig(new ConnectorProfileConfig()
                        .withConnectorProfileProperties(getConnectorProfileProperties(profileConfiguration))
                        .withConnectorProfileCredentials(new ConnectorProfileCredentials()
                                .withCustomConnector(getCustomConnectorProfileCredentials(profileConfiguration))));

        return request;
    }

    private ConnectorProfileProperties getConnectorProfileProperties(final CustomConnectorProfileConfiguration profileConfiguration) {
        CustomConnectorProfileProperties customConnectorProfileProperties = new CustomConnectorProfileProperties();
        profileConfiguration.profileProperties().ifPresent(customConnectorProfileProperties::withProfileProperties);

        if (AuthenticationType.OAUTH2.equals(profileConfiguration.authenticationType())) {
            if (!profileConfiguration.oAuth2Properties().isPresent()) {
                throw new RuntimeException("For OAuth2, oAuth2Properties are required in test-config.json");
            }
            profileConfiguration.oAuth2Properties().ifPresent(customConnectorProfileProperties::setOAuth2Properties);
        }
        return new ConnectorProfileProperties().withCustomConnector(customConnectorProfileProperties);
    }

    public DescribeConnectorEntityRequest getDescribeConnectorEntityRequest(final DescribeConnectorEntityTestConfiguration configuration) {

        DescribeConnectorEntityRequest request = new DescribeConnectorEntityRequest()
                .withConnectorProfileName(resourceInfoProvider.getProfileName(configuration.profileName()))
                .withConnectorType(ConnectorType.CustomConnector)
                .withApiVersion(resourceInfoProvider.getApiForProfileName(configuration.profileName(), configuration.apiVersion()))
                .withConnectorEntityName(configuration.entityName());
        return request;
    }

    public ListConnectorEntitiesRequest getListConnectorEntitiesRequest(final ListConnectorEntitiesTestConfiguration configuration) {

        return new ListConnectorEntitiesRequest()
                .withConnectorProfileName(resourceInfoProvider.getProfileName(configuration.profileName()))
                .withConnectorType(ConnectorType.CustomConnector)
                .withEntitiesPath(configuration.entitiesPath().orElse(null))
                .withApiVersion(resourceInfoProvider.getApiForProfileName(configuration.profileName(), configuration.apiVersion()));
    }

    public CreateFlowRequest getDestinationCreateFlowRequest(final OnDemandFromS3TestConfiguration configuration, final List<String> fields) {

        SourceFlowConfig sourceFlowConfig = new SourceFlowConfig()
                .withConnectorType(ConnectorType.S3)
                .withSourceConnectorProperties(new SourceConnectorProperties()
                        .withS3(new S3SourceProperties()
                                .withBucketName(testBucketConfiguration.bucketName())
                                .withBucketPrefix(testBucketConfiguration.bucketPrefix() + configuration.flowName())));

        DestinationFlowConfig destinationFlowConfig = new DestinationFlowConfig()
                .withConnectorType(ConnectorType.CustomConnector)
                .withConnectorProfileName(resourceInfoProvider.getProfileName(configuration.profileName()))
                .withApiVersion(resourceInfoProvider.getApiForProfileName(configuration.profileName(), configuration.apiVersion()))
                .withDestinationConnectorProperties(new DestinationConnectorProperties()
                        .withCustomConnector(new CustomConnectorDestinationProperties()
                                .withEntityName(configuration.entityName())
                                .withWriteOperationType(configuration.writeOperationType())
                                .withIdFieldNames(configuration.idFieldNames().orElse(null))
                                .withErrorHandlingConfig(new ErrorHandlingConfig()
                                        .withFailOnFirstDestinationError(false)
                                        .withBucketName(testBucketConfiguration.bucketName())
                                        .withBucketPrefix(testBucketConfiguration.bucketPrefix() + "integ-test-errors/"))
                                .withCustomProperties(configuration.destinationRuntimeSettings().orElse(null))));
        TriggerConfig triggerConfig = new TriggerConfig().withTriggerType(TriggerType.OnDemand);

        //Create Flow
        CreateFlowRequest flowRequest = new CreateFlowRequest()
                .withDescription("Flow Created by IntegrationTestFramework.")
                .withFlowName(resourceInfoProvider.generateFlowName(configuration.flowName()))
                .withDestinationFlowConfigList(Collections.singletonList(destinationFlowConfig))
                .withSourceFlowConfig(sourceFlowConfig)
                .withTasks(getDestinationQueryTasks(fields))
                .withTriggerConfig(triggerConfig);

        return flowRequest;
    }

    public CreateFlowRequest getSourceCreateFlowRequest(final OnDemandToS3TestConfiguration configuration) {

        CustomConnectorSourceProperties sourceProperties = new CustomConnectorSourceProperties()
                .withEntityName(configuration.entityName())
                .withCustomProperties(configuration.sourceRuntimeProperties().orElse(null));
        SourceFlowConfig sourceFlowConfig = new SourceFlowConfig()
                .withConnectorType(ConnectorType.CustomConnector)
                .withConnectorProfileName(resourceInfoProvider.getProfileName(configuration.profileName()))
                .withApiVersion(resourceInfoProvider.getApiForProfileName(configuration.profileName(), configuration.apiVersion()))
                .withSourceConnectorProperties(new SourceConnectorProperties()
                        .withCustomConnector(sourceProperties));

        DestinationFlowConfig destinationFlowConfig = getQueryDestinationFlowConfig();
        TriggerConfig triggerConfig = new TriggerConfig().withTriggerType(TriggerType.OnDemand);

        CreateFlowRequest flowRequest = new CreateFlowRequest()
                .withDescription("Flow Created by IntegrationTestFramework.")
                .withFlowName(resourceInfoProvider.generateFlowName(configuration.flowName()))
                .withDestinationFlowConfigList(Collections.singletonList(destinationFlowConfig))
                .withSourceFlowConfig(sourceFlowConfig)
                .withTasks(getQueryTasks(configuration.entityFields()))
                .withTriggerConfig(triggerConfig);

        return flowRequest;
    }

    private DestinationFlowConfig getQueryDestinationFlowConfig() {
        DestinationConnectorProperties destinationConnectorProperties = new DestinationConnectorProperties()
                .withS3(new S3DestinationProperties().withBucketName(testBucketConfiguration.bucketName())
                        .withBucketPrefix(testBucketConfiguration.bucketPrefix())
                        .withS3OutputFormatConfig(new S3OutputFormatConfig().withFileType(FileType.CSV)));

        return new DestinationFlowConfig().withConnectorType(ConnectorType.S3)
                .withConnectorProfileName("test")
                .withDestinationConnectorProperties(destinationConnectorProperties);
    }

    private List<Task> getQueryTasks(final List<String> fields) {
        List<Task> tasks = fields.stream().map(it -> new Task()
                .withTaskType(TaskType.Map)
                .withConnectorOperator(new ConnectorOperator().withS3(S3ConnectorOperator.NO_OP))
                .withTaskProperties(Collections.emptyMap())
                .withSourceFields(it)
                .withDestinationField(it))
                .collect(Collectors.toList());
        tasks.add(new Task().withTaskType(TaskType.Filter)
                .withTaskProperties(Collections.emptyMap())
                .withConnectorOperator(new ConnectorOperator().withCustomConnector(Operator.PROJECTION))
                .withSourceFields(fields));
        return tasks;
    }

    private List<Task> getDestinationQueryTasks(final List<String> fields) {
        List<Task> tasks = fields.stream().map(it -> new Task()
                .withTaskType(TaskType.Map)
                .withConnectorOperator(new ConnectorOperator().withS3(S3ConnectorOperator.NO_OP))
                .withTaskProperties(Collections.emptyMap())
                .withSourceFields(it)
                .withDestinationField(it))
                .collect(Collectors.toList());
        tasks.add(new Task().withTaskType(TaskType.Filter)
                .withTaskProperties(Collections.emptyMap())
                .withConnectorOperator(new ConnectorOperator().withS3(S3ConnectorOperator.PROJECTION))
                .withSourceFields(fields));
        return tasks;
    }
}
