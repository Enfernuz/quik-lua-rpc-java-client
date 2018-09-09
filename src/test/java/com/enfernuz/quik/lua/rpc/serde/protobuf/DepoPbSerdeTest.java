package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Depo;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepoPbSerdeTest {

    private static SerdeModule sut;

    private static Depo expectedObject;
    private static byte[] expectedPbInput;

    private static Depo expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        expectedObject = Depo.builder()
                .depoLimitLockedBuyValue("1")
                .depoCurrentBalance("2")
                .depoLimitLockedBuy("3")
                .depoLimitLocked("4")
                .depoLimitAvailable("5")
                .depoCurrentLimit("6")
                .depoOpenBalance("7")
                .depoOpenLimit("8")
                .build();
        expectedPbInput = qlua.rpc.GetDepo.Depo.newBuilder()
                .setDepoLimitLockedBuyValue("1")
                .setDepoCurrentBalance("2")
                .setDepoLimitLockedBuy("3")
                .setDepoLimitLocked("4")
                .setDepoLimitAvailable("5")
                .setDepoCurrentLimit("6")
                .setDepoOpenBalance("7")
                .setDepoOpenLimit("8")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = Depo.builder().build();
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.GetDepo.Depo.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(Depo.class, expectedPbInput));
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
                sut.deserialize(Depo.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
