/*
 * -
 *  * #%L
 * * Amazon Appflow Custom Connector SDK.
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
 * Enum of error codes.
 */
public enum ErrorCode {
    /**
     * Specifies error is due to client.
     */
    ClientError,

    /**
     * Specifies error is due to application.
     */
    ServerError,

    /**
     * Invalid arguments provided as input.
     */
    InvalidArgument,

    /**
     * Credentials were rejected by the underlying application.
     */
    InvalidCredentials,

    /**
     * Resource access denied by the underlying application.
     */
    AccessDenied,

    /**
     * The request to the underlying application timed out.
     */
    RequestTimeout,

    /**
     * Payload size is too large.
     */
    PayloadTooLarge,

    /**
     * Request got rejected by the underlying application due to rate limit violation.
     */
    RateLimitExceeded,

    /**
     * Not able to serve the request due to an internal error.
     */
    InternalServerError,

    /**
     * Server is not available to serve the requests at the moment
     */
    ServiceUnavailable,

    /**
     * Unknown Error from the application.
     */
    UnknownError
}
