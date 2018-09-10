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

public class GetItemJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetItem.Request requestObj;
    private static String requestJson;

    private static GetItem.Result resultObj;
    private static String resultJson;

    private static GetClassInfo.Result resultObjWithOnlyRequiredFields;
    private static String resultJsonWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetItem.Request("1", 2);
        requestJson = Resources.toString(Resources.getResource("json/getItem.request.json"), Charsets.UTF_8);

        final ImmutableMap.Builder<String, String> tableRow = ImmutableMap.builder();
        tableRow.put("field_1", "value_1");
        tableRow.put("field_2", "value_2");
        tableRow.put("field_3", "value_3");
        tableRow.put("field_...", "value_...");
        tableRow.put("field_n", "value_n");

        resultObj = GetItem.Result.getInstance( tableRow.build() );
        resultJson = Resources.toString(Resources.getResource("json/getItem.result.json"), Charsets.UTF_8);

        resultObjWithOnlyRequiredFields = new GetClassInfo.Result(null);
        resultJsonWithOnlyRequiredFields =
                Resources.toString(Resources.getResource("json/getItem.result.only_required_fields.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {
        assertEquals(requestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj));
    }

    @Test
    public void testResultDeserialize() throws IOException {
        assertEquals(resultObj, sut.readValue(resultJson, GetItem.Result.class));
    }

    @Test
    public void testDeserializeResultWithOnlyRequiredFields() throws IOException {

        assertEquals(
                resultObjWithOnlyRequiredFields,
                sut.readValue(resultJsonWithOnlyRequiredFields, GetClassInfo.Result.class)
        );
    }
}
