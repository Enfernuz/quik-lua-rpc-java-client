package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DelLabelRequestPbSerdeTest {

    private static SerdeModule sut;

    private static DelLabel.Request expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new DelLabel.Request("1", 2);
        final ByteString pbArgs = qlua.rpc.DelLabel.Request.newBuilder()
                .setChartTag("1")
                .setLabelId(2)
                .build()
                .toByteString();
        expectedPbInput =
                RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.DEL_LABEL)
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

        final DelLabel.Request actualObject = sut.deserialize(DelLabel.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
