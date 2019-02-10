package com.enfernuz.quik.lua.rpc.serde.json.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.TransReply;
import com.enfernuz.quik.lua.rpc.serde.json.AbstractJsonDeserializationTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class TransReplyJsonSerdeTest {

    public static class JsonDeserializationTest extends AbstractJsonDeserializationTest<TransReply> {

        @Override
        public String getJsonPath() {
            return "json/structures/TransReply.json";
        }

        @Override
        public TransReply getExpectedObject() {

            return TransReply.builder()
                    .transId(12345678910L)
                    .status(2)
                    .resultMsg("3")
                    .dateTime(DateTimeEntry.builder()
                            .mcs(1)
                            .ms(2)
                            .sec(3)
                            .min(4)
                            .hour(5)
                            .day(6)
                            .weekDay(7)
                            .month(8)
                            .year(9)
                            .build()
                    )
                    .uid("5")
                    .flags(6)
                    .serverTransId("7")
                    .orderNum("8")
                    .price("9")
                    .quantity("10")
                    .balance("11")
                    .firmId("12")
                    .account("13")
                    .clientCode("14")
                    .brokerRef("15")
                    .classCode("16")
                    .secCode("17")
                    .exchangeCode("18")
                    .errorCode(19)
                    .errorSource(20)
                    .firstOrderNum("21")
                    .gateReplyTime(DateTimeEntry.builder()
                            .mcs(9)
                            .ms(8)
                            .sec(7)
                            .min(6)
                            .hour(5)
                            .day(4)
                            .weekDay(3)
                            .month(2)
                            .year(1)
                            .build()
                    )
                    .build();
        }
    }
}
