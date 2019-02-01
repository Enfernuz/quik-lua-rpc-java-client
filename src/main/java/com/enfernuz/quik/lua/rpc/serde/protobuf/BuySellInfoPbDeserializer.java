package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo.BuySellInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.GetBuySellInfo;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum BuySellInfoPbDeserializer implements Deserializer<BuySellInfo>, FromPbConverter<GetBuySellInfo.BuySellInfo, BuySellInfo> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public BuySellInfo deserialize(final byte[] data) {
        return convert( qlua.rpc.GetBuySellInfo.BuySellInfo.parseFrom(data) );
    }

    @Override
    public BuySellInfo convert(@NotNull final qlua.rpc.GetBuySellInfo.BuySellInfo buySellInfo) {

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
}
