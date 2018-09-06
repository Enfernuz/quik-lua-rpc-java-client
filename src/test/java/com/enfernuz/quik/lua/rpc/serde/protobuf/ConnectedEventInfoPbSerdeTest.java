package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.ConnectedEventInfo;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConnectedEventInfoPbSerdeTest {

    private static SerdeModule sut;

    private static ConnectedEventInfo expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = new ConnectedEventInfo(true);
        expectedPbInput = QluaStructures.ConnectedEventInfo.newBuilder()
                .setFlag(true)
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

        final ConnectedEventInfo actualObject = sut.deserialize(ConnectedEventInfo.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
