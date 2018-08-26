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

public class SetLabelParamsJsonSerdeTest {

    private static ObjectMapper sut;

    private static SetLabelParams.Request requestObj;
    private static SetLabelParams.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = SetLabelParams.Request.builder()
                .chartTag("1")
                .labelId(2)
                .labelParams(
                        ImmutableMap.of(
                        "key_1", "value_1",
                        "key_2", "value_2",
                        "key_3", "value_3")
                )
                .build();

        resultObj = new SetLabelParams.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/SetLabelParams.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/SetLabelParams.result.json"), Charsets.UTF_8);
    }

    // The test might appear to be flaky though, as the map's iteration order is not strictly defined...
    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SetLabelParams.Result actualResultObj = sut.readValue(resultJson, SetLabelParams.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
