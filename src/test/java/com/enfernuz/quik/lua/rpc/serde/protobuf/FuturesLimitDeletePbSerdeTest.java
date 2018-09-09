package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FuturesLimitDeletePbSerdeTest {

    private static SerdeModule sut;

    private static FuturesLimitDelete expectedObject;
    private static byte[] expectedPbInput;

    private static FuturesLimitDelete expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = FuturesLimitDelete.builder()
                .firmId("1")
                .limitType(2)
                .build();
        expectedPbInput = QluaStructures.FuturesLimitDelete.newBuilder()
                .setFirmid("1")
                .setLimitType(2)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = FuturesLimitDelete.builder().build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.FuturesLimitDelete.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(FuturesLimitDelete.class, expectedPbInput));
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
                sut.deserialize(FuturesLimitDelete.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
