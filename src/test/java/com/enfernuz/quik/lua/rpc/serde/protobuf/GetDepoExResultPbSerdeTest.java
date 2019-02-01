package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepoEx;
import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetDepoExResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetDepoEx.Result, GetDepoEx.Result> {

    private static final String SECURITY_CODE = "1";
    private static final String TRADING_ACCOUNT_ID = "2";
    private static final String FIRM_ID = "3";
    private static final String CLIENT_CODE = "4";
    private static final int OPEN_BALANCE = 5;
    private static final int OPEN_LIMIT = 6;
    private static final int CURRENT_BALANCE = 7;
    private static final int CURRENT_LIMIT = 8;
    private static final int LOCKED_SELL = 9;
    private static final int LOCKED_BUY = 10;
    private static final String LOCKED_BUY_VALUE = "11";
    private static final String LOCKED_SELL_VALUE = "12";
    private static final String WEIGHTED_AVERAGE_POSITION_PRICE = "13";
    private static final int LIMIT_KIND = 14;

    @Override
    public @NotNull Deserializer<GetDepoEx.Result> getDeserializerUnderTest() {
        return GetDepoExResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetDepoEx.Result getTargetObject() {

        final DepoLimit depoEx = DepoLimit.builder()
                .secCode(SECURITY_CODE)
                .trdAccId(TRADING_ACCOUNT_ID)
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .openBal(OPEN_BALANCE)
                .openLimit(OPEN_LIMIT)
                .currentBal(CURRENT_BALANCE)
                .currentLimit(CURRENT_LIMIT)
                .lockedSell(LOCKED_SELL)
                .lockedBuy(LOCKED_BUY)
                .lockedBuyValue(LOCKED_BUY_VALUE)
                .lockedSellValue(LOCKED_SELL_VALUE)
                .waPositionPrice(WEIGHTED_AVERAGE_POSITION_PRICE)
                .limitKind(LIMIT_KIND)
                .build();

        return GetDepoEx.Result.getInstance(depoEx);
    }

    @NotNull
    @Override
    public qlua.rpc.GetDepoEx.Result getTargetObjectAsPbMessage() {

        final qlua.structs.QluaStructures.DepoLimit depoEx = qlua.structs.QluaStructures.DepoLimit.newBuilder()
                .setSecCode(SECURITY_CODE)
                .setTrdaccid(TRADING_ACCOUNT_ID)
                .setFirmid(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setOpenbal(OPEN_BALANCE)
                .setOpenlimit(OPEN_LIMIT)
                .setCurrentbal(CURRENT_BALANCE)
                .setCurrentlimit(CURRENT_LIMIT)
                .setLockedSell(LOCKED_SELL)
                .setLockedBuy(LOCKED_BUY)
                .setLockedBuyValue(LOCKED_BUY_VALUE)
                .setLockedSellValue(LOCKED_SELL_VALUE)
                .setWaPositionPrice(WEIGHTED_AVERAGE_POSITION_PRICE)
                .setLimitKind(LIMIT_KIND)
                .build();

        return qlua.rpc.GetDepoEx.Result.newBuilder()
                .setDepoEx(depoEx)
                .build();
    }
}
