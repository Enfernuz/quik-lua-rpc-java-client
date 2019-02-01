package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BOr;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class BitBOrArgsPbSerdeTest {

    public static class FullArgsBitBOrArgsPbSerdeTest extends AbstractPbSerializationTest<BOr.Args, qlua.rpc.bit.Bor.Args> {


        private static final int X1 = 1;
        private static final int X2 = 2;
        private static final int[] XI = new int[] {3, 4, 5};

        @Override
        public @NotNull Serializer<BOr.Args> getSerializerUnderTest() {
            return BOrArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Bor.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Bor.Args.newBuilder()
                    .setX1(X1)
                    .setX2(X2)
                    .addAllXi( Arrays.asList(3, 4, 5) )
                    .build();
        }

        @NotNull
        @Override
        public BOr.Args getTargetObject() {
            return BOr.Args.builder()
                    .x1(X1)
                    .x2(X2)
                    .xi(XI)
                    .build();
        }
    }

    public static class WithoutXiBitBOrArgsPbSerdeTest extends AbstractPbSerializationTest<BOr.Args, qlua.rpc.bit.Bor.Args> {


        private static final int X1 = 1;
        private static final int X2 = 2;

        @Override
        public @NotNull Serializer<BOr.Args> getSerializerUnderTest() {
            return BOrArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Bor.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Bor.Args.newBuilder()
                    .setX1(X1)
                    .setX2(X2)
                    .build();
        }

        @NotNull
        @Override
        public BOr.Args getTargetObject() {
            return BOr.Args.builder()
                    .x1(X1)
                    .x2(X2)
                    .build();
        }
    }
}
