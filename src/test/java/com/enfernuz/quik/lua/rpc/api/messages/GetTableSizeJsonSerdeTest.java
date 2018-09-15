package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetTableSizeJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetTableSize.Request requestObj;
    private static String requestJson;

    private static GetTableSize.Result resultObj;
    private static String resultJson;

    private static GetTableSize.Result errorObj;
    private static String errorJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetTableSize.Request(1);
        requestJson = Resources.toString(Resources.getResource("json/GetTableSize.request.json"), Charsets.UTF_8);

        final GetTableSize.TableSize tableSize = GetTableSize.TableSize.builder()
                .rows(1)
                .col(2)
                .build();
        resultObj = GetTableSize.Result.getInstance(tableSize);
        resultJson = Resources.toString(Resources.getResource("json/GetTableSize.result.json"), Charsets.UTF_8);

        errorObj = GetTableSize.Result.getErrorInstance();
        errorJson =
                Resources.toString(Resources.getResource("json/GetTableSize.result.error.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {
        assertEquals(requestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj));
    }

    @Test
    public void testResultDeserialize() throws IOException {
        assertEquals(resultObj, sut.readValue(resultJson, GetTableSize.Result.class));
    }

    @Test
    public void testDeserializeError() throws IOException {
        assertEquals(errorObj, sut.readValue(errorJson, GetTableSize.Result.class));
    }
}
