package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FirmJsonSerdeTest {

    private final ObjectMapper sut = new ObjectMapper();

    private static Firm firm;
    private static String firmAsJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        firm = Firm.builder()
                .firmId("1")
                .firmName("2")
                .status(3)
                .exchange("4")
                .build();

        firmAsJson = Resources.toString(Resources.getResource("firm.json"), Charsets.UTF_8);
    }

    @Test
    public void testSerialize() throws IOException {

        final String actual = sut.writerWithDefaultPrettyPrinter().writeValueAsString(firm);

        assertEquals(firmAsJson, actual);
    }

    @Test
    public void testDeserialize() throws IOException {

        final Firm actual = sut.readValue(firmAsJson, Firm.class);

        assertEquals(firm, actual);
    }
}
