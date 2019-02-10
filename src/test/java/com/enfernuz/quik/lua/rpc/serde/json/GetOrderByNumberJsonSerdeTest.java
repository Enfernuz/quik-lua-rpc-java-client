package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetOrderByNumber;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetOrderByNumberJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetOrderByNumber.Args> {

        @Override
        public GetOrderByNumber.Args getArgsObject() {
            return new GetOrderByNumber.Args("1", 12345678909876577L);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getOrderByNumber/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetOrderByNumber.Result> {

        private static final int DATETIME_MCS = 1;
        private static final int DATETIME_MS = 2;
        private static final int DATETIME_SEC = 3;
        private static final int DATETIME_MIN = 4;
        private static final int DATETIME_HOUR = 5;
        private static final int DATETIME_DAY = 6;
        private static final int DATETIME_WEEK_DAY = 7;
        private static final int DATETIME_MONTH = 8;
        private static final int DATETIME_YEAR = 9;

        private static final long ORDER_NUM = 12345678909876577L;
        private static final int FLAGS = 2;
        private static final String BROKER_REF = "3";
        private static final String USER_ID = "4";
        private static final String FIRM_ID = "5";
        private static final String ACCOUNT = "6";
        private static final String PRICE = "7";
        private static final int QTY = 8;
        private static final String BALANCE = "9";
        private static final String VALUE = "10";
        private static final String ACCRUED_INT = "11";
        private static final String YIELD = "12";
        private static final String TRANS_ID = "13";
        private static final String CLIENT_CODE = "14";
        private static final String PRICE2 = "15";
        private static final String SETTLE_CODE = "16";
        private static final String UID = "17";
        private static final String CANCELED_UID = "18";
        private static final String EXCHANGE_CODE = "19";
        private static final String ACTIVATION_TIME = "20";
        private static final String LINKED_ORDER = "21";
        private static final String EXPIRY = "22";
        private static final String SEC_CODE = "23";
        private static final String CLASS_CODE = "24";
        private static final String BANK_ACC_ID = "27";
        private static final int VALUE_ENTRY_TYPE = 28;
        private static final String REPO_TERM = "29";
        private static final String REPO_VALUE = "30";
        private static final String REPO2_VALUE = "31";
        private static final String REPO_VALUE_BALANCE = "32";
        private static final String START_DISCOUNT = "33";
        private static final String REJECT_REASON = "34";
        private static final String EXT_ORDER_FLAGS = "35";
        private static final int MIN_QTY = 36;
        private static final int EXEC_TYPE = 37;
        private static final int SIDE_QUALIFIER = 38;
        private static final int ACNT_TYPE = 39;
        private static final int CAPACITY = 40;
        private static final int PASSIVE_ONLY_ORDER = 41;
        private static final int VISIBLE = 42;
        private static final String AWG_PRICE = "43";
        private static final String EXPIRY_TIME = "44";
        private static final String REVISION_NUMBER = "45";
        private static final String PRICE_CURRENCY = "46";
        private static final int EXT_ORDER_STATUS = 47;
        private static final String ACCEPTED_UID = "48";
        private static final String FILLED_VALUE = "49";
        private static final String EXT_REF = "50";
        private static final String SETTLE_CURRENCY = "51";
        private static final String ON_BEHALF_OF_UID = "52";
        private static final int CLIENT_QUALIFIER = 53;
        private static final String CLIENT_SHORT_CODE = "54";
        private static final int INVESTMENT_DECISION_MAKER_QUALIFIER = 55;
        private static final String INVESTMENT_DECISION_MAKER_SHORT_CODE = "56";
        private static final int EXECUTING_TRADER_QUALIFIER = 57;
        private static final String EXECUTING_TRADER_SHORT_CODE = "58";

        private static final int INDX = 2;

        @Override
        public String getJsonPath() {
            return "json/getOrderByNumber/result.json";
        }

        @Override
        public GetOrderByNumber.Result getExpectedObject() {

            final DateTimeEntry dateTimeEntry = DateTimeEntry.builder()
                    .mcs(DATETIME_MCS)
                    .ms(DATETIME_MS)
                    .sec(DATETIME_SEC)
                    .min(DATETIME_MIN)
                    .hour(DATETIME_HOUR)
                    .day(DATETIME_DAY)
                    .weekDay(DATETIME_WEEK_DAY)
                    .month(DATETIME_MONTH)
                    .year(DATETIME_YEAR)
                    .build();

            final Order order = Order.builder()
                    .orderNum(ORDER_NUM)
                    .flags(FLAGS)
                    .brokerRef(BROKER_REF)
                    .userId(USER_ID)
                    .firmId(FIRM_ID)
                    .account(ACCOUNT)
                    .price(PRICE)
                    .qty(QTY)
                    .balance(BALANCE)
                    .value(VALUE)
                    .accruedInt(ACCRUED_INT)
                    .yield(YIELD)
                    .transId(TRANS_ID)
                    .clientCode(CLIENT_CODE)
                    .price2(PRICE2)
                    .settleCode(SETTLE_CODE)
                    .uid(UID)
                    .canceledUid(CANCELED_UID)
                    .exchangeCode(EXCHANGE_CODE)
                    .activationTime(ACTIVATION_TIME)
                    .linkedOrder(LINKED_ORDER)
                    .expiry(EXPIRY)
                    .secCode(SEC_CODE)
                    .classCode(CLASS_CODE)
                    .datetime(dateTimeEntry)
                    .withdrawDatetime(dateTimeEntry)
                    .bankAccId(BANK_ACC_ID)
                    .valueEntryType(VALUE_ENTRY_TYPE)
                    .repoTerm(REPO_TERM)
                    .repoValue(REPO_VALUE)
                    .repo2Value(REPO2_VALUE)
                    .repoValueBalance(REPO_VALUE_BALANCE)
                    .startDiscount(START_DISCOUNT)
                    .rejectReason(REJECT_REASON)
                    .extOrderFlags(EXT_ORDER_FLAGS)
                    .minQty(MIN_QTY)
                    .execType(EXEC_TYPE)
                    .sideQualifier(SIDE_QUALIFIER)
                    .acntType(ACNT_TYPE)
                    .capacity(CAPACITY)
                    .passiveOnlyOrder(PASSIVE_ONLY_ORDER)
                    .visible(VISIBLE)
                    .awgPrice(AWG_PRICE)
                    .expiryTime(EXPIRY_TIME)
                    .revisionNumber(REVISION_NUMBER)
                    .priceCurrency(PRICE_CURRENCY)
                    .extOrderStatus(EXT_ORDER_STATUS)
                    .acceptedUid(ACCEPTED_UID)
                    .filledValue(FILLED_VALUE)
                    .extRef(EXT_REF)
                    .settleCurrency(SETTLE_CURRENCY)
                    .onBehalfOfUid(ON_BEHALF_OF_UID)
                    .clientQualifier(CLIENT_QUALIFIER)
                    .clientShortCode(CLIENT_SHORT_CODE)
                    .investmentDecisionMakerQualifier(INVESTMENT_DECISION_MAKER_QUALIFIER)
                    .investmentDecisionMakerShortCode(INVESTMENT_DECISION_MAKER_SHORT_CODE)
                    .executingTraderQualifier(EXECUTING_TRADER_QUALIFIER)
                    .executingTraderShortCode(EXECUTING_TRADER_SHORT_CODE)
                    .build();


            return GetOrderByNumber.Result.getInstance(order, INDX);
        }
    }
}
