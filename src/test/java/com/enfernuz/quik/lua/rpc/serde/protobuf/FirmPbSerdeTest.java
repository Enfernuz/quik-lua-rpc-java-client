package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirmPbSerdeTest {

    private static SerdeModule sut;

    private static Firm expectedObject;
    private static byte[] expectedPbInput;

    private static Firm expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = Firm.builder()
                .firmId("1")
                .firmName("2")
                .status(3)
                .exchange("4")
                .build();
        expectedPbInput = QluaStructures.Firm.newBuilder()
                .setFirmid("1")
                .setFirmName("2")
                .setStatus(3)
                .setExchange("4")
                .build()
                .toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = Firm.builder()
                .firmId("1")
                .status(2)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields = QluaStructures.Firm.newBuilder()
                .setFirmid("1")
                .setStatus(2)
                .build()
                .toByteArray();
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

        final Firm actualObject = sut.deserialize(Firm.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final Firm actualObject = sut.deserialize(Firm.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
