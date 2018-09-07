package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.api.structures.ResponseEnvelope;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResponseEnvelopePbSerdeTest {

    private static SerdeModule sut;

    private static ResponseEnvelope expectedObjectWithError;
    private static byte[] expectedPbInputForObjectWithError;

    private static ResponseEnvelope expectedObjectWithResult;
    private static byte[] expectedPbInputForObjectWithResult;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObjectWithError = ResponseEnvelope.withError(new ServiceError(1, "2"));
        final ByteString pbError = qlua.rpc.RPC.Error.newBuilder()
                .setCode(1)
                .setMessage("2")
                .build()
                .toByteString();
        expectedPbInputForObjectWithError = qlua.rpc.RPC.Response.newBuilder()
                .setIsError(true)
                .setResult(pbError)
                .build()
                .toByteArray();

        final byte[] data = "some data".getBytes(StandardCharsets.UTF_8);
        expectedObjectWithResult = ResponseEnvelope.withResult(data);
        expectedPbInputForObjectWithResult = qlua.rpc.RPC.Response.newBuilder()
                .setResult( ByteString.copyFrom(data) )
                .build()
                .toByteArray();
    }

    @Test
    public void testSerializeResponseEnvelopeWithError() {

        final byte[] actual = sut.serialize(expectedObjectWithError);

        assertTrue( Arrays.equals(expectedPbInputForObjectWithError, actual) );
    }

    @Test
    public void testSerializeResponseEnvelopeWithResult() {

        final byte[] actual = sut.serialize(expectedObjectWithResult);

        assertTrue( Arrays.equals(expectedPbInputForObjectWithResult, actual) );
    }

    @Test
    public void testDeserializePbResponseWithError() {

        final ResponseEnvelope actualObject = sut.deserialize(ResponseEnvelope.class, expectedPbInputForObjectWithError);

        assertEquals(actualObject, expectedObjectWithError);
    }

    @Test
    public void testDeserializePbResponseWithResult() {

        final ResponseEnvelope actualObject = sut.deserialize(ResponseEnvelope.class, expectedPbInputForObjectWithResult);

        assertEquals(actualObject, expectedObjectWithResult);
    }
}
