package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;
import static org.junit.Assert.assertEquals;

public class MoneyLimitProtobufSerdeTest {

    private static Deserializer<MoneyLimit> sut;

    private static MoneyLimit expectedObject;
    private static byte[] expectedPbInput;

    private static MoneyLimit expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = MoneyLimitPbDeserializer.INSTANCE;

        expectedObject = MoneyLimit.builder()
                .currCode("1")
                .tag("2")
                .firmId("3")
                .clientCode("4")
                .openBal("5")
                .openLimit("6")
                .currentBal("7")
                .currentLimit("8")
                .locked("9")
                .lockedValueCoef("10")
                .lockedMarginValue("11")
                .leverage("12")
                .limitKind(13)
                .build();
        expectedPbInput = convertToPbByteArray(expectedObject);

        expectedObjectWithNullNonRequiredStringFileds = MoneyLimit.builder()
                .limitKind(1)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields = convertToPbByteArray(expectedObjectWithNullNonRequiredStringFileds);
    }

    @Test
    public void testDeserialize() {

        final MoneyLimit actualObject = sut.deserialize(expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final MoneyLimit actualObject = sut.deserialize(expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }

    private static byte[] convertToPbByteArray(@NotNull final MoneyLimit moneyLimit) {

        return QluaStructures.MoneyLimit.newBuilder()
                .setCurrcode( convertToPbString(moneyLimit.getCurrCode()) )
                .setTag( convertToPbString(moneyLimit.getTag()) )
                .setFirmid( convertToPbString(moneyLimit.getFirmId()) )
                .setClientCode( convertToPbString(moneyLimit.getClientCode()) )
                .setOpenbal( convertToPbString(moneyLimit.getOpenBal()) )
                .setOpenlimit( convertToPbString(moneyLimit.getOpenLimit()) )
                .setCurrentbal( convertToPbString(moneyLimit.getCurrentBal()) )
                .setCurrentlimit( convertToPbString(moneyLimit.getCurrentLimit()) )
                .setLocked( convertToPbString(moneyLimit.getLocked()) )
                .setLockedValueCoef( convertToPbString(moneyLimit.getLockedValueCoef()) )
                .setLockedMarginValue( convertToPbString(moneyLimit.getLockedMarginValue()) )
                .setLeverage( convertToPbString(moneyLimit.getLeverage()) )
                .setLimitKind( moneyLimit.getLimitKind() )
                .build()
                .toByteArray();
    }
}
