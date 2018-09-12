package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetMoneyExJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetMoneyEx.Request requestObj;
    private static String requestJson;

    private static GetMoneyEx.Result resultObj;
    private static String resultJson;

    private static GetMoneyEx.Result resultObjWithOnlyRequiredFields;
    private static String resultJsonWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetMoneyEx.Request.builder()
                .firmId("1")
                .clientCode("2")
                .tag("3")
                .currCode("4")
                .limitKind(5)
                .build();
        requestJson = Resources.toString(Resources.getResource("json/getMoneyEx.request.json"), Charsets.UTF_8);

        final MoneyLimit moneyEx = MoneyLimit.builder()
                .currCode("1")
                .tag("2")
                .firmId("3")
                .clientCode("4")
                .openBal("5")
                .openLimit("6")
                .currentBal("7")
                .currentLimit("8")
                .locked("9")
                .lockedValueCoef("10")
                .lockedMarginValue("11")
                .leverage("12")
                .limitKind(13)
                .build();

        resultObj = GetMoneyEx.Result.getInstance(moneyEx);
        resultJson = Resources.toString(Resources.getResource("json/getMoneyEx.result.json"), Charsets.UTF_8);

        resultObjWithOnlyRequiredFields = GetMoneyEx.Result.getInstance(null);
        resultJsonWithOnlyRequiredFields =
                Resources.toString(Resources.getResource("json/getMoneyEx.result.only_required_fields.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetMoneyEx.Result actualResultObj = sut.readValue(resultJson, GetMoneyEx.Result.class);

        assertEquals(resultObj, actualResultObj);
    }

    @Test
    public void testDeserializeResultWithOnlyRequiredFields() throws IOException {

        final GetMoneyEx.Result actualResultObj = sut.readValue(resultJsonWithOnlyRequiredFields, GetMoneyEx.Result.class);

        assertEquals(resultObjWithOnlyRequiredFields, actualResultObj);
    }
}
