package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HJsonSerdeTest {

    private static ObjectMapper sut;

    private static H.Request requestObj;
    private static H.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new H.Request("1", 2);

        resultObj = new H.Result("1");

        requestJson =
                Resources.toString(Resources.getResource("json/datasource.H.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/datasource.H.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final H.Result actualResultObj = sut.readValue(resultJson, H.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
