package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepoLimitDeletePbSerdeTest {

    private static SerdeModule sut;

    private static DepoLimitDelete expectedObject;
    private static byte[] expectedPbInput;

    private static DepoLimitDelete expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = DepoLimitDelete.builder()
                .secCode("1")
                .trdAccId("2")
                .firmId("3")
                .clientCode("4")
                .limitKind(5)
                .build();
        expectedPbInput = QluaStructures.DepoLimitDelete.newBuilder()
                .setSecCode("1")
                .setTrdaccid("2")
                .setFirmid("3")
                .setClientCode("4")
                .setLimitKind(5)
                .build()
                .toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = DepoLimitDelete.builder()
                .limitKind(1)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields = QluaStructures.DepoLimitDelete.newBuilder()
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

        final byte[] actual = sut.serialize(expectedObjectWithNullNonRequiredStringFileds);

        assertTrue( Arrays.equals(expectedPbInputWithEmptyNonRequiredStringFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final DepoLimitDelete actualObject = sut.deserialize(DepoLimitDelete.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final DepoLimitDelete actualObject = sut.deserialize(DepoLimitDelete.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
