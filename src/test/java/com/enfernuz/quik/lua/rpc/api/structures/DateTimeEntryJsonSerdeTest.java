package com.enfernuz.quik.lua.rpc.api.structures;

import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.json.JsonSerdeModule;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static com.enfernuz.quik.lua.rpc.serde.SerdeUtils.trimAndRemoveLineBreaks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DateTimeEntryJsonSerdeTest {

    private static SerdeModule sut;

    private static DateTimeEntry expectedObject;
    private static String expectedJson;
    private static byte[] expectedJsonAsBytes;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = JsonSerdeModule.INSTANCE;

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

        expectedJson = Resources.toString(Resources.getResource("json/structures/DateTimeEntry.json"), Charsets.UTF_8);
        expectedJsonAsBytes = trimAndRemoveLineBreaks(expectedJson).getBytes(Charsets.UTF_8);
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedJsonAsBytes, actual) );
    }

    @Test
    public void testDeserialize() {

        final DateTimeEntry actualObject = sut.deserialize(DateTimeEntry.class, expectedJsonAsBytes);

        assertEquals(expectedObject, actualObject);
    }
}