package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetFuturesLimitRequestPbSerdeTest {

    private static SerdeModule sut;

    private static GetFuturesLimit.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = GetFuturesLimit.Request.builder()
                .firmId("1")
                .trdAccId("2")
                .limitType(3)
                .currCode("4")
                .build();
        final ByteString pbArgs = qlua.rpc.GetFuturesLimit.Request.newBuilder()
                .setFirmid("1")
                .setTrdaccid("2")
                .setLimitType(3)
                .setCurrcode("4")
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.GET_FUTURES_LIMIT)
                        .setArgs(pbArgs)
                        .build()
                        .toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(GetFuturesLimit.Request.class, expectedPbInput));
    }
}
