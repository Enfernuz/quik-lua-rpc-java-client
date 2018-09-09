package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetFuturesHoldingRequestPbSerdeTest {

    private static SerdeModule sut;

    private static GetFuturesHolding.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = GetFuturesHolding.Request.builder()
                .firmId("1")
                .trdAccId("2")
                .secCode("3")
                .type(4)
                .build();
        final ByteString pbArgs = qlua.rpc.GetFuturesHolding.Request.newBuilder()
                .setFirmid("1")
                .setTrdaccid("2")
                .setSecCode("3")
                .setType(4)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.GET_FUTURES_HOLDING)
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
        assertEquals(expectedObject, sut.deserialize(GetFuturesHolding.Request.class, expectedPbInput));
    }
}
