package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyLimitDeletePbSerdeTest {

    private static SerdeModule sut;

    private static MoneyLimitDelete expectedObject;
    private static byte[] expectedPbInput;

    private static MoneyLimitDelete expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = MoneyLimitDelete.builder()
                .firmId("1")
                .limitKind(2)
                .build();
        expectedPbInput = QluaStructures.MoneyLimitDelete.newBuilder()
                .setFirmid("1")
                .setLimitKind(2)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = MoneyLimitDelete.builder().build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.MoneyLimitDelete.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(MoneyLimitDelete.class, expectedPbInput));
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
                sut.deserialize(MoneyLimitDelete.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
