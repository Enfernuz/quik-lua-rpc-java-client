package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetLinesCountJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetLinesCount.Request requestObj;
    private static GetLinesCount.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetLinesCount.Request("1");

        resultObj = new GetLinesCount.Result(1);

        requestJson =
                Resources.toString(Resources.getResource("json/getLinesCount.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/getLinesCount.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetLinesCount.Result actualResultObj = sut.readValue(resultJson, GetLinesCount.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
