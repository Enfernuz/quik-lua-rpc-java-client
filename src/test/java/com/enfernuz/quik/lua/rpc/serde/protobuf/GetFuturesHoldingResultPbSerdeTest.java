package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetFuturesHoldingResultPbSerdeTest {

    private static SerdeModule sut;

    private static GetFuturesHolding.Result expectedObject;
    private static byte[] expectedPbInput;

    private static GetFuturesHolding.Result expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

        final FuturesClientHolding futuresClientHolding = FuturesClientHolding.builder()
                .firmId("1")
                .trdAccId("2")
                .secCode("3")
                .type(4)
                .startBuy("5")
                .startSell("6")
                .todayBuy("7")
                .todaySell("8")
                .totalNet("9")
                .openBuys(10)
                .openSells(11)
                .cbplUsed("12")
                .cbplPlanned("13")
                .varMargin("14")
                .avrPosnPrice("15")
                .positionValue("16")
                .realVarMargin("17")
                .totalVarMargin("18")
                .sessionStatus(19)
                .build();
        final QluaStructures.FuturesClientHolding pbFuturesClientHolding = QluaStructures.FuturesClientHolding.newBuilder()
                .setFirmid("1")
                .setTrdaccid("2")
                .setSecCode("3")
                .setType(4)
                .setStartbuy("5")
                .setStartsell("6")
                .setTodaybuy("7")
                .setTodaysell("8")
                .setTotalnet("9")
                .setOpenbuys(10)
                .setOpensells(11)
                .setCbplused("12")
                .setCbplplanned("13")
                .setVarmargin("14")
                .setAvrposnprice("15")
                .setPositionvalue("16")
                .setRealVarmargin("17")
                .setTotalVarmargin("18")
                .setSessionStatus(19)
                .build();

        expectedObject = GetFuturesHolding.Result.getInstance(futuresClientHolding);
        expectedPbInput = qlua.rpc.GetFuturesHolding.Result.newBuilder()
                .setFuturesHolding(pbFuturesClientHolding)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = GetFuturesHolding.Result.getInstance(null);
        expectedPbInputWithOnlyRequiredFields = qlua.rpc.GetFuturesHolding.Result.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(GetFuturesHolding.Result.class, expectedPbInput));
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
                sut.deserialize(GetFuturesHolding.Result.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
