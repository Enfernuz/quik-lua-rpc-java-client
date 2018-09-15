package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetWindowRectJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetWindowRect.Request requestObj;
    private static String requestJson;

    private static GetWindowRect.Result resultObj;
    private static String resultJson;

    private static GetWindowRect.Result errorObj;
    private static String errorJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetWindowRect.Request(1);
        requestJson = Resources.toString(Resources.getResource("json/GetWindowRect.request.json"), Charsets.UTF_8);

        final GetWindowRect.WindowRect windowRect = GetWindowRect.WindowRect.builder()
                .top(1)
                .left(2)
                .bottom(3)
                .right(4)
                .build();
        resultObj = GetWindowRect.Result.getInstance(windowRect);
        resultJson = Resources.toString(Resources.getResource("json/GetWindowRect.result.json"), Charsets.UTF_8);

        errorObj = GetWindowRect.Result.getErrorInstance();
        errorJson =
                Resources.toString(Resources.getResource("json/GetWindowRect.result.error.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {
        assertEquals(requestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj));
    }

    @Test
    public void testResultDeserialize() throws IOException {
        assertEquals(resultObj, sut.readValue(resultJson, GetWindowRect.Result.class));
    }

    @Test
    public void testDeserializeError() throws IOException {
        assertEquals(errorObj, sut.readValue(errorJson, GetWindowRect.Result.class));
    }
}
