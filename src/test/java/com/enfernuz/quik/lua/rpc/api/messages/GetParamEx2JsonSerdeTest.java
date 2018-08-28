package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetParamEx2JsonSerdeTest {

    private static ObjectMapper sut;

    private static GetParamEx2.Request requestObj;
    private static GetParamEx2.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetParamEx2.Request.builder()
                .classCode("1")
                .secCode("2")
                .paramName("3")
                .build();

        final GetParamEx2.ParamEx2 paramEx = GetParamEx2.ParamEx2.builder()
                .paramType("1")
                .paramValue("2")
                .paramImage("3")
                .result("4")
                .build();

        resultObj = new GetParamEx2.Result(paramEx);

        requestJson =
                Resources.toString(Resources.getResource("json/getParamEx2.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/getParamEx2.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetParamEx2.Result actualResultObj = sut.readValue(resultJson, GetParamEx2.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
