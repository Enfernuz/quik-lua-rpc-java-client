package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AllocTable;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AllocTableRequestPbSerdeTest {

    private static SerdeModule sut;

    private static AllocTable.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = AllocTable.Request.INSTANCE;
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.ALLOC_TABLE)
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

        final AllocTable.Request actualObject = sut.deserialize(AllocTable.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
