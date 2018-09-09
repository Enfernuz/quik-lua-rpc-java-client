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

    private static Firm expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

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

        expectedObjectWithOnlyRequiredFields = Firm.builder()
                .firmId("1")
                .build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.Firm.newBuilder()
                .setFirmid("1")
                .build()
                .toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }
    
    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(Firm.class, expectedPbInput));
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
                sut.deserialize(Firm.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
