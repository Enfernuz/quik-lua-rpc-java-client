package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MoneyLimitJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<MoneyLimit> {

        @Override
        public String getJsonPath() {
            return "json/structures/MoneyLimit.json";
        }

        @Override
        public MoneyLimit getExpectedObject() {

            return MoneyLimit.builder()
                    .currCode("1")
                    .tag("2")
                    .firmId("3")
                    .clientCode("4")
                    .openBal("5")
                    .openLimit("6")
                    .currentBal("7")
                    .currentLimit("8")
                    .locked("9")
                    .lockedValueCoef("10")
                    .lockedMarginValue("11")
                    .leverage("12")
                    .limitKind(13)
                    .waPositionPrice("14")
                    .ordersCollateral("15")
                    .positionsCollateral("16")
                    .build();
        }
    }
}
