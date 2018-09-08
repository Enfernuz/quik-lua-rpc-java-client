package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DeleteRow;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteRowRequestPbSerdeTest {

    private static SerdeModule sut;

    private static DeleteRow.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new DeleteRow.Request(1, 2);
        final ByteString pbArgs = qlua.rpc.DeleteRow.Request.newBuilder()
                .setTId(1)
                .setKey(2)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.DELETE_ROW)
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

        final DeleteRow.Request actualObject = sut.deserialize(DeleteRow.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
