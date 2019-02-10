package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesLimit;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetFuturesLimitJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetFuturesLimit.Args> {

        @Override
        public GetFuturesLimit.Args getArgsObject() {

            return GetFuturesLimit.Args.builder()
                    .firmId("1")
                    .trdAccId("2")
                    .limitType(3)
                    .currCode("4")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getFuturesLimit/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetFuturesLimit.Result> {

        @Override
        public String getJsonPath() {
            return "json/getFuturesLimit/result.json";
        }

        @Override
        public GetFuturesLimit.Result getExpectedObject() {

            final FuturesLimit futuresLimit = FuturesLimit.builder()
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


            return GetFuturesLimit.Result.getInstance(futuresLimit);
        }
    }
}
