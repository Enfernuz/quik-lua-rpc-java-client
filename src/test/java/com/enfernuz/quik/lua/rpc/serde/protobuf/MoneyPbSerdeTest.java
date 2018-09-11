package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Money;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoneyPbSerdeTest {

    private static SerdeModule sut;

    private static Money expectedObject;
    private static byte[] expectedPbInput;

    private static Money expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = Money.builder()
                .moneyOpenLimit("1")
                .moneyLimitLockedNonMarginalValue("2")
                .moneyLimitLocked("3")
                .moneyOpenBalance("4")
                .moneyCurrentLimit("5")
                .moneyCurrentBalance("6")
                .moneyLimitAvailable("7")
                .build();
        expectedPbInput = qlua.rpc.GetMoney.Money.newBuilder()
                .setMoneyOpenLimit("1")
                .setMoneyLimitLockedNonmarginalValue("2")
                .setMoneyLimitLocked("3")
                .setMoneyOpenBalance("4")
                .setMoneyCurrentLimit("5")
                .setMoneyCurrentBalance("6")
                .setMoneyLimitAvailable("7")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = Money.builder().build();
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.GetMoney.Money.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(Money.class, expectedPbInput));
    }

    @Test
    public void testSerialize_WithOnlyRequiredFields() {

        assertTrue(
                Arrays.equals(
                        expectedPbInputWithOnlyRequiredFields,
                        sut.serialize(expectedObjectWithOnlyRequiredFields)
                )
        );
    }

    @Test
    public void testDeserialize_WithOnlyRequiredFields() {

        assertEquals(
                expectedObjectWithOnlyRequiredFields,
                sut.deserialize(Money.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
