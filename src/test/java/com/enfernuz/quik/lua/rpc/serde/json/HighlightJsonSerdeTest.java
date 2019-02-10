package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class HighlightJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Highlight.Args> {

        @Override
        public Highlight.Args getArgsObject() {

            return Highlight.Args.builder()
                    .tId(1)
                    .row(2)
                    .col(3)
                    .bColor(4)
                    .fColor(5)
                    .timeout(6)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/Highlight/args.json";
        }
    }

    public static class RpcDefaultArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Highlight.Args> {

        @Override
        public Highlight.Args getArgsObject() {

            return Highlight.Args.builder()
                    .tId(1)
                    .timeout(6)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/Highlight/default.args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Highlight.Result> {

        @Override
        public String getJsonPath() {
            return "json/Highlight/true.result.json";
        }

        @Override
        public Highlight.Result getExpectedObject() {
            return Highlight.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Highlight.Result> {

        @Override
        public String getJsonPath() {
            return "json/Highlight/false.result.json";
        }

        @Override
        public Highlight.Result getExpectedObject() {
            return Highlight.Result.getInstance(false);
        }
    }
}
