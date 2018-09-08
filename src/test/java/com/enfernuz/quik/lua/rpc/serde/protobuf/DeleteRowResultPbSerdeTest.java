package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DeleteRow;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteRowResultPbSerdeTest {

    private static SerdeModule sut;

    private static DeleteRow.Result expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = DeleteRow.Result.getInstance(true);
        expectedPbInput = qlua.rpc.Clear.Result.newBuilder()
                .setResult(true)
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

        final DeleteRow.Result actualObject = sut.deserialize(DeleteRow.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
