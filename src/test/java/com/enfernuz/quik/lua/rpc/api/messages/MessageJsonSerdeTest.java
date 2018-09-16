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
    private static String fullArgsRequestJson;

    private static Message.Request requiredArgsRequestObject;
    private static String requiredArgsRequestJson;

    private static Message.Result okResultObj;
    private static String okResultJson;

    private static Message.Result notOkResultObj;
    private static String notOkResultJson;

    private static Message.Result errorResultObj;
    private static String errorResultJson;


    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        fullArgsRequestObject = new Message.Request("1", Message.IconType.WARNING);
        fullArgsRequestJson = Resources.toString(Resources.getResource("json/message.request_full_args.json"), Charsets.UTF_8);

        requiredArgsRequestObject = new Message.Request("1");
        requiredArgsRequestJson = Resources.toString(Resources.getResource("json/message.request_required_args.json"), Charsets.UTF_8);

        okResultObj = Message.Result.getInstance( Message.MessageResult.getOkInstance() );
        okResultJson = Resources.toString(Resources.getResource("json/message.result.ok.json"), Charsets.UTF_8);

        notOkResultObj = Message.Result.getInstance( Message.MessageResult.getInstance(789) );
        notOkResultJson = Resources.toString(Resources.getResource("json/message.result.not_ok.json"), Charsets.UTF_8);

        errorResultObj = Message.Result.getErrorInstance();
        errorResultJson = Resources.toString(Resources.getResource("json/message.result.error.json"), Charsets.UTF_8);
    }

    @Test
    public void testFullArgsRequestSerialize() throws IOException {
        assertEquals(fullArgsRequestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(fullArgsRequestObject));
    }

    @Test
    public void testRequiredArgsRequestSerialize() throws IOException {
        assertEquals(requiredArgsRequestJson, sut.writerWithDefaultPrettyPrinter().writeValueAsString(requiredArgsRequestObject));
    }

    @Test
    public void testDeserializeOkResult() throws IOException {
        assertEquals(okResultObj, sut.readValue(okResultJson, Message.Result.class));
    }

    @Test
    public void testDeserializeNotOkResult() throws IOException {
        assertEquals(notOkResultObj, sut.readValue(notOkResultJson, Message.Result.class));
    }

    @Test
    public void testDeserializeErrorResult() throws IOException {
        assertEquals(errorResultObj, sut.readValue(errorResultJson, Message.Result.class));
    }
}
