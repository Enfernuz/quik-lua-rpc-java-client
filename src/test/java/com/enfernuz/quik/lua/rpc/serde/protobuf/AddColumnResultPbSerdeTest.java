package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddColumnResultPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<qlua.rpc.AddColumn.Result, AddColumn.Result> pbConverter;

    private static AddColumn.Result expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = AddColumnResultPbSerde.INSTANCE;

        expectedObject = new AddColumn.Result(1);
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final AddColumn.Result actualObject = sut.deserialize(AddColumn.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
