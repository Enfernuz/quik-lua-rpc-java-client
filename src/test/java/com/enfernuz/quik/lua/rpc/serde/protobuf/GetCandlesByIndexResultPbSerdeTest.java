package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.common.collect.ImmutableList;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetCandlesByIndexResultPbSerdeTest {

    private static SerdeModule sut;

    private static GetCandlesByIndex.Result expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

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

        expectedObject = new GetCandlesByIndex.Result(candles, 2, "3");

        expectedPbInput = qlua.rpc.GetCandlesByIndex.Result.newBuilder()
                .addAllT(pbCandles)
                .setN(2)
                .setL("3")
                .build()
                .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final GetCandlesByIndex.Result actualObject = sut.deserialize(GetCandlesByIndex.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
