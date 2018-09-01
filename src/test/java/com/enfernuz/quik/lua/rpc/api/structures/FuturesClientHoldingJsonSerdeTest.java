package com.enfernuz.quik.lua.rpc.api.structures;

import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.json.JsonSerdeModule;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static com.enfernuz.quik.lua.rpc.serde.SerdeUtils.trimAndRemoveLineBreaks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FuturesClientHoldingJsonSerdeTest {

    private static SerdeModule sut;

    private static FuturesClientHolding futuresClientHolding;
    private static String futuresClientHoldingAsJson;
    private static byte[] futuresClientHoldingAsJsonBytes;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = JsonSerdeModule.INSTANCE;

        futuresClientHolding = FuturesClientHolding.builder()
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

        futuresClientHoldingAsJson =
                Resources.toString(Resources.getResource("json/structures/FuturesClientHolding.json"), Charsets.UTF_8);
        futuresClientHoldingAsJsonBytes = trimAndRemoveLineBreaks(futuresClientHoldingAsJson).getBytes(Charsets.UTF_8);
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(futuresClientHolding);

        assertTrue( Arrays.equals(futuresClientHoldingAsJsonBytes, actual) );
    }

    @Test
    public void testDeserialize() {

        final FuturesClientHolding actual = sut.deserialize(FuturesClientHolding.class, futuresClientHoldingAsJsonBytes);

        assertEquals(futuresClientHolding, actual);
    }
}
