package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.V;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceVJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<V.Args> {

        @Override
        public V.Args getArgsObject() {
            return new V.Args("b5f2e439-0b43-4ed0-923f-2b7a3820a158", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/V/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<V.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/V/result.json";
        }

        @Override
        public V.Result getExpectedObject() {
            return new V.Result("9.8e-4");
        }
    }
}
