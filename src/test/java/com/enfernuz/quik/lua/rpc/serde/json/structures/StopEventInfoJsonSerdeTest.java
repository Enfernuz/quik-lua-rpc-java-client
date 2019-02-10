package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.StopEventInfo;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class StopEventInfoJsonSerdeTest {

    public static class FromDialogWindowJsonDeserializationTest extends AbstractJsonDeserializationTest<StopEventInfo> {

        @Override
        public String getJsonPath() {
            return "json/structures/StopEventInfo/from_dialog_window.json";
        }

        @Override
        public StopEventInfo getExpectedObject() {
            return StopEventInfo.getInstance(1);
        }
    }

    public static class FromTerminalClosureJsonDeserializationTest extends AbstractJsonDeserializationTest<StopEventInfo> {

        @Override
        public String getJsonPath() {
            return "json/structures/StopEventInfo/from_terminal_closure.json";
        }

        @Override
        public StopEventInfo getExpectedObject() {
            return StopEventInfo.getInstance(2);
        }
    }

    public static class OtherJsonDeserializationTest extends AbstractJsonDeserializationTest<StopEventInfo> {

        @Override
        public String getJsonPath() {
            return "json/structures/StopEventInfo/other.json";
        }

        @Override
        public StopEventInfo getExpectedObject() {
            return StopEventInfo.getInstance(3);
        }
    }
}
