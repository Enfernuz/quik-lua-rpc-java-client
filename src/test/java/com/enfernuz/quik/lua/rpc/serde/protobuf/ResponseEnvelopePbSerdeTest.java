package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.ServiceError;
import com.enfernuz.quik.lua.rpc.api.structures.ResponseEnvelope;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResponseEnvelopePbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<qlua.rpc.RPC.Response, ResponseEnvelope> pbConverter;

    private static ResponseEnvelope expectedObjectWithError;
    private static byte[] expectedPbInputForObjectWithError;

    private static ResponseEnvelope expectedObjectWithResult;
    private static byte[] expectedPbInputForObjectWithResult;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = ResponseEnvelopePbSerde.INSTANCE;

        expectedObjectWithError = ResponseEnvelope.withError(new ServiceError(1, "2"));
        expectedPbInputForObjectWithError = pbConverter.convertToPb(expectedObjectWithError).toByteArray();

        expectedObjectWithResult = ResponseEnvelope.withResult("some data".getBytes(StandardCharsets.UTF_8));
        expectedPbInputForObjectWithResult = pbConverter.convertToPb(expectedObjectWithResult).toByteArray();
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
