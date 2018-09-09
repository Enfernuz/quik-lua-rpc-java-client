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

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(ParamEventInfo.class, expectedPbInput));
    }

    @Test
    public void testSerialize_WithOnlyRequiredFields() {

        assertTrue(
                Arrays.equals(
                        expectedPbInputWithOnlyRequiredFields,
                        sut.serialize(expectedObjectWithOnlyRequiredFields)
                )
        );
    }

    @Test
    public void testDeserialize_WithOnlyRequiredFields() {

        assertEquals(
                expectedObjectWithOnlyRequiredFields,
                sut.deserialize(ParamEventInfo.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
