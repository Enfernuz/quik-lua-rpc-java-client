package com.enfernuz.quik.lua.rpc.api.messages.bit;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BXorJsonSerdeTest {

    private static ObjectMapper sut;

    private static BXor.Request fullArgsRequestObject;
    private static BXor.Request requiredArgsRequestObject;
    private static BXor.Result resultObj;
    private static String fullArgsRequestJson;
    private static String requiredArgsRequestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        fullArgsRequestObject = BXor.Request.builder()
                .x1(1)
                .x2(2)
                .xi(new int[] {3, 5, 7, 9})
                .build();

        requiredArgsRequestObject = BXor.Request.builder()
                .x1(1)
                .x2(2)
                .build();

        resultObj = new BXor.Result(1);

        fullArgsRequestJson =
                Resources.toString(Resources.getResource("json/bit.bxor.request_full_args.json"), Charsets.UTF_8);
        requiredArgsRequestJson =
                Resources.toString(Resources.getResource("json/bit.bxor.request_required_args.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/bit.bxor.result.json"), Charsets.UTF_8);
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

        final BXor.Result actualResultObj = sut.readValue(resultJson, BXor.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
