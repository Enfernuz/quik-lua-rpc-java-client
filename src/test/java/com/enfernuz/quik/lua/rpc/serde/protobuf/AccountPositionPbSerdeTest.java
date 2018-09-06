package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountPosition;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountPositionPbSerdeTest {

    private static SerdeModule sut;

    private static AccountPosition expectedObject;
    private static byte[] expectedPbInput;

    private static AccountPosition expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

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
        expectedPbInput = QluaStructures.AccountPosition.newBuilder()
                .setFirmid("1")
                .setCurrcode("2")
                .setTag("3")
                .setDescription("4")
                .setOpenbal("5")
                .setCurrentpos("6")
                .setPlannedpos("7")
                .setLimit1("8")
                .setLimit2("9")
                .setOrderbuy("10")
                .setOrdersell("11")
                .setNetto("12")
                .setPlannedbal("13")
                .setDebit("14")
                .setCredit("15")
                .setBankAccId("16")
                .setMargincall("17")
                .setSettlebal("18")
                .build()
                .toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = AccountPosition.builder().build();
        expectedPbInputWithEmptyNonRequiredStringFields =
                QluaStructures.AccountPosition.newBuilder().build().toByteArray();
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

        final AccountPosition actualObject = sut.deserialize(AccountPosition.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final AccountPosition actualObject = sut.deserialize(AccountPosition.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
