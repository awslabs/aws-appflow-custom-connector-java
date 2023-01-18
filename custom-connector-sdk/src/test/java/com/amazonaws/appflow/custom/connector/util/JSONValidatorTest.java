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
package com.amazonaws.appflow.custom.connector.util;

import com.amazonaws.appflow.custom.connector.model.metadata.EntityDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDataType;
import com.amazonaws.appflow.custom.connector.model.metadata.FieldDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableEntity;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableEntityDefinition;
import com.amazonaws.appflow.custom.connector.model.metadata.ImmutableFieldDefinition;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JSONValidatorTest {

    private static final List<String> NON_NUMBERS = ImmutableList.of("true", "false", "\"sadlfjeorghaslg123241231!2234@#$%&*()\"",
            "\"\"", "[1,2]", "\"2022-12-16\"", "[\"1\",\"2\"]", "{\"test\":\"test2\"}");

    private static final List<String> NON_STRINGS = ImmutableList.of("true", "false", "[\"1\",\"2\"]", "{\"test\":\"test2\"}", "1");
    private static final List<String> NON_OBJECT = ImmutableList.of("true", "false", "1", "1-1-1", "\"test\"");


    public static Stream<Arguments> validJsonObjects() {
        return Stream.of(
                Arguments.of("1", FieldDataType.BigDecimal),
                Arguments.of("10000000000000000000000000000000000000", FieldDataType.BigDecimal),
                Arguments.of("1.212312124125543623243242423423432423423423234242343", FieldDataType.BigDecimal),
                Arguments.of("12321321431215498.1230129414039240234", FieldDataType.BigDecimal),
                Arguments.of("12321321431215498.1230129414039240234", FieldDataType.BigDecimal),
                Arguments.of("12321321431215498.1230129414039240234", FieldDataType.BigDecimal),
                Arguments.of("-10000000000000000000000000000000000000", FieldDataType.BigDecimal),
                Arguments.of("14328094325208304324394203941090423409E23", FieldDataType.BigDecimal),
                Arguments.of("143280943252083043243942039410904234090000000", FieldDataType.BigInteger),
                Arguments.of("12132432.12312432", FieldDataType.Float),
                Arguments.of(String.valueOf(Float.MAX_VALUE), FieldDataType.Float),
                Arguments.of(String.valueOf(Float.MIN_VALUE), FieldDataType.Float),
                Arguments.of(String.valueOf(Double.MIN_VALUE), FieldDataType.Double),
                Arguments.of(String.valueOf(Double.MAX_VALUE), FieldDataType.Double),
                Arguments.of("1112131232411111.1112141323111111", FieldDataType.Double),
                Arguments.of("1", FieldDataType.BigInteger),
                Arguments.of("1090908", FieldDataType.Integer),
                Arguments.of(String.valueOf(Integer.MAX_VALUE), FieldDataType.Integer),
                Arguments.of(String.valueOf(Integer.MIN_VALUE), FieldDataType.Integer),
                Arguments.of(String.valueOf(Short.MAX_VALUE), FieldDataType.Short),
                Arguments.of(String.valueOf(Short.MIN_VALUE), FieldDataType.Short),
                Arguments.of("-1", FieldDataType.BigInteger),
                Arguments.of("-923482390423492354906325234314", FieldDataType.BigInteger),
                Arguments.of("true", FieldDataType.Boolean),
                Arguments.of("false", FieldDataType.Boolean),
                Arguments.of("\"sadlfjeorghaslg123241231!2234@#$%&*()\"", FieldDataType.String),
                Arguments.of("\"\"", FieldDataType.String),
                Arguments.of("\"sadlfjeorghaslg123241231!2234@#$%&*()\"", FieldDataType.ByteArray),
                Arguments.of("\"\"", FieldDataType.ByteArray),
                Arguments.of("{\"test\":\"test2\"}", FieldDataType.Map),
                Arguments.of("{\"test\":\"test2\"}", FieldDataType.Struct),
                Arguments.of("[]", FieldDataType.List),
                Arguments.of("[1,2]", FieldDataType.List),
                Arguments.of("\"2022-12-16\"", FieldDataType.Date),
                Arguments.of("\"2022-12-16T12:06:33+00:00\"", FieldDataType.DateTime),
                Arguments.of("[\"1\",\"2\"]", FieldDataType.List),
                Arguments.of("923482390423492354906325234314", FieldDataType.BigInteger)
        );
    }

    public static Stream<Arguments> inValidJsonObjects() {
        List<Arguments> args = NON_NUMBERS.stream().map((val) -> Arguments.of(val, FieldDataType.BigDecimal)).collect(Collectors.toList());
        args.addAll(NON_NUMBERS.stream().map((val) -> Arguments.of(val, FieldDataType.Double)).collect(Collectors.toList()));
        args.addAll(NON_NUMBERS.stream().map((val) -> Arguments.of(val, FieldDataType.Float)).collect(Collectors.toList()));
        args.addAll(NON_NUMBERS.stream().map((val) -> Arguments.of(val, FieldDataType.Integer)).collect(Collectors.toList()));
        args.addAll(NON_NUMBERS.stream().map((val) -> Arguments.of(val, FieldDataType.BigInteger)).collect(Collectors.toList()));
        args.addAll(NON_NUMBERS.stream().map((val) -> Arguments.of(val, FieldDataType.Short)).collect(Collectors.toList()));
        args.add(Arguments.of("1.1", FieldDataType.Integer));
        args.add(Arguments.of(String.valueOf(Double.valueOf(Integer.MAX_VALUE) + 1), FieldDataType.Integer));
        args.add(Arguments.of("1.1", FieldDataType.BigInteger));
        args.add(Arguments.of(String.valueOf(Integer.MAX_VALUE), FieldDataType.Short));
        args.add(Arguments.of(String.valueOf(Integer.MIN_VALUE), FieldDataType.Short));
        args.addAll(NON_STRINGS.stream().map((val) -> Arguments.of(val, FieldDataType.String)).collect(Collectors.toList()));
        args.addAll(NON_STRINGS.stream().map((val) -> Arguments.of(val, FieldDataType.Date)).collect(Collectors.toList()));
        args.addAll(NON_STRINGS.stream().map((val) -> Arguments.of(val, FieldDataType.DateTime)).collect(Collectors.toList()));
        args.addAll(NON_STRINGS.stream().map((val) -> Arguments.of(val, FieldDataType.ByteArray)).collect(Collectors.toList()));
        args.add(Arguments.of("adslkfjda", FieldDataType.Boolean));
        args.add(Arguments.of("1", FieldDataType.Boolean));
        args.add(Arguments.of("bool", FieldDataType.Boolean));
        args.add(Arguments.of("\"asdas\"", FieldDataType.Boolean));
        args.addAll(NON_OBJECT.stream().map((val) -> Arguments.of(val, FieldDataType.List)).collect(Collectors.toList()));
        args.addAll(NON_OBJECT.stream().map((val) -> Arguments.of(val, FieldDataType.Struct)).collect(Collectors.toList()));
        return args.stream();
    }

    private JSONValidator jsonHelper;

    @BeforeEach
    public void setup() {
        jsonHelper = new JSONValidator(CustomObjectMapper.getObjectMapper());
    }

    @ParameterizedTest
    @MethodSource("validJsonObjects")
    public void testJsonObjectsAreValid(String val, FieldDataType fieldDataType) throws DataFormatValidationException {
        jsonHelper.validateJsonObject(String.format("{\"test\":%s}", val), ImmutableMap.of("test", fieldDataType));
    }

    @ParameterizedTest
    @MethodSource("inValidJsonObjects")
    public void testJsonObjectsAreInValid(String val, FieldDataType fieldDataType) {
        Assertions.assertThrows(DataFormatValidationException.class,
                ()-> jsonHelper.validateJsonObject(String.format("{\"test\":%s}", val), ImmutableMap.of("test", fieldDataType)));
    }

    @Test
    public void testGetFormatsFromEntityDefinition() {
        EntityDefinition entityDefinition = ImmutableEntityDefinition.builder().addAllFields(Arrays.asList(getField("test1", FieldDataType.List),
                getField("test", FieldDataType.Long))).entity(ImmutableEntity.builder()
                .entityIdentifier("id")
                .hasNestedEntities(false).isWritable(true).build()).build();
        Map<String, FieldDataType> formatsFromEntityDefinition = JSONValidator.getFormatsFromEntityDefinition(entityDefinition);
        Assertions.assertEquals(formatsFromEntityDefinition.get("test1"), FieldDataType.List);
        Assertions.assertEquals(formatsFromEntityDefinition.get("test"), FieldDataType.Long);
    }

    private FieldDefinition getField(String fieldName, FieldDataType fieldDataType) {
        return ImmutableFieldDefinition.builder().fieldName(fieldName).dataType(fieldDataType).dataTypeLabel("test").filterOperators(new ArrayList()).build();
    }
}
