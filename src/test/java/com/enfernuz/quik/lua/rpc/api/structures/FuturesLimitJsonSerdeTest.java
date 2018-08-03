package com.enfernuz.quik.lua.rpc.api.structures;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FuturesLimitJsonSerdeTest {

    private final ObjectMapper sut = new ObjectMapper();

    private static FuturesLimit expectedObj;
    private static String expectedJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        expectedObj = FuturesLimit.builder()
                .firmId("1")
                .trdAccId("2")
                .limitType(3)
                .liquidityCoef("4")
                .cbpPrevLimit("5")
                .cbpLimit("6")
                .cbplUsed("7")
                .cbplPlanned("8")
                .varMargin("9")
                .accruedInt("10")
                .cbplUsedForOrders("11")
                .cbplUsedForPositions("12")
                .optionsPremium("13")
                .tsComission("14")
                .kgo("15")
                .currCode("16")
                .realVarMargin("17")
                .build();

        expectedJson = Resources.toString(Resources.getResource("futures_limit.json"), Charsets.UTF_8);
    }

    @Test
    public void testSerialize() throws IOException {

        final String actualJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(expectedObj);

        assertEquals(expectedJson, actualJson);
    }

    @Test
    public void testDeserialize() throws IOException {

        final FuturesLimit actualObj = sut.readValue(expectedJson, FuturesLimit.class);

        assertEquals(expectedObj, actualObj);
    }
}
