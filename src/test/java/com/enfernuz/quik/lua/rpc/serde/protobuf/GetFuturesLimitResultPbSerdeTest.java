package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesLimit;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

public class GetFuturesLimitResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetFuturesLimit.Result, GetFuturesLimit.Result> {

    private static final String FIRM_ID = "1";
    private static final String TRD_ACC_ID = "2";
    private static final int LIMIT_TYPE = 3;
    private static final String LIQUIDITY_COEF = "4";
    private static final String CBP_PREV_LIMIT = "5";
    private static final String CBP_LIMIT = "6";
    private static final String CBPL_USED = "7";
    private static final String CBPL_PLANNED = "8";
    private static final String VAR_MARGIN = "9";
    private static final String ACCRUED_INT = "10";
    private static final String CBPL_USED_FOR_ORDERS = "11";
    private static final String CBPL_USED_FOR_POSITIONS = "12";
    private static final String OPTIONS_PREMIUM = "13";
    private static final String TS_COMISSION = "14";
    private static final String KGO = "15";
    private static final String CURR_CODE = "16";
    private static final String REAL_VAR_MARGIN = "17";

    @Override
    public @NotNull Deserializer<GetFuturesLimit.Result> getDeserializerUnderTest() {
        return GetFuturesLimitResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetFuturesLimit.Result getTargetObject() {

        final FuturesLimit futuresLimit = FuturesLimit.builder()
                .firmId(FIRM_ID)
                .trdAccId(TRD_ACC_ID)
                .limitType(LIMIT_TYPE)
                .liquidityCoef(LIQUIDITY_COEF)
                .cbpPrevLimit(CBP_PREV_LIMIT)
                .cbpLimit(CBP_LIMIT)
                .cbplUsed(CBPL_USED)
                .cbplPlanned(CBPL_PLANNED)
                .varMargin(VAR_MARGIN)
                .accruedInt(ACCRUED_INT)
                .cbplUsedForOrders(CBPL_USED_FOR_ORDERS)
                .cbplUsedForPositions(CBPL_USED_FOR_POSITIONS)
                .optionsPremium(OPTIONS_PREMIUM)
                .tsComission(TS_COMISSION)
                .kgo(KGO)
                .currCode(CURR_CODE)
                .realVarMargin(REAL_VAR_MARGIN)
                .build();

        return GetFuturesLimit.Result.getInstance(futuresLimit);
    }

    @NotNull
    @Override
    public qlua.rpc.GetFuturesLimit.Result getTargetObjectAsPbMessage() {

        final QluaStructures.FuturesLimit pbFuturesLimit = QluaStructures.FuturesLimit.newBuilder()
                .setFirmid(FIRM_ID)
                .setTrdaccid(TRD_ACC_ID)
                .setLimitType(LIMIT_TYPE)
                .setLiquidityCoef(LIQUIDITY_COEF)
                .setCbpPrevLimit(CBP_PREV_LIMIT)
                .setCbplimit(CBP_LIMIT)
                .setCbplused(CBPL_USED)
                .setCbplplanned(CBPL_PLANNED)
                .setVarmargin(VAR_MARGIN)
                .setAccruedint(ACCRUED_INT)
                .setCbplusedForOrders(CBPL_USED_FOR_ORDERS)
                .setCbplusedForPositions(CBPL_USED_FOR_POSITIONS)
                .setOptionsPremium(OPTIONS_PREMIUM)
                .setTsComission(TS_COMISSION)
                .setKgo(KGO)
                .setCurrcode(CURR_CODE)
                .setRealVarmargin(REAL_VAR_MARGIN)
                .build();

        return qlua.rpc.GetFuturesLimit.Result.newBuilder()
                .setFuturesLimit(pbFuturesLimit)
                .build();
    }
}
