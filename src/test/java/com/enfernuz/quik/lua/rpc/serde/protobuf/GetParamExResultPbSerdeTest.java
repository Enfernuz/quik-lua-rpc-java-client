package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetParamExResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetParamEx.Result, GetParamEx.Result> {

    private static final String PARAM_TYPE = "1";
    private static final String PARAM_VALUE = "2";
    private static final String PARAM_IMAGE = "3";
    private static final String RESULT = "4";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Override
    public @NotNull Deserializer<GetParamEx.Result> getDeserializerUnderTest() {
        return GetParamExResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetParamEx.Result getTargetObject() {

        final GetParamEx.ParamEx paramEx = GetParamEx.ParamEx.builder()
                .paramType(PARAM_TYPE)
                .paramValue(PARAM_VALUE)
                .paramImage(PARAM_IMAGE)
                .result(RESULT)
                .build();

        return new GetParamEx.Result(paramEx);
    }

    @NotNull
    @Override
    public qlua.rpc.GetParamEx.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetParamEx.ParamEx paramEx = qlua.rpc.GetParamEx.ParamEx.newBuilder()
                .setParamType(PARAM_TYPE)
                .setParamValue(PARAM_VALUE)
                .setParamImage(PARAM_IMAGE)
                .setResult(RESULT)
                .build();

        return qlua.rpc.GetParamEx.Result.newBuilder()
                .setParamEx(paramEx)
                .build();
    }

    // TODO: really shouldn't be a responsibility of the deserializer
    @Test
    public void shouldFailOnUninitializedPbParamEx() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(
                equalTo("Поле 'param_ex' экземпляра protobuf-представления qlua.rpc.GetParamEx.Result не инициализировано.")
        );

        getDeserializerUnderTest().deserialize(qlua.rpc.GetParamEx.Result.newBuilder().build().toByteArray());
    }
}
