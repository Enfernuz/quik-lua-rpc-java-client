package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SetSelectedRow;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetSelectedRowJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetSelectedRow.Args> {

        @Override
        public SetSelectedRow.Args getArgsObject() {

            return SetSelectedRow.Args.builder()
                    .tableId(1)
                    .row(2)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetSelectedRow/args.json";
        }
    }

    public static class RpcDefaultRowArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetSelectedRow.Args> {

        @Override
        public SetSelectedRow.Args getArgsObject() {

            return SetSelectedRow.Args.builder()
                    .tableId(1)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetSelectedRow/default_row.args.json";
        }
    }

    public static class RpcOkResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetSelectedRow.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetSelectedRow/ok.result.json";
        }

        @Override
        public SetSelectedRow.Result getExpectedObject() {
            return SetSelectedRow.Result.getInstance(1);
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetSelectedRow.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetSelectedRow/error.result.json";
        }

        @Override
        public SetSelectedRow.Result getExpectedObject() {
            return SetSelectedRow.Result.getErrorInstance();
        }
    }
}
