package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MessageJsonSerdeTest {

    private static ObjectMapper sut;

    private static Message.Request fullArgsRequestObject;
    private static Message.Request requiredArgsRequestObject;
    private static Message.Result resultObj;
    private static String fullArgsRequestJson;
    private static String requiredArgsRequestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        fullArgsRequestObject = new Message.Request("1", Message.IconType.WARNING);
        requiredArgsRequestObject = new Message.Request("1");

        resultObj = new Message.Result(1);

        fullArgsRequestJson =
                Resources.toString(Resources.getResource("json/message.request_full_args.json"), Charsets.UTF_8);
        requiredArgsRequestJson =
                Resources.toString(Resources.getResource("json/message.request_required_args.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/message.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testFullArgsRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(fullArgsRequestObject);

        assertEquals(fullArgsRequestJson, actualRequestJson);
    }

    @Test
    public void testRequiredArgsRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requiredArgsRequestObject);

        assertEquals(requiredArgsRequestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final Message.Result actualResultObj = sut.readValue(resultJson, Message.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
