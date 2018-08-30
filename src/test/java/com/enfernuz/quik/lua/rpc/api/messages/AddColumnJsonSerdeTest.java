package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AddColumnJsonSerdeTest {

    private static ObjectMapper sut;

    private static AddColumn.Request requestObj;
    private static AddColumn.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = AddColumn.Request.builder()
                .tId(1)
                .iCode(2)
                .name("3")
                .isDefault(true)
                .parType(AddColumn.ColumnParameterType.QTABLE_INT64_TYPE)
                .width(6)
                .build();

        resultObj = new AddColumn.Result(1);

        requestJson =
                Resources.toString(Resources.getResource("json/AddColumn.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/AddColumn.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final AddColumn.Result actualResultObj = sut.readValue(resultJson, AddColumn.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
