package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Size;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceSizeJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Size.Args> {

        @Override
        public Size.Args getArgsObject() {
            return new Size.Args("92560f2b-27c0-4683-b436-deaf1a986a1d");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/Size/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Size.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/Size/result.json";
        }

        @Override
        public Size.Result getExpectedObject() {
            return new Size.Result(1);
        }
    }
}
