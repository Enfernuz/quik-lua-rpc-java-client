package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTradeDate;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetTradeDateRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetTradeDate.Request> {

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_TRADE_DATE;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return null;
    }

    @Override
    public @NotNull Class<GetTradeDate.Request> getTargetObjectClass() {
        return GetTradeDate.Request.class;
    }

    @NotNull
    @Override
    public GetTradeDate.Request getTargetObject() {
        return GetTradeDate.Request.INSTANCE;
    }
}
