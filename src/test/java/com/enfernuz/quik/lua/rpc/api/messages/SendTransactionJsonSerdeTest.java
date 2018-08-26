package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SendTransactionJsonSerdeTest {

    private static ObjectMapper sut;

    private static SendTransaction.Request requestObj;
    private static SendTransaction.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new SendTransaction.Request(
                ImmutableMap.of(
                        "key_1", "value_1",
                        "key_2", "value_2",
                        "key_3", "value_3"
                )
        );

        resultObj = new SendTransaction.Result("1");

        requestJson =
                Resources.toString(Resources.getResource("json/sendTransaction.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/sendTransaction.result.json"), Charsets.UTF_8);
    }

    // The test might appear to be flaky though, as the map's iteration order is not strictly defined...
    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SendTransaction.Result actualResultObj = sut.readValue(resultJson, SendTransaction.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
