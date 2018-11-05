package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetUpdateCallback;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DatasourceSetUpdateCallbackJsonSerdeTests {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetUpdateCallback.Args> {

        @Override
        public SetUpdateCallback.Args getArgsObject() {

            return SetUpdateCallback.Args.builder()
                    .datasourceUUID("1")
                    .fCbDef("2")
                    .watchingO(true)
                    .watchingH(true)
                    .watchingL(true)
                    .watchingC(true)
                    .watchingV(true)
                    .watchingT(true)
                    .watchingSize(true)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/datasource/SetUpdateCallback/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetUpdateCallback.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/SetUpdateCallback/true.result.json";
        }

        @Override
        public SetUpdateCallback.Result getExpectedObject() {
            return SetUpdateCallback.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetUpdateCallback.Result> {

        @Override
        public String getJsonPath() {
            return "json/datasource/SetUpdateCallback/false.result.json";
        }

        @Override
        public SetUpdateCallback.Result getExpectedObject() {
            return SetUpdateCallback.Result.getInstance(false);
        }
    }
}
