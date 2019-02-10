package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetTableSizeJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetTableSize.Args> {

        @Override
        public GetTableSize.Args getArgsObject() {
            return new GetTableSize.Args(1);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/GetTableSize/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetTableSize.Result> {

        @Override
        public String getJsonPath() {
            return "json/GetTableSize/result.json";
        }

        @Override
        public GetTableSize.Result getExpectedObject() {

            final GetTableSize.TableSize tableSize = GetTableSize.TableSize.builder()
                    .rows(1)
                    .col(2)
                    .build();

            return GetTableSize.Result.getInstance(tableSize);
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetTableSize.Result> {

        @Override
        public String getJsonPath() {
            return "json/GetTableSize/error.result.json";
        }

        @Override
        public GetTableSize.Result getExpectedObject() {
            return GetTableSize.Result.getErrorInstance();
        }
    }
}
