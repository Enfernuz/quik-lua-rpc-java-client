package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class FirmJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<Firm> {

        @Override
        public String getJsonPath() {
            return "json/structures/Firm.json";
        }

        @Override
        public Firm getExpectedObject() {

            return Firm.builder()
                    .firmId("1")
                    .firmName("2")
                    .status(3)
                    .exchange("4")
                    .build();
        }
    }
}
