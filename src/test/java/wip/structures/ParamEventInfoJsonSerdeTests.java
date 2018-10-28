package wip.structures;

import com.enfernuz.quik.lua.rpc.api.structures.ParamEventInfo;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import wip.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class ParamEventInfoJsonSerdeTests {

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
