package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetCellRequestPbSerdeTest {

    private static SerdeModule sut;

    private static GetCell.Args expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = GetCell.Args.builder()
                .tId(1)
                .key(2)
                .code(3)
                .build();
        final ByteString pbArgs = qlua.rpc.GetCell.Request.newBuilder()
                .setTId(1)
                .setKey(2)
                .setCode(3)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.GET_CELL)
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

        final GetCell.Args actualObject = sut.deserialize(GetCell.Args.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
