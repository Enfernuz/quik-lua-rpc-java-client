package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.DestroyTable;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DestroyTableJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<DestroyTable.Args> {

        @Override
        public DestroyTable.Args getArgsObject() {
            return new DestroyTable.Args(1);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/DestroyTable/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<DestroyTable.Result> {

        @Override
        public String getJsonPath() {
            return "json/DestroyTable/result.json";
        }

        @Override
        public DestroyTable.Result getExpectedObject() {
            return DestroyTable.Result.getInstance(true);
        }
    }
}
