package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountPosition;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import static org.junit.Assert.assertEquals;

public class AccountPositionPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.AccountPosition, AccountPosition> pbConverter;

    private static AccountPosition expectedObject;
    private static byte[] expectedPbInput;

    private static AccountPosition expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = AccountPositionPbSerde.INSTANCE;

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
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = AccountPosition.builder().build();
        expectedPbInputWithEmptyNonRequiredStringFields =
                pbConverter.convertToPb(expectedObjectWithNullNonRequiredStringFileds).toByteArray();
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
