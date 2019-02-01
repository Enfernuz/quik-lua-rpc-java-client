package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetTableNotificationCallback;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetTableNotificationCallbackResultPbSerdeTest {

    private static final int OK = 1;
    private static final int NOT_OK = 0;

    // sanity check
    static {
        assert NOT_OK != OK;
    }

    public static class OkSetTableNotificationCallbackResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.SetTableNotificationCallback.Result, SetTableNotificationCallback.Result> {

        @Override
        public @NotNull Deserializer<SetTableNotificationCallback.Result> getDeserializerUnderTest() {
            return SetTableNotificationCallbackResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetTableNotificationCallback.Result getTargetObject() {
            return SetTableNotificationCallback.Result.getOkInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.SetTableNotificationCallback.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetTableNotificationCallback.Result.newBuilder()
                    .setResult(OK)
                    .build();
        }
    }

    public static class NotOkSetTableNotificationCallbackResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.SetTableNotificationCallback.Result, SetTableNotificationCallback.Result> {

        @Override
        public @NotNull Deserializer<SetTableNotificationCallback.Result> getDeserializerUnderTest() {
            return SetTableNotificationCallbackResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetTableNotificationCallback.Result getTargetObject() {
            return SetTableNotificationCallback.Result.getErrorInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.SetTableNotificationCallback.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetTableNotificationCallback.Result.newBuilder()
                    .setResult(NOT_OK)
                    .build();
        }
    }
}
