package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BXor;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class BitBXorArgsPbSerdeTest {

    public static class FullArgsBitBXorArgsPbSerdeTest extends AbstractPbSerializationTest<BXor.Args, qlua.rpc.bit.Bxor.Request> {


        private static final int X1 = 1;
        private static final int X2 = 2;
        private static final int[] XI = new int[] {3, 4, 5};

        @Override
        public @NotNull Serializer<BXor.Args> getSerializerUnderTest() {
            return BXorArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Bxor.Request getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Bxor.Request.newBuilder()
                    .setX1(X1)
                    .setX2(X2)
                    .addAllXi( Arrays.asList(3, 4, 5) )
                    .build();
        }

        @NotNull
        @Override
        public BXor.Args getTargetObject() {
            return BXor.Args.builder()
                    .x1(X1)
                    .x2(X2)
                    .xi(XI)
                    .build();
        }
    }

    public static class WithoutXiBitBXorArgsPbSerdeTest extends AbstractPbSerializationTest<BXor.Args, qlua.rpc.bit.Bxor.Request> {


        private static final int X1 = 1;
        private static final int X2 = 2;

        @Override
        public @NotNull Serializer<BXor.Args> getSerializerUnderTest() {
            return BXorArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Bxor.Request getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Bxor.Request.newBuilder()
                    .setX1(X1)
                    .setX2(X2)
                    .build();
        }

        @NotNull
        @Override
        public BXor.Args getTargetObject() {
            return BXor.Args.builder()
                    .x1(X1)
                    .x2(X2)
                    .build();
        }
    }
}
