package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoney;
import com.enfernuz.quik.lua.rpc.api.structures.Money;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetMoneyResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetMoney.Result, GetMoney.Result> {

    private static final String MONEY_OPEN_LIMIT = "1";
    private static final String MONEY_LIMIT_LOCKED_NON_MARGINAL_VALUE = "2";
    private static final String MONEY_LIMIT_LOCKED = "3";
    private static final String MONEY_OPEN_BALANCE = "4";
    private static final String MONEY_CURRENT_LIMIT = "5";
    private static final String MONEY_CURRENT_BALANCE = "6";
    private static final String MONEY_LIMIT_AVAILABLE = "7";

    @Override
    public @NotNull Deserializer<GetMoney.Result> getDeserializerUnderTest() {
        return GetMoneyResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetMoney.Result getTargetObject() {

        final Money money = Money.builder()
                .moneyOpenLimit(MONEY_OPEN_LIMIT)
                .moneyLimitLockedNonMarginalValue(MONEY_LIMIT_LOCKED_NON_MARGINAL_VALUE)
                .moneyLimitLocked(MONEY_LIMIT_LOCKED)
                .moneyOpenBalance(MONEY_OPEN_BALANCE)
                .moneyCurrentLimit(MONEY_CURRENT_LIMIT)
                .moneyCurrentBalance(MONEY_CURRENT_BALANCE)
                .moneyLimitAvailable(MONEY_LIMIT_AVAILABLE)
                .build();

        return new GetMoney.Result(money);
    }

    @NotNull
    @Override
    public qlua.rpc.GetMoney.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetMoney.Money money = qlua.rpc.GetMoney.Money.newBuilder()
                .setMoneyOpenLimit("1")
                .setMoneyLimitLockedNonmarginalValue("2")
                .setMoneyLimitLocked("3")
                .setMoneyOpenBalance("4")
                .setMoneyCurrentLimit("5")
                .setMoneyCurrentBalance("6")
                .setMoneyLimitAvailable("7")
                .build();

        return qlua.rpc.GetMoney.Result.newBuilder()
                .setMoney(money)
                .build();
    }
}
