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

public class AccountBalanceJsonSerdeTest {

    private static SerdeModule sut;

    private static AccountBalance expectedObject;
    private static String expectedJson;
    private static byte[] expectedJsonAsBytes;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = JsonSerdeModule.INSTANCE;

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
        expectedJsonAsBytes = trimAndRemoveLineBreaks(expectedJson).getBytes(Charsets.UTF_8);
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedJsonAsBytes, actual) );
    }

    @Test
    public void testDeserialize() {

        final AccountBalance actualObject = sut.deserialize(AccountBalance.class, expectedJsonAsBytes);

        assertEquals(expectedObject, actualObject);
    }
}