package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
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
    private static String requestJson;

    private static GetFuturesLimit.Result resultObj;
    private static String resultJson;

    private static GetFuturesLimit.Result resultObjWithOnlyRequiredFields;
    private static String resultJsonWithOnlyRequiredFields;

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
        requestJson =
                Resources.toString(Resources.getResource("json/getFuturesLimit.request.json"), Charsets.UTF_8);

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
        resultJson =
                Resources.toString(Resources.getResource("json/getFuturesLimit.result.json"), Charsets.UTF_8);

        resultObjWithOnlyRequiredFields = new GetFuturesLimit.Result(null);
        resultJsonWithOnlyRequiredFields =
                Resources.toString(Resources.getResource("json/getFuturesLimit.result.only_required_fields.json"), Charsets.UTF_8);
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

    @Test
    public void testDeserializeResultWithOnlyRequiredFields() throws IOException {

        final GetFuturesLimit.Result actualResultObj = sut.readValue(resultJsonWithOnlyRequiredFields, GetFuturesLimit.Result.class);

        assertEquals(resultObjWithOnlyRequiredFields, actualResultObj);
    }
}
