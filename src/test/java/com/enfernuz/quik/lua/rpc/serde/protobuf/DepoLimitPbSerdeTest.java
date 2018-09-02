package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepoLimitPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.DepoLimit, DepoLimit> pbConverter;

    private static DepoLimit expectedObject;
    private static byte[] expectedPbInput;

    private static DepoLimit expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = DepoLimitPbSerde.INSTANCE;

        expectedObject = DepoLimit.builder()
                .secCode("1")
                .trdAccId("2")
                .firmId("3")
                .clientCode("4")
                .openBal(5)
                .openLimit(6)
                .currentBal(7)
                .currentLimit(8)
                .lockedSell(9)
                .lockedBuy(10)
                .lockedBuyValue("11")
                .lockedSellValue("12")
                .awgPositionPrice("13")
                .limitKind(14)
                .build();
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = DepoLimit.builder()
                .openBal(1)
                .openLimit(2)
                .currentBal(3)
                .currentLimit(4)
                .lockedSell(5)
                .lockedBuy(6)
                .limitKind(7)
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

        final DepoLimit actualObject = sut.deserialize(DepoLimit.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final DepoLimit actualObject = sut.deserialize(DepoLimit.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
