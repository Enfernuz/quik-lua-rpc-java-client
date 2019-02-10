package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class FuturesLimitJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<FuturesLimit> {

        @Override
        public String getJsonPath() {
            return "json/structures/FuturesLimit.json";
        }

        @Override
        public FuturesLimit getExpectedObject() {

            return FuturesLimit.builder()
                    .firmId("1")
                    .trdAccId("2")
                    .limitType(3)
                    .liquidityCoef("4")
                    .cbpPrevLimit("5")
                    .cbpLimit("6")
                    .cbplUsed("7")
                    .cbplPlanned("8")
                    .varMargin("9")
                    .accruedInt("10")
                    .cbplUsedForOrders("11")
                    .cbplUsedForPositions("12")
                    .optionsPremium("13")
                    .tsComission("14")
                    .kgo("15")
                    .currCode("16")
                    .realVarMargin("17")
                    .build();
        }
    }
}
