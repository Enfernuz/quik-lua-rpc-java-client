package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.ConnectedEventInfo;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;

@RunWith(Enclosed.class)
public class ConnectedEventInfoSerdeTest {

    public static class TrueFlagJsonDeserializationTest extends AbstractJsonDeserializationTest<ConnectedEventInfo> {

        @Override
        public String getJsonPath() {
            return "json/structures/ConnectedEventInfo/true.flag.json";
        }

        @Override
        public ConnectedEventInfo getExpectedObject() {
            return ConnectedEventInfo.getInstance(true);
        }
    }

    public static class FalseFlagJsonDeserializationTest extends AbstractJsonDeserializationTest<ConnectedEventInfo> {

        @Override
        public String getJsonPath() {
            return "json/structures/ConnectedEventInfo/false.flag.json";
        }

        @Override
        public ConnectedEventInfo getExpectedObject() {
            return ConnectedEventInfo.getInstance(false);
        }
    }
}
