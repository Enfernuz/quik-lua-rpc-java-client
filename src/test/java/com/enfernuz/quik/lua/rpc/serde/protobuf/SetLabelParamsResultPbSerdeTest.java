package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetLabelParams;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetLabelParamsResultPbSerdeTest {

    public static class TrueSetLabelParamsResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetLabelParams.Result, SetLabelParams.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<SetLabelParams.Result> getDeserializerUnderTest() {
            return SetLabelParamsResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetLabelParams.Result getTargetObject() {
            return SetLabelParams.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetLabelParams.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetLabelParams.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseSetLabelParamsResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetLabelParams.Result, SetLabelParams.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<SetLabelParams.Result> getDeserializerUnderTest() {
            return SetLabelParamsResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetLabelParams.Result getTargetObject() {
            return SetLabelParams.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetLabelParams.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetLabelParams.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
