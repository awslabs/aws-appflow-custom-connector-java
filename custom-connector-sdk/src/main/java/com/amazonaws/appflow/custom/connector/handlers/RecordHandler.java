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

package com.amazonaws.appflow.custom.connector.handlers;

import com.amazonaws.appflow.custom.connector.model.query.QueryDataRequest;
import com.amazonaws.appflow.custom.connector.model.query.QueryDataResponse;
import com.amazonaws.appflow.custom.connector.model.retreive.RetrieveDataRequest;
import com.amazonaws.appflow.custom.connector.model.retreive.RetrieveDataResponse;
import com.amazonaws.appflow.custom.connector.model.write.WriteDataRequest;
import com.amazonaws.appflow.custom.connector.model.write.WriteDataResponse;

/**
 * This interface defines the functionality to be implemented by custom connectors for record related operations.
 */
public interface RecordHandler {
    /**
     * Retrieves the batch of records against a set of identifiers from the source application
     *
     * @param request - {@link RetrieveDataRequest}
     * @return - {@link RetrieveDataResponse}
     */
    RetrieveDataResponse retrieveData(RetrieveDataRequest request);

    /**
     * Writes batch of records to the destination application
     *
     * @param request - {@link WriteDataRequest}
     * @return - {@link WriteDataResponse}
     */
    WriteDataResponse writeData(WriteDataRequest request);

    /**
     * Queries the data from the source application against the supplied filter conditions.
     *
     * @param request - {@link QueryDataRequest}
     * @return - {@link QueryDataResponse}
     */
    QueryDataResponse queryData(QueryDataRequest request);
}
