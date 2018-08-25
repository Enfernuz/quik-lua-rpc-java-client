package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2.QuoteEntry;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetQuoteLevel2JsonSerdeTest {

    private static ObjectMapper sut;

    private static GetQuoteLevel2.Request requestObj;
    private static GetQuoteLevel2.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetQuoteLevel2.Request.builder()
                .classCode("1")
                .secCode("2")
                .build();

        final List<QuoteEntry> bids =
                ImmutableList.of(
                        QuoteEntry.builder().price("100").quantity("42").build(),
                        QuoteEntry.builder().price("200").quantity("20").build(),
                        QuoteEntry.builder().price("300").quantity("1").build()
                );

        final List<QuoteEntry> offers =
                ImmutableList.of(
                        QuoteEntry.builder().price("350").quantity("25").build(),
                        QuoteEntry.builder().price("999").quantity("5000").build()
                );

        resultObj = GetQuoteLevel2.Result.builder()
                .bidCount("3")
                .offerCount("2")
                .bids(bids)
                .offers(offers)
                .build();

        requestJson =
                Resources.toString(Resources.getResource("json/getQuoteLevel2.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/getQuoteLevel2.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetQuoteLevel2.Result actualResultObj = sut.readValue(resultJson, GetQuoteLevel2.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
