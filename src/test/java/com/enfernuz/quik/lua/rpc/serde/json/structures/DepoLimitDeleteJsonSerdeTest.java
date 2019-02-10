package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class DepoLimitDeleteJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<DepoLimitDelete> {

        @Override
        public String getJsonPath() {
            return "json/structures/DepoLimitDelete.json";
        }

        @Override
        public DepoLimitDelete getExpectedObject() {

            return DepoLimitDelete.builder()
                    .secCode("1")
                    .trdAccId("2")
                    .firmId("3")
                    .clientCode("4")
                    .limitKind(5)
                    .build();
        }
    }
}
