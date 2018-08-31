package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DateTimeEntryJsonSerdeTest {

    private final ObjectMapper sut = new ObjectMapper();

    private static DateTimeEntry expectedObject;
    private static String expectedJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

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
    }

    @Test
    public void testDeserialize() throws IOException {

        final DateTimeEntry actualObject = sut.readValue(expectedJson, DateTimeEntry.class);

        assertEquals(expectedObject, actualObject);
    }
}