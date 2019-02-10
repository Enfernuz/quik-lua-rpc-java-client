package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class OrderJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<Order> {

        @Override
        public String getJsonPath() {
            return "json/structures/Order.json";
        }

        @Override
        public Order getExpectedObject() {

            final DateTimeEntry dateTime = DateTimeEntry.builder()
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

            return Order.builder()
                    .orderNum(12345678910L)
                    .flags(2)
                    .brokerRef("3")
                    .userId("4")
                    .firmId("5")
                    .account("6")
                    .price("7")
                    .qty(8)
                    .balance("9")
                    .value("10")
                    .accruedInt("11")
                    .yield("12")
                    .transId("13")
                    .clientCode("14")
                    .price2("15")
                    .settleCode("16")
                    .uid("17")
                    .canceledUid("18")
                    .exchangeCode("19")
                    .activationTime("20")
                    .linkedOrder("21")
                    .expiry("22")
                    .secCode("23")
                    .classCode("24")
                    .datetime(dateTime)
                    .withdrawDatetime(withdrawDateTime)
                    .bankAccId("27")
                    .valueEntryType(28)
                    .repoTerm("29")
                    .repoValue("30")
                    .repo2Value("31")
                    .repoValueBalance("32")
                    .startDiscount("33")
                    .rejectReason("34")
                    .extOrderFlags("35")
                    .minQty(36)
                    .execType(37)
                    .sideQualifier(38)
                    .acntType(39)
                    .capacity(40)
                    .passiveOnlyOrder(41)
                    .visible(42)
                    .awgPrice("43")
                    .expiryTime("44")
                    .revisionNumber("45")
                    .priceCurrency("46")
                    .extOrderStatus(47)
                    .acceptedUid("48")
                    .filledValue("49")
                    .extRef("50")
                    .settleCurrency("51")
                    .onBehalfOfUid("52")
                    .clientQualifier(53)
                    .clientShortCode("54")
                    .investmentDecisionMakerQualifier(55)
                    .investmentDecisionMakerShortCode("56")
                    .executingTraderQualifier(57)
                    .executingTraderShortCode("58")
                    .build();
        }
    }
}
