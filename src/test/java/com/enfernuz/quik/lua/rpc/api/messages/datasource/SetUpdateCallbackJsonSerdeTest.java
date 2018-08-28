package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SetUpdateCallbackJsonSerdeTest {

    private static ObjectMapper sut;

    private static SetUpdateCallback.Request requestObj;
    private static SetUpdateCallback.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = SetUpdateCallback.Request.builder()
                .datasourceUUID("1")
                .fCbDef("2")
                .build();

        resultObj = new SetUpdateCallback.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/datasource.SetUpdateCallback.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/datasource.SetUpdateCallback.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SetUpdateCallback.Result actualResultObj = sut.readValue(resultJson, SetUpdateCallback.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
