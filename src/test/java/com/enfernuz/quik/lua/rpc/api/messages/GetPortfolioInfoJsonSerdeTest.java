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

public class GetPortfolioInfoJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetPortfolioInfo.Request requestObj;
    private static GetPortfolioInfo.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetPortfolioInfo.Request.builder()
                .firmId("1")
                .clientCode("2")
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

        resultObj = new GetPortfolioInfo.Result(portfolioInfo);

        requestJson =
                Resources.toString(Resources.getResource("json/getPortfolioInfo.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/getPortfolioInfo.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetPortfolioInfo.Result actualResultObj = sut.readValue(resultJson, GetPortfolioInfo.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
