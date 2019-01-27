package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BNot;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class BitBNotArgsPbSerdeTest extends AbstractPbSerializationTest<BNot.Args, qlua.rpc.bit.Bnot.Request> {

    private static final int X = 1;

    @Override
    public @NotNull Serializer<BNot.Args> getSerializerUnderTest() {
        return BNotArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.bit.Bnot.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.bit.Bnot.Request.newBuilder()
                .setX(X)
                .build();
    }

    @NotNull
    @Override
    public BNot.Args getTargetObject() {
        return new BNot.Args(X);
    }
}
