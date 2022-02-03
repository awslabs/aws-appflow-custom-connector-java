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

package com.amazonaws.appflow.custom.connector.example.handler;

import com.amazonaws.appflow.custom.connector.example.parser.EntityParser;
import com.amazonaws.appflow.custom.connector.example.SalesforceResponse;
import com.amazonaws.appflow.custom.connector.example.validation.RequestValidator;
import com.amazonaws.appflow.custom.connector.handlers.MetadataHandler;
import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.amazonaws.appflow.custom.connector.model.metadata.DescribeEntityRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.DescribeEntityResponse;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableDescribeEntityResponse;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableListEntitiesResponse;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesRequest;
import com.amazonaws.appflow.custom.connector.model.metadata.ListEntitiesResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Implementation for Salesforce Metadata operations.
 */
public class SalesforceMetadataHandler extends AbstractSalesforceHandler implements MetadataHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesforceMetadataHandler.class);

    private static final String SALESFORCE_SOBJECTS_URL_FORMAT = "%sservices/data/%s/sobjects";
    private static final String SALESFORCE_SOBJECT_URL_FORMAT = "%sservices/data/%s/sobjects/%s";
    private static final String SALESFORCE_SOBJECT_DESCRIBE_URL_FORMAT = "%sservices/data/%s/sobjects/%s/describe";

    @Override
    public ListEntitiesResponse listEntities(final ListEntitiesRequest request) {
        ErrorDetails errorDetails = RequestValidator.validateListEntitiesRequest(request);
        if (Objects.nonNull(errorDetails)) {
            LOGGER.error("ListEntities request failed with errorDetails " + errorDetails);
            return ImmutableListEntitiesResponse.builder().isSuccess(false).errorDetails(errorDetails).build();
        }
        String requestUri;
        if (StringUtils.isEmpty(request.entitiesPath())) {
            requestUri = buildSalesforceRequestURI(request.connectorContext(), SALESFORCE_SOBJECTS_URL_FORMAT, null);
        } else {
            requestUri = buildSalesforceRequestURI(request.connectorContext(), SALESFORCE_SOBJECT_URL_FORMAT,
                    request.entitiesPath());
        }
        final SalesforceResponse salesforceResponse =
                getSalesforceClient(request.connectorContext()).restGet(requestUri);
        errorDetails = checkForErrorsInSalesforceResponse(salesforceResponse);
        if (Objects.nonNull(errorDetails)) {
            return ImmutableListEntitiesResponse.builder().isSuccess(false).errorDetails(errorDetails).build();
        } else {
            return ImmutableListEntitiesResponse.builder()
                    .isSuccess(true)
                    .entities(EntityParser.parseEntity(salesforceResponse.response()))
                    .build();
        }
    }

    @Override
    public DescribeEntityResponse describeEntity(final DescribeEntityRequest request) {
        ErrorDetails errorDetails = RequestValidator.validateDescribeEntityRequest(request);
        if (Objects.nonNull(errorDetails)) {
            LOGGER.error("DescribeEntity request failed with errorDetails " + errorDetails);
            return ImmutableDescribeEntityResponse.builder().isSuccess(false).errorDetails(errorDetails).build();
        }
        final String requestUri =
                buildSalesforceRequestURI(request.connectorContext(), SALESFORCE_SOBJECT_DESCRIBE_URL_FORMAT,
                        request.entityIdentifier());
        final SalesforceResponse salesforceResponse =
                getSalesforceClient(request.connectorContext()).restGet(requestUri);
        errorDetails = checkForErrorsInSalesforceResponse(salesforceResponse);

        if (Objects.nonNull(errorDetails)) {
            return ImmutableDescribeEntityResponse.builder().isSuccess(false).errorDetails(errorDetails).build();
        } else {
            return ImmutableDescribeEntityResponse.builder()
                    .isSuccess(true)
                    .entityDefinition(EntityParser.parseEntityDefinition(salesforceResponse.response()))
                    .build();
        }
    }
}
