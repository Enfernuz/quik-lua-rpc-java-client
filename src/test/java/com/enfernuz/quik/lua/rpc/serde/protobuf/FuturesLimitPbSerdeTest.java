package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FuturesLimitPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.FuturesLimit, FuturesLimit> pbConverter;

    private static FuturesLimit expectedObject;
    private static byte[] expectedPbInput;

    private static FuturesLimit expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = FuturesLimitPbSerde.INSTANCE;

        expectedObject = FuturesLimit.builder()
                .firmId("1")
                .trdAccId("2")
                .limitType(3)
                .liquidityCoef("4")
                .cbpPrevLimit("5")
                .cbpLimit("6")
                .cbplUsed("7")
                .cbplPlanned("8")
                .varMargin("9")
                .accruedInt("10")
                .cbplUsedForOrders("11")
                .cbplUsedForPositions("12")
                .optionsPremium("13")
                .tsComission("14")
                .kgo("15")
                .currCode("16")
                .realVarMargin("17")
                .build();
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = FuturesLimit.builder()
                .limitType(1)
                .build();
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

        final FuturesLimit actualObject = sut.deserialize(FuturesLimit.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final FuturesLimit actualObject = sut.deserialize(FuturesLimit.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
