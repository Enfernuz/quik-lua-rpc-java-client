package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SetWindowPosJsonSerdeTest {

    private static ObjectMapper sut;

    private static SetWindowPos.Request requestObj;
    private static SetWindowPos.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = SetWindowPos.Request.builder()
                .tId(1)
                .x(2)
                .y(3)
                .dx(4)
                .dy(5)
                .build();

        resultObj = new SetWindowPos.Result(true);

        requestJson =
                Resources.toString(Resources.getResource("json/SetWindowPos.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/SetWindowPos.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final SetWindowPos.Result actualResultObj = sut.readValue(resultJson, SetWindowPos.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
