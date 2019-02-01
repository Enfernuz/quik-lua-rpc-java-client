package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.NegTrade;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import qlua.structs.QluaStructures;

@RunWith(Enclosed.class)
public class NegTradePbSerdeTest {

    private static final long TRADE_NUMBER = 1L;
    private static final String TRADE_DATE = "2";
    private static final String SETTLE_DATE = "3";
    private static final int FLAGS = 4;
    private static final String BROKER_REF = "5";
    private static final String FIRM_ID = "6";
    private static final String ACCOUNT = "7";
    private static final String COUNTERPARTY_FIRM_ID = "8";
    private static final String COUNTERPARTY_ACCOUNT = "9";
    private static final String PRICE = "10";
    private static final int QUANTITY = 11;
    private static final String VALUE = "12";
    private static final String SETTLE_CODE = "13";
    private static final String REPORT_NUMBER = "14";
    private static final String COUNTERPARTY_REPORT_NUMBER = "15";
    private static final String ACCRUED_INTEREST = "16";
    private static final String REPO_TRADE_NUMBER = "17";
    private static final String PRICE_1 = "18";
    private static final String REPO_RATE = "19";
    private static final String PRICE_2 = "20";
    private static final String CLIENT_CODE = "21";
    private static final String TS_COMMISSION = "22";
    private static final String BALANCE = "23";
    private static final String SETTLE_TIME = "24";
    private static final String AMOUNT = "25";
    private static final String REPO_VALUE = "26";
    private static final String REPO_TERM = "27";
    private static final String REPO_2_VALUE = "28";
    private static final String RETURN_VALUE = "29";
    private static final String DISCOUNT = "30";
    private static final String LOWER_DISCOUNT = "31";
    private static final String UPPER_DISCOUNT = "32";
    private static final String BLOCK_SECURITIES = "33";
    private static final String URGENCY_FLAG = "34";
    private static final int TYPE = 35;
    private static final int OPERATION_TYPE = 36;
    private static final String EXPECTED_DISCOUNT = "37";
    private static final String EXPECTED_QUANTITY = "38";
    private static final String EXPECTED_REPO_VALUE = "39";
    private static final String EXPECTED_REPO_2_VALUE = "40";
    private static final String EXPECTED_RETURN_VALUE = "41";
    private static final String ORDER_NUMBER = "42";
    private static final String REPORT_TRADE_DATE = "43";
    private static final int SETTLED = 44;
    private static final int CLEARING_TYPE = 45;
    private static final String REPORT_COMMISSION = "46";
    private static final String COUPON_PAYMENT = "47";
    private static final String PRINCIPAL_PAYMENT = "48";
    private static final String PRINCIPAL_PAYMENT_DATE = "49";
    private static final String NEXT_DAY_SETTLE = "50";
    private static final String SETTLE_CURRENCY = "51";
    private static final String SECURITY_CODE = "52";
    private static final String CLASS_CODE = "53";
    private static final String COMP_VAL = "54";
    private static final String PARENT_TRADE_NUMBER = "55";
    private static final String BANK_ID = "56";
    private static final String BANK_ACCOUNT_ID = "57";
    private static final String PRECISE_BALANCE = "58";
    private static final String CONFIRM_TIME = "59";
    private static final int EX_FLAGS = 60;
    private static final String CONFIRM_REPORT = "61";
    private static final String EXT_REF = "62";

    public static class FullArgsNegTradePbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.NegTrade, NegTrade> {

        @Override
        public @NotNull Deserializer<NegTrade> getDeserializerUnderTest() {
            return NegTradePbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public NegTrade getTargetObject() {

            return NegTrade.builder()
                    .tradeNum(TRADE_NUMBER)
                    .tradeDate(TRADE_DATE)
                    .settleDate(SETTLE_DATE)
                    .flags(FLAGS)
                    .brokerRef(BROKER_REF)
                    .firmId(FIRM_ID)
                    .account(ACCOUNT)
                    .cpFirmId(COUNTERPARTY_FIRM_ID)
                    .cpAccount(COUNTERPARTY_ACCOUNT)
                    .price(PRICE)
                    .qty(QUANTITY)
                    .value(VALUE)
                    .settleCode(SETTLE_CODE)
                    .reportNum(REPORT_NUMBER)
                    .cpReportNum(COUNTERPARTY_REPORT_NUMBER)
                    .accruedInt(ACCRUED_INTEREST)
                    .repoTradeNo(REPO_TRADE_NUMBER)
                    .price1(PRICE_1)
                    .repoRate(REPO_RATE)
                    .price2(PRICE_2)
                    .clientCode(CLIENT_CODE)
                    .tsComission(TS_COMMISSION)
                    .balance(BALANCE)
                    .settleTime(SETTLE_TIME)
                    .amount(AMOUNT)
                    .repoValue(REPO_VALUE)
                    .repoTerm(REPO_TERM)
                    .repo2Value(REPO_2_VALUE)
                    .returnValue(RETURN_VALUE)
                    .discount(DISCOUNT)
                    .lowerDiscount(LOWER_DISCOUNT)
                    .upperDiscount(UPPER_DISCOUNT)
                    .blockSecurities(BLOCK_SECURITIES)
                    .urgencyFlag(URGENCY_FLAG)
                    .type(TYPE)
                    .operationType(OPERATION_TYPE)
                    .expectedDiscount(EXPECTED_DISCOUNT)
                    .expectedQuantity(EXPECTED_QUANTITY)
                    .expectedRepoValue(EXPECTED_REPO_VALUE)
                    .expectedRepo2Value(EXPECTED_REPO_2_VALUE)
                    .expectedReturnValue(EXPECTED_RETURN_VALUE)
                    .orderNum(ORDER_NUMBER)
                    .reportTradeDate(REPORT_TRADE_DATE)
                    .settled(SETTLED)
                    .clearingType(CLEARING_TYPE)
                    .reportComission(REPORT_COMMISSION)
                    .couponPayment(COUPON_PAYMENT)
                    .principalPayment(PRINCIPAL_PAYMENT)
                    .principalPaymentDate(PRINCIPAL_PAYMENT_DATE)
                    .nextDaySettle(NEXT_DAY_SETTLE)
                    .settleCurrency(SETTLE_CURRENCY)
                    .secCode(SECURITY_CODE)
                    .classCode(CLASS_CODE)
                    .compVal(COMP_VAL)
                    .parentTradeNo(PARENT_TRADE_NUMBER)
                    .bankId(BANK_ID)
                    .bankAccId(BANK_ACCOUNT_ID)
                    .preciseBalance(PRECISE_BALANCE)
                    .confirmTime(CONFIRM_TIME)
                    .exFlags(EX_FLAGS)
                    .confirmReport(CONFIRM_REPORT)
                    .extRef(EXT_REF)
                    .build();
        }

        @NotNull
        @Override
        public QluaStructures.NegTrade getTargetObjectAsPbMessage() {

            return QluaStructures.NegTrade.newBuilder()
                    .setTradeNum(TRADE_NUMBER)
                    .setTradeDate(TRADE_DATE)
                    .setSettleDate(SETTLE_DATE)
                    .setFlags(FLAGS)
                    .setBrokerref(BROKER_REF)
                    .setFirmid(FIRM_ID)
                    .setAccount(ACCOUNT)
                    .setCpfirmid(COUNTERPARTY_FIRM_ID)
                    .setCpaccount(COUNTERPARTY_ACCOUNT)
                    .setPrice(PRICE)
                    .setQty(QUANTITY)
                    .setValue(VALUE)
                    .setSettlecode(SETTLE_CODE)
                    .setReportNum(REPORT_NUMBER)
                    .setCpreportNum(COUNTERPARTY_REPORT_NUMBER)
                    .setAccruedint(ACCRUED_INTEREST)
                    .setRepotradeno(REPO_TRADE_NUMBER)
                    .setPrice1(PRICE_1)
                    .setReporate(REPO_RATE)
                    .setPrice2(PRICE_2)
                    .setClientCode(CLIENT_CODE)
                    .setTsComission(TS_COMMISSION)
                    .setBalance(BALANCE)
                    .setSettleTime(SETTLE_TIME)
                    .setAmount(AMOUNT)
                    .setRepovalue(REPO_VALUE)
                    .setRepoterm(REPO_TERM)
                    .setRepo2Value(REPO_2_VALUE)
                    .setReturnValue(RETURN_VALUE)
                    .setDiscount(DISCOUNT)
                    .setLowerDiscount(LOWER_DISCOUNT)
                    .setUpperDiscount(UPPER_DISCOUNT)
                    .setBlockSecurities(BLOCK_SECURITIES)
                    .setUrgencyFlag(URGENCY_FLAG)
                    .setType(TYPE)
                    .setOperationType(OPERATION_TYPE)
                    .setExpectedDiscount(EXPECTED_DISCOUNT)
                    .setExpectedQuantity(EXPECTED_QUANTITY)
                    .setExpectedRepovalue(EXPECTED_REPO_VALUE)
                    .setExpectedRepo2Value(EXPECTED_REPO_2_VALUE)
                    .setExpectedReturnValue(EXPECTED_RETURN_VALUE)
                    .setOrderNum(ORDER_NUMBER)
                    .setReportTradeDate(REPORT_TRADE_DATE)
                    .setSettled(SETTLED)
                    .setClearingType(CLEARING_TYPE)
                    .setReportComission(REPORT_COMMISSION)
                    .setCouponPayment(COUPON_PAYMENT)
                    .setPrincipalPayment(PRINCIPAL_PAYMENT)
                    .setPrincipalPaymentDate(PRINCIPAL_PAYMENT_DATE)
                    .setNextdaysettle(NEXT_DAY_SETTLE)
                    .setSettleCurrency(SETTLE_CURRENCY)
                    .setSecCode(SECURITY_CODE)
                    .setClassCode(CLASS_CODE)
                    .setCompval(COMP_VAL)
                    .setParenttradeno(PARENT_TRADE_NUMBER)
                    .setBankid(BANK_ID)
                    .setBankaccid(BANK_ACCOUNT_ID)
                    .setPrecisebalance(PRECISE_BALANCE)
                    .setConfirmtime(CONFIRM_TIME)
                    .setExFlags(EX_FLAGS)
                    .setConfirmreport(CONFIRM_REPORT)
                    .setExtref(EXT_REF)
                    .build();
        }
    }

    public static class OnlyRequiredArgsNegTradePbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.NegTrade, NegTrade> {

        @Override
        public @NotNull Deserializer<NegTrade> getDeserializerUnderTest() {
            return NegTradePbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public NegTrade getTargetObject() {

            return NegTrade.builder()
                    .tradeNum(TRADE_NUMBER)
                    .flags(FLAGS)
                    .price(PRICE)
                    .qty(QUANTITY)
                    .type(TYPE)
                    .operationType(OPERATION_TYPE)
                    .settled(SETTLED)
                    .clearingType(CLEARING_TYPE)
                    .secCode(SECURITY_CODE)
                    .classCode(CLASS_CODE)
                    .exFlags(EX_FLAGS)
                    .build();
        }

        @NotNull
        @Override
        public QluaStructures.NegTrade getTargetObjectAsPbMessage() {

            return QluaStructures.NegTrade.newBuilder()
                    .setTradeNum(TRADE_NUMBER)
                    .setFlags(FLAGS)
                    .setPrice(PRICE)
                    .setQty(QUANTITY)
                    .setType(TYPE)
                    .setOperationType(OPERATION_TYPE)
                    .setSettled(SETTLED)
                    .setClearingType(CLEARING_TYPE)
                    .setSecCode(SECURITY_CODE)
                    .setClassCode(CLASS_CODE)
                    .setExFlags(EX_FLAGS)
                    .build();
        }
    }
}
