package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LJsonSerdeTest {

    private static ObjectMapper sut;

    private static L.Request requestObj;
    private static L.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new L.Request("1", 2);

        resultObj = new L.Result("1");

        requestJson =
                Resources.toString(Resources.getResource("json/datasource.L.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/datasource.L.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final L.Result actualResultObj = sut.readValue(resultJson, L.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
