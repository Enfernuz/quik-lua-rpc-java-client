package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DelLabelResultPbSerdeTest {

    public static class TrueDelLabelResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.DelLabel.Result, DelLabel.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<DelLabel.Result> getDeserializerUnderTest() {
            return DelLabelResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public DelLabel.Result getTargetObject() {
            return DelLabel.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.DelLabel.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.DelLabel.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseDelLabelResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.DelLabel.Result, DelLabel.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<DelLabel.Result> getDeserializerUnderTest() {
            return DelLabelResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public DelLabel.Result getTargetObject() {
            return DelLabel.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.DelLabel.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.DelLabel.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
