package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Close;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceCloseResultPbSerdeTest {

    public static class TrueDatasourceCloseResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.datasource.Close.Result, Close.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<Close.Result> getDeserializerUnderTest() {
            return DsClosePbResultDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Close.Result getTargetObject() {
            return Close.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.Close.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.Close.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseDatasourceCloseResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.datasource.Close.Result, Close.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<Close.Result> getDeserializerUnderTest() {
            return DsClosePbResultDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Close.Result getTargetObject() {
            return Close.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.datasource.Close.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.datasource.Close.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
