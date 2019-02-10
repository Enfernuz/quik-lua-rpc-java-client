package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.QuoteEventInfo;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class QuoteEventInfoJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<QuoteEventInfo> {

        @Override
        public String getJsonPath() {
            return "json/structures/QuoteEventInfo.json";
        }

        @Override
        public QuoteEventInfo getExpectedObject() {

            return QuoteEventInfo.builder()
                    .classCode("1")
                    .secCode("2")
                    .build();
        }
    }
}
