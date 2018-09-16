package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsConnected;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class IsConnectedRequestPbSerdeTest extends AbstractRequestPbSerdeTest<IsConnected.Request> {

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.IS_CONNECTED;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return null;
    }

    @Override
    public @NotNull Class<IsConnected.Request> getTargetObjectClass() {
        return IsConnected.Request.class;
    }

    @NotNull
    @Override
    public IsConnected.Request getTargetObject() {
        return IsConnected.Request.INSTANCE;
    }
}
