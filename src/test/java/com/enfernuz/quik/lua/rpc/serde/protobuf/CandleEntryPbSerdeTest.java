package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CandleEntryPbSerdeTest {

    private static SerdeModule sut;

    private static CandleEntry expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

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
        final QluaStructures.DateTimeEntry pbDateTimeEntry = QluaStructures.DateTimeEntry.newBuilder()
                .setMcs(1)
                .setMs(2)
                .setSec(3)
                .setMin(4)
                .setHour(5)
                .setDay(6)
                .setWeekDay(7)
                .setMonth(8)
                .setYear(9)
                .build();

        expectedObject = CandleEntry.builder()
                .open("1")
                .close("2")
                .high("3")
                .low("4")
                .volume("5")
                .dateTimeEntry(dateTimeEntry)
                .doesExist(7)
                .build();
        expectedPbInput = QluaStructures.CandleEntry.newBuilder()
                .setOpen("1")
                .setClose("2")
                .setHigh("3")
                .setLow("4")
                .setVolume("5")
                .setDatetime(pbDateTimeEntry)
                .setDoesExist(7)
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

        final CandleEntry actualObject = sut.deserialize(CandleEntry.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}