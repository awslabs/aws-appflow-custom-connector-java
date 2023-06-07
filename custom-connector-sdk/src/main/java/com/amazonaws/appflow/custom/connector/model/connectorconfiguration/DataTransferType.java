/*-
 * #%L
 * aws-custom-connector-sdk
 * %%
 * Copyright (C) 2021 - 2023 Amazon Web Services
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
package com.amazonaws.appflow.custom.connector.model.connectorconfiguration;

/**
 * Enum class representing the types of data transfers.
 */
public enum DataTransferType {
    /**
     * Represents data transfer in the form of records. This type is used when data transfer involves structured records.
     */
    RECORD,
    /**
     * Represents data transfer in the form of files. This type is used when data transfer involves files or binary data.
     */
    FILE
}
