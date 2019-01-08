package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.RGB;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class RGBResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.RGB.Result, RGB.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Deserializer<RGB.Result> getDeserializerUnderTest() {
        return RGBResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public RGB.Result getTargetObject() {
        return new RGB.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.RGB.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.RGB.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
