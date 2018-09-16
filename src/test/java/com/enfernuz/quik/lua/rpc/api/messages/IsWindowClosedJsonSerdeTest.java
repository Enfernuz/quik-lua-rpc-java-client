package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class IsWindowClosedJsonSerdeTest {

    private static ObjectMapper sut;

    private static IsWindowClosed.Request requestObj;
    private static String requestJson;

    private static IsWindowClosed.Result trueResultObj;
    private static String trueResultJson;

    private static IsWindowClosed.Result falseResultObj;
    private static String falseResultJson;

    private static IsWindowClosed.Result errorResultObj;
    private static String errorResultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new IsWindowClosed.Request(1);
        requestJson = Resources.toString(Resources.getResource("json/IsWindowClosed.request.json"), Charsets.UTF_8);

        trueResultObj = IsWindowClosed.Result.getInstance( IsWindowClosed.WindowClosed.getInstance(true) );
        trueResultJson = Resources.toString(Resources.getResource("json/IsWindowClosed.result.true.json"), Charsets.UTF_8);

        falseResultObj = IsWindowClosed.Result.getInstance( IsWindowClosed.WindowClosed.getInstance(false) );
        falseResultJson = Resources.toString(Resources.getResource("json/IsWindowClosed.result.false.json"), Charsets.UTF_8);

        errorResultObj = IsWindowClosed.Result.getErrorInstance();
        errorResultJson = Resources.toString(Resources.getResource("json/IsWindowClosed.result.error.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {
        assertEquals(requestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj));
    }

    @Test
    public void testTrueResultDeserialize() throws IOException {
        assertEquals(trueResultObj, sut.readValue(trueResultJson, IsWindowClosed.Result.class));
    }

    @Test
    public void testFalseResultDeserialize() throws IOException {
        assertEquals(falseResultObj, sut.readValue(falseResultJson, IsWindowClosed.Result.class));
    }

    @Test
    public void testErrorResultDeserialize() throws IOException {
        assertEquals(errorResultObj, sut.readValue(errorResultJson, IsWindowClosed.Result.class));
    }
}
