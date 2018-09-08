package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo.BuySellInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum BuySellInfoPbSerde implements Serde<BuySellInfo>, PbConverter<qlua.rpc.GetBuySellInfo.BuySellInfo, BuySellInfo> {

    INSTANCE;

    @Override
    public byte[] serialize(final BuySellInfo dateTimeEntry) {
        return convertToPb(dateTimeEntry).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public BuySellInfo deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetBuySellInfo.BuySellInfo.parseFrom(data) );
    }

    @Override
    public BuySellInfo convertFromPb(@NotNull final qlua.rpc.GetBuySellInfo.BuySellInfo buySellInfo) {

        return BuySellInfo.builder()
                .isMarginSec( convertFromPbString(buySellInfo.getIsMarginSec()) )
                .isAssetSec( convertFromPbString(buySellInfo.getIsAssetSec()) )
                .balance( convertFromPbString(buySellInfo.getBalance()) )
                .canBuy( convertFromPbString(buySellInfo.getCanBuy()) )
                .canSell( convertFromPbString(buySellInfo.getCanSell()) )
                .positionValuation( convertFromPbString(buySellInfo.getPositionValuation()) )
                .value( convertFromPbString(buySellInfo.getValue()) )
                .openValue( convertFromPbString(buySellInfo.getOpenValue()) )
                .limLong( convertFromPbString(buySellInfo.getLimLong()) )
                .longCoef( convertFromPbString(buySellInfo.getLongCoef()) )
                .limShort( convertFromPbString(buySellInfo.getLimShort()) )
                .shortCoef( convertFromPbString(buySellInfo.getShortCoef()) )
                .valueCoef( convertFromPbString(buySellInfo.getValueCoef()) )
                .openValueCoef( convertFromPbString(buySellInfo.getOpenValueCoef()) )
                .share( convertFromPbString(buySellInfo.getShare()) )
                .shortWaPrice( convertFromPbString(buySellInfo.getShortWaPrice()) )
                .longWaPrice( convertFromPbString(buySellInfo.getLongWaPrice()) )
                .profitLoss( convertFromPbString(buySellInfo.getProfitLoss()) )
                .spreadHc( convertFromPbString(buySellInfo.getSpreadHc()) )
                .canBuyOwn( convertFromPbString(buySellInfo.getCanBuyOwn()) )
                .canSellOwn( convertFromPbString(buySellInfo.getCanSellOwn()) )
                .build();
    }

    @Override
    public qlua.rpc.GetBuySellInfo.BuySellInfo convertToPb(@NotNull final BuySellInfo buySellInfo) {

        return qlua.rpc.GetBuySellInfo.BuySellInfo.newBuilder()
                .setIsMarginSec( convertToPbString(buySellInfo.getIsMarginSec()) )
                .setIsAssetSec( convertToPbString(buySellInfo.getIsAssetSec()) )
                .setBalance( convertToPbString(buySellInfo.getBalance()) )
                .setCanBuy( convertToPbString(buySellInfo.getCanBuy()) )
                .setCanSell( convertToPbString(buySellInfo.getCanSell()) )
                .setPositionValuation( convertToPbString(buySellInfo.getPositionValuation()) )
                .setValue( convertToPbString(buySellInfo.getValue()) )
                .setOpenValue( convertToPbString(buySellInfo.getOpenValue()) )
                .setLimLong( convertToPbString(buySellInfo.getLimLong()) )
                .setLongCoef( convertToPbString(buySellInfo.getLongCoef()) )
                .setLimShort( convertToPbString(buySellInfo.getLimShort()) )
                .setShortCoef( convertToPbString(buySellInfo.getShortCoef()) )
                .setValueCoef( convertToPbString(buySellInfo.getValueCoef()) )
                .setOpenValueCoef( convertToPbString(buySellInfo.getOpenValueCoef()) )
                .setShare( convertToPbString(buySellInfo.getShare()) )
                .setShortWaPrice( convertToPbString(buySellInfo.getShortWaPrice()) )
                .setLongWaPrice( convertToPbString(buySellInfo.getLongWaPrice()) )
                .setProfitLoss( convertToPbString(buySellInfo.getProfitLoss()) )
                .setSpreadHc( convertToPbString(buySellInfo.getSpreadHc()) )
                .setCanBuyOwn( convertToPbString(buySellInfo.getCanBuyOwn()) )
                .setCanSellOwn( convertToPbString(buySellInfo.getCanSellOwn()) )
                .build();
    }
}
