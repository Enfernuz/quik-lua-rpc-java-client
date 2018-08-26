package com.enfernuz.quik.lua.rpc.api.messages.bit;

import com.enfernuz.quik.lua.rpc.api.messages.bit.ToHex;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ToHexJsonSerdeTest {

    private static ObjectMapper sut;

    private static ToHex.Request requestObj;
    private static ToHex.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = ToHex.Request.builder()
                .x(1)
                .n(2)
                .build();

        resultObj = new ToHex.Result("1");

        requestJson =
                Resources.toString(Resources.getResource("json/bit.tohex.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/bit.tohex.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final ToHex.Result actualResultObj = sut.readValue(resultJson, ToHex.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
