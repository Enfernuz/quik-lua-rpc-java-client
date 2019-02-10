package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.StopOrder;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class StopOrderJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<StopOrder> {

        @Override
        public String getJsonPath() {
            return "json/structures/StopOrder.json";
        }

        @Override
        public StopOrder getExpectedObject() {

            final DateTimeEntry orderDateTime = DateTimeEntry.builder()
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
            final DateTimeEntry withdrawDateTime = DateTimeEntry.builder()
                    .mcs(10)
                    .ms(11)
                    .sec(12)
                    .min(13)
                    .hour(14)
                    .day(15)
                    .weekDay(16)
                    .month(17)
                    .year(18)
                    .build();
            final DateTimeEntry activationDateTime = DateTimeEntry.builder()
                    .mcs(19)
                    .ms(20)
                    .sec(21)
                    .min(22)
                    .hour(23)
                    .day(24)
                    .weekDay(25)
                    .month(26)
                    .year(27)
                    .build();

            return StopOrder.builder()
                    .orderNum(12345678910L)
                    .orderTime("2")
                    .flags(3)
                    .brokerRef("4")
                    .firmId("5")
                    .account("6")
                    .condition(7)
                    .conditionPrice("8")
                    .price("9")
                    .qty(10)
                    .linkedOrder("11")
                    .expiry("12")
                    .transId("13")
                    .clientCode("14")
                    .coOrderNum("15")
                    .coOrderPrice("16")
                    .stopOrderType(17)
                    .orderDate("18")
                    .allTradeNum("19")
                    .stopFlags(20)
                    .offset("21")
                    .spread("22")
                    .balance("23")
                    .uid("24")
                    .filledQty(25)
                    .withdrawTime("26")
                    .conditionPrice2("27")
                    .activeFromTime("28")
                    .activeToTime("29")
                    .secCode("30")
                    .classCode("31")
                    .conditionSecCode("32")
                    .conditionClassCode("33")
                    .canceledUid("34")
                    .orderDateTime(orderDateTime)
                    .withdrawDateTime(withdrawDateTime)
                    .activationDateTime(activationDateTime)
                    .build();
        }
    }
}
