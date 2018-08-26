package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SearchItemsJsonSerdeTest {

    private static ObjectMapper sut;

    private static SearchItems.Request fullArgsRequestObject;
    private static SearchItems.Request requiredArgsRequestObject;
    private static SearchItems.Result resultObj;
    private static String fullArgsRequestJson;
    private static String requiredArgsRequestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        fullArgsRequestObject = SearchItems.Request.builder()
                .tableName("1")
                .startIndex(2)
                .endIndex(3)
                .fnDef("4")
                .params("5")
                .build();

        requiredArgsRequestObject = SearchItems.Request.builder()
                .tableName("1")
                .startIndex(2)
                .endIndex(3)
                .fnDef("4")
                .build();

        resultObj = new SearchItems.Result(new int[] {1, 3, 5, 7, 9});

        fullArgsRequestJson =
                Resources.toString(Resources.getResource("json/SearchItems.request_full_args.json"), Charsets.UTF_8);
        requiredArgsRequestJson =
                Resources.toString(Resources.getResource("json/SearchItems.request_required_args.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/SearchItems.result.json"), Charsets.UTF_8);
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

        final SearchItems.Result actualResultObj = sut.readValue(resultJson, SearchItems.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}