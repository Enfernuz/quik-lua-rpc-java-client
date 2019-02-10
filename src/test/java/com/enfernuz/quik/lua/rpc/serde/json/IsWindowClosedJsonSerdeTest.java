package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class IsWindowClosedJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<IsWindowClosed.Args> {

        @Override
        public IsWindowClosed.Args getArgsObject() {
            return new IsWindowClosed.Args(1);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/IsWindowClosed/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<IsWindowClosed.Result> {

        @Override
        public String getJsonPath() {
            return "json/IsWindowClosed/true.result.json";
        }

        @Override
        public IsWindowClosed.Result getExpectedObject() {
            return IsWindowClosed.Result.getInstance(Boolean.TRUE);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<IsWindowClosed.Result> {

        @Override
        public String getJsonPath() {
            return "json/IsWindowClosed/false.result.json";
        }

        @Override
        public IsWindowClosed.Result getExpectedObject() {
            return IsWindowClosed.Result.getInstance(Boolean.FALSE);
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<IsWindowClosed.Result> {

        @Override
        public String getJsonPath() {
            return "json/IsWindowClosed/error.result.json";
        }

        @Override
        public IsWindowClosed.Result getExpectedObject() {
            return IsWindowClosed.Result.getErrorInstance();
        }
    }
}
