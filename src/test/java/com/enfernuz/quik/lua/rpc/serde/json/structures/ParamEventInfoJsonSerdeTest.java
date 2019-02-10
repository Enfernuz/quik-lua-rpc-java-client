package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.ParamEventInfo;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ParamEventInfoJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<ParamEventInfo> {

        @Override
        public String getJsonPath() {
            return "json/structures/ParamEventInfo.json";
        }

        @Override
        public ParamEventInfo getExpectedObject() {

            return ParamEventInfo.builder()
                    .classCode("1")
                    .secCode("2")
                    .build();
        }
    }
}
