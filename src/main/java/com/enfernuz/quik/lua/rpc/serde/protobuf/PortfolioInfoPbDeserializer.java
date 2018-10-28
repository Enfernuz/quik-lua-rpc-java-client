package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.GetPortfolioInfo;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum PortfolioInfoPbDeserializer implements Deserializer<PortfolioInfo>, FromPbConverter<GetPortfolioInfo.PortfolioInfo, PortfolioInfo> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public PortfolioInfo deserialize(final byte[] data) {
        return convert(qlua.rpc.GetPortfolioInfo.PortfolioInfo.parseFrom(data));
    }

    @Override
    public PortfolioInfo convert(@NotNull qlua.rpc.GetPortfolioInfo.PortfolioInfo portfolioInfo) {

        return PortfolioInfo.builder()
                .isLeverage( convertFromPbString(portfolioInfo.getIsLeverage()) )
                .inAssets( convertFromPbString(portfolioInfo.getInAssets()) )
                .leverage( convertFromPbString(portfolioInfo.getLeverage()) )
                .openLimit( convertFromPbString(portfolioInfo.getOpenLimit()) )
                .valShort( convertFromPbString(portfolioInfo.getValShort()) )
                .valLong( convertFromPbString(portfolioInfo.getValLong()) )
                .valLongMargin( convertFromPbString(portfolioInfo.getValLongMargin()) )
                .valLongAsset( convertFromPbString(portfolioInfo.getValLongAsset()) )
                .assets( convertFromPbString(portfolioInfo.getAssets()) )
                .curLeverage( convertFromPbString(portfolioInfo.getCurLeverage()) )
                .margin( convertFromPbString(portfolioInfo.getMargin()) )
                .limAll( convertFromPbString(portfolioInfo.getLimAll()) )
                .avLimAll( convertFromPbString(portfolioInfo.getAvLimAll()) )
                .lockedBuy( convertFromPbString(portfolioInfo.getLockedBuy()) )
                .lockedBuyMargin( convertFromPbString(portfolioInfo.getLockedBuyMargin()) )
                .lockedBuyAsset( convertFromPbString(portfolioInfo.getLockedBuyAsset()) )
                .lockedSell( convertFromPbString(portfolioInfo.getLockedSell()) )
                .lockedValueCoef( convertFromPbString(portfolioInfo.getLockedValueCoef()) )
                .inAllAssets( convertFromPbString(portfolioInfo.getInAllAssets()) )
                .allAssets( convertFromPbString(portfolioInfo.getAllAssets()) )
                .profitLoss( convertFromPbString(portfolioInfo.getProfitLoss()) )
                .rateChange( convertFromPbString(portfolioInfo.getRateChange()) )
                .limBuy( convertFromPbString(portfolioInfo.getLimBuy()) )
                .limSell( convertFromPbString(portfolioInfo.getLimSell()) )
                .limNonMargin( convertFromPbString(portfolioInfo.getLimNonMargin()) )
                .limBuyAsset( convertFromPbString(portfolioInfo.getLimBuyAsset()) )
                .valShortNet( convertFromPbString(portfolioInfo.getValShortNet()) )
                .valLongNet( convertFromPbString(portfolioInfo.getValLongNet()) )
                .totalMoneyBal( convertFromPbString(portfolioInfo.getTotalMoneyBal()) )
                .totalLockedMoney( convertFromPbString(portfolioInfo.getTotalLockedMoney()) )
                .haircuts( convertFromPbString(portfolioInfo.getHaircuts()) )
                .assetsWithoutHc( convertFromPbString(portfolioInfo.getAssetsWithoutHc()) )
                .statusCoef( convertFromPbString(portfolioInfo.getStatusCoef()) )
                .varMargin( convertFromPbString(portfolioInfo.getVarmargin()) )
                .goForPositions( convertFromPbString(portfolioInfo.getGoForPositions()) )
                .goForOrders( convertFromPbString(portfolioInfo.getGoForOrders()) )
                .rateFutures( convertFromPbString(portfolioInfo.getRateFutures()) )
                .isQualClient( convertFromPbString(portfolioInfo.getIsQualClient()) )
                .isFutures( convertFromPbString(portfolioInfo.getIsFutures()) )
                .currTag( convertFromPbString(portfolioInfo.getCurrTag()) )
                .build();
    }
}
