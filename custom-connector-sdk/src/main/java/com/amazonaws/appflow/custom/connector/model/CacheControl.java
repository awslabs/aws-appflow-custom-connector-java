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

package com.amazonaws.appflow.custom.connector.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/**
 * Represents the caching policy for metadata for the supported entities.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableCacheControl.class)
@JsonDeserialize(as = ImmutableCacheControl.class)
public interface CacheControl {

    /**
     * Time to keep the metadata in cache.
     *
     * Return a large number when entity metadata is not dynamic and can
     * be cached for long time. The minimum allowed value is 600 seconds.
     */
    long timeToLive();

    /**
     * TimeUnit for the timeToLive.
     */
    @Nullable
    TimeUnit timeToLiveUnit();
}
