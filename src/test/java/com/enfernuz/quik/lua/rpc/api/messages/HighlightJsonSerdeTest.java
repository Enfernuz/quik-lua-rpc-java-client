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
    private static String requestJson;

    private static Highlight.Result trueObj;
    private static String trueJson;

    private static Highlight.Result falseObj;
    private static String falseJson;

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
        requestJson = Resources.toString(Resources.getResource("json/Highlight.request.json"), Charsets.UTF_8);

        trueObj = Highlight.Result.getInstance(true);
        trueJson = Resources.toString(Resources.getResource("json/Highlight.result.true.json"), Charsets.UTF_8);

        falseObj = Highlight.Result.getInstance(false);
        falseJson = Resources.toString(Resources.getResource("json/Highlight.result.false.json"), Charsets.UTF_8);
    }

    @Test
    public void testSerialize_Request() throws IOException {
        assertEquals(requestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj));
    }

    @Test
    public void testDeserialize_TrueResult() throws IOException {
        assertEquals(trueObj, sut.readValue(trueJson, Highlight.Result.class));
    }

    @Test
    public void testDeserialize_FalseResult() throws IOException {
        assertEquals(falseObj, sut.readValue(falseJson, Highlight.Result.class));
    }
}
