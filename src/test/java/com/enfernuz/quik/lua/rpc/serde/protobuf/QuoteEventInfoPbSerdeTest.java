package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.QuoteEventInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuoteEventInfoPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.QuoteEventInfo, QuoteEventInfo> pbConverter;

    private static QuoteEventInfo expectedObject;
    private static byte[] expectedPbInput;

    private static QuoteEventInfo expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = QuoteEventInfoPbSerde.INSTANCE;

        expectedObject = QuoteEventInfo.builder()
                .classCode("1")
                .secCode("2")
                .build();
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = QuoteEventInfo.builder().build();
        expectedPbInputWithEmptyNonRequiredStringFields =
                pbConverter.convertToPb(expectedObjectWithNullNonRequiredStringFileds).toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testSerializePbInputWithEmptyNonRequiredStringFields() {

        final byte[] actual = sut.serialize(expectedObjectWithNullNonRequiredStringFileds);

        assertTrue( Arrays.equals(expectedPbInputWithEmptyNonRequiredStringFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final QuoteEventInfo actualObject = sut.deserialize(QuoteEventInfo.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final QuoteEventInfo actualObject = sut.deserialize(QuoteEventInfo.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
