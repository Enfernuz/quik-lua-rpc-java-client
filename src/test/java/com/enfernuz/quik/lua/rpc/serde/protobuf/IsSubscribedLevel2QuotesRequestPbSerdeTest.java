package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsSubscribedLevel2Quotes;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class IsSubscribedLevel2QuotesRequestPbSerdeTest extends AbstractRequestPbSerdeTest<IsSubscribedLevel2Quotes.Request> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.IS_SUBSCRIBED_LEVEL_II_QUOTES;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.IsSubscribedLevelIIQuotes.Request.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .build();
    }

    @Override
    public @NotNull Class<IsSubscribedLevel2Quotes.Request> getTargetObjectClass() {
        return IsSubscribedLevel2Quotes.Request.class;
    }

    @NotNull
    @Override
    public IsSubscribedLevel2Quotes.Request getTargetObject() {
        return IsSubscribedLevel2Quotes.Request.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .build();
    }
}
