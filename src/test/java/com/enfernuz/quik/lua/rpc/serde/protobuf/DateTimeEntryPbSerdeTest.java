package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import static org.junit.Assert.assertEquals;

public class DateTimeEntryPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.DateTimeEntry, DateTimeEntry> pbConverter;

    private static DateTimeEntry expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = DateTimeEntryPbSerde.INSTANCE;

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
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();
    }

    @Test
    public void testDeserialize() {

        final DateTimeEntry actualObject = sut.deserialize(DateTimeEntry.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
