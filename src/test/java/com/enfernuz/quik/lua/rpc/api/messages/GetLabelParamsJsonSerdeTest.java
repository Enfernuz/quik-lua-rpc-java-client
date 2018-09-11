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

public class GetLabelParamsJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetLabelParams.Request requestObj;
    private static String requestJson;

    private static GetLabelParams.Result resultObj;
    private static String resultJson;

    private static GetLabelParams.Result resultObjWithOnlyRequiredFields;
    private static String resultJsonWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetLabelParams.Request("1", 2);
        requestJson = Resources.toString(Resources.getResource("json/GetLabelParams.request.json"), Charsets.UTF_8);

        final ImmutableMap.Builder<String, String> labelParams = ImmutableMap.builder();
        labelParams.put("param_1", "value_1");
        labelParams.put("param_2", "value_2");
        labelParams.put("param_3", "value_3");
        labelParams.put("param_...", "value_...");
        labelParams.put("param_n", "value_n");

        resultObj = GetLabelParams.Result.getInstance( labelParams.build() );
        resultJson = Resources.toString(Resources.getResource("json/GetLabelParams.result.json"), Charsets.UTF_8);

        resultObjWithOnlyRequiredFields = GetLabelParams.Result.getInstance(null);
        resultJsonWithOnlyRequiredFields =
                Resources.toString(Resources.getResource("json/GetLabelParams.result.only_required_fields.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {
        assertEquals(requestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj));
    }

    @Test
    public void testResultDeserialize() throws IOException {
        assertEquals(resultObj, sut.readValue(resultJson, GetLabelParams.Result.class));
    }

    @Test
    public void testDeserializeResultWithOnlyRequiredFields() throws IOException {

        assertEquals(
                resultObjWithOnlyRequiredFields,
                sut.readValue(resultJsonWithOnlyRequiredFields, GetLabelParams.Result.class)
        );
    }
}
