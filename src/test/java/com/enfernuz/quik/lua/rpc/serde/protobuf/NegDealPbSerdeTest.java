package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.NegDeal;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NegDealPbSerdeTest {

    private static SerdeModule sut;

    private static NegDeal expectedObject;
    private static byte[] expectedPbInput;

    private static NegDeal expectedObjectWithOnlyRequiredFields;
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

        expectedObject = NegDeal.builder()
                .negDealNum(1L)
                .negDealTime("2")
                .flags(3)
                .brokerRef("4")
                .userId("5")
                .firmId("6")
                .cpUserId("7")
                .cpFirmId("8")
                .account("9")
                .price("10")
                .qty(11)
                .matchRef("12")
                .settleCode("13")
                .yield("14")
                .accruedInt("15")
                .value("16")
                .price2("17")
                .repoRate("18")
                .refundRate("19")
                .transId("20")
                .clientCode("21")
                .repoEntry(22)
                .repoValue("23")
                .repo2Value("24")
                .repoTerm("25")
                .startDiscount("26")
                .lowerDiscount("27")
                .upperDiscount("28")
                .blockSecurities("29")
                .uid("30")
                .withdrawTime("31")
                .negDealDate("32")
                .balance("33")
                .originRepoValue("34")
                .originQty("35")
                .originDiscount("36")
                .negDealActivationDate("37")
                .negDealActivationTime("38")
                .quoteNo("39")
                .settleCurrency("40")
                .secCode("41")
                .classCode("42")
                .bankAccId("43")
                .withdrawDate("44")
                .linkedOrder("45")
                .activationDateTime(dateTimeEntry)
                .withdrawDateTime(dateTimeEntry)
                .dateTime(dateTimeEntry)
                .build();
        expectedPbInput = QluaStructures.NegDeal.newBuilder()
                .setNegDealNum(1L)
                .setNegDealTime("2")
                .setFlags(3)
                .setBrokerref("4")
                .setUserid("5")
                .setFirmid("6")
                .setCpuserid("7")
                .setCpfirmid("8")
                .setAccount("9")
                .setPrice("10")
                .setQty(11)
                .setMatchref("12")
                .setSettlecode("13")
                .setYield("14")
                .setAccruedint("15")
                .setValue("16")
                .setPrice2("17")
                .setReporate("18")
                .setRefundrate("19")
                .setTransId("20")
                .setClientCode("21")
                .setRepoentry(22)
                .setRepovalue("23")
                .setRepo2Value("24")
                .setRepoterm("25")
                .setStartDiscount("26")
                .setLowerDiscount("27")
                .setUpperDiscount("28")
                .setBlockSecurities("29")
                .setUid("30")
                .setWithdrawTime("31")
                .setNegDealDate("32")
                .setBalance("33")
                .setOriginRepovalue("34")
                .setOriginQty("35")
                .setOriginDiscount("36")
                .setNegDealActivationDate("37")
                .setNegDealActivationTime("38")
                .setQuoteno("39")
                .setSettleCurrency("40")
                .setSecCode("41")
                .setClassCode("42")
                .setBankAccId("43")
                .setWithdrawDate("44")
                .setLinkedorder("45")
                .setActivationDateTime(pbDateTimeEntry)
                .setWithdrawDateTime(pbDateTimeEntry)
                .setDateTime(pbDateTimeEntry)
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = NegDeal.builder()
                .negDealNum(1L)
                .flags(2)
                .qty(3)
                .repoEntry(4)
                .build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.NegDeal.newBuilder()
                .setNegDealNum(1L)
                .setFlags(2)
                .setQty(3)
                .setRepoentry(4)
                .build()
                .toByteArray();
    }

    @Test
    public void testSerialize() {

        final byte[] actual = sut.serialize(expectedObject);

        assertTrue( Arrays.equals(expectedPbInput, actual) );
    }

    @Test
    public void testSerializeWithOnlyRequiredFields() {

        final byte[] actual = sut.serialize(expectedObjectWithOnlyRequiredFields);

        assertTrue( Arrays.equals(expectedPbInputWithOnlyRequiredFields, actual) );
    }

    @Test
    public void testDeserialize() {

        final NegDeal actualObject = sut.deserialize(NegDeal.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializeWithOnlyRequiredFields() {

        final NegDeal actualObject = sut.deserialize(NegDeal.class, expectedPbInputWithOnlyRequiredFields);

        assertEquals(actualObject, expectedObjectWithOnlyRequiredFields);
    }
}
