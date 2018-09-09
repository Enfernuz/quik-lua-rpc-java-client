package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Trade;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TradePbSerdeTest {

    private static SerdeModule sut;

    private static Trade expectedObject;
    private static byte[] expectedPbInput;

    private static Trade expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

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

        expectedObject = Trade.builder()
                .tradeNum(1L)
                .orderNum(2L)
                .brokerRef("3")
                .userId("4")
                .firmId("5")
                .canceledUid("6")
                .account("7")
                .price("8")
                .qty(9)
                .value("10")
                .accruedInt("11")
                .yield("12")
                .settleCode("13")
                .cpFirmId("14")
                .flags(15)
                .price2("16")
                .repoRate("17")
                .clientCode("18")
                .accrued2("19")
                .repoTerm("20")
                .repoValue("21")
                .repo2Value("22")
                .startDiscount("23")
                .lowerDiscount("24")
                .upperDiscount("25")
                .blockSecurities("26")
                .clearingComission("27")
                .exchangeComission("28")
                .techCenterComission("29")
                .settleDate("30")
                .settleCurrency("31")
                .tradeCurrency("32")
                .exchangeCode("33")
                .stationId("34")
                .secCode("35")
                .classCode("36")
                .datetime(dateTimeEntry)
                .bankAccId("38")
                .brokerComission("39")
                .linkedTrade("40")
                .period(41)
                .transId("42")
                .kind(43)
                .clearingBankAccId("44")
                .canceledDatetime(dateTimeEntry)
                .clearingFirmId("46")
                .systemRef("47")
                .uid("48")
                .build();
        expectedPbInput = QluaStructures.Trade.newBuilder()
                .setTradeNum(1L)
                .setOrderNum(2L)
                .setBrokerref("3")
                .setUserid("4")
                .setFirmid("5")
                .setCanceledUid("6")
                .setAccount("7")
                .setPrice("8")
                .setQty(9)
                .setValue("10")
                .setAccruedint("11")
                .setYield("12")
                .setSettlecode("13")
                .setCpfirmid("14")
                .setFlags(15)
                .setPrice2("16")
                .setReporate("17")
                .setClientCode("18")
                .setAccrued2("19")
                .setRepoterm("20")
                .setRepovalue("21")
                .setRepo2Value("22")
                .setStartDiscount("23")
                .setLowerDiscount("24")
                .setUpperDiscount("25")
                .setBlockSecurities("26")
                .setClearingComission("27")
                .setExchangeComission("28")
                .setTechCenterComission("29")
                .setSettleDate("30")
                .setSettleCurrency("31")
                .setTradeCurrency("32")
                .setExchangeCode("33")
                .setStationId("34")
                .setSecCode("35")
                .setClassCode("36")
                .setDatetime(pbDateTimeEntry)
                .setBankAccId("38")
                .setBrokerComission("39")
                .setLinkedTrade("40")
                .setPeriod(41)
                .setTransId("42")
                .setKind(43)
                .setClearingBankAccid("44")
                .setCanceledDatetime(pbDateTimeEntry)
                .setClearingFirmid("46")
                .setSystemRef("47")
                .setUid("48")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = Trade.builder()
                .tradeNum(1L)
                .orderNum(2L)
                .qty(3)
                .flags(4)
                .period(5)
                .kind(6)
                .build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.Trade.newBuilder()
                .setTradeNum(1L)
                .setOrderNum(2L)
                .setQty(3)
                .setFlags(4)
                .setPeriod(5)
                .setKind(6)
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
        assertEquals(expectedObject, sut.deserialize(Trade.class, expectedPbInput));
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
                sut.deserialize(Trade.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
