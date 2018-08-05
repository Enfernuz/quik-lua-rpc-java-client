package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.Money;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetMoneyJsonSerdeTest {

    private static ObjectMapper sut;

    private static GetMoney.Request requestObj;
    private static GetMoney.Result resultObj;
    private static String requestJson;
    private static String resultJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = new ObjectMapper();
        sut.registerModule(new QluaJsonModule());

        requestObj = GetMoney.Request.builder()
                .clientCode("1")
                .firmId("2")
                .tag("3")
                .currCode("4")
                .build();

        final Money money = Money.builder()
                .moneyOpenLimit("1")
                .moneyLimitLockedNonMarginalValue("2")
                .moneyLimitLocked("3")
                .moneyOpenBalance("4")
                .moneyCurrentLimit("5")
                .moneyCurrentBalance("6")
                .moneyLimitAvailable("7")
                .build();

        resultObj = new GetMoney.Result(money);

        requestJson =
                Resources.toString(Resources.getResource("json/getMoney.request.json"), Charsets.UTF_8);
        resultJson =
                Resources.toString(Resources.getResource("json/getMoney.result.json"), Charsets.UTF_8);
    }

    @Test
    public void testRequestSerialize() throws IOException {

        final String actualRequestJson = sut.writerWithDefaultPrettyPrinter().writeValueAsString(requestObj);

        assertEquals(requestJson, actualRequestJson);
    }

    @Test
    public void testResultDeserialize() throws IOException {

        final GetMoney.Result actualResultObj = sut.readValue(resultJson, GetMoney.Result.class);

        assertEquals(resultObj, actualResultObj);
    }
}
