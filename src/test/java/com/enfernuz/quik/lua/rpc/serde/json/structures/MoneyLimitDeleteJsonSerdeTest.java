package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimitDelete;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class MoneyLimitDeleteJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<MoneyLimitDelete> {

        @Override
        public String getJsonPath() {
            return "json/structures/MoneyLimitDelete.json";
        }

        @Override
        public MoneyLimitDelete getExpectedObject() {

            return MoneyLimitDelete.builder()
                    .currCode("1")
                    .tag("2")
                    .clientCode("3")
                    .firmId("4")
                    .limitKind(5)
                    .build();
        }
    }
}
