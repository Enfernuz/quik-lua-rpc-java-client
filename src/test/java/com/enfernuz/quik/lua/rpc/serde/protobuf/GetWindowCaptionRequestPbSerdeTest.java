package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetWindowCaptionRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetWindowCaption.Request> {

    private static final int T_ID = 1;

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_WINDOW_CAPTION;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetWindowCaption.Request.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @Override
    public @NotNull Class<GetWindowCaption.Request> getTargetObjectClass() {
        return GetWindowCaption.Request.class;
    }

    @NotNull
    @Override
    public GetWindowCaption.Request getTargetObject() {
        return new GetWindowCaption.Request(T_ID);
    }
}
