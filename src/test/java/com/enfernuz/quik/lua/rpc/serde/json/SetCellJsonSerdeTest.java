package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SetCell;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetCellJsonSerdeTest {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetCell.Args> {

        @Override
        public SetCell.Args getArgsObject() {

            return SetCell.Args.builder()
                    .tId(1)
                    .key(2)
                    .code(3)
                    .text("4")
                    .value(5.55)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetCell/full.args.json";
        }
    }

    public static class RpcWithoutValueArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetCell.Args> {

        @Override
        public SetCell.Args getArgsObject() {

            return SetCell.Args.builder()
                    .tId(1)
                    .key(2)
                    .code(3)
                    .text("4")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetCell/without_value.args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetCell.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetCell/true.result.json";
        }

        @Override
        public SetCell.Result getExpectedObject() {
            return SetCell.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetCell.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetCell/false.result.json";
        }

        @Override
        public SetCell.Result getExpectedObject() {
            return SetCell.Result.getInstance(false);
        }
    }
}
