package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.NegDeal;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NegDealPbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.NegDeal, NegDeal> pbConverter;

    private static NegDeal expectedObject;
    private static byte[] expectedPbInput;

    private static NegDeal expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = NegDealPbSerde.INSTANCE;

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
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = NegDeal.builder()
                .negDealNum(1L)
                .flags(2)
                .qty(3)
                .repoEntry(4)
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

        final NegDeal actualObject = sut.deserialize(NegDeal.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final NegDeal actualObject = sut.deserialize(NegDeal.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
