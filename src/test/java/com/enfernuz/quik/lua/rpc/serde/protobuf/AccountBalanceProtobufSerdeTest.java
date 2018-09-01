package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountBalance;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;
import static org.junit.Assert.assertEquals;

public class AccountBalanceProtobufSerdeTest {

    private static Deserializer<AccountBalance> sut;

    private static AccountBalance expectedObject;
    private static byte[] expectedPbInput;

    private static AccountBalance expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = AccountBalancePbDeserializer.INSTANCE;

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
        expectedPbInput = convertToPbByteArray(expectedObject);

        expectedObjectWithNullNonRequiredStringFileds = AccountBalance.builder()
                .firmUse(1)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields = convertToPbByteArray(expectedObjectWithNullNonRequiredStringFileds);
    }

    @Test
    public void testDeserialize() {

        final AccountBalance actualObject = sut.deserialize(expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final AccountBalance actualObject = sut.deserialize(expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }

    private static byte[] convertToPbByteArray(@NotNull final AccountBalance accountBalance) {

        return QluaStructures.AccountBalance.newBuilder()
                .setFirmid( convertToPbString(accountBalance.getFirmId()) )
                .setSecCode( convertToPbString(accountBalance.getSecCode()) )
                .setTrdaccid( convertToPbString(accountBalance.getTrdAccId()) )
                .setDepaccid( convertToPbString(accountBalance.getDepAccId()) )
                .setOpenbal( convertToPbString(accountBalance.getOpenBal()) )
                .setCurrentpos( convertToPbString(accountBalance.getCurrentPos()) )
                .setPlannedpossell( convertToPbString(accountBalance.getPlannedPosSell()) )
                .setPlannedposbuy( convertToPbString(accountBalance.getPlannedPosBuy()) )
                .setPlanbal( convertToPbString(accountBalance.getPlanBal()) )
                .setUsqtyb( convertToPbString(accountBalance.getUsqtyb()) )
                .setUsqtys( convertToPbString(accountBalance.getUsqtys()) )
                .setPlanned( convertToPbString(accountBalance.getPlanned()) )
                .setSettlebal( convertToPbString(accountBalance.getSettleBal()) )
                .setBankAccId( convertToPbString(accountBalance.getBankAccId()) )
                .setFirmuse( accountBalance.getFirmUse() )
                .build()
                .toByteArray();
    }
}
