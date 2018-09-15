package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.enfernuz.quik.lua.rpc.serde.protobuf.AbstractResultPbSerdeTest;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;

public class GetParamExResultPbSerdeTest extends AbstractResultPbSerdeTest<GetParamEx.Result, qlua.rpc.GetParamEx.Result> {

    private static final String PARAM_TYPE = "1";
    private static final String PARAM_VALUE = "2";
    private static final String PARAM_IMAGE = "3";
    private static final String RESULT = "4";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Override
    public @NotNull Class<GetParamEx.Result> getTargetObjectClass() {
        return GetParamEx.Result.class;
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

    @Test
    public void shouldFailOnUninitializedPbParamEx() {

        thrown.expect(SerdeException.class);
        thrown.expectCause(
                allOf(
                        instanceOf(IllegalArgumentException.class),
                        hasProperty("message", equalTo("Экземпляр protobuf-представления qlua.rpc.GetParamEx.Result не содержит поля 'paramEx'."))
                )
        );

        getSerdeModuleUnderTest().deserialize(GetParamEx.Result.class, qlua.rpc.GetParamEx.Result.newBuilder().build().toByteArray());
    }
}
