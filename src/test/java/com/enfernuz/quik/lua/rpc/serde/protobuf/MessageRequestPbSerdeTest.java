package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.rpc.RPC;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessageRequestPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<qlua.rpc.Message.Request, Message.Request> pbConverter;

    private static Message.Request expectedObject;
    private static byte[] expectedPbInput;

    private static Message.Request expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = MessageRequestPbSerde.INSTANCE;

        expectedObject = new Message.Request("1", Message.IconType.WARNING);
        expectedPbInput =
                qlua.rpc.RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.MESSAGE)
                        .setArgs(pbConverter.convertToPb(expectedObject).toByteString())
                        .build()
                        .toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = new Message.Request("1");
        expectedPbInputWithEmptyNonRequiredStringFields =
                qlua.rpc.RPC.Request.newBuilder()
                        .setType(RPC.ProcedureType.MESSAGE)
                        .setArgs(pbConverter.convertToPb(expectedObjectWithNullNonRequiredStringFileds).toByteString())
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

        final byte[] actual = sut.serialize(expectedObjectWithNullNonRequiredStringFileds);

        assertTrue( Arrays.equals(expectedPbInputWithEmptyNonRequiredStringFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final Message.Request actualObject = sut.deserialize(Message.Request.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final Message.Request actualObject =
                sut.deserialize(Message.Request.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
