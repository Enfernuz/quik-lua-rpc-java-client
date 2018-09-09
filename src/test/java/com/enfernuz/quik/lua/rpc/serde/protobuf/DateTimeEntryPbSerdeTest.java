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

    private static DateTimeEntry expectedObjectInitializedByDefault;
    private static byte[] expectedPbInputInitializedByDefault;

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

        expectedObjectInitializedByDefault = DateTimeEntry.builder().build();
        expectedPbInputInitializedByDefault = QluaStructures.DateTimeEntry.getDefaultInstance().toByteArray();
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
    public void testSerializeObjectInitializedByDefault() {

        assertTrue(
                Arrays.equals(
                        expectedPbInputInitializedByDefault,
                        sut.serialize(expectedObjectInitializedByDefault)
                )
        );
    }

    @Test
    public void testDeserializePbInputInitializedByDefault() {

        assertEquals(
                expectedObjectInitializedByDefault,
                sut.deserialize(DateTimeEntry.class, expectedPbInputInitializedByDefault)
        );
    }
}
