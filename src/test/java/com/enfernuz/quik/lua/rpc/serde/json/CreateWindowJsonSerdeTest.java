package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.CreateWindow;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CreateWindowJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<CreateWindow.Args> {

        @Override
        public CreateWindow.Args getArgsObject() {
            return new CreateWindow.Args(1);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/CreateWindow/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<CreateWindow.Result> {

        @Override
        public String getJsonPath() {
            return "json/CreateWindow/result.json";
        }

        @Override
        public CreateWindow.Result getExpectedObject() {
            return new CreateWindow.Result(1);
        }
    }
}
