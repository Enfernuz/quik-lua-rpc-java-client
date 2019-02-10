package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DelLabelJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<DelLabel.Args> {

        @Override
        public DelLabel.Args getArgsObject() {
            return new DelLabel.Args("1", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/DelLabel/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<DelLabel.Result> {

        @Override
        public String getJsonPath() {
            return "json/DelLabel/result.json";
        }

        @Override
        public DelLabel.Result getExpectedObject() {
            return DelLabel.Result.getInstance(true);
        }
    }
}
