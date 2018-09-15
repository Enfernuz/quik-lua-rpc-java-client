package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWorkingFolder;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetWorkingFolderRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetWorkingFolder.Request> {

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_WORKING_FOLDER;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return null;
    }

    @Override
    public @NotNull Class<GetWorkingFolder.Request> getTargetObjectClass() {
        return GetWorkingFolder.Request.class;
    }

    @NotNull
    @Override
    public GetWorkingFolder.Request getTargetObject() {
        return GetWorkingFolder.Request.INSTANCE;
    }
}
