package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetSecurityInfo;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetSecurityInfoRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetSecurityInfo.Request> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_SECURITY_INFO;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetSecurityInfo.Request.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .build();
    }

    @Override
    public @NotNull Class<GetSecurityInfo.Request> getTargetObjectClass() {
        return GetSecurityInfo.Request.class;
    }

    @NotNull
    @Override
    public GetSecurityInfo.Request getTargetObject() {
        return GetSecurityInfo.Request.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .build();
    }
}
