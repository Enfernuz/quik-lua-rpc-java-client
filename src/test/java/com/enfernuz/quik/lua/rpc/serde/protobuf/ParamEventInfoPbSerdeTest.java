package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.ParamEventInfo;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParamEventInfoPbSerdeTest {

    private static SerdeModule sut;

    private static ParamEventInfo expectedObject;
    private static byte[] expectedPbInput;

    private static ParamEventInfo expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = ParamEventInfo.builder()
                .classCode("1")
                .secCode("2")
                .build();
        expectedPbInput = QluaStructures.ParamEventInfo.newBuilder()
                .setClassCode("1")
                .setSecCode("2")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = ParamEventInfo.builder().build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.ParamEventInfo.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testSerializePbInputWithEmptyNonRequiredStringFields() {

        final byte[] actual = sut.serialize(expectedObjectWithOnlyRequiredFields);

        assertTrue( Arrays.equals(expectedPbInputWithOnlyRequiredFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final ParamEventInfo actualObject = sut.deserialize(ParamEventInfo.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final ParamEventInfo actualObject = sut.deserialize(ParamEventInfo.class, expectedPbInputWithOnlyRequiredFields);

        assertEquals(actualObject, expectedObjectWithOnlyRequiredFields);
    }
}
