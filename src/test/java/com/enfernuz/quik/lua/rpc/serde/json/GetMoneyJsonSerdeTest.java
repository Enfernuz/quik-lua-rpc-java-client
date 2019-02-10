package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoney;
import com.enfernuz.quik.lua.rpc.api.structures.Money;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetMoneyJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetMoney.Args> {

        @Override
        public GetMoney.Args getArgsObject() {

            return GetMoney.Args.builder()
                    .clientCode("1")
                    .firmId("2")
                    .tag("3")
                    .currCode("4")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getMoney/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetMoney.Result> {

        @Override
        public String getJsonPath() {
            return "json/getMoney/result.json";
        }

        @Override
        public GetMoney.Result getExpectedObject() {

            final Money money = Money.builder()
                    .moneyOpenLimit("1")
                    .moneyLimitLockedNonMarginalValue("2")
                    .moneyLimitLocked("3")
                    .moneyOpenBalance("4")
                    .moneyCurrentLimit("5")
                    .moneyCurrentBalance("6")
                    .moneyLimitAvailable("7")
                    .build();


            return new GetMoney.Result(money);
        }
    }
}
