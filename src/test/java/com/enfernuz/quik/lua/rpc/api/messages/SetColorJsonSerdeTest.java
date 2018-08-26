package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SetColorJsonSerdeTest {

    private static ObjectMapper sut;

    private static SetColor.Request requestObj;
    private static SetColor.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = SetColor.Request.builder()
                .tId(1)
                .row(2)
                .col(3)
                .bColor(4)
                .fColor(5)
                .selBColor(6)
                .selFColor(7)
                .build();

        resultObj = new SetColor.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/SetColor.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/SetColor.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SetColor.Result actualResultObj = sut.readValue(resultJson, SetColor.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
