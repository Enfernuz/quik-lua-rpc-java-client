package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetColor;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetColorResultPbSerdeTest {

    public static class TrueSetColorResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetColor.Result, SetColor.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<SetColor.Result> getDeserializerUnderTest() {
            return SetColorResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetColor.Result getTargetObject() {
            return SetColor.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetColor.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetColor.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseSetColorResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetColor.Result, SetColor.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<SetColor.Result> getDeserializerUnderTest() {
            return SetColorResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetColor.Result getTargetObject() {
            return SetColor.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetColor.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetColor.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
