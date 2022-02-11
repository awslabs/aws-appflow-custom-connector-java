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

import com.amazonaws.services.appflow.AmazonAppflow;
import com.amazonaws.services.appflow.AmazonAppflowClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.appflow.custom.connector.integ.util.FlowPoller;

/**
 * This class contains singleton service references.
 */
public final class ServiceProvider {

    private ServiceProvider(){}

    private static AmazonAppflow client;

    private static AWSSecretsManager secretsManager;

    private static AmazonS3 amazonS3;

    private static FlowPoller flowPoller;

    public static AmazonAppflow getAppflow() {
        if (client == null) {
            client = AmazonAppflowClientBuilder.standard()
                    .build();
        }
        return client;
    }

    public static FlowPoller getFlowPoller() {
        if (flowPoller == null) {
            flowPoller = new FlowPoller();
        }
        return flowPoller;
    }

    public static AmazonS3 getS3() {
        if (amazonS3 == null) {
            amazonS3 = AmazonS3ClientBuilder.standard()
                    .build();
        }
        return amazonS3;
    }

    public static AWSSecretsManager getSecretsManager() {
        if (secretsManager == null) {
            secretsManager = AWSSecretsManagerClientBuilder.standard().build();
        }
        return secretsManager;
    }
}
