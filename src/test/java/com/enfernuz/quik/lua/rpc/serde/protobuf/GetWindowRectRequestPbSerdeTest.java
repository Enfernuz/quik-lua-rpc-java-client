package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetWindowRectRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetWindowRect.Request> {

    private static final int T_ID = 1;

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_WINDOW_RECT;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetWindowRect.Request.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @Override
    public @NotNull Class<GetWindowRect.Request> getTargetObjectClass() {
        return GetWindowRect.Request.class;
    }

    @NotNull
    @Override
    public GetWindowRect.Request getTargetObject() {
        return new GetWindowRect.Request(T_ID);
    }
}
