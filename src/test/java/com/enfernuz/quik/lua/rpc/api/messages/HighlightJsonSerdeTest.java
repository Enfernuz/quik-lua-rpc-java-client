package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HighlightJsonSerdeTest {

    private static ObjectMapper sut;

    private static Highlight.Request requestObj;
    private static Highlight.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = Highlight.Request.builder()
                .tId(1)
                .row(2)
                .col(3)
                .bColor(4)
                .fColor(5)
                .timeout(6)
                .build();

        resultObj = new Highlight.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/Highlight.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/Highlight.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final Highlight.Result actualResultObj = sut.readValue(resultJson, Highlight.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
