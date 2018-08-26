package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CreateDataSourceJsonSerdeTest {

    private static ObjectMapper sut;

    private static CreateDataSource.Request fullArgsRequestObject;
    private static CreateDataSource.Request requiredArgsRequestObject;
    private static CreateDataSource.Result successResultObj;
    private static CreateDataSource.Result errorResultObj;
    private static String fullArgsRequestJson;
    private static String requiredArgsRequestJson;
    private static String successResultJson;
    private static String errorResultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        fullArgsRequestObject = CreateDataSource.Request.builder()
                .classCode("1")
                .secCode("2")
                .interval(CreateDataSource.Interval.INTERVAL_M5)
                .param("4")
                .build();

        requiredArgsRequestObject = CreateDataSource.Request.builder()
                .classCode("1")
                .secCode("2")
                .interval(CreateDataSource.Interval.INTERVAL_M5)
                .build();

        successResultObj = CreateDataSource.Result.builder()
                .datasourceUUID("1")
                .error(false)
                .build();

        errorResultObj = CreateDataSource.Result.builder()
                .error(true)
                .errorDesc("2")
                .build();

        fullArgsRequestJson =
                Resources.toString(Resources.getResource("json/datasource.CreateDataSource.request_full_args.json"), Charsets.UTF_8);
        requiredArgsRequestJson =
                Resources.toString(Resources.getResource("json/datasource.CreateDataSource.request_required_args.json"), Charsets.UTF_8);
        successResultJson =
                Resources.toString(Resources.getResource("json/datasource.CreateDataSource.result_success.json"), Charsets.UTF_8);
        errorResultJson =
                Resources.toString(Resources.getResource("json/datasource.CreateDataSource.result_error.json"), Charsets.UTF_8);
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
    public void testSuccessResultDeserialize() throws IOException {

        final CreateDataSource.Result actualResultObj = sut.readValue(successResultJson, CreateDataSource.Result.class);

        assertEquals(successResultObj, actualResultObj);
    }

    @Test
    public void testErrorResultDeserialize() throws IOException {

        final CreateDataSource.Result actualResultObj = sut.readValue(errorResultJson, CreateDataSource.Result.class);

        assertEquals(errorResultObj, actualResultObj);
    }
}
