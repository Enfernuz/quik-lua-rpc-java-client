package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BAnd;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Enclosed.class)
public class BitBAndArgsPbSerdeTest {

    public static class FullArgsBitBAndArgsPbSerdeTest extends AbstractPbSerializationTest<BAnd.Args, qlua.rpc.bit.Band.Args> {


        private static final long X1 = 1L;
        private static final long X2 = 2L;
        private static final long[] XI = new long[] {3L, 4L, 5L};

        @Override
        public @NotNull Serializer<BAnd.Args> getSerializerUnderTest() {
            return BAndArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Band.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Band.Args.newBuilder()
                    .setX1(X1)
                    .setX2(X2)
                    .addAllXi( Arrays.asList(3L, 4L, 5L) )
                    .build();
        }

        @NotNull
        @Override
        public BAnd.Args getTargetObject() {
            return BAnd.Args.builder()
                    .x1(X1)
                    .x2(X2)
                    .xi(XI)
                    .build();
        }
    }

    public static class WithoutXiBitBAndArgsPbSerdeTest extends AbstractPbSerializationTest<BAnd.Args, qlua.rpc.bit.Band.Args> {


        private static final long X1 = 1L;
        private static final long X2 = 2L;

        @Override
        public @NotNull Serializer<BAnd.Args> getSerializerUnderTest() {
            return BAndArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Band.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Band.Args.newBuilder()
                    .setX1(X1)
                    .setX2(X2)
                    .build();
        }

        @NotNull
        @Override
        public BAnd.Args getTargetObject() {
            return BAnd.Args.builder()
                    .x1(X1)
                    .x2(X2)
                    .build();
        }
    }
}
