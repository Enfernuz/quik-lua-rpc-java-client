package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetFuturesHoldingJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetFuturesHolding.Args> {

        @Override
        public GetFuturesHolding.Args getArgsObject() {

            return GetFuturesHolding.Args.builder()
                    .firmId("1")
                    .trdAccId("2")
                    .secCode("3")
                    .type(4)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getFuturesHolding/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetFuturesHolding.Result> {

        @Override
        public String getJsonPath() {
            return "json/getFuturesHolding/result.json";
        }

        @Override
        public GetFuturesHolding.Result getExpectedObject() {

            final FuturesClientHolding futuresClientHolding = FuturesClientHolding.builder()
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


            return GetFuturesHolding.Result.getInstance(futuresClientHolding);
        }
    }
}
