package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CalcBuySell;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class CalcBuySellArgsPbSerdeTest extends AbstractPbSerializationTest<CalcBuySell.Args, qlua.rpc.CalcBuySell.Args> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";
    private static final String CLIENT_CODE = "3";
    private static final String ACCOUNT = "4";
    private static final String PRICE = "5";
    private static final boolean IS_BUY = true;
    private static final boolean IS_MARKET = true;

    @Override
    public @NotNull Serializer<CalcBuySell.Args> getSerializerUnderTest() {
        return CalcBuySellArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.CalcBuySell.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.CalcBuySell.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .setClientCode(CLIENT_CODE)
                .setAccount(ACCOUNT)
                .setPrice(PRICE)
                .setIsBuy(IS_BUY)
                .setIsMarket(IS_MARKET)
                .build();
    }

    @NotNull
    @Override
    public CalcBuySell.Args getTargetObject() {

        return CalcBuySell.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .clientCode(CLIENT_CODE)
                .account(ACCOUNT)
                .price(PRICE)
                .isBuy(IS_BUY)
                .isMarket(IS_MARKET)
                .build();
    }
}
