package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.ToHex;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BitToHexArgsPbSerdeTest {

    public static class FullArgsBitToHexArgsPbSerdeTest extends AbstractPbSerializationTest<ToHex.Args, qlua.rpc.bit.Tohex.Args> {

        private static final int X = 1;
        private static final int N = 2;

        @Override
        public @NotNull Serializer<ToHex.Args> getSerializerUnderTest() {
            return BitToHexArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Tohex.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Tohex.Args.newBuilder()
                    .setX(X)
                    .setValueN(N)
                    .build();
        }

        @NotNull
        @Override
        public ToHex.Args getTargetObject() {
            return ToHex.Args.builder()
                    .x(X)
                    .n(N)
                    .build();
        }
    }

    public static class WithoutNBitToHexArgsPbSerdeTest extends AbstractPbSerializationTest<ToHex.Args, qlua.rpc.bit.Tohex.Args> {

        private static final int X = 1;

        @Override
        public @NotNull Serializer<ToHex.Args> getSerializerUnderTest() {
            return BitToHexArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Tohex.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Tohex.Args.newBuilder()
                    .setX(X)
                    .setNullN(true)
                    .build();
        }

        @NotNull
        @Override
        public ToHex.Args getTargetObject() {

            return ToHex.Args.builder()
                    .x(X)
                    .build();
        }
    }
}
