package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetParamExArgsPbSerdeTest extends AbstractPbSerializationTest<GetParamEx.Args, qlua.rpc.GetParamEx.Args> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";
    private static final String PARAM_NAME = "3";

    @Override
    public @NotNull Serializer<GetParamEx.Args> getSerializerUnderTest() {
        return GetParamExArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetParamEx.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetParamEx.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .setParamName(PARAM_NAME)
                .build();
    }

    @NotNull
    @Override
    public GetParamEx.Args getTargetObject() {

        return GetParamEx.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .paramName(PARAM_NAME)
                .build();
    }
}
