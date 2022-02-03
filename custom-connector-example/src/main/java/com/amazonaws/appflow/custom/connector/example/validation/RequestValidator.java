/*
 * -
 *  * #%L
 * * Example Custom Connector.
 *  *
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

package com.amazonaws.appflow.custom.connector.example.validation;

import com.amazonaws.appflow.custom.connector.example.configuration.SalesforceConnectorConfiguration;
import com.amazonaws.appflow.custom.connector.model.ConnectorContext;
import com.amazonaws.appflow.custom.connector.model.credentials.Credentials;
import com.amazonaws.appflow.custom.connector.model.ErrorCode;
import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.amazonaws.appflow.custom.connector.model.ImmutableErrorDetails;
import com.amazonaws.appflow.custom.connector.model.metadata.DescribeEntityRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.query.QueryDataRequest;
import com.amazonaws.appflow.custom.connector.model.retreive.RetrieveDataRequest;
import com.amazonaws.appflow.custom.connector.model.write.WriteDataRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.amazonaws.appflow.custom.connector.example.configuration.ConnectorSettingKey.INSTANCE_URL;

/**
 * Request Validator. Contains sample validation for each type of request.
 */
public final class RequestValidator {

    private RequestValidator() {
    }

    public static ErrorDetails validateListEntitiesRequest(final ListEntitiesRequest request) {
        final List<String> errors = validateConnectorContext(request.connectorContext());
        if (CollectionUtils.isEmpty(errors)) {
            return null;
        }
        return ImmutableErrorDetails.builder()
                .errorCode(ErrorCode.InvalidArgument)
                .errorMessage(String.join(",", errors))
                .build();
    }

    public static ErrorDetails validateDescribeEntityRequest(final DescribeEntityRequest request) {
        final List<String> errors = validateConnectorContext(request.connectorContext());
        if (CollectionUtils.isEmpty(errors)) {
            return null;
        }
        return ImmutableErrorDetails.builder()
                .errorCode(ErrorCode.InvalidArgument)
                .errorMessage(String.join(",", errors))
                .build();
    }

    public static ErrorDetails validateRetrieveDataRequest(final RetrieveDataRequest request) {
        final List<String> errors = validateConnectorContext(request.connectorContext());
        if (CollectionUtils.isEmpty(errors)) {
            return null;
        }
        return ImmutableErrorDetails.builder()
                .errorCode(ErrorCode.InvalidArgument)
                .errorMessage(String.join(",", errors))
                .build();
    }

    public static ErrorDetails validateWriteDataRequest(final WriteDataRequest request) {
        final List<String> errors = new ArrayList<>();
        if (!SalesforceConnectorConfiguration.supportedWriteOperations().contains(request.operation())) {
            errors.add(String.format("Operation %s is not supported by Salesforce", request.operation()));
        }
        errors.addAll(validateConnectorContext(request.connectorContext()));
        if (CollectionUtils.isEmpty(errors)) {
            return null;
        }
        return ImmutableErrorDetails.builder()
                .errorCode(ErrorCode.InvalidArgument)
                .errorMessage(String.join(",", errors))
                .build();
    }

    public static ErrorDetails validateQueryDataRequest(final QueryDataRequest request) {
        final List<String> errors = validateConnectorContext(request.connectorContext());
        if (CollectionUtils.isEmpty(errors)) {
            return null;
        }
        return ImmutableErrorDetails.builder()
                .errorCode(ErrorCode.InvalidArgument)
                .errorMessage(String.join(",", errors))
                .build();
    }

    private static List<String> validateConnectorContext(final ConnectorContext connectorContext) {
        final List<String> errors = new ArrayList<>();
        errors.addAll(validateCredentialsInput(connectorContext.credentials()));
        errors.addAll(validateConnectorRuntimeSettingsInput(connectorContext.connectorRuntimeSettings()));
        return errors;
    }

    private static List<String> validateCredentialsInput(final Credentials credentials) {
        final List<String> errors = new ArrayList<>();
        if (Objects.isNull(credentials.secretArn())) {
            errors.add("Secret Arn for credentials should be provided as part of request in ConnectorContext");
        }
        return errors;
    }

    private static List<String> validateConnectorRuntimeSettingsInput(final Map<String, String> connectorRuntimeSettingMap) {
        final List<String> errors = new ArrayList<>();
        if (Objects.isNull(connectorRuntimeSettingMap)) {
            errors.add("Connector Context cannot be null for the Salesforce connector");
            return errors;
        }
        if (!connectorRuntimeSettingMap.containsKey(INSTANCE_URL)) {
            errors.add("InstanceUrl should be provided as connector setting for the Salesforce connector");
        }
        return errors;
    }
}
