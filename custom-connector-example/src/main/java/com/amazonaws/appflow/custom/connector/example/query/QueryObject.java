/*
 * -
 *  * #%L
 * * Example Custom Connector.
 *  *
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

package com.amazonaws.appflow.custom.connector.example.query;

import com.amazonaws.appflow.custom.connector.model.metadata.EntityDefinition;
import org.immutables.value.Value;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Class contains all the information to build query.  It might be deleted or method implementations might be changed
 * after adding Antlr parser code.
 */
@Value.Immutable
public interface QueryObject {

    String sObject();

    @Nullable
    List<String> selectedFieldNames();

    @Nullable
    String filterExpression();

    @Nullable
    String idFieldName();

    @Nullable
    List<String> fields();

    @Nullable
    String dataType();

    @Nullable
    EntityDefinition entityDefinition();
}
