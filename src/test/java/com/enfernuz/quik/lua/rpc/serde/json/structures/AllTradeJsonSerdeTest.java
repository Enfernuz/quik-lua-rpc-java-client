package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.AllTrade;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class AllTradeJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<AllTrade> {

        @Override
        public String getJsonPath() {
            return "json/structures/AllTrade.json";
        }

        @Override
        public AllTrade getExpectedObject() {

            final DateTimeEntry dateTimeEntry = DateTimeEntry.builder()
                    .mcs(1)
                    .ms(2)
                    .sec(3)
                    .min(4)
                    .hour(5)
                    .day(6)
                    .weekDay(7)
                    .month(8)
                    .year(9)
                    .build();

            return AllTrade.builder()
                    .tradeNum(123456789012345L)
                    .flags(2)
                    .price("3")
                    .qty(4)
                    .value("5")
                    .accruedInt("6")
                    .yield("7")
                    .settleCode("8")
                    .repoRate("9")
                    .repoValue("10")
                    .repo2Value("11")
                    .repoTerm("12")
                    .secCode("13")
                    .classCode("14")
                    .datetime(dateTimeEntry)
                    .period(16)
                    .openInterest("17")
                    .exchangeCode("18")
                    .execMarket("19")
                    .build();
        }
    }
}
