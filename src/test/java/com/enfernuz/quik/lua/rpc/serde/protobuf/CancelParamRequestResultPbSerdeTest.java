package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CancelParamRequest;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CancelParamRequestResultPbSerdeTest {

    private static SerdeModule sut;

    private static CancelParamRequest.Result expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new CancelParamRequest.Result(true);
        expectedPbInput = qlua.rpc.CancelParamRequest.Result.newBuilder()
                .setResult(true)
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

        final CancelParamRequest.Result actualObject = sut.deserialize(CancelParamRequest.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
