package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetMoneyExJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetMoneyEx.Args> {

        @Override
        public GetMoneyEx.Args getArgsObject() {

            return GetMoneyEx.Args.builder()
                    .firmId("1")
                    .clientCode("2")
                    .tag("3")
                    .currCode("4")
                    .limitKind(5)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getMoneyEx/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetMoneyEx.Result> {

        @Override
        public String getJsonPath() {
            return "json/getMoneyEx/result.json";
        }

        @Override
        public GetMoneyEx.Result getExpectedObject() {

            final MoneyLimit moneyLimit = MoneyLimit.builder()
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


            return GetMoneyEx.Result.getInstance(moneyLimit);
        }
    }
}
