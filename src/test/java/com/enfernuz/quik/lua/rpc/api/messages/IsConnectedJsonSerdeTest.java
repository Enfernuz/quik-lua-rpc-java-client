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

public class IsConnectedJsonSerdeTest {

    private static final ObjectMapper SUT = getSUT();

    private static final IsConnected.Request OBJ_REQUEST = IsConnected.Request.INSTANCE;
    private static final String JSON_REQUEST = getJson("json/isConnected/request.json");

    private static final IsConnected.Result OBJ_TRUE_RESULT = getObjOfTrueResult();
    private static final String JSON_TRUE_RESULT = getJson("json/isConnected/result.true.json");

    private static final IsConnected.Result OBJ_FALSE_RESULT = getObjOfFalseResult();
    private static final String JSON_FALSE_RESULT = getJson("json/isConnected/result.false.json");

    private static final IsConnected.Result OBJ_GARBAGE_RESULT = getObjOfGarbageResult();
    private static final String JSON_GARBAGE_RESULT = getJson("json/isConnected/result.garbage.json");

    private static final String JSON_RESULT_MISSING_FIELD_IS_CONNECTED = getJson("json/isConnected/result.missing.is_connected.json");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldSerialize_ObjectOf_Request_To_JsonOf_Request() throws IOException {
        assertEquals(JSON_REQUEST, SUT.writerWithDefaultPrettyPrinter().writeValueAsString(OBJ_REQUEST));
    }

    @Test
    public void shouldDeserialize_JsonOf_TrueResult_To_ObjectOf_TrueResult() throws IOException {
        assertEquals(OBJ_TRUE_RESULT, SUT.readValue(JSON_TRUE_RESULT, IsConnected.Result.class));
    }

    @Test
    public void shouldDeserialize_JsonOf_FalseResult_To_ObjectOf_FalseResult() throws IOException {
        assertEquals(OBJ_FALSE_RESULT, SUT.readValue(JSON_FALSE_RESULT, IsConnected.Result.class));
    }

    @Test
    public void shouldDeserialize_JsonOf_GarbageResult_To_ObjectOf_GarbageResult() throws IOException {
        assertEquals(OBJ_GARBAGE_RESULT, SUT.readValue(JSON_GARBAGE_RESULT, IsConnected.Result.class));
    }

    @Test
    public void shouldFailOn_deserializationOf_JsonOf_Result_WithMissingField_IsConnected() throws IOException {

        thrown.expect(MismatchedInputException.class);
        thrown.expectMessage(Matchers.containsString("Missing required creator property 'is_connected'"));

        SUT.readValue(JSON_RESULT_MISSING_FIELD_IS_CONNECTED, IsConnected.Result.class);
    }

    private static ObjectMapper getSUT() {

        final ObjectMapper result = new ObjectMapper();
        result.registerModule(new QluaJsonModule());

        return result;
    }

    private static IsConnected.Result getObjOfGarbageResult() {
        return IsConnected.Result.getInstance(123);
    }

    private static IsConnected.Result getObjOfFalseResult() {
        return IsConnected.Result.getInstance(0);
    }

    private static IsConnected.Result getObjOfTrueResult() {
        return IsConnected.Result.getInstance(1);
    }

    @SneakyThrows(IOException.class)
    private static final String getJson(final String resourcePath) {
        return Resources.toString(Resources.getResource(resourcePath), Charsets.UTF_8);
    }
}
