package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetItem;
import com.google.common.collect.ImmutableMap;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Map;

@RunWith(Enclosed.class)
public class GetItemJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetItem.Args> {

        @Override
        public GetItem.Args getArgsObject() {
            return new GetItem.Args("1", 2);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getItem/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetItem.Result> {

        @Override
        public String getJsonPath() {
            return "json/getItem/result.json";
        }

        @Override
        public GetItem.Result getExpectedObject() {

            final Map<String, String> tableRow = ImmutableMap.of(
                    "field_1", "value_1",
                    "field_2", "value_2",
                    "field_3", "value_3",
                    "field_...", "value_...",
                    "field_n", "value_n"

            );

            return GetItem.Result.getInstance(tableRow);
        }
    }
}
