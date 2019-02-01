package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.Test;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class BitTestArgsPbSerdeTest extends AbstractPbSerializationTest<Test.Args, qlua.rpc.bit.Btest.Args> {

    private static final int X = 1;
    private static final int N = 2;

    @Override
    public @NotNull Serializer<Test.Args> getSerializerUnderTest() {
        return BitTestArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.bit.Btest.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.bit.Btest.Args.newBuilder()
                .setX(X)
                .setN(N)
                .build();
    }

    @NotNull
    @Override
    public Test.Args getTargetObject() {

        return Test.Args.builder()
                .x(X)
                .n(N)
                .build();
    }
}
