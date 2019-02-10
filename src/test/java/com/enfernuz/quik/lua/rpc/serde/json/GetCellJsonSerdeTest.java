package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetCellJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetCell.Args> {

        @Override
        public GetCell.Args getArgsObject() {

            return GetCell.Args.builder()
                    .tId(1)
                    .key(2)
                    .code(3)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/GetCell/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetCell.Result> {

        @Override
        public String getJsonPath() {
            return "json/GetCell/result.json";
        }

        @Override
        public GetCell.Result getExpectedObject() {

            return GetCell.Result.builder()
                    .image("1")
                    .value("2")
                    .build();
        }
    }
}
