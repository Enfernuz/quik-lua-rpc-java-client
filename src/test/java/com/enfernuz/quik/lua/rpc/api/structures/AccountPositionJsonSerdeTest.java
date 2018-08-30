package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AccountPositionJsonSerdeTest {

    private final ObjectMapper sut = new ObjectMapper();

    private static AccountPosition expectedObject;
    private static String expectedJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        expectedObject = AccountPosition.builder()
                .firmId("1")
                .currCode("2")
                .tag("3")
                .description("4")
                .openBal("5")
                .currentPos("6")
                .plannedPos("7")
                .limit1("8")
                .limit2("9")
                .orderBuy("10")
                .orderSell("11")
                .netto("12")
                .plannedBal("13")
                .debit("14")
                .credit("15")
                .bankAccId("16")
                .marginCall("17")
                .settleBal("18")
                .build();

        expectedJson = Resources.toString(Resources.getResource("json/structures/AccountPosition.json"), Charsets.UTF_8);
    }

    @Test
    public void testDeserialize() throws IOException {

        final AccountPosition actualObject = sut.readValue(expectedJson, AccountPosition.class);

        assertEquals(expectedObject, actualObject);
    }
}