package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx2;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetParamEx2ResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetParamEx2.Result, GetParamEx2.Result> {

    private static final String PARAM_TYPE = "1";
    private static final String PARAM_VALUE = "2";
    private static final String PARAM_IMAGE = "3";
    private static final String RESULT = "4";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Override
    public @NotNull Deserializer<GetParamEx2.Result> getDeserializerUnderTest() {
        return GetParamEx2ResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetParamEx2.Result getTargetObject() {

        final GetParamEx2.ParamEx2 paramEx = GetParamEx2.ParamEx2.builder()
                .paramType(PARAM_TYPE)
                .paramValue(PARAM_VALUE)
                .paramImage(PARAM_IMAGE)
                .result(RESULT)
                .build();

        return new GetParamEx2.Result(paramEx);
    }

    @NotNull
    @Override
    public qlua.rpc.GetParamEx2.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetParamEx2.ParamEx2 paramEx = qlua.rpc.GetParamEx2.ParamEx2.newBuilder()
                .setParamType(PARAM_TYPE)
                .setParamValue(PARAM_VALUE)
                .setParamImage(PARAM_IMAGE)
                .setResult(RESULT)
                .build();

        return qlua.rpc.GetParamEx2.Result.newBuilder()
                .setParamEx(paramEx)
                .build();
    }

    // TODO: really shouldn't be a responsibility of the deserializer
    @Test
    public void shouldFailOnUninitializedPbParamEx() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(
                equalTo("Поле 'param_ex' экземпляра protobuf-представления qlua.rpc.GetParamEx2.Result не инициализировано.")
        );

        getDeserializerUnderTest().deserialize(qlua.rpc.GetParamEx2.Result.newBuilder().build().toByteArray());
    }
}
