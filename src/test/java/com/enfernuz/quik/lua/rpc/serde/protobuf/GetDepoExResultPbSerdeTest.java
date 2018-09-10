package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepoEx;
import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetDepoExResultPbSerdeTest {

    private static SerdeModule sut;

    private static GetDepoEx.Result expectedObject;
    private static byte[] expectedPbInput;

    private static GetDepoEx.Result expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        final DepoLimit depoLimit = DepoLimit.builder()
                .secCode("1")
                .trdAccId("2")
                .firmId("3")
                .clientCode("4")
                .openBal(5)
                .openLimit(6)
                .currentBal(7)
                .currentLimit(8)
                .lockedSell(9)
                .lockedBuy(10)
                .lockedBuyValue("11")
                .lockedSellValue("12")
                .awgPositionPrice("13")
                .limitKind(14)
                .build();
        final QluaStructures.DepoLimit pbDepoLimit = QluaStructures.DepoLimit.newBuilder()
                .setSecCode("1")
                .setTrdaccid("2")
                .setFirmid("3")
                .setClientCode("4")
                .setOpenbal(5)
                .setOpenlimit(6)
                .setCurrentbal(7)
                .setCurrentlimit(8)
                .setLockedSell(9)
                .setLockedBuy(10)
                .setLockedBuyValue("11")
                .setLockedSellValue("12")
                .setAwgPositionPrice("13")
                .setLimitKind(14)
                .build();

        expectedObject = GetDepoEx.Result.getInstance(depoLimit);
        expectedPbInput = qlua.rpc.GetDepoEx.Result.newBuilder()
                .setDepoEx(pbDepoLimit)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = GetDepoEx.Result.getInstance(null);
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.GetDepoEx.Result.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(GetDepoEx.Result.class, expectedPbInput));
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
                sut.deserialize(GetDepoEx.Result.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
