package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.api.structures.StopEventInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StopEventInfoPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.StopEventInfo, StopEventInfo> pbConverter;

    private static StopEventInfo expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = StopEventInfoPbSerde.INSTANCE;

        expectedObject = new StopEventInfo(1);
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testDeserialize() {

        final StopEventInfo actualObject = sut.deserialize(StopEventInfo.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }
}
