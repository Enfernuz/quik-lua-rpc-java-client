package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.enfernuz.quik.lua.rpc.api.structures.GetItem;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetItemJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetItem.Request requestObj;
    private static GetItem.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetItem.Request("1", 2);

        final ImmutableMap.Builder<String, String> tableRow = ImmutableMap.builder();
        tableRow.put("field_1", "value_1");
        tableRow.put("field_2", "value_2");
        tableRow.put("field_3", "value_3");
        tableRow.put("field_...", "value_...");
        tableRow.put("field_n", "value_n");

        resultObj = new GetItem.Result( tableRow.build() );

        requestJson =
                Resources.toString(Resources.getResource("getItem.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("getItem.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetItem.Result actualResultObj = sut.readValue(resultJson, GetItem.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
