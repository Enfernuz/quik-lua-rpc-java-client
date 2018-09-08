package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DelLabelResultPbSerdeTest {

    private static SerdeModule sut;

    private static DelLabel.Result expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = DelLabel.Result.getInstance(true);
        expectedPbInput = qlua.rpc.DelLabel.Result.newBuilder()
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

        final DelLabel.Result actualObject = sut.deserialize(DelLabel.Result.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
