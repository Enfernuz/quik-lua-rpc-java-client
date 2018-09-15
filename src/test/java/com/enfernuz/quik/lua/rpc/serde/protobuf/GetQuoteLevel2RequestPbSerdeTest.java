package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetQuoteLevel2RequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetQuoteLevel2.Request> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_QUOTE_LEVEL2;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetQuoteLevel2.Request.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .build();
    }

    @Override
    public @NotNull Class<GetQuoteLevel2.Request> getTargetObjectClass() {
        return GetQuoteLevel2.Request.class;
    }

    @NotNull
    @Override
    public GetQuoteLevel2.Request getTargetObject() {
        return GetQuoteLevel2.Request.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .build();
    }
}
