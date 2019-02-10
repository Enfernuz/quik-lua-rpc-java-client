package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class FuturesClientHoldingJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<FuturesClientHolding> {

        @Override
        public String getJsonPath() {
            return "json/structures/FuturesClientHolding.json";
        }

        @Override
        public FuturesClientHolding getExpectedObject() {

            return FuturesClientHolding.builder()
                    .firmId("1")
                    .trdAccId("2")
                    .secCode("3")
                    .type(4)
                    .startBuy("5")
                    .startSell("6")
                    .todayBuy("7")
                    .todaySell("8")
                    .totalNet("9")
                    .openBuys(10)
                    .openSells(11)
                    .cbplUsed("12")
                    .cbplPlanned("13")
                    .varMargin("14")
                    .avrPosnPrice("15")
                    .positionValue("16")
                    .realVarMargin("17")
                    .totalVarMargin("18")
                    .sessionStatus(19)
                    .build();
        }
    }
}
