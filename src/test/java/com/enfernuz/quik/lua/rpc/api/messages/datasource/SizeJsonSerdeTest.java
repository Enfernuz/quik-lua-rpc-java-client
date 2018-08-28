package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SizeJsonSerdeTest {

    private static ObjectMapper sut;

    private static Size.Request requestObj;
    private static Size.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new Size.Request("1");

        resultObj = new Size.Result(1);

        requestJson =
                Resources.toString(Resources.getResource("json/datasource.Size.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/datasource.Size.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final Size.Result actualResultObj = sut.readValue(resultJson, Size.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
