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
    private static GetLabelParams.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new GetLabelParams.Request("1", 2);

        final ImmutableMap.Builder<String, String> labelParams = ImmutableMap.builder();
        labelParams.put("param_1", "value_1");
        labelParams.put("param_2", "value_2");
        labelParams.put("param_3", "value_3");
        labelParams.put("param_...", "value_...");
        labelParams.put("param_n", "value_n");

        resultObj = new GetLabelParams.Result( labelParams.build() );

        requestJson =
                Resources.toString(Resources.getResource("json/GetLabelParams.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/GetLabelParams.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetLabelParams.Result actualResultObj = sut.readValue(resultJson, GetLabelParams.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
