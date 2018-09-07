package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FuturesClientHoldingPbSerdeTest {

    private static SerdeModule sut;

    private static FuturesClientHolding expectedObject;
    private static byte[] expectedPbInput;

    private static FuturesClientHolding expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

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
        expectedPbInput = QluaStructures.FuturesClientHolding.newBuilder()
                .setFirmid("1")
                .setTrdaccid("2")
                .setSecCode("3")
                .setType(4)
                .setStartbuy("5")
                .setStartsell("6")
                .setTodaybuy("7")
                .setTodaysell("8")
                .setTotalnet("9")
                .setOpenbuys(10)
                .setOpensells(11)
                .setCbplused("12")
                .setCbplplanned("13")
                .setVarmargin("14")
                .setAvrposnprice("15")
                .setPositionvalue("16")
                .setRealVarmargin("17")
                .setTotalVarmargin("18")
                .setSessionStatus(19)
                .build()
                .toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = FuturesClientHolding.builder()
                .type(1)
                .openBuys(2)
                .openSells(3)
                .sessionStatus(4)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields = QluaStructures.FuturesClientHolding.newBuilder()
                .setType(1)
                .setOpenbuys(2)
                .setOpensells(3)
                .setSessionStatus(4)
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

        final FuturesClientHolding actualObject = sut.deserialize(FuturesClientHolding.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final FuturesClientHolding actualObject = sut.deserialize(FuturesClientHolding.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
