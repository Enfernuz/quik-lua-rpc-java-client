package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.ParamRequest;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class ParamRequestRequestPbSerdeTest extends AbstractRequestPbSerdeTest<ParamRequest.Request> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";
    private static final String DB_NAME = "3";

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.PARAM_REQUEST;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {

        return qlua.rpc.ParamRequest.Request.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .setDbName(DB_NAME)
                .build();
    }

    @Override
    public @NotNull Class<ParamRequest.Request> getTargetObjectClass() {
        return ParamRequest.Request.class;
    }

    @NotNull
    @Override
    public ParamRequest.Request getTargetObject() {

        return ParamRequest.Request.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .dbName(DB_NAME)
                .build();
    }
}
