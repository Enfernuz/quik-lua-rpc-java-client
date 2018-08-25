package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetPortfolioInfoExJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetPortfolioInfoEx.Request requestObj;
    private static GetPortfolioInfoEx.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetPortfolioInfoEx.Request.builder()
                .firmId("1")
                .clientCode("2")
                .limitKind(3)
                .build();

        final PortfolioInfo portfolioInfo = PortfolioInfo.builder()
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

        resultObj = GetPortfolioInfoEx.Result.builder()
                .portfolioInfo(portfolioInfo)
                .initMargin("2")
                .minMargin("3")
                .correctedMargin("4")
                .clientType("5")
                .portfolioValue("6")
                .startLimitOpenPos("7")
                .totalLimitOpenPos("8")
                .limitOpenPos("9")
                .usedLimOpenPos("10")
                .accVarMargin("11")
                .clVarMargin("12")
                .optLiquidCost("13")
                .futAsset("14")
                .futTotalAsset("15")
                .futDebt("16")
                .futRateAsset("17")
                .futRateAssetOpen("18")
                .futRateGo("19")
                .planedRateGo("20")
                .cashLeverage("21")
                .futPositionType("22")
                .futAccruedInt("23")
                .build();

        requestJson =
                Resources.toString(Resources.getResource("json/getPortfolioInfoEx.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/getPortfolioInfoEx.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetPortfolioInfoEx.Result actualResultObj = sut.readValue(resultJson, GetPortfolioInfoEx.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
