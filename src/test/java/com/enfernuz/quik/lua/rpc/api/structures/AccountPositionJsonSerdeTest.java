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

public class AccountPositionJsonSerdeTest {

    private static SerdeModule sut;

    private static AccountPosition expectedObject;
    private static String expectedJson;
    private static byte[] expectedJsonAsBytes;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = JsonSerdeModule.INSTANCE;

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
        expectedJsonAsBytes = trimAndRemoveLineBreaks(expectedJson).getBytes(Charsets.UTF_8);
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedJsonAsBytes, actual) );
    }

    @Test
    public void testDeserialize() {

        final AccountPosition actualObject = sut.deserialize(AccountPosition.class, expectedJsonAsBytes);

        assertEquals(expectedObject, actualObject);
    }
}