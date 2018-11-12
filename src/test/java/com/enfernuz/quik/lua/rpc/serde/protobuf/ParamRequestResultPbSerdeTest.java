package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.ParamRequest;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ParamRequestResultPbSerdeTest {

    public static class TrueParamRequestResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.ParamRequest.Result, ParamRequest.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<ParamRequest.Result> getDeserializerUnderTest() {
            return ParamRequestResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public ParamRequest.Result getTargetObject() {
            return ParamRequest.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.ParamRequest.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.ParamRequest.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseParamRequestResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.ParamRequest.Result, ParamRequest.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<ParamRequest.Result> getDeserializerUnderTest() {
            return ParamRequestResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public ParamRequest.Result getTargetObject() {
            return ParamRequest.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.ParamRequest.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.ParamRequest.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
