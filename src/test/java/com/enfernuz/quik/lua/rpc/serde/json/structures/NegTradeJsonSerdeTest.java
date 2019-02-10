package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.NegTrade;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class NegTradeJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<NegTrade> {

        @Override
        public String getJsonPath() {
            return "json/structures/NegTrade.json";
        }

        @Override
        public NegTrade getExpectedObject() {

            return NegTrade.builder()
                    .tradeNum(12345678910L)
                    .tradeDate("2")
                    .settleDate("3")
                    .flags(4)
                    .brokerRef("5")
                    .firmId("6")
                    .account("7")
                    .cpFirmId("8")
                    .cpAccount("9")
                    .price("10")
                    .qty(11)
                    .value("12")
                    .settleCode("13")
                    .reportNum("14")
                    .cpReportNum("15")
                    .accruedInt("16")
                    .repoTradeNo("17")
                    .price1("18")
                    .repoRate("19")
                    .price2("20")
                    .clientCode("21")
                    .tsComission("22")
                    .balance("23")
                    .settleTime("24")
                    .amount("25")
                    .repoValue("26")
                    .repoTerm("27")
                    .repo2Value("28")
                    .returnValue("29")
                    .discount("30")
                    .lowerDiscount("31")
                    .upperDiscount("32")
                    .blockSecurities("33")
                    .urgencyFlag("34")
                    .type(35)
                    .operationType(36)
                    .expectedDiscount("37")
                    .expectedQuantity("38")
                    .expectedRepoValue("39")
                    .expectedRepo2Value("40")
                    .expectedReturnValue("41")
                    .orderNum("42")
                    .reportTradeDate("43")
                    .settled(44)
                    .clearingType(45)
                    .reportComission("46")
                    .couponPayment("47")
                    .principalPayment("48")
                    .principalPaymentDate("49")
                    .nextDaySettle("50")
                    .settleCurrency("51")
                    .secCode("52")
                    .classCode("53")
                    .compVal("54")
                    .parentTradeNo("55")
                    .bankId("56")
                    .bankAccId("57")
                    .preciseBalance("58")
                    .confirmTime("59")
                    .exFlags(60)
                    .confirmReport("61")
                    .extRef("62")
                    .build();
        }
    }
}
