package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountPosition;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

public class AccountPositionPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.AccountPosition, AccountPosition> {

    private static final String FIRM_ID = "1";
    private static final String CURRENCY_CODE = "2";
    private static final String TAG = "3";
    private static final String DESCRIPTION = "4";
    private static final String OPEN_BALANCE = "5";
    private static final String CURRENT_POSITION = "6";
    private static final String PLANNED_POSITION = "7";
    private static final String LIMIT_1 = "8";
    private static final String LIMIT_2 = "9";
    private static final String ORDER_BUY = "10";
    private static final String ORDER_SELL = "11";
    private static final String NETTO = "12";
    private static final String PLANNED_BALANCE = "13";
    private static final String DEBIT = "14";
    private static final String CREDIT = "15";
    private static final String BANK_ACCOUNT_ID = "16";
    private static final String MARGIN_CALL = "17";
    private static final String SETTLE_BALANCE = "18";

    @Override
    public @NotNull Deserializer<AccountPosition> getDeserializerUnderTest() {
        return AccountPositionPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public AccountPosition getTargetObject() {

        return AccountPosition.builder()
                .firmId(FIRM_ID)
                .currCode(CURRENCY_CODE)
                .tag(TAG)
                .description(DESCRIPTION)
                .openBal(OPEN_BALANCE)
                .currentPos(CURRENT_POSITION)
                .plannedPos(PLANNED_POSITION)
                .limit1(LIMIT_1)
                .limit2(LIMIT_2)
                .orderBuy(ORDER_BUY)
                .orderSell(ORDER_SELL)
                .netto(NETTO)
                .plannedBal(PLANNED_BALANCE)
                .debit(DEBIT)
                .credit(CREDIT)
                .bankAccId(BANK_ACCOUNT_ID)
                .marginCall(MARGIN_CALL)
                .settleBal(SETTLE_BALANCE)
                .build();
    }

    @NotNull
    @Override
    public QluaStructures.AccountPosition getTargetObjectAsPbMessage() {

        return QluaStructures.AccountPosition.newBuilder()
                .setFirmid(FIRM_ID)
                .setCurrcode(CURRENCY_CODE)
                .setTag(TAG)
                .setDescription(DESCRIPTION)
                .setOpenbal(OPEN_BALANCE)
                .setCurrentpos(CURRENT_POSITION)
                .setPlannedpos(PLANNED_POSITION)
                .setLimit1(LIMIT_1)
                .setLimit2(LIMIT_2)
                .setOrderbuy(ORDER_BUY)
                .setOrdersell(ORDER_SELL)
                .setNetto(NETTO)
                .setPlannedbal(PLANNED_BALANCE)
                .setDebit(DEBIT)
                .setCredit(CREDIT)
                .setBankAccId(BANK_ACCOUNT_ID)
                .setMargincall(MARGIN_CALL)
                .setSettlebal(SETTLE_BALANCE)
                .build();
    }
}
