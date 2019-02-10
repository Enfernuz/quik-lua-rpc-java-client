package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.IsSubscribedLevel2Quotes;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class IsSubscribedLevel2QuotesJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<IsSubscribedLevel2Quotes.Args> {

        @Override
        public IsSubscribedLevel2Quotes.Args getArgsObject() {

            return IsSubscribedLevel2Quotes.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/IsSubscribed_Level_II_Quotes/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<IsSubscribedLevel2Quotes.Result> {

        @Override
        public String getJsonPath() {
            return "json/IsSubscribed_Level_II_Quotes/true.result.json";
        }

        @Override
        public IsSubscribedLevel2Quotes.Result getExpectedObject() {
            return IsSubscribedLevel2Quotes.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<IsSubscribedLevel2Quotes.Result> {

        @Override
        public String getJsonPath() {
            return "json/IsSubscribed_Level_II_Quotes/false.result.json";
        }

        @Override
        public IsSubscribedLevel2Quotes.Result getExpectedObject() {
            return IsSubscribedLevel2Quotes.Result.getInstance(false);
        }
    }
}
