package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetCandlesByIndexRequestPbSerdeTest {

    private static SerdeModule sut;

    private static GetCandlesByIndex.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = GetCandlesByIndex.Request.builder()
                .tag("1")
                .line(2)
                .firstCandle(3)
                .count(4)
                .build();
        final ByteString pbArgs = qlua.rpc.GetCandlesByIndex.Request.newBuilder()
                .setTag("1")
                .setLine(2)
                .setFirstCandle(3)
                .setCount(4)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.GET_CANDLES_BY_INDEX)
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

        final GetCandlesByIndex.Request actualObject = sut.deserialize(GetCandlesByIndex.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}