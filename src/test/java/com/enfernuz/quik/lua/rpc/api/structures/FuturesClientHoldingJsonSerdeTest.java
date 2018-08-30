package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FuturesClientHoldingJsonSerdeTest {

    private final ObjectMapper sut = new ObjectMapper();

    private static FuturesClientHolding futuresClientHolding;
    private static String futuresClientHoldingAsJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        futuresClientHolding = FuturesClientHolding.builder()
                .firmId("1")
                .trdAccId("2")
                .secCode("3")
                .type(4)
                .startBuy("5")
                .startSell("6")
                .todayBuy("7")
                .todaySell("8")
                .totalNet("9")
                .openBuys(10)
                .openSells(11)
                .cbplUsed("12")
                .cbplPlanned("13")
                .varMargin("14")
                .avrPosnPrice("15")
                .positionValue("16")
                .realVarMargin("17")
                .totalVarMargin("18")
                .sessionStatus(19)
                .build();

        futuresClientHoldingAsJson =
                Resources.toString(Resources.getResource("json/structures/FuturesClientHolding.json"), Charsets.UTF_8);
    }

    @Test
    public void testSerialize() throws IOException {

        final String actual = sut.writerWithDefaultPrettyPrinter().writeValueAsString(futuresClientHolding);

        assertEquals(futuresClientHoldingAsJson, actual);
    }

    @Test
    public void testDeserialize() throws IOException {

        final FuturesClientHolding actual = sut.readValue(futuresClientHoldingAsJson, FuturesClientHolding.class);

        assertEquals(futuresClientHolding, actual);
    }
}
