package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetScriptPath;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetScriptPathRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetScriptPath.Request> {

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_SCRIPT_PATH;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return null;
    }

    @Override
    public @NotNull Class<GetScriptPath.Request> getTargetObjectClass() {
        return GetScriptPath.Request.class;
    }

    @NotNull
    @Override
    public GetScriptPath.Request getTargetObject() {
        return GetScriptPath.Request.INSTANCE;
    }
}
