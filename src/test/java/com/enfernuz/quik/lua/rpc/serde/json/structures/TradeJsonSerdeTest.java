package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Trade;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class TradeJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<Trade> {

        @Override
        public String getJsonPath() {
            return "json/structures/Trade.json";
        }

        @Override
        public Trade getExpectedObject() {

            return Trade.builder()
                    .tradeNum(12345678910L)
                    .orderNum(23456789101L)
                    .brokerRef("3")
                    .userId("4")
                    .firmId("5")
                    .canceledUid("6")
                    .account("7")
                    .price("8")
                    .qty(9)
                    .value("10")
                    .accruedInt("11")
                    .yield("12")
                    .settleCode("13")
                    .cpFirmId("14")
                    .flags(15)
                    .price2("16")
                    .repoRate("17")
                    .clientCode("18")
                    .accrued2("19")
                    .repoTerm("20")
                    .repoValue("21")
                    .repo2Value("22")
                    .startDiscount("23")
                    .lowerDiscount("24")
                    .upperDiscount("25")
                    .blockSecurities("26")
                    .clearingComission("27")
                    .exchangeComission("28")
                    .techCenterComission("29")
                    .settleDate("30")
                    .settleCurrency("31")
                    .tradeCurrency("32")
                    .exchangeCode("33")
                    .stationId("34")
                    .secCode("35")
                    .classCode("36")
                    .datetime(DateTimeEntry.builder()
                            .mcs(1)
                            .ms(2)
                            .sec(3)
                            .min(4)
                            .hour(5)
                            .day(6)
                            .weekDay(7)
                            .month(8)
                            .year(9)
                            .build()
                    ).bankAccId("38")
                    .brokerComission("39")
                    .linkedTrade("40")
                    .period(41)
                    .transId("42")
                    .kind(43)
                    .clearingBankAccId("44")
                    .canceledDatetime(DateTimeEntry.builder()
                            .mcs(9)
                            .ms(8)
                            .sec(7)
                            .min(6)
                            .hour(5)
                            .day(4)
                            .weekDay(3)
                            .month(2)
                            .year(1)
                            .build()
                    ).clearingFirmId("46")
                    .systemRef("47")
                    .uid("48")
                    .lSecCode("49")
                    .orderRevisionNumber("50")
                    .orderQty("51")
                    .orderPrice("52")
                    .orderExchangeCode("53")
                    .execMarket("54")
                    .liquidityIndicator(55)
                    .extRef("56")
                    .extTradeFlags("57")
                    .onBehalfOfUid("58")
                    .clientQualifier(59)
                    .clientShortCode("60")
                    .investmentDecisionMakerQualifier(61)
                    .investmentDecisionMakerShortCode("62")
                    .executingTraderQualifier(63)
                    .executingTraderShortCode("64")
                    .waiverFlag(65)
                    .mlegBaseSid("66")
                    .sideQualifier(67)
                    .otcPostTradeIndicator(68)
                    .capacity(69)
                    .crossRate("70")
                    .build();
        }
    }
}
