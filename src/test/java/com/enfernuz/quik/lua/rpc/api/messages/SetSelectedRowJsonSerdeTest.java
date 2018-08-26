package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SetSelectedRowJsonSerdeTest {

    private static ObjectMapper sut;

    private static SetSelectedRow.Request requestObj;
    private static SetSelectedRow.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = SetSelectedRow.Request.builder()
                .tableId(1)
                .row(2)
                .build();

        resultObj = new SetSelectedRow.Result(1);

        requestJson =
                Resources.toString(Resources.getResource("json/SetSelectedRow.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/SetSelectedRow.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SetSelectedRow.Result actualResultObj = sut.readValue(resultJson, SetSelectedRow.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}