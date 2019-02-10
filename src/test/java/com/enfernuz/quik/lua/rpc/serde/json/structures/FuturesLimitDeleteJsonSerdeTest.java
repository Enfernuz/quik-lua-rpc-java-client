package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class FuturesLimitDeleteJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<FuturesLimitDelete> {

        @Override
        public String getJsonPath() {
            return "json/structures/FuturesLimitDelete.json";
        }

        @Override
        public FuturesLimitDelete getExpectedObject() {

            return FuturesLimitDelete.builder()
                    .firmId("1")
                    .limitType(2)
                    .build();
        }
    }
}
