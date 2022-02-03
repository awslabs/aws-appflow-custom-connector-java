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

import com.amazonaws.appflow.custom.connector.example.parser.RecordResponseParser;
import com.amazonaws.appflow.custom.connector.example.query.ImmutableQueryObject;
import com.amazonaws.appflow.custom.connector.example.query.QueryObject;
import com.amazonaws.appflow.custom.connector.example.client.HttpClient;
import com.amazonaws.appflow.custom.connector.example.query.SalesforceQueryBuilder;
import com.amazonaws.appflow.custom.connector.example.SalesforceResponse;
import com.amazonaws.appflow.custom.connector.example.validation.RequestValidator;
import com.amazonaws.appflow.custom.connector.handlers.RecordHandler;
import com.amazonaws.appflow.custom.connector.model.ConnectorContext;
import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDataType;
import com.amazonaws.appflow.custom.connector.model.query.ImmutableQueryDataResponse;
import com.amazonaws.appflow.custom.connector.model.query.QueryDataRequest;
import com.amazonaws.appflow.custom.connector.model.query.QueryDataResponse;
import com.amazonaws.appflow.custom.connector.model.retreive.ImmutableRetrieveDataResponse;
import com.amazonaws.appflow.custom.connector.model.retreive.RetrieveDataRequest;
import com.amazonaws.appflow.custom.connector.model.retreive.RetrieveDataResponse;
import com.amazonaws.appflow.custom.connector.model.write.ImmutableWriteDataResponse;
import com.amazonaws.appflow.custom.connector.model.write.WriteDataRequest;
import com.amazonaws.appflow.custom.connector.model.write.WriteDataResponse;
import com.amazonaws.appflow.custom.connector.model.write.WriteOperationType;
import com.amazonaws.appflow.custom.connector.model.write.WriteRecordResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation for Salesforce Record Operations.
 */
public class SalesforceRecordHandler extends AbstractSalesforceHandler implements RecordHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesforceMetadataHandler.class);

    private static final String SALESFORCE_OBJECT_API_FORMAT = "%s/services/data/%s/sobjects/%s";
    private static final String SALESFORCE_QUERY_FORMAT = "%s/services/data/%s/query?q=%s";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public RetrieveDataResponse retrieveData(final RetrieveDataRequest request) {
        ErrorDetails errorDetails = RequestValidator.validateRetrieveDataRequest(request);
        if (Objects.nonNull(errorDetails)) {
            LOGGER.error("RetrieveData request failed with errorDetails " + errorDetails);
            return ImmutableRetrieveDataResponse.builder().isSuccess(false).errorDetails(errorDetails).build();
        }
        final QueryObject queryObject = ImmutableQueryObject.builder()
                .sObject(request.entityIdentifier())
                .selectedFieldNames(request.selectedFieldNames())
                .idFieldName(request.idFieldName())
                .fields(request.ids())
                //TODO:: Field data type should come from metadata. Not adding that implementation in example.
                .dataType(FieldDataType.Struct.name())
                .build();

        final SalesforceResponse salesforceResponse =
                getQueryConnectorResponse(queryObject, request.connectorContext());
        errorDetails = checkForErrorsInSalesforceResponse(salesforceResponse);
        if (Objects.nonNull(errorDetails)) {
            return ImmutableRetrieveDataResponse.builder().isSuccess(false).errorDetails(errorDetails).build();
        } else {
            return ImmutableRetrieveDataResponse.builder()
                    .records(RecordResponseParser.parseQueryResponse(salesforceResponse.response()))
                    .isSuccess(true)
                    .build();
        }
    }

    @Override
    public WriteDataResponse writeData(final WriteDataRequest request) {
        ErrorDetails errorDetails = RequestValidator.validateWriteDataRequest(request);
        if (Objects.nonNull(errorDetails)) {
            LOGGER.error("WriteData request failed with errorDetails " + errorDetails);
            return ImmutableWriteDataResponse.builder().isSuccess(false).errorDetails(errorDetails).build();
        }

        List<WriteRecordResult> recordResults = new ArrayList<>();
        for (String record : request.records()) {
            SalesforceResponse salesforceResponse = getSalesforceWriteResponse(record, request);
            errorDetails = checkForErrorsInSalesforceResponse(salesforceResponse);
            if (Objects.nonNull(errorDetails)) {
                return ImmutableWriteDataResponse.builder().isSuccess(false).errorDetails(errorDetails).build();
            }
            if (Objects.nonNull(salesforceResponse.response())) {
                recordResults.add(RecordResponseParser.parseWriteResponse(salesforceResponse.response()));
            }
        }

        // Salesforce UPDATE operation does not return a response. In this case we succeed unless there are errors found.
        if (!WriteOperationType.UPDATE.equals(request.operation()) && CollectionUtils.isEmpty(recordResults)) {
            return ImmutableWriteDataResponse.builder().isSuccess(false).build();
        } else {
            return ImmutableWriteDataResponse.builder().isSuccess(true).writeRecordResults(recordResults).build();
        }
    }

    @Override
    public QueryDataResponse queryData(final QueryDataRequest request) {
        ErrorDetails errorDetails = RequestValidator.validateQueryDataRequest(request);
        if (Objects.nonNull(errorDetails)) {
            LOGGER.error("QueryData request failed with errorDetails " + errorDetails);
            return ImmutableQueryDataResponse.builder().errorDetails(errorDetails).isSuccess(false).build();
        }
        final QueryObject queryObject = ImmutableQueryObject.builder()
                .sObject(request.entityIdentifier())
                .selectedFieldNames(request.selectedFieldNames())
                .filterExpression(request.filterExpression())
                .entityDefinition(request.connectorContext().entityDefinition())
                .build();

        final SalesforceResponse salesforceResponse =
                getQueryConnectorResponse(queryObject, request.connectorContext());
        errorDetails = checkForErrorsInSalesforceResponse(salesforceResponse);
        if (Objects.nonNull(errorDetails)) {
            return ImmutableQueryDataResponse.builder().errorDetails(errorDetails).isSuccess(false).build();
        } else {
            return ImmutableQueryDataResponse.builder()
                    .records(RecordResponseParser.parseQueryResponse(salesforceResponse.response()))
                    .isSuccess(true)
                    .build();
        }
    }

    private SalesforceResponse getSalesforceWriteResponse(final String record, final WriteDataRequest request) {
        JsonNode recordJson;
        try {
            recordJson = MAPPER.readValue(record, JsonNode.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Invalid record provided for Write operation. Record must be valid JSON", e);
        }
        String requestUri = buildSalesforceRequestURI(request.connectorContext(), SALESFORCE_OBJECT_API_FORMAT,
            request.entityIdentifier());

        if (WriteOperationType.INSERT.equals(request.operation())) {
            return getSalesforceClient(request.connectorContext()).restPost(requestUri, record);
        } else if (WriteOperationType.UPDATE.equals(request.operation())) {
            if (Objects.requireNonNull(request.idFieldNames()).size() != 1) {
                throw new IllegalArgumentException(
                    "A single Id field name is required for UPDATE operations in Salesforce");
            }

            String recordIdKey = request.idFieldNames().get(0);
            String recordId = getValueFromRecord(recordJson, recordIdKey);
            ((ObjectNode) recordJson).remove(recordIdKey);

            requestUri = requestUri + "/" + recordId;
            return getSalesforceClient(request.connectorContext()).restPatch(requestUri, recordJson.toString());
        } else if (WriteOperationType.UPSERT.equals(request.operation())) {
            if (Objects.requireNonNull(request.idFieldNames()).size() != 1) {
                throw new IllegalArgumentException(
                    "A single Id field name is required for UPSERT operations in Salesforce");
            }

            String recordIdKey = request.idFieldNames().get(0);
            String recordId = getValueFromRecord(recordJson, recordIdKey);
            ((ObjectNode) recordJson).remove(recordIdKey);

            requestUri = requestUri + "/" + recordIdKey + "/" + recordId;
            return getSalesforceClient(request.connectorContext()).restPatch(requestUri, recordJson.toString());
        } else {
            throw new IllegalArgumentException(
                "Write Operation Type" + request.operation().name() + " is not supported.");
        }
    }

    private SalesforceResponse getQueryConnectorResponse(final QueryObject queryObject, final ConnectorContext connectorContext) {
        final String query = getQueryString(queryObject);
        final String requestUri = buildSalesforceRequestURI(connectorContext, SALESFORCE_QUERY_FORMAT, query);
        final HttpClient httpClient = getSalesforceClient(connectorContext);
        return httpClient.restGet(requestUri);
    }

    private String getQueryString(final QueryObject queryObject) {
        try {
            return URLEncoder.encode(SalesforceQueryBuilder.buildQuery(queryObject), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Unable to encode the url", ex);
        }
    }

    private String getValueFromRecord(final JsonNode jsonRecord, final String key) {
        if (Objects.isNull(jsonRecord) || Objects.isNull(jsonRecord.get(key))) {
            throw new IllegalArgumentException(key + " key is missing from JSON record but is required");
        }

        if (StringUtils.isEmpty(jsonRecord.get(key).textValue())) {
            throw new IllegalArgumentException("Invalid value for object identifier key " + key);
        }

        return jsonRecord.get(key).textValue();
    }
}
