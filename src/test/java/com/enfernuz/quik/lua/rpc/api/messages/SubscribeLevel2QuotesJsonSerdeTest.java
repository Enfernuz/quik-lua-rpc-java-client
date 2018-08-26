package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SubscribeLevel2QuotesJsonSerdeTest {

    private static ObjectMapper sut;

    private static SubscribeLevel2Quotes.Request requestObj;
    private static SubscribeLevel2Quotes.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = SubscribeLevel2Quotes.Request.builder()
                .classCode("1")
                .secCode("2")
                .build();

        resultObj = new SubscribeLevel2Quotes.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/Subscribe_Level_II_Quotes.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/Subscribe_Level_II_Quotes.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SubscribeLevel2Quotes.Result actualResultObj = sut.readValue(resultJson, SubscribeLevel2Quotes.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
