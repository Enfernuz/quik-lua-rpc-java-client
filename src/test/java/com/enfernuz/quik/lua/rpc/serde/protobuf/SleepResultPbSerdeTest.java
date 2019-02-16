package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Sleep;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SleepResultPbSerdeTest {

    private static final Long OK = 12345L;
    private static final Long NOT_OK = null;

    // sanity check
    static {
        assert OK != NOT_OK;
    }

    public static class OkSleepResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.Sleep.Result, Sleep.Result> {

        @Override
        public @NotNull Deserializer<Sleep.Result> getDeserializerUnderTest() {
            return SleepResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Sleep.Result getTargetObject() {
            return Sleep.Result.getInstance(OK);
        }

        @NotNull
        @Override
        public qlua.rpc.Sleep.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.Sleep.Result.newBuilder()
                    .setValueResult(OK)
                    .build();
        }
    }

    public static class ErrorSleepResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.Sleep.Result, Sleep.Result> {

        @Override
        public @NotNull Deserializer<Sleep.Result> getDeserializerUnderTest() {
            return SleepResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Sleep.Result getTargetObject() {
            return Sleep.Result.getErrorInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.Sleep.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.Sleep.Result.newBuilder()
                    .setNullResult(true)
                    .build();
        }
    }
}
