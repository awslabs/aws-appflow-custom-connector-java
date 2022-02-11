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
package com.amazonaws.appflow.custom.connector.integ.util;

import com.amazonaws.appflow.custom.connector.integ.data.TestBucketConfiguration;
import com.amazonaws.appflow.custom.connector.integ.providers.ServiceProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Utility class that uploads files to S3
 */
public class S3Helper {

    private final TestBucketConfiguration testBucketConfiguration;

    public S3Helper(final TestBucketConfiguration testBucketConfiguration) {
        this.testBucketConfiguration = testBucketConfiguration;
    }

    /**
     * Utility for uploading files to the bucket specified in the test configuration.
     * @param file the string data that needs to be uploaded.
     * @param fileName the s3 prefix that that file will be uploaded under
     */
    public void uploadFile(final String file, final String fileName) {
        AmazonS3 amazonS3 = ServiceProvider.getS3();
        amazonS3.putObject(new PutObjectRequest(
                testBucketConfiguration.bucketName(),
                testBucketConfiguration.bucketPrefix() + fileName,
                new ByteArrayInputStream(file.getBytes(StandardCharsets.UTF_8)),
                new ObjectMetadata()));
    }
}
