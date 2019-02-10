package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.NegDeal;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class NegDealJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<NegDeal> {

        @Override
        public String getJsonPath() {
            return "json/structures/NegDeal.json";
        }

        @Override
        public NegDeal getExpectedObject() {

            final DateTimeEntry activationDateTime = DateTimeEntry.builder()
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
            final DateTimeEntry dateTime = DateTimeEntry.builder()
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

            return NegDeal.builder()
                    .negDealNum(12345678910L)
                    .negDealTime("2")
                    .flags(3)
                    .brokerRef("4")
                    .userId("5")
                    .firmId("6")
                    .cpUserId("7")
                    .cpFirmId("8")
                    .account("9")
                    .price("10")
                    .qty(11)
                    .matchRef("12")
                    .settleCode("13")
                    .yield("14")
                    .accruedInt("15")
                    .value("16")
                    .price2("17")
                    .repoRate("18")
                    .refundRate("19")
                    .transId("20")
                    .clientCode("21")
                    .repoEntry(22)
                    .repoValue("23")
                    .repo2Value("24")
                    .repoTerm("25")
                    .startDiscount("26")
                    .lowerDiscount("27")
                    .upperDiscount("28")
                    .blockSecurities("29")
                    .uid("30")
                    .withdrawTime("31")
                    .negDealDate("32")
                    .balance("33")
                    .originRepoValue("34")
                    .originQty("35")
                    .originDiscount("36")
                    .negDealActivationDate("37")
                    .negDealActivationTime("38")
                    .quoteNo("39")
                    .settleCurrency("40")
                    .secCode("41")
                    .classCode("42")
                    .bankAccId("43")
                    .withdrawDate("44")
                    .linkedOrder("45")
                    .activationDateTime(activationDateTime)
                    .withdrawDateTime(withdrawDateTime)
                    .dateTime(dateTime)
                    .lSecCode("49")
                    .canceledUid("50")
                    .systemRef("51")
                    .priceCurrency("52")
                    .orderExchangeCode("53")
                    .extRef("54")
                    .period("55")
                    .clientQualifier(56)
                    .clientShortCode("57")
                    .investmentDecisionMakerQualifier(58)
                    .investmentDecisionMakerShortCode("59")
                    .executingTraderQualifier(60)
                    .executingTraderShortCode("61")
                    .build();
        }
    }
}
