package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetFuturesHoldingJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetFuturesHolding.Request requestObj;
    private static GetFuturesHolding.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetFuturesHolding.Request.builder()
                .firmId("1")
                .trdAccId("2")
                .secCode("3")
                .type(4)
                .build();

        final FuturesClientHolding futuresClientHolding = FuturesClientHolding.builder()
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

        resultObj = new GetFuturesHolding.Result(futuresClientHolding);

        requestJson =
                Resources.toString(Resources.getResource("getFuturesHolding.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("getFuturesHolding.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetFuturesHolding.Result actualResultObj = sut.readValue(resultJson, GetFuturesHolding.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
