package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SetTableNotificationCallbackJsonSerdeTest {

    private static ObjectMapper sut;

    private static SetTableNotificationCallback.Request requestObj;
    private static SetTableNotificationCallback.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new SetTableNotificationCallback.Request(1, "2");

        resultObj = new SetTableNotificationCallback.Result(1);

        requestJson =
                Resources.toString(Resources.getResource("json/SetTableNotificationCallback.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/SetTableNotificationCallback.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SetTableNotificationCallback.Result actualResultObj = sut.readValue(resultJson, SetTableNotificationCallback.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
