package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FuturesLimitPbSerdeTest {

    private static SerdeModule sut;

    private static FuturesLimit expectedObject;
    private static byte[] expectedPbInput;

    private static FuturesLimit expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

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
        expectedPbInput = QluaStructures.FuturesLimit.newBuilder()
                .setFirmid("1")
                .setTrdaccid("2")
                .setLimitType(3)
                .setLiquidityCoef("4")
                .setCbpPrevLimit("5")
                .setCbplimit("6")
                .setCbplused("7")
                .setCbplplanned("8")
                .setVarmargin("9")
                .setAccruedint("10")
                .setCbplusedForOrders("11")
                .setCbplusedForPositions("12")
                .setOptionsPremium("13")
                .setTsComission("14")
                .setKgo("15")
                .setCurrcode("16")
                .setRealVarmargin("17")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = FuturesLimit.builder().build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.FuturesLimit.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {
        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(FuturesLimit.class, expectedPbInput));
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
                sut.deserialize(FuturesLimit.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
