package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetCell;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetCellResultPbSerdeTest {

    public static class TrueSetCellResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetCell.Result, SetCell.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<SetCell.Result> getDeserializerUnderTest() {
            return SetCellResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetCell.Result getTargetObject() {
            return SetCell.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetCell.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetCell.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseSetCellResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetCell.Result, SetCell.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<SetCell.Result> getDeserializerUnderTest() {
            return SetCellResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetCell.Result getTargetObject() {
            return SetCell.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetCell.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetCell.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
