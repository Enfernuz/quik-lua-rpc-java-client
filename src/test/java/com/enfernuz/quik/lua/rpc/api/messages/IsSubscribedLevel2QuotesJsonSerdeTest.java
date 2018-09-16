package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class IsSubscribedLevel2QuotesJsonSerdeTest {

    private static ObjectMapper sut;

    private static IsSubscribedLevel2Quotes.Request requestObj;
    private static String requestJson;

    private static IsSubscribedLevel2Quotes.Result trueResultObj;
    private static String trueResultJson;

    private static IsSubscribedLevel2Quotes.Result falseResultObj;
    private static String falseResultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = IsSubscribedLevel2Quotes.Request.builder()
                .classCode("1")
                .secCode("2")
                .build();
        requestJson = Resources.toString(Resources.getResource("json/IsSubscribed_Level_II_Quotes.request.json"), Charsets.UTF_8);

        trueResultObj = IsSubscribedLevel2Quotes.Result.getInstance(true);
        trueResultJson = Resources.toString(Resources.getResource("json/IsSubscribed_Level_II_Quotes.result.true.json"), Charsets.UTF_8);

        falseResultObj = IsSubscribedLevel2Quotes.Result.getInstance(false);
        falseResultJson = Resources.toString(Resources.getResource("json/IsSubscribed_Level_II_Quotes.result.false.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {
        assertEquals(requestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj));
    }

    @Test
    public void testTrueResultDeserialize() throws IOException {
        assertEquals(trueResultObj, sut.readValue(trueResultJson, IsSubscribedLevel2Quotes.Result.class));
    }

    @Test
    public void testFalseResultDeserialize() throws IOException {
        assertEquals(falseResultObj, sut.readValue(falseResultJson, IsSubscribedLevel2Quotes.Result.class));
    }
}
