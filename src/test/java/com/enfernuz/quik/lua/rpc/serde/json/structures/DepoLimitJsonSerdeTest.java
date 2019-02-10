package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class DepoLimitJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<DepoLimit> {

        @Override
        public String getJsonPath() {
            return "json/structures/DepoLimit.json";
        }

        @Override
        public DepoLimit getExpectedObject() {

            return DepoLimit.builder()
                    .secCode("1")
                    .trdAccId("2")
                    .firmId("3")
                    .clientCode("4")
                    .openBal(5)
                    .openLimit(6)
                    .currentBal(7)
                    .currentLimit(8)
                    .lockedSell(9)
                    .lockedBuy(10)
                    .lockedBuyValue("11")
                    .lockedSellValue("12")
                    .waPositionPrice("13")
                    .limitKind(14)
                    .build();
        }
    }
}
