package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx2;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetParamEx2RequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetParamEx2.Request> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";
    private static final String PARAM_NAME = "3";

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_PARAM_EX_2;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetParamEx2.Request.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .setParamName(PARAM_NAME)
                .build();
    }

    @Override
    public @NotNull Class<GetParamEx2.Request> getTargetObjectClass() {
        return GetParamEx2.Request.class;
    }

    @NotNull
    @Override
    public GetParamEx2.Request getTargetObject() {
        return GetParamEx2.Request.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .paramName(PARAM_NAME)
                .build();
    }
}
