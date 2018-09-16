package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class IsWindowClosedRequestPbSerdeTest extends AbstractRequestPbSerdeTest<IsWindowClosed.Request> {

    private static final int T_ID = 1;

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.IS_WINDOW_CLOSED;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.IsWindowClosed.Request.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @Override
    public @NotNull Class<IsWindowClosed.Request> getTargetObjectClass() {
        return IsWindowClosed.Request.class;
    }

    @NotNull
    @Override
    public IsWindowClosed.Request getTargetObject() {
        return new IsWindowClosed.Request(T_ID);
    }
}
