package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum PortfolioInfoPbSerde implements Serde<PortfolioInfo>, PbConverter<qlua.rpc.GetPortfolioInfo.PortfolioInfo, PortfolioInfo> {

    INSTANCE;

    @Override
    public byte[] serialize(final PortfolioInfo money) {
        return convertToPb(money).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public PortfolioInfo deserialize(final byte[] data) {
        return convertFromPb(qlua.rpc.GetPortfolioInfo.PortfolioInfo.parseFrom(data));
    }

    @Override
    public PortfolioInfo convertFromPb(@NotNull qlua.rpc.GetPortfolioInfo.PortfolioInfo portfolioInfo) {

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

    @Override
    public qlua.rpc.GetPortfolioInfo.PortfolioInfo convertToPb(@NotNull final PortfolioInfo portfolioInfo) {

        return qlua.rpc.GetPortfolioInfo.PortfolioInfo.newBuilder()
                .setIsLeverage( convertToPbString(portfolioInfo.getIsLeverage()) )
                .setInAssets( convertToPbString(portfolioInfo.getInAssets()) )
                .setLeverage( convertToPbString(portfolioInfo.getLeverage()) )
                .setOpenLimit( convertToPbString(portfolioInfo.getOpenLimit()) )
                .setValShort( convertToPbString(portfolioInfo.getValShort()) )
                .setValLong( convertToPbString(portfolioInfo.getValLong()) )
                .setValLongMargin( convertToPbString(portfolioInfo.getValLongMargin()) )
                .setValLongAsset( convertToPbString(portfolioInfo.getValLongAsset()) )
                .setAssets( convertToPbString(portfolioInfo.getAssets()) )
                .setCurLeverage( convertToPbString(portfolioInfo.getCurLeverage()) )
                .setMargin( convertToPbString(portfolioInfo.getMargin()) )
                .setLimAll( convertToPbString(portfolioInfo.getLimAll()) )
                .setAvLimAll( convertToPbString(portfolioInfo.getAvLimAll()) )
                .setLockedBuy( convertToPbString(portfolioInfo.getLockedBuy()) )
                .setLockedBuyMargin( convertToPbString(portfolioInfo.getLockedBuyMargin()) )
                .setLockedBuyAsset( convertToPbString(portfolioInfo.getLockedBuyAsset()) )
                .setLockedSell( convertToPbString(portfolioInfo.getLockedSell()) )
                .setLockedValueCoef( convertToPbString(portfolioInfo.getLockedValueCoef()) )
                .setInAllAssets( convertToPbString(portfolioInfo.getInAllAssets()) )
                .setAllAssets( convertToPbString(portfolioInfo.getAllAssets()) )
                .setProfitLoss( convertToPbString(portfolioInfo.getProfitLoss()) )
                .setRateChange( convertToPbString(portfolioInfo.getRateChange()) )
                .setLimBuy( convertToPbString(portfolioInfo.getLimBuy()) )
                .setLimSell( convertToPbString(portfolioInfo.getLimSell()) )
                .setLimNonMargin( convertToPbString(portfolioInfo.getLimNonMargin()) )
                .setLimBuyAsset( convertToPbString(portfolioInfo.getLimBuyAsset()) )
                .setValShortNet( convertToPbString(portfolioInfo.getValShortNet()) )
                .setValLongNet( convertToPbString(portfolioInfo.getValLongNet()) )
                .setTotalMoneyBal( convertToPbString(portfolioInfo.getTotalMoneyBal()) )
                .setTotalLockedMoney( convertToPbString(portfolioInfo.getTotalLockedMoney()) )
                .setHaircuts( convertToPbString(portfolioInfo.getHaircuts()) )
                .setAssetsWithoutHc( convertToPbString(portfolioInfo.getAssetsWithoutHc()) )
                .setStatusCoef( convertToPbString(portfolioInfo.getStatusCoef()) )
                .setVarmargin( convertToPbString(portfolioInfo.getVarMargin()) )
                .setGoForPositions( convertToPbString(portfolioInfo.getGoForPositions()) )
                .setGoForOrders( convertToPbString(portfolioInfo.getGoForOrders()) )
                .setRateFutures( convertToPbString(portfolioInfo.getRateFutures()) )
                .setIsQualClient( convertToPbString(portfolioInfo.getIsQualClient()) )
                .setIsFutures( convertToPbString(portfolioInfo.getIsFutures()) )
                .setCurrTag( convertToPbString(portfolioInfo.getCurrTag()) )
                .build();
    }
}
