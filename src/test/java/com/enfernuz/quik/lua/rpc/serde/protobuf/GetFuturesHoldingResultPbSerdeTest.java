package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

public class GetFuturesHoldingResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetFuturesHolding.Result, GetFuturesHolding.Result> {

    private static final String FIRM_ID = "1";
    private static final String TRD_ACC_ID = "2";
    private static final String SEC_CODE = "3";
    private static final int TYPE = 4;
    private static final String START_BUY = "5";
    private static final String START_SELL = "6";
    private static final String TODAY_BUY = "7";
    private static final String TODAY_SELL = "8";
    private static final String TOTAL_NET = "9";
    private static final int OPEN_BUYS = 10;
    private static final int OPEN_SELLS = 11;
    private static final String CBPL_USED = "12";
    private static final String CBPL_PLANNED = "13";
    private static final String VAR_MARGIN = "14";
    private static final String AVR_POSN_PRICE = "15";
    private static final String POSITION_VALUE = "16";
    private static final String REAL_VAR_MARGIN = "17";
    private static final String TOTAL_VAR_MARGIN = "18";
    private static final int SESSION_STATUS = 19;


    @Override
    public @NotNull Deserializer<GetFuturesHolding.Result> getDeserializerUnderTest() {
        return GetFuturesHoldingResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetFuturesHolding.Result getTargetObject() {

        final FuturesClientHolding futuresClientHolding = FuturesClientHolding.builder()
                .firmId(FIRM_ID)
                .trdAccId(TRD_ACC_ID)
                .secCode(SEC_CODE)
                .type(TYPE)
                .startBuy(START_BUY)
                .startSell(START_SELL)
                .todayBuy(TODAY_BUY)
                .todaySell(TODAY_SELL)
                .totalNet(TOTAL_NET)
                .openBuys(OPEN_BUYS)
                .openSells(OPEN_SELLS)
                .cbplUsed(CBPL_USED)
                .cbplPlanned(CBPL_PLANNED)
                .varMargin(VAR_MARGIN)
                .avrPosnPrice(AVR_POSN_PRICE)
                .positionValue(POSITION_VALUE)
                .realVarMargin(REAL_VAR_MARGIN)
                .totalVarMargin(TOTAL_VAR_MARGIN)
                .sessionStatus(SESSION_STATUS)
                .build();

        return GetFuturesHolding.Result.getInstance(futuresClientHolding);
    }

    @NotNull
    @Override
    public qlua.rpc.GetFuturesHolding.Result getTargetObjectAsPbMessage() {

        final QluaStructures.FuturesClientHolding pbFuturesClientHolding = QluaStructures.FuturesClientHolding.newBuilder()
                .setFirmid(FIRM_ID)
                .setTrdaccid(TRD_ACC_ID)
                .setSecCode(SEC_CODE)
                .setType(TYPE)
                .setStartbuy(START_BUY)
                .setStartsell(START_SELL)
                .setTodaybuy(TODAY_BUY)
                .setTodaysell(TODAY_SELL)
                .setTotalnet(TOTAL_NET)
                .setOpenbuys(OPEN_BUYS)
                .setOpensells(OPEN_SELLS)
                .setCbplused(CBPL_USED)
                .setCbplplanned(CBPL_PLANNED)
                .setVarmargin(VAR_MARGIN)
                .setAvrposnprice(AVR_POSN_PRICE)
                .setPositionvalue(POSITION_VALUE)
                .setRealVarmargin(REAL_VAR_MARGIN)
                .setTotalVarmargin(TOTAL_VAR_MARGIN)
                .setSessionStatus(SESSION_STATUS)
                .build();

        return qlua.rpc.GetFuturesHolding.Result.newBuilder()
                .setFuturesHolding(pbFuturesClientHolding)
                .build();
    }
}
