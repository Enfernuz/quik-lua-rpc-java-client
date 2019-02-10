package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class AddColumnJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<AddColumn.Args> {

        @Override
        public AddColumn.Args getArgsObject() {

            return AddColumn.Args.builder()
                    .tId(1)
                    .iCode(2)
                    .name("3")
                    .isDefault(true)
                    .parType(AddColumn.ColumnParameterType.QTABLE_INT64_TYPE)
                    .width(6)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/AddColumn/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<AddColumn.Result> {

        @Override
        public String getJsonPath() {
            return "json/AddColumn/result.json";
        }

        @Override
        public AddColumn.Result getExpectedObject() {
            return new AddColumn.Result(1);
        }
    }
}
