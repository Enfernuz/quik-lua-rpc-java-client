package wip.structures;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import wip.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class FirmJsonSerdeTests {

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
