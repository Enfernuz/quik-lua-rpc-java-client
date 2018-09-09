package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DateTimeEntryPbSerdeTest {

    private static SerdeModule sut;

    private static DateTimeEntry expectedObject;
    private static byte[] expectedPbInput;

    private static DateTimeEntry expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = DateTimeEntry.builder()
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
        expectedPbInput = QluaStructures.DateTimeEntry.newBuilder()
                .setMcs(1)
                .setMs(2)
                .setSec(3)
                .setMin(4)
                .setHour(5)
                .setDay(6)
                .setWeekDay(7)
                .setMonth(8)
                .setYear(9)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = DateTimeEntry.builder().build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.DateTimeEntry.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(DateTimeEntry.class, expectedPbInput));
    }

    @Test
    public void testSerialize_WithOnlyRequiredFields() {

        assertTrue(
                Arrays.equals(
                        expectedPbInputWithOnlyRequiredFields,
                        sut.serialize(expectedObjectWithOnlyRequiredFields)
                )
        );
    }

    @Test
    public void testDeserialize_WithOnlyRequiredFields() {

        assertEquals(
                expectedObjectWithOnlyRequiredFields,
                sut.deserialize(DateTimeEntry.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
