package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SetTableNotificationCallback;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetTableNotificationCallbackJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetTableNotificationCallback.Args> {

        @Override
        public SetTableNotificationCallback.Args getArgsObject() {
            return new SetTableNotificationCallback.Args(1, "2");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetTableNotificationCallback/args.json";
        }
    }

    public static class RpcOkResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetTableNotificationCallback.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetTableNotificationCallback/ok.result.json";
        }

        @Override
        public SetTableNotificationCallback.Result getExpectedObject() {
            return SetTableNotificationCallback.Result.getOkInstance();
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetTableNotificationCallback.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetTableNotificationCallback/error.result.json";
        }

        @Override
        public SetTableNotificationCallback.Result getExpectedObject() {
            return SetTableNotificationCallback.Result.getErrorInstance();
        }
    }

    public static class RpcOtherResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetTableNotificationCallback.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetTableNotificationCallback/other.result.json";
        }

        @Override
        public SetTableNotificationCallback.Result getExpectedObject() {
            return SetTableNotificationCallback.Result.getInstance(345);
        }
    }
}
