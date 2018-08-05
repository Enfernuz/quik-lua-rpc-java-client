package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MoneyJsonSerdeTest {

    private final ObjectMapper sut = new ObjectMapper();

    private static Money money;
    private static String moneyAsJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        money = Money.builder()
                .moneyOpenLimit("1")
                .moneyLimitLockedNonMarginalValue("2")
                .moneyLimitLocked("3")
                .moneyOpenBalance("4")
                .moneyCurrentLimit("5")
                .moneyCurrentBalance("6")
                .moneyLimitAvailable("7")
                .build();

        moneyAsJson = Resources.toString(Resources.getResource("json/money.json"), Charsets.UTF_8);
    }

    @Test
    public void testDeserialize() throws IOException {

        final Money actual = sut.readValue(moneyAsJson, Money.class);

        assertEquals(money, actual);
    }
}
