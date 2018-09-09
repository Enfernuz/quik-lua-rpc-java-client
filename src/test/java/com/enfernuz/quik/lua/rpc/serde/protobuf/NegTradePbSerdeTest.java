package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.NegTrade;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.junit.BeforeClass;
import org.junit.Test;
import qlua.structs.QluaStructures;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NegTradePbSerdeTest {

    private static SerdeModule sut;

    private static NegTrade expectedObject;
    private static byte[] expectedPbInput;

    private static NegTrade expectedObjectWithOnlyRequiredFields;
    private static byte[] expectedPbInputWithOnlyRequiredFields;

    @BeforeClass
    public static void globalSetup() {

        sut = ProtobufSerdeModule.INSTANCE;

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
        expectedPbInput = QluaStructures.NegTrade.newBuilder()
                .setTradeNum(1L)
                .setTradeDate("2")
                .setSettleDate("3")
                .setFlags(4)
                .setBrokerref("5")
                .setFirmid("6")
                .setAccount("7")
                .setCpfirmid("8")
                .setCpaccount("9")
                .setPrice("10")
                .setQty(11)
                .setValue("12")
                .setSettlecode("13")
                .setReportNum("14")
                .setCpreportNum("15")
                .setAccruedint("16")
                .setRepotradeno("17")
                .setPrice1("18")
                .setReporate("19")
                .setPrice2("20")
                .setClientCode("21")
                .setTsComission("22")
                .setBalance("23")
                .setSettleTime("24")
                .setAmount("25")
                .setRepovalue("26")
                .setRepoterm("27")
                .setRepo2Value("28")
                .setReturnValue("29")
                .setDiscount("30")
                .setLowerDiscount("31")
                .setUpperDiscount("32")
                .setBlockSecurities("33")
                .setUrgencyFlag("34")
                .setType(35)
                .setOperationType(36)
                .setExpectedDiscount("37")
                .setExpectedQuantity("38")
                .setExpectedRepovalue("39")
                .setExpectedRepo2Value("40")
                .setExpectedReturnValue("41")
                .setOrderNum("42")
                .setReportTradeDate("43")
                .setSettled(44)
                .setClearingType(45)
                .setReportComission("46")
                .setCouponPayment("47")
                .setPrincipalPayment("48")
                .setPrincipalPaymentDate("49")
                .setNextdaysettle("50")
                .setSettleCurrency("51")
                .setSecCode("52")
                .setClassCode("53")
                .setCompval("54")
                .setParenttradeno("55")
                .setBankid("56")
                .setBankaccid("57")
                .setPrecisebalance("58")
                .setConfirmtime("59")
                .setExFlags(60)
                .setConfirmreport("61")
                .build()
                .toByteArray();

        expectedObjectWithOnlyRequiredFields = NegTrade.builder().build();
        expectedPbInputWithOnlyRequiredFields = QluaStructures.NegTrade.newBuilder().build().toByteArray();
    }

    @Test
    public void testSerialize() {

        assertTrue(
                Arrays.equals(expectedPbInput, sut.serialize(expectedObject))
        );
    }

    @Test
    public void testDeserialize() {
        assertEquals(expectedObject, sut.deserialize(NegTrade.class, expectedPbInput));
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
                sut.deserialize(NegTrade.class, expectedPbInputWithOnlyRequiredFields)
        );
    }
}
