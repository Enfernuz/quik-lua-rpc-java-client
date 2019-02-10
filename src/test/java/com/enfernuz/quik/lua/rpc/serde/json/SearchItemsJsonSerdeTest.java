package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SearchItems;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SearchItemsJsonSerdeTest {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SearchItems.Args> {

        @Override
        public SearchItems.Args getArgsObject() {

            return SearchItems.Args.builder()
                    .tableName("1")
                    .startIndex(2)
                    .endIndex(3)
                    .fnDef("4")
                    .params("5")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SearchItems/full.args.json";
        }
    }

    public static class RpcWithoutParamsArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SearchItems.Args> {

        @Override
        public SearchItems.Args getArgsObject() {

            return SearchItems.Args.builder()
                    .tableName("1")
                    .startIndex(2)
                    .endIndex(3)
                    .fnDef("4")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SearchItems/without_params.args.json";
        }
    }

    public static class RpcWithoutEndIndexArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SearchItems.Args> {

        @Override
        public SearchItems.Args getArgsObject() {

            return SearchItems.Args.builder()
                    .tableName("1")
                    .startIndex(2)
                    .fnDef("3")
                    .params("4")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SearchItems/without_end_index.args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SearchItems.Result> {

        @Override
        public String getJsonPath() {
            return "json/SearchItems/result.json";
        }

        @Override
        public SearchItems.Result getExpectedObject() {
            return SearchItems.Result.getInstance(new int[]{1, 3, 5, 7, 9});
        }
    }

    public static class RpcNullResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SearchItems.Result> {

        @Override
        public String getJsonPath() {
            return "json/SearchItems/null.result.json";
        }

        @Override
        public SearchItems.Result getExpectedObject() {
            return SearchItems.Result.getNullInstance();
        }
    }

    public static class RpcEmptyResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SearchItems.Result> {

        @Override
        public String getJsonPath() {
            return "json/SearchItems/empty.result.json";
        }

        @Override
        public SearchItems.Result getExpectedObject() {
            return SearchItems.Result.getEmptyInstance();
        }
    }
}
