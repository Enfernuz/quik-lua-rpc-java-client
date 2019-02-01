package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetEmptyCallback;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceSetEmptyCallbackResultPbSerdeTest {

    public static class TrueDatasourceSetEmptyCallbackResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.datasource.SetEmptyCallback.Result, SetEmptyCallback.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<SetEmptyCallback.Result> getDeserializerUnderTest() {
            return DsSetEmptyCallbackPbResultDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetEmptyCallback.Result getTargetObject() {
            return SetEmptyCallback.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.SetEmptyCallback.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.SetEmptyCallback.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseDatasourceSetEmptyCallbackResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.datasource.SetEmptyCallback.Result, SetEmptyCallback.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<SetEmptyCallback.Result> getDeserializerUnderTest() {
            return DsSetEmptyCallbackPbResultDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetEmptyCallback.Result getTargetObject() {
            return SetEmptyCallback.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.SetEmptyCallback.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.SetEmptyCallback.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
