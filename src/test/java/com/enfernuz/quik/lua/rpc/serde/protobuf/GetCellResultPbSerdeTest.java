package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetCellResultPbSerdeTest {

    private static SerdeModule sut;

    private static GetCell.Result expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = GetCell.Result.builder()
                .image("1")
                .value("2")
                .build();
        expectedPbInput = qlua.rpc.GetCell.Result.newBuilder()
                .setImage("1")
                .setValue("2")
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

        final GetCell.Result actualObject = sut.deserialize(GetCell.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
