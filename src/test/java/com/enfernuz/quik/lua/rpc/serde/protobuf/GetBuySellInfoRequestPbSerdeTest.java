package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetBuySellInfoRequestPbSerdeTest {

    private static SerdeModule sut;

    private static GetBuySellInfo.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = GetBuySellInfo.Request.builder()
                .firmId("1")
                .clientCode("2")
                .classCode("3")
                .secCode("4")
                .price("5")
                .build();
        final ByteString pbArgs = qlua.rpc.GetBuySellInfo.Request.newBuilder()
                .setFirmId("1")
                .setClientCode("2")
                .setClassCode("3")
                .setSecCode("4")
                .setPrice("5")
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.GET_BUY_SELL_INFO)
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

        final GetBuySellInfo.Request actualObject = sut.deserialize(GetBuySellInfo.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
