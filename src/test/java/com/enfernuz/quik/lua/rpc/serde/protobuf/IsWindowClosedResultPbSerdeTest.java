package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class IsWindowClosedResultPbSerdeTest {

    public static class TrueIsWindowClosedResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.IsWindowClosed.Result, IsWindowClosed.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<IsWindowClosed.Result> getDeserializerUnderTest() {
            return IsWindowClosedResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public IsWindowClosed.Result getTargetObject() {
            return IsWindowClosed.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.IsWindowClosed.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.IsWindowClosed.Result.newBuilder()
                    .setValueWindowClosed(TRUE)
                    .build();
        }
    }

    public static class FalseIsWindowClosedResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.IsWindowClosed.Result, IsWindowClosed.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<IsWindowClosed.Result> getDeserializerUnderTest() {
            return IsWindowClosedResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public IsWindowClosed.Result getTargetObject() {
            return IsWindowClosed.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.IsWindowClosed.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.IsWindowClosed.Result.newBuilder()
                    .setValueWindowClosed(FALSE)
                    .build();
        }
    }

    public static class ErrorIsWindowClosedResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.IsWindowClosed.Result, IsWindowClosed.Result> {

        @Override
        public @NotNull Deserializer<IsWindowClosed.Result> getDeserializerUnderTest() {
            return IsWindowClosedResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public IsWindowClosed.Result getTargetObject() {
            return IsWindowClosed.Result.getErrorInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.IsWindowClosed.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.IsWindowClosed.Result.newBuilder()
                    .setNullWindowClosed(true)
                    .build();
        }
    }
}
