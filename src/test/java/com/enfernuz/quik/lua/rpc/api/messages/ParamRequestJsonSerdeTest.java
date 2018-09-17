package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParamRequestJsonSerdeTest {

    private static final ObjectMapper SUT = getSUT();

    private static final ParamRequest.Request OBJ_REQUEST = getObjOfRequest();
    private static final String JSON_REQUEST = getJson("json/ParamRequest/request.json");

    private static final ParamRequest.Result OBJ_TRUE_RESULT = getObjOfTrueResult();
    private static final String JSON_TRUE_RESULT = getJson("json/ParamRequest/result.true.json");

    private static final ParamRequest.Result OBJ_FALSE_RESULT = getObjOfFalseResult();
    private static final String JSON_FALSE_RESULT = getJson("json/ParamRequest/result.false.json");

    private static final Class<ParamRequest.Result> RESULT_CLASS = ParamRequest.Result.class;

    private static final String JSON_RESULT_MISSING_FIELD_IS_CONNECTED = getJson("json/ParamRequest/result.missing.result.json");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldSerialize_ObjectOf_Request_To_JsonOf_Request() throws IOException {
        assertEquals(JSON_REQUEST, SUT.writerWithDefaultPrettyPrinter().writeValueAsString(OBJ_REQUEST));
    }

    @Test
    public void shouldDeserialize_JsonOf_TrueResult_To_ObjectOf_TrueResult() throws IOException {
        assertEquals(OBJ_TRUE_RESULT, SUT.readValue(JSON_TRUE_RESULT, RESULT_CLASS));
    }

    @Test
    public void shouldDeserialize_JsonOf_FalseResult_To_ObjectOf_FalseResult() throws IOException {
        assertEquals(OBJ_FALSE_RESULT, SUT.readValue(JSON_FALSE_RESULT, RESULT_CLASS));
    }

    @Test
    public void shouldFailOn_deserializationOf_JsonOf_Result_WithMissingField_IsConnected() throws IOException {

        thrown.expect(MismatchedInputException.class);
        thrown.expectMessage(Matchers.containsString("Missing required creator property 'result'"));

        SUT.readValue(JSON_RESULT_MISSING_FIELD_IS_CONNECTED, RESULT_CLASS);
    }

    private static ObjectMapper getSUT() {

        final ObjectMapper result = new ObjectMapper();
        result.registerModule(new QluaJsonModule());

        return result;
    }

    private static ParamRequest.Request getObjOfRequest() {

        return ParamRequest.Request.builder()
                .classCode("1")
                .secCode("2")
                .dbName("3")
                .build();
    }

    private static ParamRequest.Result getObjOfFalseResult() {
        return ParamRequest.Result.getInstance(false);
    }

    private static ParamRequest.Result getObjOfTrueResult() {
        return ParamRequest.Result.getInstance(true);
    }

    @SneakyThrows(IOException.class)
    private static final String getJson(final String resourcePath) {
        return Resources.toString(Resources.getResource(resourcePath), Charsets.UTF_8);
    }
}
