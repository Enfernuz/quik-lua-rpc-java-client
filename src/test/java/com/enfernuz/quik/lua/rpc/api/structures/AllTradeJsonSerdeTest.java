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

public class AllTradeJsonSerdeTest {

    private static SerdeModule sut;

    private static AllTrade expectedObject;
    private static String expectedJson;
    private static byte[] expectedJsonAsBytes;

    @BeforeClass
    public static void globalSetup() throws IOException {

        sut = JsonSerdeModule.INSTANCE;

        final DateTimeEntry dateTimeEntry = DateTimeEntry.builder()
                .mcs(1)
                .ms(2)
                .sec(3)
                .min(4)
                .hour(5)
                .day(6)
                .weekDay(7)
                .month(8)
                .year(9)
                .build();

        expectedObject = AllTrade.builder()
                .tradeNum(123456789012345L)
                .flags(2)
                .price("3")
                .qty(4)
                .value("5")
                .accruedInt("6")
                .yield("7")
                .settleCode("8")
                .repoRate("9")
                .repoValue("10")
                .repo2Value("11")
                .repoTerm("12")
                .secCode("13")
                .classCode("14")
                .datetime(dateTimeEntry)
                .period(16)
                .openInterest("17")
                .exchangeCode("18")
                .build();

        expectedJson = Resources.toString(Resources.getResource("json/structures/AllTrade.json"), Charsets.UTF_8);
        expectedJsonAsBytes = trimAndRemoveLineBreaks(expectedJson).getBytes(Charsets.UTF_8);
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedJsonAsBytes, actual) );
    }

    @Test
    public void testDeserialize() {

        final AllTrade actualObject = sut.deserialize(AllTrade.class, expectedJsonAsBytes);

        assertEquals(expectedObject, actualObject);
    }
}