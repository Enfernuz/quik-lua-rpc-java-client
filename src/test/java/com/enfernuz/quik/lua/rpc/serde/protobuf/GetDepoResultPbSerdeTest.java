package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.enfernuz.quik.lua.rpc.api.structures.Depo;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetDepoResultPbSerdeTest {

    private static SerdeModule sut;

    private static GetDepo.Result expectedObject;
    private static byte[] expectedPbInput;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        final Depo depo = Depo.builder()
                .depoLimitLockedBuyValue("1")
                .depoCurrentBalance("2")
                .depoLimitLockedBuy("3")
                .depoLimitLocked("4")
                .depoLimitAvailable("5")
                .depoCurrentLimit("6")
                .depoOpenBalance("7")
                .depoOpenLimit("8")
                .build();
        final qlua.rpc.GetDepo.Depo pbDepo = qlua.rpc.GetDepo.Depo.newBuilder()
                .setDepoLimitLockedBuyValue("1")
                .setDepoCurrentBalance("2")
                .setDepoLimitLockedBuy("3")
                .setDepoLimitLocked("4")
                .setDepoLimitAvailable("5")
                .setDepoCurrentLimit("6")
                .setDepoOpenBalance("7")
                .setDepoOpenLimit("8")
                .build();

        expectedObject = new GetDepo.Result(depo);
        expectedPbInput = qlua.rpc.GetDepo.Result.newBuilder()
                .setDepo(pbDepo)
                .build()
                .toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(GetDepo.Result.class, expectedPbInput));
    }
}
