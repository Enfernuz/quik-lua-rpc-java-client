package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLinesCount;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetLinesCountArgsPbSerdeTest extends AbstractPbSerializationTest<GetLinesCount.Args, qlua.rpc.GetLinesCount.Args> {

    private static final String TAG = "1";

    @Override
    public @NotNull Serializer<GetLinesCount.Args> getSerializerUnderTest() {
        return GetLinesCountArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetLinesCount.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetLinesCount.Args.newBuilder()
                .setTag(TAG)
                .build();
    }

    @NotNull
    @Override
    public GetLinesCount.Args getTargetObject() {
        return new GetLinesCount.Args(TAG);
    }
}
