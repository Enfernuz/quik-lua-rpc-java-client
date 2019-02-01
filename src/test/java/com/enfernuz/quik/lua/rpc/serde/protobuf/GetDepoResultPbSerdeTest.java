package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.enfernuz.quik.lua.rpc.api.structures.Depo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetDepoResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetDepo.Result, GetDepo.Result> {

    private static final String DEPO_LIMIT_LOCKED_BUY_VALUE = "1";
    private static final String DEPO_CURRENT_BALANCE = "2";
    private static final String DEPO_LIMIT_LOCKED_BUY = "3";
    private static final String DEPO_LIMIT_LOCKED = "4";
    private static final String DEPO_LIMIT_AVAILABLE = "5";
    private static final String DEPO_CURRENT_LIMIT = "6";
    private static final String DEPO_OPEN_BALANCE = "7";
    private static final String DEPO_OPEN_LIMIT = "8";

    @Override
    public @NotNull Deserializer<GetDepo.Result> getDeserializerUnderTest() {
        return GetDepoResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetDepo.Result getTargetObject() {

        final Depo depo = Depo.builder()
                .depoLimitLockedBuyValue(DEPO_LIMIT_LOCKED_BUY_VALUE)
                .depoCurrentBalance(DEPO_CURRENT_BALANCE)
                .depoLimitLockedBuy(DEPO_LIMIT_LOCKED_BUY)
                .depoLimitLocked(DEPO_LIMIT_LOCKED)
                .depoLimitAvailable(DEPO_LIMIT_AVAILABLE)
                .depoCurrentLimit(DEPO_CURRENT_LIMIT)
                .depoOpenBalance(DEPO_OPEN_BALANCE)
                .depoOpenLimit(DEPO_OPEN_LIMIT)
                .build();

        return new GetDepo.Result(depo);
    }

    @NotNull
    @Override
    public qlua.rpc.GetDepo.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetDepo.Depo depo = qlua.rpc.GetDepo.Depo.newBuilder()
                .setDepoLimitLockedBuyValue(DEPO_LIMIT_LOCKED_BUY_VALUE)
                .setDepoCurrentBalance(DEPO_CURRENT_BALANCE)
                .setDepoLimitLockedBuy(DEPO_LIMIT_LOCKED_BUY)
                .setDepoLimitLocked(DEPO_LIMIT_LOCKED)
                .setDepoLimitAvailable(DEPO_LIMIT_AVAILABLE)
                .setDepoCurrentLimit(DEPO_CURRENT_LIMIT)
                .setDepoOpenBalance(DEPO_OPEN_BALANCE)
                .setDepoOpenLimit(DEPO_OPEN_LIMIT)
                .build();

        return qlua.rpc.GetDepo.Result.newBuilder()
                .setDepo(depo)
                .build();
    }
}
