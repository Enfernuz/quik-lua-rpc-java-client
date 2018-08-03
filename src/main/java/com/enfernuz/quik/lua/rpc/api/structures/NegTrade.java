package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class NegTrade {

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

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private NegTrade(
            final long tradeNum,
            final String tradeDate,
            final String settleDate,
            final int flags,
            final String brokerRef,
            final String firmId,
            final String account,
            final String cpFirmId,
            final String cpAccount,
            final String price,
            final int qty,
            final String value,
            final String settleCode,
            final String reportNum,
            final String cpReportNum,
            final String accruedInt,
            final String repoTradeNo,
            final String price1,
            final String repoRate,
            final String price2,
            final String clientCode,
            final String tsComission,
            final String balance,
            final String settleTime,
            final String amount,
            final String repoValue,
            final String repoTerm,
            final String repo2Value,
            final String returnValue,
            final String discount,
            final String lowerDiscount,
            final String upperDiscount,
            final String blockSecurities,
            final String urgencyFlag,
            final int type,
            final int operationType,
            final String expectedDiscount,
            final String expectedQuantity,
            final String expectedRepoValue,
            final String expectedRepo2Value,
            final String expectedReturnValue,
            final String orderNum,
            final String reportTradeDate,
            final int settled,
            final int clearingType,
            final String reportComission,
            final String couponPayment,
            final String principalPayment,
            final String principalPaymentDate,
            final String nextDaySettle,
            final String settleCurrency,
            final String secCode,
            final String classCode,
            final String compVal,
            final String parentTradeNo,
            final String bankId,
            final String bankAccId,
            final String preciseBalance,
            final String confirmTime,
            final int exFlags,
            final String confirmReport) {

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
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof NegTrade) ) {
            return false;
        } else {
            final NegTrade negTrade = (NegTrade) o;
            return tradeNum == negTrade.tradeNum &&
                    flags == negTrade.flags &&
                    qty == negTrade.qty &&
                    type == negTrade.type &&
                    operationType == negTrade.operationType &&
                    settled == negTrade.settled &&
                    clearingType == negTrade.clearingType &&
                    exFlags == negTrade.exFlags &&
                    Objects.equals(tradeDate, negTrade.tradeDate) &&
                    Objects.equals(settleDate, negTrade.settleDate) &&
                    Objects.equals(brokerRef, negTrade.brokerRef) &&
                    Objects.equals(firmId, negTrade.firmId) &&
                    Objects.equals(account, negTrade.account) &&
                    Objects.equals(cpFirmId, negTrade.cpFirmId) &&
                    Objects.equals(cpAccount, negTrade.cpAccount) &&
                    Objects.equals(price, negTrade.price) &&
                    Objects.equals(value, negTrade.value) &&
                    Objects.equals(settleCode, negTrade.settleCode) &&
                    Objects.equals(reportNum, negTrade.reportNum) &&
                    Objects.equals(cpReportNum, negTrade.cpReportNum) &&
                    Objects.equals(accruedInt, negTrade.accruedInt) &&
                    Objects.equals(repoTradeNo, negTrade.repoTradeNo) &&
                    Objects.equals(price1, negTrade.price1) &&
                    Objects.equals(repoRate, negTrade.repoRate) &&
                    Objects.equals(price2, negTrade.price2) &&
                    Objects.equals(clientCode, negTrade.clientCode) &&
                    Objects.equals(tsComission, negTrade.tsComission) &&
                    Objects.equals(balance, negTrade.balance) &&
                    Objects.equals(settleTime, negTrade.settleTime) &&
                    Objects.equals(amount, negTrade.amount) &&
                    Objects.equals(repoValue, negTrade.repoValue) &&
                    Objects.equals(repoTerm, negTrade.repoTerm) &&
                    Objects.equals(repo2Value, negTrade.repo2Value) &&
                    Objects.equals(returnValue, negTrade.returnValue) &&
                    Objects.equals(discount, negTrade.discount) &&
                    Objects.equals(lowerDiscount, negTrade.lowerDiscount) &&
                    Objects.equals(upperDiscount, negTrade.upperDiscount) &&
                    Objects.equals(blockSecurities, negTrade.blockSecurities) &&
                    Objects.equals(urgencyFlag, negTrade.urgencyFlag) &&
                    Objects.equals(expectedDiscount, negTrade.expectedDiscount) &&
                    Objects.equals(expectedQuantity, negTrade.expectedQuantity) &&
                    Objects.equals(expectedRepoValue, negTrade.expectedRepoValue) &&
                    Objects.equals(expectedRepo2Value, negTrade.expectedRepo2Value) &&
                    Objects.equals(expectedReturnValue, negTrade.expectedReturnValue) &&
                    Objects.equals(orderNum, negTrade.orderNum) &&
                    Objects.equals(reportTradeDate, negTrade.reportTradeDate) &&
                    Objects.equals(reportComission, negTrade.reportComission) &&
                    Objects.equals(couponPayment, negTrade.couponPayment) &&
                    Objects.equals(principalPayment, negTrade.principalPayment) &&
                    Objects.equals(principalPaymentDate, negTrade.principalPaymentDate) &&
                    Objects.equals(nextDaySettle, negTrade.nextDaySettle) &&
                    Objects.equals(settleCurrency, negTrade.settleCurrency) &&
                    Objects.equals(secCode, negTrade.secCode) &&
                    Objects.equals(classCode, negTrade.classCode) &&
                    Objects.equals(compVal, negTrade.compVal) &&
                    Objects.equals(parentTradeNo, negTrade.parentTradeNo) &&
                    Objects.equals(bankId, negTrade.bankId) &&
                    Objects.equals(bankAccId, negTrade.bankAccId) &&
                    Objects.equals(preciseBalance, negTrade.preciseBalance) &&
                    Objects.equals(confirmTime, negTrade.confirmTime) &&
                    Objects.equals(confirmReport, negTrade.confirmReport);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    tradeNum,
                    tradeDate,
                    settleDate,
                    flags,
                    brokerRef,
                    firmId,
                    account,
                    cpFirmId,
                    cpAccount,
                    price,
                    qty,
                    value,
                    settleCode,
                    reportNum,
                    cpReportNum,
                    accruedInt,
                    repoTradeNo,
                    price1,
                    repoRate,
                    price2,
                    clientCode,
                    tsComission,
                    balance,
                    settleTime,
                    amount,
                    repoValue,
                    repoTerm,
                    repo2Value,
                    returnValue,
                    discount,
                    lowerDiscount,
                    upperDiscount,
                    blockSecurities,
                    urgencyFlag,
                    type,
                    operationType,
                    expectedDiscount,
                    expectedQuantity,
                    expectedRepoValue,
                    expectedRepo2Value,
                    expectedReturnValue,
                    orderNum,
                    reportTradeDate,
                    settled,
                    clearingType,
                    reportComission,
                    couponPayment,
                    principalPayment,
                    principalPaymentDate,
                    nextDaySettle,
                    settleCurrency,
                    secCode,
                    classCode,
                    compVal,
                    parentTradeNo,
                    bankId,
                    bankAccId,
                    preciseBalance,
                    confirmTime,
                    exFlags,
                    confirmReport
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("trade_num", tradeNum)
                    .add("trade_date", tradeDate)
                    .add("settle_date", settleDate)
                    .add("flags", flags)
                    .add("brokerref", brokerRef)
                    .add("firmid", firmId)
                    .add("account", account)
                    .add("cpfirmid", cpFirmId)
                    .add("cpaccount", cpAccount)
                    .add("price", price)
                    .add("qty", qty)
                    .add("value", value)
                    .add("settlecode", settleCode)
                    .add("report_num", reportNum)
                    .add("cpreport_num", cpReportNum)
                    .add("accruedint", accruedInt)
                    .add("repotradeno", repoTradeNo)
                    .add("price1", price1)
                    .add("reporate", repoRate)
                    .add("price2", price2)
                    .add("client_code", clientCode)
                    .add("ts_comission", tsComission)
                    .add("balance", balance)
                    .add("settle_time", settleTime)
                    .add("amount", amount)
                    .add("repovalue", repoValue)
                    .add("repoterm", repoTerm)
                    .add("repo2value", repo2Value)
                    .add("return_value", returnValue)
                    .add("discount", discount)
                    .add("lower_discount", lowerDiscount)
                    .add("upper_discount", upperDiscount)
                    .add("block_securities", blockSecurities)
                    .add("urgency_flag", urgencyFlag)
                    .add("type", type)
                    .add("operation_type", operationType)
                    .add("expected_discount", expectedDiscount)
                    .add("expected_quantity", expectedQuantity)
                    .add("expected_repovalue", expectedRepoValue)
                    .add("expected_repo2value", expectedRepo2Value)
                    .add("expected_return_value", expectedReturnValue)
                    .add("order_num", orderNum)
                    .add("report_trade_date", reportTradeDate)
                    .add("settled", settled)
                    .add("clearing_type", clearingType)
                    .add("report_comission", reportComission)
                    .add("coupon_payment", couponPayment)
                    .add("principal_payment", principalPayment)
                    .add("principal_payment_date", principalPaymentDate)
                    .add("nextdaysettle", nextDaySettle)
                    .add("settle_currency", settleCurrency)
                    .add("sec_code", secCode)
                    .add("class_code", classCode)
                    .add("compval", compVal)
                    .add("parenttradeno", parentTradeNo)
                    .add("bankid", bankId)
                    .add("bankaccid", bankAccId)
                    .add("precisebalance", preciseBalance)
                    .add("confirmtime", confirmTime)
                    .add("ex_flags", exFlags)
                    .add("confirmreport", confirmReport)
                    .toString();
        }

        return asString;
    }
}
