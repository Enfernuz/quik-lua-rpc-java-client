package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import java.util.List;

public class GetCandlesByIndexResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetCandlesByIndex.Result, GetCandlesByIndex.Result> {

    private static final int N = 2;
    private static final String L = "3";

    @Override
    public @NotNull Deserializer<GetCandlesByIndex.Result> getDeserializerUnderTest() {
        return GetCandlesByIndexResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetCandlesByIndex.Result getTargetObject() {

        final List<CandleEntry> candles = ImmutableList.of(
                CandleEntry.builder()
                        .open("50")
                        .close("100")
                        .high("150")
                        .low("1")
                        .volume("555")
                        .dateTimeEntry(
                                DateTimeEntry.builder()
                                        .mcs(1)
                                        .ms(2)
                                        .sec(3)
                                        .min(4)
                                        .hour(5)
                                        .day(6)
                                        .weekDay(3)
                                        .month(8)
                                        .year(9)
                                        .build()
                        )
                        .doesExist(1)
                        .build(),
                CandleEntry.builder()
                        .open("51")
                        .close("102")
                        .high("105")
                        .low("49")
                        .volume("123")
                        .dateTimeEntry(
                                DateTimeEntry.builder()
                                        .mcs(11)
                                        .ms(12)
                                        .sec(13)
                                        .min(14)
                                        .hour(15)
                                        .day(16)
                                        .weekDay(3)
                                        .month(8)
                                        .year(9)
                                        .build()
                        )
                        .doesExist(1)
                        .build()

        );

        return new GetCandlesByIndex.Result(candles, N, L);
    }

    @NotNull
    @Override
    public qlua.rpc.GetCandlesByIndex.Result getTargetObjectAsPbMessage() {

        final List<QluaStructures.CandleEntry> pbCandles = ImmutableList.of(
                QluaStructures.CandleEntry.newBuilder()
                        .setOpen("50")
                        .setClose("100")
                        .setHigh("150")
                        .setLow("1")
                        .setVolume("555")
                        .setDatetime(
                                QluaStructures.DateTimeEntry.newBuilder()
                                        .setMcs(1)
                                        .setMs(2)
                                        .setSec(3)
                                        .setMin(4)
                                        .setHour(5)
                                        .setDay(6)
                                        .setWeekDay(3)
                                        .setMonth(8)
                                        .setYear(9)
                                        .build()
                        )
                        .setDoesExist(1)
                        .build(),
                QluaStructures.CandleEntry.newBuilder()
                        .setOpen("51")
                        .setClose("102")
                        .setHigh("105")
                        .setLow("49")
                        .setVolume("123")
                        .setDatetime(
                                QluaStructures.DateTimeEntry.newBuilder()
                                        .setMcs(11)
                                        .setMs(12)
                                        .setSec(13)
                                        .setMin(14)
                                        .setHour(15)
                                        .setDay(16)
                                        .setWeekDay(3)
                                        .setMonth(8)
                                        .setYear(9)
                                        .build()
                        )
                        .setDoesExist(1)
                        .build()
        );

        return qlua.rpc.GetCandlesByIndex.Result.newBuilder()
                .addAllT(pbCandles)
                .setN(N)
                .setL(L)
                .build();
    }
}
