package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetWindowCaptionJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetWindowCaption.Request requestObj;
    private static String requestJson;

    private static GetWindowCaption.Result resultObj;
    private static String resultJson;

    private static GetWindowCaption.Result errorObj;
    private static String errorJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetWindowCaption.Request(1);
        requestJson = Resources.toString(Resources.getResource("json/GetWindowCaption.request.json"), Charsets.UTF_8);

        resultObj = GetWindowCaption.Result.getInstance("1");
        resultJson = Resources.toString(Resources.getResource("json/GetWindowCaption.result.json"), Charsets.UTF_8);

        errorObj = GetWindowCaption.Result.getErrorInstance();
        errorJson =
                Resources.toString(Resources.getResource("json/GetWindowCaption.result.error.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {
        assertEquals(requestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj));
    }

    @Test
    public void testResultDeserialize() throws IOException {
        assertEquals(resultObj, sut.readValue(resultJson, GetWindowCaption.Result.class));
    }

    @Test
    public void testDeserializeError() throws IOException {
        assertEquals(errorObj, sut.readValue(errorJson, GetWindowCaption.Result.class));
    }
}
