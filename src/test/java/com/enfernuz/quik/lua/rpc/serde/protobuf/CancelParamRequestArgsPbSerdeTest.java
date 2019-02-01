package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CancelParamRequest;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class CancelParamRequestArgsPbSerdeTest extends AbstractPbSerializationTest<CancelParamRequest.Args, qlua.rpc.CancelParamRequest.Args> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";
    private static final String DB_NAME = "3";

    @Override
    public @NotNull Serializer<CancelParamRequest.Args> getSerializerUnderTest() {
        return CancelParamRequestArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.CancelParamRequest.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.CancelParamRequest.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .setDbName(DB_NAME)
                .build();
    }

    @NotNull
    @Override
    public CancelParamRequest.Args getTargetObject() {

        return CancelParamRequest.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .dbName(DB_NAME)
                .build();
    }
}
