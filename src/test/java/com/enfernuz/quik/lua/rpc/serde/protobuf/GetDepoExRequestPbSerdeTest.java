package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepoEx;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetDepoExRequestPbSerdeTest {

    private static SerdeModule sut;

    private static GetDepoEx.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = GetDepoEx.Request.builder()
                .firmId("1")
                .clientCode("2")
                .secCode("3")
                .trdAccId("4")
                .limitKind(5)
                .build();
        final ByteString pbArgs = qlua.rpc.GetDepoEx.Request.newBuilder()
                .setFirmid("1")
                .setClientCode("2")
                .setSecCode("3")
                .setTrdaccid("4")
                .setLimitKind(5)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.GET_DEPO_EX)
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
        assertEquals(expectedObject, sut.deserialize(GetDepoEx.Request.class, expectedPbInput));
    }
}
