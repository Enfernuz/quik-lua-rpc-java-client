package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx2;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetParamEx2ArgsPbSerdeTest extends AbstractPbSerializationTest<GetParamEx2.Args, qlua.rpc.GetParamEx2.Args> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";
    private static final String PARAM_NAME = "3";

    @Override
    public @NotNull Serializer<GetParamEx2.Args> getSerializerUnderTest() {
        return GetParamEx2ArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetParamEx2.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetParamEx2.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .setParamName(PARAM_NAME)
                .build();
    }

    @NotNull
    @Override
    public GetParamEx2.Args getTargetObject() {

        return GetParamEx2.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .paramName(PARAM_NAME)
                .build();
    }
}
