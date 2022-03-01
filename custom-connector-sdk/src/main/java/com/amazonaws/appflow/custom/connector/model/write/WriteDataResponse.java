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

package com.amazonaws.appflow.custom.connector.model.write;

import com.amazonaws.appflow.custom.connector.model.ErrorDetails;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Represents the output of a <code>WriteData</> operation.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableWriteDataResponse.class)
@JsonDeserialize(as = ImmutableWriteDataResponse.class)
public interface WriteDataResponse {
    /**
     * Specifies if the operation is successful or not. In case of partial failure,
     * this flag should be set to false and the error code should be set to PartialWriteFailure.
     */
    boolean isSuccess();

    /**
     * Error details if the Operation is unsuccessful.
     */
    @Nullable
    ErrorDetails errorDetails();

    /**
     * List of input records write call response with success and failure details.
     */
    @Nullable
    List<WriteRecordResult> writeRecordResults();
}
