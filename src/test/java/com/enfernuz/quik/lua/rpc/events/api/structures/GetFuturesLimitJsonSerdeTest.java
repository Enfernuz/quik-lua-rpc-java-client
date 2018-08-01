package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.enfernuz.quik.lua.rpc.api.structures.GetFuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetFuturesLimitJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetFuturesLimit.Request requestObj;
    private static GetFuturesLimit.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetFuturesLimit.Request.builder()
                .firmId("1")
                .trdAccId("2")
                .limitType(3)
                .currCode("4")
                .build();

        final FuturesLimit futuresLimit = FuturesLimit.builder()
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

        resultObj = new GetFuturesLimit.Result(futuresLimit);

        requestJson =
                Resources.toString(Resources.getResource("getFuturesLimit.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("getFuturesLimit.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetFuturesLimit.Result actualResultObj = sut.readValue(resultJson, GetFuturesLimit.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
