package wip.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimitDelete;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import wip.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class DepoLimitDeleteJsonSerdeTests {

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
