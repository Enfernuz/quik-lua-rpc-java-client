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

    private static FuturesLimitDelete expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

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

        expectedObjectWithNullNonRequiredStringFileds = FuturesLimitDelete.builder()
                .limitType(1)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields = QluaStructures.FuturesLimitDelete.newBuilder()
                .setLimitType(1)
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

        final FuturesLimitDelete actualObject = sut.deserialize(FuturesLimitDelete.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final FuturesLimitDelete actualObject = sut.deserialize(FuturesLimitDelete.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
