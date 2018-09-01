package com.enfernuz.quik.lua.rpc.api.structures;

import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.json.JsonSerdeModule;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static com.enfernuz.quik.lua.rpc.serde.SerdeUtils.trimAndRemoveLineBreaks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PortfolioInfoJsonSerdeTest {

    private static SerdeModule sut;

    private static PortfolioInfo expectedObject;
    private static String expectedJson;
    private static byte[] expectedJsonAsBytes;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = JsonSerdeModule.INSTANCE;

        expectedObject = PortfolioInfo.builder()
                .isLeverage("1")
                .inAssets("2")
                .leverage("3")
                .openLimit("4")
                .valShort("5")
                .valLong("6")
                .valLongMargin("7")
                .valLongAsset("8")
                .assets("9")
                .curLeverage("10")
                .margin("11")
                .limAll("12")
                .avLimAll("13")
                .lockedBuy("14")
                .lockedBuyMargin("15")
                .lockedBuyAsset("16")
                .lockedSell("17")
                .lockedValueCoef("18")
                .inAllAssets("19")
                .allAssets("20")
                .profitLoss("21")
                .rateChange("22")
                .limBuy("23")
                .limSell("24")
                .limNonMargin("25")
                .limBuyAsset("26")
                .valShortNet("27")
                .valLongNet("28")
                .totalMoneyBal("29")
                .totalLockedMoney("30")
                .haircuts("31")
                .assetsWithoutHc("32")
                .statusCoef("33")
                .varMargin("34")
                .goForPositions("35")
                .goForOrders("36")
                .rateFutures("37")
                .isQualClient("38")
                .isFutures("39")
                .currTag("40")
                .build();

        expectedJson = Resources.toString(Resources.getResource("json/structures/PortfolioInfo.json"), Charsets.UTF_8);
        expectedJsonAsBytes = trimAndRemoveLineBreaks(expectedJson).getBytes(Charsets.UTF_8);
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedJsonAsBytes, actual) );
    }

    @Test
    public void testDeserialize() {

        final PortfolioInfo actual = sut.deserialize(PortfolioInfo.class, expectedJsonAsBytes);

        assertEquals(expectedObject, actual);
    }
}
