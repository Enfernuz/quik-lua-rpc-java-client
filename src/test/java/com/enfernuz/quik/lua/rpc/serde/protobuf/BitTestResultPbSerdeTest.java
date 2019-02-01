package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.Test;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BitTestResultPbSerdeTest {

    public static class TrueBitTestResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.bit.Btest.Result, Test.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<Test.Result> getDeserializerUnderTest() {
            return BitTestResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Test.Result getTargetObject() {
            return Test.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Btest.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Btest.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseBitTestResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.bit.Btest.Result, Test.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<Test.Result> getDeserializerUnderTest() {
            return BitTestResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Test.Result getTargetObject() {
            return Test.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.bit.Btest.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.bit.Btest.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
