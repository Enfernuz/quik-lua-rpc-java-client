package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelAllLabels;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DelAllLabelsResultPbSerdeTest  {

    public static class TrueDelAllLabelsResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.DelAllLabels.Result, DelAllLabels.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<DelAllLabels.Result> getDeserializerUnderTest() {
            return DelAllLabelsResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public DelAllLabels.Result getTargetObject() {
            return DelAllLabels.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.DelAllLabels.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.DelAllLabels.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseDelAllLabelsResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.DelAllLabels.Result, DelAllLabels.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<DelAllLabels.Result> getDeserializerUnderTest() {
            return DelAllLabelsResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public DelAllLabels.Result getTargetObject() {
            return DelAllLabels.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.DelAllLabels.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.DelAllLabels.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
