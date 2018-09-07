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

        expectedObjectWithOnlyRequiredFields = MoneyLimitDelete.builder()
                .limitKind(1)
                .build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.MoneyLimitDelete.newBuilder()
                .setLimitKind(1)
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

        final byte[] actual = sut.serialize(expectedObjectWithOnlyRequiredFields);

        assertTrue( Arrays.equals(expectedPbInputWithOnlyRequiredFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final MoneyLimitDelete actualObject = sut.deserialize(MoneyLimitDelete.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final MoneyLimitDelete actualObject = sut.deserialize(MoneyLimitDelete.class, expectedPbInputWithOnlyRequiredFields);

        assertEquals(actualObject, expectedObjectWithOnlyRequiredFields);
    }
}
