package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import qlua.structs.QluaStructures;

@RunWith(Enclosed.class)
public class FuturesClientHoldingPbSerdeTest {

    private static final String FIRM_ID = "1";
    private static final String TRADING_ACCOUNT_ID = "2";
    private static final String SECURITY_CODE = "3";
    private static final int TYPE = 4;
    private static final String START_BUY = "5";
    private static final String START_SELL = "6";
    private static final String START_NET = "7";
    private static final String TODAY_BUY = "8";
    private static final String TODAY_SELL = "9";
    private static final String TOTAL_NET = "10";
    private static final int OPEN_BUYS = 11;
    private static final int OPEN_SELLS = 12;
    private static final String CBP_L_USED = "13";
    private static final String CBP_L_PLANNED = "14";
    private static final String VAR_MARGIN = "15";
    private static final String AVR_POSITION_PRICE = "16";
    private static final String POSITION_VALUE = "17";
    private static final String REAL_VAR_MARGIN = "18";
    private static final String TOTAL_VAR_MARGIN = "19";
    private static final int SESSION_STATUS = 20;

    public static class FullArgsFuturesClientHoldingPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.FuturesClientHolding, FuturesClientHolding> {

        @Override
        public @NotNull Deserializer<FuturesClientHolding> getDeserializerUnderTest() {
            return FuturesClientHoldingPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public FuturesClientHolding getTargetObject() {

            return FuturesClientHolding.builder()
                    .firmId(FIRM_ID)
                    .trdAccId(TRADING_ACCOUNT_ID)
                    .secCode(SECURITY_CODE)
                    .type(TYPE)
                    .startBuy(START_BUY)
                    .startSell(START_SELL)
                    .startNet(START_NET)
                    .todayBuy(TODAY_BUY)
                    .todaySell(TODAY_SELL)
                    .totalNet(TOTAL_NET)
                    .openBuys(OPEN_BUYS)
                    .openSells(OPEN_SELLS)
                    .cbplUsed(CBP_L_USED)
                    .cbplPlanned(CBP_L_PLANNED)
                    .varMargin(VAR_MARGIN)
                    .avrPosnPrice(AVR_POSITION_PRICE)
                    .positionValue(POSITION_VALUE)
                    .realVarMargin(REAL_VAR_MARGIN)
                    .totalVarMargin(TOTAL_VAR_MARGIN)
                    .sessionStatus(SESSION_STATUS)
                    .build();
        }

        @NotNull
        @Override
        public QluaStructures.FuturesClientHolding getTargetObjectAsPbMessage() {

            return QluaStructures.FuturesClientHolding.newBuilder()
                    .setFirmid(FIRM_ID)
                    .setTrdaccid(TRADING_ACCOUNT_ID)
                    .setSecCode(SECURITY_CODE)
                    .setType(TYPE)
                    .setStartbuy(START_BUY)
                    .setStartsell(START_SELL)
                    .setStartnet(START_NET)
                    .setTodaybuy(TODAY_BUY)
                    .setTodaysell(TODAY_SELL)
                    .setTotalnet(TOTAL_NET)
                    .setOpenbuys(OPEN_BUYS)
                    .setOpensells(OPEN_SELLS)
                    .setCbplused(CBP_L_USED)
                    .setCbplplanned(CBP_L_PLANNED)
                    .setVarmargin(VAR_MARGIN)
                    .setAvrposnprice(AVR_POSITION_PRICE)
                    .setPositionvalue(POSITION_VALUE)
                    .setRealVarmargin(REAL_VAR_MARGIN)
                    .setTotalVarmargin(TOTAL_VAR_MARGIN)
                    .setSessionStatus(SESSION_STATUS)
                    .build();
        }
    }

    public static class OnlyRequiredARgsFuturesClientHoldingPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.FuturesClientHolding, FuturesClientHolding> {

        @Override
        public @NotNull Deserializer<FuturesClientHolding> getDeserializerUnderTest() {
            return FuturesClientHoldingPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public FuturesClientHolding getTargetObject() {

            return FuturesClientHolding.builder()
                    .firmId(FIRM_ID)
                    .trdAccId(TRADING_ACCOUNT_ID)
                    .secCode(SECURITY_CODE)
                    .type(TYPE)
                    .openBuys(OPEN_BUYS)
                    .openSells(OPEN_SELLS)
                    .sessionStatus(SESSION_STATUS)
                    .build();
        }

        @NotNull
        @Override
        public QluaStructures.FuturesClientHolding getTargetObjectAsPbMessage() {

            return QluaStructures.FuturesClientHolding.newBuilder()
                    .setFirmid(FIRM_ID)
                    .setTrdaccid(TRADING_ACCOUNT_ID)
                    .setSecCode(SECURITY_CODE)
                    .setType(TYPE)
                    .setOpenbuys(OPEN_BUYS)
                    .setOpensells(OPEN_SELLS)
                    .setSessionStatus(SESSION_STATUS)
                    .build();
        }
    }
}
