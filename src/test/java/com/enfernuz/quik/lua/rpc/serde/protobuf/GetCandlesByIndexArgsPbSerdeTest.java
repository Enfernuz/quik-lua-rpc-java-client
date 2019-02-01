package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetCandlesByIndexArgsPbSerdeTest extends AbstractPbSerializationTest<GetCandlesByIndex.Args, qlua.rpc.GetCandlesByIndex.Args> {

    private static final String TAG = "1";
    private static final int LINE = 2;
    private static final int FIRST_CANDLE = 3;
    private static final int COUNT = 4;

    @Override
    public @NotNull Serializer<GetCandlesByIndex.Args> getSerializerUnderTest() {
        return GetCandlesByIndexArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetCandlesByIndex.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetCandlesByIndex.Args.newBuilder()
                .setTag(TAG)
                .setLine(LINE)
                .setFirstCandle(FIRST_CANDLE)
                .setCount(COUNT)
                .build();
    }

    @NotNull
    @Override
    public GetCandlesByIndex.Args getTargetObject() {

        return GetCandlesByIndex.Args.builder()
                .tag(TAG)
                .line(LINE)
                .firstCandle(FIRST_CANDLE)
                .count(COUNT)
                .build();
    }
}
