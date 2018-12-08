package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLinesCount;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetLinesCountResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetLinesCount.Result, GetLinesCount.Result> {

    private static final int LINES_COUNT = 1;

    @Override
    public @NotNull Deserializer<GetLinesCount.Result> getDeserializerUnderTest() {
        return GetLinesCountResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetLinesCount.Result getTargetObject() {
        return new GetLinesCount.Result(LINES_COUNT);
    }

    @NotNull
    @Override
    public qlua.rpc.GetLinesCount.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.GetLinesCount.Result.newBuilder()
                .setLinesCount(LINES_COUNT)
                .build();
    }
}
