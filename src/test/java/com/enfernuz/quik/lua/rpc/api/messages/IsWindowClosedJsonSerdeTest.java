package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class IsWindowClosedJsonSerdeTest {

    private static ObjectMapper sut;

    private static IsWindowClosed.Request requestObj;
    private static IsWindowClosed.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new IsWindowClosed.Request(1);

        resultObj = new IsWindowClosed.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/IsWindowClosed.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/IsWindowClosed.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final IsWindowClosed.Result actualResultObj = sut.readValue(resultJson, IsWindowClosed.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
