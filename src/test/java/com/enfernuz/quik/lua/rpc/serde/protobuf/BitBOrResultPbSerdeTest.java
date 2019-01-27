package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BOr;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class BitBOrResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.bit.Bor.Result, BOr.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Deserializer<BOr.Result> getDeserializerUnderTest() {
        return BOrResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public BOr.Result getTargetObject() {
        return new BOr.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.bit.Bor.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.bit.Bor.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
