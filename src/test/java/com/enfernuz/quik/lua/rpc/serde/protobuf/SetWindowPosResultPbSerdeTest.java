package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowPos;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetWindowPosResultPbSerdeTest {

    public static class TrueSetWindowPosResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetWindowPos.Result, SetWindowPos.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<SetWindowPos.Result> getDeserializerUnderTest() {
            return SetWindowPosResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetWindowPos.Result getTargetObject() {
            return SetWindowPos.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetWindowPos.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetWindowPos.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseSetWindowPosResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetWindowPos.Result, SetWindowPos.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<SetWindowPos.Result> getDeserializerUnderTest() {
            return SetWindowPosResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetWindowPos.Result getTargetObject() {
            return SetWindowPos.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetWindowPos.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetWindowPos.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
