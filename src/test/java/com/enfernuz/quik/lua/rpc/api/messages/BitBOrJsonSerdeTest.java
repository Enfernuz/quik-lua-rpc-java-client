package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BOr;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BitBOrJsonSerdeTest {

    private static ObjectMapper sut;

    private static BOr.Request fullArgsRequestObject;
    private static BOr.Request requiredArgsRequestObject;
    private static BOr.Result resultObj;
    private static String fullArgsRequestJson;
    private static String requiredArgsRequestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        fullArgsRequestObject = BOr.Request.builder()
                .x1(1)
                .x2(2)
                .xi(new int[] {3, 5, 7, 9})
                .build();

        requiredArgsRequestObject = BOr.Request.builder()
                .x1(1)
                .x2(2)
                .build();

        resultObj = new BOr.Result(1);

        fullArgsRequestJson =
                Resources.toString(Resources.getResource("json/bit.bor.request_full_args.json"), Charsets.UTF_8);
        requiredArgsRequestJson =
                Resources.toString(Resources.getResource("json/bit.bor.request_required_args.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/bit.bor.result.json"), Charsets.UTF_8);
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

        final BOr.Result actualResultObj = sut.readValue(resultJson, BOr.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
