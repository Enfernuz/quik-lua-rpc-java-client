package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SetColor;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetColorJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetColor.Args> {

        @Override
        public SetColor.Args getArgsObject() {

            return SetColor.Args.builder()
                    .tId(1)
                    .row(2)
                    .col(3)
                    .bColor(4)
                    .fColor(5)
                    .selBColor(6)
                    .selFColor(7)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetColor/args.json";
        }
    }

    public static class RpcDefaultArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetColor.Args> {

        @Override
        public SetColor.Args getArgsObject() {

            return SetColor.Args.builder()
                    .tId(1)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetColor/default.args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetColor.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetColor/true.result.json";
        }

        @Override
        public SetColor.Result getExpectedObject() {
            return SetColor.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetColor.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetColor/false.result.json";
        }

        @Override
        public SetColor.Result getExpectedObject() {
            return SetColor.Result.getInstance(false);
        }
    }
}
