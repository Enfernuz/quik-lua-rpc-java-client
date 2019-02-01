package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

@Value
public class NegDeal {

    private static final String NEG_DEAL_NUM = "neg_deal_num";
    private static final String NEG_DEAL_TIME = "neg_deal_time";
    private static final String FLAGS = "flags";
    private static final String BROKER_REF = "brokerref";
    private static final String USER_ID = "userid";
    private static final String FIRM_ID = "firmid";
    private static final String COUNTERPARTY_USER_ID = "cpuserid";
    private static final String COUNTERPARTY_FIRM_ID = "cpfirmid";
    private static final String ACCOUNT = "account";
    private static final String PRICE = "price";
    private static final String QUANTITY = "qty";
    private static final String MATCH_REF = "matchref";
    private static final String SETTLE_CODE = "settlecode";
    private static final String YIELD = "yield";
    private static final String ACCRUED_INTEREST = "accruedint";
    private static final String VALUE = "value";
    private static final String PRICE_2 = "price2";
    private static final String REPO_RATE = "reporate";
    private static final String REFUND_RATE = "refundrate";
    private static final String TRANSACTION_ID = "trans_id";
    private static final String CLIENT_CODE = "client_code";
    private static final String REPO_ENTRY = "repoentry";
    private static final String REPO_VALUE = "repovalue";
    private static final String REPO_2_VALUE = "repo2value";
    private static final String REPO_TERM = "repoterm";
    private static final String START_DISCOUNT = "start_discount";
    private static final String LOWER_DISCOUNT = "lower_discount";
    private static final String UPPER_DISCOUNT = "upper_discount";
    private static final String BLOCK_SECURITIES = "block_securities";
    private static final String UID = "uid";
    private static final String WITHDRAW_TIME = "withdraw_time";
    private static final String NEG_DEAL_DATE = "neg_deal_date";
    private static final String BALANCE = "balance";
    private static final String ORIGIN_REPO_VALUE = "origin_repovalue";
    private static final String ORIGIN_QUANTITY = "origin_qty";
    private static final String ORIGIN_DISCOUNT = "origin_discount";
    private static final String NEG_DEAL_ACTIVATION_DATE = "neg_deal_activation_date";
    private static final String NEG_DEAL_ACTIVATION_TIME = "neg_deal_activation_time";
    private static final String QUOTE_N_O = "quoteno";
    private static final String SETTLE_CURRENCY = "settle_currency";
    private static final String SECURITY_CODE = "sec_code";
    private static final String CLASS_CODE = "class_code";
    private static final String BANK_ACCOUNT_ID = "bank_acc_id";
    private static final String WITHDRAW_DATE = "withdraw_date";
    private static final String LINKED_ORDER = "linkedorder";
    private static final String ACTIVATION_DATE_TIME = "activation_date_time";
    private static final String WITHDRAW_DATE_TIME = "withdraw_date_time";
    private static final String DATE_TIME = "date_time";
    private static final String L_SECURITY_CODE = "lseccode";
    private static final String CANCELED_UID = "canceled_uid";
    private static final String SYSTEM_REF = "system_ref";
    private static final String PRICE_CURRENCY = "price_currency";
    private static final String ORDER_EXCHANGE_CODE = "order_exchange_code";
    private static final String EXT_REF = "extref";
    private static final String PERIOD = "period";
    private static final String CLIENT_QUALIFIER = "client_qualifier";
    private static final String CLIENT_SHORT_CODE = "client_short_code";
    private static final String INVESTMENT_DECISION_MAKER_QUALIFIER = "investment_decision_maker_qualifier";
    private static final String INVESTMENT_DECISION_MAKER_SHORT_CODE = "investment_decision_maker_short_code";
    private static final String EXECUTING_TRADER_QUALIFIER = "executing_trader_qualifier";
    private static final String EXECUTING_TRADER_SHORT_CODE = "executing_trader_short_code";

    long negDealNum;
    String negDealTime;
    int flags;
    String brokerRef;
    String userId;
    String firmId;
    String cpUserId;
    String cpFirmId;
    String account;
    String price;
    int qty;
    String matchRef;
    String settleCode;
    String yield;
    String accruedInt;
    String value;
    String price2;
    String repoRate;
    String refundRate;
    String transId;
    String clientCode;
    int repoEntry;
    String repoValue;
    String repo2Value;
    String repoTerm;
    String startDiscount;
    String lowerDiscount;
    String upperDiscount;
    String blockSecurities;
    String uid;
    String withdrawTime;
    String negDealDate;
    String balance;
    String originRepoValue;
    String originQty;
    String originDiscount;
    String negDealActivationDate;
    String negDealActivationTime;
    String quoteNo;
    String settleCurrency;
    String secCode;
    String classCode;
    String bankAccId;
    String withdrawDate;
    String linkedOrder;
    DateTimeEntry activationDateTime;
    DateTimeEntry withdrawDateTime;
    DateTimeEntry dateTime;
    String lSecCode;
    String canceledUid;
    String systemRef;
    String priceCurrency;
    String orderExchangeCode;
    String extRef;
    String period;
    int clientQualifier;
    String clientShortCode;
    int investmentDecisionMakerQualifier;
    String investmentDecisionMakerShortCode;
    int executingTraderQualifier;
    String executingTraderShortCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private NegDeal(
            @JsonProperty(value = NEG_DEAL_NUM, required = true) final long negDealNum,
            @JsonProperty(NEG_DEAL_TIME) final String negDealTime,
            @JsonProperty(value = FLAGS, required = true) final int flags,
            @JsonProperty(BROKER_REF) final String brokerRef,
            @JsonProperty(USER_ID) final String userId,
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(COUNTERPARTY_USER_ID) final String cpUserId,
            @JsonProperty(COUNTERPARTY_FIRM_ID) final String cpFirmId,
            @JsonProperty(ACCOUNT) final String account,
            @JsonProperty(value = PRICE, required = true) final String price,
            @JsonProperty(value = QUANTITY, required = true) final int qty,
            @JsonProperty(MATCH_REF) final String matchRef,
            @JsonProperty(SETTLE_CODE) final String settleCode,
            @JsonProperty(YIELD) final String yield,
            @JsonProperty(ACCRUED_INTEREST) final String accruedInt,
            @JsonProperty(VALUE) final String value,
            @JsonProperty(PRICE_2) final String price2,
            @JsonProperty(REPO_RATE) final String repoRate,
            @JsonProperty(REFUND_RATE) final String refundRate,
            @JsonProperty(TRANSACTION_ID) final String transId,
            @JsonProperty(CLIENT_CODE) final String clientCode,
            @JsonProperty(REPO_ENTRY) final int repoEntry,
            @JsonProperty(REPO_VALUE) final String repoValue,
            @JsonProperty(REPO_2_VALUE) final String repo2Value,
            @JsonProperty(REPO_TERM) final String repoTerm,
            @JsonProperty(START_DISCOUNT) final String startDiscount,
            @JsonProperty(LOWER_DISCOUNT) final String lowerDiscount,
            @JsonProperty(UPPER_DISCOUNT) final String upperDiscount,
            @JsonProperty(BLOCK_SECURITIES) final String blockSecurities,
            @JsonProperty(UID) final String uid,
            @JsonProperty(WITHDRAW_TIME) final String withdrawTime,
            @JsonProperty(NEG_DEAL_DATE) final String negDealDate,
            @JsonProperty(BALANCE) final String balance,
            @JsonProperty(ORIGIN_REPO_VALUE) final String originRepoValue,
            @JsonProperty(ORIGIN_QUANTITY) final String originQty,
            @JsonProperty(ORIGIN_DISCOUNT) final String originDiscount,
            @JsonProperty(NEG_DEAL_ACTIVATION_DATE) final String negDealActivationDate,
            @JsonProperty(NEG_DEAL_ACTIVATION_TIME) final String negDealActivationTime,
            @JsonProperty(QUOTE_N_O) final String quoteNo,
            @JsonProperty(SETTLE_CURRENCY) final String settleCurrency,
            @JsonProperty(SECURITY_CODE) final String secCode,
            @JsonProperty(CLASS_CODE) final String classCode,
            @JsonProperty(BANK_ACCOUNT_ID) final String bankAccId,
            @JsonProperty(WITHDRAW_DATE) final String withdrawDate,
            @JsonProperty(LINKED_ORDER) final String linkedOrder,
            @JsonProperty(ACTIVATION_DATE_TIME) final DateTimeEntry activationDateTime,
            @JsonProperty(WITHDRAW_DATE_TIME) final DateTimeEntry withdrawDateTime,
            @JsonProperty(DATE_TIME) final DateTimeEntry dateTime,
            @JsonProperty(L_SECURITY_CODE) final String lSecCode,
            @JsonProperty(CANCELED_UID) final String canceledUid,
            @JsonProperty(SYSTEM_REF) final String systemRef,
            @JsonProperty(PRICE_CURRENCY) final String priceCurrency,
            @JsonProperty(ORDER_EXCHANGE_CODE) final String orderExchangeCode,
            @JsonProperty(EXT_REF) final String extRef,
            @JsonProperty(PERIOD) final String period,
            @JsonProperty(value = CLIENT_QUALIFIER, required = true) final int clientQualifier,
            @JsonProperty(CLIENT_SHORT_CODE) final String clientShortCode,
            @JsonProperty(value = INVESTMENT_DECISION_MAKER_QUALIFIER, required = true) final int investmentDecisionMakerQualifier,
            @JsonProperty(INVESTMENT_DECISION_MAKER_SHORT_CODE) final String investmentDecisionMakerShortCode,
            @JsonProperty(value = EXECUTING_TRADER_QUALIFIER, required = true) final int executingTraderQualifier,
            @JsonProperty(EXECUTING_TRADER_SHORT_CODE) final String executingTraderShortCode) {

        this.negDealNum = negDealNum;
        this.negDealTime = negDealTime;
        this.flags = flags;
        this.brokerRef = brokerRef;
        this.userId = userId;
        this.firmId = firmId;
        this.cpUserId = cpUserId;
        this.cpFirmId = cpFirmId;
        this.account = account;
        this.price = price;
        this.qty = qty;
        this.matchRef = matchRef;
        this.settleCode = settleCode;
        this.yield = yield;
        this.accruedInt = accruedInt;
        this.value = value;
        this.price2 = price2;
        this.repoRate = repoRate;
        this.refundRate = refundRate;
        this.transId = transId;
        this.clientCode = clientCode;
        this.repoEntry = repoEntry;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.repoTerm = repoTerm;
        this.startDiscount = startDiscount;
        this.lowerDiscount = lowerDiscount;
        this.upperDiscount = upperDiscount;
        this.blockSecurities = blockSecurities;
        this.uid = uid;
        this.withdrawTime = withdrawTime;
        this.negDealDate = negDealDate;
        this.balance = balance;
        this.originRepoValue = originRepoValue;
        this.originQty = originQty;
        this.originDiscount = originDiscount;
        this.negDealActivationDate = negDealActivationDate;
        this.negDealActivationTime = negDealActivationTime;
        this.quoteNo = quoteNo;
        this.settleCurrency = settleCurrency;
        this.secCode = secCode;
        this.classCode = classCode;
        this.bankAccId = bankAccId;
        this.withdrawDate = withdrawDate;
        this.linkedOrder = linkedOrder;
        this.activationDateTime = activationDateTime;
        this.withdrawDateTime = withdrawDateTime;
        this.dateTime = dateTime;
        this.lSecCode = lSecCode;
        this.canceledUid = canceledUid;
        this.systemRef = systemRef;
        this.priceCurrency = priceCurrency;
        this.orderExchangeCode = orderExchangeCode;
        this.extRef = extRef;
        this.period = period;
        this.clientQualifier = clientQualifier;
        this.clientShortCode = clientShortCode;
        this.investmentDecisionMakerQualifier = investmentDecisionMakerQualifier;
        this.investmentDecisionMakerShortCode = investmentDecisionMakerShortCode;
        this.executingTraderQualifier = executingTraderQualifier;
        this.executingTraderShortCode = executingTraderShortCode;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(NEG_DEAL_NUM, negDealNum)
                    .add(NEG_DEAL_TIME, negDealTime)
                    .add(FLAGS, flags)
                    .add(BROKER_REF, brokerRef)
                    .add(USER_ID, userId)
                    .add(FIRM_ID, firmId)
                    .add(COUNTERPARTY_USER_ID, cpUserId)
                    .add(COUNTERPARTY_FIRM_ID, cpFirmId)
                    .add(ACCOUNT, account)
                    .add(PRICE, price)
                    .add(QUANTITY, qty)
                    .add(MATCH_REF, matchRef)
                    .add(SETTLE_CODE, settleCode)
                    .add(YIELD, yield)
                    .add(ACCRUED_INTEREST, accruedInt)
                    .add(VALUE, value)
                    .add(PRICE_2, price2)
                    .add(REPO_RATE, repoRate)
                    .add(REFUND_RATE, refundRate)
                    .add(TRANSACTION_ID, transId)
                    .add(CLIENT_CODE, clientCode)
                    .add(REPO_ENTRY, repoEntry)
                    .add(REPO_VALUE, repoValue)
                    .add(REPO_2_VALUE, repo2Value)
                    .add(REPO_TERM, repoTerm)
                    .add(START_DISCOUNT, startDiscount)
                    .add(LOWER_DISCOUNT, lowerDiscount)
                    .add(UPPER_DISCOUNT, upperDiscount)
                    .add(BLOCK_SECURITIES, blockSecurities)
                    .add(UID, uid)
                    .add(WITHDRAW_TIME, withdrawTime)
                    .add(NEG_DEAL_DATE, negDealDate)
                    .add(BALANCE, balance)
                    .add(ORIGIN_REPO_VALUE, originRepoValue)
                    .add(ORIGIN_QUANTITY, originQty)
                    .add(ORIGIN_DISCOUNT, originDiscount)
                    .add(NEG_DEAL_ACTIVATION_DATE, negDealActivationDate)
                    .add(NEG_DEAL_ACTIVATION_TIME, negDealActivationTime)
                    .add(QUOTE_N_O, quoteNo)
                    .add(SETTLE_CURRENCY, settleCurrency)
                    .add(SECURITY_CODE, secCode)
                    .add(CLASS_CODE, classCode)
                    .add(BANK_ACCOUNT_ID, bankAccId)
                    .add(WITHDRAW_DATE, withdrawDate)
                    .add(LINKED_ORDER, linkedOrder)
                    .add(ACTIVATION_DATE_TIME, activationDateTime)
                    .add(WITHDRAW_DATE_TIME, withdrawDateTime)
                    .add(DATE_TIME, dateTime)
                    .add(L_SECURITY_CODE, lSecCode)
                    .add(CANCELED_UID, canceledUid)
                    .add(SYSTEM_REF, systemRef)
                    .add(PRICE_CURRENCY, priceCurrency)
                    .add(ORDER_EXCHANGE_CODE, orderExchangeCode)
                    .add(EXT_REF, extRef)
                    .add(PERIOD, period)
                    .add(CLIENT_QUALIFIER, clientQualifier)
                    .add(CLIENT_SHORT_CODE, clientShortCode)
                    .add(INVESTMENT_DECISION_MAKER_QUALIFIER, investmentDecisionMakerQualifier)
                    .add(INVESTMENT_DECISION_MAKER_SHORT_CODE, investmentDecisionMakerShortCode)
                    .add(EXECUTING_TRADER_QUALIFIER, executingTraderQualifier)
                    .add(EXECUTING_TRADER_SHORT_CODE, executingTraderShortCode)
                    .toString();
        }

        return asString;
    }
}
