package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.Security;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetSecurityInfoJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetSecurityInfo.Request requestObj;
    private static GetSecurityInfo.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetSecurityInfo.Request.builder()
                .classCode("1")
                .secCode("2")
                .build();

        final Security securityInfo = Security.builder()
                .code("1")
                .name("2")
                .shortName("3")
                .classCode("4")
                .className("5")
                .faceValue("6")
                .faceUnit("7")
                .scale("8")
                .matDate("9")
                .lotSize("10")
                .isinCode("11")
                .minPriceStep("12")
                .build();

        resultObj = new GetSecurityInfo.Result(securityInfo);

        requestJson =
                Resources.toString(Resources.getResource("json/getSecurityInfo.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/getSecurityInfo.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetSecurityInfo.Result actualResultObj = sut.readValue(resultJson, GetSecurityInfo.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
