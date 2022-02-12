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

import com.amazonaws.appflow.custom.connector.integ.providers.ServiceProvider;
import com.amazonaws.services.appflow.AmazonAppflow;
import com.amazonaws.services.appflow.model.DescribeFlowExecutionRecordsRequest;
import com.amazonaws.services.appflow.model.DescribeFlowExecutionRecordsResult;
import com.amazonaws.services.appflow.model.ExecutionRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static com.amazonaws.services.appflow.model.ExecutionStatus.InProgress;

/**
 * Util class for polling flow executions util completion.
 */
public class FlowPoller {

    private final AmazonAppflow client;

    private static final long MILLISECONDS_IN_SECOND = 1000L;

    private static final Logger LOGGER = LoggerFactory.getLogger(FlowPoller.class);

    public FlowPoller() {
        this.client = ServiceProvider.getAppflow();
    }

    /**
     * Use this method to poll flow executions.
     * @param pollingConfig The configuration used to poll the flow.
     * @return The execution records present when the flow has completed or the timeout has been reached.
     */
    public Optional<ExecutionRecord> pollForExecutionRecordsResponse(final PollingConfiguration pollingConfig) {
        LOGGER.info("Polling flow for completion with execution Id " + pollingConfig.executionId());
        Optional<ExecutionRecord> executionRecordOptional;
        int totalTime = 0;
        do {
            try {
                Thread.sleep(pollingConfig.timeBetweenPollsS() * MILLISECONDS_IN_SECOND);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DescribeFlowExecutionRecordsResult describeFlowExecutionRecordsResult = client.describeFlowExecutionRecords(
                    new DescribeFlowExecutionRecordsRequest().withFlowName(pollingConfig.flowName()));
            executionRecordOptional = describeFlowExecutionRecordsResult.getFlowExecutions()
                    .stream()
                    .filter(executionRecord -> executionRecord.getExecutionId().equals(pollingConfig.executionId()))
                    .findFirst();
            totalTime += pollingConfig.timeBetweenPollsS();
        } while ((!executionRecordOptional.isPresent() ||
                InProgress.name().equals(executionRecordOptional.get().getExecutionStatus())) &&
                pollingConfig.maxPollTimeS() > totalTime);
        return executionRecordOptional;
    }
}
