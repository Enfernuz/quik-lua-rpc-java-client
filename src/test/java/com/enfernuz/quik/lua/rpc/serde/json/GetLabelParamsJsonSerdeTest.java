package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetLabelParams;
import com.google.common.collect.ImmutableMap;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(Enclosed.class)
public class GetLabelParamsJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetLabelParams.Args> {

        @Override
        public GetLabelParams.Args getArgsObject() {
            return new GetLabelParams.Args("1", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getLabelParams/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetLabelParams.Result> {

        @Override
        public String getJsonPath() {
            return "json/getLabelParams/result.json";
        }

        @Override
        public GetLabelParams.Result getExpectedObject() {

            final Map<String, String> labelParams = ImmutableMap.of(
                    "param_1", "value_1",
                    "param_2", "value_2",
                    "param_3", "value_3",
                    "param_...", "value_...",
                    "param_n", "value_n"

            );

            return GetLabelParams.Result.getInstance(labelParams);
        }
    }
}
