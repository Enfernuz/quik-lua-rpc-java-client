package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.os.SysDate;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SysdateJsonSerdeTest {

    public static class JsonRpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SysDate.Result> {

        @Override
        public String getJsonPath() {
            return "json/sysdate/result.json";
        }

        @Override
        public SysDate.Result getExpectedObject() {

            final DateTimeEntry dateTimeEntry = DateTimeEntry.builder()
                    .mcs(1)
                    .ms(2)
                    .sec(3)
                    .min(4)
                    .hour(5)
                    .day(6)
                    .weekDay(7)
                    .month(8)
                    .year(9)
                    .build();

            return new SysDate.Result(dateTimeEntry);
        }
    }
}
