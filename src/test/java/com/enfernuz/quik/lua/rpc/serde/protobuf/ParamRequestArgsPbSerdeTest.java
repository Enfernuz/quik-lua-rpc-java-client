package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.ParamRequest;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class ParamRequestArgsPbSerdeTest extends AbstractPbSerializationTest<ParamRequest.Args, qlua.rpc.ParamRequest.Args> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";
    private static final String DB_NAME = "3";

    @Override
    public @NotNull Serializer<ParamRequest.Args> getSerializerUnderTest() {
        return ParamRequestArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.ParamRequest.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.ParamRequest.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .setDbName(DB_NAME)
                .build();
    }

    @NotNull
    @Override
    public ParamRequest.Args getTargetObject() {

        return ParamRequest.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .dbName(DB_NAME)
                .build();
    }
}
