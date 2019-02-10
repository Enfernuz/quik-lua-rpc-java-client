package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.DeleteRow;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DeleteRowJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<DeleteRow.Args> {

        @Override
        public DeleteRow.Args getArgsObject() {

            return DeleteRow.Args.builder()
                    .tId(1)
                    .key(2)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/DeleteRow/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<DeleteRow.Result> {

        @Override
        public String getJsonPath() {
            return "json/DeleteRow/result.json";
        }

        @Override
        public DeleteRow.Result getExpectedObject() {
            return DeleteRow.Result.getInstance(true);
        }
    }
}
