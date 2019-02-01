package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BXor;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class BitBXorResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.bit.Bxor.Result, BXor.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Deserializer<BXor.Result> getDeserializerUnderTest() {
        return BXorResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public BXor.Result getTargetObject() {
        return new BXor.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.bit.Bxor.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.bit.Bxor.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
