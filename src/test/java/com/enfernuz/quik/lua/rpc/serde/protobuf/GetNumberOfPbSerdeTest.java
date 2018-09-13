package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetNumberOfPbSerdeTest extends AbstractRequestPbSerdeTest<GetNumberOf.Request> {

    private static final String TABLE_NAME = "1";

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_NUMBER_OF;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetNumberOf.Request.newBuilder()
                .setTableName(TABLE_NAME)
                .build();
    }

    @Override
    public @NotNull Class<GetNumberOf.Request> getTargetObjectClass() {
        return GetNumberOf.Request.class;
    }

    @NotNull
    @Override
    public GetNumberOf.Request getTargetObject() {
        return new GetNumberOf.Request(TABLE_NAME);
    }
}
