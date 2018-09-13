package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import org.jetbrains.annotations.NotNull;

public class GetNumCandlesResultPbSerdeTest extends AbstractResultPbSerdeTest<GetNumCandles.Result, qlua.rpc.GetNumCandles.Result> {

    private static final int NUM_CANDLES = 1;

    @Override
    public @NotNull Class<GetNumCandles.Result> getTargetObjectClass() {
        return GetNumCandles.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.GetNumCandles.Result getTargetObjectAsPbMessage() {
        return qlua.rpc.GetNumCandles.Result.newBuilder()
                .setNumCandles(NUM_CANDLES)
                .build();
    }

    @NotNull
    @Override
    public GetNumCandles.Result getTargetObject() {
        return new GetNumCandles.Result(NUM_CANDLES);
    }
}
