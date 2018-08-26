package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BitTestJsonSerdeTest {

    private static ObjectMapper sut;

    private static com.enfernuz.quik.lua.rpc.api.messages.bit.Test.Request requestObj;
    private static com.enfernuz.quik.lua.rpc.api.messages.bit.Test.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = com.enfernuz.quik.lua.rpc.api.messages.bit.Test.Request.builder()
                .x(1)
                .n(2)
                .build();

        resultObj = new com.enfernuz.quik.lua.rpc.api.messages.bit.Test.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/bit.test.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/bit.test.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final com.enfernuz.quik.lua.rpc.api.messages.bit.Test.Result actualResultObj =
                sut.readValue(resultJson, com.enfernuz.quik.lua.rpc.api.messages.bit.Test.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
