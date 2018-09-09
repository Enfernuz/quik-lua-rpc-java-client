package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo.BuySellInfo;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BuySellInfoPbSerdeTest {

    private static SerdeModule sut;

    private static BuySellInfo expectedObject;
    private static byte[] expectedPbInput;

    private static BuySellInfo expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = BuySellInfo.builder()
                .isMarginSec("1")
                .isAssetSec("2")
                .balance("3")
                .canBuy("4")
                .canSell("5")
                .positionValuation("6")
                .value("7")
                .openValue("8")
                .limLong("9")
                .longCoef("10")
                .limShort("11")
                .shortCoef("12")
                .valueCoef("13")
                .openValueCoef("14")
                .share("15")
                .shortWaPrice("16")
                .longWaPrice("17")
                .profitLoss("18")
                .spreadHc("19")
                .canBuyOwn("20")
                .canSellOwn("12")
                .build();
        expectedPbInput = qlua.rpc.GetBuySellInfo.BuySellInfo.newBuilder()
                .setIsMarginSec("1")
                .setIsAssetSec("2")
                .setBalance("3")
                .setCanBuy("4")
                .setCanSell("5")
                .setPositionValuation("6")
                .setValue("7")
                .setOpenValue("8")
                .setLimLong("9")
                .setLongCoef("10")
                .setLimShort("11")
                .setShortCoef("12")
                .setValueCoef("13")
                .setOpenValueCoef("14")
                .setShare("15")
                .setShortWaPrice("16")
                .setLongWaPrice("17")
                .setProfitLoss("18")
                .setSpreadHc("19")
                .setCanBuyOwn("20")
                .setCanSellOwn("12")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = BuySellInfo.builder().build();
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.GetBuySellInfo.BuySellInfo.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(BuySellInfo.class, expectedPbInput));
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
                sut.deserialize(BuySellInfo.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
