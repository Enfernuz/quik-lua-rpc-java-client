package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetParamExJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetParamEx.Request requestObj;
    private static GetParamEx.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetParamEx.Request.builder()
                .classCode("1")
                .secCode("2")
                .paramName("3")
                .build();

        final GetParamEx.ParamEx paramEx = GetParamEx.ParamEx.builder()
                .paramType("1")
                .paramValue("2")
                .paramImage("3")
                .result("4")
                .build();

        resultObj = new GetParamEx.Result(paramEx);

        requestJson =
                Resources.toString(Resources.getResource("json/getParamEx.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/getParamEx.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetParamEx.Result actualResultObj = sut.readValue(resultJson, GetParamEx.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
