package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.NegTrade;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NegTradePbSerdeTest {

    private static SerdeModule sut;
    private static PbConverter<QluaStructures.NegTrade, NegTrade> pbConverter;

    private static NegTrade expectedObject;
    private static byte[] expectedPbInput;

    private static NegTrade expectedObjectWithNullNonRequiredStringFileds;
    private static byte[] expectedPbInputWithEmptyNonRequiredStringFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;
        pbConverter = NegTradePbSerde.INSTANCE;

        expectedObject = NegTrade.builder()
                .tradeNum(1L)
                .tradeDate("2")
                .settleDate("3")
                .flags(4)
                .brokerRef("5")
                .firmId("6")
                .account("7")
                .cpFirmId("8")
                .cpAccount("9")
                .price("10")
                .qty(11)
                .value("12")
                .settleCode("13")
                .reportNum("14")
                .cpReportNum("15")
                .accruedInt("16")
                .repoTradeNo("17")
                .price1("18")
                .repoRate("19")
                .price2("20")
                .clientCode("21")
                .tsComission("22")
                .balance("23")
                .settleTime("24")
                .amount("25")
                .repoValue("26")
                .repoTerm("27")
                .repo2Value("28")
                .returnValue("29")
                .discount("30")
                .lowerDiscount("31")
                .upperDiscount("32")
                .blockSecurities("33")
                .urgencyFlag("34")
                .type(35)
                .operationType(36)
                .expectedDiscount("37")
                .expectedQuantity("38")
                .expectedRepoValue("39")
                .expectedRepo2Value("40")
                .expectedReturnValue("41")
                .orderNum("42")
                .reportTradeDate("43")
                .settled(44)
                .clearingType(45)
                .reportComission("46")
                .couponPayment("47")
                .principalPayment("48")
                .principalPaymentDate("49")
                .nextDaySettle("50")
                .settleCurrency("51")
                .secCode("52")
                .classCode("53")
                .compVal("54")
                .parentTradeNo("55")
                .bankId("56")
                .bankAccId("57")
                .preciseBalance("58")
                .confirmTime("59")
                .exFlags(60)
                .confirmReport("61")
                .build();
        expectedPbInput = pbConverter.convertToPb(expectedObject).toByteArray();

        expectedObjectWithNullNonRequiredStringFileds = NegTrade.builder()
                .tradeNum(1L)
                .flags(2)
                .qty(3)
                .type(4)
                .operationType(5)
                .settled(6)
                .clearingType(7)
                .exFlags(8)
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

        final NegTrade actualObject = sut.deserialize(NegTrade.class, expectedPbInput);

        assertEquals(actualObject, expectedObject);
    }

    @Test
    public void testDeserializePbInputWithEmptyNonRequiredStringFields() {

        final NegTrade actualObject = sut.deserialize(NegTrade.class, expectedPbInputWithEmptyNonRequiredStringFields);

        assertEquals(actualObject, expectedObjectWithNullNonRequiredStringFileds);
    }
}
