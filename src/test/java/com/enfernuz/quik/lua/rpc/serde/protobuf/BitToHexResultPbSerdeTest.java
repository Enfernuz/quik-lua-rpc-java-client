package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.ToHex;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class BitToHexResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.bit.Tohex.Result, ToHex.Result> {

    private static final String RESULT = "1";

    @Override
    public @NotNull Deserializer<ToHex.Result> getDeserializerUnderTest() {
        return BitToHexResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public ToHex.Result getTargetObject() {
        return new ToHex.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.bit.Tohex.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.bit.Tohex.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
