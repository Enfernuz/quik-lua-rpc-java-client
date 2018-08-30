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

public class AddLabelJsonSerdeTest {

    private static ObjectMapper sut;

    private static AddLabel.Request requestObj;
    private static AddLabel.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = AddLabel.Request.builder()
                .chartTag("1")
                .labelParams(ImmutableMap.of(
                        "key1", "value1",
                        "key2", "value2",
                        "key3", "value3"
                ))
                .build();

        resultObj = new AddLabel.Result(1);

        requestJson =
                Resources.toString(Resources.getResource("json/AddLabel.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/AddLabel.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final AddLabel.Result actualResultObj = sut.readValue(resultJson, AddLabel.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
