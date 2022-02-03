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

package com.amazonaws.appflow.custom.connector.example.client;

import com.amazonaws.appflow.custom.connector.example.ImmutableSalesforceResponse;
import com.amazonaws.appflow.custom.connector.example.SalesforceResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Implementation for HttpClient.
 */
public class HttpClient {
    private static final int TEN_MINUTE_MS = 600000;
    private static final int SOCKET_TIMEOUT_MS = TEN_MINUTE_MS;
    private static final int CONNECTION_TIMEOUT_MS = 30000;
    private static final int REQUEST_TIMEOUT_MS = TEN_MINUTE_MS;
    private static final RequestConfig REQUEST_CONFIG = RequestConfig.custom()
            .setConnectionRequestTimeout(REQUEST_TIMEOUT_MS)
            .setConnectTimeout(CONNECTION_TIMEOUT_MS)
            .setSocketTimeout(SOCKET_TIMEOUT_MS)
            .build();

    private final CloseableHttpClient httpClient;
    private final String accessToken;

    public HttpClient(final String accessToken) {
        this.accessToken = accessToken;
        this.httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(REQUEST_CONFIG)
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .build();
    }

    public SalesforceResponse restGet(final String requestUri) {
        final URI uri = URI.create(requestUri);
        final HttpGet getRequest = new HttpGet(uri);
        addAuthorizationHeader(getRequest);
        return execute(getRequest);
    }

    public SalesforceResponse restPost(final String requestUri, final String postData) {
        final URI uri = URI.create(requestUri);
        final HttpPost postRequest = new HttpPost(uri);
        addAuthorizationHeader(postRequest);
        addPostData(postRequest, postData);
        return execute(postRequest);
    }

    public SalesforceResponse restPatch(final String requestUri, final String patchData) {
        final URI uri = URI.create(requestUri);
        final HttpPatch patchRequest = new HttpPatch(uri);
        addAuthorizationHeader(patchRequest);
        addPatchData(patchRequest, patchData);
        return execute(patchRequest);
    }

    public final SalesforceResponse restPut(final String requestUri, final String putData) {
        final URI uri = URI.create(requestUri);
        final HttpPut putRequest = new HttpPut(uri);
        addAuthorizationHeader(putRequest);
        addPutData(putRequest, putData);
        return execute(putRequest);
    }

    public final SalesforceResponse restDelete(final String requestUri) {
        final URI uri = URI.create(requestUri);
        final HttpDelete deleteRequest = new HttpDelete(uri);
        addAuthorizationHeader(deleteRequest);
        return execute(deleteRequest);
    }

    private SalesforceResponse execute(final HttpUriRequest request) {
        try {
            final CloseableHttpResponse httpResponse = this.httpClient.execute(request);
            final int statusCode = httpResponse.getStatusLine().getStatusCode();
            final String response = Objects.isNull(httpResponse.getEntity()) ?
                null : EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
            final String reason = httpResponse.getStatusLine().getReasonPhrase();
            return ImmutableSalesforceResponse.builder()
                    .statusCode(statusCode)
                    .response(response)
                    .errorReason(reason)
                    .build();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void addAuthorizationHeader(final HttpRequestBase requestBase) {
            requestBase.addHeader("Authorization", "Bearer " + this.accessToken);
    }

    private void addPostData(final HttpPost postRequest, final String postData) {
        final StringEntity params = new StringEntity(postData, ContentType.APPLICATION_JSON);
        postRequest.setEntity(params);
        postRequest.addHeader("Accept-Encoding", "gzip");
    }

    private void addPatchData(final HttpPatch patchRequest, final String patchData) {
        final StringEntity params = new StringEntity(patchData, ContentType.APPLICATION_JSON);
        patchRequest.setEntity(params);
        patchRequest.addHeader("Accept-Encoding", "gzip");
    }

    private void addPutData(final HttpPut putRequest, final String putData) {
        final StringEntity params = new StringEntity(putData, ContentType.create("text/csv", StandardCharsets.UTF_8));
        putRequest.setEntity(params);
        putRequest.addHeader("Content-Type", "text/csv");
    }
}
