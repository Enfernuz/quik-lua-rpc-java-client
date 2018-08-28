package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TJsonSerdeTest {

    private static ObjectMapper sut;

    private static T.Request requestObj;
    private static T.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = new T.Request("1", 2);

        resultObj = T.Result.builder()
                .year(1)
                .month(2)
                .day(3)
                .weekDay(4)
                .hour(5)
                .min(6)
                .sec(7)
                .ms(8)
                .count(9)
                .build();

        requestJson =
                Resources.toString(Resources.getResource("json/datasource.T.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/datasource.T.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final T.Result actualResultObj = sut.readValue(resultJson, T.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
