package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetTableSizeRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetTableSize.Request> {

    private static final int T_ID = 1;

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_TABLE_SIZE;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetTableSize.Request.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @Override
    public @NotNull Class<GetTableSize.Request> getTargetObjectClass() {
        return GetTableSize.Request.class;
    }

    @NotNull
    @Override
    public GetTableSize.Request getTargetObject() {
        return new GetTableSize.Request(T_ID);
    }
}
