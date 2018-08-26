package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SetCellJsonSerdeTest {

    private static ObjectMapper sut;

    private static SetCell.Request requestObj;
    private static SetCell.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = SetCell.Request.builder()
                .tId(1)
                .key(2)
                .code(3)
                .text("4")
                .value(5.55)
                .build();

        resultObj = new SetCell.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/SetCell.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/SetCell.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SetCell.Result actualResultObj = sut.readValue(resultJson, SetCell.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
