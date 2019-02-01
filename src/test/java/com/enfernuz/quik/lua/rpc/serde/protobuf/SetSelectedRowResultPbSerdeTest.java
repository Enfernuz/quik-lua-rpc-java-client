package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetSelectedRow;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetSelectedRowResultPbSerdeTest {

    private static final int SOMETHING_THAT_OK = 42;
    private static final int NOT_OK = -1;

    // sanity check
    static {
        assert NOT_OK != SOMETHING_THAT_OK;
    }

    public static class OkSetSelectedRowResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.SetSelectedRow.Result, SetSelectedRow.Result> {

        @Override
        public @NotNull Deserializer<SetSelectedRow.Result> getDeserializerUnderTest() {
            return SetSelectedRowResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetSelectedRow.Result getTargetObject() {
            return SetSelectedRow.Result.getInstance(SOMETHING_THAT_OK);
        }

        @NotNull
        @Override
        public qlua.rpc.SetSelectedRow.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetSelectedRow.Result.newBuilder()
                    .setResult(SOMETHING_THAT_OK)
                    .build();
        }
    }

    public static class NotOkSetSelectedRowResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.SetSelectedRow.Result, SetSelectedRow.Result> {

        @Override
        public @NotNull Deserializer<SetSelectedRow.Result> getDeserializerUnderTest() {
            return SetSelectedRowResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetSelectedRow.Result getTargetObject() {
            return SetSelectedRow.Result.getErrorInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.SetSelectedRow.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetSelectedRow.Result.newBuilder()
                    .setResult(NOT_OK)
                    .build();
        }
    }
}
