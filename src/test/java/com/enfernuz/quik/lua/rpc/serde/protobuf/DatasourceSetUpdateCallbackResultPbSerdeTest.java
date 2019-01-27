package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetUpdateCallback;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceSetUpdateCallbackResultPbSerdeTest {

    public static class TrueDatasourceSetUpdateCallbackResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.datasource.SetUpdateCallback.Result, SetUpdateCallback.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<SetUpdateCallback.Result> getDeserializerUnderTest() {
            return DsSetUpdateCallbackPbResultDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetUpdateCallback.Result getTargetObject() {
            return SetUpdateCallback.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.SetUpdateCallback.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.SetUpdateCallback.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseDatasourceSetUpdateCallbackResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.datasource.SetUpdateCallback.Result, SetUpdateCallback.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<SetUpdateCallback.Result> getDeserializerUnderTest() {
            return DsSetUpdateCallbackPbResultDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetUpdateCallback.Result getTargetObject() {
            return SetUpdateCallback.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.SetUpdateCallback.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.SetUpdateCallback.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
