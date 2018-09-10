package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetDepoExJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetDepoEx.Request requestObj;
    private static String requestJson;

    private static GetDepoEx.Result resultObj;
    private static String resultJson;

    private static GetDepoEx.Result resultObjWithOnlyRequiredFields;
    private static String resultJsonWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetDepoEx.Request.builder()
                .firmId("1")
                .clientCode("2")
                .secCode("3")
                .trdAccId("4")
                .limitKind(5)
                .build();
        requestJson =
                Resources.toString(Resources.getResource("json/getDepoEx.request.json"), Charsets.UTF_8);

        final DepoLimit depoLimit = DepoLimit.builder()
                .secCode("1")
                .trdAccId("2")
                .firmId("3")
                .clientCode("4")
                .openBal(5)
                .openLimit(6)
                .currentBal(7)
                .currentLimit(8)
                .lockedSell(9)
                .lockedBuy(10)
                .lockedBuyValue("11")
                .lockedSellValue("12")
                .awgPositionPrice("13")
                .limitKind(14)
                .build();

        resultObj = GetDepoEx.Result.getInstance(depoLimit);
        resultJson =
                Resources.toString(Resources.getResource("json/getDepoEx.result.json"), Charsets.UTF_8);

        resultObjWithOnlyRequiredFields = GetDepoEx.Result.getInstance(null);
        resultJsonWithOnlyRequiredFields =
                Resources.toString(Resources.getResource("json/getDepoEx.result.only_required_fields.json"), Charsets.UTF_8);
    }

    @Test
    public void testSerializeRequest() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testDeserializeResult() throws IOException {

        final GetDepoEx.Result actualResultObj = sut.readValue(resultJson, GetDepoEx.Result.class);

        assertEquals(resultObj, actualResultObj);
    }

    @Test
    public void testDeserializeResultWithOnlyRequiredFields() throws IOException {

        final GetDepoEx.Result actualResultObj = sut.readValue(resultJsonWithOnlyRequiredFields, GetDepoEx.Result.class);

        assertEquals(resultObjWithOnlyRequiredFields, actualResultObj);
    }
}
