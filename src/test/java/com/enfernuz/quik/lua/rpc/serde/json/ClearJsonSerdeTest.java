package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.Clear;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ClearJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Clear.Args> {

        @Override
        public Clear.Args getArgsObject() {
            return new Clear.Args(1);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/Clear/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Clear.Result> {

        @Override
        public String getJsonPath() {
            return "json/Clear/true.result.json";
        }

        @Override
        public Clear.Result getExpectedObject() {
            return Clear.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Clear.Result> {

        @Override
        public String getJsonPath() {
            return "json/Clear/false.result.json";
        }

        @Override
        public Clear.Result getExpectedObject() {
            return Clear.Result.getInstance(false);
        }
    }
}
