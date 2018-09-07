package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddLabel;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddLabelResultPbSerdeTest {

    private static SerdeModule sut;

    private static AddLabel.Result expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new AddLabel.Result(1);
        expectedPbInput = qlua.rpc.AddLabel.Result.newBuilder()
                .setLabelId(1)
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

        final AddLabel.Result actualObject = sut.deserialize(AddLabel.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
