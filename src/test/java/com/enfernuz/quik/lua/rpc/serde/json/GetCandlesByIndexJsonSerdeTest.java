package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.google.common.collect.ImmutableList;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(Enclosed.class)
public class GetCandlesByIndexJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetCandlesByIndex.Args> {

        @Override
        public GetCandlesByIndex.Args getArgsObject() {

            return GetCandlesByIndex.Args.builder()
                    .tag("1")
                    .line(2)
                    .firstCandle(3)
                    .count(4)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getCandlesByIndex/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetCandlesByIndex.Result> {

        @Override
        public String getJsonPath() {
            return "json/getCandlesByIndex/result.json";
        }

        @Override
        public GetCandlesByIndex.Result getExpectedObject() {

            final List<CandleEntry> t = ImmutableList.of(

                    CandleEntry.builder()
                            .open("1")
                            .close("2")
                            .high("3")
                            .low("4")
                            .volume("5")
                            .dateTimeEntry(
                                    DateTimeEntry.builder()
                                            .mcs(1)
                                            .ms(2)
                                            .sec(3)
                                            .min(4)
                                            .hour(5)
                                            .day(6)
                                            .weekDay(7)
                                            .month(8)
                                            .year(2009)
                                            .build()
                            )
                            .doesExist(1)
                            .build(),

                    CandleEntry.builder()
                            .open("21")
                            .close("22")
                            .high("23")
                            .low("24")
                            .volume("25")
                            .dateTimeEntry(
                                    DateTimeEntry.builder()
                                            .mcs(31)
                                            .ms(32)
                                            .sec(33)
                                            .min(34)
                                            .hour(12)
                                            .day(26)
                                            .weekDay(5)
                                            .month(3)
                                            .year(2015)
                                            .build()
                            )
                            .doesExist(0)
                            .build()

            );

            return new GetCandlesByIndex.Result(t, 2, "3");
        }
    }
}
