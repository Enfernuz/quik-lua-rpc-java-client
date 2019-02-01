package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

public class DepoLimitPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.DepoLimit, DepoLimit> {

    private static final String SEC_CODE = "1";
    private static final String TRD_ACC_ID = "2";
    private static final String FIRM_ID = "3";
    private static final String CLIENT_CODE = "4";
    private static final int OPEN_BAL = 5;
    private static final int OPEN_LIMIT = 6;
    private static final int CURRENT_BAL = 7;
    private static final int CURRENT_LIMIT = 8;
    private static final int LOCKED_SELL = 9;
    private static final int LOCKED_BUY = 10;
    private static final String LOCKED_BUY_VALUE = "11";
    private static final String LOCKED_SELL_VALUE = "12";
    private static final String WA_POSITION_PRICE = "13";
    private static final int LIMIT_KIND = 14;

    @Override
    public @NotNull Deserializer<DepoLimit> getDeserializerUnderTest() {
        return DepoLimitPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public DepoLimit getTargetObject() {

        return DepoLimit.builder()
                .secCode(SEC_CODE)
                .trdAccId(TRD_ACC_ID)
                .firmId(FIRM_ID)
                .clientCode(CLIENT_CODE)
                .openBal(OPEN_BAL)
                .openLimit(OPEN_LIMIT)
                .currentBal(CURRENT_BAL)
                .currentLimit(CURRENT_LIMIT)
                .lockedSell(LOCKED_SELL)
                .lockedBuy(LOCKED_BUY)
                .lockedBuyValue(LOCKED_BUY_VALUE)
                .lockedSellValue(LOCKED_SELL_VALUE)
                .waPositionPrice(WA_POSITION_PRICE)
                .limitKind(LIMIT_KIND)
                .build();
    }

    @NotNull
    @Override
    public QluaStructures.DepoLimit getTargetObjectAsPbMessage() {

        return QluaStructures.DepoLimit.newBuilder()
                .setSecCode(SEC_CODE)
                .setTrdaccid(TRD_ACC_ID)
                .setFirmid(FIRM_ID)
                .setClientCode(CLIENT_CODE)
                .setOpenbal(OPEN_BAL)
                .setOpenlimit(OPEN_LIMIT)
                .setCurrentbal(CURRENT_BAL)
                .setCurrentlimit(CURRENT_LIMIT)
                .setLockedSell(LOCKED_SELL)
                .setLockedBuy(LOCKED_BUY)
                .setLockedBuyValue(LOCKED_BUY_VALUE)
                .setLockedSellValue(LOCKED_SELL_VALUE)
                .setWaPositionPrice(WA_POSITION_PRICE)
                .setLimitKind(LIMIT_KIND)
                .build();
    }
}
