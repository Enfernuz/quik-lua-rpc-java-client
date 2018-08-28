package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CloseJsonSerdeTest {

    private static ObjectMapper sut;

    private static Close.Request requestObj;
    private static Close.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new Close.Request("1");

        resultObj = new Close.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/datasource.Close.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/datasource.Close.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final Close.Result actualResultObj = sut.readValue(resultJson, Close.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
