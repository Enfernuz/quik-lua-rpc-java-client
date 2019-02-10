package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SetLabelParams;
import com.google.common.collect.ImmutableMap;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(Enclosed.class)
public class SetLabelParamsJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetLabelParams.Args> {

        @Override
        public SetLabelParams.Args getArgsObject() {

            final Map<String, String> labelParams = ImmutableMap.of(
                    "key_1", "value_1",
                    "key_2", "value_2",
                    "key_3", "value_3"
            );

            return new SetLabelParams.Args("1",2, labelParams);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetLabelParams/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetLabelParams.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetLabelParams/true.result.json";
        }

        @Override
        public SetLabelParams.Result getExpectedObject() {
            return SetLabelParams.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetLabelParams.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetLabelParams/false.result.json";
        }

        @Override
        public SetLabelParams.Result getExpectedObject() {
            return SetLabelParams.Result.getInstance(false);
        }
    }
}
