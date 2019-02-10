package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class InsertRowJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<InsertRow.Args> {

        @Override
        public InsertRow.Args getArgsObject() {

            return InsertRow.Args.builder()
                    .tId(1)
                    .key(2)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/InsertRow/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<InsertRow.Result> {

        @Override
        public String getJsonPath() {
            return "json/InsertRow/result.json";
        }

        @Override
        public InsertRow.Result getExpectedObject() {
            return new InsertRow.Result(1);
        }
    }
}
