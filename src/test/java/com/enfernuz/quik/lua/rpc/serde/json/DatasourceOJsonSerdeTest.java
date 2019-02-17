package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.O;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceOJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<O.Args> {

        @Override
        public O.Args getArgsObject() {
            return new O.Args("e6dee73b-fe1f-4d98-9d46-0d13697105c3", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/O/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<O.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/O/result.json";
        }

        @Override
        public O.Result getExpectedObject() {
            return new O.Result("6.022e23");
        }
    }
}
