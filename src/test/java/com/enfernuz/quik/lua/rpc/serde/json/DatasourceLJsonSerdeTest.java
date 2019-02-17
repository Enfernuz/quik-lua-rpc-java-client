package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.L;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceLJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<L.Args> {

        @Override
        public L.Args getArgsObject() {
            return new L.Args("e7bf6bae-9f16-4d87-aec3-a02ca994c35f", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/L/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<L.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/L/result.json";
        }

        @Override
        public L.Result getExpectedObject() {
            return new L.Result("123.456789");
        }
    }
}
