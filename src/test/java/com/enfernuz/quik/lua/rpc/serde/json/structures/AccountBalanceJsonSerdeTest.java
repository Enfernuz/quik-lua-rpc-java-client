package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.AccountBalance;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class AccountBalanceJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<AccountBalance> {

        @Override
        public String getJsonPath() {
            return "json/structures/AccountBalance.json";
        }

        @Override
        public AccountBalance getExpectedObject() {

            return AccountBalance.builder()
                    .firmId("1")
                    .secCode("2")
                    .trdAccId("3")
                    .depAccId("4")
                    .openBal("5")
                    .currentPos("6")
                    .plannedPosSell("7")
                    .plannedPosBuy("8")
                    .planBal("9")
                    .usqtyb("10")
                    .usqtys("11")
                    .planned("12")
                    .settleBal("13")
                    .bankAccId("14")
                    .firmUse(15)
                    .build();
        }
    }
}
