/*-
 * #%L
 * Amazon AppFlow Custom Connector SDK
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
package com.amazonaws.appflow.custom.connector;

public final class Constants {
    private Constants(){
    }

    public static final Long MAX_RESULT_SIZE = 1000L;
    public static final String AUTHENTICATION_TYPE = "authenticationType";
    
    //BasicAuthCredentials Constants
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    //ApiKeyCredentials Constants
    public static final String API_KEY = "apiKey";
    public static final String SECRET_KEY = "secretKey";

    //OAuth2Credentials Constants
    public static final String ACCESS_TOKEN = "accessToken";

    //CustomAuthCredentials Constant
    public static final String CUSTOM_AUTHENTICATION_TYPE = "customAuthenticationType";
}
