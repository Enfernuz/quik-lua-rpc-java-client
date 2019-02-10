package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.DelAllLabels;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DelAllLabelsJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<DelAllLabels.Args> {

        @Override
        public DelAllLabels.Args getArgsObject() {
            return new DelAllLabels.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/DelAllLabels/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<DelAllLabels.Result> {

        @Override
        public String getJsonPath() {
            return "json/DelAllLabels/result.json";
        }

        @Override
        public DelAllLabels.Result getExpectedObject() {
            return DelAllLabels.Result.getInstance(true);
        }
    }
}
