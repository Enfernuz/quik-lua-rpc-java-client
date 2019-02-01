package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

@Value
public class NegTrade {

    private static final String TRADE_NUMBER = "trade_num";
    private static final String TRADE_DATE = "trade_date";
    private static final String SETTLE_DATE = "settle_date";
    private static final String FLAGS = "flags";
    private static final String BROKER_REF = "brokerref";
    private static final String FIRM_ID = "firmid";
    private static final String ACCOUNT = "account";
    private static final String COUNTERPARTY_FIRM_ID = "cpfirmid";
    private static final String COUNTERPARTY_ACCOUNT = "cpaccount";
    private static final String PRICE = "price";
    private static final String QUANTITY = "qty";
    private static final String VALUE = "value";
    private static final String SETTLE_CODE = "settlecode";
    private static final String REPORT_NUMBER = "report_num";
    private static final String COUNTERPARTY_REPORT_NUMBER = "cpreport_num";
    private static final String ACCRUED_INTEREST = "accruedint";
    private static final String REPO_TRADE_NUMBER = "repotradeno";
    private static final String PRICE_1 = "price1";
    private static final String REPO_RATE = "reporate";
    private static final String PRICE_2 = "price2";
    private static final String CLIENT_CODE = "client_code";
    private static final String TS_COMMISSION = "ts_comission";
    private static final String BALANCE = "balance";
    private static final String SETTLE_TIME = "settle_time";
    private static final String AMOUNT = "amount";
    private static final String REPO_VALUE = "repovalue";
    private static final String REPO_TERM = "repoterm";
    private static final String REPO_2_VALUE = "repo2value";
    private static final String RETURN_VALUE = "return_value";
    private static final String DISCOUNT = "discount";
    private static final String LOWER_DISCOUNT = "lower_discount";
    private static final String UPPER_DISCOUNT = "upper_discount";
    private static final String BLOCK_SECURITIES = "block_securities";
    private static final String URGENCY_FLAG = "urgency_flag";
    private static final String TYPE = "type";
    private static final String OPERATION_TYPE = "operation_type";
    private static final String EXPECTED_DISCOUNT = "expected_discount";
    private static final String EXPECTED_QUANTITY = "expected_quantity";
    private static final String EXPECTED_REPO_VALUE = "expected_repovalue";
    private static final String EXPECTED_REPO_2_VALUE = "expected_repo2value";
    private static final String EXPECTED_RETURN_VALUE = "expected_return_value";
    private static final String ORDER_NUMBER = "order_num";
    private static final String REPORT_TRADE_DATE = "report_trade_date";
    private static final String SETTLED = "settled";
    private static final String CLEARING_TYPE = "clearing_type";
    private static final String REPORT_COMMISSION = "report_comission";
    private static final String COUPON_PAYMENT = "coupon_payment";
    private static final String PRINCIPAL_PAYMENT = "principal_payment";
    private static final String PRINCIPAL_PAYMENT_DATE = "principal_payment_date";
    private static final String NEXT_DAY_SETTLE = "nextdaysettle";
    private static final String SETTLE_CURRENCY = "settle_currency";
    private static final String SECURITY_CODE = "sec_code";
    private static final String CLASS_CODE = "class_code";
    private static final String COMP_VAL = "compval";
    private static final String PARENT_TRADE_NUMBER = "parenttradeno";
    private static final String BANK_ID = "bankid";
    private static final String BANK_ACCOUNT_ID = "bankaccid";
    private static final String PRECISE_BALANCE = "precisebalance";
    private static final String CONFIRM_TIME = "confirmtime";
    private static final String EX_FLAGS = "ex_flags";
    private static final String CONFIRM_REPORT = "confirmreport";
    private static final String EXT_REF = "extref";

    long tradeNum;
    String tradeDate;
    String settleDate;
    int flags;
    String brokerRef;
    String firmId;
    String account;
    String cpFirmId;
    String cpAccount;
    String price;
    int qty;
    String value;
    String settleCode;
    String reportNum;
    String cpReportNum;
    String accruedInt;
    String repoTradeNo;
    String price1;
    String repoRate;
    String price2;
    String clientCode;
    String tsComission;
    String balance;
    String settleTime;
    String amount;
    String repoValue;
    String repoTerm;
    String repo2Value;
    String returnValue;
    String discount;
    String lowerDiscount;
    String upperDiscount;
    String blockSecurities;
    String urgencyFlag;
    int type;
    int operationType;
    String expectedDiscount;
    String expectedQuantity;
    String expectedRepoValue;
    String expectedRepo2Value;
    String expectedReturnValue;
    String orderNum;
    String reportTradeDate;
    int settled;
    int clearingType;
    String reportComission;
    String couponPayment;
    String principalPayment;
    String principalPaymentDate;
    String nextDaySettle;
    String settleCurrency;
    String secCode;
    String classCode;
    String compVal;
    String parentTradeNo;
    String bankId;
    String bankAccId;
    String preciseBalance;
    String confirmTime;
    int exFlags;
    String confirmReport;
    String extRef;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private NegTrade(
            @JsonProperty(value = TRADE_NUMBER, required = true) final long tradeNum,
            @JsonProperty(TRADE_DATE) final String tradeDate,
            @JsonProperty(SETTLE_DATE) final String settleDate,
            @JsonProperty(value = FLAGS, required = true) final int flags,
            @JsonProperty(BROKER_REF) final String brokerRef,
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(ACCOUNT) final String account,
            @JsonProperty(COUNTERPARTY_FIRM_ID) final String cpFirmId,
            @JsonProperty(COUNTERPARTY_ACCOUNT) final String cpAccount,
            @JsonProperty(value = PRICE, required = true) @NonNull final String price,
            @JsonProperty(value = QUANTITY, required = true) final int qty,
            @JsonProperty(VALUE) final String value,
            @JsonProperty(SETTLE_CODE) final String settleCode,
            @JsonProperty(REPORT_NUMBER) final String reportNum,
            @JsonProperty(COUNTERPARTY_REPORT_NUMBER) final String cpReportNum,
            @JsonProperty(ACCRUED_INTEREST) final String accruedInt,
            @JsonProperty(REPO_TRADE_NUMBER) final String repoTradeNo,
            @JsonProperty(PRICE_1) final String price1,
            @JsonProperty(REPO_RATE) final String repoRate,
            @JsonProperty(PRICE_2) final String price2,
            @JsonProperty(CLIENT_CODE) final String clientCode,
            @JsonProperty(TS_COMMISSION) final String tsComission,
            @JsonProperty(BALANCE) final String balance,
            @JsonProperty(SETTLE_TIME) final String settleTime,
            @JsonProperty(AMOUNT) final String amount,
            @JsonProperty(REPO_VALUE) final String repoValue,
            @JsonProperty(REPO_TERM) final String repoTerm,
            @JsonProperty(REPO_2_VALUE) final String repo2Value,
            @JsonProperty(RETURN_VALUE) final String returnValue,
            @JsonProperty(DISCOUNT) final String discount,
            @JsonProperty(LOWER_DISCOUNT) final String lowerDiscount,
            @JsonProperty(UPPER_DISCOUNT) final String upperDiscount,
            @JsonProperty(BLOCK_SECURITIES) final String blockSecurities,
            @JsonProperty(URGENCY_FLAG) final String urgencyFlag,
            @JsonProperty(value = TYPE, required = true) final int type,
            @JsonProperty(value = OPERATION_TYPE, required = true) final int operationType,
            @JsonProperty(EXPECTED_DISCOUNT) final String expectedDiscount,
            @JsonProperty(EXPECTED_QUANTITY) final String expectedQuantity,
            @JsonProperty(EXPECTED_REPO_VALUE) final String expectedRepoValue,
            @JsonProperty(EXPECTED_REPO_2_VALUE) final String expectedRepo2Value,
            @JsonProperty(EXPECTED_RETURN_VALUE) final String expectedReturnValue,
            @JsonProperty(ORDER_NUMBER) final String orderNum,
            @JsonProperty(REPORT_TRADE_DATE) final String reportTradeDate,
            @JsonProperty(value = SETTLED, required = true) final int settled,
            @JsonProperty(value = CLEARING_TYPE, required = true) final int clearingType,
            @JsonProperty(REPORT_COMMISSION) final String reportComission,
            @JsonProperty(COUPON_PAYMENT) final String couponPayment,
            @JsonProperty(PRINCIPAL_PAYMENT) final String principalPayment,
            @JsonProperty(PRINCIPAL_PAYMENT_DATE) final String principalPaymentDate,
            @JsonProperty(NEXT_DAY_SETTLE) final String nextDaySettle,
            @JsonProperty(SETTLE_CURRENCY) final String settleCurrency,
            @JsonProperty(value = SECURITY_CODE, required = true) @NonNull final String secCode,
            @JsonProperty(value = CLASS_CODE, required = true) @NonNull final String classCode,
            @JsonProperty(COMP_VAL) final String compVal,
            @JsonProperty(PARENT_TRADE_NUMBER) final String parentTradeNo,
            @JsonProperty(BANK_ID) final String bankId,
            @JsonProperty(BANK_ACCOUNT_ID) final String bankAccId,
            @JsonProperty(PRECISE_BALANCE) final String preciseBalance,
            @JsonProperty(CONFIRM_TIME) final String confirmTime,
            @JsonProperty(value = EX_FLAGS, required = true) final int exFlags,
            @JsonProperty(CONFIRM_REPORT) final String confirmReport,
            @JsonProperty(EXT_REF) final String extRef) {

        this.tradeNum = tradeNum;
        this.tradeDate = tradeDate;
        this.settleDate = settleDate;
        this.flags = flags;
        this.brokerRef = brokerRef;
        this.firmId = firmId;
        this.account = account;
        this.cpFirmId = cpFirmId;
        this.cpAccount = cpAccount;
        this.price = price;
        this.qty = qty;
        this.value = value;
        this.settleCode = settleCode;
        this.reportNum = reportNum;
        this.cpReportNum = cpReportNum;
        this.accruedInt = accruedInt;
        this.repoTradeNo = repoTradeNo;
        this.price1 = price1;
        this.repoRate = repoRate;
        this.price2 = price2;
        this.clientCode = clientCode;
        this.tsComission = tsComission;
        this.balance = balance;
        this.settleTime = settleTime;
        this.amount = amount;
        this.repoValue = repoValue;
        this.repoTerm = repoTerm;
        this.repo2Value = repo2Value;
        this.returnValue = returnValue;
        this.discount = discount;
        this.lowerDiscount = lowerDiscount;
        this.upperDiscount = upperDiscount;
        this.blockSecurities = blockSecurities;
        this.urgencyFlag = urgencyFlag;
        this.type = type;
        this.operationType = operationType;
        this.expectedDiscount = expectedDiscount;
        this.expectedQuantity = expectedQuantity;
        this.expectedRepoValue = expectedRepoValue;
        this.expectedRepo2Value = expectedRepo2Value;
        this.expectedReturnValue = expectedReturnValue;
        this.orderNum = orderNum;
        this.reportTradeDate = reportTradeDate;
        this.settled = settled;
        this.clearingType = clearingType;
        this.reportComission = reportComission;
        this.couponPayment = couponPayment;
        this.principalPayment = principalPayment;
        this.principalPaymentDate = principalPaymentDate;
        this.nextDaySettle = nextDaySettle;
        this.settleCurrency = settleCurrency;
        this.secCode = secCode;
        this.classCode = classCode;
        this.compVal = compVal;
        this.parentTradeNo = parentTradeNo;
        this.bankId = bankId;
        this.bankAccId = bankAccId;
        this.preciseBalance = preciseBalance;
        this.confirmTime = confirmTime;
        this.exFlags = exFlags;
        this.confirmReport = confirmReport;
        this.extRef = extRef;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(TRADE_NUMBER, tradeNum)
                    .add(TRADE_DATE, tradeDate)
                    .add(SETTLE_DATE, settleDate)
                    .add(FLAGS, flags)
                    .add(BROKER_REF, brokerRef)
                    .add(FIRM_ID, firmId)
                    .add(ACCOUNT, account)
                    .add(COUNTERPARTY_FIRM_ID, cpFirmId)
                    .add(COUNTERPARTY_ACCOUNT, cpAccount)
                    .add(PRICE, price)
                    .add(QUANTITY, qty)
                    .add(VALUE, value)
                    .add(SETTLE_CODE, settleCode)
                    .add(REPORT_NUMBER, reportNum)
                    .add(COUNTERPARTY_REPORT_NUMBER, cpReportNum)
                    .add(ACCRUED_INTEREST, accruedInt)
                    .add(REPO_TRADE_NUMBER, repoTradeNo)
                    .add(PRICE_1, price1)
                    .add(REPO_RATE, repoRate)
                    .add(PRICE_2, price2)
                    .add(CLIENT_CODE, clientCode)
                    .add(TS_COMMISSION, tsComission)
                    .add(BALANCE, balance)
                    .add(SETTLE_TIME, settleTime)
                    .add(AMOUNT, amount)
                    .add(REPO_VALUE, repoValue)
                    .add(REPO_TERM, repoTerm)
                    .add(REPO_2_VALUE, repo2Value)
                    .add(RETURN_VALUE, returnValue)
                    .add(DISCOUNT, discount)
                    .add(LOWER_DISCOUNT, lowerDiscount)
                    .add(UPPER_DISCOUNT, upperDiscount)
                    .add(BLOCK_SECURITIES, blockSecurities)
                    .add(URGENCY_FLAG, urgencyFlag)
                    .add(TYPE, type)
                    .add(OPERATION_TYPE, operationType)
                    .add(EXPECTED_DISCOUNT, expectedDiscount)
                    .add(EXPECTED_QUANTITY, expectedQuantity)
                    .add(EXPECTED_REPO_VALUE, expectedRepoValue)
                    .add(EXPECTED_REPO_2_VALUE, expectedRepo2Value)
                    .add(EXPECTED_RETURN_VALUE, expectedReturnValue)
                    .add(ORDER_NUMBER, orderNum)
                    .add(REPORT_TRADE_DATE, reportTradeDate)
                    .add(SETTLED, settled)
                    .add(CLEARING_TYPE, clearingType)
                    .add(REPORT_COMMISSION, reportComission)
                    .add(COUPON_PAYMENT, couponPayment)
                    .add(PRINCIPAL_PAYMENT, principalPayment)
                    .add(PRINCIPAL_PAYMENT_DATE, principalPaymentDate)
                    .add(NEXT_DAY_SETTLE, nextDaySettle)
                    .add(SETTLE_CURRENCY, settleCurrency)
                    .add(SECURITY_CODE, secCode)
                    .add(CLASS_CODE, classCode)
                    .add(COMP_VAL, compVal)
                    .add(PARENT_TRADE_NUMBER, parentTradeNo)
                    .add(BANK_ID, bankId)
                    .add(BANK_ACCOUNT_ID, bankAccId)
                    .add(PRECISE_BALANCE, preciseBalance)
                    .add(CONFIRM_TIME, confirmTime)
                    .add(EX_FLAGS, exFlags)
                    .add(CONFIRM_REPORT, confirmReport)
                    .add(EXT_REF, extRef)
                    .toString();
        }

        return asString;
    }
}
