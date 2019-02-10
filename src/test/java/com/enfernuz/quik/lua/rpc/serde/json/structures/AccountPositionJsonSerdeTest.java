package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.AccountPosition;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class AccountPositionJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<AccountPosition> {

        @Override
        public String getJsonPath() {
            return "json/structures/AccountPosition.json";
        }

        @Override
        public AccountPosition getExpectedObject() {

            return AccountPosition.builder()
                    .firmId("1")
                    .currCode("2")
                    .tag("3")
                    .description("4")
                    .openBal("5")
                    .currentPos("6")
                    .plannedPos("7")
                    .limit1("8")
                    .limit2("9")
                    .orderBuy("10")
                    .orderSell("11")
                    .netto("12")
                    .plannedBal("13")
                    .debit("14")
                    .credit("15")
                    .bankAccId("16")
                    .marginCall("17")
                    .settleBal("18")
                    .build();
        }
    }
}
