package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.AllocTable;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class AllocTableJsonSerdeTest {

    public static class JsonRpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<AllocTable.Result> {

        @Override
        public String getJsonPath() {
            return "json/AllocTable/result.json";
        }

        @Override
        public AllocTable.Result getExpectedObject() {
            return new AllocTable.Result(1);
        }
    }
}
