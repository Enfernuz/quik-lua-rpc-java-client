package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountPosition;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;
import static org.junit.Assert.assertEquals;

public class AccountPositionProtobufSerdeTest {

    private static Deserializer<AccountPosition> sut;

    private static AccountPosition expectedObject;
    private static byte[] expectedPbInput;

    private static AccountPosition expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = AccountPositionPbDeserializer.INSTANCE;

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
        expectedPbInput = convertToPbByteArray(expectedObject);

        expectedObjectWithNullNonRequiredStringFileds = AccountPosition.builder().build();
        expectedPbInputWithEmptyNonRequiredStringFields = convertToPbByteArray(expectedObjectWithNullNonRequiredStringFileds);
    }

    @Test
    public void testDeserialize() {

        final AccountPosition actualObject = sut.deserialize(expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final AccountPosition actualObject = sut.deserialize(expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }

    private static byte[] convertToPbByteArray(@NotNull final AccountPosition accountPosition) {

        return QluaStructures.AccountPosition.newBuilder()
                .setFirmid( convertToPbString(accountPosition.getFirmId()) )
                .setCurrcode( convertToPbString(accountPosition.getCurrCode()) )
                .setTag( convertToPbString(accountPosition.getTag()) )
                .setDescription( convertToPbString(accountPosition.getDescription()) )
                .setOpenbal( convertToPbString(accountPosition.getOpenBal()) )
                .setCurrentpos( convertToPbString(accountPosition.getCurrentPos()) )
                .setPlannedpos( convertToPbString(accountPosition.getPlannedPos()) )
                .setLimit1( convertToPbString(accountPosition.getLimit1()) )
                .setLimit2( convertToPbString(accountPosition.getLimit2()) )
                .setOrderbuy( convertToPbString(accountPosition.getOrderBuy()) )
                .setOrdersell( convertToPbString(accountPosition.getOrderSell()) )
                .setNetto( convertToPbString(accountPosition.getNetto()) )
                .setPlannedbal( convertToPbString(accountPosition.getPlannedBal()) )
                .setDebit( convertToPbString(accountPosition.getDebit()) )
                .setCredit( convertToPbString(accountPosition.getCredit()) )
                .setBankAccId( convertToPbString(accountPosition.getBankAccId()) )
                .setMargincall( convertToPbString(accountPosition.getMarginCall()) )
                .setSettlebal( convertToPbString(accountPosition.getSettleBal()) )
                .build()
                .toByteArray();
    }
}
