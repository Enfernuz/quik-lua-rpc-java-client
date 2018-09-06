package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AllTrade;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AllTradePbSerdeTest {

    private static SerdeModule sut;

    private static AllTrade expectedObject;
    private static byte[] expectedPbInput;

    private static AllTrade expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

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
        final QluaStructures.DateTimeEntry pbDateTimeEntry = QluaStructures.DateTimeEntry.newBuilder()
                .setMcs(1)
                .setMs(2)
                .setSec(3)
                .setMin(4)
                .setHour(5)
                .setDay(6)
                .setWeekDay(7)
                .setMonth(8)
                .setYear(9)
                .build();

        expectedObject = AllTrade.builder()
                .tradeNum(1L)
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
        expectedPbInput = QluaStructures.AllTrade.newBuilder()
                .setTradeNum(1L)
                .setFlags(2)
                .setPrice("3")
                .setQty(4)
                .setValue("5")
                .setAccruedint("6")
                .setYield("7")
                .setSettlecode("8")
                .setReporate("9")
                .setRepovalue("10")
                .setRepo2Value("11")
                .setRepoterm("12")
                .setSecCode("13")
                .setClassCode("14")
                .setDatetime(pbDateTimeEntry)
                .setPeriod(16)
                .setOpenInterest("17")
                .setExchangeCode("18")
                .build()
                .toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = AllTrade.builder()
                .tradeNum(1L)
                .flags(2)
                .price("3")
                .period(4)
                .datetime(dateTimeEntry)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields = QluaStructures.AllTrade.newBuilder()
                .setTradeNum(1L)
                .setFlags(2)
                .setPrice("3")
                .setPeriod(4)
                .setDatetime(pbDateTimeEntry)
                .build()
                .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testSerializePbInputWithEmptyNonRequiredStringFields() {

        final byte[] actual = sut.serialize(expectedObjectWithNullNonRequiredStringFileds);

        assertTrue( Arrays.equals(expectedPbInputWithEmptyNonRequiredStringFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final AllTrade actualObject = sut.deserialize(AllTrade.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final AllTrade actualObject = sut.deserialize(AllTrade.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
