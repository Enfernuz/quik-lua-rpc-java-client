package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetNumCandlesResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetNumCandles.Result, GetNumCandles.Result> {

    private static final int NUM_CANDLES = 1;

    @Override
    public @NotNull Deserializer<GetNumCandles.Result> getDeserializerUnderTest() {
        return GetNumCandlesResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetNumCandles.Result getTargetObject() {
        return new GetNumCandles.Result(NUM_CANDLES);
    }

    @NotNull
    @Override
    public qlua.rpc.GetNumCandles.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.GetNumCandles.Result.newBuilder()
                .setNumCandles(NUM_CANDLES)
                .build();
    }
}
