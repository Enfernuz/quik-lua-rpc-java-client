package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.QuoteEventInfo;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuoteEventInfoPbSerdeTest {

    private static SerdeModule sut;

    private static QuoteEventInfo expectedObject;
    private static byte[] expectedPbInput;

    private static QuoteEventInfo expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = QuoteEventInfo.builder()
                .classCode("1")
                .secCode("2")
                .build();
        expectedPbInput = QluaStructures.QuoteEventInfo.newBuilder()
                .setClassCode("1")
                .setSecCode("2")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = QuoteEventInfo.builder().build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.QuoteEventInfo.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(QuoteEventInfo.class, expectedPbInput));
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
                sut.deserialize(QuoteEventInfo.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
