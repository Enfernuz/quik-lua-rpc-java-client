package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CancelParamRequest;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CancelParamRequestResultPbSerdeTest {

    public static class TrueCancelParamRequestResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.CancelParamRequest.Result, CancelParamRequest.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<CancelParamRequest.Result> getDeserializerUnderTest() {
            return CancelParamRequestResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public CancelParamRequest.Result getTargetObject() {
            return new CancelParamRequest.Result(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.CancelParamRequest.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.CancelParamRequest.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseCancelParamRequestResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.CancelParamRequest.Result, CancelParamRequest.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<CancelParamRequest.Result> getDeserializerUnderTest() {
            return CancelParamRequestResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public CancelParamRequest.Result getTargetObject() {
            return new CancelParamRequest.Result(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.CancelParamRequest.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.CancelParamRequest.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
