package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BNot;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class BitBNotResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.bit.Bnot.Result, BNot.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Deserializer<BNot.Result> getDeserializerUnderTest() {
        return BNotResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public BNot.Result getTargetObject() {
        return new BNot.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.bit.Bnot.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.bit.Bnot.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
