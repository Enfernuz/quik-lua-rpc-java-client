package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountBalance;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountBalancePbSerdeTest {

    private static SerdeModule sut;

    private static AccountBalance expectedObject;
    private static byte[] expectedPbInput;

    private static AccountBalance expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

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
        expectedPbInput = QluaStructures.AccountBalance.newBuilder()
                .setFirmid("1")
                .setSecCode("2")
                .setTrdaccid("3")
                .setDepaccid("4")
                .setOpenbal("5")
                .setCurrentpos("6")
                .setPlannedpossell("7")
                .setPlannedposbuy("8")
                .setPlanbal("9")
                .setUsqtyb("10")
                .setUsqtys("11")
                .setPlanned("12")
                .setSettlebal("13")
                .setBankAccId("14")
                .setFirmuse(15)
                .build()
                .toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = AccountBalance.builder()
                .firmUse(1)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields = QluaStructures.AccountBalance.newBuilder()
                .setFirmuse(1)
                .build()
                .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testSerializePbInputWithEmptyNonRequiredStringFields() {

        final byte[] actual = sut.serialize(expectedObjectWithNullNonRequiredStringFileds);

        assertTrue( Arrays.equals(expectedPbInputWithEmptyNonRequiredStringFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final AccountBalance actualObject = sut.deserialize(AccountBalance.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final AccountBalance actualObject = sut.deserialize(AccountBalance.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
