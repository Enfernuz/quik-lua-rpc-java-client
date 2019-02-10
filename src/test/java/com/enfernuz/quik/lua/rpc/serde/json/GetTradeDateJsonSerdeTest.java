package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetTradeDate;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetTradeDateJsonSerdeTest {

    public static class JsonRpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetTradeDate.Result> {

        @Override
        public String getJsonPath() {
            return "json/getTradeDate/result.json";
        }

        @Override
        public GetTradeDate.Result getExpectedObject() {

            final GetTradeDate.TradeDate tradeDate = GetTradeDate.TradeDate.builder()
                    .date("1")
                    .year(2)
                    .month(3)
                    .day(4)
                    .build();

            return new GetTradeDate.Result(tradeDate);
        }
    }
}
