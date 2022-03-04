/*
 * -
 *  * #%L
 * * Amazon AppFlow Custom Connector SDK.
 * *
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

package com.amazonaws.appflow.custom.connector.model;

/**
 * Collection of all normalized error codes for returning errors back to AppFlow.
 */
public enum ErrorCode {
    /**
     * Invalid arguments provided as input/HttpStatus 400/413 from application/Bad Request exception from Application.
     * For example QueryURI too large, write request payload too large etc.
     */
    InvalidArgument,

    /**
     * Credentials were rejected by the underlying application/HttpStatus 401 from Application.
     */
    InvalidCredentials,

    /**
     * Resource access denied by the underlying application/HttpStatus 403 from Application.
     */
    AccessDenied,

    /**
     * The request to the underlying application timed out/HttpStatus 408 from Application/
     * HttpClient timeout while sending request.
     */
    RequestTimeout,

    /**
     * Request got rejected by the underlying application due to rate limit violation/HttpStatus 429 from Application.
     */
    RateLimitExceeded,

    /**
     * Application is not available to serve the requests at the moment/HttpStatus 503 from Application.
     */
    ServiceUnavailable,

    /**
     * Specifies error is due to client or HttpStatus 4XX from Application.
     * Use specific error codes if present.
     */
    ClientError,

    /**
     * Specifies error is due to Application or HttpStatus 5XX from Application.
     * Use specific error codes if present.
     */
    ServerError,

    /**
     * Unknown Error from the Application. Use this ErrorCode only when you are not able to use the
     * other specific error codes.
     */
    UnknownError,

    /**
     * Specifies that the connector encountered failure, for some records, while writing to the application.
     */
    PartialWriteFailure,

    /**
     * Specifies that the connector is unable to find the resource like AWS SecretManagerARN etc.
     */
    ResourceNotFoundError
}
