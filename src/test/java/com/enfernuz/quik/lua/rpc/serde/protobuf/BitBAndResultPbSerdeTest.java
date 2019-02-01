package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BAnd;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class BitBAndResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.bit.Band.Result, BAnd.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Deserializer<BAnd.Result> getDeserializerUnderTest() {
        return BAndResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public BAnd.Result getTargetObject() {
        return new BAnd.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.bit.Band.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.bit.Band.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
