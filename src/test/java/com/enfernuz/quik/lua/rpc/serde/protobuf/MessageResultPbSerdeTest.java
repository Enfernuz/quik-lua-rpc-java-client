package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessageResultPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<qlua.rpc.Message.Result, Message.Result> pbConverter;

    private static Message.Result expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = MessageResultPbSerde.INSTANCE;

        expectedObject = new Message.Result(1);
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final Message.Result actualObject = sut.deserialize(Message.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
