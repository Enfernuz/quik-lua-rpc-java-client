package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.H;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceHJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<H.Args> {

        @Override
        public H.Args getArgsObject() {
            return new H.Args("6a2f41a3-c54c-fce8-32d2-0324e1c32e22", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/H/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<H.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/H/result.json";
        }

        @Override
        public H.Result getExpectedObject() {
            return new H.Result("0.321");
        }
    }
}
