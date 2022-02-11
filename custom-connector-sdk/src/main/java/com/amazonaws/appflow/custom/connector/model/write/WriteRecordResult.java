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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;

/**
 * Contains write result whether it is successful or not at record level.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableWriteRecordResult.class)
@JsonDeserialize(as = ImmutableWriteRecordResult.class)
public interface WriteRecordResult {
    /**
     * Specifies if the record is written successfully or not.
     */
    boolean isSuccess();

    /**
     * Unique identifier for the record.
     */
    String recordId();

    /**
     * Error message if the record is not written to the destination successfully.
     */
    @Nullable
    String errorMessage();
}
