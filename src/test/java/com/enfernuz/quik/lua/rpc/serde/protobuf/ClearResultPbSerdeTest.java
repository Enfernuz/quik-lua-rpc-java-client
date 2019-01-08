package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Clear;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ClearResultPbSerdeTest {

    public static class TrueClearResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.Clear.Result, Clear.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<Clear.Result> getDeserializerUnderTest() {
            return ClearResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Clear.Result getTargetObject() {
            return Clear.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.Clear.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.Clear.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseClearResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.Clear.Result, Clear.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<Clear.Result> getDeserializerUnderTest() {
            return ClearResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Clear.Result getTargetObject() {
            return Clear.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.Clear.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.Clear.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
