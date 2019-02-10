package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SubscribeLevel2Quotes;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SubscribeLevel2QuotesJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SubscribeLevel2Quotes.Args> {

        @Override
        public SubscribeLevel2Quotes.Args getArgsObject() {

            return SubscribeLevel2Quotes.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/Subscribe_Level_II_Quotes/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SubscribeLevel2Quotes.Result> {

        @Override
        public String getJsonPath() {
            return "json/Subscribe_Level_II_Quotes/true.result.json";
        }

        @Override
        public SubscribeLevel2Quotes.Result getExpectedObject() {
            return SubscribeLevel2Quotes.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SubscribeLevel2Quotes.Result> {

        @Override
        public String getJsonPath() {
            return "json/Subscribe_Level_II_Quotes/false.result.json";
        }

        @Override
        public SubscribeLevel2Quotes.Result getExpectedObject() {
            return SubscribeLevel2Quotes.Result.getInstance(false);
        }
    }
}
