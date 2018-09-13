package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class GetNumCandlesRequestPbSerdeTest extends AbstractRequestPbSerdeTest<GetNumCandles.Request> {

    private static final String TAG = "1";

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.GET_NUM_CANDLES;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.GetNumCandles.Request.newBuilder()
                .setTag(TAG)
                .build();
    }

    @Override
    public @NotNull Class<GetNumCandles.Request> getTargetObjectClass() {
        return GetNumCandles.Request.class;
    }

    @NotNull
    @Override
    public GetNumCandles.Request getTargetObject() {
        return new GetNumCandles.Request(TAG);
    }
}
