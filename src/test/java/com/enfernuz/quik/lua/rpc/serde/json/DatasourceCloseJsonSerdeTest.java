package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Close;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceCloseJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Close.Args> {

        @Override
        public Close.Args getArgsObject() {
            return new Close.Args("7547b76c-c8a8-4b66-b2d5-e12b926b068d");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/Close/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Close.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/Close/true.result.json";
        }

        @Override
        public Close.Result getExpectedObject() {
            return Close.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Close.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/Close/false.result.json";
        }

        @Override
        public Close.Result getExpectedObject() {
            return Close.Result.getInstance(false);
        }
    }
}
