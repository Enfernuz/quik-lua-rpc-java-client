package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CancelParamRequest;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CancelParamRequestRequestPbSerdeTest {

    private static SerdeModule sut;

    private static CancelParamRequest.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = CancelParamRequest.Request.builder()
                .classCode("1")
                .secCode("2")
                .dbName("3")
                .build();
        final ByteString pbArgs = qlua.rpc.CancelParamRequest.Request.newBuilder()
                .setClassCode("1")
                .setSecCode("2")
                .setDbName("3")
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.CANCEL_PARAM_REQUEST)
                        .setArgs(pbArgs)
                        .build()
                        .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final CancelParamRequest.Request actualObject = sut.deserialize(CancelParamRequest.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
