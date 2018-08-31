package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AllTradeJsonSerdeTest {

    private final ObjectMapper sut = new ObjectMapper();

    private static AccountBalance expectedObject;
    private static String expectedJson;

    @BeforeClass
    public static void globalSetup() throws IOException {

        expectedObject = AccountBalance.builder()
                .firmId("1")
                .secCode("2")
                .trdAccId("3")
                .depAccId("4")
                .openBal("5")
                .currentPos("6")
                .plannedPosSell("7")
                .plannedPosBuy("8")
                .planBal("9")
                .usqtyb("10")
                .usqtys("11")
                .planned("12")
                .settleBal("13")
                .bankAccId("14")
                .firmUse(15)
                .build();

        expectedJson = Resources.toString(Resources.getResource("json/structures/AccountBalance.json"), Charsets.UTF_8);
    }

    @Test
    public void testDeserialize() throws IOException {

        final AccountBalance actualObject = sut.readValue(expectedJson, AccountBalance.class);

        assertEquals(expectedObject, actualObject);
    }
}