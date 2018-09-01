package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Trade;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TradePbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.Trade, Trade> pbConverter;

    private static Trade expectedObject;
    private static byte[] expectedPbInput;

    private static Trade expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = TradePbSerde.INSTANCE;

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
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = Trade.builder()
                .tradeNum(1L)
                .orderNum(2L)
                .qty(3)
                .flags(4)
                .period(5)
                .kind(6)
                .build();
        expectedPbInputWithEmptyNonRequiredStringFields =
                pbConverter.convertToPb(expectedObjectWithNullNonRequiredStringFileds).toByteArray();
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

        final Trade actualObject = sut.deserialize(Trade.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final Trade actualObject = sut.deserialize(Trade.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
