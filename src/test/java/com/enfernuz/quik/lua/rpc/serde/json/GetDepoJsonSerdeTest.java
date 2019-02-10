package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.enfernuz.quik.lua.rpc.api.structures.Depo;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetDepoJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetDepo.Args> {

        @Override
        public GetDepo.Args getArgsObject() {

            return GetDepo.Args.builder()
                    .clientCode("1")
                    .firmId("2")
                    .secCode("3")
                    .trdAccId("4")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getDepo/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetDepo.Result> {

        @Override
        public String getJsonPath() {
            return "json/getDepo/result.json";
        }

        @Override
        public GetDepo.Result getExpectedObject() {

            final Depo depo = Depo.builder()
                    .depoLimitLockedBuyValue("1")
                    .depoCurrentBalance("2")
                    .depoLimitLockedBuy("3")
                    .depoLimitLocked("4")
                    .depoLimitAvailable("5")
                    .depoCurrentLimit("6")
                    .depoOpenBalance("7")
                    .depoOpenLimit("8")
                    .build();


            return new GetDepo.Result(depo);
        }
    }
}
