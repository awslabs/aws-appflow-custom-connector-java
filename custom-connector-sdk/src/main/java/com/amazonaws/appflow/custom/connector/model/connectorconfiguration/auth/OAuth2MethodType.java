/*-
 * #%L
 * aws-custom-connector-sdk
 * %%
 * Copyright (C) 2021 - 2022 Amazon Web Services
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
package com.amazonaws.appflow.custom.connector.model.connectorconfiguration.auth;

/**
 * OAuth2 Http method to use for the token request. AppFlow uses this when making login requests.
 * Default: POST
 */
public enum OAuth2MethodType {

    /**
     * POST method type
     */
    HTTP_POST,

    /**
     * GET method type
     */
    HTTP_GET
}
