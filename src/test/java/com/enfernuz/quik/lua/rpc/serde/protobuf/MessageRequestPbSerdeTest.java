package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.protobuf.ByteString;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessageRequestPbSerdeTest {

    private static SerdeModule sut;

    private static Message.Request expectedObject;
    private static byte[] expectedPbInput;

    private static Message.Request expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbBytesWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new Message.Request("1", Message.IconType.WARNING);
        final ByteString pbArgs = qlua.rpc.Message.Request.newBuilder()
                .setMessage("1")
                .setIconType(qlua.rpc.Message.IconType.WARNING)
                .build()
                .toByteString();
        expectedPbInput =
                qlua.rpc.RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.MESSAGE)
                        .setArgs(pbArgs)
                        .build()
                        .toByteArray();

        expectedObjectWithOnlyRequiredFields = new Message.Request("1");
        final ByteString pbArgsWithOnlyRequiredFields = qlua.rpc.Message.Request.newBuilder()
                .setMessage("1")
                .build()
                .toByteString();
        expectedPbBytesWithOnlyRequiredFields =
                qlua.rpc.RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.MESSAGE)
                        .setArgs(pbArgsWithOnlyRequiredFields)
                        .build()
                        .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testSerializePbInputWithEmptyNonRequiredStringFields() {

        final byte[] actual = sut.serialize(expectedObjectWithOnlyRequiredFields);

        assertTrue( Arrays.equals(expectedPbBytesWithOnlyRequiredFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final Message.Request actualObject = sut.deserialize(Message.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final Message.Request actualObject =
                sut.deserialize(Message.Request.class, expectedPbBytesWithOnlyRequiredFields);

        assertEquals(actualObject, expectedObjectWithOnlyRequiredFields);
    }
}
