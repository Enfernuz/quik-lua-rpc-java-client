package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FuturesClientHoldingPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.FuturesClientHolding, FuturesClientHolding> pbConverter;

    private static FuturesClientHolding expectedObject;
    private static byte[] expectedPbInput;

    private static FuturesClientHolding expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = FuturesClientHoldingPbSerde.INSTANCE;

        expectedObject = FuturesClientHolding.builder()
                .firmId("1")
                .trdAccId("2")
                .secCode("3")
                .type(4)
                .startBuy("5")
                .startSell("6")
                .todayBuy("7")
                .todaySell("8")
                .totalNet("9")
                .openBuys(10)
                .openSells(11)
                .cbplUsed("12")
                .cbplPlanned("13")
                .varMargin("14")
                .avrPosnPrice("15")
                .positionValue("16")
                .realVarMargin("17")
                .totalVarMargin("18")
                .sessionStatus(19)
                .build();
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = FuturesClientHolding.builder()
                .type(1)
                .openBuys(2)
                .openSells(3)
                .sessionStatus(4)
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

        final FuturesClientHolding actualObject = sut.deserialize(FuturesClientHolding.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final FuturesClientHolding actualObject = sut.deserialize(FuturesClientHolding.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
