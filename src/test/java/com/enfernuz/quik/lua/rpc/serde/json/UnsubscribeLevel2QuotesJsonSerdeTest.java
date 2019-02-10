package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.UnsubscribeLevel2Quotes;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class UnsubscribeLevel2QuotesJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<UnsubscribeLevel2Quotes.Args> {

        @Override
        public UnsubscribeLevel2Quotes.Args getArgsObject() {

            return UnsubscribeLevel2Quotes.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/Unsubscribe_Level_II_Quotes/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<UnsubscribeLevel2Quotes.Result> {

        @Override
        public String getJsonPath() {
            return "json/Unsubscribe_Level_II_Quotes/true.result.json";
        }

        @Override
        public UnsubscribeLevel2Quotes.Result getExpectedObject() {
            return UnsubscribeLevel2Quotes.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<UnsubscribeLevel2Quotes.Result> {

        @Override
        public String getJsonPath() {
            return "json/Unsubscribe_Level_II_Quotes/false.result.json";
        }

        @Override
        public UnsubscribeLevel2Quotes.Result getExpectedObject() {
            return UnsubscribeLevel2Quotes.Result.getInstance(false);
        }
    }
}
